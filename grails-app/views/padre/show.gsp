
<%@ page import="tpFallas.frame.Padre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'padre.label', default: 'Padre')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-padre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-padre" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list padre">
			
				<g:if test="${padreInstance?.adicciones}">
				<li class="fieldcontain">
					<span id="adicciones-label" class="property-label"><g:message code="padre.adicciones.label" default="Adicciones" /></span>
					
						<g:each in="${padreInstance.adicciones}" var="a">
						<span class="property-value" aria-labelledby="adicciones-label"><g:link controller="adiccion" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.cumpleCuotaAlimentaria}">
				<li class="fieldcontain">
					<span id="cumpleCuotaAlimentaria-label" class="property-label"><g:message code="padre.cumpleCuotaAlimentaria.label" default="Cumple Cuota Alimentaria" /></span>
					
						<span class="property-value" aria-labelledby="cumpleCuotaAlimentaria-label"><g:formatBoolean boolean="${padreInstance?.cumpleCuotaAlimentaria}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.discapacidad}">
				<li class="fieldcontain">
					<span id="discapacidad-label" class="property-label"><g:message code="padre.discapacidad.label" default="Discapacidad" /></span>
					
						<span class="property-value" aria-labelledby="discapacidad-label"><g:fieldValue bean="${padreInstance}" field="discapacidad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.discursoContradictorio}">
				<li class="fieldcontain">
					<span id="discursoContradictorio-label" class="property-label"><g:message code="padre.discursoContradictorio.label" default="Discurso Contradictorio" /></span>
					
						<span class="property-value" aria-labelledby="discursoContradictorio-label"><g:formatBoolean boolean="${padreInstance?.discursoContradictorio}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.edad}">
				<li class="fieldcontain">
					<span id="edad-label" class="property-label"><g:message code="padre.edad.label" default="Edad" /></span>
					
						<span class="property-value" aria-labelledby="edad-label"><g:fieldValue bean="${padreInstance}" field="edad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.horaLlegada}">
				<li class="fieldcontain">
					<span id="horaLlegada-label" class="property-label"><g:message code="padre.horaLlegada.label" default="Hora Llegada" /></span>
					
						<span class="property-value" aria-labelledby="horaLlegada-label"><g:fieldValue bean="${padreInstance}" field="horaLlegada"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.horaSalida}">
				<li class="fieldcontain">
					<span id="horaSalida-label" class="property-label"><g:message code="padre.horaSalida.label" default="Hora Salida" /></span>
					
						<span class="property-value" aria-labelledby="horaSalida-label"><g:fieldValue bean="${padreInstance}" field="horaSalida"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.ingresos}">
				<li class="fieldcontain">
					<span id="ingresos-label" class="property-label"><g:message code="padre.ingresos.label" default="Ingresos" /></span>
					
						<span class="property-value" aria-labelledby="ingresos-label"><g:fieldValue bean="${padreInstance}" field="ingresos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.relaciones}">
				<li class="fieldcontain">
					<span id="relaciones-label" class="property-label"><g:message code="padre.relaciones.label" default="Relaciones" /></span>
					
						<g:each in="${padreInstance.relaciones}" var="r">
						<span class="property-value" aria-labelledby="relaciones-label"><g:link controller="relacion" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${padreInstance?.trabaja}">
				<li class="fieldcontain">
					<span id="trabaja-label" class="property-label"><g:message code="padre.trabaja.label" default="Trabaja" /></span>
					
						<span class="property-value" aria-labelledby="trabaja-label"><g:formatBoolean boolean="${padreInstance?.trabaja}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${padreInstance?.id}" />
					<g:link class="edit" action="edit" id="${padreInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
