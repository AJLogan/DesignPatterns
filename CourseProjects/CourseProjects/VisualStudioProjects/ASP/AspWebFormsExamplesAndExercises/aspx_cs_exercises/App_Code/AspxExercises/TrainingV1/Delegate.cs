using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

namespace AspxExercises.TrainingV1 {
    public class Delegate {
        public Delegate(string name, string company,
                        int yearsExperience, double feePaid) {
            this.name = name;
            this.company = company;
            this.yearsExperience = yearsExperience;
            this.feePaid = feePaid;
        }

        public string Name {
            get { return name; }
        }

        public string Company {
            get { return company; }
        }

        public int YearsExperience {
            get { return yearsExperience; }
        }

        public double FeePaid {
            get { return feePaid; }
        }

        private readonly String name;
        private readonly String company;
        private readonly int yearsExperience;
        private readonly double feePaid;
    }
}