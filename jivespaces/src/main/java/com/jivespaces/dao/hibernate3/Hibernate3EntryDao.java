/**
 * Created on 2006-8-20 下午02:10:42
 */
package com.jivespaces.dao.hibernate3;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import com.jivespaces.dao.EntryDao;
import com.jivespaces.domain.Entry;
import com.jivespaces.util.PaginationSupport;

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
	 * @see com.jivespaces.dao.EntryDao#getEntryList(com.jivespaces.domain.Entry, int, int)
	 */
	public PaginationSupport getEntryList(Entry entry, int pageSize, int startIndex) {
		Assert.notNull(entry, "Search is required!");
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		if (StringUtils.isNotBlank(entry.getTitle())) {
			criteria.add(Restrictions.ilike("title", entry.getTitle(), MatchMode.ANYWHERE));
		}
		return findPageByCriteria(criteria, pageSize, startIndex);
	}
	
	/* (non-Javadoc)
	 * @see com.jivespaces.dao.EntryDao#getEntryListByTag(java.lang.String, int, int)
	 */
	public PaginationSupport getEntryListByTag(String tagName, int pageSize, int startIndex) {
		Assert.notNull(tagName, "search is required");
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		criteria.addOrder(Order.desc(""));
		criteria.createCriteria("tags").add(Restrictions.eq("name", tagName));
		return findPageByCriteria(criteria, pageSize, startIndex);
	}
}
