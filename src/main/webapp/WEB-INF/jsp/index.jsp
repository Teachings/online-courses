<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>



<div id="main" >

	<h2>Welcome to My Online University!</h2>
	<ul class="list-group">
		<li class="list-group-item">There are ${tCount} teachers in the system.</li>
		<li class="list-group-item">There are ${sCount} students in the system.</li>
		<li class="list-group-item">There are ${cCount} courses in the system.</li>
	</ul>
	
	<div>
		<a href="<spring:url value="/teachers.html" />">Visit teachers page	for more information</a>
	</div>
	
</div>