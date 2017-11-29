### PWJavaScriptInterface <a name="PWJavaScriptInterface"></a>
`PWJavaScriptInterface` protocol is a representation of Javascript object that can be added at runtime into In-App Message HTML page
to provide native calls and callbacks to Objective-C/Swift.

Example:

```ObjC
@implementation JavaScriptInterface

- (void)nativeCall:(NSString*)str :(PWJavaScriptCallback*)callback {
[callback executeWithParam:str];
}

@end

...

[[PWInAppManager sharedManager] addJavascriptInterface:[JavaScriptInterface new] withName:@"ObjC"];
```

```javascript
ObjC.nativeCall("exampleString", function(str) {
console.log(str);
});
```
```
@protocol PWJavaScriptInterface
```
---
### onWebViewStartLoad: <a name="onWebViewStartLoad:"></a>
Tells the delegate that In-App Message load stated
```
- (void)onWebViewStartLoad:(UIWebView*)webView
```
---
### onWebViewFinishLoad: <a name="onWebViewFinishLoad:"></a>
Tells the delegate that In-App Message load finished
```
- (void)onWebViewFinishLoad:(UIWebView*)webView
```
---
### onWebViewStartClose: <a name="onWebViewStartClose:"></a>
Tells the delegate that In-App Message is closing
```
- (void)onWebViewStartClose:(UIWebView*)webView
```
---
### PWJavaScriptCallback <a name="PWJavaScriptCallback"></a>
`PWJavaScriptCallback` is a representation of Javascript function
```
@interface PWJavaScriptCallback : NSObject
```
---
###  <a name=""></a>
Invokes callback with no arguments
```
- (NSString*) execute
```
---
###  <a name=""></a>
Invokes callback with one argument
```
- (NSString*) executeWithParam: (NSString*) param
```
---
###  <a name=""></a>
Invokes callback with multiple arguments
```
- (NSString*) executeWithParams: (NSArray*) params
```
---
### setUserId: <a name="setUserId:"></a>
Set User indentifier. This could be Facebook ID, username or email, or any other user ID.
This allows data and events to be matched across multiple user devices.
```
- (void)setUserId:(NSString *)userId
```
---
### mergeUserId:to:doMerge:completion: <a name="mergeUserId:to:doMerge:completion:"></a>
Move all events from oldUserId to newUserId if doMerge is true. If doMerge is false all events for oldUserId are removed.


* **oldUserId** - source user
* **newUserId** - destination user
* **doMerge** - if false all events for oldUserId are removed, if true all events for oldUserId are moved to newUserId
* **completion** - callback
```
- (void)mergeUserId:(NSString *)oldUserId to:(NSString *)newUserId doMerge:(BOOL)doMerge completion:(void (^)(NSError *error))completion
```
---
### postEvent:withAttributes:completion: <a name="postEvent:withAttributes:completion:"></a>
Post events for In-App Messages. This can trigger In-App message display as specified in Pushwoosh Control Panel.

Example:
```objC
[[PWInAppManager sharedManager] setUserId:@"96da2f590cd7246bbde0051047b0d6f7"];
[[PWInAppManager sharedManager] postEvent:@"buttonPressed" withAttributes:@{ @"buttonNumber" : @"4", @"buttonLabel" : @"Banner" } completion:nil];

```

* **event** - name of the event
* **attributes** - NSDictionary of event attributes
* **completion** - function to call after posting event
```
- (void)postEvent:(NSString *)event withAttributes:(NSDictionary *)attributes completion:(void (^)(NSError *error))completion
```
---
### postEvent:withAttributes: <a name="postEvent:withAttributes:"></a>
See `postEvent:withAttributes:completion:`
```
- (void)postEvent:(NSString *)event withAttributes:(NSDictionary *)attributes
```
---
### addJavascriptInterface: <a name="addJavascriptInterface:"></a>
Adds javascript interface for In-App Messages. Interface will be accessible from javascript as object with specified `name` and functions defined in `interface` class.
```
- (void)addJavascriptInterface:(NSObject<PWJavaScriptInterface>*)interface withName:(NSString*)name
```
---
