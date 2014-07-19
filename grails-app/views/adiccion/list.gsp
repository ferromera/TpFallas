
<%@ page import="tpFallas.frame.Adiccion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'adiccion.label', default: 'Adiccion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-adiccion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-adiccion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="adicto" title="${message(code: 'adiccion.adicto.label', default: 'Adicto')}" />
					
						<g:sortableColumn property="estaEnTratamiento" title="${message(code: 'adiccion.estaEnTratamiento.label', default: 'Esta En Tratamiento')}" />
					
						<g:sortableColumn property="grado" title="${message(code: 'adiccion.grado.label', default: 'Grado')}" />
					
						<g:sortableColumn property="tipoSustancia" title="${message(code: 'adiccion.tipoSustancia.label', default: 'Tipo Sustancia')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${adiccionInstanceList}" status="i" var="adiccionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${adiccionInstance.id}">${fieldValue(bean: adiccionInstance, field: "adicto")}</g:link></td>
					
						<td><g:formatBoolean boolean="${adiccionInstance.estaEnTratamiento}" /></td>
					
						<td>${fieldValue(bean: adiccionInstance, field: "grado")}</td>
					
						<td>${fieldValue(bean: adiccionInstance, field: "tipoSustancia")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${adiccionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
