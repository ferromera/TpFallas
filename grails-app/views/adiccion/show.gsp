
<%@ page import="tpFallas.frame.Adiccion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'adiccion.label', default: 'Adiccion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-adiccion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-adiccion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list adiccion">
			
				<g:if test="${adiccionInstance?.adicto}">
				<li class="fieldcontain">
					<span id="adicto-label" class="property-label"><g:message code="adiccion.adicto.label" default="Adicto" /></span>
					
						<span class="property-value" aria-labelledby="adicto-label"><g:fieldValue bean="${adiccionInstance}" field="adicto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adiccionInstance?.estaEnTratamiento}">
				<li class="fieldcontain">
					<span id="estaEnTratamiento-label" class="property-label"><g:message code="adiccion.estaEnTratamiento.label" default="Esta En Tratamiento" /></span>
					
						<span class="property-value" aria-labelledby="estaEnTratamiento-label"><g:formatBoolean boolean="${adiccionInstance?.estaEnTratamiento}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${adiccionInstance?.grado}">
				<li class="fieldcontain">
					<span id="grado-label" class="property-label"><g:message code="adiccion.grado.label" default="Grado" /></span>
					
						<span class="property-value" aria-labelledby="grado-label"><g:fieldValue bean="${adiccionInstance}" field="grado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${adiccionInstance?.tipoSustancia}">
				<li class="fieldcontain">
					<span id="tipoSustancia-label" class="property-label"><g:message code="adiccion.tipoSustancia.label" default="Tipo Sustancia" /></span>
					
						<span class="property-value" aria-labelledby="tipoSustancia-label"><g:fieldValue bean="${adiccionInstance}" field="tipoSustancia"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${adiccionInstance?.id}" />
					<g:link class="edit" action="edit" id="${adiccionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
