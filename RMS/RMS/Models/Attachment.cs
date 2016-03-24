namespace RMS.Models
{
    public class Attachment
    {
        public int ID { get; set; }
        public virtual Files href { get; set; }
        public string filename { get; set; }
        public string filesize { get; set; }
        public string filetype { get; set; }
    }
}