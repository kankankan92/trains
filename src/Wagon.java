public class Wagon {
    private int people=0;
    private String name;
    Wagon next = null;
    Wagon prev = null;
    public Wagon(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return "-[..==" + name + "==..]-";
    }
}
