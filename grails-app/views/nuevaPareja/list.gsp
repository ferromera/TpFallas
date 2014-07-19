
<%@ page import="tpFallas.frame.NuevaPareja" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nuevaPareja.label', default: 'NuevaPareja')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-nuevaPareja" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-nuevaPareja" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="discapacidad" title="${message(code: 'nuevaPareja.discapacidad.label', default: 'Discapacidad')}" />
					
						<g:sortableColumn property="edad" title="${message(code: 'nuevaPareja.edad.label', default: 'Edad')}" />
					
						<g:sortableColumn property="ingresos" title="${message(code: 'nuevaPareja.ingresos.label', default: 'Ingresos')}" />
					
						<g:sortableColumn property="trabaja" title="${message(code: 'nuevaPareja.trabaja.label', default: 'Trabaja')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${nuevaParejaInstanceList}" status="i" var="nuevaParejaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${nuevaParejaInstance.id}">${fieldValue(bean: nuevaParejaInstance, field: "discapacidad")}</g:link></td>
					
						<td>${fieldValue(bean: nuevaParejaInstance, field: "edad")}</td>
					
						<td>${fieldValue(bean: nuevaParejaInstance, field: "ingresos")}</td>
					
						<td><g:formatBoolean boolean="${nuevaParejaInstance.trabaja}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${nuevaParejaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
