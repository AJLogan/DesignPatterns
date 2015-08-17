Public Class Employee
    Public Property Name() As String
        Get
            Return _name
        End Get
        Set(ByVal value As String)
            _name = value
        End Set
    End Property
    Public Property Age() As Integer
        Get
            Return _age
        End Get
        Set(ByVal value As Integer)
            _age = value
        End Set
    End Property
    Public Property Salary() As Double
        Get
            Return _salary
        End Get
        Set(ByVal value As Double)
            _salary = value
        End Set
    End Property
    Public Overrides Function ToString() As String
        Return String.Format("{0} of age {1} earning {2}", _name, _age, _salary)
    End Function

    Dim _name As String
    Dim _age As Integer
    Dim _salary As Double
End Class
