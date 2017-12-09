### PushwooshInApp <a name="PushwooshInApp"></a>
PushwooshInApp is responsible for In-App messages functionality.

 {http://docs.pushwoosh.com/docs/in-app-messages}
```
public class PushwooshInApp
```
---
###  <a name=""></a>

* **Return Value** - PushwooshInApp shared instance.
```
@NonNull
public static PushwooshInApp getInstance()
```
---
### postEvent(String) <a name="postEvent(String)"></a>
[#postEvent(String, TagsBundle, Callback)](#postEvent(String,TagsBundle,Callback))
```
public void postEvent(@NonNull String event)
```
---
### postEvent(String, TagsBundle) <a name="postEvent(String,TagsBundle)"></a>
[#postEvent(String, TagsBundle, Callback)](#postEvent(String,TagsBundle,Callback))
```
public void postEvent(@NonNull String event, TagsBundle attributes)
```
---
### postEvent(String, TagsBundle, Callback) <a name="postEvent(String,TagsBundle,Callback)"></a>
Post events for In-App Messages. This can trigger In-App message HTML as specified in Pushwoosh Control Panel.

   
* **event** - name of the event
* **attributes** - additional event attributes
* **callback** - method completion callback
```
public void postEvent(@NonNull String event, @Nullable TagsBundle attributes, Callback<Void, PostEventException> callback)
```
---
### setUserId(String) <a name="setUserId(String)"></a>
Set User indentifier. This could be Facebook ID, username or email, or any other user ID.
 This allows data and events to be matched across multiple user devices.

 
* **userId** - user identifier
```
public void setUserId(@NonNull String userId)
```
---
### mergeUserId(String, String, boolean, Callback) <a name="mergeUserId(String,String,boolean,Callback)"></a>
Move all event statistics from oldUserId to newUserId if doMerge is true. If doMerge is false all events for oldUserId are removed.

    
* **oldUserId** - source user identifier
* **newUserId** - destination user identifier
* **doMerge** - merge/remove events for source user identifier
* **callback** - method completion callback
```
public void mergeUserId(@NonNull String oldUserId, @NonNull String newUserId, boolean doMerge, @Nullable Callback<Void, MergeUserException> callback)
```
---
### addJavascriptInterface(Object, String) <a name="addJavascriptInterface(Object,String)"></a>
Add JavaScript interface for In-Apps extension. All exported methods should be marked with @JavascriptInterface annotation.

  
* **object** - java object that will be available inside In-App page
* **name** - specified object will be available as window.`name`
```
public void addJavascriptInterface(@NonNull Object object, @NonNull String name)
```
---
### removeJavascriptInterface(String) <a name="removeJavascriptInterface(String)"></a>
Removes object registered with [#addJavascriptInterface(Object, String)](#addJavascriptInterface(Object,String))

 
* **name** - object name
```
public void removeJavascriptInterface(@NonNull String name)
```
---
### registerJavascriptInterface(String, String) <a name="registerJavascriptInterface(String,String)"></a>
Same as [#addJavascriptInterface(Object, String)](#addJavascriptInterface(Object,String)) but uses class name instead of object
```
public void registerJavascriptInterface(@NonNull String className, @NonNull String name)
```
---
