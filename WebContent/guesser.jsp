<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your word here</title>
<script type="text/javascript" src="jquery.js"></script>
<script>
$(document).ready(function(){
	$("#word").focus();
	$(document).click(function(){
		$("#word").focus();
		});
});
</script>
<c:if test="${not empty errorMessage }">
	<script>
		alert('${errorMessage}');
	</script>
</c:if>
</head>
<body>
<form action="guessIt">
	<h3>Hi ${userId }</h3>
	Guess :
	<ul>
		<c:forEach items="${attempts }" var="attempt" varStatus="i">
			<li> Attempt ${i.index+1}:&nbsp;&nbsp;<b>${attempt.word }</b>&nbsp;&nbsp;-&nbsp;&nbsp;<b>BULLS :</b>${attempt.bulls }, <b>COWS :</b>${attempt.cows }
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Guessed By: </b>${attempt.guessedBy }
		</c:forEach>
		<li>Enter your Guess :<input id="word" name="word" maxlength="4" /><input type="submit" value="Check"/> </li>
	</ul>
	<div id="othersGuess" style="display:none;">
	View Guesses :
	<ul>
		<c:forEach items="${attempts }" var="attempt" varStatus="i">
			<li> Attempt ${i.index+1}:&nbsp;&nbsp;<b>${attempt.word }</b>&nbsp;&nbsp;-&nbsp;&nbsp;<b>BULLS :</b>${attempt.bulls }, <b>COWS :</b>${attempt.cows }
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Guessed By: </b>${attempt.guessedBy }
		</c:forEach>
		<li>Enter your Guess :<input id="word" name="word" maxlength="4" /><input type="submit" value="Check"/> </li>
	</ul>
	</div>
	
</form>
</body>
</html>