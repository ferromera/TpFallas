
<%@ page import="tpFallas.frame.Madre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'madre.label', default: 'Madre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-madre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-madre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="condicionNoContacto" title="${message(code: 'madre.condicionNoContacto.label', default: 'Condicion No Contacto')}" />
					
						<g:sortableColumn property="discapacidad" title="${message(code: 'madre.discapacidad.label', default: 'Discapacidad')}" />
					
						<g:sortableColumn property="edad" title="${message(code: 'madre.edad.label', default: 'Edad')}" />
					
						<g:sortableColumn property="ingresos" title="${message(code: 'madre.ingresos.label', default: 'Ingresos')}" />
					
						<g:sortableColumn property="trabaja" title="${message(code: 'madre.trabaja.label', default: 'Trabaja')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${madreInstanceList}" status="i" var="madreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${madreInstance.id}">${fieldValue(bean: madreInstance, field: "condicionNoContacto")}</g:link></td>
					
						<td>${fieldValue(bean: madreInstance, field: "discapacidad")}</td>
					
						<td>${fieldValue(bean: madreInstance, field: "edad")}</td>
					
						<td>${fieldValue(bean: madreInstance, field: "ingresos")}</td>
					
						<td><g:formatBoolean boolean="${madreInstance.trabaja}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${madreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
