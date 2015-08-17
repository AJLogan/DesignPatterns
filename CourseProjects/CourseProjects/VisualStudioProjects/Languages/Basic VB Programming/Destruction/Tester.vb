Module Tester

    Sub Main()
        Dim widget1 As New Widget("IT", "Hard Drive", 101)
        Dim widget2 As New Widget("IT", "Monitor", 202)
        Dim widget3 As New Widget("IT", "Printer", 303)

        Console.WriteLine("Objects created are:")
        Console.WriteLine(vbTab + "widget one: {0}", widget1)
        Console.WriteLine(vbTab + "widget two: {0}", widget2)
        Console.WriteLine(vbTab + "widget three: {0}", widget3)
        Console.WriteLine(vbTab + "In generations {0} {1} {2}", GC.GetGeneration(widget1), GC.GetGeneration(widget2), GC.GetGeneration(widget3))

        doGC()
        Console.WriteLine(vbNewLine + "First garbage collection completed" + vbNewLine)

        widget2 = Nothing
        widget3 = Nothing

        doGC()
        Console.WriteLine(vbNewLine + "Second garbage collection completed" + vbNewLine)

        Console.WriteLine(vbNewLine + "End of Main" + vbNewLine)
    End Sub

    Sub doGC()
        'Request that garbage collection be carried out
        '  objects to be GC'd will have their finalizers run
        GC.Collect()

        'pause the current thread until the GC has completed
        ' deleting objects and calling finalizers
        GC.WaitForPendingFinalizers()
    End Sub
End Module
