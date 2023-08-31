package virtusa.inherit;

public class Box {
    private int w;
    int h;
    int l;

     Box(int w, int h, int l) {
        this.w = w;
        this.h = h;
        this.l = l;
    }

    public int getW() {
        return w;
    }

    Box(){
        this.w = -1;
        this.l = -1;
        this.h = -1;
    }

     Box(int side){
        this.w = side;
        this.l = side;
        this.h = side;
    }

     Box(Box old) {
         this.w = old.w;
         this.h = old.h;
         this.l = old.l;
     }

}
