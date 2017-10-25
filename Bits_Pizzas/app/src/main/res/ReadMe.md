A theme is a style that’s applied to an activity or application so that your app has a consistent look and feel.

The Support Libraries mean that you can give users on older devices the
same experience as users on newer devices even if they’re using different versions of
Android. Each library includes a specific set of features.


The v7 AppCompat Library contains a set of up-to-date themes that can be used with older versions of Android: 
in practice, they can be used with nearly all devices, as most people are using API level 19 or above.

If you want to use the AppCompat themes, however, you need to use a special kind of activity, called an AppCompatActivity.

The AppCompatActivity class is a subclass of Activity. It lives in the AppCompat Support Library, and it’s designed to work with the AppCompat
themes. Your activity needs to extend the AppCompatActivity class instead of the Activity class 
whenever you want an app bar that provides backward compatibility with older versions of Android.

As AppCompatActivity is a subclass of the Activity class, everything you’ve learned about activities so far still applies. AppCompatActivity works with layouts in just the same way, 
and inherits all the lifecycle methods from the Activity class. The main difference is that, compared to Activity, 
AppCompatActivity contains extra smarts that allow it to work with the themes from the AppCompat Support Library.