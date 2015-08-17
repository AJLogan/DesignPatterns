Module Tester

    Sub Main()
        Dim t As New Triangle
        Dim s As New Square

        testColorable(t)
        testColorable(s)
    End Sub

    Sub testColorable(ByVal ic As IColorable)
        ic.X = 25
        ic.Y = 25
        ic.draw(10)
        ic.paint(255)
    End Sub

End Module
