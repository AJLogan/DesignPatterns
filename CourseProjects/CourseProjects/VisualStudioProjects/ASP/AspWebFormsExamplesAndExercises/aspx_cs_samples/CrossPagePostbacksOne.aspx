<%@ Page Language="C#" AutoEventWireup="true" CodeFile="CrossPagePostbacksOne.aspx.cs" Inherits="CrossPagePostbacksOne" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Accident Report Form Part One</title>
</head>
<body>
    <h2>Accident Report Form Part One</h2>
    <form id="form1" runat="server">
    <div>
        <p>
            <asp:Label ID="Label1" runat="server" Text="Your Policy No" Width="192px"></asp:Label>
            <asp:TextBox ID="tbPolicyNo" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Label ID="Label2" runat="server" Text="Insurer of Other Driver" Width="192px"></asp:Label>
            <asp:TextBox ID="tbOtherDriversInsurer" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Label ID="Label3" runat="server" Text="Other Drivers Policy No" Width="192px"></asp:Label>
            <asp:TextBox ID="tbOtherDriversPolicyNo" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="btSubmit" runat="server" Text="Submit Claim Details" PostBackUrl="CrossPagePostbacksTwo.aspx"/>
        </p>
    </div>
    </form>
</body>
</html>
