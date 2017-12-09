### NotificationFactory <a name="NotificationFactory"></a>
Abstract class that is used to customize push notification appearance.
 All NotificationFactory ancestors must be public and must contain public constructor without parameters.
 Application will crash on startup if this requirement is not met.
 Custom NotificationFactory should be registered in AndroidManifest.xml metadata as follows:
 <p>
 ```
{@literal <}meta-data
             android:name="com.pushwoosh.notification_factory"
             android:value="com.your.package.YourNotificationFactory"{@literal /}{@literal >}
```
```
public abstract class NotificationFactory
```
---
###  <a name=""></a>
Generates notification using PushMessage data.

  
* **data** - notification data
* **Return Value** - Notification to show
```
@WorkerThread
@Nullable
public abstract Notification onGenerateNotification(@NonNull PushMessage data)
```
---
###  <a name=""></a>
 
* **data** - notification data
* **Return Value** - Intent to start when user clicks on notification
```
@NonNull
public Intent getNotificationIntent(@NonNull PushMessage data)
```
---
### addCancel(Notification) <a name="addCancel(Notification)"></a>
Makes notification cancellable

 
* **notification** - push notification
```
protected final void addCancel(@NonNull Notification notification)
```
---
###  <a name=""></a>
Adds led blinking to notification

    
* **notification** - push notification
* **color** - led color
* **ledOnMs** - led on duration in ms
* **ledOffMs** - led off duration in ms
```
@SuppressWarnings("WeakerAccess")
protected final void addLED(@NonNull Notification notification, @Nullable Integer color, int ledOnMs, int ledOffMs)
```
---
### addVibration(Notification, boolean) <a name="addVibration(Notification,boolean)"></a>
Adds vibration to notification.

  
* **notification** - push notification
* **vibration** - vibration setting
```
protected final void addVibration(@NonNull Notification notification, boolean vibration)
```
---
### addSound(Notification, String) <a name="addSound(Notification,String)"></a>
Adds sound to notification.

                       If parameter is null or does not exists default system sound will be played.
                     If parameter is empty no sound will be played
* **notification** - push notification
* **sound** - resource from res/raw or assets/www/res directory.
```
protected final void addSound(@NonNull Notification notification, @Nullable String sound)
```
---
###  <a name=""></a>

* **Return Value** - Application context.
```
@Nullable
protected final Context getApplicationContext()
```
---
### getContentFromHtml(String) <a name="getContentFromHtml(String)"></a>
Converts string with html formatting to CharSequence.

  
* **content** - push notification message
* **Return Value** - html formatted notification content
```
protected final CharSequence getContentFromHtml(String content)
```
---
###  <a name=""></a>
Create, if not exist, new notification channel from pushMessage.

  
* **pushMessage** - if push message doesn't contain "pw_channel" attribute, default channel will be created
* **Return Value** - channel id which connected with channel name. For Api less than 26 it doesn't create anything
```
@SuppressWarnings("WeakerAccess")
protected String addChannel(PushMessage pushMessage)
```
---
