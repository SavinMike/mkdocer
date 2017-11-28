### SoundType <a name="SoundType"></a>
 Push notification sound setting.

 [PushwooshNotificationSettings#setSoundNotificationType(SoundType)](PushwooshNotificationSettings.md#setSoundNotificationType(SoundType))
```
public enum SoundType 
```
---
###  <a name=""></a>
 Sound is played when notification arrives if AudioManager ringer mode is [RINGER_MODE_NORMAL](https://developer.android.com/reference/android/media/AudioManager.html#RINGER_MODE_NORMAL).


 Sound is never played when notification arrives.


 Sound is always played when notification arrives.

```
DEFAULT_MODE(0),

/**
* Sound is never played when notification arrives.
NO_SOUND(1),

/**
* Sound is always played when notification arrives.
ALWAYS(2)
```
---
