/**
 * Created on 2006-8-20 14:10:22
 */
package com.jivespaces.dao.hibernate3;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jivespaces.dao.CategoryDao;
import com.jivespaces.domain.Category;

/**
 * @author Shutra
 * 
 */
public class Hibernate3CategoryDao extends HibernateDaoSupport implements
		CategoryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.CategoryDao#getCategory(java.lang.String)
	 */
	public Category getCategory(String id) {
		return (Category) getHibernateTemplate().get(Category.class, id);
	}

}
