using RMS.Log.Monitor.Models.ActionFilters;
using RMS.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class DownloadController : Controller
    {
        // GET: Download
        public FileStreamResult Index(string hash)
        {
            try
            {
                return File(DBHelper.instence.files.Where(x => x.ID == Guid.Parse(hash)).First().file, "application/octet-stream"); 
            }
            catch(Exception e)
            {
                LoggerHelper.Error("down", e);
                return null;
            }
            //string absoluFilePath = Server.MapPath(System.Configuration.ConfigurationManager.AppSettings["AttachmentPath"] + filePath);
            //return File(new FileStream(absoluFilePath, FileMode.Open), "application/octet-stream", Server.UrlEncode(fileName));
        }
    }
}