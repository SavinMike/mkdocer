### PushwooshNotificationSettings <a name="PushwooshNotificationSettings"></a>
 PushwooshNotificationSettings class is used to customise push notification appearance.

```
public class PushwooshNotificationSettings 
```
---
### setMultiNotificationMode(boolean) <a name="setMultiNotificationMode(boolean)"></a>
 Allows multiple notifications to be displayed in notification center.
 By default SDK uses single notification mode where each notification overrides previously displayed notification.

 
* **on** - enable multi/single notification mode
```
public static void setMultiNotificationMode(boolean on) 
```
---
### setSoundNotificationType(SoundType) <a name="setSoundNotificationType(SoundType)"></a>
 Set whether sound should be played when notification is received.

 
* **soundNotificationType** - sound setting
```
public static void setSoundNotificationType(SoundType soundNotificationType) 
```
---
### setVibrateNotificationType(VibrateType) <a name="setVibrateNotificationType(VibrateType)"></a>
 Set whether device should vibrate when notification is received.
 If "Force Vibration" is set in Pushwoosh control panel for remote notification it will cause vibration regardless of this setting.

 
* **vibrateNotificationType** - vibration setting
```
public static void setVibrateNotificationType(VibrateType vibrateNotificationType) 
```
---
### setLightScreenOnNotification(boolean) <a name="setLightScreenOnNotification(boolean)"></a>
 Set whether notification should unlock screen.

 
* **on** - enable screen unlock
```
public static void setLightScreenOnNotification(boolean on) 
```
---
### setEnableLED(boolean) <a name="setEnableLED(boolean)"></a>
 Set whether notification should cause LED blinking.

 
* **on** - enable LED blinking
```
public static void setEnableLED(boolean on) 
```
---
### setColorLED(int) <a name="setColorLED(int)"></a>
 Set LED color. [#setEnableLED(boolean)](#setEnableLED(boolean)) must be set to adjust LED color.

 
* **color** - LED color
```
public static void setColorLED(@ColorInt int color) 
```
---
### setNotificationIconBackgroundColor(int) <a name="setNotificationIconBackgroundColor(int)"></a>
 Set notification icon background color

  [Notification.Builder.setSmallIcon]((https://developer.android.com/reference/android/app/Notification.Builder.html#setSmallIcon(int)))
* **color** - background color
```
public static void setNotificationIconBackgroundColor(@ColorInt int color) 
```
---
### areNotificationsEnabled() <a name="areNotificationsEnabled()"></a>
 
* **Return Value** - true if notifications are enabled and will appear in notification center.
```
public static boolean areNotificationsEnabled() 
```
---
### enableNotifications(boolean) <a name="enableNotifications(boolean)"></a>
 Set whether notifications should be enabled

 
* **on** - enable notifications
```
public static void enableNotifications(boolean on) 
```
---
### setNotificationChannelName(String) <a name="setNotificationChannelName(String)"></a>
 Set default notification channel name for API 26

 
* **name** - name of notification channel
```
public static void setNotificationChannelName(String name) 
```
---
