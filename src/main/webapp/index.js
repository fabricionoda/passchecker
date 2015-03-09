$(function() {
	validate();
	$("#password").keyup(function() {
		validate();
	});
});

function validate() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var obj = jQuery.parseJSON(request.responseText);
			percentage.innerHTML = obj.percentage + "%";
			description.innerHTML = obj.description;
		}
	}
	request.open("Get", document.URL + "check?pass="
			+ encodeURIComponent($("#password").val()), true);
	request.send();
}
