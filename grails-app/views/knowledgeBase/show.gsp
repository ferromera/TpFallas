
<%@ page import="tpFallas.knowledge.KnowledgeBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'knowledgeBase.label', default: 'KnowledgeBase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-knowledgeBase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-knowledgeBase" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list knowledgeBase">
			
				<g:if test="${knowledgeBaseInstance?.padre}">
				<li class="fieldcontain">
					<span id="padre-label" class="property-label"><g:message code="knowledgeBase.padre.label" default="Padre" /></span>
					
						<span class="property-value" aria-labelledby="padre-label"><g:link controller="padre" action="show" id="${knowledgeBaseInstance?.padre?.id}">${knowledgeBaseInstance?.padre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.madre}">
				<li class="fieldcontain">
					<span id="madre-label" class="property-label"><g:message code="knowledgeBase.madre.label" default="Madre" /></span>
					
						<span class="property-value" aria-labelledby="madre-label"><g:link controller="madre" action="show" id="${knowledgeBaseInstance?.madre?.id}">${knowledgeBaseInstance?.madre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.nino}">
				<li class="fieldcontain">
					<span id="nino-label" class="property-label"><g:message code="knowledgeBase.nino.label" default="Nino" /></span>
					
						<span class="property-value" aria-labelledby="nino-label"><g:link controller="nino" action="show" id="${knowledgeBaseInstance?.nino?.id}">${knowledgeBaseInstance?.nino?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.vivienda}">
				<li class="fieldcontain">
					<span id="vivienda-label" class="property-label"><g:message code="knowledgeBase.vivienda.label" default="Vivienda" /></span>
					
						<span class="property-value" aria-labelledby="vivienda-label"><g:link controller="vivienda" action="show" id="${knowledgeBaseInstance?.vivienda?.id}">${knowledgeBaseInstance?.vivienda?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.violencias}">
				<li class="fieldcontain">
					<span id="violencias-label" class="property-label"><g:message code="knowledgeBase.violencias.label" default="Violencias" /></span>
					
						<g:each in="${knowledgeBaseInstance.violencias}" var="v">
						<span class="property-value" aria-labelledby="violencias-label"><g:link controller="violenciaFamiliar" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.entrevistas}">
				<li class="fieldcontain">
					<span id="entrevistas-label" class="property-label"><g:message code="knowledgeBase.entrevistas.label" default="Entrevistas" /></span>
					
						<g:each in="${knowledgeBaseInstance.entrevistas}" var="e">
						<span class="property-value" aria-labelledby="entrevistas-label"><g:link controller="entrevista" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${knowledgeBaseInstance?.nuevaPareja}">
				<li class="fieldcontain">
					<span id="nuevaPareja-label" class="property-label"><g:message code="knowledgeBase.nuevaPareja.label" default="Nueva Pareja" /></span>
					
						<span class="property-value" aria-labelledby="nuevaPareja-label"><g:link controller="nuevaPareja" action="show" id="${knowledgeBaseInstance?.nuevaPareja?.id}">${knowledgeBaseInstance?.nuevaPareja?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${knowledgeBaseInstance?.id}" />
					<g:link class="edit" action="edit" id="${knowledgeBaseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="edit" action="evaluar" value="${message(code: 'default.button.evaluar.label', default: 'Evaluar')}" onclick="return confirm('${message(code: 'default.button.evaluar.confirm.message', default: 'Are you sure?')}');" />
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
