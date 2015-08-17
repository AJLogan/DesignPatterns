<%@ WebHandler Language="C#" Class="DemoHandler" %>

using System;
using System.Web;

public class DemoHandler : IHttpHandler {
    
    public void ProcessRequest (HttpContext context) {
        HttpResponse response = context.Response;
        response.ContentType = "text/html";
        response.Write("<html>");
        response.Write("<head><title>A Custom Handler</title></head>");
        response.Write("<body>");
        response.Write("<h2>Thank you for visiting this Web App on:&nbsp;");
        response.Write(DateTime.Now.ToShortDateString());
        response.Write("&nbsp;at&nbsp;");
        response.Write(DateTime.Now.ToShortTimeString());
        response.Write("</h2>");
        response.Write("</body>");
        response.Write("</html>");
    }
 
    public bool IsReusable {
        get {
            return true;
        }
    }

}