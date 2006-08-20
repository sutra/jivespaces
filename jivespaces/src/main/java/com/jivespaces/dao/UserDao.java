/**
 * Created on 2006-8-20 下午01:56:54
 */
package com.jivespaces.dao;

import com.jivespaces.domain.User;

/**
 * @author Shutra
 * 
 */
public interface UserDao {
	User getUser(String id);

	User getUserByOpenId(String openId);
}
