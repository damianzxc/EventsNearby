<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 28.11.18
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="template/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <div class="card mt-4">
                <img class="card-img-top img-fluid" src="../../${eventDetails.photoURL}" alt="">
                <div class="card-body">
                    <h3 class="card-title">${eventDetails.name}</h3>
                    <h6>Od: ${eventDetails.startDate} Do: ${eventDetails.endDate}</h6>
                    <h4>${eventDetails.city}</h4>
                    <p class="card-text">${eventDetails.description}</p>
                    <p>${eventDetails.user.login}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="template/footer.jsp"/>
