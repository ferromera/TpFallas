<%@ page import="tpFallas.frame.Nino" %>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="nino.nombre.label" default="Nombre"/>
	</label>
	<g:textField name="nombre"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'apellido', 'error')} ">
	<label for="apellido">
		<g:message code="nino.apellido.label" default="Apellido"/>
	</label>
	<g:textField name="apellido"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'adicciones', 'error')} ">
	<label for="adicciones">
		<g:message code="nino.adicciones.label" default="Adicciones" />
		
	</label>
	<g:select name="adicciones" from="${tpFallas.frame.Adiccion.list()}" multiple="multiple" optionKey="id" size="5" value="${ninoInstance?.adicciones*.id}" class="many-to-many"/>
	<g:link  controller="adiccion" action="create" params="[persona:'nino']">Agregar Adiccion</g:link>
	<a  href="#" onclick="editAdiccion()">Editar Adicci&oacute;n</a>
</div>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'relaciones', 'error')} ">
	<label for="relaciones">
		<g:message code="nino.relaciones.label" default="Relaciones" />
		
	</label>
	<g:select name="relaciones" from="${tpFallas.frame.Relacion.list()}" multiple="multiple" optionKey="id" size="5" value="${ninoInstance?.relaciones*.id}" class="many-to-many"/>
	<g:link  controller="relacion" action="create" params="[persona:'nino']">Agregar Relacion</g:link>
	<a  href="#" onclick="editRelacion()">Editar Relaci&oacute;n</a>
</div>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'discapacidad', 'error')} required">
	<label for="discapacidad">
		<g:message code="nino.discapacidad.label" default="Discapacidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="discapacidad" type="number" value="${ninoInstance.discapacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: ninoInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="nino.edad.label" default="Edad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" value="${ninoInstance.edad}" required=""/>
</div>

<r:script>
function editAdiccion() {
	var adiccion =  jQuery('#adicciones').val(); 
	window.location.href = '${createLink(controller:'adiccion', action:'edit', params:[persona:'nino'])}' + "&id=" + adiccion;
}

function editRelacion() {
	var relacion =  jQuery('#relaciones').val(); 
	window.location.href = '${createLink(controller:'relacion', action:'edit', params:[persona:'nino'])}' + "&id=" + relacion;
}


</r:script>


