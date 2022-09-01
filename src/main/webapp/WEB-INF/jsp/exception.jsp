<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parchis_oca" tagdir="/WEB-INF/tags" %>

<parchis_oca:layout pageName="error">

    <spring:url value="/resources/images/parchisoca.png" var="parchisoca"/>
    <img src="${parchisoca}"/>

    <h2>An error occurred</h2>

    <p>${exception.message}</p>

</parchis_oca:layout>


