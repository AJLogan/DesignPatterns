<%@ Page Language="C#" AutoEventWireup="true" CodeFile="BookSearchSolution.aspx.cs" Inherits="BookSearchSolution" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Book Search Solution</title>
</head>
<body>
    <h1>Book Search Form</h1>
    <form id="form1" runat="server">
    <div>
        <h3>Title (Mandatory)</h3>
        <asp:TextBox ID="BookTitle" runat="server"/><br />
        <asp:RequiredFieldValidator id="rv1" runat="server" ControlToValidate="BookTitle" ErrorMessage="Title is mandatory"></asp:RequiredFieldValidator>
        <h3>Author (Mandatory)</h3>
        <asp:TextBox ID="BookAuthor" runat="server"/><br />
        <asp:RequiredFieldValidator id="rv2" runat="server" ControlToValidate="BookAuthor" ErrorMessage="Author is mandatory"></asp:RequiredFieldValidator>
        <h3>ISBN (Mandatory, 5 groups of 1-5 digits separated by hashes)</h3>
        <asp:TextBox ID="BookISBN" runat="server"/><br />
        <asp:RequiredFieldValidator id="rv3" runat="server" ControlToValidate="BookISBN" ErrorMessage="ISBN is mandatory"></asp:RequiredFieldValidator>
        <asp:RegularExpressionValidator ValidationExpression="[0-9]{1,5}-[0-9]{1,5}-[0-9]{1,5}-[0-9]{1,5}-[0-9]{1,5}" ControlToValidate="BookISBN" ID="rv4" runat="server" ErrorMessage="ISBN in wrong format"></asp:RegularExpressionValidator>
        <h3>Edition (Mandatory, between 1 and 10)</h3>
        <asp:TextBox ID="BookEditon" runat="server"/><br />
        <asp:RequiredFieldValidator id="rv5" runat="server" ControlToValidate="BookEditon" ErrorMessage="Edition is mandatory"></asp:RequiredFieldValidator>
        <asp:RangeValidator ID="rv6" MinimumValue="1" MaximumValue="10" Type="Integer" runat="server" ControlToValidate="BookEditon" ErrorMessage="Edition must be in range 1-10"></asp:RangeValidator>
        <p>
            <asp:Button ID="SubmitButton" runat="server" Text="Submit" />
        </p>
    </div>
    </form>
    <h2 runat="server" id="output"/>
</body>
</html>
