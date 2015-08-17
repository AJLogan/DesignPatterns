using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AspxExercises.TrainingV2 {
    public class TrainingCourse {
        static TrainingCourse() {
            attendees = new List<Delegate>();
            attendees.Add(new Delegate("Joe Bloggs", "BMW", 3, 2500.0));
            attendees.Add(new Delegate("Jane Smith", "Honda", 5, 2600.0));
            attendees.Add(new Delegate("Fred Martin", "Nissan", 2, 2700.0));
            attendees.Add(new Delegate("Sarah Jenkins", "Peugeot", 1, 2800.0));
            attendees.Add(new Delegate("Peter Griffiths", "Renault", 7, 2900.0));
        }
        public List<Delegate> GetDelegates(int maximum, int startIndex) {
            if (startIndex + maximum > attendees.Count) {
                return attendees.GetRange(startIndex, attendees.Count - startIndex);
            } else {
                return attendees.GetRange(startIndex, maximum);
            }
        }
        public int GetDelegateCount() {
            return attendees.Count;
        }
        public void AddDelegate(Delegate d) {
            attendees.Add(d);
        }
        private static readonly List<Delegate> attendees;
    }
}
