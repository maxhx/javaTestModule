package test.interview.bms;

/**
 * Created by Mhx on 15-6-12.
 */
public class Case {

    private class innerClass{

        public innerClass(){
        }
    }

    public Case(){
        innerClass in = new innerClass();
        System.out.println("innerClass create..");
    }

    public static void main(String[] args) {
        Case c = new Case();
        System.out.println("Case create.");
    }
}
