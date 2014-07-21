<%@ page import="tpFallas.knowledge.KnowledgeBase" %>




<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'padre', 'error')} required">
	<label for="padre">
		<g:message code="knowledgeBase.padre.label" default="Padre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="" name="padre.id" from="${tpFallas.frame.Padre.list()}" optionKey="id" required="" noSelection="['':'-Elija o cree una nueva persona-']" value="${knowledgeBaseInstance?.padre?.id}" class="many-to-one"/>
	
	<g:link  controller="padre" action="create">Agregar Padre</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'madre', 'error')} required">
	<label for="madre">
		<g:message code="knowledgeBase.madre.label" default="Madre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="madre" name="madre.id" from="${tpFallas.frame.Madre.list()}" optionKey="id" required="" noSelection="['':'-Elija o cree una nueva persona-']" value="${knowledgeBaseInstance?.madre?.id}" class="many-to-one"/>
	<g:link  controller="madre" action="create">Agregar Madre</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'nino', 'error')} required">
	<label for="nino">
		<g:message code="knowledgeBase.nino.label" default="Nino" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="nino" name="nino.id" from="${tpFallas.frame.Nino.list()}" optionKey="id" required="" noSelection="['':'-Elija o cree una nueva persona-']" value="${knowledgeBaseInstance?.nino?.id}" class="many-to-one"/>
	<g:link  controller="nino" action="create">Agregar Niño</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'vivienda', 'error')} required">
	<label for="vivienda">
		<g:message code="knowledgeBase.vivienda.label" default="Vivienda" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vivienda" name="vivienda.id" from="${tpFallas.frame.Vivienda.list()}" optionKey="id" required="" noSelection="['':'-Elija o cree una nueva vivienda-']" value="${knowledgeBaseInstance?.vivienda?.id}" class="many-to-one"/>
	<g:link  controller="vivienda" action="create">Agregar Vivienda</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'violencias', 'error')} ">
	<label for="violencias">
		<g:message code="knowledgeBase.violencias.label" default="Violencias" />
		
	</label>
	<g:select name="violencias" from="${tpFallas.frame.ViolenciaFamiliar.list()}" multiple="multiple" optionKey="id" size="5" noSelection="['':'-Elija o cree caso de violencia-']" value="${knowledgeBaseInstance?.violencias*.id}" class="many-to-many"/>
	<g:link  controller="violenciaFamiliar" action="create">Agregar Violencia</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'entrevistas', 'error')} ">
	<label for="entrevistas">
		<g:message code="knowledgeBase.entrevistas.label" default="Entrevistas" />
		
	</label>
	<g:select name="entrevistas" from="${tpFallas.frame.Entrevista.list()}" multiple="multiple" optionKey="id" size="5"  noSelection="['':'-Elija o cree el resulta de una entrevista-']" value="${knowledgeBaseInstance?.entrevistas*.id}" class="many-to-many"/>
	<g:link  controller="entrevista" action="create">Agregar Entrevista</g:link>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeBaseInstance, field: 'nuevaPareja', 'error')}">
	<label for="nuevaPareja">
		<g:message code="knowledgeBase.nuevaPareja.label" default="Nueva Pareja" />
		
	</label>
	<g:select id="nuevaPareja" name="nuevaPareja.id" from="${tpFallas.frame.NuevaPareja.list()}" optionKey="id" noSelection="['null':'-Elija o cree una nueva persona-']" value="${knowledgeBaseInstance?.nuevaPareja?.id}" class="many-to-one"/>
	<g:link  controller="nuevaPareja" action="create">Agregar Pareja</g:link>
</div>

