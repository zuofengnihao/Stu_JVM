package jvm.chapter5;

public class OperandStackTest {

    public void testAddOperation() {
        byte i = 15;
        int j = 8;
        int k = i + j;
    }

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSum() {
        int i = getSum();
        int j = 10;
    }

    /**
     * i++ 与 ++i 的区别
     */
    public void add() {
        //1类
        /**
         *  0 bipush 10      6 bipush 10
         *  2 istore_1       8 istore_2
         *  3 iinc 1 by 1    9 iinc 2 by 1
         */
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        //2类
        /**
         * 12 bipush 10      21 bipush 10
         * 14 istore_3       23 istore 5
         * 15 iload_3        25 iinc 5 by 1
         * 16 iinc 3 by 1    28 iload 5
         * 19 istore 4       30 istore 6
         */

        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;



        //3类
        /**
         * 32 bipush 10       43 bipush 10
         * 34 istore 7        45 istore 8
         * 36 iload 7         47 iinc 8 by 1
         * 38 iinc 7 by 1     50 iload 8
         * 41 istore 7        52 istore 8
         */
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        //4类
        int i9 = 10;
        int i10 = i9++ + ++i9;

    }
}
