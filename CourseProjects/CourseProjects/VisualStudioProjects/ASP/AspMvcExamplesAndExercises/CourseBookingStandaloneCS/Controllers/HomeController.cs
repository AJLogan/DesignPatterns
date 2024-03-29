﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CourseBookingStandaloneCS.Controllers {
    public class HomeController : Controller {
        public ActionResult Index() {
            ViewBag.Title = "Suineg Training";
            ViewBag.Message = "The Best Software Training Around";

            return View();
        }

        public ActionResult About() {
            ViewBag.Message = "Your app description page.";

            return View();
        }

        public ActionResult Contact() {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}