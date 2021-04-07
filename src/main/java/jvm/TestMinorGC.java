package jvm;

/**
 * * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  *
 *  * 10M新生代，eden：survivor 比例 8：1，所以eden 8192K，from：1024K，to：1024K
 *  * 分配完allocation1，allocation2，allocation3之后，剩余空间不够分配allocation4，会发生MinorGC：PSYoungGen: 7052K->873K(9216K)]
 *  * 新生代从7052K-》873K，
 *  *
 *  * 老年代10M，使用4MB，allocation4 分配到老年代（大对象或者是分配担保机制）
 * @author: 李自强
 * @description: main
 * @date: 2021/4/6 上午10:55
 */
public class TestMinorGC {

    private static final int _1MB = 500 * 1024;

    public static void main(String[] args) {
        byte[] allocation1; //, allocation2, allocation3, allocation4;

        allocation1 = new byte[1 * _1MB];
        //allocation2 = new byte[2 * _1MB];
        //allocation3 = new byte[2 * _1MB];
        //allocation4 = new byte[4 * _1MB];



        /*
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            Object obj  = new Object();
            list.add(obj);
        }*/

    }
}
