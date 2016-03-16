using System.Web;
using System.Web.Optimization;

namespace RMS
{
    public class BundleConfig
    {
        // 有关绑定的详细信息，请访问 http://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {
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

            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/bootstrap.css",
                      "~/Content/site.css"));

            bundles.Add(new StyleBundle("~/Content/header").Include(//header footer的css
                      "~/Content/header.css"));
            bundles.Add(new StyleBundle("~/Content/home").Include(//首页的css
                      "~/Content/home.css"));
            bundles.Add(new ScriptBundle("~/bundles/home").Include(
                      "~/Scripts/jquery.caroufredsel-6.0.4-packed.js",
                      "~/Scripts/indexslide.js"));
            bundles.Add(new ScriptBundle("~/bundles/login").Include("~/Scripts/login.js"));
            bundles.Add(new StyleBundle("~/bundles/notices").Include("~/Content/xwlb.css"));
            bundles.Add(new StyleBundle("~/bundles/noticescontent").Include("~/Content/xwtz.css", "~/Content/fileicon.css"));
            //bundles.Add(new ScriptBundle("~/bundles/notices").Include("~/Scripts/login.js"));
        }
    }
}
