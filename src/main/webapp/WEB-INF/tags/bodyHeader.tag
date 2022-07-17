<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parchis_oca" tagdir="/WEB-INF/tags" %>

<%@ attribute name="menuName" required="true" rtexprvalue="true"
              description="Name of the active menu: home, players, games" %>

<parchis_oca:menu name="${menuName}"/>
