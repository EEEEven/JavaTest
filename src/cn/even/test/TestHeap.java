package cn.even.test;

import java.util.ArrayList;
import java.util.List;

public class TestHeap {

    public static void main(String[] args) {
        List<HeapDemo> heapDemoList = new ArrayList<>();
        int count = 0;
        while (true) {
            count++;
            heapDemoList.add(new HeapDemo());
            System.out.println(count);
        }
    }

    static class HeapDemo{

    }


}
