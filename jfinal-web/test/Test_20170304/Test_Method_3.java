package Test_20170304;

import org.junit.Test;

/**
 * Created by sd on 17/3/4.
 */
public class Test_Method_3 {
    @Test
    public void test1() {

        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = ++count;
        }
        System.out.println("count=" + count);

    }

    @Test
    public void test2() {
        int fee = 200;
        saveDefault:
        save(fee);
    }

    void saveDefault() {
        System.out.println("Test_Method_3.saveDefault");
    }

    void save(int fee) {
        System.out.println("Test_Method_3.save" + fee);
    }

    @Test
    public void test3() {
        Clent1 clent1 = new Clent1();
        System.out.println(clent1.a);
        //System.out.println(clent1.getInstance());
    }
}

class Clent1 {
    public static final String a = getInstance();

    static String getInstance() {
        System.out.println("Clent1.getInstance");
        return a;
    }
}