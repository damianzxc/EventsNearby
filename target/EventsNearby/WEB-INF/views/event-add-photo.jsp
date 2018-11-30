<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 29.11.18
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="template/header.jsp"/>

<form:form modelAttribute="eventCreationForm" method="POST"
           action="/create"
           enctype="multipart/form-data">
    <table>
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
            <td>Nazwa - krótki opis</td>
            <td><form:input path="name"/><form:errors path="name"/> </td>
        </tr>
        <tr>
            <td>Opis eventu:</td>
            <td><form:textarea cssStyle="width:700px" path="description"/><form:errors path="description"/> </td>
        </tr>
        <tr>
            <td>Dodaj plik PNG</td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

<jsp:include page="template/footer.jsp"/>