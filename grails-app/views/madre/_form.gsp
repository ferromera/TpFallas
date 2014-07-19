<%@ page import="tpFallas.frame.Madre" %>


<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="madre.nombre.label" default="Nombre"/>
	</label>
	<g:textField name="nombre"/>
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'apellido', 'error')} ">
	<label for="apellido">
		<g:message code="madre.apellido.label" default="Apellido"/>
	</label>
	<g:textField name="apellido"/>
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'adicciones', 'error')} ">
	<label for="adicciones">
		<g:message code="madre.adicciones.label" default="Adicciones" />
		
	</label>
	<g:select name="adicciones" from="${tpFallas.frame.Adiccion.list()}" multiple="multiple" optionKey="id" size="5" value="${madreInstance?.adicciones*.id}" class="many-to-many"/>
	<g:link  controller="adiccion" action="create" params="[persona:'madre']">Agregar Adiccion</g:link>
	<a  href="#" onclick="editAdiccion()">Editar Adicci&oacute;n</a>
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'relaciones', 'error')} ">
	<label for="relaciones">
		<g:message code="madre.relaciones.label" default="Relaciones" />
		
	</label>
	<g:select name="relaciones" from="${tpFallas.frame.Relacion.list()}" multiple="multiple" optionKey="id" size="5" value="${madreInstance?.relaciones*.id}" class="many-to-many"/>
	<g:link  controller="relacion" action="create" params="[persona:'madre']">Agregar Relacion</g:link>
	<a  href="#" onclick="editRelacion()">Editar Relaci&oacute;n</a>
</div>


<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'condicionNoContacto', 'error')} ">
	<label for="condicionNoContacto">
		<g:message code="madre.condicionNoContacto.label" default="Condicion No Contacto" />
		
	</label>
	<g:checkBox name="condicionNoContacto" value="${madreInstance?.condicionNoContacto}" />
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'discapacidad', 'error')} required">
	<label for="discapacidad">
		<g:message code="madre.discapacidad.label" default="Discapacidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="discapacidad" type="number" value="${madreInstance.discapacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="madre.edad.label" default="Edad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" value="${madreInstance.edad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'trabaja', 'error')} ">
	<label for="trabaja">
		<g:message code="madre.trabaja.label" default="Trabaja" />
		
	</label>
	<g:checkBox name="trabaja" value="${madreInstance?.trabaja}" />
</div>

<div class="fieldcontain ${hasErrors(bean: madreInstance, field: 'ingresos', 'error')} required">
	<label for="ingresos">
		<g:message code="madre.ingresos.label" default="Ingresos" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ingresos" type="number" value="${madreInstance.ingresos}" required=""/>
</div>

<r:script>
function editAdiccion() {
	var adiccion =  jQuery('#adicciones').val(); 
	window.location.href = '${createLink(controller:'adiccion', action:'edit', params:[persona:'madre'])}' + "&id=" + adiccion;
}

function editRelacion() {
	var relacion =  jQuery('#relaciones').val(); 
	window.location.href = '${createLink(controller:'relacion', action:'edit', params:[persona:'madre'])}' + "&id=" + relacion;
}


</r:script>




