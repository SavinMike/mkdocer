### PushManagerJSInterface <a name="PushManagerJSInterface"></a>
PushManager inApps javascript interface
 Instance of this class is accessible from inApp javascript sources by using "pushManager" variable
```
public class PushManagerJSInterface
```
---
###  <a name=""></a>
Send /postEvent request
 <p>
 js example:
 ```java
 var successCallback = function () {
 		console.log("Post event success");
 }
 var errorCallback = function (message) {
 		console.log("Post event failed: ", message);
 		alert("Post event failed: " + message);
 }
 pushManager.postEvent(JSON.stringify({
 			"event" : "testEvent",
 			"attributes" : {
 				"TestAttributeString" : "testString",
 				"TestAttributeInt" : 42,
 				"TestAttributeList" : [ 123, 456, "someString" ],
 				"TestAttributeBool" : true,
 				"TestAttributeNull" : null,
 				"TestAttributeDaysAgo" : 7,
 				"TestAttributeDate" : today
 			};,
 			"success" : "successCallback", 	// optional
 			"error" : "errorCallback" 		// optional
 	}));
 
```

    
* **event** - Event name for postEvent request
* **attributes** - Dictionary with attributes to send
* **success** - Success callback function name (optional)
* **error** - Error callback function name (optional)
```
@JavascriptInterface
public void postEvent(String blob)
```
---
###  <a name=""></a>
Closes current In-App
 <p>
 js example:
 ```java
    pushManager.closeInApp();
 
```
```
@JavascriptInterface
public void closeInApp()
```
---
###  <a name=""></a>
send /registerDevice request
 <p>
 js example:
 ```java
    pushManager.registerForPushNotifications();
 
```
```
@JavascriptInterface
public void registerForPushNotifications()
```
---
###  <a name=""></a>
send /sendTags request
 <p>
 js example:
 ```java
    pushManager.sendTags(JSON.stringify({
    	"IntTag" : 42,
    	"BoolTag" : true,
    	"StringTag" : "Test String",
    	"ListTag" : ["string1", "string2"]
    }));
 
```
```
@JavascriptInterface
public void sendTags(String tags)
```
---
