﻿<%@ Page Language="VB" AutoEventWireup="false" CodeFile="GridViewThree.aspx.vb" Inherits="GridViewThree" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1" runat="server">
        <title></title>
    </head>
    <body>
        <h1>Demo of GridView with Custom Paging</h1>
        <form id="form1" runat="server">
        <div>
            <asp:ObjectDataSource ID="myObjectDataSource"
                                  TypeName="VisualBasicWebApp.CompanyTwo"
                                  DataObjectTypeName="VisualBasicWebApp.Employee"
                                  EnablePaging="true"
                                  SelectMethod="GetEmployees"
                                  StartRowIndexParameterName="startIndex"
                                  MaximumRowsParameterName="maximum"
                                  SelectCountMethod="GetEmployeeCount"
                                  runat="server">
            </asp:ObjectDataSource>
        
        </div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false" 
                          BackColor="White" BorderColor="#3366CC"
                          BorderStyle="None" BorderWidth="1px" 
                          CellPadding="4" DataSourceID="myObjectDataSource"
                          AllowPaging="true" PageSize="3">
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
        </form>
    </body>
</html>
