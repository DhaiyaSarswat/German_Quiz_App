//package com.example.germanquizapp.MoreSettings;
//
//import android.app.Application;
//
//import com.onesignal.OneSignal;
//import com.onesignal.OSPermissionStateChanges;
//import com.onesignal.OneSignal.OSPermissionObserver;
//import com.onesignal.OneSignal.OSPermissionState;
//import com.onesignal.OneSignal.OSSubscriptionObserver;
//import com.onesignal.OSSubscriptionState;
//import com.onesignal.OSSubscriptionStateChanges;
//import com.onesignal.debug.LogLevel;
//
//public class ApplicationClass extends Application {
//
//    // NOTE: Replace the below with your own ONESIGNAL_APP_ID
//    private static final String ONESIGNAL_APP_ID = "a8dfe462-42b3-4375-aea1-d39c6239b65e";
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        // Verbose Logging set to help debug issues, remove before releasing your app.
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
//
//        // OneSignal Initialization
//        OneSignal.initWithContext(this);
//        OneSignal.setAppId(ONESIGNAL_APP_ID);
//
//        // Add Permission Observer
//        OSPermissionObserver permissionObserver = new OSPermissionObserver() {
//            @Override
//            public void onOSPermissionChanged(OSPermissionStateChanges stateChanges) {
//                // Handle permission changes
//            }
//        };
//
//        // Add Subscription Observer
//        OSSubscriptionObserver subscriptionObserver = new OSSubscriptionObserver() {
//            @Override
//            public void onOSSubscriptionChanged(OSSubscriptionStateChanges stateChanges) {
//                // Handle subscription changes
//            }
//        };
//
//        OSPermissionState status = OneSignal.getPermissionState();
//        status.addObserver(permissionObserver);
//        status.addObserver(subscriptionObserver);
//
//        // Request Notification Permission
//        OneSignal.setNotificationWillShowInForegroundHandler(notificationReceivedEvent -> {
//            // Handle notification will show in foreground
//        });
//
//        OneSignal.setNotificationOpenedHandler(notificationOpenedResult -> {
//            // Handle notification opened
//        });
//    }
//}
