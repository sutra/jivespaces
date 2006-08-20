/**
 * Created on 2006-8-20 13:22:06
 */
package com.jivespaces.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Shutra
 * 
 */
public class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8130825998272869627L;

	private Space space;

	private String id;

	private String title;

	private String excerpt;

	private Date publishedDate;

	private String body;

	private Set<Category> categories;

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the excerpt
	 */
	public String getExcerpt() {
		return excerpt;
	}

	/**
	 * @param excerpt
	 *            the excerpt to set
	 */
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

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
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate
	 *            the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
