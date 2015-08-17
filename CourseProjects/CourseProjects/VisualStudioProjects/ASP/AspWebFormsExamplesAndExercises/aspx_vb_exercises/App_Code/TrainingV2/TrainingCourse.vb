Imports Microsoft.VisualBasic
Namespace TrainingV2
    Public Class TrainingCourse
        Shared Sub New()
            attendees = New List(Of TrainingDelegate)()
            attendees.Add(New TrainingDelegate("Joe Bloggs", "BMW", 3, 2500.0))
            attendees.Add(New TrainingDelegate("Jane Smith", "Honda", 5, 2600.0))
            attendees.Add(New TrainingDelegate("Fred Martin", "Nissan", 2, 2700.0))
            attendees.Add(New TrainingDelegate("Sarah Jenkins", "Peugeot", 1, 2800.0))
            attendees.Add(New TrainingDelegate("Peter Griffiths", "Renault", 7, 2900.0))
        End Sub
        Public Function GetDelegates(ByVal maximum As Integer, ByVal startIndex As Integer) As List(Of TrainingDelegate)
            If (startIndex + maximum > attendees.Count) Then
                Return attendees.GetRange(startIndex, attendees.Count - startIndex)
            Else
                Return attendees.GetRange(startIndex, maximum)
            End If
        End Function
        Public Function GetDelegateCount() As Integer
            Return attendees.Count
        End Function
        Public Sub AddDelegate(ByVal d As TrainingDelegate)
            attendees.Add(d)
        End Sub
        Private Shared ReadOnly attendees As List(Of TrainingDelegate)
    End Class
End Namespace

