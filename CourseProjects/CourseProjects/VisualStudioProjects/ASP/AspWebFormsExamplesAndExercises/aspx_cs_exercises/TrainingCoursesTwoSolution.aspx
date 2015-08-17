<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TrainingCoursesTwoSolution.aspx.cs" Inherits="TrainingCoursesTwoSolution" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:ObjectDataSource ID="myObjectDataSource"
                              TypeName="AspxExercises.TrainingV2.TrainingCourse"
                              DataObjectTypeName="AspxExercises.TrainingV2.Delegate"
                              SelectMethod="GetDelegates"
                              StartRowIndexParameterName="startIndex"
                              MaximumRowsParameterName="maximum"
                              EnablePaging="true"
                              SelectCountMethod="GetDelegateCount"
                              InsertMethod="AddDelegate"
                              runat="server">
        </asp:ObjectDataSource>
    <div>
        <asp:GridView ID="GridView1" runat="server" BackColor="White" BorderColor="#E7E7FF"
                      BorderStyle="None" BorderWidth="1px" CellPadding="3" DataSourceID="myObjectDataSource"
                      GridLines="Horizontal" AutoGenerateColumns="false"
                      AllowPaging="True" PageSize="2">
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
        <h2>Insert a New Delegate Below...</h2>
        <asp:DetailsView ID="DetailsView1" DataKeyNames="Name"
                         DataSourceID="myObjectDataSource"
                         DefaultMode="Insert"
                         AutoGenerateRows="false"
                         runat="server">
            <Fields>
                <asp:BoundField  DataField="Name" HeaderText="Delegates Name" />
                <asp:BoundField  DataField="Company" HeaderText="Employeer" />
                <asp:BoundField  DataField="YearsExperience" HeaderText="Previous Experience" />
                <asp:BoundField  DataField="FeePaid" HeaderText="Course Fee" />
                <asp:CommandField ShowInsertButton="true" />
            </Fields>
        </asp:DetailsView>
    </div>
    </form>
</body>
</html>
