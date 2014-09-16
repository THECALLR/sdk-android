sdk-android
===========

SDK in Java (Android) for THECALLR API

## Dependencies
Thecallr API is in JSON which need to be parsed.
This SDK is based on google-gson to parse json.
So it need to be added as well as our SDK in you project (see [jars](jars/) folder).

See https://code.google.com/p/google-gson/ for more information on google-gson.

The [jars](jars/) folder contains the jar of Thecallr SDK and the version
of google-gson which was used to build this SDK.

## Basic Example (Send SMS)
See full example in [samples](samples/)

```java
// Set your credentials
Api tc = new Api("login", "password");

Hashtable<String, Object> param = new Hashtable<String, Object>();
param.put("flash_message", false);

try {
	JsonElement result = tc.call("sms.send", "THECALLR", "+33123456789", "Hello, world", param);
	System.out.println(result.getAsString());
} catch (ThecallrException e) {
	System.out.println(e.getMessage());
	System.out.println(e.data);
}
```
