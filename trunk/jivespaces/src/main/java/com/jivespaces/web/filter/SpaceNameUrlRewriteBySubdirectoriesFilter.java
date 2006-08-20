/**
 * Created on 2006-8-19 下午09:02:48
 */
package com.jivespaces.web.filter;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 借助目录名进行空间名的 URL 重写（Space name's URL rewriting by subdirectories）。
 * <p>
 * 从 /space/shutra/...（是如同 URL：
 * http://yourdomain.com/jivespaces/space/shutra/... 中的 RequestURI 部分） 中取出
 * shutra 作为 space name 存入 request 的属性中（属性名由 spaceNameAttributeName 指定）。
 * </p>
 * 
 * @author Shutra
 * 
 */
public class SpaceNameUrlRewriteBySubdirectoriesFilter extends
		SpaceNameUrlRewriteFilter {
	public SpaceNameUrlRewriteBySubdirectoriesFilter() {
		this.spaceNamePattern = Pattern.compile("/space/([0-9a-zA-Z-]+)/(.*)");
		this.spaceNameGroupIndex = 1;
		this.realUriWithoutPrefixedSlashGroupIndex = 2;
		isSpaceNameRewritingBySubdirectories = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jivespaces.web.filter.SpaceNameUrlRewriteFilter#getUrl(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected CharSequence getUrl(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getRequestURI();
	}

}
