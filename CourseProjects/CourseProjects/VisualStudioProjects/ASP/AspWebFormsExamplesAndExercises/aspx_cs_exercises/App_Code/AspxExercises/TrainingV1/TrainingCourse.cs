using System;
using System.Collections.Generic;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

namespace AspxExercises.TrainingV1 {
    public class TrainingCourse {
        public TrainingCourse() {
        }
        public List<Delegate> GetDelegates() {
            List<Delegate> attendees = new List<Delegate>();
            attendees.Add(new Delegate("Joe Bloggs", "BMW", 3, 2500.0));
            attendees.Add(new Delegate("Jane Smith", "Honda", 5, 2600.0));
            attendees.Add(new Delegate("Fred Martin", "Nissan", 2, 2700.0));
            attendees.Add(new Delegate("Sarah Jenkins", "Peugeot", 1, 2800.0));
            attendees.Add(new Delegate("Peter Griffiths", "Renault", 7, 2900.0));
            return attendees;
        }
    }
}
