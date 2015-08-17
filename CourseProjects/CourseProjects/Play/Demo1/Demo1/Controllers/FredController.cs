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
        public string Wilma(string username)
        {
            return "<h1>Hello "+ username + "</h1>";
        }

    }
}
