Public Class RomanNumeral
    Public Sub New(ByVal dv As Integer, ByVal sv As String)
        _decimalValue = dv
        _stringValue = sv
    End Sub
    Public Property StringValue() As String
        Get
            Return _stringValue
        End Get
        Set(ByVal value As String)
            _stringValue = value
        End Set
    End Property
    Public Property DecimalValue() As Integer
        Get
            Return _decimalValue
        End Get
        Set(ByVal value As Integer)
            _decimalValue = value
        End Set
    End Property
    Private _decimalValue As Integer
    Private _stringValue As String
End Class
