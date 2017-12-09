### PushwooshLocation <a name="PushwooshLocation"></a>
PushwooshLocation is a static class responsible for pushwoosh geolocation tracking. 

 By default pushwoosh-location library automatically adds following permissions: 

 [permission.ACCESS_FINE_LOCATION](https://developer.android.com/reference/android/Manifest.permission.html#ACCESS_FINE_LOCATION) 

 [android.permission.ACCESS_COARSE_LOCATION](https://developer.android.com/reference/android/Manifest.permission.html#ACCESS_COARSE_LOCATION) 

 


 For Android 6 and higher these permissions should be requested dynamically before invoking PushwooshLocation.startLocationTracking()
```
public class PushwooshLocation
```
---
### startLocationTracking() <a name="startLocationTracking()"></a>
Starts location tracking for geo push notifications.
```
public static void startLocationTracking()
```
---
### startLocationTracking(Callback) <a name="startLocationTracking(Callback)"></a>
Starts location tracking for geo push notifications.
 
* **callback** - return [Result#isSuccess()](Result.md#isSuccess()) if user accept all needed permissions and enable location
```
public static void startLocationTracking(@Nullable Callback<Void, LocationNotAvailableException> callback)
```
---
### stopLocationTracking() <a name="stopLocationTracking()"></a>
Stops geolocation tracking.
```
public static void stopLocationTracking()
```
---
