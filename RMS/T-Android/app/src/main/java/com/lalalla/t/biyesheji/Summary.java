package com.lalalla.t.biyesheji;

import java.io.Serializable;

/**
 * Created by T on 2016/3/13.
 */
public class Summary implements Serializable {
    private static final long serialVersionUID=1L;
    private Integer _id;
    private String projectname;
    private String projecttype;
    private String subject;
    private String starttime;
    private String studentname;
    private String sdudentcollege;
    private String studentnumber;
    private String sdudentemail;
    private String studentphone;
    private String teachername;
    private String teachercollege;
    private String teacheremail;
    private String teacherphone;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
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

    public void setSdudentcollege(String sdudentcollege) {
        this.sdudentcollege = sdudentcollege;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getSdudentcollege() {
        return sdudentcollege;
    }

    public String getSdudentemail() {
        return sdudentemail;
    }

    public void setSdudentemail(String sdudentemail) {
        this.sdudentemail = sdudentemail;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeachercollege() {
        return teachercollege;
    }

    public void setTeachercollege(String teachercollege) {
        this.teachercollege = teachercollege;
    }

    public String getTeacheremail() {
        return teacheremail;
    }

    public void setTeacheremail(String teacheremail) {
        this.teacheremail = teacheremail;
    }

    public String getTeacherphone() {
        return teacherphone;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone;
    }


    public Summary(String projectname, String projecttype,String subject,String starttime,String studentname,String sdudentcollege,String studentnumber,String sdudentemail,String studentphone,String teachername,String teachercollege,String teacheremail,String teacherphone) {
        super();

        this.projectname= projectname;
        this.projecttype = projecttype;
        this.subject = subject;
        this.starttime = starttime;
        this.studentname = studentname;
        this.sdudentcollege = sdudentcollege;
        this.studentnumber = studentnumber;
        this.sdudentemail = sdudentemail;
        this.studentphone = studentphone;
        this.teachername = teachername;
        this.subject = subject;
        this.teachercollege = teachercollege;
        this.teacheremail = teacheremail;
        this.teacherphone = teacherphone;
    }
    public Summary(int _id,String projectname, String projecttype,String subject,String starttime,String studentname,String sdudentcollege,String studentnumber,String sdudentemail,String studentphone,String teachername,String teachercollege,String teacheremail,String teacherphone) {
        super();
        this._id=_id;
        this.projectname= projectname;
        this.projecttype = projecttype;
        this.subject = subject;
        this.starttime = starttime;
        this.studentname = studentname;
        this.sdudentcollege = sdudentcollege;
        this.studentnumber = studentnumber;
        this.sdudentemail = sdudentemail;
        this.studentphone = studentphone;
        this.teachername = teachername;
        this.subject = subject;
        this.teachercollege = teachercollege;
        this.teacheremail = teacheremail;
        this.teacherphone = teacherphone;
    }
}
