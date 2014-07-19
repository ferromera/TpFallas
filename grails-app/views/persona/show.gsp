
<%@ page import="tpFallas.frame.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-persona" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list persona">
			
				<g:if test="${personaInstance?.adicciones}">
				<li class="fieldcontain">
					<span id="adicciones-label" class="property-label"><g:message code="persona.adicciones.label" default="Adicciones" /></span>
					
						<g:each in="${personaInstance.adicciones}" var="a">
						<span class="property-value" aria-labelledby="adicciones-label"><g:link controller="adiccion" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.discapacidad}">
				<li class="fieldcontain">
					<span id="discapacidad-label" class="property-label"><g:message code="persona.discapacidad.label" default="Discapacidad" /></span>
					
						<span class="property-value" aria-labelledby="discapacidad-label"><g:fieldValue bean="${personaInstance}" field="discapacidad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.edad}">
				<li class="fieldcontain">
					<span id="edad-label" class="property-label"><g:message code="persona.edad.label" default="Edad" /></span>
					
						<span class="property-value" aria-labelledby="edad-label"><g:fieldValue bean="${personaInstance}" field="edad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.ingresos}">
				<li class="fieldcontain">
					<span id="ingresos-label" class="property-label"><g:message code="persona.ingresos.label" default="Ingresos" /></span>
					
						<span class="property-value" aria-labelledby="ingresos-label"><g:fieldValue bean="${personaInstance}" field="ingresos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.relaciones}">
				<li class="fieldcontain">
					<span id="relaciones-label" class="property-label"><g:message code="persona.relaciones.label" default="Relaciones" /></span>
					
						<g:each in="${personaInstance.relaciones}" var="r">
						<span class="property-value" aria-labelledby="relaciones-label"><g:link controller="relacion" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.trabaja}">
				<li class="fieldcontain">
					<span id="trabaja-label" class="property-label"><g:message code="persona.trabaja.label" default="Trabaja" /></span>
					
						<span class="property-value" aria-labelledby="trabaja-label"><g:formatBoolean boolean="${personaInstance?.trabaja}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personaInstance?.id}" />
					<g:link class="edit" action="edit" id="${personaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
