package tw.com.lccnet.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnadd, btnsub, btnmul, btndiv, btndot, btnequ, btnac, tobmi;
    private TextView result;
    boolean clear_flag;
    String Num1 = "0", Num2 = "0";
    int Cal_index = 0;
    int Index_Value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//控制XML為activity_main
        SetObjFunction();
        SetMyOnClick();
        tobmi=findViewById(R.id.tobmi);
    }

    public void tobmi(View view){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }

    private void SetMyOnClick() {
        btn0.setOnClickListener(MyOnClick);
        btn1.setOnClickListener(MyOnClick);
        btn2.setOnClickListener(MyOnClick);
        btn3.setOnClickListener(MyOnClick);
        btn4.setOnClickListener(MyOnClick);
        btn5.setOnClickListener(MyOnClick);
        btn6.setOnClickListener(MyOnClick);
        btn7.setOnClickListener(MyOnClick);
        btn8.setOnClickListener(MyOnClick);
        btn9.setOnClickListener(MyOnClick);
        btnadd.setOnClickListener(MyOnClick);
        btnsub.setOnClickListener(MyOnClick);
        btnmul.setOnClickListener(MyOnClick);
        btndiv.setOnClickListener(MyOnClick);
        btndot.setOnClickListener(MyOnClick);
        btnequ.setOnClickListener(MyOnClick);
        btnac.setOnClickListener(MyOnClick);
    }

    private void SetObjFunction() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btndot = (Button) findViewById(R.id.btndot);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnequ = (Button) findViewById(R.id.btnequ);
        btnac = (Button) findViewById(R.id.btnac);
        result = (TextView) findViewById(R.id.result);
        result.setText("0");
    }

    private Button.OnClickListener MyOnClick = new Button.OnClickListener() {
        public void onClick(View v) {
            String Str_Value;
            Str_Value = result.getText().toString();
            switch (v.getId()) {
                case R.id.btn0:
                    DisplayNU("0");
                    break;
                case R.id.btn1:
                    DisplayNU("1");
                    break;
                case R.id.btn2:
                    DisplayNU("2");
                    break;
                case R.id.btn3:
                    DisplayNU("3");
                    break;
                case R.id.btn4:
                    DisplayNU("4");
                    break;
                case R.id.btn5:
                    DisplayNU("5");
                    break;
                case R.id.btn6:
                    DisplayNU("6");
                    break;
                case R.id.btn7:
                    DisplayNU("7");
                    break;
                case R.id.btn8:
                    DisplayNU("8");
                    break;
                case R.id.btn9:
                    DisplayNU("9");
                    break;
                case R.id.btndot:
                    DisplayNU(".");
                    break;
                case R.id.btnac:
                    result.setText("0");
                    break;

                case R.id.btnadd:
                    Calculate(0, Str_Value);
                    break;
                case R.id.btnsub:
                    Calculate(1, Str_Value);
                    break;
                case R.id.btnmul:
                    Calculate(2, Str_Value);
                    break;
                case R.id.btndiv:
                    Calculate(3, Str_Value);
                    break;
                case R.id.btnequ:
                    Calculate(99, Str_Value);
                    break;
            }
        }
    };

    private void DisplayNU(String S) {
        String str;
        String Zero = "0";
        str = result.getText().toString();
        if (Zero.equals(str) || Index_Value != 0) {
            result.setText("");
            result.setText(S);
            Index_Value = 0;
        } else {
            result.setText(str + S);
        }
    }

    private void Calculate(int Cal_value, String Cal_Nu) {
        double x;
        String Ans;
        switch (Cal_value) {
            case 0:
                Num1 = Cal_Nu;
                Cal_index = 0;
                result.setText("");
                break;
            case 1:
                Num1 = Cal_Nu;
                Cal_index = 1;
                result.setText("");
                break;
            case 2:
                Num1 = Cal_Nu;
                Cal_index = 2;
                result.setText("");
                break;
            case 3:
                Num1 = Cal_Nu;
                Cal_index = 3;
                result.setText("");
                break;
            case 99:
                Num2 = result.getText().toString();
                double i = Double.valueOf(Num1);
                double j = Double.valueOf(Num2);
                switch (Cal_index) {
                    case 0:
                        x = i + j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 1:
                        x = i - j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 2:
                        x = i * j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 3:
                        if (j == 0) {
                            Toast toast=Toast.makeText(MainActivity.this, "不能除以0", Toast.LENGTH_LONG);
                            toast.show();
                        } else {
                            x = i / j;
                            Ans = Double.toString(x);
                            result.setText(Ans);
                        }
                        break;
                }
                break;
        }
    }
}



