
function showMessageBoard() {

}

$(function() {
	getMessageBoardByPage(1);
})
var messageBoard = {"id":null,"email":null,"name":null,"content":null,"time":null}
var status = {"isSuccess" : false, "message" : null}
function saveMessageBoard()
{
	$("#alertMessage").slideUp();
	$("#alertMessageInfo").slideUp();
	var username = $("#messageUsername").val();
	var content = $("#messageContent").val();
	var date = new Date();
	messageBoard.name = username;
	messageBoard.content = content;
	messageBoard.time = date.getTime();
	//alert(date.getTime())
	$.ajax({
		headers : {
			"X-Requested-Accept" : 'json',
			"Accept" : "application/json",
			"Content-Type" : "application/json;charset=utf-8"
		},
		url : "messageBoard/save",
		data : JSON.stringify(messageBoard),
		method : "POST",
		success : function(data) {
			if(data.success)
			{
				var alertMsg = $("#alertMessageInfo");
				alertMsg.slideDown();
				alertMsg.text(data.message);
				getMessageBoardByPage(1);
				$("#messageUsername").val("");
				$("#messageContent").val("");
			}else{
				var alertMsg = $("#alertMessage");
				alertMsg.slideDown();
				alertMsg.text(data.message);
			}
		}
		})
}
var currentPage = 1;
function getMessageBoardByPage(page) {
	$.ajax({
		headers : {
			"X-Requested-Accept" : 'json',
			"Accept" : "application/json"
		},
		url : "messageBoard/page/" + page,
		success : function(data) {
			currentPage = page;
			var msgList = "";
			for(var i = 0;i < data.length;i++)
			{
				msgList += "<li class='list-group-item'><span class='glyphicon glyphicon-user' aria-hidden='true'>"+data[i].name+"</span>&nbsp;&nbsp;&nbsp;	<span class='label label-info'>"+data[i].time+"</span><br><br>"+data[i].content+"</li>";
			}
			$("#messageUl").html(msgList)
			$(".pagination li").each(function(){
				if($(this).index() == page)
				{
					$(this).addClass("active");
				}else{
					$(this).removeClass("active");
				}
			})
		}
	})

}

function prev()
{
	getMessageBoardByPage(currentPage - 1 > 1 ? currentPage - 1 : 1);
}

function next(totalPage)
{
	getMessageBoardByPage(currentPage + 1 > totalPage ? totalPage : currentPage + 1);
}