<%@ WebHandler Class="DemoHandler" %>

Imports System
Imports System.Web

public class DemoHandler 
    Implements IHttpHandler
    
    Public Sub ProcessRequest(ByVal context As HttpContext) Implements IHttpHandler.ProcessRequest
        Dim response As HttpResponse = context.Response
        response.ContentType = "text/html"
        response.Write("<html>")
        response.Write("<head><title>A Custom Handler</title></head>")
        response.Write("<body>")
        response.Write("<h2>Thank you for visiting this Web App on:&nbsp;")
        response.Write(DateTime.Now.ToShortDateString())
        response.Write("&nbsp;at&nbsp;")
        response.Write(DateTime.Now.ToShortTimeString())
        response.Write("</h2>")
        response.Write("</body>")
        response.Write("</html>")
    End Sub
 
    Public ReadOnly Property IsReusable() As Boolean Implements IHttpHandler.IsReusable
        Get
            Return True
        End Get
    End Property
end class