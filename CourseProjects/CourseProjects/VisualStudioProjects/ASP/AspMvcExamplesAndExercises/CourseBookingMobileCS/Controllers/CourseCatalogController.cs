using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CourseBookingMobileCS.Models;
using CourseBookingMobileCS.DataAccess;

namespace CourseBookingMobileCS.Controllers {
    public class CourseCatalogController : Controller {
        public CourseCatalogController(ITrainingCourseDAO dao) {
            this.dao = dao;
        }

        public ActionResult Index() {
            ViewData.Model = dao.GetAllCourses();
            return View();
        }

        private ITrainingCourseDAO dao;
    }
}