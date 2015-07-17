package test.interview.bms;

/**
 * Created by Mhx on 15-6-13.
 */
public class Case1 {

    /**
     * 字符串逆序
     */
    public static String doReserve(String inp) {
        if (inp != null && inp.length() > 0) {
            char[] cs = new char[inp.length()];
            for (int i = inp.length() - 1; i >= 0; i--) {
                cs[inp.length() - i - 1] = inp.charAt(i);
            }
            return String.valueOf(cs);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.printf(doReserve("abcde"));
    }
}
