package store;
public class Frame{
    private String name;
    private int duration;
    public Frame(String p, int d){
        name = p;
        duration = d;
    }
    public void setDuration(int d){
        duration = d;
    }
    
    public int getDuration(){
        return duration;
    }
    
    public String getName(){
        return name;
    }
}