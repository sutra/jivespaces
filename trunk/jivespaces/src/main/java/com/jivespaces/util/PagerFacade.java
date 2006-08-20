/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, leaf.jdk.cn
 * Filename:		PagerFacade.java
 * Module:			Dream
 * Class:			PagerFacade
 * Date:			2006-6-25 0:44:51
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PagerFacade {
    
    private static Log log = LogFactory.getLog(PagerFacade.class);  
    
    /**
     * ��ȡ Offset 
     * @return offset 
     */
    public static int getOffset(String pagerOffset) {
      
        int offset= 0;
        try {
            offset = Integer.parseInt(pagerOffset);
        } catch (NumberFormatException e) {
            if (log.isDebugEnabled()) {
                log.debug("Error during get pager.offset", e);
            }
        }
        return offset;
    }
    
    /**
     * 
     * @return 
     */
    public static int getOffset() {
    	return 0;
    }
    
    /**
     * ��ȡ maxPageItems ֵ
     * @return maxPageItems ֵ
     */
    public static int getMaxPageItems() {
        int interval = PaginationSupport.DEFAULT_MAX_PAGE_ITEMS;
       
        return interval;
    }
    
    
    /**
     * ��ȡ DEFAULT_MAX_PAGE_ITEMS ֵ
     * @return DEFAULT_MAX_INDEX_PAGES ֵ
     */
    public static int getMaxIndexPages() {
        int maxIndexPages = PaginationSupport.DEFAULT_MAX_INDEX_PAGES;
      
        return maxIndexPages;
    }
    
    
    public static String getIndex() {
        return  PaginationSupport.DEFALUT_INDEX;
    }
    
}



