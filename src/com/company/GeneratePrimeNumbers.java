package com.company;
import java.util.ArrayList;
import java.util.List;


public class GeneratePrimeNumbers implements Runnable{
    public int a;
    public int b;
    public List<Integer> primes;

    public GeneratePrimeNumbers(int a, int b){
        this.a = a;
        this.b = b;
    }

    public List<Integer> addPrimes(int a, int b){
        var list = new ArrayList<Integer>();
        for(int i = a; i <= b; i++){
            if( Prime.isPrim(i) ){
                list.add(i);
                //System.out.println(i);
            }
        }
        return list;
    }

    @Override
    public void run() {

        addPrimes(a,b);

        System.out.println("done");

    }
}

