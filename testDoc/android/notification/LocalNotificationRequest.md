### LocalNotificationRequest <a name="LocalNotificationRequest"></a>
Manages local notification schedule.
```
public class LocalNotificationRequest implements Serializable
```
---
### cancel() <a name="cancel()"></a>
Cancels local notification associated with this request and unschedules notification if it was not displayed yet.
```
public void cancel()
```
---
### unschedule() <a name="unschedule()"></a>
Undo [scheduleLocalNotification(LocalNotification)](Pushwoosh.md). If notification has been displayed it will not be deleted.
```
public void unschedule()
```
---
