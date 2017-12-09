### TagsBundle <a name="TagsBundle"></a>
Immutable collection of tags specific for current device. Tags are used to target different audience selectively when sending push notification.

 [Segmentation guide](http://docs.pushwoosh.com/docs/segmentation-tags-and-filters)
```
public class TagsBundle
```
---
### Builder <a name="Builder"></a>
TagsBundle.Builder class is used to generate TagsBundle instances
```
public static class Builder
```
---
### putInt(String, int) <a name="putInt(String,int)"></a>
Adds tag with integer value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putInt(String key, int value)
```
---
### putLong(String, long) <a name="putLong(String,long)"></a>
Adds tag with long value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putLong(String key, long value)
```
---
### incrementInt(String, int) <a name="incrementInt(String,int)"></a>
Adds increment operation for given tag

   
* **key** - tag name
* **value** - incremental value
* **Return Value** - builder
```
public Builder incrementInt(String key, int value)
```
---
### putBoolean(String, boolean) <a name="putBoolean(String,boolean)"></a>
Adds tag with boolean value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putBoolean(String key, boolean value)
```
---
### putString(String, String) <a name="putString(String,String)"></a>
Adds tag with string value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putString(String key, String value)
```
---
### putList(String, List) <a name="putList(String,List)"></a>
Adds tag with list value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putList(String key, List<String> value)
```
---
### putDate(String, Date) <a name="putDate(String,Date)"></a>
Adds tag with date value

   
* **key** - tag name
* **value** - tag value
* **Return Value** - builder
```
public Builder putDate(String key, Date value)
```
---
### remove(String) <a name="remove(String)"></a>
Removes tag

  
* **key** - tag name
* **Return Value** - builder
```
public Builder remove(String key)
```
---
### putAll(JSONObject) <a name="putAll(JSONObject)"></a>
Adds all tags from key-value pairs of given json

  @return
* **json** - json object with tag name-value pairs
```
public Builder putAll(JSONObject json)
```
---
### build() <a name="build()"></a>
Builds and returns TagsBundle.

 
* **Return Value** - TagsBundle
```
public TagsBundle build()
```
---
### getInt(String, int) <a name="getInt(String,int)"></a>
  
* **key** - tag name
* **defaultValue** - default tag value
* **Return Value** - tag value for given name or defaultValue if tag with given name does not exist
```
public int getInt(String key, int defaultValue)
```
---
### getLong(String, long) <a name="getLong(String,long)"></a>
  
* **key** - tag name
* **defaultValue** - default tag value
* **Return Value** - tag value for given name or defaultValue if tag with given name does not exist
```
public long getLong(String key, long defaultValue)
```
---
### getBoolean(String, boolean) <a name="getBoolean(String,boolean)"></a>
  
* **key** - tag name
* **defaultValue** - default tag value
* **Return Value** - tag value for given name or defaultValue if tag with given name does not exist
```
public boolean getBoolean(String key, boolean defaultValue)
```
---
###  <a name=""></a>
 
* **key** - tag name
* **Return Value** - tag value for given name or null if tag with given name does not exist
```
@Nullable
public String getString(String key)
```
---
###  <a name=""></a>
 
* **key** - tag name
* **Return Value** - tag value for given name or null if tag with given name does not exist
```
@Nullable
public List<String> getList(String key)
```
---
###  <a name=""></a>

* **Return Value** - JSON representation of TagsBundle
```
@NonNull
public JSONObject toJson()
```
---
