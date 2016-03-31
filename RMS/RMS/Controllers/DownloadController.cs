using RMS.Models;
using System;
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
            var file = DBHelper.instence.Files.Find(hash);
            Stream fs = new StreamReader(file.filePath).BaseStream;
            return File(fs, MimeMapping.GetMimeMapping(file.fileName), file.fileName);
        }
    }
}