package Test_20170304;

import org.junit.Test;

/**
 * Created by sd on 17/3/4.
 */
public class Test_Method_2 {
    @Test
    public void test1() {
        Base base = new Base();
        base.fun(100, 50);

        Sub sub = new Sub();
        //sub.fun(100, 50);//类型会由父类制定//new int[]{50}
    }
}

class Base {
    void fun(int price, int... discounts) {
        System.out.println("Base...fun");
    }
}

class Sub extends Base {
    @Override
    void fun(int price, int[] discounts) {//这里需要传入的是一个数组对象 而不是多个int
        System.out.println("Base...fun");
    }
}