using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Demo1.Controllers
{
    public class FredController : Controller
    {
        //
        // GET: /Fred/

        public ActionResult Index()
        {
            return View();
        }
        public string Wilma()
        {
            return "<h1>Hello Flintstones</h1>";
        }

    }
}
