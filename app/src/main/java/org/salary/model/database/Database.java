package org.salary.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    static Database db = null;

    static String name="SalarySystem";
    static int version=1;
    static final String TAG = "SQLite";

    public static Database getInstance(Context ct){
        if(db==null){
            db= new Database(ct);
        }
        return db;
    }
    private Database(Context context) {
        super(context, Database.name, null, Database.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.createTable);
        Log.i(TAG,"Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
