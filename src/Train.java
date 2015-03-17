public class Train {
    private String name = " ";
    Wagon first = null;

    @Override
    public String toString() {
        String str = "//[]+++[]]-";
        Wagon cur = first;
        while (cur != null) {
            str += cur.toString();
            cur = cur.next;
        }
        return str;
    }

    public void add(Wagon wagon) {
        if (!wagon.isFree()) {
            throw new RuntimeException("Вагон уже прицеплен!");
        }
        if (first == null) {
            first = wagon;
        } else {
            Wagon last = getLast();
            last.next = wagon;
            wagon.prev = last;
        }
        wagon.setFree(false);
    }

    public Wagon remove() {
        if (first == null) {
            return null;
        } else {
            if (first.next == null) {
                Wagon wagon = first;
                first = null;
                wagon.setFree(true);
                return wagon;
            } else {
                Wagon last = getLast();
                last.prev.next = null;
                last.prev = null;
                last.setFree(true);
                return last;
            }
        }
    }

    private Wagon getLast() {
        if (first == null) {
            return null;
        }
        Wagon current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int board(int passCount) {
        if (first == null) {
            throw new RuntimeException("Вагонов нет!");
        }
        Wagon current = first;
        while (current != null && passCount > 0) {
            if (!current.isFull()) {
             if (passCount>current.getFreeSits()){
                 passCount=passCount-
             }
            }
            current.people
                    current = current.next;
        }
        return -1;
    }
}
