/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jivespaces.com
 * Filename:		AbstractTestBean.java
 * Module:			Dream
 * Class:			AbstractTestBean
 * Date:			2006-6-25 10:01:38
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-6-25   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jivespaces.test;

import org.hibernate.SessionFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-6-25 10:01:38
 * @version $Id AbstractTestBean.java$
 */
public abstract class AbstractTestBean extends	AbstractTransactionalSpringContextTests {
	protected SessionFactory sessionFactory;

	public AbstractTestBean() {
		setPopulateProtectedVariables(true);
	}
	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
	 */
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "spring/global-test.xml", "spring/*-context.xml" };
	}
	
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		init();
	}

	protected void init() throws Exception {
		
	}
}
