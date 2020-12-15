<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Search</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<div>
        <p>Search from Database:</p>
        <form action="/search" method="get">
            <input type="text" name="Name"><input type="submit" value="Search">
        </form>
    </div>
    
    <h2>Artists</h2>
	
	<c:forEach items="${ artists }" var="artist">
		<a href="/albums?ArtistId=${ artist.id }"><c:out value="${ artist.name }" /></a><br/>
	</c:forEach>

	<h2>Albums</h2>
	
	<c:forEach items="${ albums }" var="album">
		<c:out value="${ album.title }" /><br/>
	</c:forEach>
</body>
</html>