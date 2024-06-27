package Heaps;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(2);
        heap.insert(5);
        heap.insert(6);
        heap.insert(1);
        System.out.println(List.of(heap.heapSort()));
    }
}
