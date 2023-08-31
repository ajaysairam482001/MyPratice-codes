package virtusa.inherit;

public class BoxWeight extends Box {
    int weight;
    String color;

    public BoxWeight(int w, int h, int l, int weight, String color) {
        super(w, h, l);
        this.weight = weight;
        this.color = color;
    }

    public BoxWeight(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public BoxWeight(int side, int weight, String color) {
        super(side);
        this.weight = weight;
        this.color = color;
    }

    public BoxWeight(Box old, int weight, String color) {
        super(old);
        this.weight = weight;
        this.color = color;
    }
}
