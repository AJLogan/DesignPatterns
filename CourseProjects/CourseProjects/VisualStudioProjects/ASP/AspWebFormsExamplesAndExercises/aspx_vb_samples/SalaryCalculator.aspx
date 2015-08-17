<%@ Page Language="VB" Debug="true" %>
<script runat="server">
	Sub CalculateSalary(sender as object, e as EventArgs)
		try	
			'get the values seleced by the user
			' NB no need to muck about with session or request objects
            Dim gross As Double = Double.Parse(grossSalary.Text)
            Dim taxAmount As Integer = Int32.Parse(taxList.SelectedItem.Value)
						
			'change the text to be displayed		
			salaryInstructions.Text = "You entered the following salary"
			taxInstructions.Text = "You selected the following tax level"
							
			'display the net salary
            netSalary.Text = "Your net salary is: " + CStr(gross - ((gross * taxAmount) / 100))
			
        Catch ex As FormatException
            salaryInstructions.Text = "Please enter a salary level!"
        End Try
	End Sub
</script>
<html>
	<head>
		<title>ASP Dot NET Demo</title>
	</head>
	<!-- Build an HTML Form using the dot NET Web Controls -->
	<body>
		<form runat="server" style="border: solid black thin; background-color: cyan; margin-left: 5em; width: 20em;">
			<p style="margin-left:2em; margin-top: 1em;">
				<asp:Label ID="salaryInstructions" RunAt="Server" Text="Please enter your gross salary"/><br/>
				<asp:TextBox ID="grossSalary" RunAt="Server" Text="10000"/>
			</p>
			<p style="margin-left:2em;">
				<asp:Label ID="taxInstructions" RunAt="Server" Text="Please enter your tax rate"/><br/>
				<asp:RadioButtonList ID="taxList" RunAt="server">
					<asp:ListItem Value="20" Text="Basic Rate (20%)" Selected="true"/>
					<asp:ListItem Value="30" Text="Medium Rate (30%)"/>
					<asp:ListItem Value="40" Text="High Rate (40%)"/>
				</asp:RadioButtonList>
			</p>
			<p style="margin-left:2em;">
				<asp:Label ID="netSalary" RunAt="Server"/>	
			</p>
			<asp:Button Text="Calculate" OnClick="CalculateSalary" RunAt="Server" style="margin-bottom: 1em;"/>
		</form>
	</body>
</html>