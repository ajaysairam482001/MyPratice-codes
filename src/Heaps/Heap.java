package Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;

    public Heap(){ //constructor
        list = new ArrayList<>();
    }

    private void swap(int from, int to ){
        T temp = list.get(from);
        list.set(from,list.get(to));
        list.set(to,temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return index*2 + 1;
    }
    private int right(int index){
        return index*2 + 2;
    }

    public void insert(T value){
        list.add(value);
        heapUp(list.size()-1);
    }
    private void heapUp(int index){
        if(index == 0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0){ // if parent is greater than child
            swap(index,p);
            heapUp(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty list");
        }

        T temp = list.get(0); //removing the root

        T last = list.remove(list.size()-1); //adding the last element to root and perform downheap
        if(!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;
    }
    private void downHeap(int index){
        int mininum = index;
        int left = left(index);
        int right = right(index);

        if(left<list.size() && list.get(mininum).compareTo(list.get(left))>0){ //comparing left and parent which is minimum and assingning it to mininum
            mininum = left;
        }
        if(right<list.size() && list.get(mininum).compareTo(list.get(right))>0){ //comparing previous if stat ans with right
            mininum = right;
        }
         //but the above two if statements we would have found the minimun number in the (parent, left , right)

        if(mininum!=index){
            swap(mininum,index);
            downHeap(mininum);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}
