package code;

public class Wagon {
    public int people = 0;
    private static final int MAX_PEOPLE = 50;
    private boolean free = true;
    private String name;
    Wagon next = null;
    Wagon prev = null;

    public Wagon(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "-[..==" + name + "==..]-";
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isFull(){
        return people==MAX_PEOPLE;
    }

    public int getFreeSits(){
        return MAX_PEOPLE-people;
    }

}
