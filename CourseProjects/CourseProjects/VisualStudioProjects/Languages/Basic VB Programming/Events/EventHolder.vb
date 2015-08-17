Public Class EventHolder
    Public Event MyEvent As Callback

    Public Sub TriggerEvent()
        RaiseEvent MyEvent(7, 9.6)
    End Sub

    'WHEN BUTTON PUXHED ON SCREEN
    'RaiseEvent Me.Click(Me,new EventArgs(...))

End Class
