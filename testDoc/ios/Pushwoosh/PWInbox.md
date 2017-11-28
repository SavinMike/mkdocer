###  <a name=""></a>
The notification arriving on the Inbox messages renewal

```
FOUNDATION_EXPORT NSString * const PWInboxMessagesDidUpdateNotification
```
---
###  <a name=""></a>
The notification arriving when a push message is added to Inbox

```
FOUNDATION_EXPORT NSString * const PWInboxMessagesDidReceiveInPushNotification
```
---
###  <a name=""></a>
The Inbox message type. Plain = without any action, Richmedia = contains a Rich media page, URL = contains remote URL, Deeplink = contains Deeplink

```
typedef NS_ENUM(NSInteger, PWInboxMessageType) 
```
---
### PWInboxMessageProtocol <a name="PWInboxMessageProtocol"></a>
`PWInboxMessageProtocol` The protocol describing the Inbox message.

```
@protocol PWInboxMessageProtocol <NSObject>
```
---
### messagesWithNoActionPerformedCountWithCompletion: <a name="messagesWithNoActionPerformedCountWithCompletion:"></a>
Get the number of the PWInboxMessageProtocol with no action performed


* **completion** - - if successful, return the number of the InboxMessages with no action performed. Otherwise, return error
```
+ (void)messagesWithNoActionPerformedCountWithCompletion:(void (^)(NSInteger count, NSError *error))completion
```
---
### unreadMessagesCountWithCompletion: <a name="unreadMessagesCountWithCompletion:"></a>
Get the number of the unread PWInboxMessageProtocol


* **completion** - - if successful, return the number of the unread InboxMessages. Otherwise, return error
```
+ (void)unreadMessagesCountWithCompletion:(void (^)(NSInteger count, NSError *error))completion
```
---
### messagesCountWithCompletion: <a name="messagesCountWithCompletion:"></a>
Get the total number of the PWInboxMessageProtocol


* **completion** - - if successful, return the total number of the InboxMessages. Otherwise, return error
```
+ (void)messagesCountWithCompletion:(void (^)(NSInteger count, NSError *error))completion
```
---
### loadMessagesWithCompletion: <a name="loadMessagesWithCompletion:"></a>
Get the collection of the PWInboxMessageProtocol that the user received


* **completion** - - if successful, return the collection of the InboxMessages. Otherwise, return error
```
+ (void)loadMessagesWithCompletion:(void (^)(NSArray<NSObject<PWInboxMessageProtocol> *> *messages, NSError *error))completion
```
---
### readMessagesWithCodes: <a name="readMessagesWithCodes:"></a>
Call this method to mark the list of InboxMessageProtocol as read


* **codes** - of the inboxMessages
```
+ (void)readMessagesWithCodes:(NSArray<NSString *> *)codes
```
---
### performActionForMessageWithCode: <a name="performActionForMessageWithCode:"></a>
Call this method, when the user clicks on the InboxMessageProtocol and the message’s action is performed


* **code** - of the inboxMessage that the user tapped
```
+ (void)performActionForMessageWithCode:(NSString *)code
```
---
### deleteMessagesWithCodes: <a name="deleteMessagesWithCodes:"></a>
Call this method, when the user deletes the list of InboxMessageProtocol manually


* **codes** - of the list of InboxMessageProtocol.code that the user deleted
```
+ (void)deleteMessagesWithCodes:(NSArray<NSString *> *)codes
```
---
### addObserverForDidReceiveInPushNotificationCompletion: <a name="addObserverForDidReceiveInPushNotificationCompletion:"></a>
Subscribe for messages arriving with push notifications. @warning You need to unsubscribe by calling the removeObserver method, if you don't want to receive notifications


* **completion** - - return the collection of the InboxMessages.
```
+ (id<NSObject>)addObserverForDidReceiveInPushNotificationCompletion:(void (^)(NSArray<NSObject<PWInboxMessageProtocol> *> *messagesAdded))completion
```
---
### addObserverForUpdateInboxMessagesCompletion: <a name="addObserverForUpdateInboxMessagesCompletion:"></a>
Subscribe for messages arriving when a message is deleted, added, or updated. @warning You need to unsubscribe by calling the removeObserver method, if you don't want to receive notifications


* **completion** - - return the collection of the InboxMessages.
```
+ (id<NSObject>)addObserverForUpdateInboxMessagesCompletion:(void (^)(NSArray<NSString *> *messagesDeleted,
NSArray<NSObject<PWInboxMessageProtocol> *> *messagesAdded,
NSArray<NSObject<PWInboxMessageProtocol> *> *messagesUpdated))completion
```
---
### removeObserver: <a name="removeObserver:"></a>
Unsubscribes from notifications


* **observer** - - Unsubscribes observer
```
+ (void)removeObserver:(id<NSObject>)observer
```
---
