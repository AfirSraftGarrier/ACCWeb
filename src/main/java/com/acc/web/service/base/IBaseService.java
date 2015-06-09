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
package com.acc.web.service.base;

import java.util.List;

public interface IBaseService<T, K, B> {
	public B add(T... toAdds);

	public B delete(K... ids);

	public B deleteAll();

	public T get(K id);

	public List<T> get(K... ids);

	public List<T> getAll();

	public List<T> getMatching(List<T> ts);

	// public T getMatching(T t);

	public B deleteMatching(List<T> ts);
}