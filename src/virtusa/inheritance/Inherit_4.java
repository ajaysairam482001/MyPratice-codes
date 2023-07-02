package virtusa.inheritance;

import java.util.*;
class Event{
    protected String n;
    protected String d;
    protected String t;
    protected String on;
    public Event(){
        this.n="";
        this.d="";
        this.t="";
        this.on="";
    }
    public Event(String n,String d,String t,String on){
        this.n=n;
        this.d=d;
        this.t=t;
        this.on=on;
    }
    public String getn(){return n;}
    public void setn(String n){this.n=n;}
    public String getd(){return d;}
    public void setd(String d){this.d=d;}
    public String gett(){return t;}
    public void sett(String t){this.t=t;}
    public String geton(){return on;}
    public void seton(String on){this.on=on;}

}
class Exhibition extends Event{
    private Integer nos;
    public Exhibition(){
        super();
        this.nos=0;
    }
    public Exhibition(String n,String d,String t,String on,Integer nos){
        super(n,d,t,on);
        this.nos = nos;
    }
    public Integer getnos(){
        return nos;
    }
    public void setnos(){
        this.nos=nos;
    }
}
class StageEvent extends Event{
    private Integer nos;
    public StageEvent(){
        super();
        this.nos=0;
    }
    public StageEvent(String n,String d,String t,String on,Integer nos){
        super(n,d,t,on);
        this.nos=nos;
    }
    public Integer getnos(){
        return nos;
    }
    public void setnos(Integer nos){
        this.nos=nos;
    }
}
class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int ch = in.nextInt();
        in.nextLine();
        String i = in.nextLine();
        String[] v = i.split(",");
        Event e=null;
        if(ch==1){
            e=new Exhibition(v[0],v[1],v[2],v[3],Integer.parseInt(v[4]));
        }else if(ch ==2){
            e= new StageEvent(v[0],v[1],v[2],v[3],Integer.parseInt(v[4]));
        }else{
            System.out.println("Invalid Input");
            return;
        }
        System.out.println(e.getn()+" "+e.getd()+" "+e.gett()+" "+e.geton());
        if(e instanceof Exhibition){
            System.out.print(((Exhibition)e).getnos());
        }else if(e instanceof StageEvent){
            System.out.print(((StageEvent)e).getnos());
        }
    }
}