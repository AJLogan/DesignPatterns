using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.SessionState;
using CourseBookingMobileCS.Controllers;
using CourseBookingMobileCS.Models;
using CourseBookingMobileCS.DataAccess;

namespace CourseBookingMobileCS.Controllers.Factories {
    public class CourseBookingControllerFactory : IControllerFactory {
        public IController CreateController(RequestContext context, string name) {
            switch (name) {
                case "Home":
                    return new HomeController();
                case "CourseCatalog": {
                    var dao = new StubTrainingCourseDAO();
                    return new CourseCatalogController(dao);
                }
                default:
                    return null;
            }
        }

        public SessionStateBehavior GetControllerSessionBehavior(RequestContext context, string name) {
            return SessionStateBehavior.Default;
        }

        public void ReleaseController(IController controller) {}
    }
}