using RMS.Log;
using System.Web;
using System.Web.Mvc;

namespace RMS
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
            filters.Add(new StatisticsTrackerAttribute());
        }
    }
}
