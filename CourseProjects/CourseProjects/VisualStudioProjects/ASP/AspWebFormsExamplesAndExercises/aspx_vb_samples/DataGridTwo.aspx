<%@ Page Language="VB" AutoEventWireup="false" CodeFile="DataGridTwo.aspx.vb" Inherits="DataGridTwo" %>
<HTML>
	<HEAD>
		<title>DataGrid Demo</title>
	</HEAD>
	<body>
		<form runat="server" ID="Form1">
			<asp:DataGrid AutoGenerateColumns="false" id="coursesGrid" runat="server">
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
</HTML>
