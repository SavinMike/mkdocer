### NotificationServiceExtension <a name="NotificationServiceExtension"></a>
NotificationServiceExtension allows to customize push notification behaviour.
 All NotificationServiceExtension ancestors must be public and must contain public constructor without parameters.
 Application will crash on startup if this requirement is not met.
 Custom NotificationServiceExtension should be registered in AndroidManifest.xml metadata as follows:
 <p>
 ```
{@literal <}meta-data
             android:name="com.pushwoosh.notification_service_extension"
             android:value="com.your.package.YourNotificationServiceExtension"{@literal /}{@literal >}
```
```
public class NotificationServiceExtension
```
---
###  <a name=""></a>
Handles push arrival.

 
* **pushBundle** - push notification payload as Bundle
```
@WorkerThread
public final void handleMessage(Bundle pushBundle)
```
---
### handleNotification(Bundle) <a name="handleNotification(Bundle)"></a>
Handles notification open.

 
* **pushBundle** - push notification payload as Bundle
```
public final void handleNotification(Bundle pushBundle)
```
---
###  <a name=""></a>
Callback method which calling when push opened

 
* **message** - push message which was opened
```
@SuppressWarnings({ "WeakerAccess", "unused" })
protected void onMessageOpened(final PushMessage message)
```
---
###  <a name=""></a>
Extension method for push notification receive handling

  
* **data** - notification data
* **Return Value** - false if notification should be generated for this data
```
@WorkerThread
protected boolean onMessageReceived(PushMessage data)
```
---
###  <a name=""></a>
Extension method for push notification open handling.
 By default starts Launcher Activity or Activity marked with @{applicationId}.MESSAGE intent filter.

 
* **message** - notification data
```
@MainThread
protected void startActivityForPushMessage(PushMessage message)
```
---
### isAppOnForeground() <a name="isAppOnForeground()"></a>

* **Return Value** - true if application is currently in focus.
```
protected boolean isAppOnForeground()
```
---
###  <a name=""></a>

* **Return Value** - Application context.
```
@Nullable
protected final Context getApplicationContext()
```
---
