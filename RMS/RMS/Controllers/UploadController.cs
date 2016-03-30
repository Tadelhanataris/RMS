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
                byte[] buffer = new byte[file.InputStream.Length];
                file.InputStream.Read(buffer, 0, buffer.Length);
                var _fileName = file.FileName;
                var _MD5 = MD5Helper.GetHash(fs);
                var _fileExt = Path.GetExtension(Path.Combine(_fileName)).TrimStart('.');
                var fileSavePath = Path.Combine(savepath, _MD5+"."+_fileExt);
                file.SaveAs(fileSavePath);
                DBHelper.instence.Files.Add(new Models.File() { filePath = fileSavePath, fileName = _fileName, fileExt = _fileExt, MD5 = _MD5 });
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