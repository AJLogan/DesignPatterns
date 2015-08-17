Imports System.Text

Public Class Widget
    Public Sub New(ByVal type As String, ByVal name As String, ByVal index As Integer)
        Me.type = type
        Me.name = name
        Me.index = index
    End Sub

    Protected Overrides Sub Finalize()
        Console.WriteLine("Finalize called for widget with index {0} in generation {1}", index, GC.GetGeneration(Me))
    End Sub
    Public Overrides Function ToString() As String

        Dim sb As New StringBuilder
        sb.Append("Widget of type ")
        sb.Append(type)
        sb.Append(" with name ")
        sb.Append(name)
        sb.Append(" and index ")
        sb.Append(index)
        Return sb.ToString

    End Function

    Private type, name As String
    Private index As Integer
End Class
