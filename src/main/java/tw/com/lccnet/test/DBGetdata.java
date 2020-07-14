package tw.com.lccnet.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DBGetdata {

    private DBService dbService;
    public DBGetdata(Context context) {
        dbService = new DBService(context);
    }

    public int insert(ItemGPS ItemGPS) {

        SQLiteDatabase db = dbService.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemGPS.KEY_SR, ItemGPS.sr);
        values.put(ItemGPS.KEY_ID, ItemGPS.uid);
        values.put(ItemGPS.KEY_NAME, ItemGPS.name);
        values.put(ItemGPS.KEY_LAT, ItemGPS.lat);
        values.put(ItemGPS.KEY_LON, ItemGPS.lon);
        values.put(ItemGPS.KEY_TIME, ItemGPS.time);
        values.put(ItemGPS.KEY_OWNER, ItemGPS.owner);
        values.put(ItemGPS.KEY_INFO, ItemGPS.info);

        // Inserting Row
        long ItemGPS_Id = db.insert(ItemGPS.DATABASE_TABLE, null, values);
        db.close(); // Closing database connection
        return (int) ItemGPS_Id;
    }

    public ArrayList<HashMap<String, String>> getAll() {
        SQLiteDatabase db = dbService.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                ItemGPS.KEY_SR + "," +
                ItemGPS.KEY_ID + "," +
                ItemGPS.KEY_NAME + "," +
                ItemGPS.KEY_LAT + "," +
                ItemGPS.KEY_LON + "," +
                ItemGPS.KEY_TIME + "," +
                ItemGPS.KEY_OWNER + "," +
                ItemGPS.KEY_INFO +
                " FROM " + ItemGPS.DATABASE_TABLE;

        ArrayList<HashMap<String, String>> ItemGPSList = new ArrayList<>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> checkpoint = new HashMap<>();
                checkpoint.put("name", cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_NAME)));
                checkpoint.put("id",cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_ID)));
                checkpoint.put("time",cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_TIME)));
                checkpoint.put("owner",cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_OWNER)));
                checkpoint.put("lan", cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_LAT)));
                checkpoint.put("lon", cursor.getString(cursor.getColumnIndex(ItemGPS.KEY_LON)));
                ItemGPSList.add(checkpoint);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return ItemGPSList;
    }
}