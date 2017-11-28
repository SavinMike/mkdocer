### onTokenRefresh(String) <a name="onTokenRefresh(String)"></a>
 if you use custom [FirebaseInstanceIdService#onTokenRefresh()](FirebaseInstanceIdService.md#onTokenRefresh())
 call this method when [FirebaseInstanceIdService#onTokenRefresh()](FirebaseInstanceIdService.md#onTokenRefresh()) is invoked

```
public static void onTokenRefresh(@Nullable String token) 
```
---
### onMessageReceived(RemoteMessage) <a name="onMessageReceived(RemoteMessage)"></a>
 if you use custom [com.google.firebase.messaging.FirebaseMessagingService#onMessageReceived(RemoteMessage)](com/google/firebase/messaging/FirebaseMessagingService#onMessageReceived(RemoteMessage))
 call this method when [com.google.firebase.messaging.FirebaseMessagingService#onMessageReceived(RemoteMessage)](com/google/firebase/messaging/FirebaseMessagingService#onMessageReceived(RemoteMessage)) is invoked

 
* **Return Value** - true if the remoteMessage was sent via Pushwoosh and was successfully processed; otherwise false
```
@SuppressWarnings("UnusedReturnValue")
public static boolean onMessageReceived(RemoteMessage remoteMessage) 
```
---
### isPushwooshMessage(RemoteMessage) <a name="isPushwooshMessage(RemoteMessage)"></a>
 Check if the remoteMessage was sent via Pushwoosh

 
* **Return Value** - true if remoteMessage was sent via Pushwoosh
```
public static boolean isPushwooshMessage(RemoteMessage remoteMessage) 
```
---
