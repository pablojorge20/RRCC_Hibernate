<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="token-input.css" rel="stylesheet" type="text/css" />
    <link href="token-input-facebook.css" rel="stylesheet" type="text/css" />    
    <link href="token-input-mac.css" rel="stylesheet" type="text/css" />    
    
    <link href="easyui-1.3.4.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="icon.css" rel="stylesheet" type="text/css" media="screen" />
    
    <title><s:text name="label.tituloSistema"/></title>
    <decorator:head/>
</head>
<script type="text/javascript" src="js/funciones.js" charset="ISO-8859-1"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.js"></script>
<script type="text/javascript" src="js/jquery.tooltip.js"></script>
<script type="text/javascript" src="js/jqFancyTransitions.1.8.js"></script>

<script type="text/javascript" src="js/jquery.easyui.min-1.3.4.js"></script>

<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.1.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/datagrid-detailview.js"></script>
<script type="text/javascript" src="js/datagrid-groupview.js"></script>
<script type="text/javascript" src="js/highcharts/highcharts.3.0.5.js"></script>
<script type="text/javascript" src="js/highcharts/modules/exporting.3.0.5.js"></script>

<script type="text/javascript" src="js/jquery.tokeninput.js"></script>

<script type="text/javascript" src="js/treegrid-dnd.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>

<script type="text/javascript">
    
function resizeLayout()
{
    try
    {
        //$('#idLayoutPlan').layout('resize');
        //$('#idLayoutPlan').expand('center');
        //$('#idLayoutPlan').layout();        
    }
    catch(e)
    {
        alert(e);
    }
    
}

$(function() {

    $('#treeFuncLogin').tree(
    {
        url: 'getFuncionalidadesLoginTreeJSON.action',
        animate:true,
        formatter:function(node)
        {
            var bIsLeaf = $(this).tree('isLeaf', node.target);
            if (node.children)
            {
                return node.text;

            }
            else
            {
                return '<a href="'+node.accion+'.action">'+node.text+'</a>';
            }
        }            
    }); 
});

    
</script>

<body>
<div id="wrapper" style="width: 100%; 
                         padding: 0px auto 0 auto;
                         margin: 0px auto 0 auto;">

    <div id="page" style="width: 100%; padding: 0px 0px 15px 0px;">
        <div id="page-bgbtm">
            <div id="idLayoutPlan" class="easyui-layout" style="width:auto;height: 100%">
                <div data-options="region:'north'" border="false">
                    <table width="100%" style="background-color: #C8C8C8;">
                        <tr>
                            
                            <td><img src="imagenes/planCompras.png" style="height: 38px;"></td>
                            <td align="right">
                                <s:if test='#session.usuario!=null'>
                                        Usuario: <span style="color: black;"><s:property value="#session.usuario.cuenta"/></span>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <img src="https://sas.celepsa.com/SALUDO/fotos/<s:property value="#session.usuario.cuenta"/>.jpg" style="height: 38px; vertical-align: middle;">
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <s:url action="logout" id="url" escapeAmp="false"/>
                                        <a href="<s:property value="#url"/>"><img style="vertical-align: middle;" src="imagenes/logout2.png" title="Salir del sistema"/></a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                </s:if>                                                        
                            </td>
                        </tr>
                    </table>                    
                </div>            
                <div data-options=" region:'west',
                                    title:'Opciones',
                                    split:true,
                                    collapsed:true,
                                    onCollapse: function() { resizeLayout(); }, 
                                    onExpand: function() { resizeLayout(); } " style="width: 270px;" border="false">
                    <ul id="treeFuncLogin"  class="easyui-tree"></ul>
                </div>
                <div data-options="region:'center',split:true" border="false">
                    <decorator:body/>
                </div>                            
            </div>            
                
            <!-- end #footer -->
            <div style="clear: both;">&nbsp;</div>
        </div>
    </div>
    <div id="footer" style="width: 100%; margin: 10px 0 10px 0;">
            <%@ include file="/WEB-INF/decorators/footer.jsp" %>
    </div>
    <!-- end #footer -->
</div>



</body>
</html>

