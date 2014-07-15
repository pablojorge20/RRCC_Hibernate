<%-- 
    Document   : graficar
    Created on : 10-jul-2014, 22:43:31
    Author     : pmedina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Gráficas</title>
</head>
<jsp:useBean id="myChartPie" scope="session" class="com.ui.servlets.graficas.PieChartGraphic" />
<body>
<h2>Gráficas
<!--String getChartViewer(HttpServletRequest request, HttpServletResponse response, String databean, int width, int height, String valueAxisLabel, String title, String categoryAxisLabel, boolean urls, boolean legend, boolean tooltips, boolean orientacionHorizonal, float R, float G,float B) { -->

<%String chartViewer3 = myChartPie.getChartViewer(request, response, "imagenData3",350,250,"value axis label2","Lu","categoria axis label",false,true,false,true,200,200,255);%>

<img src="<%=chartViewer3%>" border=0 usemap="#imageMap">
</body>
</html>
