using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace BasicAspMvcDemos.Models {
    public class Individual {
        public Individual() {
            Forename = "Dave";
            Surname = "Jones";
            Age = 23;
        }

        [Required]
        public string Forename { get; set; }

        [Required]
        public string Surname { get; set; }

        [Range(16, 65)]
        public int Age { get; set; }

        public override string ToString() {
            return String.Format("{0} {1} aged {2}", Forename, Surname, Age);
        }
    }
}