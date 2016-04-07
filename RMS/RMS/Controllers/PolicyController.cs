using PagedList;
using RMS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class PolicyController : Controller
    {
        // GET: Policy
        public ActionResult Index(string id)
        {
            var context = DBHelper.instence.Policy.OrderByDescending(x => x.ID);
            if (id == "" || id == null)
            {
                ViewData.Add("context", context.ToPagedList(1, 8));
                return View();
            }
            int? pagenum = null;
            try
            {
                pagenum = int.Parse(id);
            }
            catch
            {
                return HttpNotFound();
            }
            ViewData.Add("context", context.ToPagedList((pagenum ?? 1), 8));
            return View();
        }
        public ActionResult ViewContent(string id = null)
        {
            if (id == null || DBHelper.instence.Policy.Find(int.Parse(id))==null)
            {
                return HttpNotFound();
            }
            ViewData.Add("context", DBHelper.instence.Policy.Find(int.Parse(id)));
            return View();
        }
    }
}