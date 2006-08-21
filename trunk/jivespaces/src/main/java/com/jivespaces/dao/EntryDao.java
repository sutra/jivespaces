/**
 * Created on 2006-8-20 下午01:57:24
 */
package com.jivespaces.dao;

import com.jivespaces.domain.Entry;
import com.jivespaces.util.PaginationSupport;

/**
 * @author Shutra
 * 
 */
public interface EntryDao {
	Entry getEntry(String id);
	
	/**
	 * 分页查找Entry
	 * @param entry 查询条件
	 * @param pageSize 分页大小
	 * @param startIndex 记录开始位置
	 * @return 分页工具类
	 * @see PaginationSupport
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport getEntryList(Entry entry, int pageSize, int startIndex);
	
	/**
	 * 根据TagName查找Entry
	 * @param tagName Tag名称
	 * @param pageSize 分页大小
	 * @param startIndex 记录开始位置
	 * @return 分页工具类
	 * @see PaginationSupport
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public PaginationSupport getEntryListByTag(String tagName, int pageSize, int startIndex);
}
