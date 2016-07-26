package cool_delete.correctpmcoord;

import android.location.Location;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by Administrator on 2016/7/14.
 */
public class xposed implements IXposedHookLoadPackage {

    private Class<?> loc;
    private Class<?> UpsightLocationTracker_data;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.nianticlabs.pokemongo")) {
            XposedHelpers.findAndHookMethod("com.nianticlabs.nia.location.NianticLocationManager", loadPackageParam.classLoader, "locationUpdate",
                    Location.class,
                    int[].class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.args[0] instanceof Location) {

                        double longitude = ((Location) param.args[0]).getLongitude();
                        double latitude = ((Location) param.args[0]).getLatitude();
//                        param.setResult(param.getResult());
                        Location old = (Location) param.args[0];
                        double[] loct = correctUit.transform(latitude, longitude);
                        old.setLatitude(loct[0]);
                        old.setLongitude(loct[1]);
//                        param.args[0] = old;
                    }
                }
            });
//            XposedHelpers.findAndHookMethod("com.nianticlabs.nia.location.NianticLocationManager", loadPackageParam.classLoader, "nativeLocationUpdate", Location.class, int[].class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                    if (param.getResult() instanceof Location) {
////                        double longitude = ((Location) param.getResult()).getLongitude();
////                        double latitude = ((Location) param.getResult()).getLatitude();
////                        param.setResult(param.getResult());
//                        XposedBridge.log("com.nianticlabs.nia.location.nativeLocationUpdate本地传来经纬度了");
//                    }
//                }
//            });
            XposedHelpers.findAndHookMethod("com.nianticlabs.nia.location.LocationManagerProvider", loadPackageParam.classLoader, "updateLocation", Location.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("com.nianticlabs.nia.location.LocationManagerProvider的updateLocation传来经纬度了");
                    }
                }
            });
            XposedHelpers.findAndHookMethod("com.unity3d.player.r", loadPackageParam.classLoader, "a", Location.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("com.unity3d.player.r一个参数传来经纬度了");
                    }
                }
            });
            XposedHelpers.findAndHookMethod("com.unity3d.player.r", loadPackageParam.classLoader, "a", Location.class, Location.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("com.unity3d.player.r二个参数传来经纬度了");
                    }
                }
            });

            XposedHelpers.findAndHookMethod("crittercism.android.bc", loadPackageParam.classLoader, "a", Location.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                        XposedBridge.log("Bc传来经纬度了");
                    if (param.args[0] instanceof Location) {

                        double longitude = ((Location) param.args[0]).getLongitude();
                        double latitude = ((Location) param.args[0]).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("Bc传来经纬度了"+"精度: "+longitude+"纬度: "+latitude);
                    }
                }
            });
            XposedHelpers.findAndHookMethod("crittercism.android.bc", loadPackageParam.classLoader, "a", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("Bc返回函数传来经纬度了");
                    }
                }
            });

            XposedHelpers.findAndHookMethod("com.crittercism.app.Crittercism", loadPackageParam.classLoader, "updateLocation", Location.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("com.crittercism.app.Crittercism传来经纬度了");
                    }
                }
            });
            XposedHelpers.findAndHookMethod("com.google.ads.mediation.MediationAdRequest", loadPackageParam.classLoader, "getLocation", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    if (param.getResult() instanceof Location) {
//                        double longitude = ((Location) param.getResult()).getLongitude();
//                        double latitude = ((Location) param.getResult()).getLatitude();
//                        param.setResult(param.getResult());
                        XposedBridge.log("com.crittercism.app.Crittercism传来经纬度了");
                    }
                }
            });
//            XposedBridge.hookAllConstructors("com.google.ads.mediation.MediationAdRequest", loadPackageParam.classLoader, Date.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                    if (param.getResult() instanceof Location) {
////                        double longitude = ((Location) param.getResult()).getLongitude();
////                        double latitude = ((Location) param.getResult()).getLatitude();
////                        param.setResult(param.getResult());
//                        XposedBridge.log("com.crittercism.app.Crittercism传来经纬度了");
//                    }
//                }
//            });
//            UpsightLocationTracker_data = loadPackageParam.classLoader.loadClass("com.upsight.android.analytics.provider.UpsightLocationTracker$Data");
//            XposedHelpers.findAndHookMethod("com.upsight.android.analytics.internal.provider.LocationTracker", loadPackageParam.classLoader, "track", UpsightLocationTracker_data, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    param.
//                }
//            });
        }
    }
}
