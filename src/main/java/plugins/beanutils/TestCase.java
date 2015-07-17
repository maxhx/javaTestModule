package plugins.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;

public class TestCase {

	@Test
	public void ts1() throws Exception {
		_POJO p = new _POJO();
		BeanUtils.setProperty(p, "attr1", "isGood");
		System.out.println(BeanUtils.getProperty(p, "attr1"));

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
		m.put("attr3", "vvvv");
		
		_POJO.innerClass ic = new _POJO().new innerClass();

		BeanUtils.populate(ic , m);
		
		System.out.println(ic.attr1);
	}

}
