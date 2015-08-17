<%@ Page Language="VB" Debug="true" %>
<script runat="server">
    Protected Sub Page_Load(ByVal src As Object, ByVal args As EventArgs)
        If (IsPostBack) Then
            If (customerID.Value.Equals("")) Then
                output.InnerText = "Customer ID must be specified!"
            ElseIf (customerName.Value.Equals("")) Then
                output.InnerText = "Customer Name must be specified!"
            Else
                output.InnerText = "Total order value is: " + CStr(CalculateTotal())
            End If
        End If
    End Sub

    Private Function CalculateTotal() As Double
        Dim subtotals(3) As Double
        subtotals(0) = CalculateSubTotal(lineOneItemNumber.Value, lineOneQuantity.Value, lineOneUnitPrice.Value)
        subtotals(1) = CalculateSubTotal(lineTwoItemNumber.Value, lineTwoQuantity.Value, lineTwoUnitPrice.Value)
        subtotals(2) = CalculateSubTotal(lineThreeItemNumber.Value, lineThreeQuantity.Value, lineThreeUnitPrice.Value)
        subtotals(3) = CalculateSubTotal(lineFourItemNumber.Value, lineFourQuantity.Value, lineFourUnitPrice.Value)
        'Add up the subtotals
        Dim total As Double = 0
        For Each d As Double In subtotals
            total += d
        Next
        Return total
    End Function

    Private Function CalculateSubTotal(ByVal itemNo As String, ByVal quantity As String, ByVal price As String) As Double
        If (Not itemNo.Equals("")) Then
            Dim numQuantity As Integer = Convert.ToInt32(quantity)
            Dim numPrice As Double = Convert.ToDouble(price)
            Return numQuantity * numPrice
        Else
            Return 0
        End If
    End Function
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Order Entry Form</title>
	</head>
	<body>
    	<form runat="server">
    	    <p>
			    <b>Customer ID:</b><input runat="server" type="text" id="customerID" maxlength="10" value="ABC123"/>
    	    </p>
    	     <p>
			    <b>Customer Name:</b><input runat="server" type="text" id="customerName" maxlength="10" value="Joe Bloggs"/>
    	     </p>
    	     <p>
                <b>Credit Rating:</b>
                <input runat="server" id="ratingOne" type="radio" name="rating" value="good" checked/>Good
                <input runat="server" id="ratingTwo" type="radio" name="rating" value="medium"/>Medium
                <input runat="server" id="ratingThree" type="radio" name="rating" value="poor"/>Poor
    	     </p>
	         <table>
	             <tr><th>Line Number</th><th>Item Number</th><th>Quantity</th><th>Unit Price</th></tr>
	             <tr>
	                 <td>1</td>
	                 <td><input runat="server" type="text" id="lineOneItemNumber" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineOneQuantity" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineOneUnitPrice" maxlength="5"/></td>
	             </tr>
	             <tr>
	                 <td>2</td>
	                 <td><input runat="server" type="text" id="lineTwoItemNumber" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineTwoQuantity" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineTwoUnitPrice" maxlength="5"/></td>
	             </tr>
	             <tr>
	                 <td>3</td>
	                 <td><input runat="server" type="text" id="lineThreeItemNumber" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineThreeQuantity" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineThreeUnitPrice" maxlength="5"/></td>
	             </tr>
	             <tr>
	                 <td>4</td>
	                 <td><input runat="server" type="text" id="lineFourItemNumber" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineFourQuantity" maxlength="3"/></td>
	                 <td><input runat="server" type="text" id="lineFourUnitPrice" maxlength="5"/></td>
	             </tr>
	         </table>
    	    <p>
    	        <input runat="server" type="submit" value="Submit Data"/>
    	    </p>
    	    <h3 id="output" runat="server"></h3>
    	</form>
	</body>
</html>

