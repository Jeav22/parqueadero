<%@page import="java.util.Random"%>
<%@page import="mundo.dao.VueloDao"%>
<%@page import="mundo.dao.IBaseDatos"%>
<%@page import="mundo.vo.Vuelo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>JEAV´s Airways</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="booking/css/booking.css">
		<link rel="stylesheet" href="css/camera.css">
		<link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/owl.carousel.js"></script>
		<script src="js/camera.js"></script>
		<!--[if (gt IE 9)|!(IE)]><!-->
		<script src="js/jquery.mobile.customized.min.js"></script>
		<!--<![endif]-->
		<script src="booking/js/booking.js"></script>
		<script>
			$(document).ready(function(){
			jQuery('#camera_wrap').camera({
				loader: false,
				pagination: false ,
				minHeight: '444',
				thumbnails: false,
				height: '48.375%',
				caption: true,
				navigation: true,
				fx: 'mosaic'
			});
			/*carousel*/
			var owl=$("#owl");
				owl.owlCarousel({
				items : 2, //10 items above 1000px browser width
				itemsDesktop : [995,2], //5 items between 1000px and 901px
				itemsDesktopSmall : [767, 2], // betweem 900px and 601px
				itemsTablet: [700, 2], //2 items between 600 and 0
				itemsMobile : [479, 1], // itemsMobile disabled - inherit DESDE itemsTablet option
				navigation : true,
				pagination : false
				});
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
	<body class="page1" id="top">
<!--==============================header=================================-->
		<header>
			<div class="container_12">
				<div class="grid_12">
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li>.</li>
								<li class="current"><a href="index.jsp">JEAV´s Airways</a></li>
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
		<div class="slider_wrapper">
			<div id="camera_wrap" class="">
				<div data-src="images/slide.jpg">
					<div class="caption fadeIn">
						<h2>LONDRES</h2>
					</div>
				</div>
				<div data-src="images/slide1.jpg">
					<div class="caption fadeIn">
						<h2>Maldivas</h2>
					</div>
				</div>
				<div data-src="images/slide2.jpg">
					<div class="caption fadeIn">
						<h2>Venecia</h2>
					</div>
				</div>
			</div>
		</div>
<!--==============================Content=================================-->
		<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
			<div class="container_12">
				<%
                                    IBaseDatos v= new VueloDao();
                                    List<Vuelo> vuelos= v.findAll();
                                    for(int i=0; i<3; i++){
                                        Random r= new Random();
                                        int x= r.nextInt(vuelos.size()-1);
                                        out.println("<div class='grid_4'>"+
                                                "<div class='banner'>"
                                                + "<form action='comprar' method='post'>"+
                                                    "<img src='"+vuelos.get(x).getImg()+"'>"+
                                                    "<div class='label'>"+
                                                        "<div class='title'>"+vuelos.get(x).getDestino()+"</div>"+
                                                        "<div class='price'>DESDE<span>$ "+(143/vuelos.get(x).getDisponiblesPromo())*200+"</span></div>"
                                                +       "<input type='hidden' name='idVuelo' value='"+vuelos.get(x).getCodigo()+"'>"+
                                                        "<a><button class='hidden'>COMPRAR</button></a>"
                                                    + "</form>"+
                                                        "</div>"+
                                                    "</div>"+
                                                "</div>");
                                    }
                                %>
				<div class="clear"></div>
				<div class="grid_6">
					<h3>FORMATO DE REEMBOLSO</h3>
					<form id="bookingForm" action="reembolso" method="post">
						<div class="fl1">
							<div class="tmInput">
                                                            <input name="nombre" placeHolder="Nombre:" type="text" data-constraints='@NotEmpty @Required @AlphaSpecial' required="">
							</div>
						</div>
						<div class="fl1">
							<div class="tmInput mr0">
                                                            <input name="destino" placeHolder="Destino:" type="text" data-constraints="@NotEmpty @Required" required="">
							</div>
						</div>
						<div class="clear"></div>
						<div class="tmRadio">
							<p>Comfort</p>
							<input name="Comfort" type="radio" value="econo" id="tmRadio0" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' checked/>
							<span>Econo</span>
							<input name="Comfort" type="radio" value="Promo" id="tmRadio1" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' />
							<span>Promo</span>
							<input name="Comfort" type="radio" value="flexi" id="tmRadio2" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' />
							<span>Flexi</span>
						</div>
						<div class="clear"></div>
                                                <input class="btn" type="submit" value="Enviar">
					</form>
				</div>
				<div class="grid_5 prefix_1">
					<h3>BIENVENIDO
					</h3>
					<img src="images/page1_img1.jpg" alt="" class="img_inner fleft">
					<div class="extra_wrapper">
						<p>Lorem ipsum dolor sit ere amet, consectetur ipiscin.</p>
						In mollis erat mattis neque facilisis, sit ametiol
					</div>
					<div class="clear cl1"></div>
					<p>Find the detailed description of this <span class="col1"><a href="http://blog.templatemonster.com/free-website-templates/" rel="dofollow">freebie</a></span> at TemplateMonster blog.</p>
					<p><span class="col1"><a href="http://www.templatemonster.com/category/travel-website-templates/" rel="nofollow">Travel Website Templates</a></span> category offers you a variety of designs that are perfect for travel sphere of business.</p>
					Proin pharetra luctus diam, a scelerisque eros convallis
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
						Your Trip (c) 2014 | <a href="#">Privacy Policy</a> | Website Template Designed by <a href="#" rel="nofollow">TemplateMonster.com</a>
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

