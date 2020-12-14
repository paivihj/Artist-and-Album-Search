<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Artists</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Albums</h1>
	
	<c:forEach items="${ albums }" var="album">
		<c:out value="${ album.title }" /><br/>
	</c:forEach>
</body>
</html>