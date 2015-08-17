using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace InheritanceStart {
    internal class Student {
        public Student(string name, string subject, int year, double[] marks) {
            this.name = name;
            this.subject = subject;
            this.year = year;
            this.marks = marks;
        }

        public int Year {
            set { year = value; }
        }

        public double Average() {
            double total = 0;
            foreach (double mark in marks) {
                total += mark;
            }
            return total/marks.Length;
        }

        public override string ToString() {
            string msg = "{0} studying {1} in year {2}";
            return string.Format(msg, name, subject, year);
        }

        private string name;
        private string subject;
        private int year;
        private double[] marks;
    }
}