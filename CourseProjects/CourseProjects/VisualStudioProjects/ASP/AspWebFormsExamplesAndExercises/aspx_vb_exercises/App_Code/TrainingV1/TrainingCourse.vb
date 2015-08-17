Imports Microsoft.VisualBasic

Namespace TrainingV1
    Public Class TrainingCourse
        Public Function GetDelegates() As List(Of TrainingDelegate)
            Dim attendees As List(Of TrainingDelegate) = New List(Of TrainingDelegate)()
            attendees.Add(New TrainingDelegate("Joe Bloggs", "BMW", 3, 2500.0))
            attendees.Add(New TrainingDelegate("Jane Smith", "Honda", 5, 2600.0))
            attendees.Add(New TrainingDelegate("Fred Martin", "Nissan", 2, 2700.0))
            attendees.Add(New TrainingDelegate("Sarah Jenkins", "Peugeot", 1, 2800.0))
            attendees.Add(New TrainingDelegate("Peter Griffiths", "Renault", 7, 2900.0))
            Return attendees
        End Function
    End Class
End Namespace

