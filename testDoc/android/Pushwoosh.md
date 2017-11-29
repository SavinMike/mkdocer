### Pushwoosh <a name="Pushwoosh"></a>
 Pushwoosh class is used to manage push registration, application tags and local notifications.

 By default Pushwoosh SDK automatically adds following permissions: 

 ${applicationId}.permission.C2D_MESSAGE 

 ${applicationId}.permission.RECEIVE_ADM_MESSAGE 

 [android.permission.ACCESS_NETWORK_STATE](https://developer.android.com/reference/android/Manifest.permission.html#ACCESS_NETWORK_STATE) 

 [android.permission.INTERNET](https://developer.android.com/reference/android/Manifest.permission.html#INTERNET) 

 [android.permission.WAKE_LOCK](https://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK) 

 


 [android.permission.RECEIVE_BOOT_COMPLETED](https://developer.android.com/reference/android/Manifest.permission.html#RECEIVE_BOOT_COMPLETED)
 should be added manually to take advantage of local notification rescheduling after device restart.

```
public class Pushwoosh 
```
---
### PUSH_RECEIVE_EVENT <a name="PUSH_RECEIVE_EVENT"></a>
 Intent extra key for push notification payload. Is added to intent that starts Activity when push notification is clicked.
 


 Example:
 
 ```
{@literal @}Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       if (getIntent().hasExtra(Pushwoosh.PUSH_RECEIVE_EVENT)) {
           // Activity was started in response to push notification
           showMessage("Push message is " + getIntent().getExtras().getString(Pushwoosh.PUSH_RECEIVE_EVENT));
       }
   }
```
 

```
public static final String PUSH_RECEIVE_EVENT = "PUSH_RECEIVE_EVENT"
```
---
### PUSH_HISTORY_CAPACITY <a name="PUSH_HISTORY_CAPACITY"></a>
 Maximum number of notifications returned by [Pushwoosh#getPushHistory()](Pushwoosh.md#getPushHistory())

```
public static final int PUSH_HISTORY_CAPACITY = 16
```
---
### getInstance() <a name="getInstance()"></a>
 
* **Return Value** - Pushwoosh shared instance
```
@NonNull
public static Pushwoosh getInstance() 
```
---
### getAppId() <a name="getAppId()"></a>
 
* **Return Value** - Current Pushwoosh application id
```
public String getAppId() 
```
---
### setAppId(String) <a name="setAppId(String)"></a>
 Associates current applicaton with given pushwoosh application code
 (Alternative for "com.pushwoosh.appid" metadata in AndroidManifest.xml)

 
* **appId** - Pushwoosh application code
```
public void setAppId(@NonNull String appId) 
```
---
### setSenderId(String) <a name="setSenderId(String)"></a>
 Sets FCM/GCM sender Id
 (Alternative for "com.pushwoosh.senderid" metadata in AndroidManifest.xml)

 
* **senderId** - GCM/FCM sender id
```
public void setSenderId(@NonNull String senderId) 
```
---
### getSenderId() <a name="getSenderId()"></a>
 
* **Return Value** - Current GCM/FCM sender id
```
public String getSenderId() 
```
---
### getHwid() <a name="getHwid()"></a>
 
* **Return Value** - Pushwoosh HWID associated with current device
```
@NonNull
public String getHwid() 
```
---
### getPushToken() <a name="getPushToken()"></a>
 
* **Return Value** - Push notification token or null if device is not registered yet.
```
@Nullable
public String getPushToken() 
```
---
### registerForPushNotifications() <a name="registerForPushNotifications()"></a>
 [registerForPushNotifications(Callback)](#registerForPushNotifications(Callback))
```
public void registerForPushNotifications() 
```
---
### registerForPushNotifications(Callback) <a name="registerForPushNotifications(Callback)"></a>
 Registers device for push notifications

 
* **callback** - push registration callback
```
public void registerForPushNotifications(Callback<String, RegisterForPushNotificationsException> callback) 
```
---
### unregisterForPushNotifications() <a name="unregisterForPushNotifications()"></a>
 [unregisterForPushNotifications(Callback)](#unregisterForPushNotifications(Callback))
```
public void unregisterForPushNotifications() 
```
---
### unregisterForPushNotifications(Callback) <a name="unregisterForPushNotifications(Callback)"></a>
 Unregisters device from push notifications

 
* **callback** - push unregister callback
```
public void unregisterForPushNotifications(Callback<String, UnregisterForPushNotificationException> callback) 
```
---
### sendTags(TagsBundle) <a name="sendTags(TagsBundle)"></a>
 [sendTags(TagsBundle, Callback)](#sendTags(TagsBundle,Callback))
```
public void sendTags(@NonNull TagsBundle tags) 
```
---
### sendTags(TagsBundle, Callback) <a name="sendTags(TagsBundle,Callback)"></a>
 Associates device with given tags. If setTags request fails tags will be resent on the next application launch.
 


 Example:
 
 ```java
   pushwoosh.sendTags(Tags.intTag("intTag", 42), (result) -> {
       if (result.isSuccess()) {
           // tags sucessfully sent
       }
       else {
           // failed to send tags
       }
   });
 
```
 

  
* **tags** - [application tags bundle](tags/TagsBundle.md)
* **callback** - sendTags operation callback
```
public void sendTags(@NonNull TagsBundle tags, Callback<Void, PushwooshException> callback) 
```
---
### getTags(Callback) <a name="getTags(Callback)"></a>
 Gets tags associated with current device
 


 Example:
 
 ```java
   pushwoosh.getTags((result) -> {
       if (result.isSuccess()) {
            // tags sucessfully received
            int intTag = result.getInt("intTag");
       }
       else {
           // failed to receive tags
       }
   });
 
```
 

 
* **callback** - callback handler
```
public void getTags(@NonNull Callback<TagsBundle, GetTagsException> callback) 
```
---
### sendInappPurchase(String, BigDecimal, String) <a name="sendInappPurchase(String,BigDecimal,String)"></a>
 Sends In-App purchase statistics. Purchase information is stored in "In-app Product", "In-app Purchase" and "Last In-app Purchase date" default tags.

   
* **sku** - product identifier
* **price** - purchase price
* **currency** - purchase currency
```
public void sendInappPurchase(@NonNull String sku, @NonNull BigDecimal price, @NonNull String currency) 
```
---
### getLaunchNotification() <a name="getLaunchNotification()"></a>
 
* **Return Value** - Launch notification data or null.
```
@Nullable
public PushMessage getLaunchNotification() 
```
---
### clearLaunchNotification() <a name="clearLaunchNotification()"></a>
 reset [#getLaunchNotification()](#getLaunchNotification()) to return null.

```
public void clearLaunchNotification() 
```
---
### scheduleLocalNotification(LocalNotification) <a name="scheduleLocalNotification(LocalNotification)"></a>
 Schedules local notification.
 


 Example:
 
 ```java
   LocalNotification notification = new LocalNotification.Builder().setMessage("Local notification content")
 			  .setDelay(seconds)
 			  .build();
   LocalNotificationRequest request = Pushwoosh.getInstance().scheduleLocalNotification(notification);
 
```
 

  
* **notification** - [notification](notification/LocalNotification.md) to send
* **Return Value** - [local notification request](notification/LocalNotificationRequest.md)
```
@NonNull
public LocalNotificationRequest scheduleLocalNotification(LocalNotification notification) 
```
---
### getPushHistory() <a name="getPushHistory()"></a>
 Gets push notification history. History contains both remote and local notifications.

 
* **Return Value** - Push history as List of [#PUSH_HISTORY_CAPACITY](#PUSH_HISTORY_CAPACITY). Maximum of [#PUSH_HISTORY_CAPACITY](#PUSH_HISTORY_CAPACITY) pushes are returned
```
@NonNull
public List<PushMessage> getPushHistory() 
```
---
### clearPushHistory() <a name="clearPushHistory()"></a>
 Clears push history. Usually called after [#getPushHistory()](#getPushHistory()).

```
public void clearPushHistory() 
```
---
