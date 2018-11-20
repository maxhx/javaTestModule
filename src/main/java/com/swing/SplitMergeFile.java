package com.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <b>分割合并文件</b> <br/>
 * copy from <br/>
 * http://outofmemory.cn/code-snippet/37657/fenge-hebing-file-tuxinghua-
 * component
 * 
 * @author MAIHX
 *
 */
public class SplitMergeFile implements ActionListener {

	JFrame jf = new JFrame("分割合并文件");
	private static final long KB = 1024L;
	private static final long MB = 1024L * KB;
	private static final long GB = 1024L * MB;
	private final int BASESIZE = 1024 * 1024;
	private int blocknu = 0;// 文件夹分块
	private JButton[] jb;// 按钮
	private String[] sjb = { "打开文件", "分割", "合并" };
	private JTextField filepath = new JTextField(18);// 输入文件框
	private JLabel label_file = new JLabel("选择文件");
	private JPanel jp1 = new JPanel();// 对文件的处理对话框架
	private JLabel label_size = new JLabel("MB");
	private JTextField jt_size = new JTextField("输入文件分割大小", 10);
	private JPanel jp2 = new JPanel();
	private JTextArea jta = new JTextArea("说明:分割后会生成.RE文件,合并时找到" + ".RE文件并选定,\n把所有的分割文件放到与.RE同目录下进行合并!");
	private String dividepath = "";// 分割文件的路径
	private String filename = "";// 分割文件的名字
	private String directpath = "";// 直接路径不含有文件名
	private int dividesize = 1;// 默认分为一M
	private long filesize = 0L;// 文件大小

	private JMenuBar mb = new JMenuBar();// 对菜单进行设置
	private JMenu jm = new JMenu("帮助");

	public SplitMergeFile() {
		jf.setSize(380, 180);
		jf.setLocation(300, 250);
		jf.setLayout(new GridLayout(3, 1));// 框架的布局
		jb = new JButton[sjb.length];// 按钮
		for (int i = 0; i < sjb.length; i++) {
			jb[i] = new JButton(sjb[i]);
			jb[i].addActionListener(this);
		}
		jp1.setLayout(new FlowLayout());// 用Panel装入文件的选项
		jp1.add(label_file);
		jp1.add(filepath);// 加入文件选择框
		jp1.add(jb[0]);
		jf.add(jp1);// 把第一个Panel加入到Frame中

		jp2.setLayout(new FlowLayout());// 分割选项的Panel
		jp2.add(jt_size);
		jp2.add(label_size);
		jp2.add(jb[1]);// 加入分割按钮
		jp2.add(jb[2]);// 加入合并按钮
		jf.add(jp2);// 加入Panel2

		jf.add(jta);
		mb.add(jm);
		jf.setJMenuBar(mb);// 加入菜单
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}

	/************** 文件分割 *********************/
	public void divideFile(String path) throws IOException {
		File f = new File(path);// 判断文件是否存在
		if (jt_size.getText().trim().equals(""))
			JOptionPane.showMessageDialog(jf, "没有输入分割大小!");
		else if (isNumeric(jt_size.getText())) {
			dividesize = Integer.parseInt(jt_size.getText());// 得到分割大小
			System.out.println(f.length());
			if (dividesize > 0 && dividesize <= f.length() / 1024 / 1024) {
				int size = dividesize * BASESIZE;// 1M=1024*1024B
				if (f.isFile()) {
					FileInputStream targetfile = new FileInputStream(path);// 得到指定文件输入流
					FileChannel targetchannel = targetfile.getChannel();// 得到输入流文件通道
					filesize = targetchannel.size();// 得到文件的大小
					if ((filesize % size) == 0)
						blocknu = (int) filesize / size;
					else
						blocknu = (int) filesize / size + 1;// 分割块数
					Properties p = new Properties();// 持久属性集
					p.setProperty("FileName", filename);// 写入到文件中的文件名
					p.setProperty("Block", blocknu + "");
					FileOutputStream restore_point = new FileOutputStream(dividepath + ".RE");
					p.store(restore_point, "还原数据点");// 建立还原数据
					restore_point.close();
					FileOutputStream[] newfile = new FileOutputStream[blocknu];// 生成新的文件块
					FileChannel[] newfilechannel = new FileChannel[blocknu];// 生成新的文件通道
					for (int i = 0; i < blocknu; i++) {
						newfile[i] = new FileOutputStream(dividepath + i + "");// 生成新的文件
						newfilechannel[i] = newfile[i].getChannel();// 生成新的文件通道
						if (i < blocknu - 1)
							targetchannel.transferTo(size * i, size, newfilechannel[i]);
						else
							targetchannel.transferTo(size * i, filesize - size * i, newfilechannel[i]);
					}
					for (int i = 0; i < blocknu; i++) {
						newfile[i].close();
						newfilechannel[i].close();
					}
					targetfile.close();
					targetchannel.close();
					String result = "成功分割" + filename + "为" + blocknu + "块";
					jta.setText(result);
				} else
					JOptionPane.showMessageDialog(jf, "文件不存在!");
			} else
				JOptionPane.showMessageDialog(jf, "分割块大小必须为正并小于文件长度!");
		} else
			JOptionPane.showMessageDialog(jf, "分割块大小必须为整数!");
	}

	/*************
	 * 文件合并*****************
	 * 
	 * @throws IOException
	 */
	public void uniteFile(String path) throws IOException {
		Properties p = new Properties();// 持久属性集
		File delref = new File(path);
		FileInputStream restore_file = new FileInputStream(delref);// 得到还原文件
		p.load(restore_file);
		String p_filename = p.getProperty("FileName");
		String p_fileblock = p.getProperty("Block");
		int p_block = Integer.parseInt(p_fileblock);// 得到块数
		FileOutputStream fos = new FileOutputStream((directpath + "/" + p_filename).replace('/', File.separatorChar));
		// 输出文件
		FileChannel fosch = fos.getChannel();
		FileInputStream[] fis = new FileInputStream[p_block];// 得到要提取的文件
		FileChannel[] fch = new FileChannel[p_block];
		File[] delf = new File[p_block];// 要删除的文件
		for (int i = 0; i < p_block; i++) {
			fis[i] = new FileInputStream((directpath + "/" + p_filename + i).replace('/', File.separatorChar));// 得到文件
			fch[i] = fis[i].getChannel();// 得到文件通道
			fch[i].transferTo(0, fch[i].size(), fosch);// 放入到fosch中
			delf[i] = new File((directpath + "/" + p_filename + i).replace('/', File.separatorChar));

		}
		for (int i = 0; i < p_block; i++) {
			fch[i].close();
			fis[i].close();
			System.out.println(delf[i].delete());// 删除源文件
		}
		fos.close();
		fosch.close();
		restore_file.close();
		System.out.print(delref.delete());
		String result = "成功合并" + p_filename + "文件" + "\n并保存到了:" + directpath;
		jta.setText(result);

	}

	/************* 监听器 ******************/
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();// 得到按钮的消息
		if (comm.equals("打开文件")) {
			JFileChooser jfc = new JFileChooser();// 打开文件夹
			jfc.setSize(300, 250);
			int returnVal = jfc.showOpenDialog(jf);// 设置文件夹为打开文件夹
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				filename = jfc.getSelectedFile().getName();// 得到文件名
				directpath = jfc.getCurrentDirectory().getAbsolutePath();
				dividepath = directpath + "/" + filename;
				dividepath.replace('/', File.separatorChar);
				// 为了跨平台更换文件的分隔符
				filepath.setText(dividepath);// 显示在文件框中
			}
			jfc.setVisible(true);
			FileInputStream targetfile;
			try {
				targetfile = new FileInputStream(dividepath);
				FileChannel targetchannel = targetfile.getChannel();// 得到输入流文件通道
				try {
					filesize = targetchannel.size();
				} catch (IOException e1) {
					// TODO 自动生成 catch 块
					e1.printStackTrace();
				} // 得到文件的大小
			} catch (FileNotFoundException e1) {
				// TODO 自动生成 catch 块
				e1.printStackTrace();
			} // 得到指定文件输入流
			String showsize = "0 Bytes";
			if (filesize >= GB)
				showsize = String.valueOf((float) filesize / GB) + " GB";
			else if (filesize >= MB)
				showsize = String.valueOf((float) filesize / MB) + " MB";
			else if (filesize >= KB)
				showsize = String.valueOf((float) filesize / KB) + " KB";
			else if (filesize > 1)
				showsize = String.valueOf(filesize) + " Bytes";
			else
				showsize = "1 Byte";
			String fileinfor = "文件路径:" + dividepath + "\n文件大小" + showsize;
			jta.setText(fileinfor);
		} else if (comm.equals("分割")) {
			dividepath = filepath.getText();
			try {
				divideFile(dividepath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else if (comm.equals("合并")) {
			try {
				uniteFile(filepath.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new SplitMergeFile();
	}

}
