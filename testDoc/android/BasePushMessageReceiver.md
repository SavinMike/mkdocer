###  <a name=""></a>
 BasePushMessageReceiver class is used to replicate automatic foreground push handling similar to iOS.
 Whenever it is registered it will cancel all incoming notification and invoke [BasePushMessageReceiver#onMessageReceive(Intent)](BasePushMessageReceiver.md#onMessageReceive(Intent)) method.
 In order for it to work as intended you should register this receiver every time your application becomes active and unregister it every time it goes background.
 i.e it means that you should register it on <b>every</b> Activity resume and unregister it on <b>every</b> Activity pause. 



 
 
     ```

     public class TestNotificationServiceExtension extends NotificationServiceExtension {
        {@literal @}Override
         public boolean onMessageReceived(final PushMessage message) {
             if (isAppOnForeground()) {
                 Handler mainHandler = new Handler(getApplicationContext().getMainLooper());
                 mainHandler.post(() -> {
                     handlePush(message);
                 });

                 // this indicates that notification should not be displayed
                 return true;
             }
         }

        {@literal @}Override
         protected void startActivityForPushMessage(PushMessage message) {
             super.startActivityForPushMessage(message);

             handlePush(message);
         }

        {@literal @}MainThread
         private void handlePush(PushMessage message) {
             // TODO: handle push message
         }
     }
     
```
 

```
@Deprecated
public abstract class BasePushMessageReceiver extends BroadcastReceiver 
```
---
### JSON_DATA_KEY <a name="JSON_DATA_KEY"></a>
 Push notification payload is stored as stringified json under this key in intent extras.

```
public static final String JSON_DATA_KEY = "pw_data_json_string"
```
---
###  <a name=""></a>
 Called when notification is received in foreground.

 
* **intent** - intent that started this receiver.
```
protected abstract void onMessageReceive(Intent intent)
```
---
