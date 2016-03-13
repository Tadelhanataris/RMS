using System;
using System.Linq;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace RMS.Models
{
    public class BannerImage
    {
        public int ID { get; set; }
        public string href { get; set; }
        public string src { get; set; }
    }

    public class Notice
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public string attachment { get; set; }
    }

    public class News
    {
        public int ID { get; set; }
        public DateTime date { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public string attachment { get; set; }
    }

    public class DBHelper : DbContext
    {
        public static readonly DBHelper instence = new DBHelper();
        private DBHelper() : base("name=DefaultConnection")
        { }
        public DbSet<BannerImage> Banners { get; set; }
        public DbSet<Notice> Notices { get; set; }
        public DbSet<News> News { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }

    }
}
