Imports Microsoft.VisualBasic

Imports System.Xml

Public Class CustomSettingsHandler
    Implements IConfigurationSectionHandler
    Public Function Create(ByVal parent As Object, ByVal configContext As Object, ByVal section As XmlNode) As Object Implements IConfigurationSectionHandler.Create
        Dim tmpMaxThreads As String = ""
        Dim tmpDatabaseIP As String = ""
        For Each child As XmlNode In section.ChildNodes
            If (TypeOf child Is XmlElement) Then
                Dim current As XmlElement = CType(child, XmlElement)
                If (current.Name.Equals("MaxThreads")) Then
                    tmpMaxThreads = current.InnerText
                ElseIf (current.Name.Equals("DatabaseIP")) Then
                    tmpDatabaseIP = current.InnerText
                End If
            End If
        Next
        Return New CustomSettingsVO(Convert.ToInt32(tmpMaxThreads.Trim()), tmpDatabaseIP)
    End Function
End Class
