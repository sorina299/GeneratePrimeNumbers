package com.company;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        singleThread();
    }

    public static void singleThread(){
        var start = System.currentTimeMillis();
        var t1 = new Thread(new GeneratePrimeNumbers(0, 100000));
        t1.run();
        var finish = System.currentTimeMillis();
        System.out.println("Total duration of the computation with single thread: " + (finish-start));
    }

    public static void multiThread(){

    }
}
