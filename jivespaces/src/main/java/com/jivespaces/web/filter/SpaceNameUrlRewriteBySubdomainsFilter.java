/**
 * Created on 2006-8-19 下午10:43:28
 */
package com.jivespaces.web.filter;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 借助子域名进行空间名的 URL 重写（Space name's URL rewriting by subdomains）。
 * <p>
 * 从 http://shutra.jivespaces.com/... 取出 shutra 作为 space name 存入 request
 * 的属性中（属性名由 spaceNameAttributeName 指定）。
 * </p>
 * 
 * @author Shutra
 * 
 */
public class SpaceNameUrlRewriteBySubdomainsFilter extends
		SpaceNameUrlRewriteFilter {
	public SpaceNameUrlRewriteBySubdomainsFilter() {
		this.spaceNamePattern = Pattern
				.compile("(http|https)://([0-9a-zA-Z-]+).([0-9a-zA-Z-.]+)((:[\\d]+)?)/jivespaces/(.*)");
		this.spaceNameGroupIndex = 2;
		this.realUriWithoutPrefixedSlashGroupIndex = 6;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.web.filter.SpaceNameUrlRewriteFilter#getUrl(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected CharSequence getUrl(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getRequestURL();
	}

}
