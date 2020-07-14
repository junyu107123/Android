package tw.com.lccnet.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button buttonBMI,buttonclear,tocal;
    private EditText editText1,editText2;
    private TextView textView;
    Context context;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonBMI=findViewById(R.id.buttonbmi);
        buttonclear=findViewById(R.id.buttonclear);
        tocal=findViewById(R.id.tocal);

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    editText1 = findViewById(R.id.tall);
                    editText2 = findViewById(R.id.weight);
                    textView = findViewById(R.id.textView);

                    double h = Double.parseDouble(editText1.getText().toString());
                    double w = Double.parseDouble(editText2.getText().toString());
                    double bmi = w / (Math.pow(h / 100, 2));

                    if (bmi < 18.5) {
                        textView.setText("過瘦");
                    } else if (bmi <= 24) {
                        textView.setText("正常");
                    } else if (bmi > 24) {
                        textView.setText("過胖");
                    } else {
                        textView.setText("錯誤");
                    }
                    textView.setText(textView.getText().toString() + ",你的BMI值為:" + bmi);
                }
                catch (Exception obj){
                    Toast.makeText(Main2Activity.this,"請先輸入身高體重喔!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
                textView.setText("");
            }
        });
    }
    public void tocal(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }


}
