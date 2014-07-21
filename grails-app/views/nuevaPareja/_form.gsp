<%@ page import="tpFallas.frame.NuevaPareja" %>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="nuevaPareja.nombre.label" default="Nombre"/>
	</label>
	<g:textField name="nombre"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'apellido', 'error')} ">
	<label for="apellido">
		<g:message code="nuevaPareja.apellido.label" default="Apellido"/>
	</label>
	<g:textField name="apellido"/>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'adicciones', 'error')} ">
	<label for="adicciones">
		<g:message code="nuevaPareja.adicciones.label" default="Adicciones" />
		
	</label>
	<g:select name="adicciones" from="${tpFallas.frame.Adiccion.list()}" multiple="multiple" optionKey="id" size="5" value="${nuevaParejaInstance?.adicciones*.id}" class="many-to-many"/>
	<g:link  controller="adiccion" action="create" params="[persona:'nuevaPareja']">Agregar Adiccion</g:link>
	<a  href="#" onclick="editAdiccion()">Editar Adicci&oacute;n</a>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'relaciones', 'error')} ">
	<label for="relaciones">
		<g:message code="nuevaPareja.relaciones.label" default="Relaciones" />
		
	</label>
	<g:select name="relaciones" from="${tpFallas.frame.Relacion.list()}" multiple="multiple" optionKey="id" size="5" value="${nuevaParejaInstance?.relaciones*.id}" class="many-to-many"/>
	<g:link  controller="relacion" action="create" params="[persona:'nuevaPareja']">Agregar Relacion</g:link>
	<a  href="#" onclick="editRelacion()">Editar Relaci&oacute;n</a>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="nuevaPareja.edad.label" default="Edad (10-120)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" value="${nuevaParejaInstance.edad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'discapacidad', 'error')} required">
	<label for="discapacidad">
		<g:message code="nuevaPareja.discapacidad.label" default="Discapacidad (0-5)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="discapacidad" type="number" value="${nuevaParejaInstance.discapacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'trabaja', 'error')} ">
	<label for="trabaja">
		<g:message code="nuevaPareja.trabaja.label" default="Trabaja" />
		
	</label>
	<g:checkBox name="trabaja" value="${nuevaParejaInstance?.trabaja}" />
</div>

<div class="fieldcontain ${hasErrors(bean: nuevaParejaInstance, field: 'ingresos', 'error')} required">
	<label for="ingresos">
		<g:message code="nuevaPareja.ingresos.label" default="Ingresos (0-500000)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ingresos" type="number" value="${nuevaParejaInstance.ingresos}" required=""/>
</div>


<r:script>
function editAdiccion() {
	var adiccion =  jQuery('#adicciones').val(); 
	window.location.href = '${createLink(controller:'adiccion', action:'edit', params:[persona:'nuevaPareja'])}' + "&id=" + adiccion;
}

function editRelacion() {
	var relacion =  jQuery('#relaciones').val(); 
	window.location.href = '${createLink(controller:'relacion', action:'edit', params:[persona:'nuevaPareja'])}' + "&id=" + relacion;
}


</r:script>


