/**
 * Created on 2006-8-20 下午02:02:19
 */
package com.jivespaces;

import java.util.List;

import com.jivespaces.dao.CategoryDao;
import com.jivespaces.dao.EntryDao;
import com.jivespaces.dao.SpaceDao;
import com.jivespaces.dao.UserDao;
import com.jivespaces.domain.Category;
import com.jivespaces.domain.Entry;
import com.jivespaces.domain.Space;
import com.jivespaces.domain.User;

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
}
