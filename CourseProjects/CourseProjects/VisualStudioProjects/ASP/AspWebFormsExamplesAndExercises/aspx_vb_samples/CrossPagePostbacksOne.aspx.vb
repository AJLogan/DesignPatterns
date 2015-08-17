
Partial Class CrossPagePostbacksOne
    Inherits System.Web.UI.Page
    Public ReadOnly Property DriversPolicyNo() As String
        Get
            Return tbPolicyNo.Text
        End Get
    End Property
    Public ReadOnly Property OtherDriversInsurer() As String
        Get
            Return tbOtherDriversInsurer.Text
        End Get
    End Property
    Public ReadOnly Property OtherDriversPolicyNo() As String
        Get
            Return tbOtherDriversPolicyNo.Text
        End Get
    End Property
End Class
