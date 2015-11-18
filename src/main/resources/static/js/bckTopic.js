$(document).ready(function() {
	$('#htmlInfo').summernote();
	$('#htmlInfo').code($("#inputHtml").val());
	$("#newSubTopic").submit(function(event) {
		$("#inputHtml").val($('#htmlInfo').code());
	});
});