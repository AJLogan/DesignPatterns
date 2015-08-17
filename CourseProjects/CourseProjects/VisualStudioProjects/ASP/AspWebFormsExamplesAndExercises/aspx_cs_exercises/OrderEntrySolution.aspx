<%@ Page Language="C#" %>
<script  language="C#" runat="server">

        protected void Page_Load(object src, EventArgs args) {
            if (IsPostBack) {
                if (customerID.Value.Equals("")) {
                    output.InnerText = "Customer ID must be specified!";
                }
                else if (customerName.Value.Equals("")) {
                    output.InnerText = "Customer Name must be specified!";
                }
                else {
                    output.InnerText = "Total order value is: " + calculateTotal();
                }
            }
        }

        private double calculateTotal() {
            double[] subtotals = new double[4];
            subtotals[0] = calculateSubTotal(lineOneItemNumber.Value, lineOneQuantity.Value, lineOneUnitPrice.Value);
            subtotals[1] = calculateSubTotal(lineTwoItemNumber.Value, lineTwoQuantity.Value, lineTwoUnitPrice.Value);
            subtotals[2] =
                calculateSubTotal(lineThreeItemNumber.Value, lineThreeQuantity.Value, lineThreeUnitPrice.Value);
            subtotals[3] = calculateSubTotal(lineFourItemNumber.Value, lineFourQuantity.Value, lineFourUnitPrice.Value);
            //Add up the subtotals
            double total = 0;
            foreach (double d in subtotals) {
                total += d;
            }
            return total;
        }

        private double calculateSubTotal(string itemNo, string quantity, string price) {
            if (!itemNo.Equals("")) {
                int numQuantity = Convert.ToInt32(quantity);
                double numPrice = Convert.ToDouble(price);
                return numQuantity*numPrice;
            }
            else {
                return 0;
            }
        }

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
                <input runat="server" id="ratingOne" type="radio" name="rating" value="good" checked="true"/>Good
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

