package com.example.sonal.fitnessmantra;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.String;


public class Exercise extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        String [] excr={"Abdominals","Back","Biceps","Calves","Chest","Quads","Shoulders","Triceps"};
        ListAdapter exercise = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,excr);
        ListView exercie_listView = (ListView) findViewById(R.id.exercise_listView);
        exercie_listView.setAdapter(exercise);
    }
   }
