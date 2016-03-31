using System;
using System.Collections.Generic;
using System.IO;
using System.Web.Mvc;
using RMS.Helper;
using RMS.Models;

namespace RMS.Controllers
{
    
    public class UploadController : Controller
    {
        [HttpPost]
        public void Index()
        {
            var files = Request.Files;
            var savepath = Request.MapPath("~/savepath");
            if (!Directory.Exists(savepath))
            {
                Directory.CreateDirectory(savepath);
            }
            if (files.Count >= 0)
            {
                var file = files[0];
                DBHelper.instence.Files.Add(Models.File.AddFile(file.InputStream, file.FileName));
                DBHelper.instence.SaveChangesAsync();
            }
        }
        //[HttpGet]
        //public ActionResult Index()
        //{
        //    return HttpNotFound();
        //}
    }
}