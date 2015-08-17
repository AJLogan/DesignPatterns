Imports Microsoft.VisualBasic

Public Class CustomSettingsVO
    Public Sub New(ByVal _maxThreads As String, ByVal _databaseIP As String)
        Me._databaseIP = _databaseIP
        Me._maxThreads = _maxThreads
    End Sub
    Public ReadOnly Property MaxThreads() As String
        Get
            Return _maxThreads
        End Get
    End Property
    Public ReadOnly Property DatabaseIP() As String
        Get
            Return _databaseIP
        End Get
    End Property
    Private _maxThreads As String
    Private _databaseIP As String
End Class
