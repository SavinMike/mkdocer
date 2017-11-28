### VibrateType <a name="VibrateType"></a>
 Push notification vibration setting.
 Application must use [VIBRATE](https://developer.android.com/reference/android/Manifest.permission.html#VIBRATE) permission in order for vibration to work.

 com.pushwoosh.notification.PushwooshNotificationSettings#setVibrateNotificationType(VibrateType)
```
public enum VibrateType 
```
---
###  <a name=""></a>
 Notification causes vibration if AudioManager ringer mode is [RINGER_MODE_VIBRATE](https://developer.android.com/reference/android/media/AudioManager.html#RINGER_MODE_VIBRATE).


 Notification will not cause vibration.


 Notification will always cause vibration.

```
DEFAULT_MODE(0),

/**
* Notification will not cause vibration.
NO_VIBRATE(1),

/**
* Notification will always cause vibration.
ALWAYS(2)
```
---
