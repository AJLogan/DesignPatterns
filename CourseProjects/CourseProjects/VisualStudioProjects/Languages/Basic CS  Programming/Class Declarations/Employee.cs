using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Class_Declarations
{
    //A basic class declaration
    public class Employee {
        //The class has 3 overloaded constructors
        public Employee(string id, string name) : base() {
            this.id = id;
            this.name = name;
        }
        public Employee(string id, string name, int age) : this(id, name) {
            this.age = age;
        }
        public Employee(string id, string name, int age, double salary) : this(id, name, age) {
            this.salary = salary;
        }
        //The 'markOnHoliday' method is overloaded
        public void markOnHoliday(int days) {
            markOnHoliday();
            holidaysTaken += days;
        }
        public void markOnHoliday() {
            onHoliday = true;
        }
        //The 'awardBonus' method is virtual to switch on polymorphism
        public virtual void awardBonus(double bonus) {
            salary += bonus;
        }
        //The base class version of 'ToString' is being replaced
        public override string ToString() {
            return id + " called " + name + " aged " + age + " earning " + salary;
        }
        //fields
        private string id;
        private string name;
        private int age;
        private double salary;
        private bool onHoliday;
        private int holidaysTaken;
    }
}
