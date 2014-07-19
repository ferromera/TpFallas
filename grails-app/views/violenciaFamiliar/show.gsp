
<%@ page import="tpFallas.frame.ViolenciaFamiliar" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-violenciaFamiliar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-violenciaFamiliar" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list violenciaFamiliar">
			
				<g:if test="${violenciaFamiliarInstance?.autor}">
				<li class="fieldcontain">
					<span id="autor-label" class="property-label"><g:message code="violenciaFamiliar.autor.label" default="Autor" /></span>
					
						<span class="property-value" aria-labelledby="autor-label"><g:link controller="persona" action="show" id="${violenciaFamiliarInstance?.autor?.id}">${violenciaFamiliarInstance?.autor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${violenciaFamiliarInstance?.destinatario}">
				<li class="fieldcontain">
					<span id="destinatario-label" class="property-label"><g:message code="violenciaFamiliar.destinatario.label" default="Destinatario" /></span>
					
						<span class="property-value" aria-labelledby="destinatario-label"><g:link controller="persona" action="show" id="${violenciaFamiliarInstance?.destinatario?.id}">${violenciaFamiliarInstance?.destinatario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${violenciaFamiliarInstance?.tipoViolencia}">
				<li class="fieldcontain">
					<span id="tipoViolencia-label" class="property-label"><g:message code="violenciaFamiliar.tipoViolencia.label" default="Tipo Violencia" /></span>
					
						<span class="property-value" aria-labelledby="tipoViolencia-label"><g:fieldValue bean="${violenciaFamiliarInstance}" field="tipoViolencia"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${violenciaFamiliarInstance?.id}" />
					<g:link class="edit" action="edit" id="${violenciaFamiliarInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
