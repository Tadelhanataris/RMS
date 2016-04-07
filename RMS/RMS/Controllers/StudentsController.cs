using RMS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class StudentsController : Controller
    {
        // GET: Students
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult NewProject()
        {
            return View();
        }
        public ActionResult Progress(string id="1")
        {
            var context = DBHelper.instence.Project_progress.Where(x=>x.sequence.ToString()==id).ToArray();
            ViewData.Add("context", context);
            ViewData.Add("record_num", 5);
            ViewData.Add("current_num", id);
            return View();
        }

        [HttpPost]
        public JsonResult Progress()
        {
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