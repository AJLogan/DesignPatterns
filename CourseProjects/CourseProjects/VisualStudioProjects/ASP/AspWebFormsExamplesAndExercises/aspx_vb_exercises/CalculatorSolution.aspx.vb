
Partial Class CalculatorSolution
    Inherits System.Web.UI.Page
    Protected Enum Operations
        None
        Add
        Subtract
        Divide
        Multiply
    End Enum
    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs)
        If (Not IsPostBack) Then
            SetupSessionVariables()
        End If
    End Sub
    Private Sub SetupSessionVariables()
        Session("CurrentOperation") = Operations.None
        Session("CurrentTotal") = 0.0
    End Sub
    Protected Sub btAdd_Click(ByVal sender As Object, ByVal e As EventArgs)
        Session("CurrentOperation") = Operations.Add
        dataBox.Text = Session("CurrentTotal").ToString()
    End Sub
    Protected Sub btSubtract_Click(ByVal sender As Object, ByVal e As EventArgs)
        Session("CurrentOperation") = Operations.Subtract
        dataBox.Text = Session("CurrentTotal").ToString()
    End Sub
    Protected Sub btMultiply_Click(ByVal sender As Object, ByVal e As EventArgs)
        Session("CurrentOperation") = Operations.Multiply
        dataBox.Text = Session("CurrentTotal").ToString()
    End Sub
    Protected Sub btDivide_Click(ByVal sender As Object, ByVal e As EventArgs)
        Session("CurrentOperation") = Operations.Divide
        dataBox.Text = Session("CurrentTotal").ToString()
    End Sub
    Protected Sub btEquals_Click(ByVal sender As Object, ByVal e As EventArgs)
        dataBox.Text = Session("CurrentTotal").ToString()
    End Sub
    Protected Sub btClear_Click(ByVal sender As Object, ByVal e As EventArgs)
        dataBox.Text = ""
        SetupSessionVariables()
    End Sub
    Private Sub ProcessNumber(ByVal number As Double)

        Dim total As Double = CDbl(Session("CurrentTotal"))

        Select Case CType(Session("CurrentOperation"), Operations)
            Case Operations.None
                Session("CurrentTotal") = number
            Case Operations.Add
                Session("CurrentTotal") = number + total
            Case Operations.Multiply
                Session("CurrentTotal") = number * total
            Case Operations.Divide
                Session("CurrentTotal") = total / number
            Case Operations.Subtract
                Session("CurrentTotal") = total - number
        End Select

        dataBox.Text = number.ToString()
        Session("CurrentOperation") = Operations.None
    End Sub
    Protected Sub btOne_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(1)
    End Sub
    Protected Sub btTwo_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(2)
    End Sub
    Protected Sub btThree_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(3)
    End Sub
    Protected Sub btFour_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(4)
    End Sub
    Protected Sub btFive_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(5)
    End Sub
    Protected Sub btSix_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(6)
    End Sub
    Protected Sub btSeven_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(7)
    End Sub
    Protected Sub btEight_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(8)
    End Sub
    Protected Sub btNine_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(9)
    End Sub
    Protected Sub btZero_Click(ByVal sender As Object, ByVal e As EventArgs)
        ProcessNumber(0)
    End Sub
End Class
