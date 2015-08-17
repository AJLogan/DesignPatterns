using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CourseBookingMobileCS.Models {
    public class TrainingCourse {
        public TrainingCourse() {}

        public TrainingCourse(string number, string title, string type) {
            Type = type;
            Number = number;
            Title = title;
        }

        public string Type { get; set; }
        public string Number { get; set; }
        public string Title { get; set; }
    }
}