### Tags <a name="Tags"></a>
Static utility class for tags creation
```
public final class Tags
```
---
### intTag(String, int) <a name="intTag(String,int)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of int type
```
public static TagsBundle intTag(String key, int value)
```
---
### longTag(String, long) <a name="longTag(String,long)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of long type
```
public static TagsBundle longTag(String key, long value)
```
---
### booleanTag(String, boolean) <a name="booleanTag(String,boolean)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of boolean type
```
public static TagsBundle booleanTag(String key, boolean value)
```
---
### stringTag(String, String) <a name="stringTag(String,String)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of string type
```
public static TagsBundle stringTag(String key, String value)
```
---
### listTag(String, List) <a name="listTag(String,List)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of list type
```
public static TagsBundle listTag(String key, List<String> value)
```
---
### dateTag(String, Date) <a name="dateTag(String,Date)"></a>
  
* **key** - tag name
* **value** - tag value
* **Return Value** - TagsBundle with single tag of Date type
```
public static TagsBundle dateTag(String key, Date value)
```
---
### removeTag(String) <a name="removeTag(String)"></a>
 
* **key** - tag name
* **Return Value** - TagsBundle for tag removal
```
public static TagsBundle removeTag(String key)
```
---
### fromJson(JSONObject) <a name="fromJson(JSONObject)"></a>
 
* **json** - json object with tag name-value pairs
* **Return Value** - converted tags
```
public static TagsBundle fromJson(JSONObject json)
```
---
### incrementInt(String, int) <a name="incrementInt(String,int)"></a>
  
* **key** - tag name
* **delta** - incremental value
* **Return Value** - TagsBundle for tag increment operation
```
public static TagsBundle incrementInt(String key, int delta)
```
---
### empty() <a name="empty()"></a>

* **Return Value** - empty TagsBundle
```
public static TagsBundle empty()
```
---
