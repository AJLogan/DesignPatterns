using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Mvc;
using BasicAspMvcDemos.Models;

namespace BasicAspMvcDemos.Controllers {
    public class DemosController : Controller {
        public String Actions0() {
            return "<h1>You called the controller method 'Actions0'</h1>";
        }

        public String Actions1() {
            return "<h1>You called the controller method 'Actions1'</h1>";
        }

        public String Actions2(string value1) {
            string msg = "<h1>You passed the value '{0}' in the URL</h1>";
            return string.Format(msg, value1);
        }

        public String Actions3(string value1, string value2) {
            string msg = "<h1>You passed the values '{0}' and '{1}' in the URL</h1>";
            return string.Format(msg, value1, value2);
        }

        public String Actions4(string remainderOfUrl) {
            var msg = new StringBuilder();
            msg.Append("<h1>You passed the values ");
            foreach (var val in remainderOfUrl.Split('/')) {
                msg.Append("'");
                msg.Append(val);
                msg.Append("' ");
            }
            msg.Append("at the end of the URL</h1>");
            return msg.ToString();
        }

        public String Actions5() {
            var currentRequest = HttpContext.Request;
            var forename = currentRequest.QueryString["forename"];
            var surname = currentRequest.QueryString["surname"];
            var age = currentRequest.QueryString["age"];

            string msg = "<h1>You supplied data about '{0} {1}' aged {2}</h1>";
            return string.Format(msg, forename, surname, age);
        }

        public String Actions6(string forename, string surname, string age) {
            string msg = "<h1>You supplied data about '{0} {1}' aged {2}</h1>";
            return string.Format(msg, forename, surname, age);
        }

        public String Actions7(string forename, string surname, string age) {
            string msg = "<h1>You supplied data about '{0} {1}' aged {2}</h1>";
            return string.Format(msg, forename, surname, age);
        }

        public String Actions8(Person person) {
            string msg = "<h1>You created a person object for '{0}'</h1>";
            return string.Format(msg, person);
        }

        public String Actions9(Vehicle vehicle) {
            string msg = "<h1>You created a vehicle object for '{0}'</h1>";
            return string.Format(msg, vehicle);
        }

        public ActionResult Actions10(Individual person) {
            if (ModelState.IsValid) {
                string msg = "<h1>You created an individual object for '{0}'</h1>";
                return Content(string.Format(msg, person));
            } else {
                return View("Validation");
            }
        }

        public ActionResult Actions11(Individual person) {
            return View("Validation", person);
        }

        public ActionResult Actions12(Individual person) {
            if (ModelState.IsValid) {
                return Content(String.Format("You created an individual object for '{0}'", person));
            } else {
                throw new HttpException(406, "That data is not valid");
            }
        }

        public String Content1() {
            return "<h1>Hello Dere...</h1>";
        }

        public Person Content2() {
            var tst = new Person() {Forename = "Henry", Surname = "Jenkins", Age = 36};
            return tst;
        }

        public FilePathResult Content3() {
            return File("~/Content/SampleContent.xml", "application/xml");
        }

        public RedirectResult Content4() {
            return Redirect("/Demos/Content1");
        }

        public JsonResult Content5() {
            var data = new {
                Forename = "Peter",
                Surname = "Davies",
                Address = "12 Arcatia Road",
                Age = 27,
                Married = true
            };
            return Json(data);
        }

        public ActionResult Razor1() {
            ViewData.Model = BuildSampleData();
            return View("RazorSyntax");
        }

        public ActionResult Razor2() {
            ViewData.Model = BuildSampleData();
            return View("RazorHtmlHelpers");
        }

        public ActionResult jQuery(string demoName) {
            return demoName == null ? View("jQueryIndex") : View("jQuery/" + demoName);
        }

        private static MyData BuildSampleData() {
            var data = new MyData();

            data.TheVehicle.Manufacturer = "Nissan";
            data.TheVehicle.Model = "X-Trail";
            data.TheVehicle.Owner.Forename = "Joe";
            data.TheVehicle.Owner.Surname = "Bloggs";
            data.TheVehicle.Owner.Age = 37;
            data.AddressList = new List<string> {
                "10 Arcatia Road",
                "27 Univeristy Street",
                "32 Manor Lane"
            };
            data.Repayment = 125.60;
            return data;
        }
    }
}