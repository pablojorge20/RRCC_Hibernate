<%-- 
    Document   : Documento
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
            <title><s:text name="Documento"/></title>
            <sx:head/>

            <link rel="stylesheet" type="text/css" href="view.css" media="all">
                <script type="text/javascript" src="view.js"></script>
                <script type="text/javascript" src="calendar.js"></script>
                </head>
                <s:property value="accion"/>
                <s:form action="grabar" method="post" theme="simple">
                    <s:hidden name="url" value="%{url}" />

                    <body id="main_body" >

                        <s:actionerror theme="mensaje" />
                        <s:actionmessage theme="mensaje" />
                        <form id="form_813135" class="appnitro"  method="post" action="">
                            <br>&nbsp;&nbsp;<s:text name="Usted esta en :"/>
                                <strong>
                                    Documentos
                                </strong>
                                
                                <s:hidden name="documento.id" value="%{documento.id}" theme="simple"/>   
                                 <s:hidden name="documento.eliminado" value="%{documento.eliminado}" theme="simple"/>   
                                 
                                <table border="0">
                                    <tr>
                                        <td WIDTH=150>
                                            <label class="description" for="element_1">Fecha Registro </label>  <br>  <br>  
                                            <label class="description" for="element_2">Fecha recepcion </label> <br>  <br>  
                                            <label class="description" for="element_5">Tipo Documentos </label> <br>  <br>  
                                            <label class="description" for="element_6">Remitente </label> <br>  <br>  
                                            <label class="description" for="element_3">Observaciones </label> <br>  <br> <br>  
                                            <label class="description" for="element_4">Asunto </label> <br>  <br>  <br>  
                                            <label class="description" for="element_7">Ingreso/Salida </label> <br>  <br>  
                                            <label class="description" for="element_8">Criticidad </label> <br>  <br>  
                                            <label class="description" for="element_8">Estado </label> <br>    
                                        </td>
                                        <td WIDTH=150>
                                        <br>  
                                          <s:textfield name="documento.fechaRegistro" value="%{documento.fechaRegistro}" size="12" disabled="true" maxLength="10" theme="simple"/> <br>  <br>  
                                            <sx:datetimepicker name="documento.fechaRecepcion"  value="%{documento.fechaRecepcion}"  displayFormat="dd/MM/yyyy"/> <br>  <br>  
                                            <s:select  list="LTipo"
                                               listKey="id"
                                               listValue="Descripcion"
                                               name="documento.tmTipoDocumentoid.id"
                                               value="%{documento.tmTipoDocumentoid.id}"

                                               theme="simple"
                                               cssClass="texto"/>   <br>  <br>  
                                       <s:select  list="LRemitente"
                                                  listKey="id"
                                                  listValue="Nombre+' '+Apellido"
                                                  name="documento.tmStakePersonaid.id"
                                                  value="%{documento.tmStakePersonaid.id}"

                                                  theme="simple"
                                                  cssClass="texto"/>  <br>  <br>  
                                                      <s:textarea name="documento.observaciones" value="%{documento.observaciones}" rows="2" cols="50" maxLength="100" theme="simple"/> <br>  <br>  
                                                <s:textarea name="documento.asunto" value="%{documento.asunto}" rows="2" cols="50" maxLength="100" theme="simple"/> <br>  <br>  
                                                <s:select  list="LIngreso"
                                                          listKey="id"
                                                          listValue="Descripcion"
                                                          name="documento.ingresoSalida"
                                                          value="%{documento.ingresoSalida}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  
                                                          <s:select  list="LCriticidad"
                                                          listKey="id"
                                                          listValue="Descripcion"
                                                          name="documento.criticidadid.id"
                                                          value="%{documento.criticidadid.id}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  
                                                          <s:select  list="LEstado"
                                                          listKey="id"
                                                          listValue="Descripcion"
                                                          name="documento.tmEstadoid.id"
                                                          value="%{documento.tmEstadoid.id}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  

                                                          </td>
                                                          <td WIDTH=150>
                                                          <br> 
                                                          <label class="description" for="element_1">Fecha Caducidad </label> <br>  <br> <br>  <br>    
                                                          <label class="description" for="element_1">Relacionado a: </label> <br>  <br>  
                                                          <label class="description" for="element_5">Convenio </label> <br>  <br>  
                                                          <label class="description" for="element_5">Programa </label> <br>  <br>  
                                                          <label class="description" for="element_5">Proyecto </label> <br>  <br>  
                                                          <label class="description" for="element_5">Documento </label> <br>  <br>  <br>  <br>  <br>  <br>  <br> 
                                                          </td>
                                                          <td WIDTH=150>
                                                          <sx:datetimepicker name="documento.fechaCaducidad"  value="%{documento.fechaCaducidad}"  displayFormat="dd/MM/yyyy"/> <br>  <br>  <br>  <br>  <br>  <br>  
                                                          <s:select  list="LConvenio"
                                                          listKey="id"
                                                          listValue="Asunto"
                                                          name="documento.refConvenio"
                                                          value="%{documento.refConvenio}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  
                                                          <s:select  list="LPrograma"
                                                          listKey="id"
                                                          listValue="Asunto"
                                                          name="documento.refPrograma"
                                                          value="%{documento.refPrograma}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  
                                                          <s:select  list="LProyecto"
                                                          listKey="id"
                                                          listValue="Asunto"
                                                          name="documento.refProyecto"
                                                          value="%{documento.refProyecto}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>  
                                                          <s:select  list="LDocumento"
                                                          listKey="id"
                                                          listValue="Asunto"
                                                          name="documento.refDocumento"
                                                          value="%{documento.refDocumento}"

                                                          theme="simple"
                                                          cssClass="texto"/>   <br>  <br>   <br>  <br>  <br>  <br>   

                                                          </td>
                                                          </tr>
                                                          <tr>
                                                          <td></td>
                                                          <td>
                                                          <a href="StakeholderDoc.action?documento.id=<s:property value="%{documento.id}"/>">Hacer click para añadir Stakeholder &nbsp;&nbsp;<img src="imagenes/stakeholder.png" height="20" title="Documentos"/></a>        
                                                          <BR>
                                                          <a href="AdjuntosDoc.action?documento.id=<s:property value="%{documento.id}"/>">Hacer click para añadir Adjuntos &nbsp;&nbsp;<img src="imagenes/aprobar.png" height="20" title="Documentos"/></a>             
                                                          </td>
                                                          <td></td>
                                                          <td>
                                                          <input type="reset"  value="Cancelar" style="width:100px;height:20px;background-color:#819FF7;color:white;font-size:10pt; font-family:Verdana;text-align:center;"/>

                                                          <input type="hidden" name="form_id" value="813135" />

                                                          <input id="saveForm" class="button_text" type="submit" name="Guardar" value="Guardar" style="width:100px;height:20px;background-color:#819FF7;color:white;font-size:10pt; font-family:Verdana;text-align:center;"/>



                                                          </td>
                                                          </tr>
                                                          </table>  
                                                          </form>




                                                          </s:form>      




                                                          </body>

                                                          </html>