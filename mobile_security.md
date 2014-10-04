Mobile Security 
==============


- No system logs in mobile. (Android "read log" access can read all the logs)
- Don't store sensitive data on external storage {removable storage media and an internal storage} (Android)
	- files saved to external storage are world-readable. no security for files.
	- Use *Mode_Private* to create files in internal storage 
- Data protection (iOS)
	- this setting is in Capabilities.
	- can encrypts app files automatically.
	- make them inaccessible when the device is locked.
- Unprotected URL handlers (Android & iOS)  By design but need to be careful.
	- App can receive data from other apps, such as the browser and other apps, such as the browser and other app, using custom URL handlers. Any other app can pretend to be the sender.
		- E.g videoto://yahoo/amar
	- This untrusted data is processed by the app.  
- Javascript Bridge
	- addJavaScriptInterface method, allows JavaScript in a WebView to directly invoke native java methods.
	- Only load HTTPS content from trusted domains
	- For android api 17+, force explicit annotate on those methods with "@JavascriptInterface"
- SSL Certificate Checking Disabled (iOS)
	- App sets the allowInvalidCertificates property to true in order to configure AFNetworking to accept any SSL certificates as valid. This is dangerous.
- WebView Disables same Origin polity
	- Untrusted can read the content of any website or any file stored in the App's folder.
