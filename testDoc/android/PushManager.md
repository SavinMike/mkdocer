### PushManager <a name="PushManager"></a>
 Push notifications manager.

 
```
@Deprecated
public class PushManager 
```
---
### REGISTER_EVENT <a name="REGISTER_EVENT"></a>
 BaseRegistrationReceiver intent extra key. Indicates successful push registration. Push token is stored in intent extras under this key.

```
public static final String REGISTER_EVENT = "REGISTER_EVENT"
```
---
### REGISTER_ERROR_EVENT <a name="REGISTER_ERROR_EVENT"></a>
 BaseRegistrationReceiver intent extra key. Indicates unsuccessful push registration. Error description is stored in intent extras under this key.

```
public static final String REGISTER_ERROR_EVENT = "REGISTER_ERROR_EVENT"
```
---
### UNREGISTER_EVENT <a name="UNREGISTER_EVENT"></a>
 BaseRegistrationReceiver intent extra key. Indicates successful push unregistration. Push token is stored in intent extras under this key.

```
public static final String UNREGISTER_EVENT = "UNREGISTER_EVENT"
```
---
### UNREGISTER_ERROR_EVENT <a name="UNREGISTER_ERROR_EVENT"></a>
 BaseRegistrationReceiver intent extra key. Indicates successful push registration. Error description is stored in intent extras under this key.

```
public static final String UNREGISTER_ERROR_EVENT = "UNREGISTER_ERROR_EVENT"
```
---
### PUSH_RECEIVE_EVENT <a name="PUSH_RECEIVE_EVENT"></a>
 Intent extra key for push notification payload. Is added to intent that starts Activity when push notification is clicked.

```
public static final String PUSH_RECEIVE_EVENT = Pushwoosh.PUSH_RECEIVE_EVENT
```
---
### REGISTER_BROAD_CAST_ACTION <a name="REGISTER_BROAD_CAST_ACTION"></a>
 Intent filter action for BaseRegistrationReceiver.

```
public static final String REGISTER_BROAD_CAST_ACTION = "com.pushwoosh.REGISTER_BROAD_CAST_ACTION"
```
---
### PUSH_HISTORY_CAPACITY <a name="PUSH_HISTORY_CAPACITY"></a>
  Maximum number of notifications returned by [PushManager#getPushHistory()](PushManager.md#getPushHistory())

```
public static final int PUSH_HISTORY_CAPACITY = Pushwoosh.PUSH_HISTORY_CAPACITY
```
---
###  <a name=""></a>
 Initializes push manager. Private.

 
* **context** - context
```
private PushManager(Context context) 
```
---
### initializePushManager(Context, String, String) <a name="initializePushManager(Context,String,String)"></a>
 Init push manager with Pushwoosh App ID and Project ID for GCM.
 Use either this function or place the values in AndroidManifest.xml as per documentation.

   
* **context** - context
* **appId** - Pushwoosh Application ID
* **projectId** - ProjectID from Google GCM
```
public static void initializePushManager(Context context, String appId, String projectId) 
```
---
### getInstance(Context) <a name="getInstance(Context)"></a>
 Returns current instance of PushManager. Can return null if Project ID or Pushwoosh App Id not given.

 
* **context** - context
```
public static PushManager getInstance(Context context) 
```
---
### onStartup(Context) <a name="onStartup(Context)"></a>
  
* **context** - context
```
public void onStartup(Context context) throws Exception 
```
---
### getBadgeNumber() <a name="getBadgeNumber()"></a>
 
 
* **Return Value** - current application badge number
```
public int getBadgeNumber() 
```
---
### setBadgeNumber(int) <a name="setBadgeNumber(int)"></a>
 Set application badge number

 
 
* **newBadge** - applicaton icon badge number
```
public void setBadgeNumber(int newBadge) 
```
---
### addBadgeNumber(int) <a name="addBadgeNumber(int)"></a>
 Increment/decrement application badge number

 
 
* **deltaBadge** - applicaton icon badge number addition
```
public void addBadgeNumber(int deltaBadge) 
```
---
### startTrackingGeoPushes() <a name="startTrackingGeoPushes()"></a>
 Starts tracking Geo Push Notifications

 

```
@RequiresPermission(allOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
public void startTrackingGeoPushes() 
```
---
### startTrackingGeoPushes(Context) <a name="startTrackingGeoPushes(Context)"></a>
 Starts tracking Geo Push Notifications

 
 
* **context** - context
```
@RequiresPermission(allOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
public static void startTrackingGeoPushes(Context context) 
```
---
### stopTrackingGeoPushes() <a name="stopTrackingGeoPushes()"></a>
 Stop tracking Geo Push Notifications

 
```
public void stopTrackingGeoPushes() 
```
---
### stopTrackingGeoPushes(Context) <a name="stopTrackingGeoPushes(Context)"></a>
 Stop tracking Geo Push Notifications

 
 
* **context** - context
```
public static void stopTrackingGeoPushes(Context context) 
```
---
### startTrackingBeaconPushes() <a name="startTrackingBeaconPushes()"></a>
 Starts tracking Beacon Push Notifications

 
```
public void startTrackingBeaconPushes() 
```
---
### stopTrackingBeaconPushes() <a name="stopTrackingBeaconPushes()"></a>
 Stop tracking Beacon Push Notifications

 
```
public void stopTrackingBeaconPushes() 
```
---
### getPushwooshHWID(Context) <a name="getPushwooshHWID(Context)"></a>
 Gets Pushwoosh HWID. Unique device identifier that is used in API communication with Pushwoosh.

 
```
public static String getPushwooshHWID(Context context) 
```
---
### getPushToken(Context) <a name="getPushToken(Context)"></a>
 Gets push notification token. May be null if not registered for push notifications yet.

 
```
public static String getPushToken(Context context) 
```
---
### registerForPushNotifications() <a name="registerForPushNotifications()"></a>
 Registers for push notifications.

 
```
public void registerForPushNotifications() 
```
---
### unregisterForPushNotifications() <a name="unregisterForPushNotifications()"></a>
 Unregister from push notifications

 
```
public void unregisterForPushNotifications() 
```
---
### getCustomData(Bundle) <a name="getCustomData(Bundle)"></a>
 Get push notification user data

 
 
* **Return Value** - string user data, or null
```
public String getCustomData(Bundle pushBundle) 
```
---
### sendTags(Context, Map, SendPushTagsCallBack) <a name="sendTags(Context,Map,SendPushTagsCallBack)"></a>
 Send tags asynchronously

 
   
* **context** - context
* **tags** - tags to send. Value can be String or Integer only - if not Exception will be thrown
* **listener** - execute result callback
```
public static void sendTags(final Context context, final Map<String, Object> tags, final SendPushTagsCallBack listener) 
```
---
### GetTagsListener <a name="GetTagsListener"></a>
 Get tags listener.

 
```
public interface GetTagsListener 
```
---
### onTagsReceived(Map) <a name="onTagsReceived(Map)"></a>
 Called when tags received

 
* **tags** - received tags map
```
public void onTagsReceived(Map<String, Object> tags)
```
---
### onError(Exception) <a name="onError(Exception)"></a>
 Called when request failed

 
* **e** - Exception
```
public void onError(Exception e)
```
---
### getTagsAsync(Context, GetTagsListener) <a name="getTagsAsync(Context,GetTagsListener)"></a>
 Get tags from Pushwoosh service asynchronously

 
  
* **Return Value** - tags, or null
```
public static void getTagsAsync(final Context context, final GetTagsListener listener) 
```
---
### trackInAppRequest(Context, String, BigDecimal, String, Date) <a name="trackInAppRequest(Context,String,BigDecimal,String,Date)"></a>
 Track in-app purchase

 
     
* **sku** - purchased product ID
* **price** - price for the product
* **currency** - currency of the price (ex: "USD")
* **purchaseTime** - time of the purchase (ex: new Date())
```
public static void trackInAppRequest(final Context context, final String sku, final BigDecimal price, final String currency, final Date purchaseTime) 
```
---
### getLaunchNotification() <a name="getLaunchNotification()"></a>
 Returns launch notification if the app was started in response to push notification

 
 
* **Return Value** - string-formatted JSON payload of launch push notification
```
public String getLaunchNotification() 
```
---
### clearLaunchNotification() <a name="clearLaunchNotification()"></a>
 Enforces getLaunchNotification() to return null for whatever reason

 

```
public void clearLaunchNotification() 
```
---
### RichPageListener <a name="RichPageListener"></a>
 Rich page listener.

 
```
public interface RichPageListener 
```
---
### onRichPageAction(String) <a name="onRichPageAction(String)"></a>
 Called when rich page button has been tapped

 
* **actionParams** - params as specified in the Control Panel
```
public void onRichPageAction(String actionParams)
```
---
### onRichPageClosed() <a name="onRichPageClosed()"></a>
 Called when rich page has been closed

```
public void onRichPageClosed()
```
---
### setRichPageListener(RichPageListener) <a name="setRichPageListener(RichPageListener)"></a>
 Sets current active rich page action listener

 
 
```
public void setRichPageListener(RichPageListener listener) 
```
---
### setUserId(Context, String) <a name="setUserId(Context,String)"></a>
 Set User indentifier. This could be Facebook ID, username or email, or any other user ID.
 This allows data and events to be matched across multiple user devices.

 
  
* **context** - context
* **userId** - user id
```
public void setUserId(final Context context, final String userId) 
```
---
### MergeUserCallback <a name="MergeUserCallback"></a>
 
```
public interface MergeUserCallback 
```
---
### mergeUserId(String, String, boolean, MergeUserCallback) <a name="mergeUserId(String,String,boolean,MergeUserCallback)"></a>
 Move all event statistics from oldUserId to newUserId if doMerge is true. If doMerge is false all events for oldUserId are removed.

 
    
* **oldUserId** - source user identifier
* **newUserId** - destination user identifier
* **doMerge** - merge/remove events for source user identifier
* **callback** - method completion callback
```
public void mergeUserId(String oldUserId, String newUserId, boolean doMerge, final MergeUserCallback callback) 
```
---
### setMultiNotificationMode(Context) <a name="setMultiNotificationMode(Context)"></a>
 
 
* **context** - context
```
public static void setMultiNotificationMode(Context context) 
```
---
### setSimpleNotificationMode(Context) <a name="setSimpleNotificationMode(Context)"></a>
 
 
* **context** - context
```
public static void setSimpleNotificationMode(Context context) 
```
---
### setSoundNotificationType(Context, SoundType) <a name="setSoundNotificationType(Context,SoundType)"></a>
 
  
* **context** - context
* **soundNotificationType** - sound type
```
public static void setSoundNotificationType(Context context, SoundType soundNotificationType) 
```
---
### setVibrateNotificationType(Context, VibrateType) <a name="setVibrateNotificationType(Context,VibrateType)"></a>
 
  
* **context** - context
* **vibrateNotificationType** - vibrate type
```
public static void setVibrateNotificationType(Context context, VibrateType vibrateNotificationType) 
```
---
### setLightScreenOnNotification(Context, boolean) <a name="setLightScreenOnNotification(Context,boolean)"></a>
 
  
* **context** - context
* **lightsOn** - enable
```
public static void setLightScreenOnNotification(Context context, boolean lightsOn) 
```
---
### setEnableLED(Context, boolean) <a name="setEnableLED(Context,boolean)"></a>
 
  
* **context** - context
* **ledOn** - enable
```
public static void setEnableLED(Context context, boolean ledOn) 
```
---
### setColorLED(Context, int) <a name="setColorLED(Context,int)"></a>
 
  
* **context** - context
* **color** - led color
```
public static void setColorLED(Context context, int color) 
```
---
### setNotificationIconBackgroundColor(Context, int) <a name="setNotificationIconBackgroundColor(Context,int)"></a>
 
  
* **context** - context
* **color** - background color
```
public static void setNotificationIconBackgroundColor(Context context, int color) 
```
---
### setBeaconBackgroundMode(Context, boolean) <a name="setBeaconBackgroundMode(Context,boolean)"></a>
 
  
* **context** - context
* **backgroundMode** - enable
```
public static void setBeaconBackgroundMode(Context context, boolean backgroundMode) 
```
---
### scheduleLocalNotification(Context, String, int) <a name="scheduleLocalNotification(Context,String,int)"></a>
 Schedules a local notification

 
    
* **context** - context
* **message** - notification message
* **seconds** - delay (in seconds) until the message will be sent
* **Return Value** - local notification id
```
public static int scheduleLocalNotification(Context context, String message, int seconds) 
```
---
### scheduleLocalNotification(Context, String, Bundle, int) <a name="scheduleLocalNotification(Context,String,Bundle,int)"></a>
 Schedules a local notification with extras
 <p>
 Extras parameters:
 title - message title, same as message parameter
 l - link to open when notification has been tapped
 b - banner URL to show in the notification instead of text
 u - user data
 i - identifier string of the image from the app to use as the icon in the notification
 ci - URL of the icon to use in the notification

 
     
* **context** - context
* **message** - notification message
* **extras** - notification extras parameters
* **seconds** - delay (in seconds) until the message will be sent
* **Return Value** - local notification id
```
public static int scheduleLocalNotification(Context context, String message, Bundle extras, int seconds) 
```
---
### clearLocalNotification(Context, int) <a name="clearLocalNotification(Context,int)"></a>
 Removes scheduled local notification with given id

 
  
* **context** - context
* **id** - local notification id
```
public static void clearLocalNotification(Context context, int id) 
```
---
### clearLocalNotifications(Context) <a name="clearLocalNotifications(Context)"></a>
 Removes all scheduled local notifications

 
 
* **context** - context
```
public static void clearLocalNotifications(Context context) 
```
---
### clearNotificationCenter(Context) <a name="clearNotificationCenter(Context)"></a>
 Removes all notifications from the tray

 
 
* **context** - context
```
public static void clearNotificationCenter(Context context) 
```
---
###  <a name=""></a>
 
  
* **value** - incremental value
* **Return Value** - tag
```
public static Map<String, Object> incrementalTag(Integer value) 
```
---
### getPushHistory() <a name="getPushHistory()"></a>
 Gets push history.

 
  Maximum of PUSH_HISTORY_CAPACITY pushes are returned

* **Return Value** - Array of strings: JSON payload of each push
```
public ArrayList<String> getPushHistory() 
```
---
### clearPushHistory() <a name="clearPushHistory()"></a>
 Clears push history. Usually called after getPushHistory

 
```
public void clearPushHistory() 
```
---
