using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace State {
    class Program {
        static void Main(string[] args) {
            var s = new Student("Dave Jones", "History", Enrollment.PartTime);
            Console.WriteLine(s);
            s.ChangeEnrollment(Enrollment.FullTime);
            Console.WriteLine(s);
        }
    }
}
