/**
 * Created on 2006-8-20 13:22:06
 */
package com.jivespaces.domain;

import java.util.Date;
import java.util.Set;

/**
 * @author Shutra
 * 
 */
public class Entry extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8130825998272869627L;

	private Space space;

	private String title;

	private String excerpt;

	private Date publishedDate;

	private String content;

	/**
	 * 别名。某个空间某一天不能有相同的别名。
	 */
	private String name;
	
	private Set<Category> categories;

	private Set<Tag> tags;
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
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
	
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
