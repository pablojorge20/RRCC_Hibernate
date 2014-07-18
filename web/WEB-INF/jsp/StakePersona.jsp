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

    
	<TABLE BORDER=0 WIDTH=600>
			 <br>&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Stakeholder - Personas
    </strong>

<TD WIDTH=300>
       
	<div id="form_container">
	
		
		<form id="form_813135" class="appnitro"  method="post" action="">
					<div class="form_description">

       
    <br>
                        <s:hidden name="persona.id" value="%{persona.id}" theme="simple"/>    
		</div>						
			<ul >
					
		<label class="description" for="element_1">Fecha Registro </label>
		<span>
			
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 <s:textfield name="persona.FechaRegistro" value="%{persona.FechaRegistro}" size="15" disabled="true" maxLength="10" theme="simple"/>
              
		<br>
                    
		<label class="description" for="element_2">Nombre </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <s:textfield name="persona.Nombre" value="%{persona.Nombre}" size="45" maxLength="45" theme="simple"/>
			
			
		</span>
		<br>
		<label class="description" for="element_2">Apellido </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <s:textfield name="persona.Apellido" value="%{persona.Apellido}" size="45" maxLength="45" theme="simple"/>
			
			
		</span>
		 <br>
                     <br>
		<label class="description" for="element_2">Alias </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <s:textfield name="persona.Alias" value="%{persona.Alias}" size="20" maxLength="20" theme="simple"/>
			
			
		</span>
		<br>
                    <br>
		<label class="description" for="element_8">Nivel Influencia </label>
		
	  <s:select  list="LNinfluencia"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="persona.NInfluencia.id"
                                   value="%{persona.NInfluencia.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
                    
		</div> 
		
           <br>
		<label class="description" for="element_8">Zona </label>
		
	  <s:select  list="LZona"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="persona.zona.id"
                                   value="%{persona.zona.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
                    
		</div> 
	  	
			
</TD>

<TD WIDTH=200>
    		
		<label class="description" for="element_1">Identidad </label>
                            <span>
			<br>
                        <s:textarea name="persona.Identidad" value="%{persona.Identidad}" wrap="true" rows="6" cols="50" maxLength="250" theme="simple"/>    
                            </span>  
                <div>
<br>
</div>
        

              
		<label class="description" for="element_5">Tipo de Documento </label>
		
		
  <s:select  list="LTipo"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="persona.TDoumentoIdentidad.id"
                                   value="%{persona.TDoumentoIdentidad.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
	
                		 <br>
                                     <br>
		<label class="description" for="element_2">Nro Documento </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <s:textfield name="Persona.NroDocumento" value="%{persona.NroDocumento}" size="15" maxLength="10" theme="simple"/>
			
			
		</span>
                   
                    <br>
                        <br>
                           
		<label class="description" for="element_8">Estado </label>
		
	  <s:select  list="LEstado"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="persona.estado.id"
                                   value="%{persona.estado.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
                    
		</div> 	
    
</TD>
                
    <TR>
    <TD WIDTH=100>
        <br>
            
        
        <input type="reset"  value="Cancelar" />
            		
			    <input type="hidden" name="form_id" value="813135" />
			    
				<input id="saveForm" class="button_text" type="submit" name="Guardar" value="Guardar" />
	</div>
	
            </form>	
        </TD>
        
            <TD WIDTH=100>
     
	
        </TD>

        </TR>


          
                        
                 


</TABLE>

       


     </s:form>      
   
           
      
        
	</body>
        
</html>