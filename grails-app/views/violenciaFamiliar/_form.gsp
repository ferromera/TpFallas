<%@ page import="tpFallas.frame.ViolenciaFamiliar" %>



<div class="fieldcontain ${hasErrors(bean: violenciaFamiliarInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="violenciaFamiliar.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="autor" name="autor.id" from="${tpFallas.frame.Persona.list()}" optionKey="id" required="" value="${violenciaFamiliarInstance?.autor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: violenciaFamiliarInstance, field: 'destinatario', 'error')} required">
	<label for="destinatario">
		<g:message code="violenciaFamiliar.destinatario.label" default="Destinatario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="destinatario" name="destinatario.id" from="${tpFallas.frame.Persona.list()}" optionKey="id" required="" value="${violenciaFamiliarInstance?.destinatario?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: violenciaFamiliarInstance, field: 'tipoViolencia', 'error')} required">
	<label for="tipoViolencia">
		<g:message code="violenciaFamiliar.tipoViolencia.label" default="Tipo Violencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoViolencia" from="${tpFallas.frame.ViolenciaFamiliar$TipoViolencia?.values()}" keys="${tpFallas.frame.ViolenciaFamiliar$TipoViolencia.values()*.name()}" required="" value="${violenciaFamiliarInstance?.tipoViolencia?.name()}"/>
</div>

