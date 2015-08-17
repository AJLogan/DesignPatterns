<%@ Page Language="VB" AutoEventWireup="false" CodeFile="TrainingCoursesSolution.aspx.vb" Inherits="TrainingCoursesSolution" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:ObjectDataSource ID="myObjectDataSource"
                              TypeName="TrainingV1.TrainingCourse"
                              DataObjectTypeName="TrainingV1.Delegate"
                              SelectMethod="GetDelegates"
                              runat="server">
        </asp:ObjectDataSource>
        <div>
            <asp:GridView ID="GridView1" runat="server" BackColor="White" BorderColor="#E7E7FF"
                BorderStyle="None" BorderWidth="1px" CellPadding="3" DataSourceID="myObjectDataSource"
                GridLines="Horizontal" AutoGenerateColumns="false">
                <FooterStyle BackColor="#B5C7DE" ForeColor="#4A3C8C" />
                <RowStyle BackColor="#E7E7FF" ForeColor="#4A3C8C" />
                <PagerStyle BackColor="#E7E7FF" ForeColor="#4A3C8C" HorizontalAlign="Right" />
                <SelectedRowStyle BackColor="#738A9C" Font-Bold="True" ForeColor="#F7F7F7" />
                <HeaderStyle BackColor="#4A3C8C" Font-Bold="True" ForeColor="#F7F7F7" />
                <AlternatingRowStyle BackColor="#F7F7F7" />
                <Columns>
                    <asp:BoundField  DataField="Name" HeaderText="Delegates Name" />
                    <asp:BoundField  DataField="Company" HeaderText="Employeer" />
                    <asp:BoundField  DataField="YearsExperience" HeaderText="Previous Experience" />
                    <asp:BoundField  DataField="FeePaid" HeaderText="Course Fee" />
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>
