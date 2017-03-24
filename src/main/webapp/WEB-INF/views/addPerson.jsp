<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/people" var="back" />

<spring:url value="/resources/css/hello-world-spring.css" var="helloCss" />
<spring:url value="/resources/css/font-awesome.css" var="fontAwesome" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />

<link href="${helloCss}" rel="stylesheet" />
<link href="${fontAwesome}" rel="stylesheet" />
<link href="${bootstrapCSS}" rel="stylesheet" />

<title><spring:message code="addPerson"/></title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2><spring:message code="addPerson"/></h2>
		</div>
		<div class="row">
			<p class="form-intro col-sm-offset-2 col-sm-10"><spring:message code="required"/>(<abbr class="required" title="required">*</abbr>)</p>	
		</div>
		<div class="row">
			<form:form modelAttribute="person" cssClass="form-horizontal">
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="nombre">
						<spring:message code="name"/> <abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="nombre" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="nombre"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="apellidos">
						<spring:message code="surname"/> <abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="apellidos" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="apellidos"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="username">
						<spring:message code="username"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="username" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="username"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="pass">
						<spring:message code="pass"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:password cssClass="form-control" path="pass" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="pass"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="repass">
						<spring:message code="repass"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:password cssClass="form-control" path="repass" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="repass"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="githubProfile">
						<spring:message code="githubProfile"/>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="githubProfile" />
					</div>
					<div class="col-sm-5 error">
						<form:errors path="githubProfile"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="fechaNacimiento">
						<spring:message code="birthDate"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="fechaNacimiento" placeholder="dd/mm/yyyy"/>
					</div>
					<div class="col-sm-5 error">
						<form:errors path="fechaNacimiento"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="email">
						<spring:message code="email"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="email"/>
					</div>
					<div class="col-sm-5 error">
						<form:errors path="email"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="telefono">
						<spring:message code="phone"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="telefono"/>
					</div>
					<div class="col-sm-5 error">
						<form:errors path="telefono"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="provincia.id">
						<spring:message code="province"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:select cssClass="form-control" path="provincia.id">
							<spring:message code="select.option" var="selectOptionMessage"/>
							<form:option value="0" label="${selectOptionMessage}"></form:option>
							<form:options items="${caracteristicas}" itemLabel="nombre" itemValue="id"/>
						</form:select>
					</div>
					
					<div class="col-sm-5 error">
						<form:errors path="provincia"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="poblacion">
						<spring:message code="town"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="poblacion"/>
					</div>
					<div class="col-sm-5 error">
						<form:errors path="poblacion"/>
					</div>
				</div>
				<div class="form-group">
					<form:label cssClass="col-sm-3 control-label" path="dni">
						<spring:message code="dni"/><abbr class="required" title="required"> * </abbr>
					</form:label>
					<div class="col-sm-4">
						<form:input cssClass="form-control" path="dni"/>
					</div>
					<div class="col-sm-5 error">
						<form:errors path="dni"/>
					</div>
				</div>
				<div class="form-group col-sm-7 text-right">
					<a href="${back}" class="btn btn-default" role="button">
						<i class="fa fa-arrow-left" aria-hidden="true"></i>
						<spring:message code="back"/>
					</a>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-floppy-o" aria-hidden="true"></i>
						<spring:message code="save"/>
					</button>
				</div>
			</form:form>
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