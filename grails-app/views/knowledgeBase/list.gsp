
<%@ page import="tpFallas.knowledge.KnowledgeBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'knowledgeBase.label', default: 'KnowledgeBase')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-knowledgeBase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-knowledgeBase" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="knowledgeBase.padre.label" default="Padre" /></th>
					
						<th><g:message code="knowledgeBase.madre.label" default="Madre" /></th>
					
						<th><g:message code="knowledgeBase.nino.label" default="Nino" /></th>
					
						<th><g:message code="knowledgeBase.vivienda.label" default="Vivienda" /></th>
					
						<th><g:message code="knowledgeBase.nuevaPareja.label" default="Nueva Pareja" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${knowledgeBaseInstanceList}" status="i" var="knowledgeBaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${knowledgeBaseInstance.id}">${fieldValue(bean: knowledgeBaseInstance, field: "padre")}</g:link></td>
					
						<td>${fieldValue(bean: knowledgeBaseInstance, field: "madre")}</td>
					
						<td>${fieldValue(bean: knowledgeBaseInstance, field: "nino")}</td>
					
						<td>${fieldValue(bean: knowledgeBaseInstance, field: "vivienda")}</td>
					
						<td>${fieldValue(bean: knowledgeBaseInstance, field: "nuevaPareja")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${knowledgeBaseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
