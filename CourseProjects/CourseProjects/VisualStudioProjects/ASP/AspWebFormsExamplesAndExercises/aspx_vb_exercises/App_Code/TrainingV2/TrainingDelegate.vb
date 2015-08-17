Imports Microsoft.VisualBasic

Namespace TrainingV2
    Public Class TrainingDelegate
        Public Sub New()
        End Sub
        Public Sub New(ByVal name As String, ByVal company As String, ByVal yearsExperience As Integer, ByVal feePaid As Double)
            _name = name
            _company = company
            _yearsExperience = yearsExperience
            _feePaid = feePaid
        End Sub
        Public Property Name() As String
            Get
                Return _name
            End Get
            Set(ByVal value As String)
                _name = value
            End Set
        End Property
        Public Property Company() As String
            Get
                Return _company
            End Get
            Set(ByVal value As String)
                _company = value
            End Set
        End Property
        Public Property YearsExperience() As Integer
            Get
                Return _yearsExperience
            End Get
            Set(ByVal value As Integer)
                _yearsExperience = value
            End Set
        End Property
        Public Property FeePaid() As Double
            Get
                Return _feePaid
            End Get
            Set(ByVal value As Double)
                _feePaid = value
            End Set
        End Property
        Private _name As String
        Private _company As String
        Private _yearsExperience As Integer
        Private _feePaid As Double
    End Class
End Namespace

