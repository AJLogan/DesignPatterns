using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace BasicAspMvcDemos
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                                name: "DemosRoute1",
                                url: "Examples/{action}/{value1}/{value2}",
                                defaults: new
                                {
                                    controller = "Demos",
                                    action = "Actions0",
                                    value1 = UrlParameter.Optional,
                                    value2 = UrlParameter.Optional
                                }
                            );

            routes.MapRoute(
                                name: "DemosRoute2",
                                url: "Examples/{action}/{*remainderOfUrl}",
                                defaults: new
                                {
                                    controller = "Demos"
                                }
                            );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );

        }
    }
}