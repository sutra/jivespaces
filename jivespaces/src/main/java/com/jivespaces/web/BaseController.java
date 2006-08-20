/**
 * Created on 2006-8-20 下午04:25:34
 */
package com.jivespaces.web;

import org.springframework.web.servlet.mvc.Controller;

import com.jivespaces.JiveSpacesFacade;

/**
 * @author Shutra
 * 
 */
public abstract class BaseController implements Controller {
	protected JiveSpacesFacade jiveSpacesFacade;

	/**
	 * @param jiveSpacesFacade
	 *            the jiveSpacesFacade to set
	 */
	public void setJiveSpacesFacade(JiveSpacesFacade jiveSpacesFacade) {
		this.jiveSpacesFacade = jiveSpacesFacade;
	}

}
