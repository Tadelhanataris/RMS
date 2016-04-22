using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

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
    }
}