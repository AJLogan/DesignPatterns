Public Class Student
    Public Sub New(ByVal name As String, ByVal subject As String, ByVal year As Integer, ByVal marks() As Double)
        _name = name
        _subject = subject
        _year = year
        _marks = marks
    End Sub
    Public Property Year() As Integer
        Get
            Return _year
        End Get
        Set(ByVal value As Integer)
            _year = value
        End Set
    End Property
    Public Function average() As Double
        Dim total As Double
        For Each mark As Double In _marks
            total += mark
        Next
        Return total / _marks.Length
    End Function
    Public Overrides Function ToString() As String
        Dim msg As String = "{0} studying {1} in year {2}"
        Return String.Format(msg, _name, _subject, _year)
    End Function
    Private _name As String
    Private _subject As String
    Private _year As Integer
    Private _marks() As Double
End Class
