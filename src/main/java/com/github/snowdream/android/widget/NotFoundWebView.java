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

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
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
	private String script = null;

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
		if (context == null) {
			return;
		}

		// enable JavaScript
		WebSettings settings = this.getSettings();
		settings.setJavaScriptEnabled(true);

		// init attrs
		TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.CustomWebView);

		try {
			int type = a.getInteger(R.styleable.CustomWebView_type, 0);
			switch (type) {
			case 0:
				script = context.getString(R.string.html_notfound);
				break;
			case 1:
				script = context.getString(R.string.html_qq_narrow);
				break;
			case 2:
				script = context.getString(R.string.html_qq_narrow);
				break;
			case 3:
				script = context.getString(R.string.html_qq_wide);
				break;
			case 4:
				script = context.getString(R.string.html_yibo);
				break;
			default:
				script = a.getString(R.styleable.CustomWebView_script);
				break;
			}
		} finally {
			a.recycle();
		}
	}

	private void showNotFoundPage() {
		String html = getNotFoundPageHtml();
		this.loadData(html, "text/html", "UTF-8");
	}

	private String getNotFoundPageHtml() {
		String body = "";

		if (script != null && script != "") {
			body = script;
		}

		return HtmlUtil.getHtml(body);
	}

	@Override
	public void loadUrl(String url) {
		new loadUrlTask().execute(url);
	}

	private void loadSuperUrl(String url) {
		super.loadUrl(url);
	}

	@SuppressLint("NewApi")
	@Override
	public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
		new loadUrlTask().execute(url, additionalHttpHeaders);
	}

	@SuppressLint("NewApi")
	private void loadSuperUrl(String url,
			Map<String, String> additionalHttpHeaders) {
		super.loadUrl(url, additionalHttpHeaders);
	}

	/**
	 * Check the status code
	 * 
	 * @param url
	 * @return status code
	 */
	private int getRespStatus(String url) {
		int status = -1;
		try {
			HttpHead head = new HttpHead(url);
			HttpClient client = new DefaultHttpClient();
			HttpResponse resp = client.execute(head);
			status = resp.getStatusLine().getStatusCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	private class loadUrlTask extends AsyncTask<Object, Void, Void> {

		@SuppressWarnings("unchecked")
		@Override
		protected Void doInBackground(Object... params) {
			if (params == null || params.length < 1) {
				return null;
			}
			String url = null;
			Map<String, String> additionalHttpHeaders = null;

			if (params.length > 0) {
				url = (String) params[0];
			}

			if (params.length > 1) {
				additionalHttpHeaders = (Map<String, String>) params[1];
			}

			if (url == null || url == "") {
				return null;
			}

			if (getRespStatus(url) == HttpStatus.SC_NOT_FOUND) {
				showNotFoundPage();
			}else {
				if (additionalHttpHeaders != null) {
					loadSuperUrl(url, additionalHttpHeaders);
				}else {
					loadSuperUrl(url);
				}
			}

			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
		}

	}
}
