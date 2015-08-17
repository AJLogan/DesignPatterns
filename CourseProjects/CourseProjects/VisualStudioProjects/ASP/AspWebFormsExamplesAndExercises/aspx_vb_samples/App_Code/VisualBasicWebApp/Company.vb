Imports Microsoft.VisualBasic
Namespace VisualBasicWebApp
    Public Class Company
        Shared Sub New()
            _data = New List(Of Employee)()
            _data.Add(New Employee("AB12", "Joe A Bloggs", "IT", 10000.0))
            _data.Add(New Employee("CD34", "Jane B Smith", "HR", 20000.0))
            _data.Add(New Employee("EF56", "Joe C Bloggs", "IT", 30000.0))
            _data.Add(New Employee("GH78", "Jane D Smith", "HR", 40000.0))
            _data.Add(New Employee("IJ90", "Joe E Bloggs", "IT", 50000.0))
            _data.Add(New Employee("KL12", "Jane F Smith", "HR", 60000.0))
            _data.Add(New Employee("MN34", "Joe G Bloggs", "IT", 70000.0))
            _data.Add(New Employee("OP56", "Jane H Smith", "HR", 80000.0))
            _data.Add(New Employee("QR78", "Joe I Bloggs", "IT", 90000.0))
            _data.Add(New Employee("ST90", "Jane J Smith", "HR", 100000.0))
        End Sub
        Public Function GetEmployees() As List(Of Employee)
            Return _data
        End Function
        Private Shared ReadOnly _data As List(Of Employee)
    End Class
End Namespace

