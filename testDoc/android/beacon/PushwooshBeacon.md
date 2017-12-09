### PushwooshBeacon <a name="PushwooshBeacon"></a>
PushwooshBeacon is a static class responsible for iBeacon tracking. 

 By default pushwoosh-beacon library automatically adds following permissions: 

 [android.permission.BLUETOOTH](https://developer.android.com/reference/android/Manifest.permission.html#BLUETOOTH) 

 [android.permission.BLUETOOTH_ADMINH](https://developer.android.com/reference/android/Manifest.permission.html#BLUETOOTH_ADMIN) 

```
public final class PushwooshBeacon
```
---
### startTrackingBeaconPushes() <a name="startTrackingBeaconPushes()"></a>
Starts beacon tracking for iBeacon push notifications.
```
public static void startTrackingBeaconPushes()
```
---
### stopTrackingBeaconPushes() <a name="stopTrackingBeaconPushes()"></a>
Stops beacon tracking.
```
public static void stopTrackingBeaconPushes()
```
---
### setBeaconBackgroundMode(boolean) <a name="setBeaconBackgroundMode(boolean)"></a>
Sets beacon tracking battery optimization.

 
```
public static void setBeaconBackgroundMode(boolean backgroundMode)
```
---
