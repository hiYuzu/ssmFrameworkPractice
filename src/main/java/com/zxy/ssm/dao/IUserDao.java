package com.zxy.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxy.ssm.pojo.User;

/**
 *<p>
 *@Description: User数据库操作接口
 *</p>
 *@author yuzu
 *@date 2018/10/11 8:25
 */
public interface IUserDao {
	
	/**
	 *<p>
	 *@Description: 查询结果个数
	 *</p>
	 *@author yuzu
	 *@date 2018/10/11 8:28
	 *@param user
	 *@return
	 */
	public int getCount(@Param("user") User user);
	
	/**
	 *<p>
	 *@Description: 查询User数据
	 *</p>
	 *@author yuzu
	 *@date 2018/10/11 8:30
	 *@param user
	 *@return
	 */
	public List<User> getUser(@Param("user") User user);
}