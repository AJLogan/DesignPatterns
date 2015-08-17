<%@ Page Language="VB" AutoEventWireup="true" CodeFile="BookSearch.aspx.vb" Inherits="BookSearch" %>
<script runat="server">
    Public Sub Page_PreRender(ByVal sender As Object, ByVal e As EventArgs)
        Validate()
        If (IsValid) Then
            output.InnerText = "Page Has Validated"
        Else
            output.InnerText = "Page Not Yet Validated"
        End If
    End Sub
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <h1>Book Search Form</h1>
    <form id="form1" runat="server">
    <div>
        <h3>Title (Mandatory)</h3>
        <asp:TextBox ID="BookTitle" runat="server"/><br />
        <h3>Author (Mandatory)</h3>
        <asp:TextBox ID="BookAuthor" runat="server"/><br />
        <h3>ISBN (Mandatory, 5 groups of 1-5 digits separated by hashes)</h3>
        <asp:TextBox ID="BookISBN" runat="server"/><br />
        <h3>Edition (Mandatory, between 1 and 10)</h3>
        <asp:TextBox ID="TextBox1" runat="server"/><br />
        <asp:Button ID="SubmitButton" runat="server" Text="Submit" />
    </div>
    </form>
    <h2 runat="server" id="output"/>
</body>
</html>
