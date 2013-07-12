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

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * A Webview when 404 errors occour,will show the public service advertisement.
 * 
 * @author snowdream <yanghui1986527@gmail.com>
 * @date 2013-7-9
 * @version v1.0
 */
public class NotFoundWebView extends WebView {

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public NotFoundWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public NotFoundWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	/**
	 * @param context
	 */
	public NotFoundWebView(Context context) {
		super(context);
		init(context, null, 0);
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void init(Context context, AttributeSet attrs, int defStyle) {
		WebSettings settings = this.getSettings();
		settings.setJavaScriptEnabled(true);
	}

	public void showNotFoundPage() {
		String html = getNotFoundPageHtml();
		this.loadData(html, "text/html", "UTF-8");
	}

	private String getNotFoundPageHtml() {
		String body ="";

		return HtmlUtil.getHtml(body);
	}
}
