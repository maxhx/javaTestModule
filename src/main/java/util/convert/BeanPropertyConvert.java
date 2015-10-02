package util.convert;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * 
 * @author MAIHX
 *
 */
public class BeanPropertyConvert {
	
	public <T> void invoke(T org,String org_attr,T tar,String tar_attr){
		try {
			Object obj = BeanUtils.getProperty(org, org_attr);
			PropertyUtils.setProperty(tar, tar_attr, obj);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public <T> void invoke(T org,String org_attr,T tar,String tar_attr,CallRunable cr){
		
	}
	
	interface CallRunable{
		void call();
	}
}
