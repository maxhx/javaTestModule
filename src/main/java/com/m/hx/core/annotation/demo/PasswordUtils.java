package com.m.hx.core.annotation.demo;

/** 
* @ClassName: PasswordUtils 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author maihx
* 创建时间 2017年4月23日 下午5:09:20 
*  
*/
public class PasswordUtils {
	
	@UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

}
