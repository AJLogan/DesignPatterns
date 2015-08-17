Imports System.Text

Public Class Employee
    'Class constructors
    Public Sub New(ByVal id As String, ByVal name As String, ByVal age As Integer, ByVal salary As Double)
        Me.New(id, name, age)
        Me.salary = salary
    End Sub
    Public Sub New(ByVal id As String, ByVal name As String, ByVal age As Integer)
        Me.New(id, name)
        Me.age = age
    End Sub
    Public Sub New(ByVal id As String, ByVal name As String)
        Me.id = id
        Me.name = name
    End Sub

    'Show polymorphism
    Public Overridable Sub awardBonus(ByVal bonus As Double)
        salary = salary + bonus
    End Sub

    'Show overloading
    Public Overloads Sub markOnHoliday()
        onHoliday = True
    End Sub

    Public Overloads Sub markOnHoliday(ByVal days As Integer)
        markOnHoliday()
        holidaysTaken += days
    End Sub

    'Override ToString from Object
    Public Overrides Function ToString() As String
        Dim sb As StringBuilder = New StringBuilder()
        sb.Append(id)
        sb.Append(" called ")
        sb.Append(name)
        sb.Append(" aged ")
        sb.Append(age)
        sb.Append(" earning ")
        sb.Append(salary)

        ToString = sb.ToString()
    End Function

    'Fields of the class
    Protected name, id As String
    Protected age As Integer
    Protected salary As Double
    Protected onHoliday As Boolean
    Protected holidaysTaken As Integer


End Class
