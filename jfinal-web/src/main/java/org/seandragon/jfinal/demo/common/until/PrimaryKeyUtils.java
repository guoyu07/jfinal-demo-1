package org.seandragon.jfinal.demo.common.until;


/**
 * Created by sd on 17/3/9.
 */
public class PrimaryKeyUtils {

    public static String getRandomStrByNanoTime(final boolean shift) {
        return toUnsignedString(getRightNanoTime() + pro.cg.tools.getCode(5), shift ? 6 : 4);
    }

    private static long getRightNanoTime() {
        long nanoTime = System.nanoTime();
        if (nanoTime < 0) return getRightNanoTime();
        else return nanoTime;
    }

    public static String getRandomStrByUUID(final int length) {
        return pro.cg.tools.getUUID().substring(0, length > 32 ? 32 : length);
    }

    public static String getRandomStrByUUID_Time(final int length) {
        return Long.toHexString(Long.parseLong(pro.cg.date.getNowTime("yyMMdd"))) + pro.cg.tools.getUUID().substring(0, length - 5);
    }

    public static long getRandomLongByTime(final int length) {
        String s = pro.cg.date.getNowTime("yyMMddHHmmss");
        if (length > 12) s += pro.cg.tools.getCodeStr(length - 12);
        return Long.valueOf(s);
    }

    /**
     * shift :
     * 5   32进制
     * 6   64进制
     * 放入long类型数字
     *
     * @param i     数字
     * @param shift 2的几次幂
     * @return 经过转换的
     */
    private static String toUnsignedString(long i, int shift) {
        shift = shift > 6 ? 6 : shift;
        final char[] self = shift > 5 ? digits_$ : digits;
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << shift;
        long mask = radix - 1;
        do {
            buf[--charPos] = self[(int) (i & mask)];
            i >>>= shift;
        } while (i != 0);
        return new String(buf, charPos, (64 - charPos));
    }


    private final static char[] digits = {//32位
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    }, digits_$ = {//64位
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '*', '$'
    };
}
