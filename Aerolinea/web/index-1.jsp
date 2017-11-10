<%@page import="mundo.vo.Vuelo"%>
<%@page import="mundo.dao.VueloDao"%>
<%@page import="java.util.List"%>
<%@page import="mundo.dao.IBaseDatos"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Hot Tours</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script>
		$(document).ready(function(){
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
		</script>
		<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
				<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
	</head>
	<body>
<!--==============================header=================================-->
		<header>
			<div class="container_12">
				<div class="grid_12">
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li>.</li>
								<li class="current"><a href="index.jsp">JEAV's Airways</a></li>
								<li><a href="index-1.jsp">TOURS</a></li>
								<li><a href="index-4.jsp">CONTACTENOS</a></li>
							</ul>
						</nav>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_12">
					<h1>
						<a href="index.jsp">
							<img src="images/logo.png" alt="Your Happy Family">
						</a>
					</h1>
				</div>
			</div>
		</header>
<!--==============================Content=================================-->
		<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
			<div class="container_12">
				<div class="banners">
                                    <%
                                        IBaseDatos v= new VueloDao();
                                    List<Vuelo> vuelos= v.findAll();
                                    for(int i=0; i<vuelos.size(); i++){
                                        out.println("<div class='grid_4'>"+
                                                "<div class='banner'>"+
                                                 "<form action='comprar' method='post'>"+
                                                    "<img src='"+vuelos.get(i).getImg()+"'>"+
                                                    "<div class='label'>"+
                                                        "<div class='title'>"+vuelos.get(i).getDestino()+"</div>"+
                                                        "<div class='price'>DESDE<span>$ "+(143/vuelos.get(i).getDisponiblesPromo())*200+"</span></div>"
                                                +       "<input type='hidden' name='idVuelo' value='"+vuelos.get(i).getCodigo()+"'>"+
                                                        "<a><button class='hidden'>COMPRAR</button></a>"
                                                    + "</form>"+
                                                    "</div>"+
                                                "</div>"+
                                            "</div>");
                                    }
                                    %>
				</div>
			</div>
		</div>
<!--==============================footer=================================-->
		<footer>
			<div class="container_12">
				<div class="grid_12">
					<div class="socials">
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>
					<div class="copy">
						Your Trip (c) 2014 | <a href="#">Privacy Policy</a> | Website Template Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
					</div>
				</div>
			</div>
		</footer>
		<script>
		$(function (){
			$('#bookingForm').bookingForm({
				ownerEmail: '#'
			});
		})
		</script>
	</body>
</html>