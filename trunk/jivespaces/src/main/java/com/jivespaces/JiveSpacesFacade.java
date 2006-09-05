/**
 * Created on 2006-8-20 13:20:44
 */
package com.jivespaces;

import java.util.List;

import com.jivespaces.domain.Category;
import com.jivespaces.domain.Entry;
import com.jivespaces.domain.Space;
import com.jivespaces.domain.Tag;
import com.jivespaces.domain.User;
import com.jivespaces.util.PaginationSupport;

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
	
	/**
	 * 保存Entry
	 * @param entry
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public void saveEntry(Entry entry);
	
	/**
	 * 删除Entry
	 * @param id
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public void removeEntry(String id);
	
	/**
	 * 根据条件分页查询用户
	 * @param user　查询条件
	 * @param pageSize　分页大小
	 * @param startIndex　开始位置
	 * @param order 排序的字段
	 * @param isDesc 是否倒排
	 * @return 分页工具类
	 * @see {@link PaginationSupport}
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport<User> getUserPage(User user, int pageSize, int startIndex, String order, Boolean isDesc);
	
	/**
	 * 根据条件分页查询Entry
	 * <p>
	 *  <ul>
	 *   <li>模糊查询标题(title) ilike</li>
	 *   <li>精确查询(excerpt) eq</li>
	 *   <li>模糊查询内容(content) ilike</li>
	 *  </ul>
	 * </p>
	 * @param entry 查询条件
	 * @param pageSize　分页大小
	 * @param startIndex　开始位置
	 * @param order　排序的字段
	 * @param isDesc 是否倒排
	 * @return 分页工具类
	 * @see {@link PaginationSupport}
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport<Entry> getEntryPage(Entry entry, int pageSize, int startIndex, String order, Boolean isDesc);
	
	/**
	 * 根据tagName分页查询Entry
	 * @param tag Tag
	 * @param pageSize 分页大小
	 * @param startIndex　开始位置
	 * @param order　排序的字段
	 * @param isDesc　是否倒排
	 * @return　分页工具类
	 * @see {@link PaginationSupport}
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport<Entry> getEntryPageByTag(Tag tag, int pageSize, int startIndex, String order, Boolean isDesc);
	
	/**
	 * 根据categoryName分页查询Entry
	 * @param category Category
	 * @param pageSize 分页大小
	 * @param startIndex　开始位置
	 * @param order　排序的字段
	 * @param isDesc　是否倒排
	 * @return 分页工具类
	 * @see {@link PaginationSupport}
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport<Entry> getEntryPageByCategory(Category category, int pageSize, int startIndex, String order, Boolean isDesc);
	
}
