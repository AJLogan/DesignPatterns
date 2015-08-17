using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace State {
    public enum Enrollment { FullTime, PartTime}

    public class Student {
        private string name;
        private string course;
        private StudentType type;

        public Student(string name, string course, Enrollment enrollment) {
            this.name = name;
            this.course = course;
            type = ChooseType(enrollment);
        }

        public void ChangeEnrollment(Enrollment enrollment) {
            type = ChooseType(enrollment);
        }

        private StudentType ChooseType(Enrollment enrollment) {
            switch (enrollment) {
                case Enrollment.FullTime:
                    return new FullTimeStudentType();
                case Enrollment.PartTime:
                    return new PartTimeStudentType();
                default:
                    throw new InvalidOperationException("Unknown type");
            }
        }

        public double Fees() {
            return type.BasicFees();
        } 

        public double? TravelAllowance() {
            if (type.QualifiesForTravelSubsidy) {
                return type.TravelSubsidy();
            }
            return null;
        }

        public override string ToString() {
            var result = new StringBuilder();
            result.Append("Student ");
            result.Append(name);
            result.Append(" studying ");
            result.Append(course);
            result.Append(" paying fees of ");
            result.Append(Fees());
            if (TravelAllowance() != null) {
                result.Append(" with a travel allowance of ");
                result.Append(TravelAllowance());
            }
            return result.ToString();
        }
    }
}
