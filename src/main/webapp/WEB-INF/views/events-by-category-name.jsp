<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 28.11.18
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>

<c:forEach items="${eventsByCategoryName}" var="event">


    <h2>${event.name}</h2>
    <p>${event.description}</p>
    <a href="/details/${event.id}">Szczegóły</a>

</c:forEach>


<jsp:include page="template/footer.jsp" />
