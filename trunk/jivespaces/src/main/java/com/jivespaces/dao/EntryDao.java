/**
 * Created on 2006-8-20 下午01:57:24
 */
package com.jivespaces.dao;

import java.io.Serializable;

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
	
	/**
	 * 保存Entry
	 * @param entry
	 * @return entry's Id
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public Serializable saveEntry(Entry entry);
	
	/**
	 * 删除Entry
	 * @param entry
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public void removeEntry(Entry entry);
}
