### LocalNotification <a name="LocalNotification"></a>
 The LocalNotification class combines data that is used to schedule local notification [scheduleLocalNotification(LocalNotification)](Pushwoosh.md)

```
public class LocalNotification 
```
---
### Builder <a name="Builder"></a>
 LocalNotification Builder.

```
public static class Builder 
```
---
### setTag(String) <a name="setTag(String)"></a>
 Sets notification tag that is used to distinguish different notifications. Notifications with different tags will not replace each other.
 Notifications with same tag will replace each other if multinotification mode is not set [PushwooshNotificationSettings#setMultiNotificationMode(boolean)](PushwooshNotificationSettings.md#setMultiNotificationMode(boolean))

  
* **tag** - notification tag
* **Return Value** - builder
```
public Builder setTag(String tag) 
```
---
### setMessage(String) <a name="setMessage(String)"></a>
 Sets notification content.

  
* **message** - notififcation text message
* **Return Value** - builder
```
public Builder setMessage(String message) 
```
---
### setDelay(int) <a name="setDelay(int)"></a>
 Sets the delay after which notification will be displayed.

  
* **delay** - delay in seconds
* **Return Value** - builder
```
public Builder setDelay(int delay) 
```
---
### setLink(String) <a name="setLink(String)"></a>
 Sets url link that will be open in browser instead of default launcher activity after clicking on notification.
 Deeplink url can be also used as parameter.

  
* **url** - url link
* **Return Value** - builder
```
public Builder setLink(String url) 
```
---
### setBanner(String) <a name="setBanner(String)"></a>
 Sets image for notification BigPictureStyle (https://developer.android.com/reference/android/app/Notification.BigPictureStyle.html)

  
* **url** - image url link
* **Return Value** - builder
```
public Builder setBanner(String url) 
```
---
### setSmallIcon(String) <a name="setSmallIcon(String)"></a>
 Sets small icon image.

  
* **name** - resource name for small icon.
* **Return Value** - builder
```
public Builder setSmallIcon(String name) 
```
---
### setLargeIcon(String) <a name="setLargeIcon(String)"></a>
 Sets large icon image.

  
* **url** - image url link.
* **Return Value** - builder
```
public Builder setLargeIcon(String url) 
```
---
### setExtras(Bundle) <a name="setExtras(Bundle)"></a>
 Sets custom notification bundle. Warning: this can replace other settings.

  
* **extras** - notification bundle extras
* **Return Value** - builder
```
public Builder setExtras(Bundle extras) 
```
---
### build() <a name="build()"></a>
 Builds and returns LocalNotification.

 
* **Return Value** - local notification
```
public LocalNotification build() 
```
---
