package core.case5;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ExecCommand {

	private static final Log log = LogFactory.getLog(ExecCommand.class);

	/**
	 * @param command
	 * @throws IOException
	 */
	public void exec(String command) throws IOException {
		exec(command, null, null);
	}

	/**
	 * @param command
	 * @param workpath
	 * @throws IOException
	 */
	public void exec(String command, String workpath) throws IOException {
		exec(command, null, workpath);
	}

	/**
	 * @param command
	 * @param envp
	 * @param workpath
	 * @throws IOException
	 */
	public void exec(String command, String[] envp, String workpath) throws IOException {
		InputStream is = null;
		BufferedInputStream in = null;
		BufferedReader br = null;
		try {
			File dir = null;
			if (null != workpath)
				dir = new File(workpath);
			log.info("【COMMAND】>>> " + command);
			// InputStream is = Runtime.getRuntime().exec(new
			// String[]{"ping","127.0.0.1"}).getInputStream();
			is = Runtime.getRuntime().exec(command, envp, dir).getInputStream();
			in = new BufferedInputStream(is);
			br = new BufferedReader(new InputStreamReader(in));
			String ss = "";
			while ((ss = br.readLine()) != null) {
				lineHandler(ss);
			}
		} finally {
			if (null != br)
				br.close();
			if (null != in)
				in.close();
			if (null != is)
				is.close();
		}
	}

	/**
	 * @param commands
	 * @throws IOException
	 */
	public void exec(String[] commands) throws IOException {
		exec(commands, null, null);
	}

	/**
	 * @param commands
	 * @param workpath
	 * @throws IOException
	 */
	public void exec(String[] commands, String workpath) throws IOException {
		exec(commands, null, workpath);
	}

	/**
	 * @param commands
	 * @param envp
	 * @param workpath
	 * @throws IOException
	 */
	public void exec(String[] commands, String[] envp, String workpath) throws IOException {
		InputStream is = null;
		BufferedInputStream in = null;
		BufferedReader br = null;
		try {
			File dir = null;
			if (null != workpath)
				dir = new File(workpath);
			log.info("【COMMAND】>>>：" + getCommandString(commands));
			is = Runtime.getRuntime().exec(commands, envp, dir).getInputStream();
			in = new BufferedInputStream(is);
			br = new BufferedReader(new InputStreamReader(in));
			String ss = "";
			while ((ss = br.readLine()) != null) {
				lineHandler(ss);
			}
		} finally {
			if (null != br)
				br.close();
			if (null != in)
				in.close();
			if (null != is)
				is.close();
		}
	}

	/**
	 * @param commands
	 * @return
	 */
	private String getCommandString(String[] commands) {
		StringBuffer sb = new StringBuffer();
		for (String command : commands) {
			sb.append(command);
			sb.append(" ");
		}
		return sb.toString();
	}

	protected abstract void lineHandler(String lineStr);
}
