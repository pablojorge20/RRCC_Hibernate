<%-- 
    Document   : Persona
    Created on : 18-mar-2014, 23:10:02
    Author     : pmedina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><s:text name="Persona"/></title>
            <sx:head/>

            <link rel="stylesheet" type="text/css" href="view.css" media="all">
                <script type="text/javascript" src="view.js"></script>
                <script type="text/javascript" src="calendar.js"></script>
                </head>
                <s:property value="accion"/>
                <s:form action="grabarPersona" method="post" theme="simple">
                    <s:hidden name="url" value="%{url}" />

                    <body id="main_body" >

                        <s:actionerror theme="mensaje" />
                        <s:actionmessage theme="mensaje" />
                        <strong>
                            Stakeholder - Personas
                        </strong>
                        <form id="form_813135" class="appnitro"  method="post" action="">
                            <div class="form_description">
                                <table  border="0" cellspacing="3" cellpadding="0">
                                    <s:hidden name="persona.id" value="%{persona.id}" theme="simple"/>    
                                    <tr>
                                        <td WIDTH=150>
                                            <label class="description" for="element_1">Fecha Registro </label> <br> <br> 
                                                    <label class="description" for="element_2">Nombre </label><br>  <br> 
                                                            <label class="description" for="element_2">Apellido </label><br>  <br> 
                                                                    <label class="description" for="element_2">Alias </label><br>  <br> 
                                                                            <label class="description" for="element_8">Nivel Influencia </label><br>  <br> 
                                                                                    <label class="description" for="element_8">Zona </label><br>  <br> 
                                                                                            </td>
                                                                                            <td WIDTH=150><s:textfield name="persona.FechaRegistro" value="%{persona.FechaRegistro}" size="15" disabled="true" maxLength="10" theme="simple"/><br>  <br> 
                                                                                                        <s:textfield name="persona.Nombre" value="%{persona.Nombre}" size="45" maxLength="45" theme="simple"/><br>  <br> 
                                                                                                                <s:textfield name="persona.Apellido" value="%{persona.Apellido}" size="45" maxLength="45" theme="simple"/><br>  <br> 
                                                                                                                        <s:textfield name="persona.Alias" value="%{persona.Alias}" size="20" maxLength="20" theme="simple"/><br>  <br> 
                                                                                                                                <s:select  list="LNinfluencia"
                                                                                                                                           listKey="id"
                                                                                                                                           listValue="Descripcion"
                                                                                                                                           name="persona.NInfluencia.id"
                                                                                                                                           value="%{persona.NInfluencia.id}"

                                                                                                                                           theme="simple"
                                                                                                                                           cssClass="texto"/>  <br>  <br> 
                                                                                                                                               <s:select  list="LZona"
                                                                                                                                                          listKey="id"
                                                                                                                                                          listValue="Descripcion"
                                                                                                                                                          name="persona.zona.id"
                                                                                                                                                          value="%{persona.zona.id}"

                                                                                                                                                          theme="simple"
                                                                                                                                                          cssClass="texto"/><br>  <br> 
                                                                                                                                                       </td>
                                                                                                                                                       <td WIDTH=150>
                                                                                                                                                           <label class="description" for="element_1">Identidad </label><br>  <br>  <br>  <br>  <br>  
                                                                                                                                                                               <label class="description" for="element_5">Tipo de Documento </label><br><br>    
                                                                                                                                                                                       <label class="description" for="element_2">Nro Documento </label><br>  <br>  
                                                                                                                                                                                               <label class="description" for="element_8">Estado </label><br>  <br>  
                                                                                                                                                                                                       </td>
                                                                                                                                                                                                       <td WIDTH=150>
                                                                                                                                                                                                        <s:textarea name="persona.Identidad" value="%{persona.Identidad}" wrap="true" rows="6" cols="50" maxLength="250" theme="simple"/>    <br>  <br>  
                                                                                                                                                                                                        <s:select  list="LTipo"
                                                                                                                                                                                                        listKey="id"
                                                                                                                                                                                                        listValue="Descripcion"
                                                                                                                                                                                                        name="persona.TDoumentoIdentidad.id"
                                                                                                                                                                                                        value="%{persona.TDoumentoIdentidad.id}"

                                                                                                                                                                                                        theme="simple"
                                                                                                                                                                                                        cssClass="texto"/>  <br>  <br>  
                                                                                                                                                                                                        <s:textfield name="Persona.NroDocumento" value="%{persona.NroDocumento}" size="12" maxLength="8" theme="simple"/><br>  <br>  
                                                                                                                                                                                                        <s:select  list="LEstado"
                                                                                                                                                                                                        listKey="id"
                                                                                                                                                                                                        listValue="Descripcion"
                                                                                                                                                                                                        name="persona.estado.id"
                                                                                                                                                                                                        value="%{persona.estado.id}"

                                                                                                                                                                                                        theme="simple"
                                                                                                                                                                                                        cssClass="texto"/> <br>  <br>  

                                                                                                                                                                                                        </td>
                                                                                                                                                                                                        </tr>
                                                                                                                                                                                                        <tr>
                                                                                                                                                                                                        <td></td>
                                                                                                                                                                                                        <td></td>
                                                                                                                                                                                                        <td></td>
                                                                                                                                                                                                        <td>
                                                                                                                                                                                                        <input type="reset"  value="Cancelar" style="width:100px;height:20px;background-color:#819FF7;color:white;font-size:10pt; font-family:Verdana;text-align:center;" />


                                                                                                                                                                                                        &nbsp;&nbsp;&nbsp;		    
                                                                                                                                                                                                        <input id="saveForm" class="button_text" type="submit" name="Guardar" value="Guardar" style="width:100px;height:20px;background-color:#819FF7;color:white;font-size:10pt; font-family:Verdana;text-align:center;" />

                                                                                                                                                                                                        </td>
                                                                                                                                                                                                        </tr>
                                                                                                                                                                                                        </table>
                                                                                                                                                                                                        </form>




                                                                                                                                                                                                        </s:form>      




                                                                                                                                                                                                        </body>

                                                                                                                                                                                                        </html>