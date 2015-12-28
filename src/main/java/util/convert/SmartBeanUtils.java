package util.convert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

/**
 * <b>加强版 BeanUtils反射类</b>
 * 
 * @author Maihx
 *
 */
public class SmartBeanUtils extends BeanUtils {

	/**
	 * 像小天那样单纯地将Map转成一个javaBean
	 * 
	 * @param m
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T map2Bean(Map<String, Object> m, Class<T> t) {
		try {
			if (!CollectionUtils.isEmpty(m) && null != t) {
				String className = t.getName();
				T target = (T) Class.forName(className).newInstance();
//				Field[] fs = target.getClass().getDeclaredFields();
				Field[] fs = null;
				fs = getBeanFields(target.getClass(),fs);
				// 外层循环遍历Map
				for (Entry<String, Object> en : m.entrySet()) {
					// 内层循环遍历"对象"属性
					for (Field f : fs) {
						//////////////////////////////////
						// + 此处将Map内容归并到"对象"中
						//////////////////////////////////
						if (en.getKey().equals(f.getName())) {
							f.setAccessible(true);
							Object nv = en.getValue();
							// TODO 这里待优化
							String fieldType = f.getType().toString().replace("class java.lang.", "");
//							System.out.println("fieldType:"+fieldType);
							switch(fieldType){
								case "Integer": 
									nv = nv==""? 0:Integer.parseInt(String.valueOf(nv));
									break;
								case "Double": 
									nv = nv==""? 0:Double.parseDouble(String.valueOf(nv));
									break;
								default:
									break;
							}
							f.set(target, nv);
						} else {
							// 暂时不处理两者有差异的属性
						}
					}

				}

				return target;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> list2Beans(List ol, Class<T> t) {
		try {
			if (null != ol && ol.size() > 0 && null != t) {
				List<T> tl = new ArrayList<T>();
				for (Object o : ol) {
					if (o instanceof Map) {
						Map<String, Object> m = (Map<String, Object>) o;
						T tt = map2Bean(m, t);
						tl.add(tt);
					}else{
						//暂时不处理了
					}
				}
				return tl;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**取出所有的属性，包含父类属性*/
	public static Field[] getBeanFields(Class cls,Field[] fs){
        fs = (Field[]) ArrayUtils.addAll(fs, cls.getDeclaredFields());
        if(cls.getSuperclass()!=null){
            Class clsSup = cls.getSuperclass();
            fs = getBeanFields(clsSup,fs);
        }
        return fs;
    }

	/*public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Map m = new HashMap();
		m.put("datagridId", "12345");
		map2Bean(m,BaseplamResourcesVO.class);
	}*/
}
