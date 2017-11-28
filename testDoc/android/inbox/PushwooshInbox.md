### messagesWithNoActionPerformedCount(Callback) <a name="messagesWithNoActionPerformedCount(Callback)"></a>
 Get the number of the [InboxMessage](InboxMessage) with no action performed

 
* **callback** - - if successful, return the number of the InboxMessages with no action performed. Otherwise, return error
```
public static void messagesWithNoActionPerformedCount(Callback<Integer, InboxMessagesException> callback) 
```
---
### unreadMessagesCount(Callback) <a name="unreadMessagesCount(Callback)"></a>
 Get the number of the unread [InboxMessage](InboxMessage)

 
* **callback** - - if successful, return the number of the unread InboxMessages. Otherwise, return error
```
public static void unreadMessagesCount(Callback<Integer, InboxMessagesException> callback) 
```
---
### messagesCount(Callback) <a name="messagesCount(Callback)"></a>
 Get the total number of the [InboxMessage](InboxMessage)

 
* **callback** - - if successful, return the total number of the InboxMessages. Otherwise, return error
```
public static void messagesCount(Callback<Integer, InboxMessagesException> callback) 
```
---
### loadMessages(Callback) <a name="loadMessages(Callback)"></a>
 Get the collection of the [InboxMessage](InboxMessage) that the user received

 
* **callback** - - if successful, return the collection of the InboxMessages. Otherwise, return error
```
public static void loadMessages(Callback<Collection<InboxMessage>, InboxMessagesException> callback) 
```
---
### readMessage(String) <a name="readMessage(String)"></a>
 Call this method, when the user reads the [InboxMessage](InboxMessage)

 
* **code** - of the inboxMessage
```
public static void readMessage(String code) 
```
---
### readMessages(Collection) <a name="readMessages(Collection)"></a>
 Call this method, when the user reads list of [InboxMessage](InboxMessage)

 
* **codes** - of the inboxMessages
```
@SuppressWarnings("WeakerAccess")
public static void readMessages(Collection<String> codes) 
```
---
### performAction(String) <a name="performAction(String)"></a>
 Call this method, when the user clicks on the [InboxMessage](InboxMessage) and the message's action is performed

 
* **code** - of the inboxMessage that the user tapped
```
public static void performAction(String code) 
```
---
### deleteMessage(String) <a name="deleteMessage(String)"></a>
 Call this method, when the user deletes the [InboxMessage](InboxMessage) manually

 
* **code** - of the inboxMessage that the user deleted
```
public static void deleteMessage(String code) 
```
---
### deleteMessages(Collection) <a name="deleteMessages(Collection)"></a>
 Call this method, when the user deletes the list of [InboxMessage](InboxMessage) manually

 
* **codes** - of the list of [InboxMessage#getCode()](InboxMessage.md#getCode()) that the user deleted
```
@SuppressWarnings("WeakerAccess")
public static void deleteMessages(Collection<String> codes) 
```
---
