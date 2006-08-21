/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.com
 * Filename:		TagDao.java
 * Class:			TagDao
 * Date:			2006-8-21 下午10:08:23
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-8-21   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jivespaces.dao;

import com.jivespaces.domain.Tag;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-8-21 下午10:08:23
 * @version $Id TagDao.java$
 */
public interface TagDao extends BaseDao {
	
	public Tag getTag(String id);
}
