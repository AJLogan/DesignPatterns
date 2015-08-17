using System;
using System.Net.Http;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net.Http.Headers;
using BasicWebApiDemos.Models;
using System.Linq;
using System.Collections.Generic;

namespace BasicWebApiDemos.Tests.Controllers {
    [TestClass]
    public class UsersControllerAcceptanceTest {
        [TestInitialize]
        public void start() {
            client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:52504/");
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        [TestMethod]
        public void HttpClient_GetRetrievesUsers() {
            HttpResponseMessage response = client.GetAsync("api/users").Result;
            Assert.IsTrue(response.IsSuccessStatusCode);

            var users = response.Content.ReadAsAsync<IEnumerable<User>>().Result;
            var usersList = users.ToList();
            Assert.AreEqual(6, usersList.Count);
            Assert.IsTrue(usersList.Exists(user => user.Username == "dave1"));
            Assert.IsFalse(usersList.Exists(user => user.Username == "dummy"));
        }

        [TestMethod]
        public void HttpClient_GetById() {
            HttpResponseMessage response = client.GetAsync("api/users/dave1").Result;
            Assert.IsTrue(response.IsSuccessStatusCode);

            var result = response.Content.ReadAsAsync<User>().Result;
            var expected = new User("dave1", "wn1hgb0", UserRole.ROOT);
            Assert.AreEqual(expected, result);
        }

        [TestMethod]
        public void HttpClient_PostAddsAUser() {
            var newUser = new User("newUser", "passw0rd", UserRole.STANDARD);
            HttpResponseMessage response = client.PostAsJsonAsync("api/users", newUser).Result;

            Assert.IsTrue(response.IsSuccessStatusCode);

            var users = response.Content.ReadAsAsync<IEnumerable<User>>().Result;
            Assert.AreEqual(7, users.Count());
            Assert.IsTrue(users.Contains(newUser));
        }

        [TestMethod]
        public void HttpClient_PutAddsAUser() {
            var newUser = new User("newUser", "passw0rd", UserRole.STANDARD);
            HttpResponseMessage response = client.PutAsJsonAsync("api/users", newUser).Result;

            Assert.IsTrue(response.IsSuccessStatusCode);

            var users = response.Content.ReadAsAsync<IEnumerable<User>>().Result;
            Assert.AreEqual(7, users.Count());
            Assert.IsTrue(users.Contains(newUser));
        }

        [TestMethod]
        public void HttpClient_DeleteRemovesAUser() {
            HttpResponseMessage response = client.DeleteAsync("api/users?username=dave1").Result;
            var users = response.Content.ReadAsAsync<IEnumerable<User>>().Result;
            Assert.AreEqual(5, users.Count());
            Assert.IsFalse(users.ToList().Exists(user => user.Username == "dave1"));
        }

        private HttpClient client;
    }
}