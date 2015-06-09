/**
 * 
 * ACCWebFrame - ACC Web Development Platform
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
package com.acc.web.test;

import junit.framework.TestCase;

import com.acc.web.frame.manager.LogManager;

public class CommonTest extends TestCase {
	private LogManager logManager;

	public class TestObject {
		private String name;
		private int value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.logManager = new LogManager();
	}

	private TestObject getTestObject() {
		TestObject testObject = new TestObject();
		testObject.setName("name of test object");
		testObject.setValue(1);
		return testObject;
	}

	public void testInfo() {
		this.logManager.info("info!");
		this.logManager.info("prefix", "info!");
		this.logManager.info("testObject", getTestObject());
		this.logManager.info(CommonTest.class, "testObject", getTestObject());
	}

	public void testfileOut() {
		this.logManager.fileOut("file out!");
		this.logManager.fileOut("prefix", "file out!");
		this.logManager.fileOut("testObject", getTestObject());
	}

	public void testSystemOut() {
		this.logManager.systemOut("system out!");
		this.logManager.systemOut("prefix", "system out!");
		this.logManager.systemOut("testObject", getTestObject());
	}
}