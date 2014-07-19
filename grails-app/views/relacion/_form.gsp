<%@ page import="tpFallas.frame.Relacion" %>



<div class="fieldcontain ${hasErrors(bean: relacionInstance, field: 'desde', 'error')} required">
	<label for="desde">
		<g:message code="relacion.desde.label" default="Desde" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="desde" from="${tpFallas.frame.Relacion$Participante?.values()}" keys="${tpFallas.frame.Relacion$Participante.values()*.name()}" required="" value="${relacionInstance?.desde?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: relacionInstance, field: 'hacia', 'error')} required">
	<label for="hacia">
		<g:message code="relacion.hacia.label" default="Hacia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="hacia" from="${tpFallas.frame.Relacion$Participante?.values()}" keys="${tpFallas.frame.Relacion$Participante.values()*.name()}" required="" value="${relacionInstance?.hacia?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: relacionInstance, field: 'valor', 'error')} required">
	<label for="valor">
		<g:message code="relacion.valor.label" default="Valor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valor" type="number" value="${relacionInstance.valor}" required=""/>
</div>

