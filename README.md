> ## ⚠️ DEPRECATED — Callr API v1 (JSON-RPC)
>
> This SDK targets the **legacy Callr JSON-RPC API (v1)**, which is **deprecated** and **will be shut down on 30 June 2027**. After that date this SDK will stop working.
>
> **➡️ Please migrate to the new Callr REST API v2.**
>
> - 📘 **Migration guide (JSON-RPC → REST API v2):** https://docs.callr.com/reference/migrating-from-json-rpc-v1
> - 📣 **What's new in REST API v2:** https://docs.callr.com/changelog/rest-api-v2-is-here
> - 🌐 **REST API v2 base URL:** `https://api.callr.com/v2.0`
> - ✉️ **Questions / migration help:** support@callr.com
>
> Your existing API credentials work with REST API v2 — **no new keys required**.
>
> **Official Callr REST API v2 SDKs are coming in the near future.** In the meantime, you can call the REST API directly, or generate a client from the OpenAPI 3.1 spec (see **Generate a REST API v2 client today** below).

---

## Generate a REST API v2 client today

**An official Callr REST API v2 SDK for Android / Kotlin is coming soon.** Until then, generate a fully-typed client from the [OpenAPI 3.1 spec](https://api.callr.com/v2.0/openapi.json) with [OpenAPI Generator](https://openapi-generator.tech/) (requires v7.x+ for OpenAPI 3.1):

```bash
docker run --rm -v "$PWD:/local" openapitools/openapi-generator-cli generate \
  -g kotlin \
  -i https://api.callr.com/v2.0/openapi.json \
  -o /local/callr-v2-android
```

Authenticate with your API Key via the `x-api-key` header (or HTTP Basic: Account SID + API Key). The base URL `https://api.callr.com/v2.0` is baked into the generated client — see its generated `docs/` for the available endpoints.

---

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
Api tc = new Api("login", "password");

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
