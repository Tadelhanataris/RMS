using System;
using System.Collections.Generic;
using System.Data.Entity.Migrations;
using System.IO;
using System.Linq;
using System.Web;

namespace RMS.Models
{
    public class BannerImageDBContextInitializer : System.Data.Entity.DropCreateDatabaseAlways<DBHelper>
    {
        protected override void Seed(DBHelper context)
        {
            var banner = new List<BannerImage>
             {
                 new BannerImage{href="#",src=File.AddFile("/images/testnews1.JPG")},
                 new BannerImage{href="#",src=File.AddFile("/images/testnews2.JPG")},
                 new BannerImage{href="#",src=File.AddFile("/images/testnews3.JPG")},
                 new BannerImage{href="#",src=File.AddFile("/images/testnews4.JPG")},
                 new BannerImage{href="#",src=File.AddFile("/images/testnews5.JPG")}
             };
            var notice = new List<Notice>
            {
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Notice { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N"}
            };
            var policy = new List<Policy>
            {
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N" },
                new Policy { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123N"}
            };
            var news = new List<News>
            {
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W",attachment=new List<Attachment> {new Attachment {href=File.AddFile(@"D:\index.html"),filename="党建.doc",filesize="18kb",filetype="doc" } } }
            };
            banner.ForEach(s => { context.Banners.AddOrUpdate(s); context.SaveChangesAsync(); });
            notice.ForEach(n => { context.Notices.AddOrUpdate(n); context.SaveChangesAsync(); });
            news.ForEach(n => { context.News.AddOrUpdate(n); context.SaveChangesAsync(); });
            policy.ForEach(n => { context.Policy.AddOrUpdate(n); context.SaveChangesAsync(); });
            var table = new List<Table>
            {
                new Table {title="党建1",file=File.AddFile(@"D:\neccs.jpg") },
            };
            
            table.ForEach(n => { context.Table.AddOrUpdate(n); context.SaveChangesAsync(); });
        }
    }
}