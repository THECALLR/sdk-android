sdk-android
===========

SDK in Java (Android) for CALLR API

## Dependencies
The CALLR API is in JSON which needs to be parsed.
This SDK is based on google-gson to parse json, and apache commons codec to encode base64.
So it need to be added as well as our SDK in you project (see [jars](jars/) folder).

See [https://code.google.com/p/google-gson/](https://code.google.com/p/google-gson/) for more information on google-gson.
and [https://commons.apache.org/proper/commons-codec/](https://commons.apache.org/proper/commons-codec/) for the apache commons codec.

The [jars](jars/) folder contains the jar of the CALLR Java SDK.

## Basic Example (Send SMS)
See full example in [samples](samples/) - This can be imported into Android Studio as a gradle based project.

```java
// Set your credentials
Api tc = new Api(new LoginPasswordAuth("login", "password"), null);

Hashtable<String, Object> param = new Hashtable<String, Object>();
param.put("flash_message", false);

try {
	JsonElement result = tc.call("sms.send", "SMS", "+33123456789", "Hello, world", param);
	System.out.println(result.getAsString());
} catch (ThecallrException e) {
	System.out.println(e.getMessage());
	System.out.println(e.data);
}
```
