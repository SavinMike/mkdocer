###  <a name=""></a>
 BasePushMessageReceiver class is used to handle push registration/unregistration events.

 
```
@Deprecated
public abstract class BaseRegistrationReceiver extends BroadcastReceiver 
```
---
###  <a name=""></a>
 Push registration callback. Intent extras contain one of the following keys: 


 [PushManager#UNREGISTER_ERROR_EVENT](PushManager.md#UNREGISTER_ERROR_EVENT) - indicates successful registration. Intent extras contain push notification token under this key.

 [PushManager#UNREGISTER_ERROR_EVENT](PushManager.md#UNREGISTER_ERROR_EVENT) - indicates successful unregistration. Intent extras contain push notification token under this key.

 [PushManager#UNREGISTER_ERROR_EVENT](PushManager.md#UNREGISTER_ERROR_EVENT) - indicates registration error. Intent extras contain error description under this key.

 [PushManager#UNREGISTER_ERROR_EVENT](PushManager.md#UNREGISTER_ERROR_EVENT) - indicates unregistration error. Intent extras contain error description under this key.

  
* **context** - context
* **intent** - intent
```
protected abstract void onRegisterActionReceive(Context context, Intent intent)
```
---
