<%@page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<title>ZyL's Reference</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
<link rel="stylesheet" href="css/style2.css" media="screen"
	type="text/css" />
<style>
#title {
	text-align: center;
}

* {
	margin: 0;
	padding: 0;
}

#box {
	width: 300px;
	height: 300px;
	border: solid 1px #000;
	border-radius: 50%;
	position: absolute;
	top: 100px;
	left: 300px;
	box-shadow: 1px 1px 5px #000;
	cursor: pointer;
}

.hour {
	width: 14px;
	height: 80px;
	background: #000;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -80px 0 0 -7px;
	border-radius: 50% 50% 0 0;
	transform-origin: center bottom;
}

.min {
	width: 14px;
	height: 100px;
	background: #000;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -100px 0 0 -7px;
	border-radius: 50% 50% 0 0;
	transform-origin: center bottom;
}

.sec {
	width: 4px;
	height: 120px;
	background: red;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -120px 0 0 -2px;
	transform-origin: center bottom;
}

.cap {
	width: 20px;
	height: 20px;
	background: #999;
	border-radius: 50%;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -10px 0 0 -10px;
}

.scale {
	width: 4px;
	height: 10px;
	background: #000;
	position: absolute;
	left: 50%;
	margin-left: -2px;
	display: block;
	-webkit-transform: rotate(45deg);
	transform-origin: center 150px;
}

.bs {
	width: 6px;
	height: 18px;
	background: #000;
	position: absolute;
	left: 50%;
	margin-left: -3px;
	display: block;
	-webkit-transform: rotate(45deg);
	transform-origin: center 150px;
}

.bs em {
	width: 50px;
	text-align: center;
	margin: 17px 0;
	position: absolute;
	top: 0;
	left: 50%;
	margin-left: -25px;
	font-style: normal;
}
</style>
<script type="text/javascript" src="js/clock.js"></script>
<style>
#header {
	text-align: center;
	z-index: 10;
	position: relative;
}
#body{
	position:relative;
	padding-bottom: 1px;
}
#footer{
	width:100%;
	text-align:center;
	position: absolute;
	bottom: 0;
}
</style>
</head>
<body>
	<div id="header">
		<p style="margin: 150px auto">
			<a>Reference</a>
		</p>
		<hr>
		<br>
		<ul style="font-size: 30px;">
			<li><a href="../learning">Learning</a></li>
			<br>
			<li><a href="../demos">Demos</a></li>
			<br>
			<li><a href="../mc">MC Server</a></li>
			<br>
			<li><a href="http://zyl-me.xicp.net:99/">GitLab</a></li>
			<br>
			<li><a href="../gitblit">Gitblit</a></li>
			<br>
			<li><a href="../jenkins">Jenkins</a></li>
			<br>
			<li><a href="../eclipse-plugin">Eclipse plugin</a></li>
			<br>
			<li><a href="../flappybird">Flappy Bird Game</a></li>
			<br>
			<li><a href="https://github.com/me10zyl">me10zyl's Github</a></li>
			<br>
		</ul>s
		<div id="box" style="position: fixed; top: -100px; left: 0;">
			<div class="hour"></div>
			<div class="min"></div>
			<div class="sec"></div>
			<div class="cap"></div>
		</div>
	</div>
	<canvas class="canvas" style="position: fixed; top: -150px; z-index: 1"></canvas>
	<div class="help"></div>

	<div class="ui">
		<input class="ui-input" type="text" /> <span class="ui-return">↵</span>
	</div>

	<div class="overlay">
		<div class="tabs">
			<div class="tabs-labels">
				<span class="tabs-label">Commands</span><span class="tabs-label">Info</span><span
					class="tabs-label">Share</span>
			</div>

			<div class="tabs-panels">
				<ul class="tabs-panel commands">
					<li class="commands-item"><span class="commands-item-title">Text</span><span
						class="commands-item-info" data-demo="Hello :)">Type
							anything</span><span class="commands-item-action">Demo</span></li>
					<li class="commands-item"><span class="commands-item-title">Countdown</span><span
						class="commands-item-info" data-demo="#countdown 10">#countdown<span
							class="commands-item-mode">number</span></span><span
						class="commands-item-action">Demo</span></li>
					<li class="commands-item"><span class="commands-item-title">Time</span><span
						class="commands-item-info" data-demo="#time">#time</span><span
						class="commands-item-action">Demo</span></li>
					<li class="commands-item"><span class="commands-item-title">Rectangle</span><span
						class="commands-item-info" data-demo="#rectangle 30x15">#rectangle<span
							class="commands-item-mode">width x height</span></span><span
						class="commands-item-action">Demo</span></li>
					<li class="commands-item"><span class="commands-item-title">Circle</span><span
						class="commands-item-info" data-demo="#circle 25">#circle<span
							class="commands-item-mode">diameter</span></span><span
						class="commands-item-action">Demo</span></li>

					<li class="commands-item commands-item--gap"><span
						class="commands-item-title">Animate</span><span
						class="commands-item-info"
						data-demo="The time is|#time|#countdown 3|#icon thumbs-up"><span
							class="commands-item-mode">command1</span>&nbsp;|<span
							class="commands-item-mode">command2</span></span><span
						class="commands-item-action">Demo</span></li>
				</ul>

				<div class="tabs-panel ui-details">
					<div class="ui-details-content">
						<h1>Shape Shifter</h1>

						<p>
							An experiment by <a href="//www.kennethcachia.com"
								target="_blank">Kenneth Cachia<a />.<br /> <a
								href="//fortawesome.github.io/Font-Awesome/#icons-new"
								target="_blank">Font Awesome</a> is being used to render all
								#icons.
						</p>

						<br />

						<p>
							Visit <a
								href="http://www.kennethcachia.com/shape-shifter/?a=#icon thumbs-up"
								target="_blank">Shape Shifter</a> to use icons.
						</p>
					</div>
				</div>

				<div class="tabs-panel ui-share">
					<div class="ui-share-content">
						<h1>Sharing</h1>

						<p>
							Simply add <em>?a=</em> to the current URL to share any static or
							animated text. Examples:
						</p>

						<p>
							<a href="http://www.kennethcachia.com/shape-shifter?a=Hello"
								target="_blank">www.kennethcachia.com/shape-shifter?a=Hello</a><br />
							<a
								href="http://www.kennethcachia.com/shape-shifter?a=Hello|#countdown 3"
								target="_blank">www.kennethcachia.com/shape-shifter?a=Hello|#countdown
								3</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/animateBackground.js"></script>
	<script src="js/animateNumber.js"></script>
	<script src="js/ajaxViewCount.js"></script>
	<div id="footer" style="color:red">
		2015年7月17日11:45:17 me10zyl@qq.com
		<small>浏览次数:<span >${viewCount}</span>次</small> 自2015年7月17日
	</div>
	<script src="js/index.js"></script>
	<script src="js/index2.js"></script>
</body>


</html>