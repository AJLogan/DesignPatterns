using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AspxExercises.TrainingV2 {
    public class Delegate {
        public Delegate(string name, string company,
                        int yearsExperience, double feePaid) {
            this.name = name;
            this.company = company;
            this.yearsExperience = yearsExperience;
            this.feePaid = feePaid;
        }
        public Delegate() {}

        public string Name {
            get { return name; }
            set { name = value; }
        }

        public string Company {
            get { return company; }
            set { company = value; }
        }

        public int YearsExperience {
            get { return yearsExperience; }
            set { yearsExperience = value; }
        }

        public double FeePaid {
            get { return feePaid; }
            set { feePaid = value; }
        }

        private String name;
        private String company;
        private int yearsExperience;
        private double feePaid;
    }
}
