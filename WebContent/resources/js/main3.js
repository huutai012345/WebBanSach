$(document).ready(
		function() {
			let
			base_url = location.protocol + "//" + document.domain + ":"
					+ location.port + "/DoAnCuoiKi";
			$(".deleteBook").click(function(e) {
				let
				id = $(this).attr("book_id");
				$(".confirmDelete").click(function(e) {
					$.ajax({
						type : "GET",
						url : base_url + "/admin/book/delete/" + id + ".htm",
						success : function(data) {
							alert(data);
							location.reload();
						},
					});
				});
			});

			$(".deleteUser").click(function(e) {
				let
				id = $(this).attr("user_id");
				$(".confirmDelete").click(function(e) {
					$.ajax({
						type : "GET",
						url : base_url + "/admin/user/delete/" + id + ".htm",
						success : function(data) {
							alert(data);
							location.reload();
						},
					});
				});
			});
			
			$(".deleteOrderDetail").click(function(e) {
				let
				id = $(this).attr("orderDetail_id");
				$(".confirmDelete").click(function(e) {
					$.ajax({
						type : "GET",
						url : base_url + "/admin/order-detail/delete/" + id + ".htm",
						success : function(data) {
							alert(data);
							location.reload();
						},
					});
				});
			});

			$(".deleteCate").click(
					function(e) {
						let
						id = $(this).attr("cate_id");
						$(".confirmDelete").click(
								function(e) {
									$.ajax({
										type : "GET",
										url : base_url
												+ "/admin/category/delete/"
												+ id + ".htm",
										success : function(data) {
											alert(data);
											location.reload();
										},
									});
								});
					});
		});
