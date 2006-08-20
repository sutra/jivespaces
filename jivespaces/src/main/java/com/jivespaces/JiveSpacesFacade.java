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
 * @author <a
 *         href="mailto:zhoushuqun@gmail.com?subject=com.jivespaces.JiveSpacesFacade">Shutra</a>
 * 
 */
public interface JiveSpacesFacade {
	/**
	 * 获取指定 ID 的用户信息。
	 * 
	 * @param id
	 * @return
	 */
	User getUser(String id);

	/**
	 * 获取指定 OpenID 的用户信息。
	 * 
	 * @param openId
	 * @return
	 * @see <a href="http://openid.net/">OpenID</a>
	 */
	User getUserByOpenId(String openId);

	/**
	 * 获取指定空间 ID 的空间信息。
	 * 
	 * @param id
	 * @return
	 */
	Space getSpace(String id);

	/**
	 * 获取指定空间名的空间信息。
	 * 
	 * @param name
	 * @return
	 */
	Space getSpaceByName(String name);

	/**
	 * 获取指定所有者的所有空间。
	 * 
	 * @param owner
	 * @return
	 */
	List<Space> getSpaces(User owner);

	/**
	 * 获取指定 ID 的日志。
	 * 
	 * @param id
	 * @return
	 */
	Entry getEntry(String id);

	/**
	 * 获取指定 ID 的分类。
	 * 
	 * @param id
	 * @return
	 */
	Category getCategory(String id);
}
