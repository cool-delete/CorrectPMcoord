package cool_delete.correctpmcoord;

/**
 * Created by Administrator on 2016/7/23.
 */
public class correctUit {

    private static double pi = 3.14159265358979324;

    public static double[] transform(double wgLat, double wgLon) {
        double[] d = new double[]{wgLat, wgLon};
        if (!(Ischinamid(d) || Islasaanhui(d) || sadssaasaw(d) || dali(d) || sadw(d) || sadsaw(d) || IsChinaab(d) || IsChinaac(d) || IsChinadasdsawsa(d) || IsChinadasdw(d) ||
                        IsChinadasdwsa(d) || IsChinadwd(d) || IsChinasa(d) || Islasa(d) || Islsa(d) || IsChinasd(d) || IsChinadsasdsawsa(d) || Ismegodsasdsawsa(d) ||
                        Ismegodsasdsawsasa(d) || Isyunnan(d) || Isyunnansad(d) || dalisa(d) || sadsasaw(d) ||
                        sasadssaasaw(d))) {
        } else if ((IsHongKong(d) || IsMaco(d))) {
            return d;
            //不转换
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

        return 21.803618 < doubles[0] && doubles[0] < 22.502207 && doubles[1] > 113.784522 && doubles[1] < 114.114391;
    }

    private static boolean IsMaco(double[] doubles) {

        return 22.110815 < doubles[0] && doubles[0] < 22.1974637 && doubles[1] > 113.576953 && doubles[1] < 113.612315;
    }

    private static boolean Ischinamid(double[] doubles) {

        return 30.446978 < doubles[0] && doubles[0] < 41.577437 && doubles[1] > 81.621219 && doubles[1] < 117.590609;
    }//鸡眼

    private static boolean IsChinaab(double[] doubles) {

        return 41.577437 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 117.590609 && doubles[1] < 126.578862;
    }

    //鸡冠
    private static boolean IsChinaac(double[] doubles) {

        return 46.514702 < doubles[0] && doubles[0] < 53.562203 && doubles[1] > 117.590609 && doubles[1] < 134.767475;
    }

    //从下往上1
    private static boolean IsChinasa(double[] doubles) {

        return 41.577437 < doubles[0] && doubles[0] < 42.384865 && doubles[1] > 126.578862 && doubles[1] < 128.041590;
    }

    //从下往上2
    private static boolean IsChinasd(double[] doubles) {

        return 42.022723 < doubles[0] && doubles[0] < 42.384865 && doubles[1] > 128.041590 && doubles[1] < 128.964441;
    }

    //42.384861, 128.041583到 43.014628, 129.843348
    private static boolean IsChinadwd(double[] doubles) {

        return 42.384861 < doubles[0] && doubles[0] < 43.014628 && doubles[1] > 128.041583 && doubles[1] < 129.843348;
    }

    //    43.014628,129.843348 到 44.807133,131.425378
    private static boolean IsChinadasdw(double[] doubles) {

        return 43.014628 < doubles[0] && doubles[0] < 44.807133 && doubles[1] > 129.843348 && doubles[1] < 131.425378;
    }

    //    44.807133,131.425378 到  46.514702,134.767475
    private static boolean IsChinadasdwsa(double[] doubles) {

        return 44.807133 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 131.425378 && doubles[1] < 134.767475;
    }

    //    46.514702,126.578862 dao  41.490017,127.162683
    private static boolean IsChinadasdsawsa(double[] doubles) {

        return 41.490017 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 126.578862 && doubles[1] < 127.162683;
    }

    //        46.514702,126.578862 dao  42.384865,128.041590
    private static boolean IsChinadsasdsawsa(double[] doubles) {

        return 42.384865 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 126.578862 && doubles[1] < 128.041590;
    }
/////以上鸡头完成

    //以下蒙古and内蒙古包括乌鲁木齐 新疆道路
//    41.577437,80.421735 到 46.514702,117.590609
    private static boolean Ismegodsasdsawsa(double[] doubles) {

        return 41.577437 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 80.421735 && doubles[1] < 117.590609;
    }//新疆

    //    37.031062, 74.825134 到 41.577437, 80.421735
    private static boolean Ismegodsasdsawsasa(double[] doubles) {

        return 37.031062 < doubles[0] && doubles[0] < 41.577437 && doubles[1] > 74.825134 && doubles[1] < 80.421735;
    }

    //以下西双版纳
//    21.904831, 101.708679到  23.008556, 98.978870
    private static boolean Isyunnan(double[] doubles) {

        return 21.904831 < doubles[0] && doubles[0] < 23.008556 && doubles[1] > 98.978870 && doubles[1] < 101.708679;
    }

    //昆明到南宁之间
//    22.816715, 106.792602到 29.606909,96.152343
    private static boolean Isyunnansad(double[] doubles) {
        return 22.816715 < doubles[0] && doubles[0] < 29.606909 && doubles[1] > 96.152343 && doubles[1] < 106.792602;
    }

    //拉萨市
//    29.606909,96.152343 到 30.446978,81.621219
    private static boolean Islasa(double[] doubles) {
        return 29.606909 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 81.621219 && doubles[1] < 96.152343;
    }

    //拉萨到安徽
//    29.606909,96.152343 到 30.446978,117.590609
    private static boolean Islasaanhui(double[] doubles) {
        return 29.606909 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 96.152343 && doubles[1] < 117.590609;
    }

    //崇左市
//        22.816715,106.792602 到 21.657005,107.976672
    private static boolean Islsa(double[] doubles) {
        return 21.657005 < doubles[0] && doubles[0] < 22.816715 && doubles[1] > 106.792602 && doubles[1] < 107.976672;
    }

    //北海到安徽
//    22.816715,106.792602 到  30.446978, 117.590609
    private static boolean dali(double[] doubles) {
        return 22.816715 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 106.792602 && doubles[1] < 117.590609;
    }

    //北海到三亚以东
//    18.262574, 111.286827 到 21.657005, 107.976672覆盖海南岛
    private static boolean dalisa(double[] doubles) {
        return 18.262574 < doubles[0] && doubles[0] < 21.657005 && doubles[1] > 107.976672 && doubles[1] < 111.286827;
    }

    //崇左市到安徽
//    22.816715,106.792602 到 30.446978, 117.590609
    private static boolean sadw(double[] doubles) {
        return 22.816715 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 106.792602 && doubles[1] < 117.590609;
    }

    //台南到安徽
//    23.150483, 119.860839 到 30.446978, 117.590609
    private static boolean sadsaw(double[] doubles) {
        return 23.150483 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 117.590609 && doubles[1] < 119.860839;
    }

    //安徽到台北 覆盖舟山
//    25.279496, 122.574462 到 30.446978, 117.590609
    private static boolean sadsasaw(double[] doubles) {
        return 25.279496 < doubles[0] && doubles[0] < 30.446978 && doubles[1] > 122.574462 && doubles[1] < 117.590609;
    }

    //安徽到沈阳
//    41.577437, 124.130455 到 30.446978, 117.590609
    private static boolean sadssaasaw(double[] doubles) {
        return 30.446978 < doubles[0] && doubles[0] < 41.577437 && doubles[1] > 117.590609 && doubles[1] < 124.130455;
    }

    //丹东到哈尔滨覆盖鸭绿江
//    39.970831, 124.326781 到 46.514702, 126.578862
    private static boolean sasadssaasaw(double[] doubles) {
        return 30.446978 < doubles[0] && doubles[0] < 46.514702 && doubles[1] > 124.326781 && doubles[1] < 126.578862;
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

}
