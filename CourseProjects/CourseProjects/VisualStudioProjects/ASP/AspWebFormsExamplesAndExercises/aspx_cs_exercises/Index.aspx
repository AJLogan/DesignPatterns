<%@ Page Language="C#" Theme="MyTheme"%>
<%@ Import Namespace="AspxExercises" %>
<script runat="server">
	protected void Page_Load(object obj, EventArgs args) {
		if(!IsPostBack) {
			aspExerciseSolutions.DataSource = buildExerciseMaterials();
			DataBind();
		}
	}
	private static ArrayList buildExerciseMaterials() {
		ArrayList solutions = new ArrayList();
        solutions.Add(new CourseExercise("Times Tables", "Using the Basic ASP Syntax", "TimesTables.aspx", "TimesTablesSolution.aspx"));
        solutions.Add(new CourseExercise("Parameters", "Sorting Form Parameters", "FinancialResultsFormOne.html", "FinancialResultsFormTwo.html"));
        solutions.Add(new CourseExercise("Order Entry", "Processing an Order", "OrderEntry.html", "OrderEntrySolution.aspx"));
        solutions.Add(new CourseExercise("Calculator", "Building a Simple Calculator", "Calculator.aspx", "CalculatorSolution.aspx"));
        solutions.Add(new CourseExercise("Using the Grid View", "Displaying Data Via Objects", "TrainingCourses.aspx", "TrainingCoursesSolution.aspx"));
        solutions.Add(new CourseExercise("Enhancing the Grid View", "Adding Paging and Insertion", "TrainingCoursesTwo.aspx", "TrainingCoursesTwoSolution.aspx"));
        solutions.Add(new CourseExercise("Validation", "Adding Validation to Web Forms", "BookSearch.aspx", "BookSearchSolution.aspx"));
		return solutions;
	}
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head runat="server">
		<title>ASP .NET Examples Index Page</title>
	</head>
	<body>
		<asp:Repeater Runat="server" ID="aspExerciseSolutions">
			<HeaderTemplate>
				<table width="80%">
					<tr>
						<td class="title" colspan="4">Resources And Solutions For Exercises</td>
					</tr>
					<tr class="headers">
						<td>Name</td><td>Description</td><td>Exercise</td><td>Solution</td>
					</tr>
			</HeaderTemplate>
			<ItemTemplate>
				<tr>
					<td><%#((CourseExercise)(Container.DataItem)).Title %></td>
					<td><%#((CourseExercise)(Container.DataItem)).Description %></td>
					<td>
						<a href="<%#((CourseExercise)(Container.DataItem)).ExerciseUrl %>">#####</a>
					</td>
					<td>
						<a href="<%#((CourseExercise)(Container.DataItem)).SolutionUrl %>">#####</a>
					</td>
				</tr>
			</ItemTemplate>
			<AlternatingItemTemplate>
				<tr class="even">
					<td><%#((CourseExercise)(Container.DataItem)).Title %></td>
					<td><%#((CourseExercise)(Container.DataItem)).Description %></td>
					<td>
						<a href="<%#((CourseExercise)(Container.DataItem)).ExerciseUrl %>">#####</a>
					</td>
					<td>
						<a href="<%#((CourseExercise)(Container.DataItem)).SolutionUrl %>">#####</a>
					</td>
				</tr>
			</AlternatingItemTemplate>
			<FooterTemplate>
				</table>
			</FooterTemplate>
		</asp:Repeater>
	</body>
</html>