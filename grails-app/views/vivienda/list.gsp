
<%@ page import="tpFallas.frame.Vivienda" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vivienda.label', default: 'Vivienda')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vivienda" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vivienda" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="comparteCama" title="${message(code: 'vivienda.comparteCama.label', default: 'Comparte Cama')}" />
					
						<g:sortableColumn property="cuidadoEnAusencia" title="${message(code: 'vivienda.cuidadoEnAusencia.label', default: 'Cuidado En Ausencia')}" />
					
						<g:sortableColumn property="habitabilidad" title="${message(code: 'vivienda.habitabilidad.label', default: 'Habitabilidad')}" />
					
						<g:sortableColumn property="habitacionDelNino" title="${message(code: 'vivienda.habitacionDelNino.label', default: 'Habitacion Del Nino')}" />
					
						<g:sortableColumn property="propietario" title="${message(code: 'vivienda.propietario.label', default: 'Propietario')}" />
					
						<g:sortableColumn property="riesgo" title="${message(code: 'vivienda.riesgo.label', default: 'Riesgo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${viviendaInstanceList}" status="i" var="viviendaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${viviendaInstance.id}">${fieldValue(bean: viviendaInstance, field: "comparteCama")}</g:link></td>
					
						<td>${fieldValue(bean: viviendaInstance, field: "cuidadoEnAusencia")}</td>
					
						<td>${fieldValue(bean: viviendaInstance, field: "habitabilidad")}</td>
					
						<td><g:formatBoolean boolean="${viviendaInstance.habitacionDelNino}" /></td>
					
						<td>${fieldValue(bean: viviendaInstance, field: "propietario")}</td>
					
						<td>${fieldValue(bean: viviendaInstance, field: "riesgo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${viviendaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
