<%@ Page Language="VB" AutoEventWireup="false" CodeFile="DataGridThree.aspx.vb" Inherits="DataGridThree" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>DataGrid Demo</title>
	</head>
	<body>
		<form runat="server" ID="Form1">
			<asp:DataGrid BorderColor="Black" AutoGenerateColumns="false" id="coursesGrid" runat="server">
				<HeaderStyle BackColor="Navy" ForeColor="White" Font-Size="14pt" HorizontalAlign="Center"/>
				<ItemStyle Font-Size="12pt" />
				<AlternatingItemStyle Font-Size="12pt" BackColor="LightBlue"/>
				<Columns>
					<asp:BoundColumn DataField="CourseNum" HeaderText="Catalog Code"/>
					<asp:BoundColumn DataField="CourseTitle" HeaderText="Full Title Of Course"/>
					<asp:BoundColumn DataField="CourseType" HeaderText="Experience Required"/>
					<asp:BoundColumn DataField="StartDate" HeaderText="Start Of Next Delivery"/>
					<asp:BoundColumn DataField="EndDate" HeaderText="End Of Next Delivery"/>
				</Columns>
			</asp:DataGrid>
		</form>
	</body>
</head>
