<%@ Page Language="C#"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
	</head>
	<body>
		<!-- 
			Note that the code below does not work:
				Exception ex = Server.GetLastError();
			This is because the error is cleared before
			  the error handling page is triggered
			Storing the value in the session object will
			  not work because the old session is discarded
			  and a new one is created
		-->
		<h3>Custom Error Handling Page</h3>
	</body>
</html>
