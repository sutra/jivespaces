/**
 * Created on 2006-8-20 下午01:57:31
 */
package com.jivespaces.dao;

import com.jivespaces.domain.Category;

/**
 * @author Shutra
 * 
 */
public interface CategoryDao extends BaseDao{
	Category getCategory(String id);
}
