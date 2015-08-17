<%@ Page Language="VB" AutoEventWireup="false" CodeFile="CrossPagePostbacksTwo.aspx.vb" Inherits="CrossPagePostbacksTwo" %>
<%@ PreviousPageType VirtualPath="~/CrossPagePostbacksOne.aspx" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>Accident Report Form Part Two</title>
</head>
<body>
    <h2>Accident Report Form Part Two</h2>
    <h3>Please confirm the following:</h3>
    <p>
        Your Policy No: <b><%= PreviousPage.DriversPolicyNo %></b>
    </p>
    <p>
        Insurer of Other Driver <b><%= PreviousPage.OtherDriversInsurer %></b>
    </p>
    <p>
        Other Drivers Policy No <b><%= PreviousPage.OtherDriversPolicyNo %></b>
    </p>
    <form id="form1" runat="server">
    <div>
        <p>
            <asp:Button ID="Button1" runat="server" Text="Confirm Claim Details" PostBackUrl="CrossPagePostbacksThree.aspx"/>
        </p>
    </div>
    </form>
</body>
</html>
