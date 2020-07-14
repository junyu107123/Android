package tw.com.lccnet.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {
    private Button btngps;
    private TextView textgps;
    private LocationManager locationManager;
    private String commadStr;

    public static final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btngps =(Button)findViewById(R.id.btngps);
        textgps=(TextView)findViewById(R.id.textgps);
        commadStr = LocationManager.GPS_PROVIDER;//使用GPS定位
    }

    public void gps(View view) {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //LocationManager可以用來獲取當前的位置,追蹤設備的移動路線
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            ActivityCompat.requestPermissions(Main3Activity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_ACCESS_COARSE_LOCATION);
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(commadStr, 1000, 0, locationListener);
        //事件的條件設定為時間間隔1秒,距離改變0米,設定監聽位置變化
        Location location = locationManager.getLastKnownLocation(commadStr);
        //利用locationManager.getLastKnownLocation取得當下的位置資料


        if (location != null) {
            textgps.setText("經度:" + location.getLongitude() + "\n緯度:" + location.getLatitude());
        } else {
            textgps.setText("定位中");
        }
    }
        LocationListener locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                textgps.setText("經度:"+location.getLongitude()+"\n緯度:"+location.getLatitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }

