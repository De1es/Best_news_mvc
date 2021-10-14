<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="<c:url value="/resources/CSS/main.css"/>" rel="stylesheet">
    <title>Deleting news</title>
  </head>
  <body>
    <div id="central_block">
      <p id = question_text>
        Are you sure you want to delete the news?
      </p>
      <div class="buttons">
        <form:form action="../deleteNews/${news.id}" method="post">
          <button class="button"  name="choice" value="1">
            Yes
          </button>
          <button class="button" name="choice" value="0">
            No
          </button>
        </form:form>
      </div>

    </div>
  </body>
</html>
