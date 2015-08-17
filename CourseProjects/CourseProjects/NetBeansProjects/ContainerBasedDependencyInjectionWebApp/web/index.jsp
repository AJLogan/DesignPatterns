<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple Demo of JEE6 Container Dependency Injection</title>
    </head>
    <body>
        <h1>Simple Demo of JEE6 Container Dependency Injection</h1>
        <h2>Please enter your payment details below...</h2>
        <form method="POST" action="demo">
            <p>
                <label>Your account number: </label>
                <input type="text" name="accountNumber" size="10" required/>
            </p>
            <p>
                <label>The amount: </label>
                <input type="text" name="amount" size="10" required/>
            </p>
            <p>
                <label>PayPal</label>
                <input type="radio" name="provider" value="paypal" checked/>
                <label>Visa</label>
                <input type="radio" name="provider" value="visa"/>
                <label>MasterCard</label>
                <input type="radio" name="provider" value="mastercard"/>
            </p>
            <p>
                <input type="submit" value="Make Payment"/>
            </p>
        </form>
    </body>
</html>
