Module Program
    Sub Main()
        Dim forename = "Joe"
        Dim streetNumber = 16
        Dim person = _
            <person>
                <name title="Mr">
                    <forename><%= forename %></forename>
                    <surname>Bloggs</surname>
                </name>
                <address postcode="BT37 AB1">
                    <street number=<%= streetNumber %>>
                        Arcatia Road
                    </street>
                    <city>Belfast</city>
                </address>
            </person>

        Dim node As XNode = Nothing
        For Each node In person.DescendantNodesAndSelf
            If TypeOf node Is XElement Then
                Dim element = CType(node, XElement)
                Console.WriteLine("Element called: {0}", element.Name)
            End If
        Next


    End Sub
End Module
