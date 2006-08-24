/**
 * Created on 2006-8-19 下午10:51:27
 */
package com.jivespaces.web.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jivespaces.domain.Space;

/**
 * 
 * @author Shutra
 * 
 */
public abstract class SpaceNameUrlRewriteFilter implements Filter {
	protected Log log = LogFactory
			.getLog(SpaceNameUrlRewriteBySubdirectoriesFilter.class);

	protected FilterConfig filterConfig;

	protected static String spaceNameAttributeName = "com.jivespaces.web.filter.SpaceNameUrlRewriteFilter.spaceNameAttributeName";

	protected static boolean isSpaceNameRewritingBySubdirectories = false;

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
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		CharSequence url = this.getUrl(req);
		log.debug("url: " + url);
		String spaceName = null;
		String realUri = null;
		Matcher matcher = this.spaceNamePattern.matcher(url);
		if (matcher.find()) {
			spaceName = matcher.group(this.spaceNameGroupIndex).toLowerCase();
			realUri = "/"
					+ matcher.group(this.realUriWithoutPrefixedSlashGroupIndex);
			log.debug("spaceName: " + spaceName);
			log.debug("realUri: " + realUri);
		}

		if (spaceName != null && realUri != null) {
			req.setAttribute(spaceNameAttributeName, spaceName);
			// TODO.
			Space space = new Space();
			space.setName(spaceName);
			space.setDisplayName("test..." + spaceName);
			req.setAttribute("space", space);

			// this.filterConfig.getServletContext().getRequestDispatcher(realUri)
			// .forward(request, response);

			chain.doFilter(request, response);
		} else {
			// TODO: display the error page.
			this.filterConfig.getServletContext().getRequestDispatcher("/")
					.forward(request, response);
		}
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
			spaceNameAttributeName = s;
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

	public static String getSpaceName(HttpServletRequest httpServletRequest) {
		return (String) httpServletRequest
				.getAttribute(SpaceNameUrlRewriteFilter.spaceNameAttributeName);
	}

	public static boolean isSpaceNameRewritingBySubdirectories() {
		return isSpaceNameRewritingBySubdirectories;
	}

	protected abstract CharSequence getUrl(HttpServletRequest httpServletRequest);
}