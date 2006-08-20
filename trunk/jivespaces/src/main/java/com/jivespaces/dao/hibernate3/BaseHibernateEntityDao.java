/**
 * Created on 2006-8-20 21:27:57
 */
package com.jivespaces.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.jivespaces.dao.BaseDao;
import com.jivespaces.util.HibernateUtils;
import com.jivespaces.util.PaginationSupport;

/**
 * @author Shutra
 * @see <a
 *      href="http://www.blogjava.net/calvin/archive/2006/04/28/43830.html">Java5泛型的用法，T.class的获取和为擦拭法站台</a>
 */
public abstract class BaseHibernateEntityDao<T> extends HibernateDaoSupport implements BaseDao{
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
	
	public PaginationSupport findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		return HibernateUtils.findByCriteria(getHibernateTemplate(), detachedCriteria,
				startIndex, pageSize);
	}
	
}
