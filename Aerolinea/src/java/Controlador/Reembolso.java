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
import mundo.vo.Econo;
import mundo.vo.Flexi;
import mundo.vo.Pasaje;
import mundo.vo.Vuelo;

/**
 *
 * @author JEAV
 */

@WebServlet(name = "reembolso", urlPatterns = {"/reembolso"})
public class Reembolso extends HttpServlet{
    private IBaseDatos p;
    private IBaseDatos v;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        p= new PasajeDao();
        v= new VueloDao();
        String error="<div class='grid_5'>"
                                     + "<h3>No se ha encontrado</h3>"
                                + "<div class=\"label\">\n" +
"				<button title='Volver' class='btn'><a href='/Aerolinea/index.jsp'>Volver</a></button>\n" +
"                               </div>"
                                     + "</div>"
                                     + "<div class='grid_5 prefix_1'>"+
"					<h3>FORMATO DE REEMBOLSO</h3>\n" +
"					<form id=\"bookingForm\" action=\"reembolso\" method=\"post\">\n" +
"						<div class=\"fl1\">\n" +
"							<div class=\"tmInput\">\n" +
"								<input name=\"nombre\" placeHolder=\"Nombre Pasajero:\" type=\"text\" data-constraints='@NotEmpty @Required @AlphaSpecial' required>\n" +
"								<input name=\"destino\" placeHolder=\"Destino:\" type=\"text\" data-constraints=\"@NotEmpty @Required\" required>\n" +
"							</div>\n" +
"						</div>\n" +
                                     "		<div class=\"clear\"></div>\n" +
                                     "		<br>\n" +
"						<div class=\"tmRadio\">\n" +
"							<p>Comfort</p>\n" +
"							<input name=\"Comfort\" type=\"radio\" value=\"econo\" id=\"tmRadio0\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' checked/>\n" +
"							<span>Econo</span>\n" +
"							<input name=\"Comfort\" type=\"radio\" value=\"Promo\" id=\"tmRadio1\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' />\n" +
"							<span>Promo</span>\n" +
"							<input name=\"Comfort\" type=\"radio\" value=\"flexi\" id=\"tmRadio2\" data-constraints='@RadioGroupChecked(name=\"Comfort\", groups=[RadioGroup])' />\n" +
"							<span>Flexi</span>\n" +
"						</div>\n" +
"						<div class=\"clear\"></div>\n" +
"                                                <input class=\"btn\" type=\"submit\" value=\"Enviar\">\n" +
"					</form>\n"
                            + "</div>";
        try (PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>\n" +
            "<html lang=\"es\">\n" +
            "	<head>\n" +
            "		<title>Reembolso</title>\n" +
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
            "			<div class=\"container_12\">\n");
            List<Vuelo> vuelos = v.findAll();
            List<Pasaje> pasajes = p.findAll();
            String nombre= req.getParameter("nombre");
            String destino= req.getParameter("destino");
            String tipo= req.getParameter("Comfort");
            out.println("<br>"
                    + "<h2>Reembolsos</h2>");
            for (Vuelo vuelo : vuelos) {
                if(vuelo.getDestino().equalsIgnoreCase(destino)){
                    for (Pasaje pasaje : pasajes) {
                        if (nombre.equalsIgnoreCase(pasaje.getPasajero()) && vuelo.getCodigo()== pasaje.getVuelo()) {
                        //out.print(pasaje.getPasajero()+" "+tipo+""+pasaje.getTipo()+" "+vuelo.getDestino());
                            if("promo".equalsIgnoreCase(tipo) && 1==pasaje.getTipo()){
                                out.println("<h3>La clase promo no posee devolucion</h3>"
                                        + "<button title='Volver' class='btn'><a href='/Aerolinea/index.jsp'>Volver</a></button>\n");
                                break;
                            }else if("econo".equalsIgnoreCase(tipo) && 2==pasaje.getTipo()){
                                Econo reembolso= new Econo(vuelo.getCodigo(), pasaje.getValor(), vuelo.getDestino(), vuelo.getDisponiblesEcono(), vuelo.getCodigo());
                                double retorno= reembolso.calcularReembolso();
                                
                                out.print("<h3>La devolucion se ha logrado con exito!</h3>"
                                        + "<p>Pasajero: "+nombre+"</p>"
                                        + "<p>Destino: "+destino+"</p>"
                                        + "<p>Fecha: "+vuelo.getFecha()+"</p>"
                                        + "<h4>Clase: "+tipo+"</h4>"
                                        + "<p>Al pasaje se le resto el valor de la multa por de $100</p>"
                                        + "<br>"
                                        + "<p>Su devolucion se realizo por valor de $"+retorno+"</p>"
                                        + "<button title='Volver' class='btn'><a href='/Aerolinea/index.jsp'>Volver</a></button>\n");
                                break;
                            }else if("flexi".equals(tipo)&& 3==pasaje.getTipo()){
                                Flexi reembolso= new Flexi(null,vuelo.getCodigo(), pasaje.getValor(), vuelo.getDestino(), vuelo.getDisponiblesEcono(), vuelo.getCodigo());
                                double retorno= reembolso.calcularReembolso();
                                
                                out.print("<h3>la devolucion se ha logrado con exito!</h3>"
                                        + "<p>Pasajero: "+nombre+"</p>"
                                        + "<p>Destino: "+destino+"</p>"
                                        + "<p>Fecha: "+vuelo.getFecha()+"</p>"
                                        + "<h4>Clase: "+tipo+"</h4>"
                                        + "<p>Al pasaje se le resto el valor de la multa por de $70</p>"
                                        + "<br>"
                                        + "<p>Su devolucion se realizo por valor de $"+retorno+"</p>"
                                        + "<button title='Volver' class='btn'><a href='/Aerolinea/index.jsp'>Volver</a></button>\n");
                                break;
                            }else{
                                out.print(error);
                                break;
                            }
                        }else if(pasajes.indexOf(pasaje)== pasajes.size()-1){
                             out.println(error);
                             break;
                }
                    }
                    break;
                }else if(vuelos.indexOf(vuelo)== vuelos.size()-1){
                    out.println(error);
                    break;
                }
            }
            out.print("			</div>\n" +
            "		</div>\n" +
            "<!--==============================footer=================================-->\n" +
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
"		</script>" +
            "</html>");
        }
    }
}
