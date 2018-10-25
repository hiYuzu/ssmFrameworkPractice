package com.zxy.ssm.pojo;

/**
 * <p>
 *
 * @author yuzu
 * @Description: UserPojo
 * </p>
 * @date 2018/9/29 13:18
 */

public class User {
	private int userId;
	private String userName;
	private String userSex;
	private int userAge;
	private String userTel;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
}