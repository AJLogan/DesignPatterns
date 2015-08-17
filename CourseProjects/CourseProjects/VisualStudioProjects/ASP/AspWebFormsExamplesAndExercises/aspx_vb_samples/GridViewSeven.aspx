﻿<%@ Page Language="VB" AutoEventWireup="false" CodeFile="GridViewSeven.aspx.vb" Inherits="GridViewSeven" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
         <asp:LinqDataSource ID="myLinqDataSource" ContextTypeName="VisualBasicWebApp.CompanyFour"
                             TableName="Staff" Where="Department == @Dept" runat="server">
            <WhereParameters>
                <asp:ControlParameter ControlID="DropDown1" Type="String"
                                      Name="Dept" PropertyName="SelectedValue" />
            </WhereParameters>                   
         </asp:LinqDataSource>
         <asp:LinqDataSource ID="myLinqDataSourceTwo" ContextTypeName="VisualBasicWebApp.CompanyFour"
                             TableName="Departments" runat="server" />
         <h2>Choose the department you wish to view</h2>
         <asp:DropDownList ID="DropDown1" AutoPostBack="true" 
                           DataSourceID="myLinqDataSourceTwo" runat="server" />                    
         <hr />
         <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false" 
                      BackColor="White" BorderColor="#3366CC"
                      BorderStyle="None" BorderWidth="1px" 
                      CellPadding="4" DataSourceID="myLinqDataSource"
                      AllowPaging="true" PageSize="3"
                      AutoGenerateEditButton="true" 
                      AutoGenerateDeleteButton="true"
                      DataKeyNames="ID">
            <FooterStyle BackColor="#99CCCC" ForeColor="#003399" />
            <RowStyle BackColor="White" ForeColor="#003399" />
            <PagerStyle BackColor="#99CCCC" ForeColor="#003399" HorizontalAlign="Left" />
            <SelectedRowStyle BackColor="#009999" Font-Bold="True" ForeColor="#CCFF99" />
            <HeaderStyle BackColor="#003399" Font-Bold="True" ForeColor="#CCCCFF" />
            <Columns>
                <asp:BoundField  DataField="ID" ReadOnly="true" HeaderText="Employees ID" />
                <asp:BoundField  DataField="Name" HeaderText="Employees Name" />
                <asp:BoundField  DataField="Department" HeaderText="Employees Department" />
                <asp:BoundField  DataField="Salary" HeaderText="Employees Salary" />
            </Columns>
        </asp:GridView>
    </div>
    </form>
</body>
</html>

