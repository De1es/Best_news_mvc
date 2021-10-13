<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <title>Good News header</title>
    <link rel="stylesheet" href="resources/CSS/header.css">
  </head>
  <body>
    <header>
      <a href="/" id="header_text">GoodNews, everyone!</a>
      <form id="lang_ru" class="lang_buttons" action="Controller" method="post">
        <input type="hidden" name="command" value="change_locale">
        <button class="buttons_type" name="lang" value="ru">РУС</button>
      </form>
      <form id="lang_en" class="lang_buttons" action="Controller" method="post">
        <input type="hidden" name="command" value="change_locale">
        <button class="buttons_type" name="lang" value="en">EN</button>
      </form>
      <c:choose>
        <c:when test="${empty sessionScope.authorized_user}">
          <form id="authorisation_button" class="auth_reg_buttons" action="Controller"
                method="post">
            <input type="hidden" name="command" value="to_authorisation_page">
            <button class="buttons_type">${auth_button}</button>
          </form>
          <form id="registration_button" class="auth_reg_buttons" action="Controller"
                method="post">
            <input type="hidden" name="command" value="to_registration_page">
            <button class="buttons_type">${reg_button}</button>
          </form>
        </c:when>
        <c:otherwise>
          <form id="quit_button" class="auth_reg_buttons" action="Controller"
                method="post">
            <input type="hidden" name="command" value="logout_user">
            <button class="buttons_type">${quit_button}</button>
          </form>
          <form id="account_button" class="auth_reg_buttons" action="Controller"
                method="post">
            <input type="hidden" name="command" value="to_account_page">
            <button class="buttons_type">${account_button}</button>
          </form>
          <p id="user_in_header">${user_access}, ${sessionScope.authorized_user.login}</p>
        </c:otherwise>
      </c:choose>
    </header>
  </body>
</html>
