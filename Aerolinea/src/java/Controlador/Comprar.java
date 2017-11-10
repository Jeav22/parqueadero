/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.dao.IBaseDatos;
import mundo.dao.PasajeDao;
import mundo.dao.VueloDao;
import mundo.vo.Pasaje;
import mundo.vo.Vuelo;

/**
 * Clase Payment: Es la encargada de manejar todo el pago y el paso posterior a finalizar la compra por medio de la aplicación Web.
 * @author Jorge Arenas 
 * @author Paola Vargas 
 * @author Alejandra Castillo
 * @author Alejandro Rodriguez
 * @author Nicolás Chicuazuque
 * @version 1
 */
@WebServlet(urlPatterns = {"/comprar"})

public class Comprar extends HttpServlet{
    private IBaseDatos v;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");  
            try (PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>\n" +
            "<html lang=\"es\">\n" +
            "	<head>\n" +
            "		<title>::Comprar::</title>\n" +
            "		<meta charset=\"utf-8\">\n" +
            "		<meta name=\"format-detection\" content=\"telephone=no\" />\n" +
            "		<link rel=\"icon\" href=\"images/favicon.ico\">\n" +
            "		<link rel=\"shortcut icon\" href=\"images/favicon.ico\" />\n" +
            "		<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
            "		<script src=\"js/jquery.js\"></script>\n" +
            "		<script src=\"js/jquery-migrate-1.2.1.js\"></script>\n" +
            "		<script src=\"js/script.js\"></script>\n" +
            "		<script src=\"js/superfish.js\"></script>\n" +
            "		<script src=\"js/jquery.ui.totop.js\"></script>\n" +
            "		<script src=\"js/jquery.equalheights.js\"></script>\n" +
            "		<script src=\"js/jquery.mobilemenu.js\"></script>\n" +
            "		<script src=\"js/jquery.easing.1.3.js\"></script>\n" +
            "		<script>\n" +
            "		$(document).ready(function(){\n" +
            "			$().UItoTop({ easingType: 'easeOutQuart' });\n" +
            "			});\n" +
            "		</script>\n" +
            "		<!--[if lt IE 8]>\n" +
            "		<div style=' clear: both; text-align:center; position: relative;'>\n" +
            "			<a href=\"http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode\">\n" +
            "				<img src=\"http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg\" border=\"0\" height=\"42\" width=\"820\" alt=\"You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today.\" />\n" +
            "			</a>\n" +
            "		</div>\n" +
            "		<![endif]-->\n" +
            "		<!--[if lt IE 9]>\n" +
            "		<script src=\"js/html5shiv.js\"></script>\n" +
            "		<link rel=\"stylesheet\" media=\"screen\" href=\"css/ie.css\">\n" +
            "		<![endif]-->\n" +
            "	</head>\n" +
            "	<body>\n" +
            "<!--==============================header=================================-->\n" +
            "		<header>\n" +
            "			<div class=\"container_12\">\n" +
            "				<div class=\"grid_12\">\n" +
            "					<div class=\"menu_block\">\n" +
            "						<nav class=\"horizontal-nav full-width horizontalNav-notprocessed\">\n" +
            "							<ul class=\"sf-menu\">\n" +
            "								<li>.</li>\n" +
            "								<li class=\"current\"><a href=\"index.jsp\">JEAV's Airways</a></li>\n" +
            "								<li><a href=\"index-1.jsp\">TOURS</a></li>\n" +
            "								<li><a href=\"index-4.jsp\">CONTACTENOS</a></li>\n" +
            "							</ul>\n" +
            "						</nav>\n" +
            "						<div class=\"clear\"></div>\n" +
            "					</div>\n" +
            "				</div>\n" +
            "				<div class=\"grid_12\">\n" +
            "					<h1>\n" +
            "						<a href=\"index.jsp\">\n" +
            "							<img src=\"images/logo.png\" alt=\"Your Happy Family\">\n" +
            "						</a>\n" +
            "					</h1>\n" +
            "				</div>\n" +
            "			</div>\n" +
            "		</header>\n" +
            "<!--==============================Content=================================-->\n" +
            "		<div class=\"content\"><div class=\"ic\">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>\n" +
            "			<div class='container_12'>\n"
                    + "<div class='clear'></div>\n"+
"				<div class='grid_3'>'\n"
                    + "<br>\n");
            if(req.getParameter("Comfort")== null){
            v= new VueloDao();  
            List<Vuelo> vuelos= v.findAll();
            Vuelo info = null;
            String idV= req.getParameter("idVuelo");
                for (Vuelo vuelo : vuelos) {
                    if(idV.equals(""+vuelo.getCodigo())){
                        info= vuelo;
                        out.print("<img src='"+vuelo.getImg()+"'>\n"
                                + "</div>\n"
                                + "<br>\n"
                                + "<div class='grid_3'>\n"
                                + "<br>\n"
                                + "<h2>"+vuelo.getDestino()+"</h2>\n"
                                + "<h1>Disponibiliadad: "+vuelo.getCantidad()+"</h1>\n"
                                + "<h1>Fecha: "+vuelo.getFecha()+"</h1>\n"
                                + "<br>\n"
                                + "<p>Promo "+vuelo.getDisponiblesPromo()+"\n"
                                + "Econo "+vuelo.getDisponiblesEcono()+"    \n"
                                + "Flexi "+vuelo.getDisponiblesFlexi()+"</p>\n"
                                + "<ul>\n"
                                + "<li><p>Los pasajes vendidos como Promo no son reembolsables</p></li>\n" +
                                "<li><p>Los pasajes vendidos como Econo son reembolsables pero tiene una multa de $100.000</p></li>\n" +
                                "<li><p>Los pasajes vendidos como Flexi son reembolsables pero tiene una multa de $70.000</p></li>"
                                + "</ul>"
                                + "</div>\n");
                    }
                }
            
            out.print("<div class=\"grid_5 prefix_1\">\n" +
"					<h4>FORMATO DE COMPRA</h4>\n" +
"					<form id=\"bookingForm\" action=\"comprar\" method=\"post\">\n" +
"						<div class=\"fl1\">\n" +
"							<div class=\"tmInput\">\n" +
"								<input name=\"nombre\" placeHolder=\"Nombre:\" type=\"text\" data-constraints='@NotEmpty @Required @AlphaSpecial' required>\n" +
"							</div>\n" +
"						</div>\n" +
"						<div class=\"clear\"></div>\n" +
"						<div class=\"tmRadio\">\n" +
"							<p>Comfort</p>\n" +
"							<input name=\"Comfort\" type=\"radio\" value=\"econo\" id=\"tmRadio0\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' checked/>\n" +
"							<span>Econo:$ "+(143/info.getDisponiblesEcono())*800+"</span>\n"
                    + "                                 <br>" +
"							<input name=\"Comfort\" type=\"radio\" value=\"promo\" id=\"tmRadio1\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' />\n" +
"							<span>Promo :$ "+(143/info.getDisponiblesPromo())*200+"</span>\n" 
                    + "                                 <br>" +
"							<input name=\"Comfort\" type=\"radio\" value=\"flexi\" id=\"tmRadio2\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' />\n"
                    + "                                  <input type='hidden' name='fecha' value='"+info.getFecha()+"'>"
                    + "                                  <input type='hidden' name='vuelo' value='"+info.getCodigo()+"'>"
                    + "                                  <input type='hidden' name='Comfort' value='"+req.getParameter("Comfort")+"'>"
                    + "                                  <input type='hidden' name='cantidad' value='"+info.getCantidad()+"'>"
                    + "                                  <input type='hidden' name='Vpromo' value='"+(143/info.getDisponiblesPromo())*200+"'>"
                    + "                                  <input type='hidden' name='Vecono' value='"+(143/info.getDisponiblesEcono())*800+"'>"+
                    "                                    <input type='hidden' name='Vflexi' value='"+(143/info.getDisponiblesFlexi())*2100+"'>" +
"							<span>Flexi :$ "+(143/info.getDisponiblesFlexi())*2100+"</span>\n" +
"						</div>\n"+
"						<div class=\"clear\"></div>\n" +
"                                                <input class=\"btn\" type=\"submit\" value=\"Enviar\">\n" +
"					</form>\n" +
"				</div>"+
                    "</div>\n" +
            "		</div>\n");
            }else{
                if("Flexi".equalsIgnoreCase(req.getParameter("Comfort")) && req.getParameter("silla")==null){
                        int x=Integer.parseInt(req.getParameter("cantidad"));
                    out.print("<h3>Seleccion de Silla</h3>");
                    out.print("<form action='comprar' method='post'>");
                    int y=x/4;
                    int aux=1;
                    for (int i = 0; i < y; i++) {
                        for (int j = 0; j < 4; j++) {
                            out.print("<input type='hidden' name='silla' value='"+aux+"'>"
                                    +"<input type='hidden' name='Comfort' value='"+req.getParameter("Comfort")+"'>"
                                    +"<input type='hidden' name='fecha' value='"+req.getParameter("fecha")+"'>"
                                    +"<input type='hidden' name='nombre' value='"+req.getParameter("nombre")+"'>"
                                    +"<input type='hidden' name='vuelo' value='"+req.getParameter("vuelo")+"'>"
                                    +"<input type='hidden' name='valor' value='"+req.getParameter("Vflexi")+"'>");
                            
                            out.print("&nbsp&nbsp&nbsp&nbsp"
                                    + "<input type='submit' value='"+(aux++)+"'>");
                        }              
                        out.print("<br>\n");
                    }
                    out.print("</form>");
                }else{
                    out.print("<div class='grid_8 prefix_4'>"
                            + "<h1>Compra realizada con exito</h1>\n"
                            + "<h4>Pasajero: "+req.getParameter("nombre")+"</h4>"
                            + "<p> Comfort :"+req.getParameter("Comfort")+"</p>\n"
                            + "<p> Fecha :"+req.getParameter("fecha")+"</p>\n"
                            + "</div>"
                            + "<button title='Volver' class='btn'><a href='/Aerolinea/index.jsp'>Volver</a></button>\n");
                    Pasaje pasaje= new Pasaje();
                    pasaje.setPasajero(req.getParameter("nombre"));
                    pasaje.setVuelo(Integer.parseInt(req.getParameter("vuelo")));
                    if(req.getParameter("Comfort").equalsIgnoreCase("promo")){
                        pasaje.setTipo(1);
                        pasaje.setValor(Double.parseDouble(req.getParameter("Vpromo")));
                    }else if(req.getParameter("Comfort").equalsIgnoreCase("econo")){
                        pasaje.setTipo(2);
                        pasaje.setValor(Double.parseDouble(req.getParameter("Vecono")));
                    }else{
                        pasaje.setTipo(3);
                        pasaje.setValor(Double.parseDouble(req.getParameter("valor")));
                    }
                    IBaseDatos p= new PasajeDao();
                    p.insert(pasaje);
                    List<Vuelo> vuelos= v.findAll();
                    for (Vuelo vuelo : vuelos) {
                       if(req.getParameter("vuelo").equals(""+vuelo.getCodigo())){
                           if (req.getParameter("Comfort").equalsIgnoreCase("econo")) {
                               vuelo.setDisponiblesEcono(vuelo.getDisponiblesEcono()-1);
                           }else if (req.getParameter("Comfort").equalsIgnoreCase("promo")) {
                               vuelo.setDisponiblesPromo(vuelo.getDisponiblesPromo()-1);
                           }else if (req.getParameter("Comfort").equalsIgnoreCase("flexi")) {
                               vuelo.setDisponiblesFlexi(vuelo.getDisponiblesFlexi()-1);
                           }
                           IBaseDatos v= new VueloDao();
                           v.update(vuelo);
                       }
                    }
                }
            }            
            out.print("<!--==============================footer=================================-->\n" +
            "		<footer>\n" +
            "			<div class=\"container_12\">\n" +
            "				<div class=\"grid_12\">\n" +
            "					<div class=\"socials\">\n" +
            "						<a href=\"#\" class=\"fa fa-facebook\"></a>\n" +
            "						<a href=\"#\" class=\"fa fa-twitter\"></a>\n" +
            "						<a href=\"#\" class=\"fa fa-google-plus\"></a>\n" +
            "					</div>\n" +
            "					<div class=\"copy\">\n" +
            "						Your Trip (c) 2014 | <a href=\"#\">Privacy Policy</a> | Website Template Designed by <a href=\"http://www.templatemonster.com/\" rel=\"nofollow\">TemplateMonster.com</a>\n" +
            "					</div>\n" +
            "				</div>\n" +
            "			</div>\n" +
            "		</footer>\n" +
            "		<script>\n" +
            "		$(function (){\n" +
            "			$('#bookingForm').bookingForm({\n" +
            "				ownerEmail: '#'\n" +
            "			});\n" +
            "		})\n" +
            "		</script>\n" +
            "	</body>\n"
                    + "\n" +
"		<script>\n" +
"			$(function (){\n" +
"				$('#bookingForm').bookingForm({\n" +
"					ownerEmail: '#'\n" +
"				});\n" +
"			})\n" +
"		</script>"+
            "</html>");
        }
    }
}
