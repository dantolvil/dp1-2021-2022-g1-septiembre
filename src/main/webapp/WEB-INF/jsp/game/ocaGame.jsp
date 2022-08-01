<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ page import="org.springframework.samples.parchis_oca.enums.GameStatus" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="parchisoca" tagdir="/WEB-INF/tags" %>

<%@ page import="org.springframework.samples.parchis_oca.enums.GameMovement" %>

<!-- <parchis_oca:gameLayout pageName="New Oca game">-->

    <div class="row">
        <div class="col-md-5">
            <h2 class="text-decoration-underline"> Oca </h2>
        </div>
        <div class="col-md-7">
            <spring:url value="{gameId}/quit" var="quitURL">
                <spring:param name="gameId" value="${game.Id}" />
            </spring:url>
            <a class="btn btn-danger m-1" href=${fn:escapeXml(quitURL)}>Quit</a>

        </div>
    </div>


    <div class="row">
        <div class="col-md-9">
            <c:if test="${game.status == 'FINISHED'}">
                <h5>The game has finished. The winner is ${game.winner.firstname}. You can press the Quit button
                    to exit.</h5>
            </c:if>
            <!-- <parchis_oca:oca oca="${game.gameboard}" /> -->
            <c:forEach items="${game.gameboard.fields}" var="field">
                <!-- <parchis_oca:ocaBoardField size="100" field="${field}" /> -->
            </c:forEach>
            <c:forEach items="${game.other_players}" var="player">
                <c:forEach items="${player.gamePieces}" var="piece">
                  <!-- <parchis_oca:ocaPiece size="100" piece="${piece}" /> -->
                </c:forEach>
            </c:forEach>
            <c:forEach items="${game.creator.gamePieces}" var="piece">
               <!--  <parchisoca:ocaPiece size="100" piece="${piece}" />  -->
            </c:forEach>
        </div>


        <div class="col-md-3">
            <div class="row">
                <table class="table table-hover table-striped table-condensed rounded-3"
                    style="background-color: #FFFFFF;">
                    <tr class="fw-bold">
                        <th>Last Plays</th>
                    </tr>
                    <tbody>
                        <c:forEach items="${game.history_board}" var="history">
                            <tr class="fw-bolder">
                                <td>
                                    <c:out value="${history}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <c:if test="${game.started}">
                <c:if test="${currentuser.myTurn}">
                    <h2>It's your turn</h2>
                    <c:if test="${game.actionMessage == 1}">
                        <h5>You entered a goose square, so you moved on to the next goose and rolled the dice again</h5>
                    </c:if>
                    <c:if test="${game.actionMessage == 2}">
                        <h5>You entered a dice square, so you moved on to the other dice and rolled the dice again</h5>
                    </c:if>
                    <c:if test="${game.actionMessage == 3}">
                        <h5>You entered a bridge square, so you jumped to the other bridge and rolled the dice again</h5>
                    </c:if>
      
                    <c:if test="${game.turn_state == GameMovement.START}">
                        <spring:url value="{gameId}/dice" var="diceUrl">
                            <spring:param name="gameId" value="${game.Id}" />
                        </spring:url>
                        <a href="${fn:escapeXml(diceUrl)}" class="btn btn-secondary active" role="button"
                            aria-pressed="true">Roll Dice</a>
                    </c:if>

                    <c:if test="${game.GameMovement == GameMovement.CHOOSEPLAYER || game.GameMovement == GameMovement.DIRECTPASSTURN}">
                        <h5> You rolled: ${game.dice}</h5>
                        <!-- <parchis_oca:dice number="${game.dice}" /> -->
                        <c:choose>
                            <c:when test="${game.gameboard.options.size()} == 1">
                                <h5>${game.options.get(0)}</h5>
                            </c:when>
                            <c:otherwise>

                                <table class="table table-hover table-striped table-condensed rounded-3"
                                    style="background-color: #FFFFFF;">
                                    <tr class="fw-bold">
                                        <th>Option</th>
                                        <th>Choose</th>
                                    </tr>
                                    <tbody>
                                        <c:forEach items="${game.gameboard.options}" var="option">
                                            <td>
                                                <c:out value="${option.text}" />
                                            </td>
                                            <td>
                                                <spring:url value="{gameid}/choice/{choiceid}" var="choiceUrl">
                                                    <spring:param name="choiceid" value="${option.number}" />
                                                    <spring:param name="gameid" value="${game.Id}" />
                                                </spring:url>
                                                <a href="${fn:escapeXml(choiceUrl)}" class="btn btn-secondary active"
                                                    role="button" aria-pressed="true">Choose</a>
                                            </td>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:if>
            </c:if>
        </div>
    </div>
<!-- </parchis_oca:gameLayout> -->
