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
        private File() { }
        private File(byte[] buffer, string FileName, string Md5)
        {
            this.MD5 = Md5;
            this.fileName = FileName;
            this.fileExt = Path.GetExtension(Path.Combine(fileName)).TrimStart('.');
            var savepath = System.AppDomain.CurrentDomain.BaseDirectory + "savepath";
            if (!Directory.Exists(savepath))
            {
                Directory.CreateDirectory(savepath);
            }
            this.filePath = Path.Combine(savepath, this.MD5 + "." + this.fileExt);
            new FileStream(filePath, FileMode.Create).Write(buffer, 0, buffer.Length);
        }

        public static File AddFile(Stream fs, string FileName)
        {
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);
            var MD5 = MD5Helper.GetHash(fs);
            if (DBHelper.instence.Files.Find(MD5) != null)
                return DBHelper.instence.Files.Find(MD5);
            return new File(buffer, FileName, MD5);
        }

        public static File AddFile(string filepath)
        {
            if (filepath.StartsWith("/") || filepath.StartsWith("\\"))
                filepath = System.AppDomain.CurrentDomain.BaseDirectory + filepath;
            var fs = new FileStream(filepath, FileMode.Open, FileAccess.Read);
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);
            var MD5 = MD5Helper.GetHash(fs);
            var fileName = Path.GetFileName(filepath);
            if (DBHelper.instence.Files.Find(MD5) != null)
                return DBHelper.instence.Files.Find(MD5);
            return new File(buffer, fileName, MD5);
        }
    }
}