/**
 * Created on 2006-8-19 下午10:51:27
 */
package com.jivespaces.web.filter;

import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Shutra
 * 
 */
public abstract class SpaceNameUrlRewriteFilter implements Filter {
	protected Log log = LogFactory.getLog(SpaceNameUrlRewriteBySubdirectoriesFilter.class);

	protected FilterConfig filterConfig;

	protected String spaceNameAttributeName = "space";

	protected Pattern spaceNamePattern;

	protected int spaceNameGroupIndex;

	protected int realUriWithoutPrefixedSlashGroupIndex;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

		// spaceNameAttributeName.
		String s = this.filterConfig.getInitParameter("spaceNameAttributeName");
		if (s != null) {
			this.spaceNameAttributeName = s;
		}

		// spaceNamePattern.
		s = this.filterConfig.getInitParameter("spaceNamePattern");
		if (s != null) {
			this.spaceNamePattern = Pattern.compile(s);
		}

		// spaceNameGroupIndex.
		s = this.filterConfig.getInitParameter("spaceNameGroupIndex");
		if (s != null) {
			this.spaceNameGroupIndex = NumberUtils.toInt(s);
		}

		// realUriGroupIndex.
		s = this.filterConfig
				.getInitParameter("realUriWithoutPrefixedSlashGroupIndex");
		if (s != null) {
			this.realUriWithoutPrefixedSlashGroupIndex = NumberUtils.toInt(s);
		}
	}
}
