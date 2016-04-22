using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using RMS.Models;
using System.Data.Entity.Migrations;

namespace RMS.Controllers
{
    public class AdminController : Controller
    {
        // GET: Admin
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult AddStu()
        {
            return View();
        }

        public ActionResult AddTeacher()
        {
            return View();
        }

        public ActionResult AddAdmin()
        {
            return View();
        }

        public ActionResult AddClub()
        {
            return View();
	}
        public ActionResult NewNotification()
        {
            return View();
        }
        [HttpPost]
        public JsonResult NewNotification(FormCollection fm)
        {
            var no = new Notification()
            {
                type = (Notification.n_type)Enum.Parse(typeof(Notification.n_type), (string)fm["type"])
            };
            switch (no.type)
            {
                case Notification.n_type.焦点新闻:
                    { no.news = new News { title = (string)fm["title"], content = (string)fm["content"] ,date=DateTime.Now}; break; }
                case Notification.n_type.通知公告:
                    { no.notice = new Notice { title = (string)fm["title"], content = (string)fm["content"], date = DateTime.Now }; break; }
            }

            DBHelper.instence.Notification.AddOrUpdate(no);
            DBHelper.instence.SaveChanges();


            return new JsonResult
            {
                Data = new
                {
                    message = "成功"
                }
            };
        }
    }
}