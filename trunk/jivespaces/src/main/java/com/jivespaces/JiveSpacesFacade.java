/**
 * Created on 2006-8-20 13:20:44
 */
package com.jivespaces;

import java.util.List;

import com.jivespaces.domain.Category;
import com.jivespaces.domain.Entry;
import com.jivespaces.domain.Space;
import com.jivespaces.domain.User;

/**
 * @author Shutra
 * 
 */
public interface JiveSpacesFacade {
	User getUser(String id);

	User getUserByOpenId(String openId);

	Space getSpace(String id);

	Space getSpaceByName(String name);

	List<Space> getSpaces(User owner);

	Entry getEntry(String id);

	Category getCategory(String id);
}
