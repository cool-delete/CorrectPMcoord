package cool_delete.correctpmcoord;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by Administrator on 2016/7/23.
 */
public class correctUit {

    private static double pi = 3.14159265358979324;

    public static double[] transform(double wgLat, double wgLon) {
        double[] d = new double[]{wgLat, wgLon};
        if (!isflatlands(d)) {

            if (bigChina(d)) {
                if (istaiwan(d) || IsHongKong(d) || IsMaco(d)) {
                    return d;
                }
            } else if (!isNortheast(d)) {
                if (!isSinkiang(d)) {
                    return d;
                }

            } else return d;
        }
        double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
        double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
        double radLat = wgLat / 180.0 * pi;
        double magic = Math.sin(radLat);
        double ee = 0.00669342162296594323;
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        double a = 6378245.0;
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);

        return new double[]{wgLat + dLat, wgLon + dLon};
    }

    private static boolean IsHongKong(double[] doubles) {
        return VincentyDistance(new double[]{22.167733, 114.232372, doubles[0], doubles[1]}) < 41875;
    }

    private static boolean istaiwan(double[] doubles) {
        return VincentyDistance(new double[]{23.737169, 120.861706, doubles[0], doubles[1]}) < 210683;
    }
//    澳门 中心点 22.193464, 113.556572 不需要转换

    private static boolean IsMaco(double[] doubles) {
        double[] center = {doubles[0], doubles[1], 22.193464, 113.556572};
        double[] center2 = {doubles[0], doubles[1], 22.141042, 113.568958};
        double[] center3 = {doubles[0], doubles[1], 22.131106, 113.512306};
        return VincentyDistance(center) < 2876 || VincentyDistance(center2) < 3806 && !(VincentyDistance(center3) < 4121);
    }

    //中国大圆中国大圆 中心点 30.426389, 111.695222
//    1445094.38米

    private static boolean isflatlands(double[] doubles) {
        return VincentyDistance(new double[]{30.647753, 113.649397, doubles[0], doubles[1]}) < 900992;
    }

    private static boolean bigChina(double[] doubles) {
        double[] center = {30.426389, 111.695222};
        double[] center1 = {19.327536, 104.523831, doubles[0], doubles[1]};

        return VincentyDistance(new double[]{center[0], center[1], doubles[0], doubles[1]}) < 1453117 && !(VincentyDistance(center1) < 415116);
    }

    // 中心点 44.058328, 122.859581
//    1035763
    private static boolean isNortheast(double[] doubles) {
        if (VincentyDistance(new double[]{42.631033, 119.845314, doubles[0], doubles[1]}) < 452922) {//小鸡头
            return true;
        } else {

            double[] center = {44.058328, 122.859581, doubles[0], doubles[1]};
            double[] center1 = {34.434444, 132.415622, doubles[0], doubles[1]};//
            double[] center2 = {44.657797, 131.897394, doubles[0], doubles[1]};//
            double[] center4 = {42.693678, 134.932075, doubles[0], doubles[1]};//
            double[] center5 = {45.011725, 139.522514, doubles[0], doubles[1]};
            double[] center6 = {52.181483, 132.985406, doubles[0], doubles[1]};
            double[] center7 = {51.677600, 102.772353, doubles[0], doubles[1]};
            return VincentyDistance(center) < 1037119 && !(VincentyDistance(center1) < 918220 || VincentyDistance(center2) < 57154
                    || VincentyDistance(center4) < 307294 || VincentyDistance(center5) < 476657 || VincentyDistance(center6) < 466000 || VincentyDistance(center7) < 1053281);
        }
    }

    //    中心点 38.214811, 89.010628
//            1141248
    private static boolean isSinkiang(double[] doubles) {
        double[] center = {doubles[0], doubles[1], 38.214811, 89.010628};
        double[] center1 = {doubles[0], doubles[1], 51.677600, 102.772353};
        return VincentyDistance(center) < 1140389 && !(VincentyDistance(center1) < 1052770);
    }


    private static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
        return ret;
    }

    private static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double HaverSin(double theta) {
        double v = Math.sin(theta / 2);
        return v * v;
    }

    public static double VincentyDistance(double[] doubles) {
        double _radiusA = 6378173;

        double lat1 = Math.toRadians(doubles[0]);
        double lng1 = Math.toRadians(doubles[1]);
        double lat2 = Math.toRadians(doubles[2]);
        double lng2 = Math.toRadians(doubles[3]);

        //差值
        double vLon = Math.abs(lng1 - lng2);
        double vLat = Math.abs(lat1 - lat2);

        //h is the great circle distance in radians, great circle就是一个球体上的切面，它的圆心即是球心的一个周长最大的圆。
        double h = HaverSin(vLat) + Math.cos(lat1) * Math.cos(lat2) * HaverSin(vLon);

        return 2 * _radiusA * Math.asin(Math.sqrt(h));


    }
}
