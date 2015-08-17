Imports System.Collections.Generic
Imports System.Text

Public Class LinkedList(Of T)
    Public Function IsEmpty() As Boolean
        Return _currentSize = 0
    End Function

    Public Sub Add(ByVal item As T)
        _currentSize += 1
        If (_first Is Nothing) Then
            _first = New Node(Of T)(item, Nothing)
        Else
            Dim last = MoveToLastNode(_first)
            last.After = New Node(Of T)(item, last)
        End If
    End Sub
    Public ReadOnly Property Size() As Integer
        Get
            Return _currentSize
        End Get
    End Property
    Default Public ReadOnly Property Items(ByVal index As Integer)
        Get
            Return GetItem(index)
        End Get
    End Property
    Private Function GetItem(ByVal index As Integer) As T
        If (IsEmpty()) Then
            Throw New ListEmptyException("No Items")

        ElseIf (IndexIsInvalid(index)) Then
            Throw New ArgumentOutOfRangeException()

        Else
            Return RetrieveItem(index)
        End If

    End Function
    Public Sub Remove(ByVal item As T)
        Dim toDie As Node(Of T) = Nothing
        If (IsEmpty()) Then
            Throw New ListEmptyException("Cant remove")

        ElseIf (item Is Nothing Or Not Exists(item, toDie)) Then
            Throw New ArgumentOutOfRangeException()

        Else
            _currentSize -= 1
            If (_first.Item.Equals(item)) Then
                Remove_FirstNode()
            Else
                If (toDie.After Is Nothing) Then
                    RemoveLastNode(toDie)
                Else
                    RemoveNodeFromMiddle(toDie)
                End If
            End If
        End If
    End Sub
    Private Function FindNode(ByVal item As T) As Node(Of T)
        Dim current = _first
        While (Not current Is Nothing)
            If (current.Item.Equals(item)) Then
                Exit While
            Else
                current = current.After
            End If
        End While
        Return current
    End Function

    Private Sub RemoveNodeFromMiddle(ByVal current As Node(Of T))
        Dim beforeCurrent = current.Before
        Dim afterCurrent = current.After
        beforeCurrent.After = afterCurrent
        afterCurrent.Before = beforeCurrent
    End Sub
    Private Sub RemoveLastNode(ByVal current As Node(Of T))
        Dim beforeCurrent = current.Before
        beforeCurrent.After = Nothing
    End Sub
    Private Sub Remove_FirstNode()
        _first = _first.After
        If (Not _first Is Nothing) Then
            _first.Before = Nothing
        End If
    End Sub
    Private Function Exists(ByVal item As T, ByRef found As Node(Of T)) As Boolean
        Dim current = _first
        While (Not current Is Nothing)
            If (current.Item.Equals(item)) Then
                found = current
                Return True
            Else
                current = current.After
            End If
        End While
        found = Nothing
        Return False
    End Function
    Public Overrides Function ToString() As String
        If (IsEmpty()) Then
            Return "List Is Empty"
        Else
            Dim sb = New StringBuilder("List Contents:")
            Dim current As Node(Of T) = _first
            While (Not current Is Nothing)
                sb.Append(" ")
                sb.Append(current.Item)
                current = current.After
            End While
            Return sb.ToString()
        End If
    End Function

    Private Function MoveToLastNode(ByVal n As Node(Of T)) As Node(Of T)
        Dim current = n
        While (Not current.After Is Nothing)
            current = current.After
        End While

        Return current
    End Function
    Private Function RetrieveItem(ByVal index As Integer) As T
        If (index = 0) Then
            Return _first.Item
        Else
            Dim current = _first
            For i As Integer = 1 To index
                current = current.After
            Next
            Return current.Item
        End If
    End Function
    Private Function IndexIsInvalid(ByVal index As Integer) As Boolean
        Return (index < 0 Or index > (Size - 1))
    End Function

    Private _currentSize As Integer
    Private _first As Node(Of T)
End Class
