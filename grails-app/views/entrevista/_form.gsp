<%@ page import="tpFallas.frame.Entrevista" %>



<div class="fieldcontain ${hasErrors(bean: entrevistaInstance, field: 'participante', 'error')} required">
	<label for="participante">
		<g:message code="entrevista.participante.label" default="Participante" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="participante" name="participante.id" from="${tpFallas.frame.Persona.list()}" optionKey="id" required="" value="${entrevistaInstance?.participante?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: entrevistaInstance, field: 'resultado', 'error')} required">
	<label for="resultado">
		<g:message code="entrevista.resultado.label" default="Resultado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="resultado" type="number" value="${entrevistaInstance.resultado}" required=""/>
</div>

