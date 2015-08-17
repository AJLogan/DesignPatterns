Imports System.Text


Public Class Derived
    Inherits Base
    'Calls Base.New()
    Public Sub New()
        MyBase.New()
    End Sub
    'Calls Base.New(String)
    Public Sub New(ByVal p1 As String)
        MyBase.New(p1)
    End Sub
    'Calls Base.New(String)
    Public Sub New(ByVal p1 As String, ByVal p2 As String)
        MyBase.New(p1)
        derivedFieldOne = p2
    End Sub
    'Calls Derived.New(String,String)
    Public Sub New(ByVal p1 As String, ByVal p2 As String, ByVal p3 As String)
        Me.New(p1, p2)
        derivedFieldTwo = p3
    End Sub
    Public Overrides Function ToString() As String
        Dim sb As New StringBuilder
        sb.Append(vbNewLine)
        sb.Append(vbTab)
        sb.Append("baseFieldOne is: ")
        sb.Append(baseFieldOne)
        sb.Append(vbNewLine)
        sb.Append(vbTab)
        sb.Append("derivedFieldOne is: ")
        sb.Append(derivedFieldOne)
        sb.Append(vbNewLine)
        sb.Append(vbTab)
        sb.Append("derivedFieldOne is: ")
        sb.Append(derivedFieldTwo)
        sb.Append(vbNewLine)
        Return sb.ToString
    End Function

    'Fields
    Protected derivedFieldOne As String
    Protected derivedFieldTwo As String
End Class
