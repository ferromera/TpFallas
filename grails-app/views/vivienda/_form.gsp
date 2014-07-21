<%@ page import="tpFallas.frame.Vivienda" %>


<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'habitacionDelNino', 'error')} ">
	<label for="habitacionDelNino">
		<g:message code="vivienda.habitacionDelNino.label" default="Habitacion Del Nino" />
		
	</label>
	<g:checkBox name="habitacionDelNino" value="${viviendaInstance?.habitacionDelNino}" />
</div>

<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'comparteCama', 'error')} required">
	<label for="comparteCama">
		<g:message code="vivienda.comparteCama.label" default="Comparte Cama" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="comparteCama" from="${tpFallas.frame.Vivienda$ComparteCama?.values()}" keys="${tpFallas.frame.Vivienda$ComparteCama.values()*.name()}" required="" value="${viviendaInstance?.comparteCama?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'cuidadoEnAusencia', 'error')} required">
	<label for="cuidadoEnAusencia">
		<g:message code="vivienda.cuidadoEnAusencia.label" default="Cuidado En Ausencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="cuidadoEnAusencia" from="${tpFallas.frame.Vivienda$CuidadoEnAusencia?.values()}" keys="${tpFallas.frame.Vivienda$CuidadoEnAusencia.values()*.name()}" required="" value="${viviendaInstance?.cuidadoEnAusencia?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'habitabilidad', 'error')} required">
	<label for="habitabilidad">
		<g:message code="vivienda.habitabilidad.label" default="Habitabilidad (-2 a +2 entero)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="habitabilidad" type="number" value="${viviendaInstance.habitabilidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'propietario', 'error')} ">
	<label for="propietario">
		<g:message code="vivienda.propietario.label" default="Propietario" />
		
	</label>
	<g:textField name="propietario" value="${viviendaInstance?.propietario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: viviendaInstance, field: 'riesgo', 'error')} required">
	<label for="riesgo">
		<g:message code="vivienda.riesgo.label" default="Riesgo (0 a 3 entero)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="riesgo" type="number" value="${viviendaInstance.riesgo}" required=""/>
</div>

