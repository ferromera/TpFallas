<%@ page import="tpFallas.frame.Padre" %>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="padre.nombre.label" default="Nombre"/>
	</label>
	<g:textField name="nombre"/>
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'apellido', 'error')} ">
	<label for="apellido">
		<g:message code="padre.apellido.label" default="Apellido"/>
	</label>
	<g:textField name="apellido"/>
</div>


<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'relaciones', 'error')} ">
	<label for="relaciones">
		<g:message code="padre.relaciones.label" default="Relaciones" />
		
	</label>
	<g:select name="relaciones" from="${tpFallas.frame.Relacion.list()}" multiple="multiple" optionKey="id" size="5" value="${padreInstance?.relaciones*.id}" class="many-to-many"/>
	<g:link  controller="relacion" action="create" params="[persona:'padre']">Agregar Relacion</g:link>
	<a  href="#" onclick="editRelacion()">Editar Relaci&oacute;n</a>
	
	
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'adicciones', 'error')} ">
	<label for="adicciones">
		<g:message code="padre.adicciones.label" default="Adicciones" />
		
	</label>
	<g:select name="adicciones" from="${tpFallas.frame.Adiccion.list()}" multiple="multiple" optionKey="id" size="5" value="${padreInstance?.adicciones*.id}" class="many-to-many"/>
	
	<g:link  controller="adiccion" action="create" params="[persona:'padre']">Agregar Adiccion</g:link>
	<a  href="#" onclick="editAdiccion()">Editar Adicci&oacute;n</a>
	
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'edad', 'error')} required">
	<label for="edad">
		<g:message code="padre.edad.label" default="Edad (10-120)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="edad" type="number" value="${padreInstance.edad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'cumpleCuotaAlimentaria', 'error')} ">
	<label for="cumpleCuotaAlimentaria">
		<g:message code="padre.cumpleCuotaAlimentaria.label" default="Cumple Cuota Alimentaria" />
		
	</label>
	<g:checkBox name="cumpleCuotaAlimentaria" value="${padreInstance?.cumpleCuotaAlimentaria}" />
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'discapacidad', 'error')} required">
	<label for="discapacidad">
		<g:message code="padre.discapacidad.label" default="Discapacidad (0-5)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="discapacidad" type="number" value="${padreInstance.discapacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'discursoContradictorio', 'error')} ">
	<label for="discursoContradictorio">
		<g:message code="padre.discursoContradictorio.label" default="Discurso Contradictorio" />
		
	</label>
	<g:checkBox name="discursoContradictorio" value="${padreInstance?.discursoContradictorio}" />
</div>



<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'horaLlegada', 'error')} required">
	<label for="horaLlegada">
		<g:message code="padre.horaLlegada.label" default="Hora Llegada" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="horaLlegada" type="number" value="${padreInstance.horaLlegada}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'horaSalida', 'error')} required">
	<label for="horaSalida">
		<g:message code="padre.horaSalida.label" default="Hora Salida" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="horaSalida" type="number" value="${padreInstance.horaSalida}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'trabaja', 'error')} ">
	<label for="trabaja">
		<g:message code="padre.trabaja.label" default="Trabaja" />
		
	</label>
	<g:checkBox name="trabaja" value="${padreInstance?.trabaja}" />
</div>

<div class="fieldcontain ${hasErrors(bean: padreInstance, field: 'ingresos', 'error')} required">
	<label for="ingresos">
		<g:message code="padre.ingresos.label" default="Ingresos (0-500000)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ingresos" type="number" value="${padreInstance.ingresos}" required=""/>
</div>

<r:script>
function editAdiccion() {
	var adiccion =  jQuery('#adicciones').val(); 
	window.location.href = '${createLink(controller:'adiccion', action:'edit', params:[persona:'padre'])}' + "&id=" + adiccion;
}

function editRelacion() {
	var relacion =  jQuery('#relaciones').val(); 
	window.location.href = '${createLink(controller:'relacion', action:'edit', params:[persona:'padre'])}' + "&id=" + relacion;
}


</r:script>





