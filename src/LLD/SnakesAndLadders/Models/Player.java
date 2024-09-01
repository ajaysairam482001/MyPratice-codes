package LLD.SnakesAndLadders.Models;

public class Player {
    private  String playername;
    private int position;

    public Player(String name){
        this.playername = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int pos){
        this.position = pos;
    }
    public String getPlayername(){
        return playername;
    }
}
