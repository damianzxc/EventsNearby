<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 29.11.18
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="template/header.jsp"/>

<div class="container-fluid">

    <!-- DataTables Example -->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" <%-- width="100%" <-segerguje wyniki, nie współgra z wyszukiwaniem po dacie--%> cellspacing="0">
                    <thead>
                    <tr>
                        <th>Nazwa</th>
                        <th>Adres</th>
                        <th>Kategoria</th>
                        <th>Start</th>
                        <th>Koniec</th>
                        <th>Opis</th>
                        <th>Link</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Nazwa</th>
                        <th>Adres</th>
                        <th>Kategoria</th>
                        <th>Start</th>
                        <th>Koniec</th>
                        <th>Opis</th>
                        <th>Link</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${userEvents}" var="event">
                        <tr>
                            <td>${event.name}</td>
                            <td>${event.city}<br/>
                                    ${event.street}</td>
                            <td>${event.category.name}</td>
                            <td>${event.startDate}</td>
                            <td>${event.endDate}</td>
                            <td>${event.description}</td>
                            <td>
                                <a href="delete/${event.id}">Usuń</a><br/>
                                <a href="/edit/${event.id}">Edytuj</a><br/>
                                <a href="/details/${event.id}">Szczegóły</a><br/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>
<!-- /.container-fluid -->


<jsp:include page="template/footer.jsp" />
</body>
</html>
