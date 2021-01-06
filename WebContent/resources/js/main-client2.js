$(document).ready(function () {
  let base_url =
    location.protocol +
    "//" +
    document.domain +
    ":" +
    location.port +
    "/DoAnCuoiKi";
  $("#amount").val(1);
  $("#amount").css({ height: "40px", width: "70px" });

  $("#add-cart").click(function (e) {
    let id = $(this).attr("book_id");
    let amount = $("#amount").val();
    $.ajax({
      type: "GET",
      url: base_url + "/add-cart/" + id + ".htm?amount=" + amount,
      success: function (data) {
        alert(data);
        location.reload();
      },
    });
  });

  $("#buy-now").click(function (e) {
    let id = $(this).attr("book_id");
    let amount = $("#amount").val();
    $.ajax({
      type: "GET",
      url: base_url + "/buy-now/" + id + ".htm?amount=" + amount,
      success: function (data) {
        if (data == "1") {
          window.location.href = base_url + "/checkout.htm";
        } else {
          alert(data);
          location.reload();
        }
      },
    });
  });

  $(".amount").on("change", function (e) {
    let id = $(this).attr("book_id");
    let amount = $(this).val();
    $.ajax({
      type: "GET",
      url: base_url + "/update-product/" + id + ".htm?amount=" + amount,
      success: function (data) {
    	if(data!="success")
    	{
    		alert(data);
    	}
        location.reload();
      },
    });
  });
});
