using System;
using System.Collections.Generic;
using System.IO;
using System.Web.Mvc;
using RMS.Helper;
using RMS.Models;
using System.Data.Entity.Migrations;

namespace RMS.Controllers
{
    
    public class UploadController : Controller
    {
        [HttpPost]
        public JsonResult Index()
        {
            var files = Request.Files;
            string md5 = null;
            var savepath = Request.MapPath("~/savepath");
            if (!Directory.Exists(savepath))
            {
                Directory.CreateDirectory(savepath);
            }
            if (files.Count >= 0)
            {
                var file = files[0];
                DBHelper.instence.Files.AddOrUpdate(Models.File.AddFile(file.InputStream, file.FileName,out md5));
                DBHelper.instence.SaveChangesAsync();
            }
            return new JsonResult
            {
                Data = new
                {
                    url = "/Download/?hash=" + md5,
                    message="上传成功"
                }
            };
        }
        //[HttpGet]
        //public ActionResult Index()
        //{
        //    return HttpNotFound();
        //}
    }
}