<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/CSS/main.css"/>" rel="stylesheet">
    <title>Best News</title>
  </head>
  <body>
    <div id="header">
      <a id="bestNews" href="${pageContext.request.contextPath}/">
        <h2>Best News</h2>
      </a>
    </div>
    <c:forEach items="${newsList}" var="news">
      <div class="news">
        <a id="news_title" href="${pageContext.request.contextPath}/news/${news.id}">
          <h3><c:out value="${news.title}"/></h3>
        </a>
        <p><c:out value="${news.brief}"/></p>
        <p id="time_in_news">
          <i><fmt:formatDate value="${news.date}" pattern="HH:mm dd MMMM yyyy"/></i>
        </p>
        <form action="${pageContext.request.contextPath}/news/update?id=${news.id}" method="post">
          <button class="button">Update</button>
        </form>
        <form action="${pageContext.request.contextPath}/news/delete/${news.id}" method="post">
          <button class="button">Delete</button>
        </form>
      </div>
    </c:forEach>
    <form id="pages" action="${pageContext.request.contextPath}/">
      <input type="hidden" name="currentPage" value="${currentPage}">
      <c:forEach items="${pages}" var="page">
        <button class="page" name="nextPage" value="${page}">
            ${page}
        </button>
      </c:forEach>
    </form>
  </body>
</html>
