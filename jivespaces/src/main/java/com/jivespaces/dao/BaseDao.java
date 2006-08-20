/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.org
 * Filename:		BaseDao.java
 * Class:			BaseDao
 * Date:			2006-8-20 下午10:46:34
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-8-20   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jivespaces.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.jivespaces.util.PaginationSupport;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-8-20 下午10:46:34
 * @version $Id BaseDao.java$
 */
public interface BaseDao {
	/**
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize, final int startIndex);
	
}
