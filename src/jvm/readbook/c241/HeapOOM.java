package jvm.readbook.c241;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m(最小堆内存) -Xmx20m(最大堆内存) +HeapDumpOnOutOfMemoryError(Dump内存堆快照)
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
