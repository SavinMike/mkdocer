### PushNotificationDelegate <a name="PushNotificationDelegate"></a>
`PushNotificationDelegate` protocol defines the methods that can be implemented in the delegate of the `PushNotificationManager` class' singleton object.
These methods provide information about the key events for push notification manager such as registering with APS services, receiving push notifications or working with the received notification.
These methods implementation allows to react on these events properly.

```
@protocol PushNotificationDelegate
```
---
### onDidRegisterForRemoteNotificationsWithDeviceToken: <a name="onDidRegisterForRemoteNotificationsWithDeviceToken:"></a>
Tells the delegate that the application has registered with Apple Push Service (APS) successfully.


* **token** - A token used for identifying the device with APS.
```
- (void)onDidRegisterForRemoteNotificationsWithDeviceToken:(NSString *)token
```
---
### onDidFailToRegisterForRemoteNotificationsWithError: <a name="onDidFailToRegisterForRemoteNotificationsWithError:"></a>
Sent to the delegate when Apple Push Service (APS) could not complete the registration process successfully.


* **error** - An NSError object encapsulating the information about the reason of the registration failure. Within this method you can define application's behaviour in case of registration failure.
```
- (void)onDidFailToRegisterForRemoteNotificationsWithError:(NSError *)error
```
---
### onPushReceived:withNotification:onStart: <a name="onPushReceived:withNotification:onStart:"></a>
Tells the delegate that the push manager has received a remote notification.

The provider originates it as a JSON-defined dictionary that iOS converts to an NSDictionary object; the dictionary may contain only property-list objects plus NSNull.

* **pushManager** - The push manager that received the remote notification.
* **pushNotification** - A dictionary that contains information referring to the remote notification, potentially including a badge number for the application icon, an alert sound, an alert message to display to the user, a notification identifier, and custom data.
* **onStart** - If the application was not foreground when the push notification was received, the application will be opened with this parameter equal to `YES`, otherwise the parameter will be `NO`.
```
- (void)onPushReceived:(PushNotificationManager *)pushManager withNotification:(NSDictionary *)pushNotification onStart:(BOOL)onStart
```
---
### onPushAccepted:withNotification: <a name="onPushAccepted:withNotification:"></a>
Tells the delegate that the user has pressed OK on the push notification.
IMPORTANT: This method is used for backwards compatibility and is deprecated. Please use the `onPushAccepted:withNotification:onStart:` method instead

The provider originates it as a JSON-defined dictionary that iOS converts to an NSDictionary object; the dictionary may contain only property-list objects plus NSNull.
Push dictionary sample:

{
aps =     {
alert = "Some text.";
sound = default;
};
p = 1pb;
}


* **pushManager** - The push manager that received the remote notification.
* **pushNotification** - A dictionary that contains information referring to the remote notification, potentially including a badge number for the application icon, an alert sound, an alert message to display to the user, a notification identifier, and custom data.
```
- (void)onPushAccepted:(PushNotificationManager *)pushManager withNotification:(NSDictionary *)pushNotification DEPRECATED_ATTRIBUTE
```
---
### onPushAccepted:withNotification:onStart: <a name="onPushAccepted:withNotification:onStart:"></a>
Tells the delegate that the user has pressed on the push notification banner.

The provider originates it as a JSON-defined dictionary that iOS converts to an NSDictionary object; the dictionary may contain only property-list objects plus NSNull.
Push dictionary sample:

{
aps =     {
alert = "Some text.";
sound = default;
};
p = 1pb;
}


* **pushManager** - The push manager that received the remote notification.
* **pushNotification** - A dictionary that contains information about the remote notification, potentially including a badge number for the application icon, an alert sound, an alert message to display to the user, a notification identifier, and custom data.
* **onStart** - If the application was not foreground when the push notification was received, the application will be opened with this parameter equal to `YES`, otherwise the parameter will be `NO`.
```
- (void)onPushAccepted:(PushNotificationManager *)pushManager withNotification:(NSDictionary *)pushNotification onStart:(BOOL)onStart
```
---
### onTagsReceived: <a name="onTagsReceived:"></a>
Tells the delegate that the push manager has received tags from the server.

Dictionary example:

{
Country = ru;
Language = ru;
}


* **tags** - Dictionary representation of received tags.
```
- (void)onTagsReceived:(NSDictionary *)tags
```
---
### onTagsFailedToReceive: <a name="onTagsFailedToReceive:"></a>
Sent to the delegate when push manager could not complete the tags receiving process successfully.


* **error** - An NSError object that encapsulates information why receiving tags did not succeed.
```
- (void)onTagsFailedToReceive:(NSError *)error
```
---
### onInAppClosed: <a name="onInAppClosed:"></a>
Tells the delegate that In-App with specified code has been closed


* **code** - In-App code
```
- (void)onInAppClosed:(NSString *)code
```
---
### onInAppDisplayed: <a name="onInAppDisplayed:"></a>
Tells the delegate that In-App with specified code has been displayed


* **code** - In-App code
```
- (void)onInAppDisplayed:(NSString *)code
```
---
### PWTags <a name="PWTags"></a>
`PWTags` class encapsulates the methods for creating tags parameters for sending them to the server.

```
@interface PWTags : NSObject
```
---
### incrementalTagWithInteger: <a name="incrementalTagWithInteger:"></a>
Creates a dictionary for incrementing/decrementing a numeric tag on the server.

Example:

NSDictionary *tags = [NSDictionary dictionaryWithObjectsAndKeys:
aliasField.text, @"Alias",
[NSNumber numberWithInt:[favNumField.text intValue]], @"FavNumber",
[PWTags incrementalTagWithInteger:5], @"price",
nil];

[[PushNotificationManager pushManager] setTags:tags];



* **delta** - Difference that needs to be applied to the tag's counter.
* **Return Value** - Dictionary, that needs to be sent as the value for the tag
```
+ (NSDictionary *)incrementalTagWithInteger:(NSInteger)delta
```
---
### PushNotificationManager <a name="PushNotificationManager"></a>
`PushNotificationManager` class offers access to the singletone-instance of the push manager responsible for registering the device with the APS servers, receiving and processing push notifications.

```
@interface PushNotificationManager : NSObject 
```
---
###  <a name=""></a>
Pushwoosh Application ID. Usually retrieved automatically from Info.plist parameter `Pushwoosh_APPID`

```
@property (nonatomic, copy, readonly) NSString *appCode
```
---
###  <a name=""></a>
Application name. Usually retrieved automatically from Info.plist bundle name (CFBundleDisplayName). Could be used to override bundle name. In addition could be set in Info.plist as `Pushwoosh_APPNAME` parameter.

```
@property (nonatomic, copy, readonly) NSString *appName
```
---
###  <a name=""></a>
`PushNotificationDelegate` protocol delegate that would receive the information about events for push notification manager such as registering with APS services, receiving push notifications or working with the received notification.
Pushwoosh Runtime sets it to ApplicationDelegate by default

```
@property (nonatomic, weak) NSObject<PushNotificationDelegate> *delegate
```
---
###  <a name=""></a>
Show push notifications alert when push notification is received while the app is running, default is `YES`

```
@property (nonatomic, assign) BOOL showPushnotificationAlert
```
---
###  <a name=""></a>
Returns push notification payload if the app was started in response to push notification or null otherwise

```
@property (nonatomic, copy, readonly) NSDictionary *launchNotification
```
---
###  <a name=""></a>
Returns UNUserNotificationCenterDelegate that handles foreground push notifications on iOS10

```
@property (nonatomic, strong, readonly) id<UNUserNotificationCenterDelegate> notificationCenterDelegate
```
---
### initializeWithAppCode:appName: <a name="initializeWithAppCode:appName:"></a>
Initializes PushNotificationManager. Usually called by Pushwoosh Runtime internally.

* **appCode** - Pushwoosh App ID.
* **appName** - Application name.
```
+ (void)initializeWithAppCode:(NSString *)appCode appName:(NSString *)appName
```
---
### pushManager: <a name="pushManager:"></a>
Returns an object representing the current push manager.


* **Return Value** - A singleton object that represents the push manager.
```
+ (PushNotificationManager *)pushManager
```
---
### registerForPushNotifications: <a name="registerForPushNotifications:"></a>
Registers for push notifications. By default registeres for "UIRemoteNotificationTypeBadge | UIRemoteNotificationTypeSound | UIRemoteNotificationTypeAlert" flags.
Automatically detects if you have "newsstand-content" in "UIBackgroundModes" and adds "UIRemoteNotificationTypeNewsstandContentAvailability" flag.

```
- (void)registerForPushNotifications
```
---
### unregisterForPushNotifications: <a name="unregisterForPushNotifications:"></a>
Unregisters from push notifications. You should call this method in rare circumstances only, such as when a new version of the app drops support for remote notifications. Users can temporarily prevent apps from receiving remote notifications through the Notifications section of the Settings app. Apps unregistered through this method can always re-register.

```
- (void)unregisterForPushNotifications
```
---
### initWithApplicationCode:appName: <a name="initWithApplicationCode:appName:"></a>
Deprecated. Use initializeWithAppCode:appName: method class

```
- (instancetype)initWithApplicationCode:(NSString *)appCode appName:(NSString *)appName __attribute__((deprecated))
```
---
### initWithApplicationCode:navController:appName: <a name="initWithApplicationCode:navController:appName:"></a>
Deprecated. Use initializeWithAppCode:appName: method class

```
- (id)initWithApplicationCode:(NSString *)appCode navController:(UIViewController *)navController appName:(NSString *)appName __attribute__((deprecated))
```
---
### sendLocation: <a name="sendLocation:"></a>
Sends geolocation to the server for GeoFencing push technology. Called internally, please use `startLocationTracking` and `stopLocationTracking` functions.


* **location** - Location to be sent.
```
- (void)sendLocation:(CLLocation *)location
```
---
### startLocationTracking: <a name="startLocationTracking:"></a>
Start location tracking.

```
- (void)startLocationTracking
```
---
### stopLocationTracking: <a name="stopLocationTracking:"></a>
Stops location tracking

```
- (void)stopLocationTracking
```
---
### setTags: <a name="setTags:"></a>
Send tags to server. Tag names have to be created in the Pushwoosh Control Panel. Possible tag types: Integer, String, Incremental (integer only), List tags (array of values).

Example:

NSDictionary *tags = [NSDictionary dictionaryWithObjectsAndKeys:
aliasField.text, @"Alias",
[NSNumber numberWithInt:[favNumField.text intValue]], @"FavNumber",
[PWTags incrementalTagWithInteger:5], @"price",
[NSArray arrayWithObjects:@"Item1", @"Item2", @"Item3", nil], @"List",
nil];

[[PushNotificationManager pushManager] setTags:tags];


* **tags** - Dictionary representation of tags to send.
```
- (void)setTags:(NSDictionary *)tags
```
---
### setTags:withCompletion: <a name="setTags:withCompletion:"></a>
Send tags to server with completion block. If setTags succeeds competion is called with nil argument. If setTags fails completion is called with error.

```
- (void)setTags:(NSDictionary *)tags withCompletion:(void (^)(NSError *error))completion
```
---
### loadTags: <a name="loadTags:"></a>
Get tags from the server. Calls delegate method `onTagsReceived:` or `onTagsFailedToReceive:` depending on the results.

```
- (void)loadTags
```
---
### loadTags:error: <a name="loadTags:error:"></a>
Get tags from server. Calls delegate method if exists and handler (block).

Example of the dictionary representation of the received tags:

{
Country = ru;
Language = ru;
}


* **successHandler** - The block is executed on the successful completion of the request. This block has no return value and takes one argument: the dictionary representation of the recieved tags.
* **errorHandler** - The block is executed on the unsuccessful completion of the request. This block has no return value and takes one argument: the error that occurred during the request.
```
- (void)loadTags:(PushwooshGetTagsHandler)successHandler error:(PushwooshErrorHandler)errorHandler
```
---
### sendAppOpen: <a name="sendAppOpen:"></a>
Informs the Pushwoosh about the app being launched. Usually called internally by SDK Runtime.

```
- (void)sendAppOpen
```
---
### sendBadges: <a name="sendBadges:"></a>
Sends current badge value to server. Called internally by SDK Runtime when `UIApplication` `setApplicationBadgeNumber:` is set. This function is used for "auto-incremeting" badges to work.
This way Pushwoosh server can know what current badge value is set for the application.


* **badge** - Current badge value.
```
- (void)sendBadges:(NSInteger)badge
```
---
### sendSKPaymentTransactions: <a name="sendSKPaymentTransactions:"></a>
Sends in-app purchases to Pushwoosh. Use in paymentQueue:updatedTransactions: payment queue method (see example).

Example:

- (void)paymentQueue:(SKPaymentQueue *)queue updatedTransactions:(NSArray *)transactions {
[[PushNotificationManager pushManager] sendSKPaymentTransactions:transactions];
}


* **transactions** - Array of SKPaymentTransaction items as received in the payment queue.
```
- (void)sendSKPaymentTransactions:(NSArray *)transactions
```
---
### sendPurchase:withPrice:currencyCode:andDate: <a name="sendPurchase:withPrice:currencyCode:andDate:"></a>
Tracks individual in-app purchase. See recommended `sendSKPaymentTransactions:` method.


* **productIdentifier** - purchased product ID
* **price** - price for the product
* **currencyCode** - currency of the price (ex: @"USD")
* **date** - time of the purchase (ex: [NSDate now])
```
- (void)sendPurchase:(NSString *)productIdentifier withPrice:(NSDecimalNumber *)price currencyCode:(NSString *)currencyCode andDate:(NSDate *)date
```
---
### getPushToken: <a name="getPushToken:"></a>
Gets current push token.


* **Return Value** - Current push token. May be nil if no push token is available yet.
```
- (NSString *)getPushToken
```
---
### getHWID: <a name="getHWID:"></a>
Gets HWID. Unique device identifier that used in all API calls with Pushwoosh.
This is identifierForVendor for iOS >= 7.


* **Return Value** - Unique device identifier.
```
- (NSString *)getHWID
```
---
### getApnPayload: <a name="getApnPayload:"></a>
Gets APN payload from push notifications dictionary.

Example:

- (void) onPushAccepted:(PushNotificationManager *)pushManager withNotification:(NSDictionary *)pushNotification onStart:(BOOL)onStart {
NSDictionary * apnPayload = [[PushNotificationsManager pushManager] getApnPayload:pushNotification];
NSLog(@"%@", apnPayload);
}

For Push dictionary sample:

{
aps =     {
alert = "Some text.";
sound = default;
};
p = 1pb;
}

Result is:

{
alert = "Some text.";
sound = default;
};


* **pushNotification** - Push notifications dictionary as received in `onPushAccepted: withNotification: onStart:`
```
- (NSDictionary *)getApnPayload:(NSDictionary *)pushNotification
```
---
### getCustomPushData: <a name="getCustomPushData:"></a>
Gets custom JSON string data from push notifications dictionary as specified in Pushwoosh Control Panel.

Example:

- (void) onPushAccepted:(PushNotificationManager *)pushManager withNotification:(NSDictionary *)pushNotification onStart:(BOOL)onStart {
NSString * customData = [[PushNotificationsManager pushManager] getCustomPushData:pushNotification];
NSLog(@"%@", customData);
}


* **pushNotification** - Push notifications dictionary as received in `onPushAccepted: withNotification: onStart:`
```
- (NSString *)getCustomPushData:(NSDictionary *)pushNotification
```
---
### getCustomPushDataAsNSDict: <a name="getCustomPushDataAsNSDict:"></a>
The same as getCustomPushData but returns NSDictionary rather than JSON string (converts JSON string into NSDictionary).

```
- (NSDictionary *)getCustomPushDataAsNSDict:(NSDictionary *)pushNotification
```
---
### getRemoteNotificationStatus: <a name="getRemoteNotificationStatus:"></a>
Returns dictionary with enabled remove notificaton types.
Example enabled push:
{
enabled = 1;
pushAlert = 1;
pushBadge = 1;
pushSound = 1;
type = 7;
}

where "type" field is UIUserNotificationType

Disabled push:
{
enabled = 1;
pushAlert = 0;
pushBadge = 0;
pushSound = 0;
type = 0;
}

Note: In the latter example "enabled" field means that device can receive push notification but could not display alerts (ex: silent push)

```
+ (NSMutableDictionary *)getRemoteNotificationStatus
```
---
### clearNotificationCenter: <a name="clearNotificationCenter:"></a>
Clears the notifications from the notification center.

```
+ (void)clearNotificationCenter
```
---
### setUserId: <a name="setUserId:"></a>
Set User indentifier. This could be Facebook ID, username or email, or any other user ID.
This allows data and events to be matched across multiple user devices.

Deprecated. Use PWInAppManager setUserId method instead

```
- (void)setUserId:(NSString *)userId __attribute__ ((deprecated));
```
---
### mergeUserId:to:doMerge:completion: <a name="mergeUserId:to:doMerge:completion:"></a>
Move all events from oldUserId to newUserId if doMerge is true. If doMerge is false all events for oldUserId are removed.


Deprecated. Use PWInAppManager mergeUserId method instead

* **oldUserId** - source user
* **newUserId** - destination user
* **doMerge** - if false all events for oldUserId are removed, if true all events for oldUserId are moved to newUserId
* **completion** - callback
```
- (void)mergeUserId:(NSString *)oldUserId to:(NSString *)newUserId doMerge:(BOOL)doMerge completion:(void (^)(NSError *error))completion __attribute__ ((deprecated))
```
---
### postEvent:withAttributes:completion: <a name="postEvent:withAttributes:completion:"></a>
Post events for In-App Messages. This can trigger In-App message display as specified in Pushwoosh Control Panel.

Example:

[[PushNotificationManager pushManager] setUserId:@"96da2f590cd7246bbde0051047b0d6f7"];
[[PushNotificationManager pushManager] postEvent:@"buttonPressed" withAttributes:@{ @"buttonNumber" : @"4", @"buttonLabel" : @"Banner" } completion:nil];


Deprecated. Use PWInAppManager postEvent method instead

* **event** - name of the event
* **attributes** - NSDictionary of event attributes
* **completion** - function to call after posting event
```
- (void)postEvent:(NSString *)event withAttributes:(NSDictionary *)attributes completion:(void (^)(NSError *error))completion __attribute__ ((deprecated))
```
---
### postEvent:withAttributes: <a name="postEvent:withAttributes:"></a>
See `postEvent:withAttributes:completion:`

Deprecated. Use PWInAppManager postEvent method instead

```
- (void)postEvent:(NSString *)event withAttributes:(NSDictionary *)attributes __attribute__ ((deprecated))
```
---
