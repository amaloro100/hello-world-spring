<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/css/hello-world-spring.css" var="helloCss" />
<spring:url value="/resources/css/font-awesome.css" var="fontAwesome" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />

<link href="${helloCss}" rel="stylesheet" />
<link href="${fontAwesome}" rel="stylesheet" />
<link href="${bootstrapCSS}" rel="stylesheet" />

<title><spring:message code="person"/></title>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h2><spring:message code="person"/></h2>
		</div>
		<div class="row">
			<div class="col-md-9">
				<table class="table table-striped table-hover table-bordered">
					<tr>
						<th><spring:message code="name"/></th>
						<th><spring:message code="surname"/></th>
						<th><spring:message code="githubProfile"/></th>
						<th><spring:message code="username"/></th>
					</tr>
					<c:forEach items="${people}" var="person">
						<spring:url value="/people/${person.username}" var="personURL" />
						<tr class="clickable-row" data-href="${personURL}">
							<td class="vert-align">
								<c:out value="${person.nombre}"/>
							</td>
							<td class="vert-align">
								<c:out value="${person.apellidos}"/>
							</td>
							<td class="vert-align">
								<i class="fa fa-github-alt" aria-hidden="true"></i>${person.githubProfile}
							</td>
							<td class="vert-align">
								<i class="fa fa-user" aria-hidden="true"></i>${person.username}
							</td>
						</tr>
					</c:forEach>
				</table>
				<spring:url value="/people/add" var="addPersonURL" />
				<a href="${addPersonURL}" class="btn btn-primary" role="button"><i class="fa fa-plus" aria-hidden="true"></i><spring:message code="add"/></a>
			</div>
		</div>
	</div>
</body>
<spring:url value="/resources/js/hello-world-spring.js" var="helloJS" />
<spring:url value="/resources/js/jquery.min.js" var="helloJQuery" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
<script src="${helloJQuery}"></script>
<script src="${bootstrapJS}"></script>
<script src="${helloJS}"></script>
</html>
