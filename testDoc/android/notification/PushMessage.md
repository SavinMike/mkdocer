### PushMessage <a name="PushMessage"></a>
Push message data class.
```
public class PushMessage
```
---
### getLargeIconUrl() <a name="getLargeIconUrl()"></a>
 [Notification.Builder.setLargeIcon]((https://developer.android.com/reference/android/app/Notification.Builder.html#setLargeIcon(android.graphics.Bitmap)))
* **Return Value** - Notification large icon url.
```
public String getLargeIconUrl()
```
---
### getBigPictureUrl() <a name="getBigPictureUrl()"></a>
 [Notification.BigPictureStyle.bigPicture]((https://developer.android.com/reference/android/app/Notification.BigPictureStyle.html#bigPicture(android.graphics.Bitmap)))
* **Return Value** - Notification big picture url.
```
public String getBigPictureUrl()
```
---
### getHeader() <a name="getHeader()"></a>
 [Notification.Builder.setContentTitle]((https://developer.android.com/reference/android/app/Notification.Builder.html#setContentTitle(java.lang.CharSequence)))
* **Return Value** - Notification title.
```
public String getHeader()
```
---
### getMessage() <a name="getMessage()"></a>
 [Notification.Builder.setContentText](https://developer.android.com/reference/android/app/Notification.Builder.html#setContentText(java.lang.CharSequence))
* **Return Value** - Notification message.
```
public String getMessage()
```
---
### getPushHash() <a name="getPushHash()"></a>

* **Return Value** - Pushmessage hash. Pushes triggered using remote API may not have hash.
```
public String getPushHash()
```
---
### isSilent() <a name="isSilent()"></a>

* **Return Value** - true if push message is "silent" and will not present notification.
```
public boolean isSilent()
```
---
### isLocal() <a name="isLocal()"></a>

* **Return Value** - true if push notification is local.
```
public boolean isLocal()
```
---
### getIconBackgroundColor() <a name="getIconBackgroundColor()"></a>
 [Notification.Builder.setColor]((https://developer.android.com/reference/android/app/Notification.Builder.html#setColor(int)))
* **Return Value** - notification icon background color.
```
public Integer getIconBackgroundColor()
```
---
### getLed() <a name="getLed()"></a>

* **Return Value** - Led color for current push message.
```
public Integer getLed()
```
---
### getSound() <a name="getSound()"></a>

* **Return Value** - sound uri for current push message.
```
public String getSound()
```
---
### getVibration() <a name="getVibration()"></a>

* **Return Value** - true if device should vibrate in response to notification.
```
public boolean getVibration()
```
---
### getTicker() <a name="getTicker()"></a>
 [Notification.Builder.setTicker]((https://developer.android.com/reference/android/app/Notification.Builder.html#setTicker(java.lang.CharSequence)))
* **Return Value** - Ticker.
```
public String getTicker()
```
---
### getSmallIcon() <a name="getSmallIcon()"></a>
 [Notification.Builder.setSmallIcon]((https://developer.android.com/reference/android/app/Notification.Builder.html#setSmallIcon(int)))
* **Return Value** - Notification small icon.
```
public int getSmallIcon()
```
---
### getPriority() <a name="getPriority()"></a>
 [Notification.Builder.setPriority]((https://developer.android.com/reference/android/app/Notification.Builder.html#setPriority(int)))
* **Return Value** - Notification priority.
```
public int getPriority()
```
---
### getBadges() <a name="getBadges()"></a>

* **Return Value** - Application icon badge number.
```
public int getBadges()
```
---
### getVisibility() <a name="getVisibility()"></a>
 [Notification.Builder.setVisibility]((https://developer.android.com/reference/android/app/Notification.Builder.html#setVisibility(int)))
* **Return Value** - Notification visibility.
```
public int getVisibility()
```
---
### getLedOnMS() <a name="getLedOnMS()"></a>

* **Return Value** - LED on duration in ms
```
public int getLedOnMS()
```
---
### getLedOffMS() <a name="getLedOffMS()"></a>

* **Return Value** - LED off duration in ms
```
public int getLedOffMS()
```
---
### getActions() <a name="getActions()"></a>

* **Return Value** - Notification actions
```
public List<Action> getActions()
```
---
### getTag() <a name="getTag()"></a>
 Notifications with same tag will replace each other if multinotification mode is not set [PushwooshNotificationSettings#setMultiNotificationMode(boolean)](PushwooshNotificationSettings.md#setMultiNotificationMode(boolean))
* **Return Value** - Notification tag. Notifications with different tags will not replace each other.
```
public String getTag()
```
---
### isLockScreen() <a name="isLockScreen()"></a>

* **Return Value** - true if notification presents Rich Media on lock screen.
```
public boolean isLockScreen()
```
---
### getCustomData() <a name="getCustomData()"></a>

* **Return Value** - custom push data attached to incoming push message
```
public String getCustomData()
```
---
### toBundle() <a name="toBundle()"></a>

* **Return Value** - Bundle representation of push payload
```
public Bundle toBundle()
```
---
### toJson() <a name="toJson()"></a>

* **Return Value** - JSON representation of push payload
```
public JSONObject toJson()
```
---
