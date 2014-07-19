
<%@ page import="tpFallas.frame.Vivienda" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vivienda.label', default: 'Vivienda')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vivienda" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vivienda" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vivienda">
			
				<g:if test="${viviendaInstance?.comparteCama}">
				<li class="fieldcontain">
					<span id="comparteCama-label" class="property-label"><g:message code="vivienda.comparteCama.label" default="Comparte Cama" /></span>
					
						<span class="property-value" aria-labelledby="comparteCama-label"><g:fieldValue bean="${viviendaInstance}" field="comparteCama"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${viviendaInstance?.cuidadoEnAusencia}">
				<li class="fieldcontain">
					<span id="cuidadoEnAusencia-label" class="property-label"><g:message code="vivienda.cuidadoEnAusencia.label" default="Cuidado En Ausencia" /></span>
					
						<span class="property-value" aria-labelledby="cuidadoEnAusencia-label"><g:fieldValue bean="${viviendaInstance}" field="cuidadoEnAusencia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${viviendaInstance?.habitabilidad}">
				<li class="fieldcontain">
					<span id="habitabilidad-label" class="property-label"><g:message code="vivienda.habitabilidad.label" default="Habitabilidad" /></span>
					
						<span class="property-value" aria-labelledby="habitabilidad-label"><g:fieldValue bean="${viviendaInstance}" field="habitabilidad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${viviendaInstance?.habitacionDelNino}">
				<li class="fieldcontain">
					<span id="habitacionDelNino-label" class="property-label"><g:message code="vivienda.habitacionDelNino.label" default="Habitacion Del Nino" /></span>
					
						<span class="property-value" aria-labelledby="habitacionDelNino-label"><g:formatBoolean boolean="${viviendaInstance?.habitacionDelNino}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${viviendaInstance?.propietario}">
				<li class="fieldcontain">
					<span id="propietario-label" class="property-label"><g:message code="vivienda.propietario.label" default="Propietario" /></span>
					
						<span class="property-value" aria-labelledby="propietario-label"><g:fieldValue bean="${viviendaInstance}" field="propietario"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${viviendaInstance?.riesgo}">
				<li class="fieldcontain">
					<span id="riesgo-label" class="property-label"><g:message code="vivienda.riesgo.label" default="Riesgo" /></span>
					
						<span class="property-value" aria-labelledby="riesgo-label"><g:fieldValue bean="${viviendaInstance}" field="riesgo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${viviendaInstance?.id}" />
					<g:link class="edit" action="edit" id="${viviendaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
