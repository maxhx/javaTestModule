package plugins.beanutils;

import java.util.Map;

public class _POJO {
	
	private String attr1;
	private String attr2;
	private Object map3;
	
	
	
	public Object getMap3() {
		return map3;
	}
	public void setMap3(Object map3) {
		this.map3 = map3;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
	
	public class innerClass{
		String attr1;
		String attr2;
		String attr3;
		public String getAttr1() {
			return attr1;
		}
		public void setAttr1(String attr1) {
			this.attr1 = attr1;
		}
		public String getAttr2() {
			return attr2;
		}
		public void setAttr2(String attr2) {
			this.attr2 = attr2;
		}
		public String getAttr3() {
			return attr3;
		}
		public void setAttr3(String attr3) {
			this.attr3 = attr3;
		}
		
		@Override
		public String toString() {
			return String.format("attr1:%s,attr2:%s,attr3:%s", this.attr1,this.attr2,this.attr3);
		}
		
	}


	@Override
	public String toString() {
		return String.format("attr1:%s,attr2:%s,map3:%s", this.attr1,this.attr2,this.map3);
	}
	
	

}
