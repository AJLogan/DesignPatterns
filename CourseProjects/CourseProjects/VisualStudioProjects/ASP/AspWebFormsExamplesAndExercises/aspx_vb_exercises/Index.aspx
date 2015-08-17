<%@ Page Language="VB" Theme="MyTheme"%>
<%@ Import Namespace="AspxExercises" %>
<script runat="server">
    Protected Sub Page_Load(ByVal obj As Object, ByVal args As EventArgs)
        If (Not IsPostBack) Then
            aspExerciseSolutions.DataSource = buildExerciseMaterials()
            DataBind()
        End If
    End Sub
    Private Function buildExerciseMaterials() As ArrayList
        Dim solutions As ArrayList = New ArrayList()
        solutions.Add(New CourseExercise("Times Tables", "Using the Basic ASP Syntax", "TimesTables.aspx", "TimesTablesSolution.aspx"))
        solutions.Add(New CourseExercise("Parameters", "Sorting Form Parameters", "FinancialResultsFormOne.html", "FinancialResultsFormTwo.html"))
        solutions.Add(New CourseExercise("Order Entry", "Processing an Order", "OrderEntry.html", "OrderEntrySolution.aspx"))
        solutions.Add(New CourseExercise("Calculator", "Building a Simple Calculator", "Calculator.aspx", "CalculatorSolution.aspx"))
        solutions.Add(New CourseExercise("Using the Grid View", "Displaying Data Via Objects", "TrainingCourses.aspx", "TrainingCoursesSolution.aspx"))
        solutions.Add(New CourseExercise("Enhancing the Grid View", "Adding Paging and Insertion", "TrainingCoursesTwo.aspx", "TrainingCoursesTwoSolution.aspx"))
        solutions.Add(New CourseExercise("Validation", "Adding Validation to Web Forms", "BookSearch.aspx", "BookSearchSolution.aspx"))
        Return solutions
    End Function
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
					<td><%#Eval("Title")%></td>
					<td><%#Eval("Description")%></td>
					<td>
						<a href="<%#Eval("ExerciseUrl")%>">#####</a>
					</td>
					<td>
						<a href="<%#Eval("SolutionUrl") %>">#####</a>
					</td>
				</tr>
			</ItemTemplate>
			<AlternatingItemTemplate>
				<tr class="even">
					<td><%#Eval("Title")%></td>
					<td><%#Eval("Description")%></td>
					<td>
						<a href="<%#Eval("ExerciseUrl")%>">#####</a>
					</td>
					<td>
						<a href="<%#Eval("SolutionUrl") %>">#####</a>
					</td>
				</tr>
			</AlternatingItemTemplate>
			<FooterTemplate>
				</table>
			</FooterTemplate>
		</asp:Repeater>
	</body>
</html>