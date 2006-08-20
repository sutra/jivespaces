/**
 * Created on 2006-8-20 16:01:08
 */
package com.jivespaces.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.jivespaces.domain.Entry;

/**
 * @author Shutra
 * 
 */
public class EntryController extends BaseController {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Entry entry = jiveSpacesFacade.getEntry(id);
		request.setAttribute("entry", entry);
		return new ModelAndView("entry");
	}

}
