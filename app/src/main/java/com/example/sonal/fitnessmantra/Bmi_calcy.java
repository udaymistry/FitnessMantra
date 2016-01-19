package com.example.sonal.fitnessmantra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.math.BigDecimal;
import android.support.annotation.Nullable;
import android.widget.Toast;



public class Bmi_calcy extends AppCompatActivity implements OnClickListener
{
    EditText eheight_ft,eweight,eheight_inch;
    BigDecimal dg,bmi1;
    Button bsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calcy);
        eheight_ft=(EditText)findViewById(R.id.UserHeight);
        eweight=(EditText)findViewById(R.id.UserWeight);
        eheight_inch=(EditText)findViewById(R.id.HeightInch) ;
        bsubmit=(Button)findViewById(R.id.Submit);
        bsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try
        {int  height_ft=Integer.parseInt(eheight_ft.getText().toString());
            int height_inch= Integer.parseInt(eheight_inch.getText().toString());
            int height=height_ft*12 + height_inch;
            int  weight  = Integer.parseInt(eweight.getText().toString());
            float pounds= (float) (weight*2.20462);
            float bmi= ( pounds / ( height *height ) ) * 703;
            dg=new BigDecimal(bmi);
            bmi1 = dg.setScale(2,BigDecimal.ROUND_FLOOR);

            if(bmi1.floatValue()<18.5)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Underweight");
            }
            if(bmi1.floatValue()>=18.5 && bmi1.floatValue()<=24.9)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Weight Is Normal");
            }
            if(bmi1.floatValue()>=25 && bmi1.floatValue()<=29.9)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Overweight");
            }
            if(bmi1.floatValue()>=30)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Obese "+"\n Stop eating fat ass");
            }



        }
        catch (NumberFormatException e)
        {
            eheight_ft.setText("");
            eweight.setText("");
            Toast.makeText(getApplicationContext(),"Enter proper values",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmi_calcy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
