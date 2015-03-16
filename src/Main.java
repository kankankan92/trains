public class Main {
    public static void main(String[] args) {
        Train train1 = new Train();
        Train train2 = new Train();
        Wagon wagon1 = new Wagon("MilPop");
        Wagon wagon2 = new Wagon("Lanister");
        Wagon wagon3 = new Wagon("Bob");
        Wagon wagon4 = new Wagon("Rachel");
        train1.add(wagon1);
        train1.add(wagon2);
        train2.add(wagon3);
        train2.add(wagon4);
        train1.remove();
        train2.add(wagon2);

        System.out.println(train1);
        System.out.println(train2);
    }
}
