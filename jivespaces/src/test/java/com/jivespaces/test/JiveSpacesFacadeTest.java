/**
 * <pre>
 * Copyright:		Copyright(C) 2006, jivespaces.com
 * Filename:		JiveSpacesFacadeTest.java
 * Class:			JiveSpacesFacadeTest
 * Date:			2006-9-4 下午10:45:40
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-9-4   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jivespaces.test;

import com.jivespaces.JiveSpacesFacade;
import com.jivespaces.domain.Entry;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-9-4 下午10:45:40
 * @version $Id JiveSpacesFacadeTest.java$
 */
public class JiveSpacesFacadeTest extends AbstractTestBean {
	protected JiveSpacesFacade jiveSpacesFacade;
	
	public void testEntryCRUD() throws Exception {
		Entry entry = new Entry();
		entry.setTitle("JiveSpaces's Entry");
		entry.setContent("This is the JiveSpaces's entry");
		jiveSpacesFacade.saveEntry(entry);
		String id = entry.getId();
		Entry saved = jiveSpacesFacade.getEntry(id);
		assertEquals(saved.getTitle(), "JiveSpaces's Entry");
		
		saved.setTitle("Title modified!");
		jiveSpacesFacade.saveEntry(saved);
		assertEquals("Title modified!", jiveSpacesFacade.getEntry(id).getTitle());
		jiveSpacesFacade.removeEntry(id);
		
		assertNull(jiveSpacesFacade.getEntry(id));
		
	}
}
