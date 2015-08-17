<%@ Page language="c#" %>
<script runat="server">
	public void Page_PreRender(Object sender, EventArgs e) {
		Validate();
		if(IsValid) {
			output.InnerText = "Page Has Validated";
		} else {
			output.InnerText = "Page Not Yet Validated";
		}
	}
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Validation</title>
	</head>
	<body>
		<h3 runat="server" id="output"/>
		<form runat="server">
			<p>
				Name (Mandatory)<br/>
				<asp:TextBox id="nameBox" runat="server"></asp:TextBox><br/>
				<asp:RequiredFieldValidator id="rv1" runat="server" ControlToValidate="nameBox" ErrorMessage="Name is mandatory"></asp:RequiredFieldValidator>
			</p>
			<p>
				Account Number (aaa-111-aa)<br/>
				<asp:TextBox id="accountNoBox" runat="server"></asp:TextBox><br/>
				<asp:RequiredFieldValidator id="rv2" runat="server" ControlToValidate="accountNoBox" ErrorMessage="Account Number is mandatory"></asp:RequiredFieldValidator><br/>
				<asp:RegularExpressionValidator id="rxv1" runat="server" ErrorMessage="Account number must follow pattern" ControlToValidate="accountNoBox"
				ValidationExpression="\w{3}-\d{3}-\w{2}" />
			</p>
			<p>
				Salary ( &gt; 20000)<br/>
				<asp:TextBox id="salaryBox" runat="server"></asp:TextBox><br/>
				<asp:RequiredFieldValidator id="rv3" runat="server" ControlToValidate="salaryBox" ErrorMessage="Salary is mandatory"></asp:RequiredFieldValidator><br/>
				<asp:CompareValidator id="cv1" runat="server" ControlToValidate="salaryBox" ErrorMessage="Salary must be greater than 2000"
				ValueToCompare="20000" Operator="GreaterThan" Type="Double"></asp:CompareValidator>
			</p>
			<p>
				Age (18 to 65)<br/>
				<asp:TextBox id="ageBox" runat="server"></asp:TextBox><br/>
				<asp:RequiredFieldValidator id="rv4" runat="server" ControlToValidate="ageBox" ErrorMessage="Age is mandatory"></asp:RequiredFieldValidator><br/>
				<asp:RangeValidator id="rav1" runat="server" ErrorMessage="Age must be 18 to 65" ControlToValidate="ageBox"
				MinimumValue="18" MaximumValue="65" Type="Integer" />
			</p>
			<p>
				<input type="submit" value="Submit"/>
			</p>
		</form>
	</body>
</html>
