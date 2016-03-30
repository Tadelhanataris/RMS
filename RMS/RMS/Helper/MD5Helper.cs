using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace RMS.Helper
{
    public class MD5Helper
    {
        #region 直接输入stream计算md5
        public static string GetHash(Stream fs)
        {
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);
            return GetHash(buffer);
        }
        #endregion

        #region 输入string计算md5
        public static string GetHash(string s)
        {
            return GetHash(Encoding.UTF8.GetBytes(s));
        }
        #endregion

        #region 输入byte[]计算md5
        public static string GetHash(byte[] b)
        {
            using (MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider())
            {
                return BitConverter.ToString(md5.ComputeHash(b)).Replace("-", "");
            }
        }
        #endregion
    }
}