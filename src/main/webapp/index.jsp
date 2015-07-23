<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>ZyL's Reference</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
<link rel="stylesheet" href="css/style2.css" media="screen"
	type="text/css" />
<link rel="stylesheet" href="css/style3.css" media="screen"
	type="text/css" />
<link rel="stylesheet" href="css/zyl.css" media="screen" type="text/css" />
<script type="text/javascript" src="js/clock.js"></script>

</head>
<body>

	<div id="header">
		<p style="margin: 150px auto">
			<a>Reference</a>
		</p>

		<div id="messageBtn">
			<a href="javascript:void(0)" onclick='showMessageBoard()'
				style="color: red" data-toggle="modal" data-target="#messageBoard">留言板</a>
		</div>
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
		</ul>
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

	<div class="modal fade" id="messageBoard" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">留言板</h4>

					<div class="alert alert-danger" role="alert" style="display: none"
						id="alertMessage">请输入用户名</div>
					<div class="alert alert-success" role="alert" style="display: none"
						id="alertMessageInfo">请输入用户名</div>
				</div>
				<div class="modal-body">
					<ul class="list-group" id="messageUl">
						<li class="list-group-item"><span
							class="glyphicon glyphicon-user" aria-hidden="true">用户1</span><br>
							<br> 啦啦啦</li>
					</ul>
					<nav>
						<ul class="pagination">
							<li><a href="javascript:void(0)"
									onclick="prev()" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<c:set var="pageCount" value="${totalPage}"></c:set>
							<c:set var="maxSugguestPage" value="${7}"></c:set>
							<%-- <c:choose>
								<c:when test="${pageCount < maxSugguestPage}"> --%>
							<c:forEach begin="1" end="${pageCount}" var="index">
								<li><a href="javascript:void(0)"
									onclick="getMessageBoardByPage(${index })">${index }</a></li>
							</c:forEach>
							<%-- </c:when>
								<c:otherwise> --%>
							<%-- 	<c:set var="firstDot" value="${true}"></c:set>
									<c:forEach begin="1" end="${pageCount - 1}" var="index">
										<c:choose>
											<c:when
												test="${index > maxSugguestPage and firstDot}">
												<li><a href="javascript:void(0)" onclick="getMessageBoardByPage(${index })">..</a></li>
												<c:set var="firstDot" value="false"></c:set>
											</c:when>
											<c:otherwise>
												<c:if test="${firstDot}">
													<li><a href="javascript:void(0)" onclick="getMessageBoardByPage(${index })">${index }</a></li>
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<li><a href="#">${pageCount }</a></li> --%>
							<%-- 	</c:otherwise>
							</c:choose> --%>
							<li><a href="javascript:void(0)" aria-label="Next" onclick="next(${totalPage})"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				<div class="modal-footer">
					<div class="input-group input-group-sm">
						<input type="text" class="form-control" placeholder="用户名"
							aria-describedby="sizing-addon1" id="messageUsername">
					</div>
					<div class="input-group input-group-sm">
						<textarea type="text" class="form-control" placeholder="留言"
							aria-describedby="sizing-addon1"
							style="height: 130px; width: 420px; margin-top: 20px;"
							id="messageContent"></textarea>
					</div>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="saveMessageBoard()">发表</button>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/animateBackground.js"></script>
	<script src="js/animateNumber.js"></script>
	<script src="js/ajaxViewCount.js"></script>
	<div id="footer" style="color: red">
		2015年7月17日11:45:17 me10zyl@qq.com <small>浏览次数:<span>${viewCount}</span>次
		</small> 自2015年7月17日
	</div>




	<script src="js/index.js"></script>
	<script src="js/index2.js"></script>
	<script src="js/zyl.js"></script>
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>


</html>