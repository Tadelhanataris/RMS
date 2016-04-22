using System;
using System.Linq;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace RMS.Models
{
    public enum ProjectClass { 院级, 校级, 市级, 国家级 };
    public class BannerImage
    {
        public int ID { get; set; }
        public string href { get; set; }
        public virtual File src { get; set; }
    }

    public class Notification
    {
        public int ID { get; set; }
        public enum n_type { 通知公告 , 焦点新闻 , 政策文件 , 项目指南 , 文件表格 }
        public n_type type { get; set; }
        public virtual Notice notice { get; set; }
        public virtual News news { get; set; }
        public virtual Policy policy { get; set; }
        public virtual Table table { get; set; }
        public virtual Gallery gallery { get; set; }
        //public virtual Guide guide { get; set; } //todo
    }

    public class Notice
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public virtual List<Attachment> attachment { get; set; }
    }

    public class News
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public virtual List<Attachment> attachment { get; set; }
    }

    public class Policy
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public virtual List<Attachment> attachment { get; set; }
    }

    public class Guide
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public virtual List<Attachment> attachment { get; set; }
    }

    public class Gallery
    {
        public int ID { get; set; }
        public virtual Project project { get; set; }
        public virtual IEnumerable<Result> result { get; set; }
        public class Result
        {
            public int ID { get; set; }
            public string title { get; set; }
            public string content { get; set; }
            public File pic { get; set; }
        }
    }

    public class Table
    {
        public int ID { get; set; }
        public string title { get; set; }
        public virtual File file { get; set; }
    }

    public class Academy
    {
        public int ID { get; set; }
        public string academy { get; set; }
    }

    public class Person
    {
        public string name { get; set; }
        public bool sex { get; set; }
        public virtual Academy academy { get; set; }
        public string identity { get; set; }
        public string email { get; set; }
        public long phone { get; set; }
    }
    public class Club :Person
    {
        public int cno { get; set; }
        public string pwd { get; set; }
        public int grade { get; set; }
        public string subject { get; set; }
        //照片
    }
    public class Admin : Person
    {
        [Key]
        public int ano { get; set; }
        public string pwd { get; set; }
    }
    public class Teacher :Person
    {
        [Key]
        public int tno { get; set; }
        public string pwd { get; set; }
        public int tage { get; set; }
        public string finaldegree { get; set; }
        public string subject { get; set; }
        public string direction { get; set; }
        public string title { get; set; }
        public string duty { get; set; }
        public string tel { get; set; }
    }
    public class Member : Person
    {
        [Key]
        public int sno { get; set; }
        public string subject { get; set; }
        public string assignment { get; set; }
        public int assignmentratio { get; set; }
        public bool afterinto { get; set; }
    }
    public class Leader : Person
    {
        [Key]
        public int sno { get; set; }
        public string subject { get; set; }
        public string assignment { get; set; }
        public int assignmentratio { get; set; }
        public bool afterinto { get; set; }
    }
    public class Stu :Person
    {
        [Key]
        public int sno { get; set; }
        public string pwd { get; set; }
        public int grade { get; set; }
        public string subject { get; set; }
    }

    public class Fund
    {
        public enum m_type { 图书资料费, 实验材料费, 调研费, 印刷费, 成果转化费, 文献资料收集查询费, 交通费, 其他 }
        public int ID { get; set; }
        public m_type fundType { get; set; }
        public float money { get; set; }
        public string reason { get; set; }
    }

    public class Project
    {
        public enum p_type { 指南类, 自选类, 创业类, 定向资助, 延续资助 }
        public int ID { get; set; }
        public string projectName { get; set; }
        public p_type projectType { get; set; }
        public string projectNo { get; set; }
        public string projectSubject { get; set; }
        public virtual Leader leader { get; set; }
        public virtual IEnumerable<Member> members { get; set; }
        //todo 教师类
        //public virtual Teacher teacher { get; set; }
        public string baseon { get; set; }
        public string purpose { get; set; }
        public string schedule { get; set; }
        public string format { get; set; }
        public string special { get; set; }
        public string experience { get; set; }
        public virtual IEnumerable<Fund> fund { get; set; }
        public virtual IEnumerable<FundUse> funduse { get; set; }
        public virtual StartReport startreport { get; set; }
        public virtual MidReport midreport { get; set; }
        public virtual EndReport endreport { get; set; }



        #region 以下部分未定
        public string passProject { get; set; }
        public ProjectClass passProjectClass { get; set; }
        public string passLeaderName { get; set; }
        public long passLeaderPhone { get; set; }
        public long passLeaderSno { get; set; }
        public string passTeacherName { get; set; }
        public long passTeacherPhone { get; set; }
        public string passTeacherTitle { get; set; }
        #endregion
    }

    public class StartReport
    {
        public int ID { get; set; }
    }

    public class MidReport
    {
        public int ID { get; set; }
        public enum Status { 提前完成, 按时完成, 可能无法完成 }
        public double money { get; set; }
        public Status status { get; set; }
        public string proceed { get; set; }
    }

    public class EndReport
    {
        public int ID { get; set; }
        public string summary { get; set; }
        public string mainresult { get; set; }
        public string resultformat { get; set; }
        public IEnumerable<Fund> expectfund { get; set; }
        public IEnumerable<Fund> actualfund { get; set; }
    }

    public class FundUse
    {
        public int ID { get; set; }
        public DateTime time { get; set; }
        public string title { get; set; }
        public float money { get; set; }
    }

    public class Project_Progress
    {

        public int ID { get; set; }
        public int sequence { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public virtual Project project { get; set; }
    }




    public class DBHelper : DbContext
    {
        public static readonly DBHelper instence = new DBHelper();
        private DBHelper() : base("name=DefaultConnection") { }
        public DbSet<File> Files { get; set; }
        public DbSet<BannerImage> Banners { get; set; }
        public DbSet<Notice> Notices { get; set; }
        public DbSet<News> News { get; set; }
        public DbSet<Policy> Policy { get; set; }
        public DbSet<Guide> Guide { get; set; }
        public DbSet<Table> Table { get; set; }
        public DbSet<Project_Progress> Project_progress { get; set; }
        public DbSet<Project> Project { get; set; }
        public DbSet<Notification> Notification { get; set; }

        public DbSet<Academy> Academy { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}
