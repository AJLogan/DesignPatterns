Imports Microsoft.VisualBasic

Public Class CourseExercise
    Private ReadOnly _title As String
    Private ReadOnly _description As String
    Private ReadOnly _exerciseUrl As String
    Private ReadOnly _solutionUrl As String

    Public Sub New(ByVal title As String, ByVal description As String, ByVal exerciseUrl As String, ByVal solutionUrl As String)
        _title = title
        _description = description
        _exerciseUrl = exerciseUrl
        _solutionUrl = solutionUrl
    End Sub
    Public ReadOnly Property Title() As String
        Get
            Return _title
        End Get
    End Property

    Public ReadOnly Property Description() As String
        Get
            Return _description
        End Get
    End Property
	    Public ReadOnly Property ExerciseUrl As String
        Get
            Return _exerciseUrl
        End Get
    End Property
	    Public ReadOnly Property SolutionUrl As String
        Get
            Return _solutionUrl
        End Get
    End Property
End Class
