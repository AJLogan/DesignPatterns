using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CourseBookingStandaloneCS.Models;

namespace CourseBookingStandaloneCS.DataAccess {
    public interface ITrainingCourseDAO {
        void AddCourse(TrainingCourse tc);
        void UpdateCourse(TrainingCourse tc);
        TrainingCourse GetCourseByNumber(string number);
        TrainingCourse GetCourseByTitle(string title);
        IQueryable<TrainingCourse> GetAllCourses();
        IQueryable<TrainingCourse> GetCoursesByType(string type);
        IQueryable<TrainingCourse> GetCoursesContainingText(string text);
    }
}
