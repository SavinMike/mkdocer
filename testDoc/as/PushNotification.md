### PushNotification() <a name="PushNotification()"></a>
Constructor. Do not call directly. Use [getInstance()](getInstance()) method.
 ```
var pushwoosh:PushNotification = PushNotification.getInstance();
```
```
public function PushNotification()
```
---
### scheduleLocalNotification(int, String) <a name="scheduleLocalNotification(int,String)"></a>
Schedules local notification

  
 Example:
 ```
pushwoosh.scheduleLocalNotification(30, "{\"alertBody\": \"Time to collect coins!\",
	    	    		\"alertAction\":\"Collect!\", \"soundName\":\"sound.caf\", \"badge\": 5, \"custom\": {\"a\":\"json\"}}");
```
* **seconds** - delay for the local notification in seconds
* **alertJson** - JSON with the local notification
```
public function scheduleLocalNotification(seconds:int, alertJson:String):int
```
---
### clearLocalNotifications() <a name="clearLocalNotifications()"></a>
Removes all local notifications
```
public function clearLocalNotifications():void
```
---
### clearLocalNotification(int) <a name="clearLocalNotification(int)"></a>
Android only: removes local notification with given id
```
public function clearLocalNotification(id:int):void
```
---
### isPushNotificationSupported() <a name="isPushNotificationSupported()"></a>
Checks if push notifications supported on the platform
```
public function get isPushNotificationSupported():Boolean
```
---
### onDeviceReady() <a name="onDeviceReady()"></a>
Call this after all the callbacks have been set

 Example:
 ```
var pushwoosh:PushNotification = PushNotification.getInstance();
	    	    pushwoosh.addEventListener(PushNotificationEvent.PERMISSION_GIVEN_WITH_TOKEN_EVENT, onToken);
	    	    pushwoosh.addEventListener(PushNotificationEvent.PERMISSION_REFUSED_EVENT, onError);
	    	    pushwoosh.addEventListener(PushNotificationEvent.PUSH_NOTIFICATION_RECEIVED_EVENT, onPushReceived);
	    	    pushwoosh.addEventListener(PushNotificationEvent.PUSH_NOTIFICATION_OPENED_EVENT, onPushOpened);

	    	    pushwoosh.onDeviceReady();

	    	    pushwoosh.registerForPushNotification();
```
```
public function onDeviceReady():void
```
---
### getPushToken() <a name="getPushToken()"></a>
Returns push token if available. May return null.
```
public function getPushToken():String
```
---
### getPushwooshHWID() <a name="getPushwooshHWID()"></a>
Returns unique identifier of the device
```
public function getPushwooshHWID():String
```
---
### registerForPushNotification() <a name="registerForPushNotification()"></a>
Registers for push notifications
```
public function registerForPushNotification() : void
```
---
### startBeaconPushes() <a name="startBeaconPushes()"></a>
Starts beacons tracking
```
public function startBeaconPushes() : void
```
---
### stopBeaconPushes() <a name="stopBeaconPushes()"></a>
Stops beacons tracking
```
public function stopBeaconPushes() : void
```
---
### setBeaconBackgroundMode(Boolean) <a name="setBeaconBackgroundMode(Boolean)"></a>
Android only: notifies that app goes into background for iBeacon tracking
```
public function setBeaconBackgroundMode(value:Boolean) : void
```
---
### setBadgeNumberValue(int) <a name="setBadgeNumberValue(int)"></a>
Sets the app icon badge value
```
public function setBadgeNumberValue(value:int):void
```
---
### setMultiNotificationMode() <a name="setMultiNotificationMode()"></a>
Android only: enables multiple notification in the notification center
```
public function setMultiNotificationMode():void
```
---
### setSimpleNotificationMode() <a name="setSimpleNotificationMode()"></a>
Android only: enables single notification only in the notification center
```
public function setSimpleNotificationMode():void
```
---
### setSoundType(int) <a name="setSoundType(int)"></a>
Android only: sets sound type for push notifications.
 
* **value** - 0 - default, 1 - no sound, 2 - always
```
public function setSoundType(value:int):void
```
---
### setVibrateType(int) <a name="setVibrateType(int)"></a>
Android only: sets vibration type for push notifications.
 
 Make sure you add [VIBRATE](https://developer.android.com/reference/android/Manifest.permission.html#VIBRATE) permission to AndroidManifest.xml
* **value** - 0 - default, 1 - no vibration, 2 - always
```
public function setVibrateType(value:int):void
```
---
### setEnableLed(Boolean) <a name="setEnableLed(Boolean)"></a>
Android only: enables led blinking when push notification arrives
```
public function setEnableLed(value:Boolean):void
```
---
### startGeoPushes() <a name="startGeoPushes()"></a>
Starts Geo-location based push notifications.
```
public function startGeoPushes():void
```
---
### stopGeoPushes() <a name="stopGeoPushes()"></a>
Stops Geo-location based push notifications
```
public function stopGeoPushes():void
```
---
### setIntTag(String, int) <a name="setIntTag(String,int)"></a>
Sets integer tag on a device

  
* **name** - is the name of the tag
* **value** - is the value of the tag
```
public function setIntTag(name:String, value:int):void
```
---
### setStringTag(String, String) <a name="setStringTag(String,String)"></a>
Sets string tag on a device

  
* **name** - is the name of the tag
* **value** - is the value of the tag
```
public function setStringTag(name:String, value:String):void
```
---
### getTags(Function, Function) <a name="getTags(Function,Function)"></a>
Returns tags

  
 Example:
 ```
pushwoosh.getTags(function(tags:Object) {
				trace("Application tags: " + JSON.stringify(tags));
			},
			function(error:String) {
				trace("Failed to get tags: " + error);
			}
		);
```
* **success** - success callback
* **error** - error callback
```
public function getTags(success:Function, error:Function):void
```
---
### unregisterFromPushNotification() <a name="unregisterFromPushNotification()"></a>
Unregisters the device from push notifications
```
public function unregisterFromPushNotification():void
```
---
### sendPurchase(String, Number, String) <a name="sendPurchase(String,Number,String)"></a>
Send purchase information.
 This will set default tags "In-app Product", "In-app Purchase" and "Last In-app Purchase date"

   
* **productId** - identifier of purchased product
* **price** - product price
* **currency** - currency for price number
```
public function sendPurchase(productId:String, price:Number, currency:String):void
```
---
### setUserId(String) <a name="setUserId(String)"></a>
Set User indentifier. This could be Facebook ID, username or email, or any other user ID.
 This allows data and events to be matched across multiple user devices.
```
public function setUserId(userId:String):void
```
---
### postEvent(String, Object) <a name="postEvent(String,Object)"></a>
Post events for In-App Messages. This can trigger In-App message display as specified in Pushwoosh Control Panel.

 Example:
 ```
pushwoosh.postEvent("buttonPressed", { "buttonNumber" : "4", "buttonLabel" : "Banner" } );
```
```
public function postEvent(eventId:String, attributes:Object):void
```
---
### getInstance() <a name="getInstance()"></a>

* **Return Value** - instance of PushNotification
```
public static function getInstance() : PushNotification
```
---
