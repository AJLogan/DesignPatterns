using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace UsingLinqStart {
    class Program {
        static void Main(string[] args) {
            var students = BuildSampleData();
            FindPsychologyStudents(students);
            FindOverallAverage(students);
        }

        private static void FindOverallAverage(List<Student> students) {
            double total = 0;
            foreach (var student in students) {
                total += student.Average();
            }
            Console.WriteLine("Overall average is: {0}", total / students.Count);
        }

        private static void FindPsychologyStudents(List<Student> students) {
            var results = new List<string>();
            foreach (var student in students) {
                if (student.Subject == "Psychology") {
                    results.Add(student.Name);
                }
            }
            Console.WriteLine("Psychology students are:");
            foreach (string s in results) {
                Console.WriteLine(s);
            }
        }
        private static List<Student> BuildSampleData() {
            List<Student> students = new List<Student>();
            students.Add(new Student("Dave", "Psychology", 3, new double [] { 76.5, 82.4 }));
            students.Add(new Student("Jane", "Comp Sci", 3, new double [] { 66.4, 70.2 }));
            students.Add(new Student("Pete", "Psychology", 3, new double [] { 91.5, 82.5 }));
            students.Add(new Student("Mary", "Comp Sci", 3, new double [] { 54.7, 89.3 }));
            students.Add(new Student("Fred", "Psychology", 3, new double []{ 93.4, 68.2 }));
            students.Add(new Student("Susan", "Comp Sci", 3, new double [] { 59.3, 79.5 }));
            students.Add(new Student("Henry", "Psychology", 3, new double [] { 81.3, 87.3 }));
            students.Add(new Student("Lucy", "Comp Sci", 3, new double [] { 89.1, 58.4 }));

            return students;
        }
    }
}
