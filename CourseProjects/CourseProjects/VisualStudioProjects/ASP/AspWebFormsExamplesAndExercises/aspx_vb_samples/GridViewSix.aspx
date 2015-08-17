<%@ Page Language="VB" AutoEventWireup="false" CodeFile="GridViewSix.aspx.vb" Inherits="GridViewSix" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1" runat="server">
        <title></title>
    </head>
    <body>
        <h1>Using the GridView with SQL Server</h1>
        <form id="form1" runat="server">
        <div>
            
        
            <asp:SqlDataSource ID="mySqlDataSource" runat="server" 
                ConnectionString="<%$ ConnectionStrings:CoursesDBConnectionString %>" 
                SelectCommand="SELECT [CourseNum], [CourseTitle], [CourseType] FROM [Courses]"
                InsertCommand="INSERT INTO Courses ([CourseNum], [CourseTitle], [CourseType]) VALUES (@CourseNum, @CourseTitle, @CourseType)"
                UpdateCommand="UPDATE [Courses] SET [CourseNum] = @CourseNum, [CourseTitle] = @CourseTitle WHERE [CourseNum] = @CourseNum">
            </asp:SqlDataSource>
            
        
        </div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false" 
                          BackColor="White" BorderColor="#3366CC"
                          BorderStyle="None" BorderWidth="1px" 
                          CellPadding="4" DataSourceID="mySqlDataSource"
                          AllowPaging="true" PageSize="3"
                          AutoGenerateEditButton="true" 
                          DataKeyNames="CourseNum">
                <FooterStyle BackColor="#99CCCC" ForeColor="#003399" />
                <RowStyle BackColor="White" ForeColor="#003399" />
                <PagerStyle BackColor="#99CCCC" ForeColor="#003399" HorizontalAlign="Left" />
                <SelectedRowStyle BackColor="#009999" Font-Bold="True" ForeColor="#CCFF99" />
                <HeaderStyle BackColor="#003399" Font-Bold="True" ForeColor="#CCCCFF" />
                <Columns>
                    <asp:BoundField  DataField="CourseNum" ReadOnly="true" HeaderText="Unique Course Number" />
                    <asp:BoundField  DataField="CourseTitle" HeaderText="Title of Course" />
                    <asp:BoundField  DataField="CourseType" HeaderText="Type of Course" />
                </Columns>
            </asp:GridView>
            <h2>Insert a New Course Below...</h2>
            <asp:DetailsView ID="DetailsView1" DataKeyNames="CourseNum"
                             DataSourceID="mySqlDataSource"
                             DefaultMode="Insert"
                             AutoGenerateRows="false"
                             runat="server">
                <Fields>
                    <asp:BoundField  DataField="CourseNum" ReadOnly="true" HeaderText="Unique Course Number" />
                    <asp:BoundField  DataField="CourseTitle" HeaderText="Title of Course" />
                    <asp:BoundField  DataField="CourseType" HeaderText="Type of Course" />
                    <asp:CommandField ShowInsertButton="true" />
                </Fields>
            </asp:DetailsView>
        </form>
    </body>
</html>
