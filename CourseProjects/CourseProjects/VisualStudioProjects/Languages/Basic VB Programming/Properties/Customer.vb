Imports System.Text

Public Class Customer
    Public Sub New(ByVal name As String)
        _name = name
    End Sub
    Public Property Address() As String
        Get
            Return _address
        End Get
        Set(ByVal Value As String)
            _address = Value
        End Set
    End Property
    Public ReadOnly Property Name() As String
        Get
            Return _name
        End Get
    End Property
    Public WriteOnly Property CreditLimit() As Double
        Set(ByVal Value As Double)
            _creditLimit = Value
        End Set
    End Property
    Public Overrides Function toString() As String
        Dim sb As New StringBuilder
        sb.Append("Customer called ")
        sb.Append(_name)
        sb.Append(" at address ")
        sb.Append(_address)
        sb.Append(" with credit limit ")
        sb.Append(_creditLimit)
        Return sb.ToString()
    End Function
    Private _name As String
    Private _address As String
    Private _creditLimit As Double
End Class
