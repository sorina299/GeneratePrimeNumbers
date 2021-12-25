package com.company;

public class Prime {
    public static boolean isPrim(int number){
        if(number < 2){
            return false;
        }

        for(int i = 2; i < number/2; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

}
