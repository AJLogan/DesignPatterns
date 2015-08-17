Public Class SalesPerson
    Inherits Employee

    'Class constructors
    Public Sub New(ByVal id As String, ByVal name As String, ByVal age As Integer, ByVal salary As Double, ByVal target As Integer)
        MyBase.New(id, name, age, salary)
        Me.target = target
    End Sub

    'Show polymorphism
    Public Overrides Sub awardBonus(ByVal bonus As Double)
        salary = salary + (bonus * 2)
    End Sub

    'Override ToString
    Public Overrides Function ToString() As String
        ToString = MyBase.ToString + " with a target of " + CStr(target) + vbNewLine
    End Function

    'Fields of Class
    Private target As Double
End Class
