Imports System
Imports System.Text
Imports Microsoft.VisualStudio.TestTools.UnitTesting

<TestClass()> _
Public Class LinkedListTest
    <TestInitialize()> Public Sub Begin()
        _list = New LinkedList(Of String)()
    End Sub
    <TestMethod()> Public Sub New_listIsEmpty()
        Assert.IsTrue(_list.IsEmpty())
    End Sub
    <TestMethod()> Public Sub ListWithItemsIsNotEmpty()
        _list.Add("abc")
        Assert.IsFalse(_list.IsEmpty())
    End Sub
    <TestMethod()> Public Sub NewListHasZeroSize()
        Assert.AreEqual(0, _list.Size)
    End Sub
    <TestMethod()> Public Sub ListWithItemsHasCorrectSize()
        addTestData()
        Assert.AreEqual(3, _list.Size)
    End Sub
    <TestMethod()> _
    Public Sub CanGetSingleItem()
        _list.Add("abc")
        Assert.AreEqual("abc", _list(0))
    End Sub
    <TestMethod()> Public Sub CanGetMultipleItems()
        addTestData()
        Assert.AreEqual("abc", _list(0))
        Assert.AreEqual("def", _list(1))
        Assert.AreEqual("ghi", _list(2))
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ListEmptyException))> _
    Public Sub AccessingEmpty_listFails()
        Dim tmp As String = _list(1)
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ArgumentOutOfRangeException))> _
    Public Sub AccessingWithNegativeIndexFails()
        _list.Add("abc")
        Dim tmp As String = _list(-1)
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ArgumentOutOfRangeException))> _
    Public Sub AccessingWithTooLargeAnIndexFails()
        addTestData()
        Dim tmp As String = _list(3)
    End Sub
    <TestMethod()> _
    Public Sub ToStringWorks()
        Assert.AreEqual("List Is Empty", _list.ToString())
        _list.Add("ZZZ")
        Assert.AreEqual("List Contents: ZZZ", _list.ToString())
        addTestData()
        Assert.AreEqual("List Contents: ZZZ abc def ghi", _list.ToString())
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ListEmptyException))> _
    Public Sub RemoveFromEmpty_listFails()
        _list.Remove("abc")
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ArgumentOutOfRangeException))> _
    Public Sub NullArgumentForRemoveFails()
        addTestData()
        _list.Remove(Nothing)
    End Sub
    <TestMethod()> _
    <ExpectedException(GetType(ArgumentOutOfRangeException))> _
    Public Sub RemoveWhereItemNotFoundFails()
        addTestData()
        _list.Remove("XXX")
    End Sub
    <TestMethod()> _
    Public Sub RemovingOnlyItemWorks()
        _list.Add("abc")
        _list.Remove("abc")
        Assert.IsTrue(_list.IsEmpty())
        Assert.AreEqual(0, _list.Size)
        Assert.AreEqual("List Is Empty", _list.ToString())
    End Sub
    <TestMethod()> _
    Public Sub RemovingFirstItemWorks()
        addTestData()
        _list.Remove("abc")
        Assert.IsFalse(_list.IsEmpty())
        Assert.AreEqual(2, _list.Size)
        Assert.AreEqual("List Contents: def ghi", _list.ToString())

    End Sub
    <TestMethod()> _
    Public Sub RemovingLastItemWorks()
        addTestData()
        _list.Remove("ghi")
        Assert.IsFalse(_list.IsEmpty())
        Assert.AreEqual(2, _list.Size)
        Assert.AreEqual("List Contents: abc def", _list.ToString())
    End Sub
    <TestMethod()> _
    Public Sub RemovingItemFromMiddleWorks()
        addTestData()
        _list.Remove("def")
        Assert.IsFalse(_list.IsEmpty())
        Assert.AreEqual(2, _list.Size)
        Assert.AreEqual("List Contents: abc ghi", _list.ToString())
    End Sub
    Private Sub addTestData()
        _list.Add("abc")
        _list.Add("def")
        _list.Add("ghi")
    End Sub
    Private _list As LinkedList(Of String)
End Class
