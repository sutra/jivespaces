/**
 * Created on 2006-8-20 13:24:05
 */
package com.jivespaces.domain;

import java.io.Serializable;

/**
 * @author Shutra
 * 
 */
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2027121874375007838L;

	private Space space;

	private String id;

	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
