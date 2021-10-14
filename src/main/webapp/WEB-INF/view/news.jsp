<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <link href="<c:url value="/resources/CSS/main.css"/>" rel="stylesheet">
    <title>News page</title>
  </head>
  <body>
    <div id="header">
      <a id="bestNews" href="${pageContext.request.contextPath}/">
        <h2>Best News</h2>
      </a>
    </div>
    <div class="news">
      <h2 id="news_title" ><c:out value="${news.title}"/></h2>
      <p><c:out value="${news.content}"/></p>
      <p id="time_in_news">
        <i><fmt:formatDate value="${news.date}" pattern="HH:mm dd MMMM yyyy"/></i>
      </p>
    </div>
  </body>
</html>
