package LinkedList;

public class PraticingListhere {
    public static void main(String[] args) {
//        SLL list = new SLL();
//        list.insertFirst(32);
//        list.insertFirst(45);
//        list.insertFirst(21);
//        list.insertFirst(84);
//
//        list.insertLast(100);
//        list.insertLast(101);
//        list.insert(99,1);
//        list.insert(54,0);
//        list.insert(64,1);
//        list.insert(41,0);
//
//        list.display();
//        list.delete(0);
//        System.out.println(list.getSize());
//        list.displayReverse();

//        DLL list = new DLL();
//        list.insertFirst(32);
//        list.insertFirst(45);
//        list.insertFirst(21);
//        list.insertFirst(84);
//        list.insertLast(100);
//        list.insertLast(101);
//        list.insert(10,5);
//        list.display();
//        list.displayReverse();

        CLL list = new CLL();
        list.insertFirst(32);
        list.insertFirst(45);
        list.insertFirst(21);
        list.insertFirst(84);
        list.insertLast(100);
        list.insertLast(101);
        list.insert(56,5);
        list.display();
        list.delete(7);
        list.display();


    }
}