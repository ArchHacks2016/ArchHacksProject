package com.example.grace.archhacks;

/**
 * Created by XIN on 11/5/16.
 */

public class Calculation {

    protected static int threshold=75;

    public static int calculate(int joy, int anger, int sad, int surprise){
        /*
        Scale:
        5 - tres bien
        4 - bien
        3 - neutral
        2 - mal
        1 - tres mal
         */

        int neg = Math.max(anger, sad);
        if(neg<joy){
            return 4 + joy/threshold;
        }else if(neg==joy){
            return 3;
        }else{ //neg>joy
            return 2 - neg/threshold;
        }
    }
}
