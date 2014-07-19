
<%@ page import="tpFallas.frame.Padre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'padre.label', default: 'Padre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-padre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-padre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="cumpleCuotaAlimentaria" title="${message(code: 'padre.cumpleCuotaAlimentaria.label', default: 'Cumple Cuota Alimentaria')}" />
					
						<g:sortableColumn property="discapacidad" title="${message(code: 'padre.discapacidad.label', default: 'Discapacidad')}" />
					
						<g:sortableColumn property="discursoContradictorio" title="${message(code: 'padre.discursoContradictorio.label', default: 'Discurso Contradictorio')}" />
					
						<g:sortableColumn property="edad" title="${message(code: 'padre.edad.label', default: 'Edad')}" />
					
						<g:sortableColumn property="horaLlegada" title="${message(code: 'padre.horaLlegada.label', default: 'Hora Llegada')}" />
					
						<g:sortableColumn property="horaSalida" title="${message(code: 'padre.horaSalida.label', default: 'Hora Salida')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${padreInstanceList}" status="i" var="padreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${padreInstance.id}">${fieldValue(bean: padreInstance, field: "cumpleCuotaAlimentaria")}</g:link></td>
					
						<td>${fieldValue(bean: padreInstance, field: "discapacidad")}</td>
					
						<td><g:formatBoolean boolean="${padreInstance.discursoContradictorio}" /></td>
					
						<td>${fieldValue(bean: padreInstance, field: "edad")}</td>
					
						<td>${fieldValue(bean: padreInstance, field: "horaLlegada")}</td>
					
						<td>${fieldValue(bean: padreInstance, field: "horaSalida")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${padreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
