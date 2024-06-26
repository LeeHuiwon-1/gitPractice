<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
th{
	background: cyan;
}
.err {
	color: green;
}
</style>

<%
	String[] position = { "공격수", "미드필더", "수비수", "골키퍼"};

	String[] grade = { "상", "중", "하"};
%>


FootBallInsert.jsp<br>

<script>

	var f_selbox = new Array('프리미어리그', '분데스리가', '세리에A', '라리가', '리그앙');
	
	var s_selbox = new Array();
	s_selbox[0] = new Array('토트넘', '맨시티', '맨유');
	s_selbox[1] = new Array('바이에른뮌헨', '도르트문트', '레버쿠젠');
	s_selbox[2] = new Array('인터밀란', 'AC밀란', '유벤투스', '라치오');
	s_selbox[3] = new Array('레알마드리드', '바르셀로나');
	s_selbox[4] = new Array('파리생제르맹', '모나코');
	
	var selectLeague;
	
	function init(f_league, f_team) {
		
		document.myform.first.options[0] = new Option("리그를 선택하세요", "");
		document.myform.second.options[0] = new Option("소속팀을 선택하세요", "");
		
		for (i = 0 ; i < f_selbox.length ; i++) {
			 document.myform.first.options[i+1] = new Option(f_selbox[i],f_selbox[i]);
			if (document.myform.first.options[i + 1].value == f_league) {
				document.myform.first.options[i + 1].selected = true;
				selectLeague = i;
			}//if
		}//for

		 for(var j = 0 ; j < s_selbox[selectLeague].length ; j++){
	    	  document.myform.second.options[j+1] = new Option(s_selbox[selectLeague][j]);
	    	  if(document.myform.second.options[j+1].value == f_team){
	         	 document.myform.second.options[j+1].selected = true;
	          }
	      }//for
		
	}//init

	function leagueChange() {
		var index = document.myform.first.selectedIndex;

		for (i = document.myform.second.length - 1 ; i > 0; i--) {
			document.myform.second.options[i] = null;	// team 초기화
		}

		for (i = 0; i < s_selbox[index - 1].length; i++) {
			document.myform.second.options[i + 1] = new Option(s_selbox[index - 1][i]);
		}

	}//init
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
		var use;
		var isCheck = false;
		
		$('#name_check').click(function(){
			
			isCheck = true;
			$.ajax({
				url : "name_check_proc.fb",
				
				type : "post",
				
				data : ({
					inputName : $("input[name=name]").val()
				}),
				
				success : function(data){
					
					flag = true;
					
					if($('input[name=name]').val() == ""){
						$('#nameMessage').html("이름이 누락되었습니다.").css("color","red").show();
						$('input[name=name]').focus();	
					}
					else if(data == "YES"){
						$("#nameMessage").html("사용가능한 이름입니다.").css("color","blue").show();
						$('input[name=name]').focus();
						use = "possible";
					}
					else{
						$("#nameMessage").html("이미 등록된 이름입니다.").css("color","red").show();
						use = "imPossible";
					}
					
				}	//success
			
			});	//ajax
			
		});	//click
		
		$('input[name=name]').keydown(function(){
			isCheck = false;
			use = "";
			
			$("#nameMessage").css('display','none');
			
		});
		
		$('#btnSubmit').click(function(){
			
			if(use == "imPossible"){
				alert("이미 사용중인 이름입니다.");
				return false;
			}
			else if(isCheck == false){
				alert("중복체크를 하세요.");
				return false;
			}
			
		});	//#btnSubmit click
		
		
	});	//ready
	
</script>

<body onLoad="init('${football.league}','${football.team}')">

	<form:form commandName="football" name="myform" action="insert.fb" method="post">
		<h2>선수 정보 등록</h2>
		
		<table border="1" align="center" width="50%" height="60%">
			<tr>
				<th>선수이름</th>
				<td>
					<input type="text" name="name" value="${football.name}">
					<input type="button" id="name_check" value="중복체크">
					<span id="nameMessage"></span>
					<form:errors path="name" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>소속 리그</th>
				<td>
					<select id="first" name="league" onChange="leagueChange()"></select>
					<form:errors path="league" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>소속 팀</th>
				<td>
					<select id="second" name="team"></select>
					<form:errors path="team" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>포지션</th>
				<td>
					<c:set var="position" value="<%=position %>"/>
					<c:forEach var="i" begin="0" end="${fn:length(position)-1 }">
						<input type="checkbox" name="position" value="${position[i]}"
							<c:if test = "${fn:contains(football.position, position[i]) }">checked</c:if>>
							${position[i]}
					</c:forEach>
					<form:errors path="position" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>키</th>
				<td>
					<input type="text" name="height" value=0>
					<input type="text" value="CM" size="1" disabled >
					<form:errors path="height" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>몸무게</th>
				<td>
					<input type="text" name="weight" value=0>
					<input type="text" value="KG" size="1" disabled >
					<form:errors path="weight" cssClass="err" />
				</td>
			</tr>
			
			<tr>
				<th>등급</th>
				<td>
					<c:set var="grade" value="<%=grade %>"/>
					<c:forEach var="i" begin="0" end="${fn:length(grade)-1 }">
						<input type="radio" name="grade" value="${grade[i]}"
							<c:if test = "${football.grade eq grade[i] }">checked</c:if>>
							${grade[i]}
					</c:forEach>
					<form:errors path="grade" cssClass="err" />
				</td>
			</tr>
			
			
			<tr>
				<th colspan="2">
					<input type="submit" value="삽입" id="btnSubmit">
				</th>
			</tr>
		</table>
	</form:form>

</body>