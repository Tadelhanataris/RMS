package com.lalalla.t.biyesheji;

import java.io.Serializable;

/**
 * Created by T on 2016/3/13.
 */
public class Selfinformations implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer _id;
    private String studentname;
    private String studentnumber;
    private String identifynumber;

    private String gender;
    private String grade;
    private String college;
    private String subject;
    private String email;
    private String phone;


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }


    public String getstudentname() {
        return studentname;
    }

    public void setstudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getstudentnumber() {
        return studentnumber;
    }

    public void setstudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getidentifynumber() {
        return identifynumber;
    }

    public void setidentifynumber(String identifynumber) {
        this.identifynumber = identifynumber;
    }


    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getgender() {
        return gender;
    }

    public String getcollege() {
        return college;
    }

    public void setcollege(String college) {
        this.college = college;
    }

    public String getsubject() {
        return subject;
    }

    public void setsubject(String subject) {
        this.subject = subject;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Selfinformations(String studentname, String studentnumber, String identifynumber, String gender, String grade, String college, String subject, String email, String phone, String teacheremail, String teacherphone) {
        super();

        this.studentname = studentname;
        this.studentnumber = studentnumber;
        this.identifynumber = identifynumber;

        this.gender = gender;
        this.grade = grade;
        this.college = college;
        this.subject = subject;
        this.email = email;
        this.identifynumber = identifynumber;
        this.phone = phone;

    }

    public Selfinformations(int _id, String studentname, String studentnumber, String identifynumber, String gender, String grade, String college, String subject, String email, String phone) {
        super();
        this._id = _id;
        this.studentname = studentname;
        this.studentnumber = studentnumber;
        this.identifynumber = identifynumber;

        this.gender = gender;
        this.grade = grade;
        this.college = college;
        this.subject = subject;
        this.email = email;
        this.identifynumber = identifynumber;
        this.phone = phone;

    }
}