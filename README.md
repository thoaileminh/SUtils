## SUtils
An Utility for Android applications (4.0+).

[![](https://jitpack.io/v/thoaileminh/SUtils.svg)](https://jitpack.io/#thoaileminh/SUtils)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


## How to use SUtils

##### Step 1. Add the JitPack repository to your build file
Add this in your root `build.gradle` file (**not** your app `build.gradle` file):

```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

##### Step 2. Add the library to your app `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.thoaileminh:SUtils:3.0'
    //or compile 'com.github.thoaileminh:SUtils:3.0'
}
```


## Example usage
It's very easy to use, just call any function utility you want, for example:

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SUtils.hideSoftKeyboard(this)

        SUtils.checkNetworkConnected(this, lnMain, false)
    }
}

```


# Explorer more function:
```kotlin

//AnimationHelper-------------------------------------------------------------------------
    //animation zoom out image
    SUtils.animImageZoomOut(this, ivYourImage)


//ApiHelper-------------------------------------------------------------------------------
    //check key of value String is exits into json or not, if not return null
    var myStr = SUtils.checkKeyStringExits(yourJson, "yourKey")

    //check key of value Integer is exits into json or not, if not return 0
    var myInt = SUtils.checkKeyIntExits(yourJson, "yourKey")

    //check key of value BigDecimal is exits into json or not, if not return 0
    var myBD = SUtils.checkKeyBigDecimalExits(yourJson, "yourKey")

    //check key of value Boolean is exits into json or not, if not return false
    var isCheck = SUtils.checkKeyBooleanExits(yourJson, "yourKey")

    //check special key of value String is exits into json or not, if not return special value
    var myStr =  SUtils.checkKeySpecialStringtExits(yourJson, "yourKey", "yourSpecialValue")
   
    //check special key of value Integer is exits into json or not, if not return special value
    var myInt =  SUtils.checkKeySpecialIntExits(yourJson, "yourKey", 999)

    //check special key of value BigDecimal is exits into json or not, if not return special value
    var myBC =  SUtils.checkKeySpecialBigDecimalExits(yourJson, "yourKey", BigDecimal("999"))

    //check special key of value Boolean is exits into json or not, iif not return special value
    var isCheck =  SUtils.checkKeyBooleanExits(yourJson, "yourKey", true)
 
 
//FacebookHelper--------------------------------------------------------------------------
   //get keyHash for longIn facebook
   var keyHash =  SUtils.getKeyHashesLoginFacebook(this, "com.your.packagename")
   
   
//HTMLHelper------------------------------------------------------------------------------
    //load HTML in TextView
    SUtils.loadHTMLinTextView(tvYourTextView, "yourHTML")
    
    //load HTML and optimize WebView
    SUtils.loadHTMLinWebView(tvYourWebView, "yourHTML")
    
    
//ImageHelper-----------------------------------------------------------------------------   
    //get bitmap from image URL
     var bitmap = SUtils.getBitmapFromURL("yourImageURL")
     
    //get bitmap from image in drawable folder
    var bitmap = SUtils.getBitmapFromDrawable(resources.getDrawable(R.drawable.ic_launcher))
    or
    var bitmap = SUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher)!!)
    
    //get real bitmap with orientation
    var bitmap = SUtils.getRealBitmapOrientation(yourBitmap, yourImagePath)
    
    //get bitmap rotate image with degrees
    var bitmap = SUtils.getBitmapRotateImage(yourBitmap, 190)
   
    //get URI from image file local
    var uri = SUtils.getUriFromImageFile(this, yourImageFile)

    //get path from image URI local
    var path = SUtils.getPathFromImageUri(this, yourImageUri)
   
    //get path from cursor
    var path = SUtils.getPathFromCursor(this, yourImageCursor)
   
   
//LogHelper-------------------------------------------------------------------------------
    //check set show logcat or hide
    SUtils.setShowLogOrNot(true)
    
    //action show logcat type: Error
    SUtils.showLog("your message")
    
    
//NetworkHelper---------------------------------------------------------------------------
    //check internet connected or not, if lost show snack bar alert at view your set
    if (!CheckNetwork.isConnected(this, rlMain, false))
            return
            

//OSHelper--------------------------------------------------------------------------------
    //hide keyboard
    SUtils.hideSoftKeyboard(this)
    
     //show keyboard
    SUtils.showSoftKeyboard(this)
    
    //show snack bar short
     SUtils.showSnackBar(rlMain, R.string.str_your_message)
     
     //show snack bar long
     SUtils.showSnackBarLong(rlMain, R.string.str_your_message)
     
     //show snack bar indefinite
     SUtils.showSnackBarIndefinite(rlMain, R.string.str_your_message)
      
     //get current app version
     var currenVersion =  SUtils.getAppVersion(this)
    
    
//PermissionHelper------------------------------------------------------------------------
     //check permission is granted or not
     var isGranted =  SUtils.isGrantedPermission(this, Manifest.permission.CAMERA)
     
     
//StringHelper----------------------------------------------------------------------------
    //convert string Vietnamese to English
    var str =  SUtils.convertStrVietnameseToEnglish("Tôi là người Việt Nam")
    
    //count line of content string
    var number =  SUtils.countLines("your string")


//TimeHelper------------------------------------------------------------------------------
    //get current date (dd-MM-yyyy)
    var date = SUtils.getCurrentDate()
    
    //get current date time (dd-MM-yyyy HH:mm:ss)
    var dateTime = SUtils.getCurrentDateTime()
    
    //getCurrentTimestamp
    var timeStamp = SUtils.getCurrentTimestamp()
    
    //convert date to timestamp (dd-MM-yyyy)
    var timeStamp = SUtils.convertDateToTimestamp("31-12-2018")
    
    //convert date time to time stamp (dd-MM-yyyy HH:mm:ss)
    var timeStamp = SUtils.convertDateTimeToTimestamp("31-12-2018 12:30:00")
    
    //convert time stamp to date
    var date = SUtils.convertTimestampToDate(1546234200000)

   //convert time stamp to date time
    var dateTime = SUtils.convertTimestampToDateTime(1546234200000)
    
    //convert date time to string (dd-MM-yyyy HH:mm:ss)
    var timeStr = SUtils.convertDateTimeToString(this, "21-04-2018 15:30:00")
    
    // format day and month to Vietnamese/English language
    //vi = Vietnamese
    //en = English
    var timeLocal = SUtils.convertMonthDayLocaleString(this, "vi" , 12, 31)


//OtherHelper-----------------------------------------------------------------------------
    //format BigDecimal to currency
    var strFormated = SUtils.formatBigDecimalToCurrency(BigDecimal("10000000"))
    
```



## License

Copyright 2018 Lê Minh Thoại

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and limitations under the License.
