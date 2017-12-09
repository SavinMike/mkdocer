### PushwooshBadge <a name="PushwooshBadge"></a>
PushwooshBadge is a static class responsible for application icon badge number managing. 

 By default pushwoosh-badge library automatically adds following permissions:

 	com.sec.android.provider.badge.permission.READ 

 	com.sec.android.provider.badge.permission.WRITE 

 	com.htc.launcher.permission.READ_SETTINGS 

 	com.htc.launcher.permission.UPDATE_SHORTCUT 

 	com.sonyericsson.home.permission.BROADCAST_BADGE 

 	com.sonymobile.home.permission.PROVIDER_INSERT_BADGE 

 	com.anddoes.launcher.permission.UPDATE_COUNT 

 	com.majeur.launcher.permission.UPDATE_BADGE 

 	com.huawei.android.launcher.permission.CHANGE_BADGE 

 	com.huawei.android.launcher.permission.READ_SETTINGS 

 	com.huawei.android.launcher.permission.WRITE_SETTINGS 

 	android.permission.READ_APP_BADGE 

 	com.oppo.launcher.permission.READ_SETTINGS 

 	com.oppo.launcher.permission.WRITE_SETTINGS 

```
public class PushwooshBadge
```
---
### setBadgeNumber(int) <a name="setBadgeNumber(int)"></a>
Set application icon badge number and synchronize this value with pushwoosh backend.
 0 value can be used to clear badges

 
* **newBadge** - icon badge number
```
public static void setBadgeNumber(int newBadge)
```
---
### getBadgeNumber() <a name="getBadgeNumber()"></a>

* **Return Value** - current application icon badge number
```
public static int getBadgeNumber()
```
---
### addBadgeNumber(int) <a name="addBadgeNumber(int)"></a>
Increment current icon badge number

 
* **deltaBadge** - application icon badge number addition
```
public static void addBadgeNumber(int deltaBadge)
```
---
