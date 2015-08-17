namespace DataBinding {
    public class Employee {
        private string id;
        private string department;
        private string name;
        private double salary;

        public Employee(string id, string name, string department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public Employee() {
        }
        public string ID {
            get { return id; }
            set { id = value; }
        }
        public string Name {
            get { return name; }
            set { name = value; }
        }
        public string Department {
            get { return department; }
            set { department = value; }
        }
        public double Salary {
            get { return salary; }
            set { salary = value; }
        }
    }
}