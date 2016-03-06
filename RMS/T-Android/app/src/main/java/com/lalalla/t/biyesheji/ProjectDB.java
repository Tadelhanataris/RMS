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
    public void delete(Integer id){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("delete from project where id=?",
                new Object[]{id});
    }
    public void update(Project project){
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        db.execSQL("update project set date=?,tittle=?,content=? where id=?",
                new Object[]{project.getdate(),project.getTittle(),project.getContent(),project.getId()});
    }
    public Project find(Integer id){
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from project where id=?",
                new String[]{id.toString()});
        if(cursor.moveToFirst())
        {
            int projectid=cursor.getInt(cursor.getColumnIndex("id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return new Project(projectid,date,tittle,content);
        }
        cursor.close();
        return null;
    }
    public List<Project> getScrollData(int offset,int maxResult){
        List<Project> projects= new ArrayList<Project>();
        SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from project order by id asc limit ?,?",
                        new String[]{String.valueOf(offset),String.valueOf(maxResult)});
        while(cursor.moveToNext())
        {
            int projectid=cursor.getInt(cursor.getColumnIndex("id"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String tittle=cursor.getString(cursor.getColumnIndex("tittle"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
           projects.add(new Project(projectid,date,tittle,content));
        }
        cursor.close();
        return projects;
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
