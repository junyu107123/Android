package tw.com.lccnet.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView cv;
    private TextView tv,tvtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cv=findViewById(R.id.calendview);
        tv=findViewById(R.id.tv);
        tvtime=findViewById(R.id.tvtime);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date=dayOfMonth+"/"+(month+1)+"/"+year;
                tv.setText(date);
            }
        });
    }

}
