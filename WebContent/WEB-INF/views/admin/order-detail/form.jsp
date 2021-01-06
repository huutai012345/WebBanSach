<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="control-group">
	<label class="control-label">ID Order</label>
	<div class="controls">
		<form:input path="order.id" class="input-xlarge" readonly="true"/>
	</div>
</div>
<div class="control-group">
	<label class="control-label">Book</label>
	<div class="controls">
		<form:select path="book.id" items="${books}" itemValue="id"
			itemLabel="name" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">Amount</label>
	<div class="controls">
		<form:input path="amount" class="input-xlarge" />
		<form:errors path="amount" />
	</div>
</div>
<div class="control-group">
	<label class="control-label">Order Date</label>
	<div class="controls">
		<form:input path="created_at" class="input-xlarge" readonly="true"/>
		<form:errors path="created_at" />
	</div>
</div>
