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
package com.acc.web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acc.java.model.Response;
import com.acc.java.model.ResponseStatus;

@Component
public class HttpDataManager {
	@Autowired
	protected CommonDataManager commonDataManager;
	@Autowired
	protected JsonManager jsonManager;

	private String defaultExceptionResponseString;
	private String defaultSuccessResponseString;

	public CommonDataManager getCommonDataManager() {
		return this.commonDataManager;
	}

	private void init() {
		// Response defaultExceptionResponse = new Response();
		// defaultExceptionResponse.setSuccess(commonDataManager.getDefaultNo());
		this.defaultExceptionResponseString = jsonManager.getJson(this
				.getDefaultExceptionResponse());
		// Response defaultSuccessResponse = new Response();
		// defaultSuccessResponse.setSuccess(commonDataManager.getDefaultYes());
		this.defaultSuccessResponseString = jsonManager.getJson(this
				.getDefaultSuccessResponse());
	}

	public String getDefaultExceptionResponseString() {
		if (this.defaultExceptionResponseString == null) {
			this.init();
		}
		return this.defaultExceptionResponseString;
	}

	public String getDefaultSuccessResponseString() {
		if (this.defaultSuccessResponseString == null) {
			this.init();
		}
		return this.defaultSuccessResponseString;
	}

	public Response getDefaultExceptionResponse() {
		Response defaultExceptionResponse = new Response();
		defaultExceptionResponse.setResponseStatus(ResponseStatus.EXCEPTION);
		return defaultExceptionResponse;
	}

	public Response getDefaultSuccessResponse() {
		Response defaultSuccessResponse = new Response();
		defaultSuccessResponse.setResponseStatus(ResponseStatus.SUCCESS);
		return defaultSuccessResponse;
	}
}