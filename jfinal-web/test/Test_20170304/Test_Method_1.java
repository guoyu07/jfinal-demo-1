package Test_20170304;

import org.junit.Test;

/**
 * Created by sd on 17/3/4.
 */
public class Test_Method_1 {
    @Test
    public void test1() {
        Client client = new Client();
        client.methodA("China", 0);
        client.methodA("China", "People");
        //client.methodA("China");
        //client.methodA("China", null);

        //未能制定具体类型。
        //如果null转换成String[]活着Integer[]就可以了，数组单值都可以
    }
}

class Client {
    public void methodA(String str, Integer... is) {

    }

    public void methodA(String str, String... strs) {

    }
}
