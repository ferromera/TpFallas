
<%@ page import="tpFallas.frame.Nino" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nino.label', default: 'Nino')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-nino" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-nino" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="discapacidad" title="${message(code: 'nino.discapacidad.label', default: 'Discapacidad')}" />
					
						<g:sortableColumn property="edad" title="${message(code: 'nino.edad.label', default: 'Edad')}" />
					
						<g:sortableColumn property="ingresos" title="${message(code: 'nino.ingresos.label', default: 'Ingresos')}" />
					
						<g:sortableColumn property="trabaja" title="${message(code: 'nino.trabaja.label', default: 'Trabaja')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ninoInstanceList}" status="i" var="ninoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ninoInstance.id}">${fieldValue(bean: ninoInstance, field: "discapacidad")}</g:link></td>
					
						<td>${fieldValue(bean: ninoInstance, field: "edad")}</td>
					
						<td>${fieldValue(bean: ninoInstance, field: "ingresos")}</td>
					
						<td><g:formatBoolean boolean="${ninoInstance.trabaja}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ninoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
