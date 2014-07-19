<%@ page import="tpFallas.frame.Adiccion" %>



<div class="fieldcontain ${hasErrors(bean: adiccionInstance, field: 'adicto', 'error')} required">
	<label for="adicto">
		<g:message code="adiccion.adicto.label" default="Adicto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="adicto" from="${tpFallas.frame.Adiccion$Adicto?.values()}" keys="${tpFallas.frame.Adiccion$Adicto.values()*.name()}" required="" value="${adiccionInstance?.adicto?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adiccionInstance, field: 'estaEnTratamiento', 'error')} ">
	<label for="estaEnTratamiento">
		<g:message code="adiccion.estaEnTratamiento.label" default="Esta En Tratamiento" />
		
	</label>
	<g:checkBox name="estaEnTratamiento" value="${adiccionInstance?.estaEnTratamiento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: adiccionInstance, field: 'grado', 'error')} required">
	<label for="grado">
		<g:message code="adiccion.grado.label" default="Grado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="grado" type="number" value="${adiccionInstance.grado}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: adiccionInstance, field: 'tipoSustancia', 'error')} required">
	<label for="tipoSustancia">
		<g:message code="adiccion.tipoSustancia.label" default="Tipo Sustancia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoSustancia" from="${tpFallas.frame.Adiccion$TipoSustancia?.values()}" keys="${tpFallas.frame.Adiccion$TipoSustancia.values()*.name()}" required="" value="${adiccionInstance?.tipoSustancia?.name()}"/>
</div>
