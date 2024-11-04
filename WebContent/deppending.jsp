<%@ page import ="com.smart.working.*"  %>
<%@ page import ="java.sql.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pending Task</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons CSS -->

 <!-- side nav css file -->
 <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
 <!-- side nav css file -->
 
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
	<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
		<!--left-fixed -navigation-->
		<aside class="sidebar-left">
      <nav class="navbar navbar-inverse">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".collapse" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Pending.jsp"><span class="fa fa-area-chart"></span> Smart Miantainace<span class="dashboard_text">Maintainance Portal</span></a>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="sidebar-menu">
              <li class="header">MAIN NAVIGATION</li>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="sidebar-menu">
             
                <li class="treeview">
                
                <a href="login.html"><i class="fa fa-dashboard"></i> <span>Dashboard</span>
                </a>
              </li>
              <li class="treeview">
                
               <a href="welcomedepartment.html"><i class="fa fa-dashboard"></i> <span> Home </span>
                </a>
              </li>
              <li class="treeview">
                
                <a href="owndeptc.jsp"><i class="fa fa-dashboard"></i> <span> View own department complain</span>
                </a>
              </li>
              <li class="treeview">
                
                <a href="deadlinetask.jsp"><i class="fa fa-dashboard"></i> <span>View Deadline Task Of Road Maintainance </span>
                </a>
              </li>
              <li class="treeview">
                
                <a href="deppending.jsp"><i class="fa fa-dashboard"></i> <span> View Pending Complain</span>
                </a>
              </li>
              <li class="treeview">
                
                <a href="depcomplain.jsp"><i class="fa fa-dashboard"></i> <span> View Complete Complain</span>
                </a>
              </li>
              
          <!-- /.navbar-collapse -->
      </nav>
    </aside>
	</div>                         
          <!-- /.navbar-collapse -->
      </nav>
    </aside>
	</div>
		<!--left-fixed -navigation-->
		
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				
		
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				
					
					<div class="row">
						
						
  
       	<table class="table table-striped">
  <thead>
    <tr>
    
      <th scope="col">Title</th>
      <th scope="col"> Description</th>
 	<th scope="col"> Pending Task</th>
   
 
    </tr>
  </thead>
  		<%
  		try
  		{
  		Connection con = ConnetDB.getConnect();
  		PreparedStatement ps1 = con.prepareStatement("select title,description,pendingtask from complain ");
  	
  		ResultSet rs1 = ps1.executeQuery();
  		
  		while(rs1.next())
  		{
  			
  		%>
  		<tr>
  		<td><%= rs1.getString(1)  %></td>
  		<td><%= rs1.getString(2)  %></td>
  		<td><%= rs1.getString(3)  %></td>
  	
  	
  		
  		</tr>
  		<%
  		
  		}
  		}
  		catch(Exception e)
  		{
  			e.printStackTrace();
  		}
  		%>
  </table>

				
				
              
             
              
        </div>   

					</div>
				</div>
			</div>
		</div>
		                
		<!--footer-->
		<div class="footer">
		  
	   </div>
        <!--//footer-->
	</div>
	
	<!-- side nav js -->
	<script src='js/SidebarNav.min.js' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js -->
	
	<!-- Classie --><!-- for toggle left push menu script -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!-- //Classie --><!-- //for toggle left push menu script -->
	
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
   
</body>
</html>