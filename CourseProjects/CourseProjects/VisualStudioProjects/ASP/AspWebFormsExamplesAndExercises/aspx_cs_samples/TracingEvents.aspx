<%@ Page Language="C#" Trace="true" %>
<script runat="server">
	protected override void OnInit(EventArgs e) {
		if(IsPostBack) {
			Trace.Write("MyCategory",Request.Form["msgText"] + " from OnInit");
			Trace.Warn("MyCategory",Request.Form["msgText"] + " from OnInit");
		}
	}
	protected override void OnLoad(EventArgs e) {
		if(IsPostBack) {
			if(Request.Form["ordering"].Equals("byCategory")) {
				Trace.TraceMode = TraceMode.SortByCategory;
			} else {
				Trace.TraceMode = TraceMode.SortByTime;
			}
			Trace.Write("MyCategory",Request.Form["msgText"] + " from OnLoad");
			Trace.Warn("MyCategory",Request.Form["msgText"] + " from OnLoad");
		}
	}
	protected override void OnPreRender(EventArgs e) {
		if(IsPostBack) {
			Trace.Write("MyCategory",Request.Form["msgText"] + " from OnPreRender");
			Trace.Warn("MyCategory",Request.Form["msgText"] + " from OnPreRender");
		}
	}
	protected override void OnUnload(EventArgs e) {
		//Cannot use trace here
	}	
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Tracing and ASPX Events</title>
	</head>
	<body>
		<h3>This is the normal body of the page</h3>
		<form runat="server">
			<p>
				Enter a message to display in tracing:<br/>
				<input type="text" name="msgText" value="Default Msg"/>
			</p>
			<p>
				Choose how you would like trace messages ordered: <br/>
				By time: <input type="radio" name="ordering" value="byTime" checked/>
				By group: <input type="radio" name="ordering" value="byCategory"/>
			</p>
			<p>
				<input type="submit" value="Submit"/>
			</p>
		</form>
		<h3>Tracing information will be added below:</h3>
		<hr/>
	</body>
</html>