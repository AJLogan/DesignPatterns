Imports System.Runtime.CompilerServices

<Extension()> _
Public Module TestTwo
    <Extension()> _
    Public Function Op2(ByVal obj As TestOne, ByVal str As String) As String
        Return obj.Op1() + str
    End Function
End Module
