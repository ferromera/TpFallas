<%@ page import="tpFallas.frame.Persona" %>



<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'adicciones', 'error')} ">
	<label for="adicciones">
		<g:message code="persona.adicciones.label" default="Adicciones" />
		
	</label>
	<g:select name="adicciones" from="${tpFallas.frame.Adiccion.list()}" multiple="multiple" optionKey="id" size="5" value="${personaInstance?.adicciones*.id}" class="many-to-many"/>
	<g:link  controller="adiccion" action="create">Agregar Adiccion</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'discapacidad', 'error')} required">
	<label for="discapacidad">
		<g:message code="persona.discapacidad.label" default="Discapacidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="discapacidad" type="number" value="${personaInstance.discapacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="persona.edad.label" default="Edad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" value="${personaInstance.edad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'ingresos', 'error')} required">
	<label for="ingresos">
		<g:message code="persona.ingresos.label" default="Ingresos" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ingresos" type="number" value="${personaInstance.ingresos}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'relaciones', 'error')} ">
	<label for="relaciones">
		<g:message code="persona.relaciones.label" default="Relaciones" />
		
	</label>
	<g:select name="relaciones" from="${tpFallas.frame.Relacion.list()}" multiple="multiple" optionKey="id" size="5" value="${personaInstance?.relaciones*.id}" class="many-to-many"/>
	<g:link  controller="relacion" action="create">Agregar Relacion</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'trabaja', 'error')} ">
	<label for="trabaja">
		<g:message code="persona.trabaja.label" default="Trabaja" />
		
	</label>
	<g:checkBox name="trabaja" value="${personaInstance?.trabaja}" />
</div>

