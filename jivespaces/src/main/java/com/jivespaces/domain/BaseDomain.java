/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.org
 * Filename:		BaseDomain.java
 * Class:			BaseDomain
 * Date:			2006-8-21 下午09:54:02
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
package com.jivespaces.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-8-21 下午09:54:02
 * @version $Id BaseDomain.java$
 */
public abstract class BaseDomain implements Serializable {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
