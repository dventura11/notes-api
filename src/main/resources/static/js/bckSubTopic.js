$(document).ready(function() {
	$('#subTopicHtmlEditor').summernote();
	$('#articleHtmlEditor').summernote();
	$("#setSubTopic").submit(function(event) {
		$("#subTopicHtml").val($('#subTopicHtmlEditor').code());
	});
	$("#addArticle").submit(function(event) {
		$("#articleHtml").val($('#articleHtmlEditor').code());
	});
});