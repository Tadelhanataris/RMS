using System;
using System.Linq;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Collections.Generic;

namespace RMS.Models
{
    public enum ProjectClass { 院级,校级,市级,国家级};
    public class BannerImage
    {
        public int ID { get; set; }
        public string href { get; set; }
        public virtual File src { get; set; }
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
        public int ID { get; set; }
        public string name { get; set; }
        public bool sex { get; set; }
        public virtual Academy academy { get; set; }
        public string identity { get; set; }
        public string email { get; set; }
        public long phone { get; set; }
    }
    public class Member : Person {
        public long sno { get; set; }
        public string subject { get; set; }
        public string assignment { get; set; }
    }
    public class Leader : Person {
        public long sno { get; set; }
        public string subject { get; set; }
    }

    public class Fund
    {
        public enum m_type { 图书资料费,实验材料费,调研费,印刷费,成果转化费}
        public int ID { get; set; }
        public m_type fundType { get; set; }
        public float money { get; set; }
        public string reason { get; set; }
    }

    public class Project
    {
        public enum p_type {指南类,自选类,创业类,定向资助,延续资助 }
        public int ID { get; set; }
        public string projectName { get; set; }
        public p_type projectType { get; set; }
        public string projectNo { get; set; }
        public string projectSubject { get; set; }
        public virtual Leader leader { get; set; }
        public virtual Member[] members { get; set; }
        //todo 教师类
        //public virtual Teacher teacher { get; set; }
        public string baseon { get; set; }
        public string purpose { get; set; }
        public string schedule { get; set; }
        public string format { get; set; }
        public string special { get; set; }
        public string experience { get; set; }
        public virtual Fund[] fund { get; set; }
        public virtual FundUse[] funduse { get; set; }
        


        #region 以下部分未定
        public string passProject { get; set; }
        public ProjectClass passProjectClass { get; set; }
        public string passLeaderName { get; set; }
        public long passLeaderPhone { get; set; }
        public long paaLeaderSno { get; set; }
        public string passTeacherName { get; set; }
        public long passTeacherPhone { get; set; }
        public string passTeacherTitle { get; set; }
        #endregion
    }

    public class FundUse
    {
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
        private DBHelper() : base("name=DefaultConnection"){ }
        public DbSet<File> Files { get; set; }
        public DbSet<BannerImage> Banners { get; set; }
        public DbSet<Notice> Notices { get; set; }
        public DbSet<News> News { get; set; }
        public DbSet<Policy> Policy { get; set; }
        public DbSet<Table> Table { get; set; }
        public DbSet<Project_Progress> Project_progress { get; set; }
        public DbSet<Project> Project { get; set; }

        public DbSet<Academy> Academy { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();  
        }
    }
}
