using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace BasicWebApiDemos.Models {
    public enum UserRole {
        STANDARD,
        DEVELOPER,
        ADMINISTRATOR,
        ROOT
    }

    [DataContract]
    public class User {
        public User(string uname, string passwd, UserRole role) {
            Username = uname;
            Password = passwd;
            Role = role;
        }

        public override bool Equals(object obj) {
            if (obj == null || !(obj is User)) {
                return false;
            } else {
                var other = obj as User;
                return Username == other.Username &&
                       Password == other.Password &&
                       Role == other.Role;
            }
        }

        [DataMember]
        public string Username { get; set; }

        [DataMember]
        public string Password { get; set; }

        [DataMember]
        public UserRole Role { get; set; }
    }
}