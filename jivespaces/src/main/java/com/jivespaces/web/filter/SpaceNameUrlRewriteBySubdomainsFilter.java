/**
 * Created on 2006-8-19 下午10:43:28
 */
package com.jivespaces.web.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Shutra
 * 
 */
public class SpaceNameUrlRewriteBySubdomainsFilter extends SpaceNameUrlRewriteFilter {
	public SpaceNameUrlRewriteBySubdomainsFilter() {
		this.spaceNamePattern = Pattern
				.compile("(http|https)://([0-9a-zA-Z-]+).([0-9a-zA-Z-.]+)((:[\\d]+)?)/jivespaces/(.*)");
		this.spaceNameGroupIndex = 2;
		this.realUriWithoutPrefixedSlashGroupIndex = 6;
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
		StringBuffer requestURL = req.getRequestURL();
		log.debug("requestURL: " + requestURL);
		String spaceName = null;
		String realUri = null;
		Matcher matcher = this.spaceNamePattern.matcher(requestURL);
		if (matcher.find()) {
			spaceName = matcher.group(this.spaceNameGroupIndex).toLowerCase();
			realUri = "/"
					+ matcher.group(this.realUriWithoutPrefixedSlashGroupIndex);
			log.debug("spaceName: " + spaceName);
			log.debug("realUri: " + realUri);
		}
		if (spaceName != null && realUri != null) {
			req.setAttribute(this.spaceNameAttributeName, spaceName);
			this.filterConfig.getServletContext().getRequestDispatcher(realUri)
					.forward(request, response);
		} else {
			this.filterConfig.getServletContext().getRequestDispatcher("/")
					.forward(request, response);
		}
	}

}
