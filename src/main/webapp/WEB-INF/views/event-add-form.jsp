<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.11.18
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="template/header.jsp"/>

<table>
    <tbody>
    <form:form modelAttribute="eventCreationForm" method="post">
        <tr>
            <td>Kategoria:</td>
            <td><form:select path="category" items="${categoryList}"
                    itemLabel="name" itemValue="id" /></td>
        </tr>
        <tr>
            <td>Data rozpoczęcia:</td>
            <td><form:input type="date" path="startDate"/><form:errors path="startDate"/> </td>
        </tr>
        <tr>
            <td>Data zakończenia:</td>
            <td><form:input type="date" path="endDate"/><form:errors path="endDate"/> </td>
        </tr>
        <tr>
            <td>Miasto:</td>
            <td><form:input path="city"/><form:errors path="city"/> </td>
        </tr>
        <tr>
            <td>Ulica i numer domu:</td>
            <td><form:input path="street"/><form:errors path="street"/> </td>
        </tr>
        <tr>
            <td>Opis eventu:</td>
            <td><form:textarea cssStyle="width:700px" path="description"/><form:errors path="description"/> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Dodaj event"></td>
        </tr>
    </form:form>
    </tbody>
</table>

<jsp:include page="template/footer.jsp"/>
