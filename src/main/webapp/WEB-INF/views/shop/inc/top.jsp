<%@page import="com.project.cinderella.model.domain.SubCategory"%>
<%@page import="com.project.cinderella.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
   List<TopCategory> topList = (List)request.getAttribute("topList");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* Dropdown Button */
.dropbtn {
  background-color: #000000;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #818181;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}
</style>
<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}


</script>
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
            <div class="offcanvas__links">
                <a href="cinderella/shop/member/registform">Sign in</a>
                <a href="#">FAQs</a>
            </div>
            <div class="offcanvas__top__hover">
                <span>Usd <i class="arrow_carrot-down"></i></span>
                <ul>
                    <li>USD</li>
                    <li>EUR</li>
                    <li>USD</li>
                </ul>
            </div>
        </div>
        <div class="offcanvas__nav__option">
            <a href="#" class="search-switch"><img src="/cinderella/resources/img/icon/search.png" alt=""></a>
            <a href="#"><img src="/cinderella/resources/img/icon/heart.png" alt=""></a>
            <a href="#"><img src="/cinderella/resources/img/icon/cart.png" alt=""> <span>0</span></a>
            <div class="price">$0.00</div>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__text">
            <p>Free shipping, 30-day return or refund guarantee.</p>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-7">
                        <div class="header__top__left">
                            <p>Free shipping, 30-day return or refund guarantee.</p>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-5">
                        <div class="header__top__right">
                            <div class="header__top__links">
                            
                                <%if(session.getAttribute("member")==null){ //세션에 담겨진 데이터가 없다면%>
             					 	<a href="/cinderella/shop/member/loginForm">Sign in</a>
              					 <%}else{ %>
               						<a href="/cinderella/shop/member/logout">Sign out</a>
               					<%} %>

                                <a href="/cinderella/shop/member/registForm">Sign Up</a>
                                <a href="#">FAQs</a>
                            </div>
                            <div class="header__top__hover">
                                <span>Usd <i class="arrow_carrot-down"></i></span>
                                <ul>
                                    <li>USD</li>
                                    <li>EUR</li>
                                    <li>USD</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="/cinderella/resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li class="active"><a href="/cinderella/">Home</a></li>
                            
                            <li><a href="/cinderella/shop/product/list">Product</a>
                               <ul class="dropdown">
                                  <%for(int i=0; i<topList.size(); i++){ %>
                                  <%TopCategory topCategory = topList.get(i); %>
                                     <li class="dropbtn" onClick="myFunction()">
                                        <%=topCategory.getTopcategory_name()%>
                                  		<i class="fa fa-caret-down"></i>
		                                <div id="myDropdown" class="dropdown-content">
		                                	<%for(int j=0; j<topCategory.getSubCategory().size(); j++){ %>
		                                     <%SubCategory subCategory = topCategory.getSubCategory().get(j); %>
		                                  <a href="a href="/cinderella/shop/product/list?subcategory_id=<%=subCategory.getSubcategory_id()%>"><%=subCategory.getSubcategory_name() %></a>
		                                  <%} %>
		                                </div>
                            		</li>
                                      <%--<a href="/cinderella/shop/product/list?topcategory_id=<%=topCategory.getTopcategory_id()%>"><%=topCategory.getTopcategory_name()%></a> --%>
                                    <%} %> 
                                 </li>
                               </ul> 
                            </li>
                            
                            <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                            <li><a href="/cinderella/shop/preview">PhotoReview</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__nav__option">
                        <a href="#" class="search-switch"><img src="/cinderella/resources/img/icon/search.png" alt=""></a>
                        <a href="#"><img src="/cinderella/resources/img/icon/heart.png" alt=""></a>
                        <a href="#"><img src="/cinderella/resources/img/icon/cart.png" alt=""> <span>0</span></a>
                        <div class="price">$0.00</div>
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    </body>
</html> 