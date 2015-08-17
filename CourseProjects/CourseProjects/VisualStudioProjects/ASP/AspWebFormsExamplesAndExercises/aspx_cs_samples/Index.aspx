<%@ Page Language="C#" Theme="MyTheme"%>
<%@ Import Namespace="aspxsamples" %>
<script runat="server">
	protected void Page_Load(object obj, EventArgs args) {
		if(!IsPostBack) {
			infrastructure.DataSource = buildStandardExamples();
			controls.DataSource = buildControlsExamples();
            dataBinding.DataSource = buildDataBindingExamples();
			DataBind();
		}
	}
	private static ArrayList buildStandardExamples() {
		ArrayList examples = new ArrayList();
        examples.Add(new CourseExample("Custom Handlers", "Writing Your Own HTTP Handler", "DemoHandler.ashx"));
		examples.Add(new CourseExample("Hello World","A very simple page","HelloWorld.aspx"));
		examples.Add(new CourseExample("Configuration","Reading config values from 'web.config'","ConfigValues.aspx"));
		examples.Add(new CourseExample("Requests","Investigating the HTTP Request","RequestDetails.aspx"));
		examples.Add(new CourseExample("GET Parameters","Reading parameters from the URL","UrlParameters.aspx?aaa=111&bbb=222&ccc=333"));
		examples.Add(new CourseExample("POST Parameters","Reading parameters from a form","SimpleForm.html"));
		examples.Add(new CourseExample("Page Events I","Handling events using autowiring","PageEvents.aspx"));
		examples.Add(new CourseExample("Page Events II","Handling events using polymorphism","PageEventsTwo.aspx"));
		examples.Add(new CourseExample("Page Events III","Handling events using delegates","PageEventsThree.aspx"));
		examples.Add(new CourseExample("Session State","Storing information in the session","SessionState.aspx"));
		examples.Add(new CourseExample("Application State","Storing information in the application","ApplicationState.aspx"));
		examples.Add(new CourseExample("Exceptions","Specifying an exception handling page","ThrowError.aspx?Throw=Yes"));
		examples.Add(new CourseExample("Tracing","Displaying the page trace","TracingEvents.aspx"));
		examples.Add(new CourseExample("Restricting Pages","Using form based authentication","Secured.aspx"));
		return examples;
	}
	private static ArrayList buildControlsExamples() {
		ArrayList controls = new ArrayList();
        controls.Add(new CourseExample("Control Properties", "Changing the text and CSS of a control", "ControlProperties.aspx"));
		controls.Add(new CourseExample("Basic Controls","A simple salary calculator","SalaryCalculator.aspx"));
		controls.Add(new CourseExample("Controls and View State","Examining how controls manage their data","DecodingViewState.aspx"));
		controls.Add(new CourseExample("Validation","Using the validation controls","Validation.aspx"));
		controls.Add(new CourseExample("Custom Controls I","Creating a control with data binding","CustomControls.aspx"));
		controls.Add(new CourseExample("Custom Controls II","Adding state management to the control","CustomControlsTwo.aspx"));
        controls.Add(new CourseExample("Master Pages (ASP 2.0)", "Using Master Pages to reuse a layout", "MasterPagesDemo.aspx"));
        controls.Add(new CourseExample("Cross-Page Postbacks (ASP 2.0)", "Submitting to a different Web Form", "CrossPagePostbacksOne.aspx"));
		return controls;
	}
    private static ArrayList buildDataBindingExamples() {
        ArrayList controls = new ArrayList();
        controls.Add(new CourseExample("Basic DataGrid (ASP 1)", "The DataGrid Control", "DataGridOne.aspx"));
        controls.Add(new CourseExample("Naming Columns (ASP 1)", "Specifying the names of DataGrid columns", "DataGridTwo.aspx"));
        controls.Add(new CourseExample("Adding Styling (ASP 1)", "Adding styling to a DataGrid", "DataGridThree.aspx"));
        controls.Add(new CourseExample("Basic GridView (ASP 2)", "Using a GridView with an ObjectDataSource", "GridViewOne.aspx"));
        controls.Add(new CourseExample("Adding Paging (ASP 2)", "Adding paging to the GridView", "GridViewTwo.aspx"));
        controls.Add(new CourseExample("Custom Paging (ASP 2)", "Implementing paging efficiently", "GridViewThree.aspx"));
        controls.Add(new CourseExample("Altering Data (ASP 2)", "Updating and deleting data", "GridViewFour.aspx"));
        controls.Add(new CourseExample("Inserting Rows (ASP 2)", "Adding new records via a DetailsView", "GridViewFive.aspx"));
        controls.Add(new CourseExample("GridView and SQL Server (ASP 2)", "The GridView Demo with a SqlDataSource", "GridViewSix.aspx"));
        controls.Add(new CourseExample("GridView and LINQ (ASP 2)", "The GridView Demo with a LinqDataSource", "GridViewSeven.aspx"));
        return controls;
    }
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head runat="server">
		<title>ASP .NET Demos Index Page</title>
	</head>
	<body>
		<asp:Repeater Runat="server" ID="infrastructure">
			<HeaderTemplate>
				<table width="80%">
					<tr>
						<td class="title" colspan="3">The ASP .NET Infrastructure</td>
					</tr>
					<tr class="headers">
						<td>Name</td><td>Description</td>
					</tr>
			</HeaderTemplate>
			<ItemTemplate>
				<tr>
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</ItemTemplate>
			<AlternatingItemTemplate>
				<tr class="even">
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</AlternatingItemTemplate>
			<FooterTemplate>
				</table>
			</FooterTemplate>
		</asp:Repeater>
		
		<asp:Repeater Runat="server" ID="controls">
			<HeaderTemplate>
				<table width="80%">
					<tr>
						<td class="title" colspan="3">Using Controls</td>
					</tr>
					<tr class="headers">
						<td>Name</td><td>Description</td>
					</tr>
			</HeaderTemplate>
			<ItemTemplate>
				<tr>
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</ItemTemplate>
			<AlternatingItemTemplate>
				<tr class="even">
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</AlternatingItemTemplate>
			<FooterTemplate>
				</table>
			</FooterTemplate>
		</asp:Repeater>
		
		<asp:Repeater Runat="server" ID="dataBinding">
			<HeaderTemplate>
				<table width="80%">
					<tr>
						<td class="title" colspan="3">Data Binding</td>
					</tr>
					<tr class="headers">
						<td>Name</td><td>Description</td>
					</tr>
			</HeaderTemplate>
			<ItemTemplate>
				<tr>
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</ItemTemplate>
			<AlternatingItemTemplate>
				<tr class="even">
					<td><%# Eval("Title") %></td>
					<td>
						<a href="<%# Eval("Url") %>">
							<%# Eval("Description") %>
						</a>
					</td>
				</tr>
			</AlternatingItemTemplate>
			<FooterTemplate>
				</table>
			</FooterTemplate>
		</asp:Repeater>
	</body>
</html>