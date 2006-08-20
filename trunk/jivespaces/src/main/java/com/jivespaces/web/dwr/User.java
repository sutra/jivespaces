/**
 * Created on 2006-8-20 14:45:40
 */
package com.jivespaces.web.dwr;

import org.directwebremoting.WebContextFactory;

import com.jivespaces.web.filter.SpaceNameUrlRewriteFilter;

/**
 * @author Shutra
 * 
 */
public class User {
	public String getSpaceName() {
		return SpaceNameUrlRewriteFilter.getSpaceName(WebContextFactory.get()
				.getHttpServletRequest());
	}

}
