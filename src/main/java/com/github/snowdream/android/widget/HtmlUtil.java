/*******************************************************************************
 * Copyright (C) 2013 Snowdream Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.github.snowdream.android.widget;


/**
 * a Html Util
 *
 * @author snowdream <yanghui1986527@gmail.com>
 * @date 2013-7-11
 * @version v1.0
 */
public class HtmlUtil {
	private static final String HTML_HEAD = "<html><head><title>Not Found!</titile></head><body>";
	private static final String HTML_FOOTER = "</body></html>";
	
	/**
	 * Builder a html webpage from the body,a piece of code which is javascript 
	 * or frame.
	 * 
	 * @param body
	 * @return the html webpage
	 */
	public static String getHtml(String body) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(HTML_HEAD);
		buffer.append(body);
		buffer.append(HTML_FOOTER);
		return buffer.toString();
	}
}
