/**
 * 
 * ACCWeb - ACC Web Development Platform
 * Copyright (c) 2014, AfirSraftGarrier, afirsraftgarrier@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.acc.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.acc.web.manager.HttpDataManager;
import com.acc.web.manager.JsonManager;
import com.acc.web.manager.LogManager;

public class ACCBaseRest extends SpringBeanAutowiringSupport {
	@Autowired
	protected JsonManager jsonManager;
	@Autowired
	protected LogManager logManager;
	@Autowired
	protected HttpDataManager httpDataManager;

	protected String getJson(Object object) {
		return this.jsonManager.getJson(object);
	}

	protected String getDefaultExceptionResponseString() {
		return this.httpDataManager.getDefaultExceptionResponseString();
	}

	protected String getDefaultSuccessResponseString() {
		return this.httpDataManager.getDefaultSuccessResponseString();
	}
}