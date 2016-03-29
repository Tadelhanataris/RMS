using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace RMS.Models
{
    public class Files
    {
        public Guid ID { get; set; }
        public FileStream file { get; set; }
    }
}