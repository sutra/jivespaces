/**
 * Created on 2006-8-20 下午02:10:42
 */
package com.jivespaces.dao.hibernate3;

import java.io.Serializable;

import com.jivespaces.dao.EntryDao;
import com.jivespaces.domain.Entry;

/**
 * @author Shutra
 * 
 */
public class Hibernate3EntryDao extends BaseHibernateEntityDao<Entry> implements
		EntryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.EntryDao#getEntry(java.lang.String)
	 */
	public Entry getEntry(String id) {
		return get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jivespaces.dao.EntryDao#saveEntry(com.jivespaces.domain.Entry)
	 */
	public Serializable saveEntry(Entry entry) {
		getHibernateTemplate().saveOrUpdate(entry);
		return entry.getId();
	}
}
