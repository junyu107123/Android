package tw.com.lccnet.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import java.util.ArrayList;
import java.util.HashMap;

public class Main4Activity extends AppCompatActivity {

    private final String DB_NAME = "MyList.db";
    private String TABLE_NAME = "MyTable";
    private final int DB_VERSION = 1;
    SQLiteDB mDBHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料
    ArrayList<HashMap<String, String>> getNowArray = new ArrayList<>();//取得被選中的項目資料

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlitedb);


        mDBHelper = new SQLiteDB(this, DB_NAME
                , null, DB_VERSION, TABLE_NAME);//初始化資料庫

    }//onCreate End
}