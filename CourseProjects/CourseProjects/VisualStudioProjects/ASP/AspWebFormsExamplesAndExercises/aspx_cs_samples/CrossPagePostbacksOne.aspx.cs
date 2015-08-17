using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class CrossPagePostbacksOne : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    public string DriversPolicyNo {
        get { return tbPolicyNo.Text; }
    }
    public string OtherDriversInsurer {
        get { return tbOtherDriversInsurer.Text; }
    }
    public string OtherDriversPolicyNo {
        get { return tbOtherDriversPolicyNo.Text; }
    }
}
