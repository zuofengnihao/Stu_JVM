package jvm.chapter5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReturnAddressTest {

    public ReturnAddressTest() {
        //return
        return;
    }


    public boolean methodBoolean(){
        return false;//ireturn
    }

    public byte methodByte() {
        return 0;//ireturn
    }

    public short methodShort() {
        return 0;//ireturn
    }

    public char methodChar() {
        return 0;//ireturn
    }

    public int methodInt() {
        return 0;//ireturn
    }

    public long methodLong() {
        return 0L;//lreturn
    }

    public float methodFloat() {
        return 0.0F;//freturn
    }

    public double methodDouble() {
        return 0.0;//dreturn
    }

    public String methodString() {
        return null;//areturn
    }

    public Date methodDate() {
        return null;//areturn
    }

    public void methodVoid() {
        //return
        return;
    }

    static {
        int i = 10;//clinit return
    }

    public void method2() {

        methodVoid();

        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        FileReader fis = new FileReader("zuofeng.txt");
        char[] buffer = new char[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            String s = new String(buffer, 0, len);
            System.out.println(s);
        }
        fis.close();
    }
}
