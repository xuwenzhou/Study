<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>The Home Page of MyApp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO">
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive">
	<meta name="author" content="FREEHTML5.CO">

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content="">
	<meta property="og:image" content="">
	<meta property="og:url" content="">
	<meta property="og:site_name" content="">
	<meta property="og:description" content="">
	<meta name="twitter:title" content="">
	<meta name="twitter:image" content="">
	<meta name="twitter:url" content="">
	<meta name="twitter:card" content="">

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Google Webfonts -->
<!-- 	<link href="http://fonts.useso.com/css?family=Roboto:400,300,100,500" rel="stylesheet" type="text/css">
	<link href="http://fonts.useso.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="http://fonts.useso.com/css?family=Sanchez:400,400italic" rel="stylesheet" type="text/css">
	<link href="http://fonts.useso.com/css?family=Playfair+Display:400,400italic" rel="stylesheet" type="text/css"> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Theme Style -->
	<link rel="stylesheet" href="css/style.css">
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
		
		<main role="main" id="fh5co-main">
		
			<!-- 三角形问题 -->
			<div class="container" id="services-animate">
				<div class="row row-padded">
					<div class="col-md-3">
						<h2 class="fh5co-section-heading to-animate">三角形问题<span class="fh5co-border"></span></h2>
						<p class="to-animate">请输入三个不大于200的正整数<br>我们将对三边是否构成三角形进行判断<br>并判断是否是特殊三角形</p>
					</div>
					<div class="col-md-8 col-md-push-1">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="a" class="sr-only">A</label>
									<input type="text" id="a" class="form-control" placeholder="A">
								</div>
								<div class="form-group to-animate">
									<label for="b" class="sr-only">B</label>
									<input type="text" id="b" class="form-control" placeholder="B">
								</div>
								<div class="form-group to-animate">
									<label for="c" class="sr-only">C</label>
									<input type="text" id="c" class="form-control" placeholder="C">
								</div>
								<div class="form-group to-animate">
									<label for="check" class="sr-only">Check</label>
									<input type="submit" id="check" class="btn btn-primary btn-block" value="Check">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="triangleResult" class="sr-only">Result</label>
									<textarea name="triangleResult" id="triangleResult" readonly="readonly" cols="30" rows="5" class="form-control" placeholder="Result"></textarea>
								</div>
							</div>

						</div>
					</div>
					
				</div>
				<!-- END .row -->

			</div>
			<!-- END .container -->
			
			<!-- 分隔背景 -->
			<div class="fh5co-section-seperator" style="background-image: url(&quot;images/hero-2.jpg&quot;); background-position: 0px 75px;" data-stellar-background-ratio="0.5">
				<div class="fh5co-overlay"></div>
				<div class="container" id="counter-animate">
					<div class="fh5co-section-content-wrap">
						<div class="fh5co-section-content">
							<div class="row">
								<div class="col-md-4 text-center to-animate">
									<span class="fh5co-counter js-counter" data-from="0" data-to="28" data-speed="5000" data-refresh-interval="50">28</span>
									<span class="fh5co-counter-label">Clients Worked With</span>
									
								</div>
								<div class="col-md-4 text-center to-animate">
									<span class="fh5co-counter js-counter" data-from="0" data-to="57" data-speed="5000" data-refresh-interval="50">57</span>
									<span class="fh5co-counter-label">Completed Projects</span>
								</div>
								<div class="col-md-4 text-center to-animate">
									<span class="fh5co-counter js-counter" data-from="0" data-to="34023" data-speed="5000" data-refresh-interval="50">34023</span>
									<span class="fh5co-counter-label">Line of Codes</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END .container -->
			
			<!-- 日历问题 -->
			<div class="container" id="services-animate">
				<div class="row row-padded">
					<div class="col-md-3">
						<h2 class="fh5co-section-heading to-animate">日历问题<span class="fh5co-border"></span></h2>
						<p class="to-animate">请输入1900年~9999年中任意一个日期<br>我们将判断日期是否合法<br>并给出合法日期的下一日</p>
					</div>
					<div class="col-md-8 col-md-push-1">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="year" class="sr-only">Year</label>
									<input type="text" id="year" class="form-control" placeholder="Year">
								</div>
								<div class="form-group to-animate">
									<label for="month" class="sr-only">Month</label>
									<input type="text" id="month" class="form-control" placeholder="Month">
								</div>
								<div class="form-group to-animate">
									<label for="day" class="sr-only">Day</label>
									<input type="text" id="day" class="form-control" placeholder="Day">
								</div>
								<div class="form-group to-animate">
									<label for="next" class="sr-only">NextDay</label>
									<input type="submit" id="next" class="btn btn-primary btn-block" value="NextDay">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="dateResult" class="sr-only">Result</label>
									<textarea name="dateResult" id="dateResult" readonly="readonly" cols="30" rows="5" class="form-control" placeholder="Result"></textarea>
								</div>
							</div>

						</div>
					</div>
					
				</div>
				<!-- END .row -->

			</div>
			<!-- END .container -->

			<!-- 斐波拉契问题 -->
			<div class="container" id="services-animate">
				<div class="row row-padded">
					<div class="col-md-3">
						<h2 class="fh5co-section-heading to-animate">斐波拉契问题<span class="fh5co-border"></span></h2>
						<p class="to-animate">请输入任意一个正整数<br>我们将输出该长度的斐波拉契数列，及程序运行时间</p>
					</div>
					<div class="col-md-8 col-md-push-1">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="fiboMax" class="sr-only">Max</label>
									<input type="text" id="fiboMax" class="form-control" placeholder="Max">
								</div>
								<div class="form-group to-animate">
									<label for="fibonacci" class="sr-only">Fibonacci</label>
									<input type="submit" id="fibonacci" class="btn btn-primary btn-block" value="Fibonacci">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="fibonacciResult" class="sr-only">Result</label>
									<textarea name="fibonacciResult" id="fibonacciResult" readonly="readonly" cols="30" rows="10" class="form-control" placeholder="Result"></textarea>
								</div>
								<div class="form-group to-animate">
									<label for="fibonacciTime" class="sr-only">Time</label>
									<textarea name="fibonacciTime" id="fibonacciTime" readonly="readonly" cols="30" rows="1" class="form-control" placeholder="Time"></textarea>
								</div>
							</div>

						</div>
					</div>
					
				</div>
				<!-- END .row -->

			</div>
			<!-- END .container -->

			<!-- 素数问题 -->
			<div class="container" id="services-animate">
				<div class="row row-padded">
					<div class="col-md-3">
						<h2 class="fh5co-section-heading to-animate">素数问题<span class="fh5co-border"></span></h2>
						<p class="to-animate">请输入任意一个正整数<br>我们将输出小于该数的所有素数，及程序运行时间</p>
					</div>
					<div class="col-md-8 col-md-push-1">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="erasMax" class="sr-only">Max</label>
									<input type="text" id="erasMax" class="form-control" placeholder="Max">
								</div>
								<div class="form-group to-animate">
									<label for="erastothenes" class="sr-only">Erastothenes</label>
									<input type="submit" id="erastothenes" class="btn btn-primary btn-block" value="Erastothenes">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="erastothenesResult" class="sr-only">Result</label>
									<textarea name="erastothenesResult" id="erastothenesResult" readonly="readonly" cols="30" rows="10" class="form-control" placeholder="Result"></textarea>
								</div>
								<div class="form-group to-animate">
									<label for="erastothenesTime" class="sr-only">Time</label>
									<textarea name="erastothenesTime" id="erastothenesTime" readonly="readonly" cols="30" rows="1" class="form-control" placeholder="Time"></textarea>
								</div>
							</div>

						</div>
					</div>
					
				</div>
				<!-- END .row -->

			</div>
			<!-- END .container -->
			
			
			<!-- 生成二维码图片 -->
			<div class="container" id="services-animate">
				<div class="row row-padded">
					<div class="col-md-3">
						<h2 class="fh5co-section-heading to-animate">生成二维码图片<span class="fh5co-border"></span></h2>
						<p class="to-animate">生成二维码图片<br>生成二维码图片</p>
					</div>
					<div class="col-md-8 col-md-push-1">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group to-animate">
									<label for="infor" class="sr-only">信息</label>
									<input type="text" id="erasMax" class="form-control" placeholder="信息">
								</div>
								<div class="form-group to-animate">
									<label for="getTwo" class="sr-only">生成二维码</label>
									<input type="submit" id="getTwo" class="btn btn-primary btn-block" value="生成二维码">
								</div>
								<p id="image"/>
							</div>

						</div>
					</div>
					
				</div>
				<!-- END .row -->

			</div>
			<!-- END .container -->

		</main>

	
		<!-- jQuery -->
		<script src="js/jquery.min.js"></script>
		<!-- jQuery Easing -->
		<script src="js/jquery.easing.1.3.js"></script>
		<!-- Bootstrap -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Waypoints -->
		<script src="js/jquery.waypoints.min.js"></script>
		<!-- Stellar -->
		<script src="js/jquery.stellar.min.js"></script>
		<!-- countTo -->
		<script src="js/jquery.countTo.js"></script>
		<!-- Magnific Popup -->
		<script src="js/jquery.magnific-popup.min.js"></script>
		<!-- Main JS -->
		<script src="js/main.js"></script>
		
		<script type="text/javascript">   
		
		$(document).ready(function(){
			var image;
			  
			$("#check").click(function(){
				var postUrl = "/myapp-study/getTriangle";
				var params = {
						a:  $("#a").val(),  
		                b:  $("#b").val(),
		                c:  $("#c").val()
				}
				
				$.post(postUrl,params,function(result){
					
					$("#triangleResult").html(result.msg);
					
				});
				
			});
			
			$("#next").click(function(){
				var postUrl = "/myapp-study/getNextDate";
				var params = {
						year:  $("#year").val(),  
		                month:  $("#month").val(),
		                day:  $("#day").val()
				}
				
				$.post(postUrl,params,function(result){
					
					$("#dateResult").html(result.msg);
					
				});
				
			});
			
			$("#fibonacci").click(function(){
				var postUrl = "/myapp-study/getFibonacci";
				var params = {
						fiboMax:  $("#fiboMax").val()
				}
				
				$.post(postUrl,params,function(result){
					
					$("#fibonacciResult").html(result.msg);
					$("#fibonacciTime").html(result.time);
					
				});
				
			});
			
			$("#erastothenes").click(function(){
				var postUrl = "/myapp-study/getErastothenes";
				var params = {
						erasMax:  $("#erasMax").val()
				}
				
				$.post(postUrl,params,function(result){
					
					$("#erastothenesResult").html(result.msg);
					$("#erastothenesTime").html(result.time);
					
				});
				
			});
			
			$("#getTwo").click(function(){
				var postUrl = "/myapp-study/getTwo";
				var params = {
				}
				
				$.post(postUrl,params,function(result){
					//$("#image").html = "data:image/png;base64," + result.image;
					$("#image").innerHTML = '<div>图片img标签展示：</div><img src="data:image/png;base64,' + result.image+ '" alt=""/>'; 
				});
				
			});
			
		});
		</script>

</body>
</html>