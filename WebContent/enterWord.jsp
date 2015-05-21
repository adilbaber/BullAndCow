<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your word here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#word").focus();
	$(document).click(function(){
		$("#word").focus();
		});
});
</script>

<c:if test="${not empty successMsg }">
<script type="text/javascript">
	alert('You Found it!!! Post ur word now!!');
</script>
</c:if>
<c:if test="${not empty errorMessage }">
<script type="text/javascript">
	alert('${errorMessage}');
</script>
</c:if>
</head>
<body>
<h3>Welcome ${userId }</h3>
<form action="postWord">
	Enter a four letter word: <input id="word" name="word" maxlength="4"/>
	<input type="submit" value="Post" />
</form>
</body>
</html>