Public Class Base
    'The default constructor is written by the compiler
    '  if no other constructors are present in the class
    Public Sub New()
        MyBase.New()
    End Sub
    'First line of constructor must call superclass
    '  or another constructor (default call inserted)
    Public Sub New(ByVal p1 As String)
        baseFieldOne = p1
    End Sub
    'Fields
    Protected baseFieldOne As String
End Class
