/**
 * Created on 2006-8-20 下午01:57:24
 */
package com.jivespaces.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.jivespaces.domain.Entry;
import com.jivespaces.util.PaginationSupport;

/**
 * @author Shutra
 * 
 */
public interface EntryDao extends BaseDao {
	Entry getEntry(String id);
	
	/**
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public PaginationSupport<Entry> findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize, final int startIndex);
	
}
