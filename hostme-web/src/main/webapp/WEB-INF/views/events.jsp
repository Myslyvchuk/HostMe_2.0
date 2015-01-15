<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="min-height: 682px;">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/AdminLTE.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">

<script src="resources/js/jquery.dataTables.js" type="text/javascript"></script>
<!--  <script src="resources/js/event.js" type="text/javascript"></script>-->
<script src="resources/js/fnAjaxReload.js" type="text/javascript"></script>
<script src="resources/js/dataTables.bootstrap.js"
	type="text/javascript"></script>
<title>Events</title>
</head>
<body class="wysihtml5-supported">

	<!--  	<video id="bgvid" autoplay loop poster="resources/images/nature.jpg">
		<source src="resources/video/mp4/nature1.mp4" type="video/mp4">
	</video> -->


	<section class="content-header">
		<h1>
			<spring:message code="label.events" />
		</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">

			<div class="box">
				<div class="box-header">

					<h3 class="box-title">
						<i class="fa fa-plus-square"></i> Events management

					</h3>

					<div id="addButtonEvent" style="margin-top: 10px;">
						<a href="event-creation" class="btn btn-default btn-sm"><i
							class="fa fa-fw fa-plus-square-o"></i> <spring:message
								code="label.addEvent" /></a>

						<button onclick="refresh()" class="btn btn-default btn-sm">
							<i class="fa fa-fw fa-refresh"></i>
							<spring:message code="label.Refresh" />
						</button>
					</div>


				</div>

				<!-- /.box-header -->
				<ul class="nav nav-tabs">

					<li id="events" class="active" onclick="events(this)"><a
						href="#" data-toggle="tab"><spring:message code="label.events" /></a></li>

					<!--  		<li class="" onclick="initialize_request_to_me(this)"><a
						href="#" data-toggle="tab"><spring:message
								code="label.Myevents" /></a></li>
					<li class="" onclick="initialize_request_to_me(this)"><a
						href="#" data-toggle="tab"><spring:message
								code="label.SignedEvents" /></a></li> -->

				</ul>

				<div class="row">
					<div class="col-xs-6">
						<div id="example1_length" class="dataTables_length">
							<label><select size="1" name="example1_length"
								aria-controls="example1"><option value="10"
										selected="selected">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option></select> records per page</label>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="dataTables_filter" id="example1_filter">
							<label>Search: <input type="text"
								aria-controls="example1"></label>
						</div>
					</div>
				</div>

				<div class="box-body table-responsive">
					<table id="request_table_obtain"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Title</th>
								<th>Starts</th>
								<th>Ends</th>
								<th>Location</th>
								<th>Price</th>
								<th>Website</th>
								<th>Organizer</th>
								<th>Status</th>
								<th>Attendees</th>
								<th>Comments</th>
								<th>Photos</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="events" items="${events}">
								<tr>
									<td><c:out value="${events.description}">
										</c:out></td>
									<td><c:out value="${events.startDate}">
										</c:out></td>
									<td><c:out value="${events.endDate}">
										</c:out></td>
									<td><c:out value="${events.address}">
										</c:out></td>
									<td><c:out
											value="${events.priceCategory.getPriceCategory()}">
										</c:out></td>
									<td><c:out value="${events.website}">
										</c:out></td>
									<td><c:out value="${events.owner.getLogin()}">
										</c:out></td>
									<td><c:out value="${events.status}">
										</c:out></td>
									<td><c:out value="${events.attendee}">
										</c:out></td>
									<td><c:out value="${events.comment}">
										</c:out></td>
									<td><c:out value="${events.comment}">
										</c:out></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->


</body>
</html>