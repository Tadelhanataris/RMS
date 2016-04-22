using RMS.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity.Migrations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RMS.Controllers
{
    public class StudentsController : Controller
    {
        // GET: Students
        public ActionResult Index()
        {
            return View();
        }

        #region 新建项目
        public ActionResult NewProject()
        {
            return View();
        }

        [HttpPost]
        public JsonResult NewProject(Project project)
        {
            try
            {
                project.leader.academy = DBHelper.instence.Academy.Find(int.Parse(this.Request.Form["leader.academy"]));
                if (project.members != null)
                {
                    int i = project.members.Count();
                    for (; i > 0; i--)
                    {
                        project.members.ElementAt(i-1).academy = DBHelper.instence.Academy.Find(int.Parse(this.Request.Form["members[" + (i - 1) + "].academy"]));
                    }
                }
                DBHelper.instence.Project.Add(project);
                DBHelper.instence.SaveChanges();
                return new JsonResult
                {
                    Data = new
                    {
                        message = "提交成功！"
                    }
                };
            }
            catch
            {
                
                return new JsonResult
                {
                    Data = new
                    {
                        message = "提交失败！"
                    }
                };
            }
        }

        #endregion

        #region 项目进度
        public ActionResult Progress(string id="1")
        {
            //todo 通过cookie获得用户关联到项目
            ViewData.Add("record_num", 5);
            ViewData.Add("current_num", int.Parse(id));
            //todo 后台设置可编辑时间
            var mod = DBHelper.instence.Project_progress.Where(x => x.sequence.ToString() == id);
            if (mod.Count() > 0)
                return View(mod.First());
            else
                return View();
        }

        [HttpPost]
        public JsonResult Progress(FormCollection Fm)
        {
            //todo 通过cookie获得用户关联到项目
            //todo 根据后台可编辑时间确定是否接收
            var _sequence = int.Parse(Fm.GetValue("sequence").AttemptedValue);
            var _title = Fm.GetValue("title").AttemptedValue;
            var _content = Fm.GetValue("content").AttemptedValue;
            DBHelper.instence.Project_progress.AddOrUpdate(new Project_Progress { sequence = _sequence, title = _title, content = _content });
            if(DBHelper.instence.SaveChanges()>0)
                return new JsonResult
                {
                    Data = new
                    {
                        message = "项目第"+ _sequence + "次记录保存成功！"
                    }
                };
            else
                return new JsonResult
                {
                    Data = new
                    {
                        message = "提交失败！"
                    }
                };
        }
        #endregion

        #region 项目申请书
        public ActionResult Start()
        {
            return View();
        }
        #endregion

        #region 项目中期报告
        public ActionResult Mid()
        {
                return View();
        }
        #endregion

        #region 项目结题报告
        public ActionResult End()
        {
            return View();
        }
        #endregion


        #region 经费使用记录
        public ActionResult Fund()
        {
            return View();
        }
        #endregion
        public ActionResult OverView()
        {
            return View();
        }
    }
}