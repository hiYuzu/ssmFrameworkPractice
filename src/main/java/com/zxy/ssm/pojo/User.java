package com.zxy.ssm.pojo;

import com.zxy.ssm.util.DefaultArgument;
import org.codehaus.jackson.map.Serializers;

/**
 * <p>
 *
 * @author yuzu
 * @Description: UserPojo
 * </p>
 * @date 2018/9/29 13:18
 */

public class User extends BasePojo {
	private Integer userId = DefaultArgument.INT_DEFAULT;
	private String userName;
	private String userSex;
	private Integer userAge = DefaultArgument.INT_DEFAULT;
	private String userTel;
	private String userEmail;
	private String userPwd;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}