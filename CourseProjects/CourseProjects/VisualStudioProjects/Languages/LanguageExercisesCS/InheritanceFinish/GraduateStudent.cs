using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace InheritanceFinish {
    class GraduateStudent : Student {
        public GraduateStudent(string name, string subject, int year,
                               double[] marks, params Student[] students)
                               : base(name, subject, year, marks) {
           this.students = students;
        }
        public override string ToString() {
            string msg = "{0} supervising {1} students";
            return string.Format(msg, base.ToString(), students.Length);
        }
        public new double Average() {
            double total = 0;
            foreach (Student s in students) {
                total += s.Average();
            }
            return total / students.Length;
        }
        private Student[] students;
    }
}
