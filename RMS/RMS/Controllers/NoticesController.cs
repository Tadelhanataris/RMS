﻿using PagedList;
using RMS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class NoticesController : Controller
    {
        // GET: Notices
        public ActionResult Index(string id)
        {
            var context = DBHelper.instence.Notices.OrderByDescending(x => x.ID);
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
            ViewData.Add("context", context.ToPagedList((pagenum??1), 8));
            return View();
        }

        public ActionResult ViewContent(string id = null)
        {
            if (id==null||DBHelper.instence.Notices.Count(x => x.ID.ToString() == id) == 0)
            {
                return HttpNotFound();
            }
            ViewData.Add("context", DBHelper.instence.Notices.Where(x=>x.ID.ToString()==id).ToList()[0]);
            return View();
        }
    }
}