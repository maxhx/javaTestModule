
package com.m.hx.core.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加密算法
 * 
 * @author maihaixian
 * @version 2012-8-2 上午9:19:18
 */
public class DemoForDES {
	public static final String KEY_NAME = "key.obj";
	private static final DemoForDES desDemo = new DemoForDES();

	/**
	 * 实例化
	 * 
	 * @return
	 */
	public static DemoForDES getInstance() {
		return desDemo;
	}

	private DemoForDES() {
		super();
	}

	/**
	 */
	private void createKey() {
		try {
			// �õ���Կ��ʵ�� ��ʲô��ʽ���ܡ����ܵķ�ʽ�Ƚ϶ࡣ
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			kg.init(56);
			SecretKey key = kg.generateKey();
			System.out.println("��ɵ���Կ=========="+key);

			// ����ɵ���Կ����д���ļ���
			URI destFilePath = DemoForDES.getKeyPath();
			System.out.println("==============================="+destFilePath.toString());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(new File(destFilePath)));
			objectOutputStream.writeObject(key);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param pass
	 */
	private void createKey(String pass) {

		// byte byteRawKeyData[] = "&d!t(k)j".getBytes();
		byte byteRawKeyData[] = pass.getBytes();
		// DESKeySpec��ָ��һ�� DES ��Կ��
		DESKeySpec dKeySpec = null;
		/*
		 * SecretKeyFactory ���ʾ������Կ�Ĺ�����
		 * 
		 * ��Կ������������Կ������
		 * Key�Ĳ�͸��������Կ��ת��Ϊ��Կ�淶���ײ���Կ���ϵ�͸����ʾ��ʽ������֮��Ȼ��������Կ����ֻ�����ܣ��Գƣ���Կ���в�����
		 * 
		 * ��Կ����Ϊ˫��ģʽ�����������ݸ���Կ�淶����Կ���ϣ�������͸����Կ���󣬻����ʵ���ʽ��ȡ��Կ����ĵײ���Կ���ϡ�
		 */
		SecretKeyFactory secretKeyFactory;
		try {

			dKeySpec = new DESKeySpec(byteRawKeyData);
			secretKeyFactory = SecretKeyFactory.getInstance("DES");
			// SecretKey���𱣴�Գ���Կ
			SecretKey key = secretKeyFactory.generateSecret(dKeySpec);

			URI destFilePath = DemoForDES.getKeyPath();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(new File(destFilePath)));
			objectOutputStream.writeObject(key);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ���ļ��ж���Key,���ڼ���ʹ�á�
	 * 
     * ��ԿKey�����·����ע��ʹ�ø÷�����ʱ��ȷ�����Ѿ��������Կ��
	 * @return
	 */
	private Key getKey() {
		URI keyFilePath = DemoForDES.getKeyPath();

		Key key = null;
		try {
			// ����ɵ���Կ������ļ��ж�ȡ������Ȼ����ǿ��ת����һ����Կ����
//			ObjectInputStream objectInputStream = new ObjectInputStream(
//					new FileInputStream(new File(keyFilePath)));
//			key = (Key) objectInputStream.readObject();
			ObjectInputStream objectInputStream = new ObjectInputStream(this.getClass().getResourceAsStream(KEY_NAME));
			key = (Key) objectInputStream.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * ��ȡ��Կ�ļ����ڵ�ַ
	 * 
	 * @return
	 */
	private static URI getKeyPath() {

		String absolutePath = new DemoForDES().getClass().getResource("")
				.toString();
		absolutePath = absolutePath + DemoForDES.KEY_NAME;
		URI uri = null;
		try {
			uri = new URL(absolutePath).toURI();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return uri;
	}

	/**
	 * ��������ַ���м��� ����д�˽�����byte����ת�����ַ�ķ�����ֱ���ڵ��þ����ˡ�
	 * 
	 * @param source
	 * @return �Ż�һ��byte���飬Ϊʲô���Ż��ַ�����Ϊ���ܵ�ʱ��Ҫ�������byte������ܽ��н��ܣ������ܵ�ʱ��������ַ�
	 *         ��ô�ͻ���?Ը���Ǳ�������⡣
	 */
	private byte[] encrypt(String source) {
		byte[] target = null;
		try {
			byte[] center = source.getBytes("UTF-8");
			Key key = getKey();
			Cipher cipher = Cipher.getInstance("DES");

			cipher.init(Cipher.ENCRYPT_MODE, key);

			target = cipher.doFinal(center);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return target;
	}

	/**
	 * @param source
	 *            ���ܺ��byte���顣���ü��ܷ���encrypt����String������ɼ���
	 * @return ���ܺ���ַ�
	 * @Description �����㷨��
	 */
	private byte[] decrypt(byte[] source) {
		byte[] dissect = null;
		try {
			Key key = getKey();
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);// ʹ��˽Կ����
			dissect = cipher.doFinal(source);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new RuntimeException("�����ȡ����Կ����ȷ������ϵ����Ա������Կ��");

		}
		return dissect;
	}

	/**
	 * ���ڰѼ��ܺ��byte[]��������ض��ķ�ʽд�뵽�ļ���
	 * 
	 * @param bytes
	 */
	private String encodeByteToBase64String(byte[] bytes) {
		BASE64Encoder base64encoder = new BASE64Encoder();
		// base64encoder.encode(bytes,new FileOutputStream(new
		// File("e:\\t.txt")));
		String targer = base64encoder.encode(bytes);
		return targer;
	}

	/**
	 * ���ڼ���֮ǰ�����˱���ĸ�ʽ �������ڲ����ص�ķ�ʽ������ ��Ȼ��õ���һ��byte[]���ڽ��롣
	 * 
	 * @return
	 */
	private byte[] getByteFromBase64String(String source) {
		BASE64Decoder base64decoder = new BASE64Decoder();
		byte[] encodeByte = null;
		try {
			encodeByte = base64decoder.decodeBuffer(source);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return encodeByte;
	}

	/**
	 * ��ָ�����ֽ�д�뵽�ļ��С�
	 * 
	 * @param b
	 * @param filePath
	 */
	private void writeByteToFile(byte[] b, String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);

			fileOutputStream.write(b);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ܣ��ȸ��DES�����㷨���ܣ�Ȼ��ת��Ϊbase64����
	 * 
	 * @param source
	 * @return
	 */
	public String encryptToString(String source) {
		if (source == null) {
			throw new RuntimeException("���ܵ�Դ��Ϊ�գ�����Դ��");
		}

		byte[] target = this.encrypt(source);
		String result = this.encodeByteToBase64String(target);

		return result;
	}

	/**
	 * ���ܣ������Ľ���Ϊ�ַ�
	 * 
	 * @param source
	 * @return
	 */
	public String decryptToString(String source) {
		if (source == null) {
			throw new RuntimeException("���ܵ�Դ��Ϊ�գ�����Դ��");
		}

		byte[] sourceByte = this.getByteFromBase64String(source);
		byte[] targetByte = this.decrypt(sourceByte);
		String target = new String(targetByte);

		return target;
	}
	
	/**
	 * ������Ԫ�������
	 * @param text
	 */
	private String testEncryptToString(String text){
        String result = this.decryptToString(text);
        return result;
	}
	
	/*public static void main(String[] args){
		DemoForDES test = new DemoForDES();
//		test.createKey("marconimarconimarconimarconimarconimarconimarconimarconi");
////		String encStr = test.encryptToString("xywGDnoc");
////		System.out.println("=======���ܺ�Ľ��======="+encStr);
//		
//		String decStr = test.decryptToString("DGXrIh/Zraw5mQw1Q0t0xw==");
//		System.out.println("=======���ܺ�Ľ��======="+decStr);
//		test.createKey();
        test.testEncryptToString("IL3g3gGzbIdMPHvfV9+BZw==");
	}*/

	/**
	 * ����ʹ�á�
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		DemoForDES encryption = new DemoForDES();
		/*
		// 1�������Կ
		// www.io.encryption.createKey();
		www.io.encryption.createKey("12345678");

		System.out.println("��ɵ���Կ�ǡ�"+www.io.encryption.getKey()+"������ʾ�����Ƕ���");
		// // 2������
		String mingwen = "max";
		byte[] target = www.io.encryption.encrypt(mingwen);

		System.out.println("�����ǡ�"+mingwen+"��,ʹ����Կ���ܺ�����ġ�"+new String(target)+"��");
		// 3�������ĸ�Ϊbase64����
		String result = www.io.encryption.encodeByteToBase64String(target);
		System.out.println("���ľ���Base64���ܺ�" + result+"��");*/

		String result = "2cc51175f6f4d9fd7e58add18756ccbb";
		// 4�������Ĵ�base64ת�����
		byte[] source = encryption.getByteFromBase64String(result);
		System.out.println("���ľ���Base64���ܺ�"+new String(source)+"��");
		// 5�������Կ����
		byte[] target2 = encryption.decrypt(source);
		System.out.println("�����Կ���ܺ�,�õ����ġ�" + new String(target2)+"��");

		System.out.println("===============��ʱ��"+(System.currentTimeMillis()-startTime)+"������");

		// System.out.println(PasswordManager.getPath());

		// PasswordManager www.io.encryption = new PasswordManager();

		// String source = www.io.encryption.encryptToString("1342567");
		// System.out.println(source);
		// Date begin = new Date();
		// for(int i=0; i<100; i++){
		// String source = "RF6D0QvRkys=";
		// String target = www.io.encryption.decryptToString(source);
		// System.out.println(target);
		// }
		// Date end = new Date();
		// System.out.println(end.getTime()-begin.getTime());

		// byte[] source =
		// www.io.encryption.getByteFromBase64String("e10adc3949ba59abbe56e057f20f883e");
		// System.out.println(new String(source));
		// // 5�������Կ����
		// byte[] target2 = www.io.encryption.decrypt(source);
		// System.out.println("���ܺ�" + new String(target2));

	}
}