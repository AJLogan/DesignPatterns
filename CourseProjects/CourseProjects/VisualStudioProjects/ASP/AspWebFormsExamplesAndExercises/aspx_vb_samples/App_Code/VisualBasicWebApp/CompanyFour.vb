Imports Microsoft.VisualBasic
Namespace VisualBasicWebApp
    Public Class CompanyFour
        Public Sub New()
            _staff = New List(Of Employee)()
            _staff.Add(New Employee("AB12", "Joe A Bloggs", "IT", 10000.0))
            _staff.Add(New Employee("CD34", "Jane B Smith", "HR", 20000.0))
            _staff.Add(New Employee("EF56", "Joe C Bloggs", "IT", 30000.0))
            _staff.Add(New Employee("GH78", "Jane D Smith", "HR", 40000.0))
            _staff.Add(New Employee("IJ90", "Joe E Bloggs", "IT", 50000.0))
            _staff.Add(New Employee("KL12", "Jane F Smith", "HR", 60000.0))
            _staff.Add(New Employee("MN34", "Joe G Bloggs", "IT", 70000.0))
            _staff.Add(New Employee("OP56", "Jane H Smith", "HR", 80000.0))
            _staff.Add(New Employee("QR78", "Joe I Bloggs", "IT", 90000.0))
            _staff.Add(New Employee("ST90", "Jane J Smith", "HR", 100000.0))
            _departments = New List(Of String)
            _departments.Add("IT")
            _departments.Add("HR")
        End Sub
        Public ReadOnly Property Staff() As IEnumerable(Of Employee)
            Get
                Return _staff
            End Get
        End Property

        Public ReadOnly Property Departments() As IEnumerable(Of String)
            Get
                Return _departments
            End Get
        End Property
        Private ReadOnly _staff As List(Of Employee)
        Private ReadOnly _departments As List(Of String)
    End Class
End Namespace

