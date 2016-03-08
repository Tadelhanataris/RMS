package com.lalalla.t.biyesheji;

/**
 * Created by T on 2016/3/4.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String tag="DBSQLiteHelper";
    private static final String name="t.db";
    private static final int version=1;
    public DBOpenHelper(Context context) {
        super(context, name, null, version);
        Log.v(tag, "构造器");
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table project(_id integer primary key autoincrement,date varchar(20),tittle varchar(50),content varchar(1000))");

        Log.v(tag, "数据库创建执行一次");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS person");
        onCreate(db);

    }

}