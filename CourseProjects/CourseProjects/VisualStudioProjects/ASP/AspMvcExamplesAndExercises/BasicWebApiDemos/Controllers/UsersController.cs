using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web;
using System.IO;
using BasicWebApiDemos.Models;

namespace BasicWebApiDemos.Controllers {
    public class UsersController : ApiController {
        private readonly List<User> users = BuildUsers();

        public IEnumerable<User> GetAllUsers() {
            return users;
        }

        public User GetUserById(string id) {
            return users.Single(user => user.Username == id);
        }

        public IEnumerable<User> PutUser([FromBody] User value) {
            users.Add(value);
            return users;
        }

        public IEnumerable<User> PostUser([FromBody] User value) {
            users.Add(value);
            return users;
        }

        public IEnumerable<User> DeleteUser(string username) {
            User toDie = users.Single(user => user.Username == username);
            if (toDie != null) {
                users.Remove(toDie);
            }
            return users;
        }

        private static List<User> BuildUsers() {
            return new List<User> {
                new User("dave1", "wn1hgb0", UserRole.ROOT),
                new User("dave2", "wn1hgb1", UserRole.ADMINISTRATOR),
                new User("dave3", "wn1hgb2", UserRole.ADMINISTRATOR),
                new User("jane1", "wn1hgb3", UserRole.DEVELOPER),
                new User("jane2", "wn1hgb4", UserRole.DEVELOPER),
                new User("jane3", "wn1hgb5", UserRole.STANDARD)
            };
        }
    }
}