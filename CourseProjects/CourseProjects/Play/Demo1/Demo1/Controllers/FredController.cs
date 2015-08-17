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

        public ViewResult Index()
        {
            return View();
        }
        public ViewResult Wilma(string username)
        {
            ViewData.Model = username;
            return View("Pebbles");
        }

    }
}
