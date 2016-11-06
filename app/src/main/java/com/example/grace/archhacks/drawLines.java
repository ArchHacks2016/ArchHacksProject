package com.example.grace.archhacks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by XXY on 11/5/2016.
 */

public class drawLines extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        float day1 = 5f;
        float day2 = 4f;
        float day3 = 5f;
        float day4 = 2f;
        float day5 = 4f;
        float day6 = 5f;
        float day7 = 5f;
        float[] input = new float[7];
        input[1] = day1;
        input[2] = day2;
        input[3] = day4;
        input[4] = day4;
        input[5] = day5;
        input[6] = day6;
        input[7] = day7;

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(day1, 0));
        entries.add(new Entry(day2, 1));
        entries.add(new Entry(day3, 2));
        entries.add(new Entry(day4, 3));
        entries.add(new Entry(day5, 4));
        entries.add(new Entry(day6, 5));
        entries.add(new Entry(day7, 6));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Sun");
        labels.add("Mon");
        labels.add("Tue");
        labels.add("Wed");
        labels.add("Thur");
        labels.add("Fri");
        labels.add("Sat");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);
        
        String suggestion = suggest(input);
        TextView textView = (TextView) findViewById(R.id.ansView);
        textView.setText(suggestion);
    }

    // This is from calculation:
    public static String suggest(float[] levels){
        int len=levels.length;
        if (len<=2f){
            return "Please record at least three days for a trend analysis. ";
        }else if (len>7f){
            return "Please select at most seven days for a trend analysis. ";
        }

        float[] differences= new float[len];

        for(int i=0; i<len-1; i++){
            differences[i]=levels[i+1]=levels[i];
        }

        float sum1=0;
        float sum2=0;
        for(int i=0; i<len/2-1; i++){
            sum1+=levels[i];
        }
        for(int i=len/2; i<len-1; i++){
            sum2+=levels[i+1];
        }

        sum1=sum1*2/len;
        sum2=sum2*2/len;

        if(sum1==sum2){
            if(sum1>3f){
                return "You feel happy through out the time. Keep smiling:) ";
            }else if(sum1==3f){
                return "You feel neutral these days. ";
            }else{
                return "You feel not happy this week. What's up? ";
            }
        }else if(sum1>sum2){
            if(sum1>3f){
                return "You feel happy throughout the time. Keep smiling:) ";
            }else{
                return "It is great that you feel better now. ";
            }
        }else{
            if(sum2<3f){
                return "You feel worse throughout the time. What's up? ";
            }else{
                return "Don't forget to smile! ";
            }
        }
    }
}
