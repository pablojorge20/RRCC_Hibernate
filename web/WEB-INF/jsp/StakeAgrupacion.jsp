<%-- 
    Document   : Agrupacion
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
<title><s:text name="Agrupacion"/></title>
<sx:head/>

<link rel="stylesheet" type="text/css" href="view.css" media="all">
<script type="text/javascript" src="view.js"></script>
<script type="text/javascript" src="calendar.js"></script>
</head>
  <s:property value="accion"/>
        <s:form action="grabarAgrupacion" method="post" theme="simple">
            <s:hidden name="url" value="%{url}" />
  
<body id="main_body" >
    
        <s:actionerror theme="mensaje" />
        <s:actionmessage theme="mensaje" />

    
	<TABLE BORDER=0 WIDTH=600>
			 <br>&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Stakeholder - Agrupaciones
    </strong>

<TD WIDTH=300>
       
	<div id="form_container">
	
		
		<form id="form_813135" class="appnitro"  method="post" action="">
					<div class="form_description">

       
    <br>
                        <s:hidden name="agrupacion.id" value="%{agrupacion.id}" theme="simple"/>    
		</div>						
			<ul >
					
		<label class="description" for="element_1">Fecha Registro </label>
		<span>
			
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 <s:textfield name="agrupacion.FechaRegistro" value="%{agrupacion.FechaRegistro}" size="15" maxLength="10" theme="simple"/>
              
		<br>
                    
                    <br>
		<label class="description" for="element_2">Nombre </label>
		<span>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <s:textfield name="agrupacion.Nombre" value="%{agrupacion.Nombre}" size="45" maxLength="45" theme="simple"/>
			
			
		</span>
		
                    <br>
		<label class="description" for="element_8">Nivel Influencia </label>
		
	  <s:select  list="LNinfluencia"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="agrupacion.NInfluencia.id"
                                   value="%{agrupacion.NInfluencia.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
                    
		</div> 
		
			
			
</TD>

<TD WIDTH=200>
    		
		<label class="description" for="element_1">Identidad </label>
                            <span>
			
                        <s:textfield name="agrupacion.Identidad" value="%{agrupacion.Identidad}" size="50" maxLength="100" theme="simple"/>    
                            </span>  
                <div>
<br>
    <label class="description" for="element_1">Ubicacion </label>
                            <span>
			
                        <s:textfield name="agrupacion.Ubicacion" value="%{agrupacion.Ubicacion}" size="50" maxLength="100" theme="simple"/>    
                            </span>  
</div>
        
                                      <br>
		<label class="description" for="element_8">Zona </label>
		
	  <s:select  list="LZona"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="agrupacion.zona.id"
                                   value="%{agrupacion.zona.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	
                    
		</div> 
                
                                           <br>
		<label class="description" for="element_8">Estado </label>
		
	  <s:select  list="LEstado"
                                   listKey="id"
                                   listValue="Descripcion"
                                   name="agrupacion.estado.id"
                                   value="%{agrupacion.estado.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
        	

    
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