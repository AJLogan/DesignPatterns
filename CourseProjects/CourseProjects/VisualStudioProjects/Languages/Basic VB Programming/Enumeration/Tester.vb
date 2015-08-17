Module Tester
    Enum SocketStates
        Connecting      '0
        Connected       '1
        Sending         '2
        Waiting         '3
        Receiving       '4
        Disconnecting   '5
        Disconnected    '6
    End Enum


    Sub Main()
        Dim state As SocketStates

        For x As Integer = 0 To 6
            state = x
            Select Case state
                Case SocketStates.Connecting
                    Console.WriteLine("State is connecting")
                Case SocketStates.Connected
                    Console.WriteLine("State is connected")
                Case SocketStates.Sending
                    Console.WriteLine("State is sending")
                Case SocketStates.Waiting
                    Console.WriteLine("State is waiting")
                Case SocketStates.Receiving
                    Console.WriteLine("State is receiving")
                Case SocketStates.Disconnecting
                    Console.WriteLine("State is disconnecting")
                Case SocketStates.Disconnected
                    Console.WriteLine("State is disconnected")
            End Select
        Next
        
    End Sub

End Module
