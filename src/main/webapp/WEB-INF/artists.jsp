<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Artists</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Artists</h1>
	
	<p><small><i>Click the artist name to see albums or <a href="/formArtist.html">click here to add a new artist</a>.</i></small></p>
	<br>
	
	<c:forEach items="${ artists }" var="artist">
		<a href="/albums?ArtistId=${ artist.id }"><c:out value="${ artist.name }" /></a><br/>
	</c:forEach>
</body>
</html>