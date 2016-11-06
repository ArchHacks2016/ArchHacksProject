package com.example.grace.archhacks;

/**
 * Created by XIN on 11/5/16.
 */

public class Calculation  {

    protected static int threshold=75;

    public static int emotionLevel(int joy, int anger, int sad, int surprise){
        /*
        Scale:
        5 - tres bien
        4 - bien
        3 - neutral
        2 - mal
        1 - t-res mal
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

    public static String suggest(int[] levels){
        int len=levels.length;
        if (len<=2){
            return "Please record at least three days for a trend analysis. ";
        }else if (len>7){
            return "Please select at most seven days for a trend analysis. ";
        }

        int[] differences=new int[len];

        for(int i=0; i<len-1; i++){
            differences[i]=levels[i+1]=levels[i];
        }

        int sum1=0;
        int sum2=0;
        for(int i=0; i<len/2-1; i++){
            sum1+=levels[i];
        }
        for(int i=len/2; i<len-1; i++){
            sum2+=levels[i+1];
        }

        sum1=sum1*2/len;
        sum2=sum2*2/len;

        if(sum1==sum2){
            if(sum1>3){
                return "You feel happy through out the time. Keep smiling:) ";
            }else if(sum1==3){
                return "You feel neutral these days. ";
            }else{
                return "You feel not happy this week. What's up? ";
            }
        }else if(sum1>sum2){
            if(sum1>3){
                return "You feel happy throughout the time. Keep smiling:) ";
            }else{
                return "It is great that you feel better now. ";
            }
        }else{
            if(sum2<3){
                return "You feel worse throughout the time. What's up? ";
            }else{
                return "Don't forget to smile! ";
            }
        }

    }
}
