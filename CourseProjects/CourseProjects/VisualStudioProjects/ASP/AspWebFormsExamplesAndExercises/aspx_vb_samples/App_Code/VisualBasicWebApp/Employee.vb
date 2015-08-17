Imports Microsoft.VisualBasic
Namespace VisualBasicWebApp
    Public Class Employee
        Private _id As String
        Private _department As String
        Private _name As String
        Private _salary As Double
        Public Sub New()
        End Sub
        Public Sub New(ByVal id As String, ByVal name As String, ByVal department As String, ByVal salary As Double)
            _id = id
            _name = name
            _department = department
            _salary = salary
        End Sub
        Public Property ID() As String
            Get
                Return _id
            End Get
            Set(ByVal value As String)
                _id = value
            End Set
        End Property
        Public Property Name() As String
            Get
                Return _name
            End Get
            Set(ByVal value As String)
                _name = value
            End Set
        End Property
        Public Property Department() As String
            Get
                Return _department
            End Get
            Set(ByVal value As String)
                _department = value
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
    End Class
End Namespace

