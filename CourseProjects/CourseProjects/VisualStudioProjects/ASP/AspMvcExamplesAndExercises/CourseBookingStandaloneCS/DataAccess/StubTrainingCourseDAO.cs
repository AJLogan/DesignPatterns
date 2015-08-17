using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CourseBookingStandaloneCS.Models;

namespace CourseBookingStandaloneCS.DataAccess
{
    public class StubTrainingCourseDAO : ITrainingCourseDAO
    {
         public StubTrainingCourseDAO() {
            additions = new List<TrainingCourse>();
            updates = new List<TrainingCourse>();
            sampleData = new List<TrainingCourse>();
            PopulateInitialCourses();
        }
        private void PopulateInitialCourses() {
            sampleData.Add(new TrainingCourse() { Number = "AB12", Title = "Intro To C++", Type = "Beginners" });
            sampleData.Add(new TrainingCourse() { Number = "CD34", Title = "Intro To C#", Type = "Beginners" });
            sampleData.Add(new TrainingCourse() { Number = "EF56", Title = "Intro To Java", Type = "Beginners" });
            sampleData.Add(new TrainingCourse() { Number = "GH78", Title = "Intro To IL", Type = "Intermediate" });
            sampleData.Add(new TrainingCourse() { Number = "IJ90", Title = "XPath and XSLT", Type = "Intermediate" });
            sampleData.Add(new TrainingCourse() { Number = "KL12", Title = "Enterprise JavaBeans", Type = "Advanced" });
            sampleData.Add(new TrainingCourse() { Number = "MN34", Title = "Designing .NET Apps", Type = "Advanced" });
        }
        public TrainingCourse GetCourseByNumber(string number) {
            TrainingCourse course = null;
            foreach (TrainingCourse tc in sampleData) {
                if (tc.Number == number) {
                    course = tc;
                }
            }
            return course;
        }
        public TrainingCourse GetCourseByTitle(string title) {
            TrainingCourse course = null;
            foreach (TrainingCourse tc in sampleData) {
                if (tc.Title == title) {
                    course = tc;
                }
            }
            return course;
        }
        public IQueryable<TrainingCourse> GetAllCourses() {
            return sampleData.AsQueryable<TrainingCourse>();
        }
        public IQueryable<TrainingCourse> GetCoursesByType(string type) {
            var results = new List<TrainingCourse>();
            foreach (TrainingCourse tc in sampleData) {
                if (tc.Type == type) {
                    results.Add(tc);
                }
            }
            return results.AsQueryable<TrainingCourse>();
        }
        public IQueryable<TrainingCourse> GetCoursesContainingText(string text) {
            var results = new List<TrainingCourse>();
            foreach (TrainingCourse tc in sampleData) {
                if (tc.Title.Contains(text)) {
                    results.Add(tc);
                }
            }
            return results.AsQueryable<TrainingCourse>();
        }
        public void AddCourse(TrainingCourse tc) {
            sampleData.Add(tc);
            additions.Add(tc);
        }
        public void UpdateCourse(TrainingCourse tc) {
            updates.Add(tc);
        }
        public List<TrainingCourse> Additions {
            get {
                return additions;
            }
        }
        public List<TrainingCourse> Updates {
            get {
                return updates;
            }
        }
        private List<TrainingCourse> sampleData;
        private List<TrainingCourse> additions;
        private List<TrainingCourse> updates;
    }
}