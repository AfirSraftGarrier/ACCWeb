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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acc.java.util.base.BaseLogUtil;
import com.acc.java.util.constant.AppLibConstant;

@Component
public class LogManager extends BaseLogUtil {
	@Autowired
	JsonManager jsonManager;

	enum LogType {
		INFO, WARN, ERROR, DEBUG, FATAL, SYSTEMOUT, FILE
	}

	private Log getLogger(Object logTypeObject) {
		if (logTypeObject == null) {
			return LogFactory.getLog(this.getDefaultLogTypeString());
		}
		if (logTypeObject instanceof String) {
			return LogFactory.getLog((String) logTypeObject);
		} else if (logTypeObject instanceof Class) {
			return LogFactory.getLog((Class) logTypeObject);
		} else {
			return LogFactory.getLog((logTypeObject.getClass()));
		}
	}

	public String getLogString(Object prefixObject, Object informationObject) {
		return getLogString(prefixObject, informationObject, new JsonManager(),
				-1);
	}

	private void log(Object logTypeObject, Object prefixObject,
			Object informationObject, LogType logType) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		Log log = logType == LogType.SYSTEMOUT || logType == LogType.FILE ? null
				: this.getLogger(logTypeObject);
		String logString = this.getLogString(prefixObject, informationObject);
		switch (logType) {
		case SYSTEMOUT:
			super.systemOut(logString);
			break;
		case FILE:
			super.fileOut(logString);
			break;
		case INFO:
			log.info(logString);
			break;
		case WARN:
			log.warn(logString);
			break;
		case DEBUG:
			log.debug(logString);
			break;
		case ERROR:
			log.error(logString);
			break;
		case FATAL:
			log.fatal(logString);
			break;
		}
	}

	public void systemOut(Object informationObject) {
		this.log(null, null, informationObject, LogType.SYSTEMOUT);
	}

	public void systemOut(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.SYSTEMOUT);
	}

	public void fileOut(Object informationObject) {
		this.log(null, null, informationObject, LogType.FILE);
	}

	public void fileOut(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.FILE);
	}

	private String getDefaultLogTypeString() {
		return Thread.currentThread().getStackTrace()[5].getClassName();
	}

	public void info(Object informationObject) {
		this.log(null, null, informationObject, LogType.INFO);
	}

	public void info(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.INFO);
	}

	public void info(Object logTypeObject, Object prefixObject,
			Object informationObject) {
		this.log(logTypeObject, prefixObject, informationObject, LogType.INFO);
	}

	public void warn(Object informationObject) {
		this.log(null, null, informationObject, LogType.WARN);
	}

	public void warn(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.WARN);
	}

	public void warn(Object logTypeObject, Object prefixObject,
			Object informationObject) {
		this.log(logTypeObject, prefixObject, informationObject, LogType.WARN);
	}

	public void debug(Object informationObject) {
		this.log(null, null, informationObject, LogType.DEBUG);
	}

	public void debug(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.DEBUG);
	}

	public void debug(Object logTypeObject, Object prefixObject,
			Object informationObject) {
		this.log(logTypeObject, prefixObject, informationObject, LogType.DEBUG);
	}

	public void error(Object informationObject) {
		this.log(null, null, informationObject, LogType.ERROR);
	}

	public void error(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.ERROR);
	}

	public void error(Object logTypeObject, Object prefixObject,
			Object informationObject) {
		this.log(logTypeObject, prefixObject, informationObject, LogType.ERROR);
	}

	public void fatal(Object informationObject) {
		this.log(null, null, informationObject, LogType.FATAL);
	}

	public void fatal(Object prefixObject, Object informationObject) {
		this.log(null, prefixObject, informationObject, LogType.FATAL);
	}

	public void fatal(Object logTypeObject, Object prefixObject,
			Object informationObject) {
		this.log(logTypeObject, prefixObject, informationObject, LogType.FATAL);
	}

	// public String getLogString(Object informationObject) {
	// return getLogString(null, informationObject, this.jsonManager, -1);
	// }

	// public void info(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// info(this.getLogger(classType), this.getLogString(tagObject,
	// informationPrefixString, informationObject, this.jsonManager));
	// }

	// private void info(Log log
	// // , JsonManager jsonManager
	// , String logString) {
	// log.info(logString);
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// }

	// public void warn(Class classType, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// warn(this.getLogger(classType),
	// this.getLogString(informationObject, this.jsonManager));
	// }
	//
	// public void warn(Class classType, Object tagObject, Object
	// informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// warn(this.getLogger(classType), this.getLogString(tagObject,
	// informationObject, this.jsonManager));
	// }
	//
	// public void warn(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// warn(this.getLogger(classType), this.getLogString(tagObject,
	// informationPrefixString, informationObject, this.jsonManager));
	// }
	//
	// private void warn(Log log
	// // , JsonManager jsonManager
	// , String logString) {
	// log.warn(logString);
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// }
	//
	// public void error(Class classType, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// error(this.getLogger(classType),
	// this.getLogString(informationObject, this.jsonManager));
	// }
	//
	// public void error(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// error(this.getLogger(classType), this.getLogString(tagObject,
	// informationObject, this.jsonManager));
	// }
	//
	// public void error(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// error(this.getLogger(classType), this.getLogString(tagObject,
	// informationPrefixString, informationObject, this.jsonManager));
	// }
	//
	// private void error(Log log
	// // , JsonManager jsonManager
	// , String logString) {
	// log.error(logString);
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// }
	//
	// public void debug(Class classType, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// debug(this.getLogger(classType),
	// this.getLogString(informationObject, this.jsonManager));
	// }
	//
	// public void debug(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// debug(this.getLogger(classType), this.getLogString(tagObject,
	// informationObject, this.jsonManager));
	// }
	//
	// public void debug(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// debug(this.getLogger(classType), this.getLogString(tagObject,
	// informationPrefixString, informationObject, this.jsonManager));
	// }
	//
	// private void debug(Log log
	// // , JsonManager jsonManager
	// , String logString) {
	// log.debug(logString);
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// }
	//
	// public void fatal(Class classType, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// fatal(this.getLogger(classType),
	// this.getLogString(informationObject, this.jsonManager));
	// }
	//
	// public void fatal(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// fatal(this.getLogger(classType), this.getLogString(tagObject,
	// informationObject, this.jsonManager));
	// }
	//
	// //
	// public void fatal(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// fatal(this.getLogger(classType), this.getLogString(tagObject,
	// informationPrefixString, informationObject, this.jsonManager));
	// }
	//
	// private void fatal(Log log
	// // , JsonManager jsonManager
	// , String logString) {
	// log.fatal(logString);
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// }

	// public void warning(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// warn(this.getLogger(classType), jsonManager, tagObject,
	// informationObject);
	// }

	// public void error(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// error(this.getLogger(classType), jsonManager, tagObject,
	// informationObject);
	// }

	// public void debug(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// debug(this.getLogger(classType), jsonManager, tagObject,
	// informationObject);
	// }

	// public void fatal(Class classType, Object tagObject,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// fatal(this.getLogger(classType), jsonManager, tagObject,
	// informationObject);
	// }

	// public void warn(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// warn(this.getLogger(classType), jsonManager, tagObject,
	// informationPrefixString, informationObject);
	// }

	// public void error(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// error(this.getLogger(classType), jsonManager, tagObject,
	// informationPrefixString, informationObject);
	// }

	// public void debug(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// debug(this.getLogger(classType), jsonManager, tagObject,
	// informationPrefixString, informationObject);
	// }

	// public void fatal(Class classType, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// fatal(this.getLogger(classType), jsonManager, tagObject,
	// informationPrefixString, informationObject);
	// }

	// public void systemOut(Object tagObject, Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// systemOut(jsonManager, tagObject, informationObject);
	// }
	//
	// public void systemOut(Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// systemOut(jsonManager, informationObject);
	// }
	//
	// public void systemOut(Object tagObject, String informationPrefixString,
	// Object informationObject) {
	// if (!AppLibConstant.isUseLog()) {
	// return;
	// }
	// systemOut(jsonManager, tagObject, informationPrefixString,
	// informationObject);
	// }

	// @Autowired
	// protected static JsonManager jsonManager;

	// private static String getStringFromObject(JsonManager jsonManager,
	// Object object) {
	// String resultString;
	// if (object instanceof String) {
	// resultString = (String) object;
	// } else {
	// try {
	// resultString = jsonManager.getJson(object);
	// } catch (Exception e) {
	// resultString = "该类不符合规范，尝试传字符串类型";
	// }
	// }
	// return resultString;
	// }

	// private static String getStringFromObject(Object object) {
	// String resultString;
	// if (object instanceof String) {
	// resultString = (String) object;
	// } else {
	// try {
	// resultString = jsonManager.getJson(object);
	// } catch (Exception e) {
	// resultString = "该类不符合规范，尝试传字符串类型";
	// }
	// }
	// return resultString;
	// }

	// public static void info(Logger log, JsonManager jsonManager,
	// Object tagObject, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void warn(Logger log, JsonManager jsonManager,
	// Object tagObject, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// log.warn((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.warn(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void error(Logger log, JsonManager jsonManager,
	// Object tagObject, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// log.error((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.error(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void debug(Logger log, JsonManager jsonManager,
	// Object tagObject, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// log.debug((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.debug(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void fatal(Logger log, JsonManager jsonManager,
	// Object tagObject, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// log.fatal((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.fatal(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// // public static void info(Logger log, JsonManager jsonManager,
	// // Object tagObject, String informationPrefixString,
	// // Object informationObject) {
	// // // if (!HttpConstant.LOG) {
	// // // return;
	// // // }
	// // String informationString = informationPrefixString
	// // + getStringFromObject(jsonManager, informationObject);
	// // if (tagObject instanceof String) {
	// // log.info((String) tagObject + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // } else {
	// // log.info(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// // + informationString);
	// // }
	// // }
	//
	// public static void warn(Logger log, JsonManager jsonManager,
	// Object tagObject, String informationPrefixString,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = informationPrefixString
	// + getStringFromObject(jsonManager, informationObject);
	// if (tagObject instanceof String) {
	// log.warn((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.warn(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void error(Logger log, JsonManager jsonManager,
	// Object tagObject, String informationPrefixString,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = informationPrefixString
	// + getStringFromObject(jsonManager, informationObject);
	// if (tagObject instanceof String) {
	// log.error((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.error(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void debug(Logger log, JsonManager jsonManager,
	// Object tagObject, String informationPrefixString,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = informationPrefixString
	// + getStringFromObject(informationObject);
	// if (tagObject instanceof String) {
	// log.debug((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.debug(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// private void debug(Logger log, JsonManager jsonManager,String
	// debugString) {
	// log
	// }
	//
	// public static void fatal(Logger log, JsonManager jsonManager,
	// Object tagObject, String informationPrefixString,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = informationPrefixString
	// + getStringFromObject(jsonManager, informationObject);
	// if (tagObject instanceof String) {
	// log.fatal((String) tagObject + HttpConstant.JSON_DIVIDER
	// + informationString);
	// } else {
	// log.fatal(tagObject.getClass() + HttpConstant.JSON_DIVIDER
	// + informationString);
	// }
	// }
	//
	// public static void systemOut(JsonManager jsonManager, Object tagObject,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// System.out.println(((String) tagObject) + "--" + informationString);
	// // ;
	// } else {
	// System.out.println(("" + tagObject.getClass()) + "--"
	// + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// }
	//
	// public static void systemOut(JsonManager jsonManager,
	// Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// // if (informationObject instanceof String) {
	// System.out.println(informationString);
	// // ;
	// // } else {
	// // System.out.println(("" + informationObject.getClass()) + "--"
	// // + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// // }
	// }
	//
	// public static void systemOut(JsonManager jsonManager, Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(jsonManager,
	// informationObject);
	// if (tagObject instanceof String) {
	// System.out.println(((String) tagObject) + "--"
	// + informationPrefixString + ":" + informationString);
	// // ;
	// } else {
	// System.out.println(("" + tagObject.getClass()) + "--"
	// + informationPrefixString + ":" + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// }
	//
	// public static void fileOut(Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// String informationString = getStringFromObject(informationObject);
	// if (tagObject instanceof String) {
	// fileOut(((String) tagObject) + "--" + informationPrefixString + ":"
	// + informationString);
	// // ;
	// } else {
	// fileOut(("" + tagObject.getClass()) + "--"
	// + informationPrefixString + ":" + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// }
	//
	// public static void fileOut(Object informationObject) {
	// String informationString = getStringFromObject(informationObject);
	// File file = new File(AppLibConstant.getLogFilePath());
	// if (file.exists() == false) {
	// try {
	// file.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// DataOutputStream dos = null;
	// try {
	// dos = new DataOutputStream(new FileOutputStream(file, true));
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss  ");
	// String time = sdf.format(new Date());
	// dos.writeUTF(time);
	// dos.writeUTF(informationString + "\r\n");
	// dos.flush();
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// if (dos != null) {
	// try {
	// dos.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// dos = null;
	// }
	// }
	// }
}