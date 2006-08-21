/**
 * Created on 2006-8-20 13:24:05
 */
package com.jivespaces.domain;


/**
 * @author Shutra
 * 
 */
public class Category extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2027121874375007838L;

	private Space space;

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the space
	 */
	public Space getSpace() {
		return space;
	}

	/**
	 * @param space
	 *            the space to set
	 */
	public void setSpace(Space space) {
		this.space = space;
	}

}
