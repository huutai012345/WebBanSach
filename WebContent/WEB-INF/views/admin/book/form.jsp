<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="control-group">
	<label class="control-label">Name</label>
	<div class="controls">
		<form:input path="book.name" class="input-xlarge" />
		<form:errors path="book.name" />
	</div>
</div>

<div class="control-group">
	<label class="control-label">Author</label>
	<div class="controls">
		<form:input path="book.author" class="input-xlarge" />
		<form:errors path="book.author" />

	</div>
</div>

<div class="control-group">
	<label class="control-label">Category</label>
	<div class="controls">
		<form:select path="book.cate.id" items="${cates}" itemValue="id"
			itemLabel="name" />
	</div>
</div>

<div class="control-group">
	<label class="control-label">Price</label>
	<div class="controls">
		<form:input path="book.price" class="input-xlarge" />
		<form:errors path="book.price" />
	</div>
</div>

<div class="control-group">
	<label class="control-label">Quantity</label>
	<div class="controls">
		<form:input path="book.amount" class="input-xlarge" />
		<form:errors path="book.amount" />
	</div>
</div>

<div class="control-group">
	<label class="control-label">Img</label>
	<div class="controls">
		<input type="file" name="img" class="input-xlarge" value="D:/Image/PhamPhuong.jpg">
	</div>
</div>

<div class="control-group">
	<label class="control-label">Detail</label>
	<div class="controls">
		<form:textarea path="book.detail" rows="5" cols="250"
			class="input-xlarge" />
		<form:errors path="book.detail" />
	</div>
</div>