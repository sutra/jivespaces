/**
 * Created on 2006-8-20 上午10:45:12
 */
package com.jivespaces.web.util;

import javax.servlet.http.HttpServletRequest;

import com.jivespaces.web.filter.SpaceNameUrlRewriteFilter;

/**
 * @author Shutra
 * 
 */
public class WebUtils {
	public static String getContextPath(HttpServletRequest httpServletRequest) {
		String cp = httpServletRequest.getContextPath();
		if (SpaceNameUrlRewriteFilter.isSpaceNameRewritingBySubdirectories()) {
			cp += SpaceNameUrlRewriteFilter.getSpaceName(httpServletRequest);
		}
		if (cp.equals("/")) {
			return "";
		} else {
			return cp;
		}
	}
}
