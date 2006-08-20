/**
 * Created on 2006-8-20 下午01:57:24
 */
package com.jivespaces.dao;

import com.jivespaces.domain.Entry;

/**
 * @author Shutra
 * 
 */
public interface EntryDao {
	Entry getEntry(String id);
}
