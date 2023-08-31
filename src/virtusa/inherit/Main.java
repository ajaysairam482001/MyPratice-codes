package virtusa.inherit;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4, 5, 6);
        Box box2 = new Box(box1);
        System.out.println(box1.getW());
//        Box box3 = new Box(6);
//     System.out.println(box2.w+" "+ box2.h+" "+box2.l);
//        System.out.println(box3.l+box3.w);
//        BoxWeight bw1 =  new BoxWeight(6, "red");
//        //System.out.println(bw1.weight);
//       // fun();
//        Main obj = new Main();
//        obj.fun2();
//
//    }
//    static void fun(){
//        Main main = new Main();
//        main.greetings();
//    }
//    void fun2(){
//        greetings();
//    }
//
//    void greetings(){
//        System.out.println("hello");
//    }
//
    }
}
