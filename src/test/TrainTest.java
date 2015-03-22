package test;

import org.junit.Assert;
import org.junit.Test;

import code.Train;
import code.Wagon;

/**
 * Created by Makarenko on 17.03.2015.
 */
public class TrainTest {

    @Test
    public void testAddWagon1(){
        Train train = new Train();
        Wagon wagon = new Wagon("1");
        train.add(wagon);
        Assert.assertEquals("Криво вагоны считаем", 1, train.wagonCount());
    }

    @Test(expected = RuntimeException.class)
    public void testAddWagonNotFree(){
        Train train1 = new Train();
        Wagon wagon = new Wagon("1");
        train1.add(wagon);
        Train train2 = new Train();
        train2.add(wagon);
    }

    @Test(expected = RuntimeException.class)
    public void removeWagonFromEmptyTrain(){
        Train train1 = new Train();
        train1.remove();
    }

    @Test
    public void boardPassengersGTfreeSeats(){
        Train train1 = new Train();
        train1.add(new Wagon("1"));
        Assert.assertEquals(10, train1.board(60));
        Assert.assertEquals(50, train1.getWagon(0).people);
    }

    @Test
    public void boardPassengersLTfreeSeats(){
        Train train1 = new Train();
        train1.add(new Wagon("1"));
        Assert.assertEquals(0, train1.board(30));
        Assert.assertEquals(30, train1.getWagon(0).people);
    }

    @Test(expected = RuntimeException.class)
    public void boardPassengersEmptyTrain(){
        Train train1 = new Train();
        train1.board(30);
    }

    @Test
    public void boardPassengers2Wagons(){
        Train train1 = new Train();
        train1.add(new Wagon("1"));
        train1.add(new Wagon("2"));
        Assert.assertEquals(0, train1.board(70));
        Assert.assertEquals(50, train1.getWagon(0).people);
        Assert.assertEquals(20, train1.getWagon(1).people);
    }

    @Test
    public void isFullTrain(){
        Train train1 = new Train();
        train1.add(new Wagon("1"));
        train1.add(new Wagon("2"));
        train1.board(100);
        Assert.assertEquals(true, train1.isFull());
    }

    @Test
    public void isNotFullTrain(){
        Train train1 = new Train();
        train1.add(new Wagon("1"));
        train1.add(new Wagon("2"));
        train1.board(90);
        Assert.assertEquals(false, train1.isFull());
    }

}
