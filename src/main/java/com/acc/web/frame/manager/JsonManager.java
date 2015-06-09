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
package com.acc.web.frame.manager;

import org.springframework.stereotype.Component;

import com.acc.java.manager.base.BaseJsonManager;

@Component
public class JsonManager extends BaseJsonManager {
	// private static JsonManager instance;
	// private final Gson gson;

	// public static JsonManager getInstance() {
	// if (instance == null) {
	// instance = new JsonManager();
	// }
	// return instance;
	// }

	// public JsonManager() {
	// this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
	// .create();
	// }

	// public String getJson(Object object) {
	// return this.gson.toJson(object);
	// }
	//
	// public <T> T getObject(String jsonString, Class<T> classT) {
	// // T returnObject = null;
	// // try {
	// // returnObject = this.gson.fromJson(jsonString, classT);
	// // } catch (JsonSyntaxException e) {
	// // e.printStackTrace();
	// // }
	// return this.gson.fromJson(jsonString, classT);
	// }
	//
	// public <T> T getObject(String jsonString, Type type) {
	// // T returnObject = null;
	// // try {
	// // returnObject = this.gson.fromJson(jsonString, type);
	// // } catch (JsonSyntaxException e) {
	// // // LogUtil.info(this, jsonString);
	// // e.printStackTrace();
	// // }
	// return this.gson.fromJson(jsonString, type);
	// }
	//
	// // public <T> T get(String jsonString) {
	// // // T returnObject = null;
	// // // try {
	// // // returnObject = this.gson.fromJson(jsonString, classT);
	// // // } catch (JsonSyntaxException e) {
	// // // e.printStackTrace();
	// // // }
	// // Type type = new TypeToken<T>() {
	// // }.getType();
	// // return this.gson.fromJson(jsonString, type);
	// // }
	//
	// // public <T> T get(String jsonString, Class<T> classT) {
	// // // T returnObject = null;
	// // // try {
	// // // returnObject = this.gson.fromJson(jsonString, classT);
	// // // } catch (JsonSyntaxException e) {
	// // // e.printStackTrace();
	// // // }
	// // // Type type = new TypeToken<T>() {
	// // // }.getType();
	// // return this.gson.fromJson(jsonString, classT);
	// // }
	//
	// // public <T extends Long> List<T> gets(String jsonString) {
	// // // T returnObject = null;
	// // // try {
	// // // returnObject = this.gson.fromJson(jsonString, classT);
	// // // } catch (JsonSyntaxException e) {
	// // // e.printStackTrace();
	// // // }
	// // Type type = new TypeToken<T>() {
	// // }.getType();
	// // return this.gson.fromJson(jsonString, type);
	// // }
	//
	// // public <T> Type getType(Class<T> classType) {
	// // return new TypeToken<T>() {
	// // }.getType();
	// // }
}