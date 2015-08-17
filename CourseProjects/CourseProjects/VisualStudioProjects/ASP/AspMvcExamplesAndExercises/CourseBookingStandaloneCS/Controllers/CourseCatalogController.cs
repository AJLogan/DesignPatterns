using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CourseBookingStandaloneCS.Models;
using CourseBookingStandaloneCS.DataAccess;

namespace CourseBookingStandaloneCS.Controllers {
    public class CourseCatalogController : Controller {
        public CourseCatalogController(ITrainingCourseDAO dao) {
            this.dao = dao;
        }

        public ActionResult Index() {
            ViewData.Model = dao.GetAllCourses();
            return View();
        }

        public ActionResult ByNumber(string number) {
            TrainingCourse course = dao.GetCourseByNumber(number);
            if (course != null) {
                ViewData.Model = course;
                return View();
            } else {
                string errorMsg = String.Format("No Course With the Number '{0}'", number);
                ViewData.Model = errorMsg;
                return View("NoResults");
            }
        }

        public ActionResult ByKeyword(string keyword) {
            IQueryable<TrainingCourse> courses = dao.GetCoursesContainingText(keyword);
            if (courses.ToList().Count != 0) {
                ViewData["keyword"] = keyword;
                ViewData.Model = courses;
                return View();
            } else {
                string errorMsg = String.Format("No Courses Contain the Keyword '{0}'", keyword);
                ViewData.Model = errorMsg;
                return View("NoResults");
            }
        }

        [AcceptVerbs(HttpVerbs.Get)]
        public ActionResult NewCourse() {
            return View("NewCourse");
        }

        [AcceptVerbs(HttpVerbs.Post)]
        public ActionResult NewCourse(string number, string title, string type) {
            dao.AddCourse(new TrainingCourse() {Number = number, Title = title, Type = type});
            ViewData["message"] = "Course Created Sccessfully!";
            ViewData.Model = dao.GetCourseByNumber(number);
            return View("NewCourseCreated");
        }

        private readonly ITrainingCourseDAO dao;
    }
}