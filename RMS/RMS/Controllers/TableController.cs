using PagedList;
using RMS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class TableController : Controller
    {
        // GET: Table
        public ActionResult Index(string id)
        {
            var context = DBHelper.instence.Table.OrderByDescending(x => x.ID);
            if (id == "" || id == null)
            {
                ViewData.Add("context", context.ToPagedList(1, 10));
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
            ViewData.Add("context", context.ToPagedList((pagenum ?? 1), 10));
            return View();
        }
    }
}