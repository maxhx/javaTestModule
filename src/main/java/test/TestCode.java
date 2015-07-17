
package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class TestCode {


    @Test
    public void finalTestCase(){
        final Map<String, Object> m = new HashMap<String, Object>();
        m.put("1","AAA");
        m.put("2","BBBB");
        System.out.println(m);
    }


}