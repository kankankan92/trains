package code;

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
            throw new RuntimeException("Вагонов нет!");
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
                if (passCount > current.getFreeSits()) {
                    passCount = passCount - current.getFreeSits();
                    current.people = current.people + current.getFreeSits();
                } else {
                    current.people = current.people + passCount;
                    passCount = 0;
                }
            }
            current = current.next;
        }

        return passCount;
    }

    public int board2(int passCount) {
        if (first == null) {
            throw new RuntimeException("Вагонов нет!");
        }
        Wagon current = first;
        while (current.next != null && passCount > 0) {
            if (!current.isFull()) {
                current.people++;
                passCount--;
                current = current.next;
            }
            current = current.next;

        }


        return passCount;
    }

    public Wagon getWagon(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Номер вагона не может быть отрицательным, дебил");
        }
        Wagon current = first;
        int num = 0;
        while (current != null && num != n) {
            current = current.next;
            num++;
        }
        if (current == null) {
            throw new RuntimeException("Вагона нет!");
        }
        return current;
    }

    public int wagonCount() {
        Wagon current = first;
        int wagonCount = 0;
        while (current != null) {
            current = current.next;
            wagonCount++;
        }
        return wagonCount;
    }

    public boolean isFull() {
        Wagon current = first;
        while (current != null) {
            if (!current.isFull()) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

}
