using System;
using System.Linq;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Collections.Generic;

namespace RMS.Models
{
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

    public class Project_Progress
    {
        
        public int ID { get; set; }
        public int sequence { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        //public virtual Project project { get; set; }
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
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();  
        }
    }
}
