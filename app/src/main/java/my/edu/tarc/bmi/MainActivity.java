package my.edu.tarc.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult= (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view){
        double weight,height,bmi;
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height = height/100;

        bmi = weight / (height*height);

        if(bmi<=18.5){
            textViewResult.setText(getString(R.string.resultUnder));
            imageViewResult.setImageResource(R.drawable.under);
        }else if(bmi>21){
            textViewResult.setText(getString(R.string.resultOver));
            imageViewResult.setImageResource(R.drawable.over);
        }else{
            textViewResult.setText(getString(R.string.resultNormal));
            imageViewResult.setImageResource(R.drawable.normal);
        }
    }

    public void resetText(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }

}
