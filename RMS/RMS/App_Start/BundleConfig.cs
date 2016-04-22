using System.Web;
using System.Web.Optimization;

namespace RMS
{
    public class BundleConfig
    {
        // 有关绑定的详细信息，请访问 http://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {


            #region css
            bundles.Add(new StyleBundle("~/Content/css").Include("~/Content/bootstrap.css"));
            bundles.Add(new StyleBundle("~/Content/header").Include("~/Content/header.css"));//header footer的css
            bundles.Add(new StyleBundle("~/Content/home").Include("~/Content/home.css"));//首页的css
            bundles.Add(new StyleBundle("~/Content/table").Include("~/Content/bgxz.css", "~/Content/fileicon.css"));
            bundles.Add(new StyleBundle("~/Content/club").Include("~/Content/cxjlb.css"));
            bundles.Add(new StyleBundle("~/Content/stu").Include("~/Content/stu.css"));//学生页面的header footer的css
            bundles.Add(new StyleBundle("~/Content/notices").Include("~/Content/xwlb.css"));
            bundles.Add(new StyleBundle("~/Content/progress").Include("~/Content/xmjd.css"));
            bundles.Add(new StyleBundle("~/Content/newproject").Include("~/Content/xxmsq.css"));
            bundles.Add(new StyleBundle("~/Content/fund").Include("~/Content/jfsyjl.css"));
            bundles.Add(new StyleBundle("~/Content/noticescontent").Include("~/Content/xwtz.css", "~/Content/fileicon.css"));
            bundles.Add(new StyleBundle("~/Content/stumid").Include("~/Content/zqjcbg.css"));
            bundles.Add(new StyleBundle("~/Content/stuend").Include("~/Content/jtysbg.css"));
            bundles.Add(new StyleBundle("~/Content/stustart").Include("~/Content/ckxmsqs.css"));
            #endregion


            #region js
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/jqueryval").Include(
                        "~/Scripts/jquery.validate*"));

            // 使用要用于开发和学习的 Modernizr 的开发版本。然后，当你做好
            // 生产准备时，请使用 http://modernizr.com 上的生成工具来仅选择所需的测试。
            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
                      "~/Scripts/bootstrap.js",
                      "~/Scripts/respond.js"));
            bundles.Add(new ScriptBundle("~/bundles/home").Include(
                      "~/Scripts/jquery.caroufredsel-6.0.4-packed.js",
                      "~/Scripts/indexslide.js"));
            bundles.Add(new ScriptBundle("~/bundles/login").Include("~/Scripts/login.js"));

            bundles.Add(new ScriptBundle("~/bundles/newproject").Include("~/Scripts/xxmsq.js"));
            #endregion
            //bundles.Add(new ScriptBundle("~/bundles/notices").Include("~/Scripts/login.js"));
        }
    }
}