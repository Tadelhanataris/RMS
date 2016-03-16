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
        db.execSQL("create table project(_id integer primary key autoincrement,date varchar(20),tittle varchar(50),content varchar(1000),P_ID INTEGER,FOREIGN KEY(P_ID) REFERENCES PERSON(PERSON_ID))");
        db.execSQL("create table person(person_id integer primary key autoincrement,number varchar(10),password varchar(50),Unique(number))");
        db.execSQL("create table news(_id integer primary key autoincrement,date varchar(20),tittle varchar(50),content varchar(1000))");
        db.execSQL("create table notification(_id integer primary key autoincrement,date varchar(20),tittle varchar(50),content varchar(1000),P_ID INTEGER,FOREIGN KEY(P_ID) REFERENCES PERSON(PERSON_ID))");
        db.execSQL("create table summary" +
                "(_id integer primary key autoincrement," +
                "projectname varchar(20)," +
                "projecttype varchar(20)," +
                "subject varchar(20)," +
                "starttime varchar(20)," +
                "studentname varchar(20)," +
                "studentcollege varchar(20)," +
                "studentnumber varchar(20)," +
                "studentemail varchar(20)," +
                "studentphone varchar(20)," +
                "teachername varchar(20)," +
                "teachercollege varchar(20)," +
                "teacheremail varchar(20)," +
                "teacherphone varchar(20)," +
                "P_ID INTEGER,FOREIGN KEY(P_ID) REFERENCES PERSON(PERSON_ID)" +
                ")");
        Log.v(tag, "数据库创建执行一次");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS project");
        db.execSQL("DROP TABLE IF EXISTS person");
        db.execSQL("DROP TABLE IF EXISTS news");
        db.execSQL("DROP TABLE IF EXISTS notification");
        db.execSQL("DROP TABLE IF EXISTS summary");

        onCreate(db);

    }

}