<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="content-language" content="en" />
	<meta name="description" content="[HERE PASTE YOUR DESCRIPTION]" />
	<meta name="author" content="Template:TemplatesDock [www.templatesdock.com]; e-mail:hello@templatesdock.com" />
	<link rel="stylesheet" media="screen,projection" type="text/css" href="jsp/css/main.css" />
	<link rel="stylesheet" media="screen,projection" type="text/css" href="jsp/css/nivo.css" />
	<link rel="stylesheet" media="screen,projection" type="text/css" href="sp/css/skin.css" />	
	<!--[if IE 6]><script src="javascript/pngfix.js"></script><script>DD_belatedPNG.fix('#logo img, #nav li a, #nav li a span, #nav-icons img, #twitter, #imac');</script><![endif]--> 			
	<script type="text/javascript" src="/jsp/javascript/jquery.js"></script>
	<script type="text/javascript" src="/jsp/javascript/jquery.nivo.js"></script>
	<script type="text/javascript" src="/jsp/javascript/cufon-yui.js"></script>
	<script type="text/javascript" src="/jsp/javascript/font.font.js"></script>
	<script type="text/javascript">
	Cufon.replace('h1, h2', {hover:true});
	$(window).load(function() {
		$('#slider').nivoSlider({
		effect:'sliceDown',
		slices:20,
		animSpeed:500,
		pauseTime:3000,
		startSlide:0,
		directionNav:false,
		directionNavHide:false,
		controlNav:false,
		controlNavThumbs:false,
		controlNavThumbsFromRel:false,
		keyboardNav:false,
		pauseOnHover:true,
		manualAdvance:false,
		captionOpacity:0.5,
		beforeChange:function(){},
		afterChange:function(){},
		slideshowEnd:function(){}
		});
	});

	</script>
	<title>RRCC</title>
</head>
<style>
    #tooltip {
	position: absolute;
	z-index: 3000;
	border: 1px solid #111;
	background-color: #eee;
	padding: 5px;
	opacity: 0.95;
    }
    
    #galleria{height:450px}
</style>


<body id="hp"> <!-- APPLY CSS STYLES FOR HOMEPAGE -->
   
<div id="main">

		<!-- NAVIGATION -->
	<ul id="nav">
            <br>
            <div align="center">
	<a href="/WebRRCC/welcome.action" ><img src="imagenes/portadas/portada3.jpg"  title="Incio del sistema"/></a>
           </div>  
               
    </ul>
  </div> 
	<!-- /header -->

	<!-- WELCOME -->
	<div id="welcome" class="box"><!-- /welcome-inner -->

		<!-- TWITTER --><!-- /twitter -->
		
		<div id="imac">
		
			<!-- REPLACE THESE 3 IMAGES WITH YOUR OWN IMAGES (WIDTH:371, HEIGHT:211) --><!-- /slider --></div> <!-- /imac -->
		
</div> <!-- /welcome -->
	
	<!-- COLUMNS --><!-- /section -->

	<!-- CONTACT -->
	<div id="contact">

<address>
			Celepsa <span>|</span>
			<a href="#">www.celepsa.com</a> <span>|</span>
			<a href="mailto:pmedina@celepsa.com">pmedina@celepsa.com</a> <span>|</span>
			Address: Av. Carlos Villaran 514 Santa Catalina La Victoria<span>|</span>
			Phone: (051)6192800
	  </address>

	</div> <!-- /contact -->	
	
	<!-- FOOTER -->
	<div id="footer" class="box">

		<!-- Would you like to remove this line? Visit www.templatesdock.com/terms.php -->
		<p class="f-right t-right"><br /><span class="smaller">Tip: <a href="http://www.nuvio.cz/">Webdesign</a></span></p>
		<!-- Would you like to remove this line? Visit www.templatesdock.com/terms.php -->
	
		<p class="f-left">Copyright &copy;&nbsp;2014 <a href="#">Celepsa</a>, All Rights Reserved &reg;</p>

	</div> <!-- /footer -->

</div> <!-- /main -->

<script type="text/javascript"> Cufon.now(); </script>

</body>
</html>
