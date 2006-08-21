/**
 * Created on 2006-8-20 下午01:49:25
 */
package com.jivespaces.domain;


/**
 * @author Shutra
 * 
 */
public class User extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466698209227153700L;

	private String openId;

	private String displayName;


	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId
	 *            the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
