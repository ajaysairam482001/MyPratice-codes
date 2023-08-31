package virtusa.inherit2;
class Arithmetic {
    int a;
    int b;
    void Arithmetic(int a,int b){
        this.a=a;
        this.b=b;
    }
    int add(int a,int b){
        return a+b;
    }
}
class Adder extends Arithmetic{
//    @Override
//    void Arithmetic(int a, int b) {
//        super.Arithmetic(a, b);
//    }

    @Override
    int add(int a, int b) {
        return super.add(a, b);
    }
}

