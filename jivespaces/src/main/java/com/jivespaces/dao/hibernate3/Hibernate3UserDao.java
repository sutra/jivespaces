/**
 * Created on 2006-8-20 下午02:11:15
 */
package com.jivespaces.dao.hibernate3;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jivespaces.dao.UserDao;
import com.jivespaces.domain.User;

/**
 * @author Shutra
 * 
 */
public class Hibernate3UserDao extends HibernateDaoSupport implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.UserDao#getUser(java.lang.String)
	 */
	public User getUser(String id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.UserDao#getUserByOpenId(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public User getUserByOpenId(String openId) {
		List<User> users = getHibernateTemplate().find(
				"from User where openId = ?", openId);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
