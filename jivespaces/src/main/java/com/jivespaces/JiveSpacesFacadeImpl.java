/**
 * Created on 2006-8-20 下午02:02:19
 */
package com.jivespaces;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import com.jivespaces.dao.CategoryDao;
import com.jivespaces.dao.EntryDao;
import com.jivespaces.dao.SpaceDao;
import com.jivespaces.dao.UserDao;
import com.jivespaces.domain.Category;
import com.jivespaces.domain.Entry;
import com.jivespaces.domain.Space;
import com.jivespaces.domain.Tag;
import com.jivespaces.domain.User;
import com.jivespaces.util.PaginationSupport;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Shutra</a>
 * 
 */
public class JiveSpacesFacadeImpl implements JiveSpacesFacade {
	private CategoryDao categoryDao;

	private EntryDao entryDao;

	private SpaceDao spaceDao;

	private UserDao userDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}

	public void setSpaceDao(SpaceDao spaceDao) {
		this.spaceDao = spaceDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getCategory(java.lang.String)
	 */
	public Category getCategory(String id) {
		return this.categoryDao.getCategory(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getEntry(java.lang.String)
	 */
	public Entry getEntry(String id) {
		return this.entryDao.getEntry(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getSpace(java.lang.String)
	 */
	public Space getSpace(String id) {
		return this.spaceDao.getSpace(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getSpaceByName(java.lang.String)
	 */
	public Space getSpaceByName(String name) {
		return this.spaceDao.getSpaceByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getSpaces(com.jivespaces.domain.User)
	 */
	public List<Space> getSpaces(User owner) {
		return this.spaceDao.getSpaces(owner);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getUser(java.lang.String)
	 */
	public User getUser(String id) {
		return this.userDao.getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.JiveSpacesFacade#getUserByOpenId(java.lang.String)
	 */
	public User getUserByOpenId(String openId) {
		return this.userDao.getUserByOpenId(openId);
	}
	

	/* (non-Javadoc)
	 * @see com.jivespaces.JiveSpacesFacade#getUserPage(com.jivespaces.domain.User, int, int, java.lang.String, java.lang.Boolean)
	 */
	public PaginationSupport<User> getUserPage(User user, int pageSize, int startIndex, String order, Boolean isDesc) {
		Assert.notNull(user, "search is required");
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		if (StringUtils.isNotBlank(user.getDisplayName())) {
			criteria.add(Restrictions.eq("displayName", user.getDisplayName()));
		}
		if (StringUtils.isNotBlank(order) && isDesc!=null && isDesc) {
			criteria.addOrder(Order.desc(order));
		} else if (StringUtils.isNotBlank(order)) {
			criteria.addOrder(Order.asc(order));
		}
		return this.userDao.findPageByCriteria(criteria, pageSize, startIndex);
	}
	
	/* (non-Javadoc)
	 * @see com.jivespaces.JiveSpacesFacade#getEntryPage(com.jivespaces.domain.Entry, int, int, java.lang.String, java.lang.Boolean)
	 */
	public PaginationSupport<Entry> getEntryPage(Entry entry, int pageSize, int startIndex, String order, Boolean isDesc) {
		Assert.notNull(entry, "search is required!");
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		if (StringUtils.isNotBlank(entry.getTitle())) {
			criteria.add(Restrictions.ilike("title", entry.getTitle(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(entry.getExcerpt())) {
			criteria.add(Restrictions.eq("excerpt", entry.getExcerpt()));
		}
		if (StringUtils.isNotBlank(entry.getContent())) {
			criteria.add(Restrictions.ilike("content", entry.getContent(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(order) && isDesc!=null && isDesc) {
			criteria.addOrder(Order.desc(order));
		} else if (StringUtils.isNotBlank(order)) {
			criteria.addOrder(Order.asc(order));
		}
		return this.entryDao.findPageByCriteria(criteria, pageSize, startIndex);
	}
	
	/* (non-Javadoc)
	 * @see com.jivespaces.JiveSpacesFacade#getEntryPageByTag(com.jivespaces.domain.Tag, int, int, java.lang.String, java.lang.Boolean)
	 */
	public PaginationSupport<Entry> getEntryPageByTag(Tag tag, int pageSize, int startIndex, String order, Boolean isDesc) {
		Assert.notNull(tag, "tag is required!");
		Assert.notNull(tag.getName(), "tag's name is required!");
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		criteria.createCriteria("tags").add(Restrictions.eq("name", tag.getName()));
		if (StringUtils.isNotBlank(order) && isDesc!=null && isDesc) {
			criteria.addOrder(Order.desc(order));
		} else if (StringUtils.isNotBlank(order)) {
			criteria.addOrder(Order.asc(order));
		}
		return this.entryDao.findPageByCriteria(criteria, pageSize, startIndex);
	}
	
	/* (non-Javadoc)
	 * @see com.jivespaces.JiveSpacesFacade#getEntryPageByCategory(com.jivespaces.domain.Category, int, int, java.lang.String, java.lang.Boolean)
	 */
	public PaginationSupport<Entry> getEntryPageByCategory(Category category, int pageSize, int startIndex, String order, Boolean isDesc) {
		Assert.notNull(category, "category is required!");
		Assert.notNull(category.getName(), "category's name is required!");
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		criteria.createCriteria("categories", "category").add(Restrictions.eq("name", category.getName()));
		if (StringUtils.isNotBlank(order) && isDesc!=null && isDesc) {
			criteria.addOrder(Order.desc(order));
		} else if (StringUtils.isNotBlank(order)) {
			criteria.addOrder(Order.asc(order));
		}
		return this.entryDao.findPageByCriteria(criteria, pageSize, startIndex);
	}
}
