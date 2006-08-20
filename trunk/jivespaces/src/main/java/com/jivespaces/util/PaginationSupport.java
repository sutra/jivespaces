/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, leaf.jdk.cn
 * Filename:		PaginationSupport.java
 * Module:			Dream
 * Class:			PaginationSupport
 * Date:			2006-6-25 0:32:40
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-6-25   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jivespaces.util;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-6-25 0:32:40
 * @version $Id PaginationSupport.java$
 */
import java.util.LinkedList;
import java.util.List;

public class PaginationSupport {

	// ---------------------------------------------------------
	// static variables
	// ---------------------------------------------------------

	// 默认每页显示条数
	public static final int DEFAULT_MAX_PAGE_ITEMS = 10;

	// 默认开始记录条数
	public static final int DEFAULT_OFFSET = 0;

	// 默认显示页码最大数
	public static final int DEFAULT_MAX_INDEX_PAGES = 10;

	// index 为索引页位置, 可以选择 "center", "forward", "half-full"
	public static final String DEFALUT_INDEX = "center";

	// ---------------------------------------------------------
	// memeber variables
	// ---------------------------------------------------------

	// 开始记录条数
	private int offset = 0;

	// 每页显示条数
	private int maxPageItems = DEFAULT_MAX_PAGE_ITEMS;

	// 显示页码最大数
	private int maxIndexPages = DEFAULT_MAX_INDEX_PAGES;

	// 总记录数
	private int totalCount;

	// 返回结果集
	private List items = new LinkedList();

	// index 为索引页位置, 可以选择 "center", "forward", "half-full"
	private String index = DEFALUT_INDEX;

	private int[] indexes = new int[0];

	public PaginationSupport() {
		setMaxIndexPages(DEFAULT_MAX_INDEX_PAGES);
		setTotalCount(0);
		setOffset(0);
		setItems(new LinkedList());
	}

	public PaginationSupport(List items, int totalCount) {
		setMaxPageItems(DEFAULT_MAX_PAGE_ITEMS);
		setTotalCount(totalCount);
		setItems(items);
		setOffset(PagerFacade.getOffset());
	}

	public PaginationSupport(List items, int totalCount, int offset) {
		setMaxPageItems(DEFAULT_MAX_PAGE_ITEMS);
		setTotalCount(totalCount);
		setItems(items);
		setOffset(offset);
	}

	public PaginationSupport(List items, int totalCount, int offset, int maxPageItems) {
		setMaxPageItems(maxPageItems);
		setTotalCount(totalCount);
		setItems(items);
		setOffset(offset);
	}

	public PaginationSupport(List items, int totalCount, int offset, int maxPageItems, int maxIndexPages, String index) {
		setMaxPageItems(maxPageItems);
		setTotalCount(totalCount);
		setItems(items);
		setOffset(offset);
		setMaxIndexPages(maxIndexPages);
		setIndex(index);
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		if (items == null) {
			this.items = new LinkedList();
		} else {
			this.items = items;
		}
	}

	public int getMaxPageItems() {
		return maxPageItems;
	}

	public void setMaxPageItems(int maxPageItems) {
		this.maxPageItems = maxPageItems;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			int count = totalCount / maxPageItems;
			if (totalCount % maxPageItems > 0) {
				count++;
			}
			indexes = new int[count];
			for (int i = 0; i < count; i++) {
				indexes[i] = maxPageItems * i;
			}
		} else {
			this.totalCount = 0;
		}
	}

	public int[] getIndexes() {
		return indexes;
	}

	public void setIndexes(int[] indexes) {
		this.indexes = indexes;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int startIndex) {
		if (totalCount <= 0)
			this.offset = 0;
		else if (startIndex >= totalCount)
			this.offset = indexes[indexes.length - 1];
		else if (startIndex < 0)
			this.offset = 0;
		else {
			this.offset = indexes[startIndex / maxPageItems];
		}
	}

	public int getNextIndex() {
		int nextIndex = getOffset() + maxPageItems;
		return nextIndex >= totalCount ? getOffset() : nextIndex;
	}

	public int getPreviousIndex() {
		int previousIndex = getOffset() - maxPageItems;
		return previousIndex < 0 ? DEFAULT_OFFSET : previousIndex;
	}

	/**
	 * @return Returns the dEFAULT_MAX_INDEX_PAGES.
	 */
	public static int getDEFAULT_MAX_INDEX_PAGES() {
		return DEFAULT_MAX_INDEX_PAGES;
	}

	/**
	 * @return Returns the maxIndexPages.
	 */
	public int getMaxIndexPages() {
		return maxIndexPages;
	}

	/**
	 * @param maxIndexPages
	 *            The maxIndexPages to set.
	 */
	public void setMaxIndexPages(int maxIndexPages) {
		this.maxIndexPages = maxIndexPages;
	}

	/**
	 * @return Returns the index.
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            The index to set.
	 */
	public void setIndex(String index) {
		this.index = index;
	}

}
