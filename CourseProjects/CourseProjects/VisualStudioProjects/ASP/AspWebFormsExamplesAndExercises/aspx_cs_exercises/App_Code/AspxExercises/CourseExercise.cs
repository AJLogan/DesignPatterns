using System;

namespace AspxExercises {
	public class CourseExercise {
        private readonly string title;
        private readonly string description;
		private readonly string exerciseUrl;
        private readonly string solutionUrl;

	    public CourseExercise(string title, string description, string exerciseUrl, string solutionUrl) {
	        this.title = title;
	        this.description = description;
	        this.exerciseUrl = exerciseUrl;
	        this.solutionUrl = solutionUrl;
	    }
	    public string Title {
	        get { return title; }
	    }
	    public string Description {
	        get { return description; }
	    }
	    public string ExerciseUrl {
	        get { return exerciseUrl; }
	    }
	    public string SolutionUrl {
	        get { return solutionUrl; }
	    }
	}
}