Public Class Employee
    Public Sub New()
    End Sub
    Public Sub New(ByVal name As String, ByVal dept As String, ByVal age As Integer, ByVal salary As Double)
        _name = name
        _dept = dept
        _age = age
        _salary = salary
    End Sub
    Public Property Name() As String
        Get
            Return _name
        End Get
        Set(ByVal value As String)
            _name = value
        End Set
    End Property
    Public Property Dept() As String
        Get
            Return _dept
        End Get
        Set(ByVal value As String)
            _dept = value
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
        Return String.Format("{0} working in {1} of age {2} earing {3}", Name, Dept, Age, Salary)
    End Function

    Dim _name As String
    Dim _dept As String
    Dim _age As Integer
    Dim _salary As Double
End Class
