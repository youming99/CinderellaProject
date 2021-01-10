<%@page import="com.project.cinderella.model.domain.TopCategory"%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../inc/top.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<%@ include file="../inc/header.jsp"%>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>eCommerce HTML-5 Template </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
</head>

<script>
function login(){
   $("#loginForm").attr({
      action:"/cinderella/shop/member/login",
      method:"post"
   });      
   
   $("#loginForm").submit();
   
}
</script>   
<style>
</style>   
<body>

    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Login</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

    <!--================login_part Area =================-->
    <section class="login_part section_padding ">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_text text-center">
                        <div class="login_part_text_iner">
                            <h2>New to our Shop?</h2>
                            <!-- <p>There are advances being made in science and technology
                                everyday, and a good example of this is the</p> -->
                           <!--  <a href="#" class="btn_3">Create an Account</a> -->
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_form">
                        <div class="login_part_form_iner">
                            <h3>Welcome Back ! <br>
                                Please Sign in now</h3>
                                <div id="loader" style="margin:auto"></div>
         <form id="loginForm" style="margin:50px 50px">
                            <!-- <form class="row contact_form" action="#" method="post" novalidate="novalidate"> -->
                                <div class="col-md-12 form-group p_star">
                                    <input type="text" name="user_id" placeholder="Username" required>
                                </div>
                                <div class="col-md-12 form-group p_star">
                                    <input type="password" name="password" placeholder="Password" required>
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="creat_account d-flex align-items-center">
                                       
                                    </div>
                                    <input type="button" value="Login" onClick="login()">
                                        log in
                                    </button>
                                 
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================login_part end =================-->

    <%@ include file="../inc/footer.jsp"%>



</body>
    
</html>