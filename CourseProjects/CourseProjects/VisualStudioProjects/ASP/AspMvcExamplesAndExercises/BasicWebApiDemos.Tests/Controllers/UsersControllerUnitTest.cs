using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Web.Http;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BasicWebApiDemos;
using BasicWebApiDemos.Controllers;
using BasicWebApiDemos.Models;

namespace BasicWebApiDemos.Tests.Controllers {
    [TestClass]
    public class UsersControllerUnitTest {
        [TestMethod]
        public void GetRetrievesUsers() {
            var controller = new UsersController();
            IEnumerable<User> users = controller.GetAllUsers();
            Assert.AreEqual(6, users.Count());
        }

        [TestMethod]
        public void GetById() {
            var controller = new UsersController();
            var expected = new User("dave1", "wn1hgb0", UserRole.ROOT);
            User result = controller.GetUserById("dave1");
            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void PostAddsAUser() {
            var controller = new UsersController();
            var tstUser = new User("tstUser", "passw0rd", UserRole.DEVELOPER);
            IEnumerable<User> users = controller.PostUser(tstUser);
            Assert.AreEqual(7, users.Count());
            Assert.IsTrue(users.Contains(tstUser));
        }

        [TestMethod]
        public void PutAddsAUser() {
            var controller = new UsersController();
            var tstUser = new User("tstUser", "passw0rd", UserRole.DEVELOPER);
            IEnumerable<User> users = controller.PutUser(tstUser);
            Assert.AreEqual(7, users.Count());
            Assert.IsTrue(users.Contains(tstUser));
        }

        [TestMethod]
        public void DeleteRemovesAUser() {
            var controller = new UsersController();
            IEnumerable<User> users = controller.DeleteUser("dave1");
            Assert.AreEqual(5, users.Count());
        }
    }
}