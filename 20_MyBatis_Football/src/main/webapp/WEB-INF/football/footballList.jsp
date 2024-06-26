<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	th{
		background: cyan;
	}
</style>

<script type="text/javascript">
	function insert(){
		location.href="insert.fb";
	}
</script>


footballList.jsp<br>

<center>
	<h2>선수 리스트 화면(해당 레코드 갯수:${pageInfo.totalCount}) </h2>
	<h3 align="center">현재 선택한 페이지 번호 : ${pageInfo.pageNumber}</h3>
	<form action="list.fb" method="get">
		<select name = "whatColumn">
			<option value="all">전체 검색
			<option value="team">소속팀
			<option value="grade">등급
			<option value="position">포지션
		</select>
		<input type="text" name="keyword" value="">
		<input type="submit" value="검색">
	</form>
</center>

<table border="1" align="center" width="50%" height="30%">

	<tr>
		<th colspan="10">
			<input type="button" value="삽입" onClick="insert()">
		</th>
	</tr>
	<tr align="center">
		<th>번호</th>
		<th>이름</th>
		<th>리그</th>
		<th>소속팀</th>
		<th>포지션</th>
		<th>키</th>
		<th>몸무게</th>
		<th>등급</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
	<c:forEach var="ftbl" items="${lists}">
		<tr align="center">
			<td>${ftbl.num }</td>
			<td>
				<a href="detail.fb?num=${ftbl.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${pageInfo.whatColumn}&keyword=${pageInfo.keyword}">
					${ftbl.name}
				</a>
			</td>
			<td>${ftbl.league}</td>
			<td>${ftbl.team}</td>
			<td>${ftbl.position}</td>
			<td>${ftbl.height}</td>
			<td>${ftbl.weight}</td>
			<td>${ftbl.grade}</td>
			<td><input type="button" value="수정" onClick="location.href='update.fb?num=${ftbl.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${pageInfo.whatColumn}&keyword=${pageInfo.keyword}'"></td>
			<td>
				<a href="delete.fb?num=${ftbl.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${pageInfo.whatColumn}&keyword=${pageInfo.keyword}">
					삭제
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

<p align="center">
	${pageInfo.pagingHtml }
</p>