using System;

namespace State {
    public abstract class StudentType {
        public abstract double BasicFees();
        public virtual bool QualifiesForTravelSubsidy {
            get { return false; }
        }
        public virtual double TravelSubsidy() {
            throw new InvalidOperationException("Does not qualify");
        }
    }
    public class PartTimeStudentType : StudentType {
        public override double BasicFees() {
            return 3000.0;
        }
    }
    public class FullTimeStudentType : StudentType {
        public override double BasicFees() {
            return 5000.0;
        }
        public override bool QualifiesForTravelSubsidy {
            get {
                return true;
            }
        }
        public override double TravelSubsidy() {
            return 50.60;
        }
    }
}
