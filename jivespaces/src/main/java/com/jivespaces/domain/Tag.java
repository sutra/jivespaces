/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.com
 * Filename:		Tag.java
 * Class:			Tag
 * Date:			2006-8-21 下午09:54:53
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

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-8-21 下午09:54:53
 * @version $Id Tag.java$
 */
public class Tag extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8640621023025162300L;
	
	private  String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tag:" + this.name;
	}
}
