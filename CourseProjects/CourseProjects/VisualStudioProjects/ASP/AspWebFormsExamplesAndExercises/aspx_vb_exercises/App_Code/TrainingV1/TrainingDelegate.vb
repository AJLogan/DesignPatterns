Imports Microsoft.VisualBasic

Namespace TrainingV1
    Public Class TrainingDelegate
        Public Sub New(ByVal name As String, ByVal company As String, ByVal yearsExperience As Integer, ByVal feePaid As Double)
            _name = name
            _company = company
            _yearsExperience = yearsExperience
            _feePaid = feePaid
        End Sub
        Public ReadOnly Property Name() As String
            Get
                Return _name
            End Get
        End Property
        Public ReadOnly Property Company() As String
            Get
                Return _company
            End Get
        End Property
        Public ReadOnly Property YearsExperience() As Integer
            Get
                Return _yearsExperience
            End Get
        End Property
        Public ReadOnly Property FeePaid() As Double
            Get
                Return _feePaid
            End Get
        End Property
        Private ReadOnly _name As String
        Private ReadOnly _company As String
        Private ReadOnly _yearsExperience As Integer
        Private ReadOnly _feePaid As Double
    End Class
End Namespace

