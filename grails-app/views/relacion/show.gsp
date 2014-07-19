
<%@ page import="tpFallas.frame.Relacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'relacion.label', default: 'Relacion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-relacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-relacion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list relacion">
			
				<g:if test="${relacionInstance?.desde}">
				<li class="fieldcontain">
					<span id="desde-label" class="property-label"><g:message code="relacion.desde.label" default="Desde" /></span>
					
						<span class="property-value" aria-labelledby="desde-label"><g:fieldValue bean="${relacionInstance}" field="desde"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${relacionInstance?.hacia}">
				<li class="fieldcontain">
					<span id="hacia-label" class="property-label"><g:message code="relacion.hacia.label" default="Hacia" /></span>
					
						<span class="property-value" aria-labelledby="hacia-label"><g:fieldValue bean="${relacionInstance}" field="hacia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${relacionInstance?.valor}">
				<li class="fieldcontain">
					<span id="valor-label" class="property-label"><g:message code="relacion.valor.label" default="Valor" /></span>
					
						<span class="property-value" aria-labelledby="valor-label"><g:fieldValue bean="${relacionInstance}" field="valor"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${relacionInstance?.id}" />
					<g:link class="edit" action="edit" id="${relacionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
