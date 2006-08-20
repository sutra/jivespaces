/**
 * Created on 2006-8-20 下午09:27:57
 */
package com.jivespaces.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Shutra
 * @see http://www.blogjava.net/calvin/archive/2006/04/28/43830.html
 */
public abstract class BaseHibernateEntityDao<T> extends HibernateDaoSupport {
	private Class<T> entityClass;

	public BaseHibernateEntityDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		T o = (T) getHibernateTemplate().get(entityClass, id);
		return o;
	}
}
