"com.android.browser.permission.READ_HISTORY_BOOKMARKS" 
in manifest xml file won't run due to Android 6.0 Changes on bookmark browser behavior

"The android.provider.Browser.getAllBookmarks() and android.provider.Browser.saveBookmark() methods are now removed. Likewise, the READ_HISTORY_BOOKMARKS and WRITE_HISTORY_BOOKMARKS permissions are removed. If your app targets Android 6.0 (API level 23) or higher, don't access bookmarks from the global provider or use the bookmark permissions. Instead, your app should store bookmarks data internally."


However this is the right solution for this exercise with the existed provided code.