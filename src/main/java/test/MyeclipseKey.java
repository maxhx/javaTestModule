
package test;

/**   
 * @Title: MyeclipseKey.java 
 * @Package test 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author ����   
 * @date Jun 5, 2013 9:20:38 AM 
 * @version V1.0   
 */


import java.util.Scanner;

/**
 * 
 * MyEclipse(8.0,7.5,7.0,6.5,6.0...)��ע������ɴ���
 * 
 * 
 * 
 * 
 * 
 * @author ShunLi
 * 
 * @Time 2009-12-25
 * 
 */

public class MyeclipseKey

{

	private static final String LL = "Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself.";

	public MyeclipseKey()

	{

	}

	/**
	 * 
	 * �����Subscription Code����㷨
	 * 
	 * 
	 * 
	 * @param userId
	 * 
	 * (Subscriber)
	 * 
	 * @param licenseNum
	 * 
	 * @return Subscription Code
	 * 
	 */

	public String getSerial(String subscriber, String licenseNum)

	{

		java.util.Calendar cal = java.util.Calendar.getInstance();// ��õ�ǰ����

		cal.add(1, 3);// +3��

		cal.add(6, -1);// ��ǰ��-1

		java.text.NumberFormat nf = new java.text.DecimalFormat("000");

		licenseNum = nf.format(Integer.valueOf(licenseNum));// licenseNum��ʽ������λ����

		String verTime = new StringBuilder("-").append(

		new java.text.SimpleDateFormat("yyMMdd").format(cal.getTime()))

		.append("0").toString();// ����

		String type = "YE3MP-";

		String need = new StringBuilder(subscriber.substring(0, 1))

		.append(type).append("300").append(licenseNum).append(verTime)

		.toString();// ����ע����Ϣ

		String dx = new StringBuilder(need).append(LL).append(subscriber)

		.toString();

		int suf = this.decode(dx);// �������ע����Ϣ

		String code = new StringBuilder(need).append(String.valueOf(suf))

		.toString();

		return this.change(code);

	}

	private int decode(String s)

	{

		int i;

		char[] ac;

		int j;

		int k;

		i = 0;

		ac = s.toCharArray();// ��sת��Ϊ�����ַ�����

		j = 0;

		k = ac.length;

		while (j < k)

		{

			i = (31 * i) + ac[j];// �����㷨�������Ϊʲô�����ӣ��п��ܾ��������Ӷ����

			j++;

		}

		System.out.println();

		return Math.abs(i);// ȡ���ֵ

	}

	/**
	 * 
	 * �仯ԭ����
	 * 
	 * �����֣�10����������ĸ�?��Сд��26�����۰�Ե��������໥�ı䣩��Ҳ��
	 * 
	 * 0��5�Ե���0��5��5��0��
	 * 
	 * A��N��a��n�Ե�
	 * 
	 * @param ԭ�ַ�
	 * 
	 * @return �仯����ַ�
	 * 
	 */

	private String change(String s)

	{

		byte[] abyte0;

		char[] ac = null;

		int i;

		int k;

		int j;

		abyte0 = s.getBytes();

		ac = new char[abyte0.length];

		i = 0;

		k = abyte0.length;

		while (i < k)

		{

			j = abyte0[i];

			if ((j >= 48) && (j <= 57))// 0-9,ʵ��01234��56789��Ӧ���໥�Ե���Ҳ��0��5�Ե���1��6�Ե�

			{

				j = (((j - 48) + 5) % 10) + 48;

			} else if ((j >= 65) && (j <= 90))// A-Z

			{

				j = (((j - 65) + 13) % 26) + 65;

			} else if ((j >= 97) && (j <= 122))// a-z

			{

				j = (((j - 97) + 13) % 26) + 97;

			}

			ac[i] = (char) j;

			i++;

		}

		return String.valueOf(ac);

	}

	/**
	 * 
	 * �����������ȵ��ã�����ע����(Subscription Code)
	 * 
	 * 
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args)

	{

		// �������Ļ����һЩ������������

		// �������ģ�һ�������ڹ������õ��ַ��п��ܻ�������룬�ڶ����Ǻ����getBytes�Բ�ͬ���ַ����ֲ�ͬ�Ĵ�����ʽ���µ���������

		// ���Դ��Ҳ��û�а취���������û����ˣ�����и��ֽ���ˣ���֪ͨ�ң�QQ��506817493��E��leeshunli@qq.com����лл

		System.out.print("������ע����û���(��֧������):");

		Scanner scanner = new Scanner(System.in);// ������

		String subscriber = scanner.nextLine();// ����һ���ַ�

		MyeclipseKey myeclipseKeyGen = new MyeclipseKey();// ʵ��

		String subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");// ����Ĳ�����һ���������͵��ַ�,���ַ�ΧΪ0-999

		System.out.println("\n" + "MyEclipseע������ɵĽ������" + "\n");

		System.out.println("Subscriber:" + subscriber);

		System.out.println("Subscription Code:" + subscription_Code);

		/**
		 * 
		 * �������JDK1.5��ǰ��д����JDK1.5�����ϰ汾���뿴�����õ�д��
		 * 
		 */

		/*
		 * 
		 * BufferedReader reader = null; try {
		 * 
		 * System.out.println("������ע����û���(��֧������):"); reader = new
		 * 
		 * BufferedReader(new InputStreamReader(System.in)); String subscriber =
		 * 
		 * null; subscriber = reader.readLine(); System.out.println(subscriber);
		 * 
		 * 
		 * 
		 * MyEclipseKeyGen myeclipseKeyGen = new MyEclipseKeyGen(); String
		 * 
		 * subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");//
		 * 
		 * ����Ĳ�����һ���������͵��ַ�,���ַ�ΧΪ0-999 // System.out.println("ע����ɵĽ������");
		 * 
		 * System.out.println("Subscriber:" + subscriber);
		 * 
		 * System.out.println("Subscription Code:" + subscription_Code);
		 * 
		 * reader.readLine();
		 * 
		 * 
		 *  } catch (IOException ex) { ex.printStackTrace(); } finally { if
		 * 
		 * (reader != null) { try { reader.close(); } catch (IOException e) {
		 * 
		 * e.printStackTrace(); } reader = null; } }
		 * 
		 */

	}

}