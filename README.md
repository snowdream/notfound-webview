#notfound-webview

##Introduction
Thousands of children go missing every year all over the world. Thanks to the notfound-webview project, you can make a difference.When you use webview,if you get an error 404,then you can show the information to help finding the missing children.

##Screenshots
![preview.png](preview.png "notfound-webview")

##Download
Download [the latest aar][1] or grab via Maven:

```xml
<dependency>
  <groupId>com.github.snowdream.android.widget</groupId>
  <artifactId>notfound-webview</artifactId>
  <version>0.0.3</version>
  <type>aar</type>
</dependency>
```

##Usage
Import the library with maven,Then define your custom webview widget in the layout file(like activity_main.xml).
```xml
<com.github.snowdream.android.widget.NotFoundWebView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/webview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:type="qq" />
```
app:type can select the following values:  
[notfound][2]  
[qq][3]    
[qq_wide][3]    
[qq_narrow][3]    
[yibo][4]    

Then in the activity,load the url address as usual.If you get an error 404,Then the webview will show show the information to help finding the missing children.

```java
NotFoundWebView webView = (NotFoundWebView)findViewById(R.id.webview);
webView.setWebViewClient(new WebViewClient());
webView.loadUrl("http://www.checkupdown.com/InvalidPage.html");
```

##License
```
 Copyright (C) 2013 Snowdream Mobile
  
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
  
 http://www.apache.org/licenses/LICENSE-2.0
  
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
[![Build Status](https://travis-ci.org/snowdream/notfound-webview.png?branch=master)](https://travis-ci.org/snowdream/notfound-webview)

[1]:https://oss.sonatype.org/content/groups/public/com/github/snowdream/android/widget/notfound-webview/0.0.3/notfound-webview-0.0.3.aar
[2]:http://notfound.org/
[3]:http://www.qq.com/404/
[4]:http://yibo.iyiyun.com/