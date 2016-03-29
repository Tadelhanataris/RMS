using System;
using System.Collections.Generic;
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
                 new BannerImage{src=new Files { file=new System.IO.FileStream(@"/images/testnews1.JPG",System.IO.FileMode.Open) },href="#"},
                 new BannerImage{src=new Files { file=new System.IO.FileStream(@"/images/testnews2.JPG",System.IO.FileMode.Open) },href="#"},
                 new BannerImage{src=new Files { file=new System.IO.FileStream(@"/images/testnews3.JPG",System.IO.FileMode.Open) },href="#"},
                 new BannerImage{src=new Files { file=new System.IO.FileStream(@"/images/testnews4.JPG",System.IO.FileMode.Open) },href="#"},
                 new BannerImage{src=new Files { file=new System.IO.FileStream(@"/images/testnews5.JPG",System.IO.FileMode.Open) },href="#"}
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
            var news = new List<News>
            {
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W",attachment=new List<Attachment>() },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W",attachment=new List<Attachment> {new Attachment {href=new Files { file= new System.IO.FileStream(@"D:\index.html", System.IO.FileMode.Open) },filename="党建.doc",filesize="18kb",filetype="doc" } } }
            };
            banner.ForEach(s => context.Banners.Add(s));
            notice.ForEach(n => context.Notices.Add(n));
            news.ForEach(n => context.News.Add(n));
            context.SaveChanges();
        }
    }
}