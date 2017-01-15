<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h2>Teachers</h2>
<p>List of all the teachers in the system</p>
<div class="table-responsive">
	<table class="table table-hover table-bordered table-stripped">
		<thead>
			<tr>
				<th>#</th>
				<th>Teacher Name</th>
				<th>Students</th>
				<th>Courses</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teachersMap" items="${teachersMap}">
				<tr>
					<th>${teachersMap.key}</th>
					<th>${teachersMap.value}</th>
					<th><a href="<spring:url value="/teachers/${teachersMap.key}/students.html" />">Click here</a></th>
					<th><a href="<spring:url value="/teachers/${teachersMap.key}/courses.html" />">Click here</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
