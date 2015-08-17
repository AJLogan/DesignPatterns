Public Class Indexed
    Public Property Items(ByVal index As Integer) As Integer
        Get
            Select Case index
                Case 0
                    Return valOne
                Case 1
                    Return valTwo
                Case 2
                    Return valThree
                Case 3
                    Return valFour
            End Select
        End Get
        Set(ByVal Value As Integer)
            Select Case index
                Case 0
                    valOne = Value
                Case 1
                    valTwo = Value
                Case 2
                    valThree = Value
                Case 3
                    valFour = Value
            End Select
        End Set
    End Property

    Private valOne, valTwo, valThree, valFour As Integer
End Class
