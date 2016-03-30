using RMS.Helper;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.IO;
using System.Linq;
using System.Web;

namespace RMS.Models
{
    public class File
    {
        [Key]
        [StringLength(32)]
        public string MD5 { set; get; }
        [StringLength(int.MaxValue)]
        public string filePath { get; set; }
        [StringLength(1024)]
        public string fileName { get; set; }
        [StringLength(8)]
        public string fileExt { set; get; }
        public File() { }
        public File(Stream fs,string FileName)
        {
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);
            var _fileName = FileName;
            var _MD5 = MD5Helper.GetHash(fs);
            var _fileExt = Path.GetExtension(Path.Combine(_fileName)).TrimStart('.');
            var savepath = Request.MapPath("~/savepath");
            if (!Directory.Exists(savepath))
            {
                Directory.CreateDirectory(savepath);
            }
            var fileSavePath = Path.Combine(savepath, _MD5 + "." + _fileExt);
            new FileStream(fileSavePath, FileMode.Create).Write(buffer, 0, buffer.Length);
            DBHelper.instence.Files.Add(new Models.File() { filePath = fileSavePath, fileName = _fileName, fileExt = _fileExt, MD5 = _MD5 });
            DBHelper.instence.SaveChangesAsync();
        }
    }
}