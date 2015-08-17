Imports NUnit.Framework


<TestFixture()> Public Class TestBasicMath
    <SetUp()> Public Sub Begin()
        System.Console.WriteLine("SetUp OK")
        mathObj = New BasicMath(30, 20)
    End Sub
    <TearDown()> Public Sub Last()
        System.Console.WriteLine("TearDown OK")
    End Sub
    <Test()> Public Sub AdditionWorks()
        'Assertion.AssertEquals("addition failed!", 50, mathObj.add())
        Assert.AreEqual(50, mathObj.Add(), "addition failed!")
    End Sub
    <Test()> Public Sub SubtractionWorks()
        'Assertion.AssertEquals("subtraction failed!", 10, mathObj.subtract())
        Assert.AreEqual(10, mathObj.Subtract(), "subtraction failed!")
    End Sub
    <Test()> Public Sub MultiplicationWorks()
        'Assertion.AssertEquals("multiplication failed!", 600, mathObj.multiply())
        Assert.AreEqual(600, mathObj.Multiply(), "multiplication failed!")
    End Sub

    Private mathObj As BasicMath
End Class
