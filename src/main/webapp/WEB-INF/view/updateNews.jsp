<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <link href="<c:url value="/resources/CSS/main.css"/>" rel="stylesheet">
    <title>Update news</title>
  </head>
  <body>
    <div class="news">
      <h3>News updating page</h3><br>
      <form:form action="update" modelAttribute="news" method="PUT">
        <form:hidden path="id" value = "${news.id}"/>
        <form:hidden path="date" value = "${news.date}"/>
        Title: <br>
        <form:errors path="title" cssClass="error"/>
        <form:textarea cssClass="title_field" path="title" placeholder = "${news.title}"/><br>
        Brief:<br>
        <form:errors path="brief" cssClass="error"/>
        <form:textarea cssClass="brief_field" path="brief" placeholder = "${news.brief}"/><br>
        Content:<br>
        <form:errors path="content" cssClass="error"/>
        <form:textarea cssClass="content_field" path="content" placeholder = "${news.content}"/><br>
        <form:button value="Update"/>
        <input class="cr_news_button" type="submit" value="Update"><br>
      </form:form>
    </div>
  </body>
</html>
