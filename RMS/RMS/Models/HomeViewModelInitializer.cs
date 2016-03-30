using System;
using System.Collections.Generic;
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
                 new BannerImage{href="#",src="/images/testnews2.JPG"},
                 new BannerImage{href="#",src="/images/testnews2.JPG"},
                 new BannerImage{href="#",src="/images/testnews3.JPG"},
                 new BannerImage{href="#",src="/images/testnews4.JPG"},
                 new BannerImage{href="#",src="/images/testnews5.JPG"}
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
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W" },
                new News { date=DateTime.Today,title="纪念“三八”国际妇女节106周年 暨首都妇女先进典型表彰大会在我校隆重召开",content="123W",attachment=new List<Attachment> {new Attachment {href="#",filename="党建.doc",filesize="18kb",filetype="doc" } } }
            };
            banner.ForEach(s => context.Banners.Add(s));
            notice.ForEach(n=>context.Notices.Add(n));
            news.ForEach(n=>context.News.Add(n));
            context.SaveChanges();
        }
    }
}