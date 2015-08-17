<%@ Page language="c#" Inherits="AspxExercises.CalculatorSolution" CodeFile="CalculatorSolution.aspx.cs" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Calculator</title>
	</head>
	<body>
		<form id="Form1" method="post" runat="server">
			<asp:textbox id="dataBox" style="Z-INDEX: 100; LEFT: 61px; POSITION: absolute; TOP: 53px" runat="server"
				Width="212px" Height="30px"></asp:textbox>
			<asp:button id="btClear" style="Z-INDEX: 126; LEFT: 204px; POSITION: absolute; TOP: 254px" runat="server"
				Width="67px" Height="21px" Text="Clear" onclick="btClear_Click"></asp:button>
			<asp:button id="btEquals" style="Z-INDEX: 125; LEFT: 204px; POSITION: absolute; TOP: 224px"
				runat="server" Width="67px" Height="23px" Text="Equals" onclick="btEquals_Click"></asp:button><asp:button id="btDivide" style="Z-INDEX: 124; LEFT: 205px; POSITION: absolute; TOP: 196px"
				runat="server" Width="67px" Height="21px" Text="Divide" onclick="btDivide_Click"></asp:button><asp:button id="btMultiply" style="Z-INDEX: 123; LEFT: 206px; POSITION: absolute; TOP: 164px"
				runat="server" Width="65px" Height="23px" Text="Multiply" onclick="btMultiply_Click"></asp:button>
			<asp:Button id="btSubtract" style="Z-INDEX: 122; LEFT: 206px; POSITION: absolute; TOP: 133px"
				runat="server" Width="65px" Height="23px" Text="Subtract" onclick="btSubtract_Click"></asp:Button>
			<asp:Button id="btZero" style="Z-INDEX: 121; LEFT: 107px; POSITION: absolute; TOP: 226px" runat="server"
				Width="37px" Height="33px" Text="0" onclick="btZero_Click"></asp:Button>
			<asp:Button id="btNine" style="Z-INDEX: 120; LEFT: 157px; POSITION: absolute; TOP: 182px" runat="server"
				Width="35px" Height="34px" Text="9" onclick="btNine_Click"></asp:Button>
			<asp:Button id="btEight" style="Z-INDEX: 119; LEFT: 107px; POSITION: absolute; TOP: 182px" runat="server"
				Width="37px" Height="32px" Text="8" onclick="btEight_Click"></asp:Button>
			<asp:Button id="btSeven" style="Z-INDEX: 118; LEFT: 63px; POSITION: absolute; TOP: 182px" runat="server"
				Width="33px" Height="33px" Text="7" onclick="btSeven_Click"></asp:Button>
			<asp:Button id="btSix" style="Z-INDEX: 117; LEFT: 158px; POSITION: absolute; TOP: 138px" runat="server"
				Width="35px" Height="34px" Text="6" onclick="btSix_Click"></asp:Button>
			<asp:Button id="btFive" style="Z-INDEX: 116; LEFT: 108px; POSITION: absolute; TOP: 141px" runat="server"
				Width="36px" Height="31px" Text="5" onclick="btFive_Click"></asp:Button>
			<asp:Button id="btFour" style="Z-INDEX: 115; LEFT: 62px; POSITION: absolute; TOP: 142px" runat="server"
				Width="36px" Height="30px" Text="4" onclick="btFour_Click"></asp:Button>
			<asp:Button id="btOne" style="Z-INDEX: 109; LEFT: 61px; POSITION: absolute; TOP: 100px" runat="server"
				Width="36px" Height="31px" Text="1" onclick="btOne_Click"></asp:Button>
			<asp:Button id="btThree" style="Z-INDEX: 114; LEFT: 158px; POSITION: absolute; TOP: 101px" runat="server"
				Width="35px" Height="29px" Text="3" onclick="btThree_Click"></asp:Button>
			<asp:Button id="btTwo" style="Z-INDEX: 113; LEFT: 107px; POSITION: absolute; TOP: 100px" runat="server"
				Width="37px" Height="31px" Text="2" onclick="btTwo_Click"></asp:Button>
			<asp:Button id="btAdd" style="Z-INDEX: 101; LEFT: 207px; POSITION: absolute; TOP: 102px" runat="server"
				Width="65px" Height="22px" Text="Add" onclick="btAdd_Click"></asp:Button>
		</form>
	</body>
</html>
