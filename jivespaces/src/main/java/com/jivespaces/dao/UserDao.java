/**
 * Created on 2006-8-20 下午01:56:54
 */
package com.jivespaces.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.jivespaces.domain.User;
import com.jivespaces.util.PaginationSupport;

/**
 * @author Shutra
 * 
 */
public interface UserDao  extends BaseDao{
	User getUser(String id);

	User getUserByOpenId(String openId);
	
	/**
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public PaginationSupport<User> findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize, final int startIndex);
}
