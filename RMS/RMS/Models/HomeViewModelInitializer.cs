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
            string[] acd = {"文学院",
"历史学院",
"政法学院",
"教育学院",
"外国语学院",
"马克思主义学院",
"管理学院",
"音乐学院",
"美术学院",
"数学科学学院",
"物理系",
"化学系",
"生命科学学院",
"资源环境与旅游学院",
"信息工程学院",
"教育技术系",
"初等教育学院",
"学前教育学院",
"燕都学院",
"良乡校区基础学部",
"继续教育学院",
"国际文化学院",
"京疆学院",
"中国书法文化研究院",
"文化研究院",
"首都基础教育发展研究院",
"大学英语教研部",
"体育教学研究部",
"图书馆",
"上海合作组织大学"};
            acd.ToList().ForEach(x => context.Academy.AddOrUpdate(new Academy { academy = x }));
            banner.ForEach(s => { context.Banners.AddOrUpdate(s); });
            notice.ForEach(n => { context.Notices.AddOrUpdate(n); });
            news.ForEach(n => { context.News.AddOrUpdate(n); });
            policy.ForEach(n => { context.Policy.AddOrUpdate(n); });
            var table = new List<Table>
            {
                new Table {title="党建1",file=File.AddFile(@"D:\neccs.jpg") },
            };
            
            table.ForEach(n => { context.Table.AddOrUpdate(n);});
            context.SaveChangesAsync();
        }
    }
}