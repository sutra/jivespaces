/**
 * Created on 2006-8-20 下午01:57:16
 */
package com.jivespaces.dao;

import java.util.List;

import com.jivespaces.domain.Space;
import com.jivespaces.domain.User;

/**
 * @author Shutra
 * 
 */
public interface SpaceDao extends BaseDao{
	Space getSpace(String id);

	Space getSpaceByName(String name);

	List<Space> getSpaces(User owner);
}
