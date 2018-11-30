<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 23.11.18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="template/header.jsp"/>

<table>
    <tbody>
    <form:form modelAttribute="registrationFormData" method="post">
    <tr>
        <td>Login:</td>
        <td><form:input path="login"/><form:errors path="login"/> </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><form:input path="email"/><form:errors path="email"/> </td>
    </tr>
    <tr>
        <td>Hasło:</td>
        <td><form:input path="password"/><form:errors path="password"/> </td>
    </tr>
    <tr>
        <td>Powtórz hasło:</td>
        <td><form:input path="confirmedPassword"/><form:errors path="confirmedPassword"/> </td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Zarejestruj"></td>
    </tr>
    </form:form>
    </tbody>
</table>

<jsp:include page="template/footer.jsp"/>