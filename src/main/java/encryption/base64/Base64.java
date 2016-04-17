
package encryption.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base64 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
//		String code = decode("MTIzNDU2QWI=");
//		System.out.print(code);
		
		String code = encode("123456Ab@()");
//		System.out.println(code);
		System.out.println(decode("MTIzNDU2QWIh"));
	}
	
	/**Base64解密方法*/
    public static String decode(String str) {
        try {
            BASE64Decoder decode = new BASE64Decoder();
            byte[] bytes = decode.decodeBuffer(str);
            return new String(bytes);
        }
        catch (Exception e) {
            //throw new GsExp();
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * Base64加密方法
     * @param str
     * @return
     */
    public static String encode(String str) {
        try {
            String encode = new BASE64Encoder().encode(str.getBytes());
            return encode;
        }
        catch (Exception e) {
            //throw new GsExp();
            e.printStackTrace();
            return "";
        }
    }
    
    /**MD5加密方法
     * @param message
     * @return
     * @throws java.security.NoSuchAlgorithmException
     */
    public static String encrypt(String message) throws NoSuchAlgorithmException{
    	 if (message == null) {
             message = "";
         }

         MessageDigest md = MessageDigest.getInstance("MD5");
         byte[] bts = md.digest(message.getBytes());
         // BASE64
         BASE64Encoder base64Encoder = new BASE64Encoder();
         return base64Encoder.encode(bts);
    }
}