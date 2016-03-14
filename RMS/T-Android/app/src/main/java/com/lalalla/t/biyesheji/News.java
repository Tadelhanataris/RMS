package com.lalalla.t.biyesheji;

import java.io.Serializable;

/**
 * Created by T on 2016/3/13.
 */
public class News implements Serializable {
    private static final long serialVersionUID=1L;
    private Integer id;
    private String date;
    private String tittle;
    private String content;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getdate() {
        return date;
    }
    public void setdate(String name) {
        this.date = date;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {this.tittle = tittle;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String date, String tittle,String content) {
        super();
        this.date = date;
        this.tittle = tittle;
        this.content = content;
    }
    public News(int id,String date, String tittle,String content) {
        super();
        this.id=id;
        this.date = date;
        this.tittle = tittle;
        this.content = content;
    }
}
