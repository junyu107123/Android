package tw.com.lccnet.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDB extends SQLiteOpenHelper {
    String TAG = SQLiteDB.class.getSimpleName();
    String TableName;


    public SQLiteDB(@Nullable Context context
            , @Nullable String dataBaseName
            , @Nullable SQLiteDatabase.CursorFactory factory, int version, String TableName) {
        super(context, dataBaseName, factory, version);
        this.TableName = TableName;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLTable = "CREATE TABLE IF NOT EXISTS " + TableName + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Phone TEXT," +
                "Hobby TEXT," +
                "ElseInfo TEXT" +
                ");";
        db.execSQL(SQLTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        final String SQL = "DROP TABLE " + TableName;
        db.execSQL(SQL);

    }
    //指標,db指向sqldb的table
    public Cursor select(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.query("sqldb",null,null,null,
                        null,null,null,null);
        return cursor;
    }
    //新增db Table內容,帶入 姓名 年齡 性別 電話 地址
    public long insert(String name,String age,String sex,String phone,String address){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("age",age);
        cv.put("sex",sex);
        cv.put("phone",phone);
        cv.put("address",address);
        long row=db.insert("sqldb",null,cv);
        return row;
    }
    //刪除Table單筆資料,帶入id
//    public void delete(int id){
//        SQLiteDatabase db=this.getWritableDatabase();
//        String Where="_id"+"="+integer.toString(id);
//        db.delete("sqldb",where,null);
//    }
    //刪除Table全部資料
    public void deleteAll(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+"sqldb");
    }
}
