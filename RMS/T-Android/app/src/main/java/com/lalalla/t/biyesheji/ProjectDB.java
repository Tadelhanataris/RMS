package com.lalalla.t.biyesheji;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import dbSQLiteOPenHelper.db.domain.Project;
//import dbSQLiteOPenHelper.service.DBOpenHelper;

/**
 * Created by T on 2016/3/4.
 */
public class ProjectDB {
    private DBOpenHelper dbOpenHelper;

    public ProjectDB(Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
    }

    public void save(Project project){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into project(date,tittle,content) values (?,?,?)",
                new Object[]{project.getdate(),project.getTittle(),project.getContent()});

    }
    public void save(Person person)
    {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into person(number,password) values (?,?)",
                new Object[]{person.getNumber(),person.getPassword()});
    }


    public long personcount()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT COUNT(person_id) FROM person",null);
        cursor.moveToFirst();
        long result=cursor.getLong(0);
        return result;
    }



    public void delete(Integer id){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("delete from project where _id=?",
                new Object[]{id});
    }
    public void personupdate(Person person){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("update person set number=?,password=? where person_id=?",
                new Object[]{person.getNumber(), person.getPassword(), person.getId()});
    }
    public void update(Project project){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("update project set date=?,tittle=?,content=? where _id=?",
                new Object[]{project.getdate(), project.getTittle(), project.getContent(), project.getId()});
    }

    public Project find(Integer _id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from project where _id=?",
                new String[]{_id.toString()});
        if(cursor.moveToFirst())
        {
            int projectid=cursor.getInt(cursor.getColumnIndex("_id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return new Project(projectid,date,tittle,content);
        }
        cursor.close();
        return null;
    }
    public Notification findnotification(Integer _id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from notification where _id=?",
                new String[]{_id.toString()});
        if(cursor.moveToFirst())
        {
            int notificationid=cursor.getInt(cursor.getColumnIndex("_id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return new Notification(notificationid,date,tittle,content);
        }
        cursor.close();
        return null;
    }



    public News findnews(Integer _id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from news where _id=?",
                new String[]{_id.toString()});
        if(cursor.moveToFirst())
        {
            int newsid=cursor.getInt(cursor.getColumnIndex("_id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return new News(newsid,date,tittle,content);
        }
        cursor.close();
        return null;
    }
    public Summary findsummary(Integer _id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from summary where _id=?",
                new String[]{_id.toString()});
        if(cursor.moveToFirst())
        {
            int newsid=cursor.getInt(cursor.getColumnIndex("_id"));
            String projectname=cursor.getString(cursor.getColumnIndex("projectname"));
            String projecttype=cursor.getString(cursor.getColumnIndex("projecttype"));
            String subject=cursor.getString(cursor.getColumnIndex("subject"));
            String starttime=cursor.getString(cursor.getColumnIndex("starttime"));
            String studentname=cursor.getString(cursor.getColumnIndex("studentname"));
            String studentcollege=cursor.getString(cursor.getColumnIndex("studentcollege"));
            String studentnumber=cursor.getString(cursor.getColumnIndex("studentnumber"));
            String studentemail=cursor.getString(cursor.getColumnIndex("studentemail"));
            String studentphone=cursor.getString(cursor.getColumnIndex("studentphone"));
            String teachername=cursor.getString(cursor.getColumnIndex("teachername"));
            String teachercollege=cursor.getString(cursor.getColumnIndex("teachercollege"));
            String teacheremail=cursor.getString(cursor.getColumnIndex("teacheremail"));
            String teacherphone=cursor.getString(cursor.getColumnIndex("teacherphone"));
//            int pid=cursor.getInt(cursor.getColumnIndex("P_id"));
            return new Summary(newsid,projectname,projecttype,subject,starttime,studentname,studentcollege,studentnumber,studentemail,studentphone,teachername,teachercollege,teacheremail,teacherphone);
        }
        cursor.close();
        return null;
    }

    public Selfinformations findselfinformation(Integer _id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from selfinformation where _id=?",
                new String[]{_id.toString()});
        if(cursor.moveToFirst())
        {
            int newsid=cursor.getInt(cursor.getColumnIndex("_id"));
            String studentname=cursor.getString(cursor.getColumnIndex("studentname"));
            String studentnumber=cursor.getString(cursor.getColumnIndex("studentnumber"));
            String identifynumber=cursor.getString(cursor.getColumnIndex("identifynumber"));
//            String password=cursor.getString(cursor.getColumnIndex("password"));
//            String confirmpassword=cursor.getString(cursor.getColumnIndex("confirmpassword"));
            String gender=cursor.getString(cursor.getColumnIndex("gender"));
            String grade=cursor.getString(cursor.getColumnIndex("grade"));
            String college=cursor.getString(cursor.getColumnIndex("college"));
            String subject=cursor.getString(cursor.getColumnIndex("subject"));
            String email=cursor.getString(cursor.getColumnIndex("email"));
            String phone=cursor.getString(cursor.getColumnIndex("phone"));
//            String teacheremail=cursor.getString(cursor.getColumnIndex("teacheremail"));
//            String teacherphone=cursor.getString(cursor.getColumnIndex("teacherphone"));
//            int pid=cursor.getInt(cursor.getColumnIndex("P_id"));
            return new Selfinformations(newsid,studentname,studentnumber,identifynumber,gender,grade,college,subject,email,phone);
        }
        cursor.close();
        return null;
    }



    public List<Project> getScrollData(int offset,int maxResult){
        List<Project> projects= new ArrayList<Project>();
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from project order by date desc limit ?,?",
                        new String[]{String.valueOf(offset),String.valueOf(maxResult)});
        while(cursor.moveToNext())
        {
            int projectid=cursor.getInt(cursor.getColumnIndex("_id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
           projects.add(new Project(projectid,date,tittle,content));
        }
        cursor.close();
        return projects;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        return db.rawQuery("select * from project order by date desc limit ?,?",
                new String[]{"0",String.valueOf(Integer.MAX_VALUE)});
    }

    public Cursor getNewsAllData()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        return db.rawQuery("select * from news order by date desc limit ?,?",
                new String[]{"0",String.valueOf(Integer.MAX_VALUE)});
    }
    public Cursor getNotificationAllData()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        return db.rawQuery("select * from notification order by date desc limit ?,?",
                new String[]{"0",String.valueOf(Integer.MAX_VALUE)});
    }
    public Cursor getsummaryAllData()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        return db.rawQuery("select * from summary order by _id desc limit ?,?",
                new String[]{"0",String.valueOf(Integer.MAX_VALUE)});
    }

public Cursor getselfinformaitonAllData(){
    SQLiteDatabase db= dbOpenHelper.getReadableDatabase();
    return db.rawQuery("select * from selfinformation order by _id desc limit ?,?",
            new String[]{"0",String.valueOf(Integer.MAX_VALUE)});
}
    public long getCount()
    {
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select count(*) from project",null);
        cursor.moveToFirst();
        long result=cursor .getLong(0);
        return result;

    }
}
