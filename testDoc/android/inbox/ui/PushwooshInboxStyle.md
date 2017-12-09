### EMPTY_ANIMATION <a name="EMPTY_ANIMATION"></a>
Use this property for clearing list animation [#listAnimation](#listAnimation)
```
const val EMPTY_ANIMATION = -1
```
---
### dateFormatter <a name="dateFormatter"></a>
Inbox message date format.
 By default used [DEFAULT_DATE_FORMAT](inbox/ui/model/customizing/formatter/InboxDateFormatter.md) format
```
var dateFormatter: InboxDateFormatter = DefaultDateFormatter()
```
---
### listAnimation <a name="listAnimation"></a>
Item appearing animation. Set [#EMPTY_ANIMATION](#EMPTY_ANIMATION) for clear animation
```
@AnimRes
var listAnimation: Int = android.R.anim.slide_in_left
```
---
### defaultImageIcon <a name="defaultImageIcon"></a>
The icon shown near the message if there's no icon in push payload. If not specified, the app icon is used
```
@DrawableRes
var defaultImageIcon: Int = -1
```
---
### listErrorImage <a name="listErrorImage"></a>
The image which is displayed if an error occurs and the list of inbox messages is empty
```
var listErrorImage = R.drawable.inbox_ic_error
```
---
### listErrorMessage <a name="listErrorMessage"></a>
The error text which is displayed when an error occurs
```
var listErrorMessage: CharSequence? = "It seems something went wrong. Please try again later!"
```
---
### listEmptyImage <a name="listEmptyImage"></a>
The image which is displayed if the list of inbox messages is empty
```
var listEmptyImage = R.drawable.inbox_ic_empty
```
---
### listEmptyText <a name="listEmptyText"></a>
The text which is displayed if the list of inbox messages is empty
```
var listEmptyText: CharSequence? = "Currently there are no messages in the Inbox."
```
---
### accentColor <a name="accentColor"></a>
Accent color of inbox cell. By default used AppCompat R.attr.colorAccent
```
@ColorRes
var accentColor: Int? = null
```
---
### backgroundColor <a name="backgroundColor"></a>
The color of cell background. By default used Android android.R.attr.windowBackground
```
@ColorRes
var backgroundColor: Int? = null
```
---
### highlightColor <a name="highlightColor"></a>
The color of cell highlight. By default used AppCompat R.attr.colorControlHighlight
```
@ColorRes
var highlightColor: Int? = null
```
---
### imageTypeColor <a name="imageTypeColor"></a>
The color of the unread message action icon (Deep Link, URL, etc.). By default used [#accentColor](#accentColor)
```
@ColorRes
var imageTypeColor: Int? = null
```
---
### readImageTypeColor <a name="readImageTypeColor"></a>
The color of the read message action icon. By default used [#readDateColor](#readDateColor)
```
@ColorRes
var readImageTypeColor: Int? = null
```
---
### titleColor <a name="titleColor"></a>
The title color of unread messages. By default used Android android.R.attr.textColorPrimary
```
@ColorRes
var titleColor: Int? = null
```
---
### readTitleColor <a name="readTitleColor"></a>
The title color of read messages. By default used Android android.R.attr.textColorSecondary
```
@ColorRes
var readTitleColor: Int? = null
```
---
### descriptionColor <a name="descriptionColor"></a>
The text color of unread messages. By default used Android android.R.attr.textColorSecondary
```
@ColorRes
var descriptionColor: Int? = null
```
---
### readDescriptionColor <a name="readDescriptionColor"></a>
The text color of read messages. By default used Android android.R.attr.textColorSecondary
```
@ColorRes
var readDescriptionColor: Int? = null
```
---
### dateColor <a name="dateColor"></a>
The date color of unread messages. By default used Android android.R.attr.textColorSecondary
```
@ColorRes
var dateColor: Int? = null
```
---
### readDateColor <a name="readDateColor"></a>
The date color of read messages. By default used Android android.R.attr.textColorSecondary
```
@ColorRes
var readDateColor: Int? = null
```
---
### dividerColor <a name="dividerColor"></a>
The divider color. By default used Android android.R.attr.listDivider
```
@ColorRes
var dividerColor: Int? = null
```
---
###  <a name=""></a>
Clear all setting colors
```
fun clearColors()
```
---
