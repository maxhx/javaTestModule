package plugins.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

public class TestCase {

	@Test
	public void ts1() throws Exception {
		_POJO p = new _POJO();
		BeanUtils.setProperty(p, "attr1", new CallRunnable<String>() {
			public String invoke() {
				// TODO Auto-generated method stub
				return "Abc";
			}
		}.invoke());
		BeanUtils.setProperty(p, "map3", new CallRunnable<Object>() {
			
			@SuppressWarnings("rawtypes")
			public Map invoke() {
				Map m = new HashMap();
				m.put("tfboy", "淘粪");
				return m;
			}
		}.invoke());
		System.out.println(p);
		System.out.println(BeanUtils.getProperty(p, "attr1").toString());
		System.out.println(PropertyUtils.getProperty(p, "map3"));
//		Map m = (Map) p.getMap3();
		String p1 = p.getAttr1();
		System.out.println(p1.getClass());

	}

	@Test
	public void ts2() throws Exception {

		final String key = "5";

		ConvertUtils.register(new Converter() {

			public <T> T convert(Class<T> type, Object value) {
				_POJO.innerClass ic = new _POJO().new innerClass();

				if (value == key) {

				}
				System.out.println(value);

				return null;
			}
		}, _POJO.innerClass.class);
	}

	@Test
	public void ts3() throws Exception {
		Map m = new HashMap();
		m.put("attr1", "val1");
		m.put("attr2", "val2");
		m.put("attr3", "vvvv");

		System.out.println(
				BeanUtilsBean2.getInstance().getConvertUtils().convert(m, _POJO.class));
		
		System.out.println(ConvertUtils.convert(m));
		System.out.println(ConvertUtils.convert(m, _POJO.innerClass.class));

	}
	
	
	@Test
	public void ts4() throws Exception {
		Map m = new HashMap();
		m.put("attr1", "val1");
		m.put("attr2", "val2");
		m.put("attrs3", "vvvv");
		
		_POJO.innerClass ic = new _POJO().new innerClass();

		BeanUtils.populate(ic , m);
		
		System.out.println(ic);
	}

	
	interface CallRunnable<T>{
		
		T invoke();
	}
	
}
