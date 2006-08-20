/**
 * Created on 2006-8-20 14:10:54
 */
package com.jivespaces.dao.hibernate3;

import java.util.List;

import com.jivespaces.dao.SpaceDao;
import com.jivespaces.domain.Space;
import com.jivespaces.domain.User;

/**
 * @author Shutra
 * 
 */
public class Hibernate3SpaceDao extends BaseHibernateEntityDao<Space> implements
		SpaceDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.SpaceDao#getSpace(java.lang.String)
	 */
	public Space getSpace(String id) {
		return get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.SpaceDao#getSpaceByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Space getSpaceByName(String name) {
		List<Space> spaces = getHibernateTemplate().find(
				"from Space where name = ?", name);
		if (spaces.isEmpty()) {
			return null;
		} else {
			return spaces.get(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.dao.SpaceDao#getSpaces(com.jivespaces.domain.User)
	 */
	@SuppressWarnings("unchecked")
	public List<Space> getSpaces(User owner) {
		return getHibernateTemplate().find("from Space where owner.id = ?",
				owner.getId());
	}

}
