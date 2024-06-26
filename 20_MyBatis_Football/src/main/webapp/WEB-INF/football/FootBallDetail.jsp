<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	th{
		background: cyan;
	}
	
	td{
		text-align: center;
	}
</style>
FootBallDetail.jsp<br>

	<table border="1" align="center" width="50%" height="60%">
		
		<tr>
			<th>번호</th>
			<td>${football.num}</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>${football.name}</td>
		</tr>
		
		<tr>
			<th>소속리그</th>
			<td>${football.league}</td>
		</tr>
		
		<tr>
			<th>소속 팀</th>
			<td>${football.team}</td>
		</tr>
		
		<tr>
			<th>포지션</th>
			<td>${football.position}</td>
		</tr>
		
		<tr>
			<th>키</th>
			<td>${football.height}</td>
		</tr>
		
		<tr>
			<th>몸무게</th>
			<td>${football.weight}</td>
		</tr>
		
		<tr>
			<th>등급</th>
			<td>${football.grade}</td>
		</tr>
		
		<tr>
			<th colspan="2">
				<a href="list.fb?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">리스트로 돌아가기</a>
			</th>
		</tr>
	</table>