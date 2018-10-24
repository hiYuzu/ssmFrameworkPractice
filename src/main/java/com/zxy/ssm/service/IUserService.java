package com.zxy.ssm.service;

import java.util.List;
import com.zxy.ssm.pojo.User;

/**
 *<p>
 *@Description: User操作服务类接口
 *</p>
 *@author yuzu
 *@date 2018/9/29 16:08
 */
 
public interface IUserService {
	
	/**
	 *<p>
	 *@Description: 查询结果个数
	 *</p>
	 *@author yuzu
	 *@date 2018/9/29 13:09
	 *@param user
	 *@return
	 */
	int getCount(User user);
	 
	/**
	 *<p>
	 *@Description: 查询user数据
	 *</p>
	 *@author yuzu
	 *@date 2018/9/29 13:10
	 *@param user
	 *@return
	 */
	 List<User> getUsers(User user);
}