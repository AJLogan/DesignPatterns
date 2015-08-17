using System;
using System.Web.Mvc;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using CourseBookingStandaloneCS.Controllers;
using CourseBookingStandaloneCS.Models;
using CourseBookingStandaloneCS.DataAccess;

namespace CourseBookingStandaloneCS.Tests.Controllers {
    [TestClass]
    public class CourseCatalogControllerTest {
        [TestInitialize()]
        public void Begin() {
            dao = new StubTrainingCourseDAO();
            controller = new CourseCatalogController(dao);
        }

        [TestMethod]
        public void IndexAction_ReturnsAllCourses() {
            var result = controller.Index() as ViewResult;
            var courses = (IQueryable<TrainingCourse>) result.ViewData.Model;
            Assert.AreEqual(7, courses.Count());
        }

        [TestMethod]
        public void ByNumber_ReturnsValidCourse() {
            var result = controller.ByNumber("AB12") as ViewResult;
            var tc = (TrainingCourse) result.ViewData.Model;
            Assert.AreEqual("AB12", tc.Number);
            Assert.AreEqual("Intro To C++", tc.Title);
        }

        [TestMethod]
        public void ByNumber_HandlesInvalidCourseNumber() {
            var result = controller.ByNumber("ZZ00") as ViewResult;
            Assert.AreEqual("NoResults", result.ViewName);
        }

        [TestMethod]
        public void ByKeyword_ReturnsValidCourses() {
            var result = controller.ByKeyword("Intro") as ViewResult;
            var courses = (IQueryable<TrainingCourse>) result.ViewData.Model;
            var keyword = (string) result.ViewData["keyword"];
            Assert.AreEqual("Intro", keyword);
            Assert.AreEqual(4, courses.Count());
        }

        [TestMethod]
        public void ByKeyword_HandlesUnknownKeyword() {
            var result = controller.ByKeyword("XXX") as ViewResult;
            Assert.AreEqual("NoResults", result.ViewName);
        }

        private CourseCatalogController controller;
        private ITrainingCourseDAO dao;
    }
}