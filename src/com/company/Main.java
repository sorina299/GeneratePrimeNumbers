package com.company;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("How do you want to generate prime numbers? Using a single thread(1) or multiple threads(2)?");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if(choice == 1){
            singleThread();
        }else if( choice == 2) {
            multiThread();
        }
    }

    public static void singleThread(){
        // 1_000_000 cu 1 thread 64,7 sec
        var start = System.currentTimeMillis();
        var t1 = new Thread(new GeneratePrimeNumbers(0, 1_000_000));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var finish = System.currentTimeMillis();
        System.out.println("Total duration of the computation with single thread: " + (finish-start));
    }

    public static void multiThread(){
        //1_000_000 cu 4 threaduri 27,3 sec
        var threads = new LinkedList<Thread>();
        //int nThreads = 8;

        Scanner in = new Scanner(System.in);
        int nThreads;
        System.out.println("How many threads do you want to use? ");
        nThreads = in.nextInt();

        var start = System.currentTimeMillis();

        int step = 1_000_000 / nThreads + 1;
        for( int i = 0; i < nThreads; i++ ){
            threads.add( new Thread( new GeneratePrimeNumbers( i * step, Math.min(1_000_000, (i + 1) * step - 1 ) )  ) );
        }

        for( var i : threads ){
            i.start();
        }

        for( var i : threads ){
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var finish = System.currentTimeMillis();
        System.out.println("Total duration of the computation with multithreading: " + (finish - start) );

    }

}

