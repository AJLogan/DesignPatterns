Public MustInherit Class Shape
    Implements IColorable

    Public MustOverride Sub paint(ByVal color As Integer) Implements IColorable.paint
    Public MustOverride Sub draw(ByVal size As Integer) Implements IDrawable.draw

    Public Property X() As Integer Implements IDrawable.X
        Get
            Return xPosition
        End Get
        Set(ByVal Value As Integer)
            xPosition = Value
        End Set
    End Property

    Public Property Y() As Integer Implements IDrawable.Y
        Get
            Return yPosition
        End Get
        Set(ByVal Value As Integer)
            yPosition = Value
        End Set
    End Property

    Private xPosition As Integer
    Private yPosition As Integer
End Class
