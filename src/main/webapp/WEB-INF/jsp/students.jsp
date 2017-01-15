<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div id="main">

	<c:if test="${not empty teacherName}">
		<h2>Teacher ${teacherName} has below students:</h2>
	</c:if>
	<c:if test="${empty teacherName}">
		<h2>List of all the students</h2>
	</c:if>
		<ul class="list-group">
			<c:forEach items="${studentsMap}" var="studentsMap">
				<li class="list-group-item">${studentsMap.value}</li>
			</c:forEach>
		</ul>
	<div>
		<a href="<spring:url value="/teachers.html" />">Visit teachers
			page for more information</a>
	</div>

</div>