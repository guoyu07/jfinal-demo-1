package org.seandragon.jfinal.demo.common.until;

import pro.mojo.type.DateFromTo;
import pro.mojo.type.DatePro;
import pro.mojo.type.DecimalObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created By SeanDragon
 * At 2016年10月21日, PM 03:10:19
 * 对pro.cg包的DateFromTo类的一种简易化使用
 */
public class DateFromToUtils {

    /**
     * 获取日期的天的最小时间和最大时间
     *
     * @param datePro 时间
     * @return 起始截止日期
     */
    public static DateFromTo getDayDateFromTo(String fieldName, DatePro datePro) {
        if (datePro == null) return null;
        DatePro from = new DatePro();
        from.toMinDate(datePro.getYear(), datePro.getMonth(), datePro.getDay());
        DatePro to = new DatePro();
        to.toMaxDate(datePro.getYear(), datePro.getMonth(), datePro.getDay());
        return new DateFromTo(fieldName, from, to);
    }

    /**
     * 获取今天的最小时间和最大时间
     *
     * @param datePro 时间
     * @return 起始截止日期
     */
    public static DateFromTo getMonthDateFromTo(String fieldName, DatePro datePro) {
        if (datePro == null) return null;
        DatePro from = new DatePro();
        from.toMinDate(datePro.getYear(), datePro.getMonth());
        DatePro to = new DatePro();
        to.toMaxDate(datePro.getYear(), datePro.getMonth());
        return new DateFromTo(fieldName, from, to);
    }

    /**
     * 获取今天的最小时间和最大时间
     *
     * @param datePro 时间
     * @return 起始截止日期
     */
    public static DateFromTo getYearDateFromTo(String fieldName, DatePro datePro) {
        if (datePro == null) return null;
        DatePro from = new DatePro();
        from.toMinDate(datePro.getYear());
        DatePro to = new DatePro();
        to.toMaxDate(datePro.getYear());
        return new DateFromTo(fieldName, from, to);
    }

    public static DateFromTo nullableSet(DateFromTo dateFromTo) {
        if (dateFromTo.getFrom() == null) {
            dateFromTo.setFrom(new DatePro(new Date(0)));
        }
        if (dateFromTo.getTo() == null) {
            //这里如果没有填写to的日期就是今天的时间加上一个月
            dateFromTo.setTo(new DatePro().addMonth(12));
        }

        return dateFromTo;
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 生成24位时间戳
     *
     * @return
     */
    public static String createBuyId(Date date) {
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            format += r.nextInt(10);
        }
        return format;
    }

    /**
     * 数字格式化
     *
     * @param o double 或者 string
     * @return 格式化后的字符串
     */
    public static String format(Object o) {
        if (null == o)
            return null;

        /*DecimalFormat df = new DecimalFormat(",###.00");

        DecimalObject d = DecimalObject.instance(o.toString());
        if (d.doubleValue() < 1) {
            df = new DecimalFormat(",###");
        }*/

        //// FIXME: 2016/12/20/0020 据商宇龙说 可能有问题 应该用上面的 待定
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        DecimalObject d = DecimalObject.instance(o.toString());

        return df.format(d.doubleValue());
    }
}
