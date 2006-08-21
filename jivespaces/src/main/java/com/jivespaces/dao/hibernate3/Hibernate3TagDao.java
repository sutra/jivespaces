/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.com
 * Filename:		Hibernate3TagDao.java
 * Class:			Hibernate3TagDao
 * Date:			2006-8-21 下午10:10:29
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
package com.jivespaces.dao.hibernate3;

import com.jivespaces.dao.TagDao;
import com.jivespaces.domain.Tag;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-8-21 下午10:10:29
 * @version $Id Hibernate3TagDao.java$
 */
public class Hibernate3TagDao extends BaseHibernateEntityDao<Tag> implements TagDao {

	/* (non-Javadoc)
	 * @see com.jivespaces.dao.TagDao#getTag(java.lang.String)
	 */
	public Tag getTag(String id) {
		return get(id);
	}
	
	
}
