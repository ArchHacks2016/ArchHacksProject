package com.example.grace.archhacks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;

/**
 * Created by XXY on 11/5/2016.
 */

public class drawLines extends AppCompatActivity {
    Trend trend;
    float day1;
    float day2;
    float day3;
    float day4;
    float day5;
    float day6;
    float day7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linechart);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        ParseQuery<Trend> query = ParseQuery.getQuery(Trend.class);
        query.getFirstInBackground(new GetCallback<Trend>() {
            @Override
            public void done(Trend object, ParseException e) {
                trend = object;

//                try {
//                    day1 = (float)trend.getJSONArray("trends").getDouble(0);
//                    day2 = (float)trend.getJSONArray("trends").getDouble(0);
//                    day3 = Float.valueOf(trend.getJSONArray("trends").get(2).toString());
//                    day4 = Float.valueOf(trend.getJSONArray("trends").get(3).toString());
//                    day5 = Float.valueOf(trend.getJSONArray("trends").get(4).toString());
//                    day6 = Float.valueOf(trend.getJSONArray("trends").get(5).toString());
//                    day7 = Float.valueOf(trend.getJSONArray("trends").get(6).toString());
//                } catch (JSONException e1) {
//                    e1.printStackTrace();
//                }

            }
        });


        float day1 = 5f;
        float day2 = 3f;
        float day3 = 4f;
        float day4 = 4f;
        float day5 = 3f;
        float day6 = 1f;
        float day7 = 1f;

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(day1, 0));
        entries.add(new Entry(day2, 1));
        entries.add(new Entry(day3, 2));
        entries.add(new Entry(day4, 3));
        entries.add(new Entry(day5, 4));
        entries.add(new Entry(day6, 5));
        entries.add(new Entry(day7, 6));

        LineDataSet dataset = new LineDataSet(entries, "score");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Day 1");
        labels.add("Day 2");
        labels.add("Day 3");
        labels.add("Day 4");
        labels.add("Day 5");
        labels.add("Day 6");
        labels.add("Day 7");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);
        float[] input = new float[7];
        input[0] = day1;
        input[1] = day2;
        input[2] = day3;
        input[3] = day4;
        input[4] = day5;
        input[5] = day6;
        input[6] = day7;


        // Get suggestion.
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
