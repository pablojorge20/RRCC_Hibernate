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

    
	<TABLE BORDER=0 WIDTH=600>


<TD WIDTH=200>
       
	<div id="form_container">
	
		
		<form id="form_813135" class="appnitro"  method="post" action="">
					<div class="form_description">
			 <br>&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Documentos
    </strong>
       
    <br>
                        <s:hidden name="documento.id" value="%{documento.id}" theme="simple"/>    
		</div>						
			<ul >
					
		<label class="description" for="element_1">Fecha Registro </label>
		<span>
			
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 <s:textfield name="documento.fechaRegistro" value="%{documento.fechaRegistro}" size="12" disabled="true" maxLength="10" theme="simple"/>
              
		 
		<br>
                    <br>
		<label class="description" for="element_2">Fecha recepcion </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <sx:datetimepicker name="documento.fechaRecepcion"  value="%{documento.fechaRecepcion}"  displayFormat="dd/MM/yyyy"/>
			
		</span>
		<br>
		 
		
		<label class="description" for="element_5">Tipo Documentos </label>
		&nbsp;&nbsp;&nbsp;
	<s:select  list="LTipo"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="documento.tipoDocumento.id"
                                   value="%{documento.tipoDocumento.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
	
		
		<br><label class="description" for="element_6">Remitente </label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <s:select  list="LRemitente"
                                   listKey="id"
                                   listValue="Nombre"
                                   name="documento.stakeholder.id"
                                   value="%{documento.stakeholder.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		
		<br>
		<label class="description" for="element_3">Observaciones </label>
		<div>
                     <s:textarea name="documento.observaciones" value="%{documento.observaciones}" rows="2" cols="50" maxLength="100" theme="simple"/>
			
		</div> 
		
		<label class="description" for="element_4">Asunto </label>
		<div>
                    <s:textarea name="documento.asunto" value="%{documento.asunto}" rows="2" cols="50" maxLength="100" theme="simple"/>
		
		</div> 
		
		<label class="description" for="element_7">Ingreso/Salida </label>
		<div>
	  <s:select  list="LIngreso"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="documento.ingreso.id"
                                   value="%{documento.ingreso.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		</div> 
		
		<label class="description" for="element_8">Criticidad </label>
		<div>
	  <s:select  list="LCriticidad"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="documento.criticidad.id"
                                   value="%{documento.criticidad.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
                    
		</div> 
                     <br>
		<label class="description" for="element_8">Estado </label>
		
	  <s:select  list="LEstado"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="documento.estado.id"
                                   value="%{documento.estado.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
		</div> 
		
			
			
</TD>

<TD WIDTH=250>
    		
		<label class="description" for="element_1">Fecha Caducidad </label>
                            <span>
			
                        
                        <sx:datetimepicker name="documento.fechaCaducidad"  value="%{documento.fechaCaducidad}"  displayFormat="dd/MM/yyyy"/>
                            </span>  
                            <BR>
                                <BR>
                <div>
<label class="description" for="element_1">Relacionado a: </label>
</div>
        
		<label class="description" for="element_5">Convenio </label>
		<div>
  <s:select  list="LConvenio"
                                   listKey="id"
                                   listValue="Asunto"
                                   name="documento.convenio.id"
                                   value="%{documento.convenio.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		</div> 
              
		<label class="description" for="element_5">Programa </label>
		<div>
		<div>
  <s:select  list="LPrograma"
                                   listKey="id"
                                   listValue="Asunto"
                                   name="documento.programa.id"
                                   value="%{documento.programa.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		</div> 
                
		<label class="description" for="element_5">Proyecto </label>
		<div>
<s:select  list="LProyecto"
                                   listKey="id"
                                   listValue="Asunto"
                                   name="documento.proyecto.id"
                                   value="%{documento.proyecto.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		</div> 
                
                
		<label class="description" for="element_5">Documento </label>
		<div>
<s:select  list="LDocumento"
                                   listKey="id"
                                   listValue="Asunto"
                                   name="documento.documento.id"
                                   value="%{documento.documento.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
		</div> 
       
</TD>
                
    <TR>
    <TD WIDTH=100>
        
        <input type="reset"  value="Cancelar" />
            		
			    <input type="hidden" name="form_id" value="813135" />
			    
				<input id="saveForm" class="button_text" type="submit" name="Guardar" value="Guardar" />
	</div>
	
            </form>	
        </TD>
        
            <TD WIDTH=100>
           <a href="StakeholderDoc.action?documento.id=<s:property value="%{documento.id}"/>">Hacer click para añadir Stakeholder &nbsp;&nbsp;<img src="imagenes/stakeholder.png" height="20" title="Documentos"/></a>        
           <BR>
<a href="AdjuntosDoc.action?documento.id=<s:property value="%{documento.id}"/>">Hacer click para añadir Adjuntos &nbsp;&nbsp;<img src="imagenes/aprobar.png" height="20" title="Documentos"/></a>             
     
	
        </TD>

        </TR>


          
                        
                 


</TABLE>

       


     </s:form>      
   
           
      
        
	</body>
        
</html>