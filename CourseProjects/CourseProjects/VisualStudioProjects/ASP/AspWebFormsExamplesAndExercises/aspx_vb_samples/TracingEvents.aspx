<%@ Page Language="VB" Trace="true" %>
<script runat="server">
    Protected Overrides Sub OnInit(ByVal e As EventArgs)
        If (IsPostBack) Then
            Trace.Write("MyCategory", Request.Form("msgText") + " from OnInit")
            Trace.Warn("MyCategory", Request.Form("msgText") + " from OnInit")
        End If
    End Sub
    Protected Overrides Sub OnLoad(ByVal e As EventArgs)
        If (IsPostBack) Then
            If (Request.Form("ordering").Equals("byCategory")) Then
                Trace.TraceMode = TraceMode.SortByCategory
            Else
                Trace.TraceMode = TraceMode.SortByTime
            End If
            Trace.Write("MyCategory", Request.Form("msgText") + " from OnLoad")
            Trace.Warn("MyCategory", Request.Form("msgText") + " from OnLoad")
        End If
    End Sub
    Protected Overrides Sub OnPreRender(ByVal e As EventArgs)
        If (IsPostBack) Then
            Trace.Write("MyCategory", Request.Form("msgText") + " from OnPreRender")
            Trace.Warn("MyCategory", Request.Form("msgText") + " from OnPreRender")
        End If
    End Sub
    Protected Overrides Sub OnUnload(ByVal e As EventArgs)
        'Cannot use trace here
    End Sub
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