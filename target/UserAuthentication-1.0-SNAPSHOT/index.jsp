<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css.css">

    <title>LOGIN PAGE</title>
</head>

<body>
<h2>Access our page after sign up </h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="register.jsp" method="post">
            <h1>Create Account</h1>
            <span>Use your email for registration</span>
            <input type="text" placeholder="First Name"  name="fname" required />
            <input type="text" placeholder="Last Name" name="lname" required />
            <input type="email" placeholder="Email" name="email" required />
            <input type="password" placeholder="Password" name="password" required />
            <button id="signUp">Create New User</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="http://localhost:8080/examples/servlets/servlet/login" method="post">
            <h1>LOGIN</h1>
            <span>Use your account</span>
            <input type="email" placeholder="Email"  name="email"  required/>
            <input type="password" placeholder="Password" name="password" required />
            <button id="signIn">LOGIN</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>Go back to login page</p>
                <button class="ghost" id="signIn1">back to Login</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp1">Create New User</button>
            </div>
        </div>
    </div>
</div>
</body>
<script >

    const signUpButton1 = document.getElementById('signUp1');
    const signInButton1 = document.getElementById('signIn1');
    const container = document.getElementById('container');

    signUpButton1.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton1.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });


</script>

</html>