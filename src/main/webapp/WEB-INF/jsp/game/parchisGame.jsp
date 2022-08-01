<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ page import="org.springframework.samples.parchis_oca.enums.GameStatus" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="parchisoca" tagdir="/WEB-INF/tags" %>

<%@ page import="org.springframework.samples.parchis_oca.enums.GameMovement" %>

<!--<parchisoca:gameLayout pageName="New Parchis game">-->

    <div class="row">
        <div class="col-md-5">
            <h2 class="text-decoration-underline">Parchis</h2>
        </div>
        <div class="col-md-7">
            <spring:url value="{gameId}/quit" var="quitURL">
                <spring:param name="gameId" value="${game.Id}" />
            </spring:url>
            <a class="btn btn-danger m-1" href=${fn:escapeXml(quitURL)}>Quit</a>

            <input type="button" id="fpb" class="btn btn-info m-1 text-light" value="GamePieces">
        </div>
    </div>

    <div class="row">
        <div class="col-md-9">
            <c:if test="${game.status == 'FINISHED'}">
                <h5>The game has already finished. The winner is ${game.winner.firstname} You can press the Quit button
                    to exit.</h5>
            </c:if>
            <parchisoca:parchis parchis="${game.gameboard}" />
            <c:forEach items="${game.gameboard.fields}" var="field">
               <!-- <parchisoca:boardField size="40" field="${field}" /> -->
            </c:forEach>
            <c:forEach items="${game.otherPlayers}" var="player">
                <c:forEach items="${player.gamePieces}" var="piece">
                  <!-- <parchisoca:gamePiece size="40" piece="${piece}" /> -->
                </c:forEach>
            </c:forEach>
            <c:forEach items="${game.creator.gamePieces}" var="piece">
              <!-- <parchisoca:gamePiece size="40" piece="${piece}" />  -->
            </c:forEach>
        </div>

        <div class="col-md-3" style="position: relative;">
            <div class="p-3 border border-dark rounded-3 w-100" id="fpd"
                style="display:none; position: absolute; background-color: #C0C0C0; left: 0px; top: -25px;">
                <h5><span style="color: #FFFF00;">Yellow</span> pieces are finished: ${game.gameboard.yellowFinished}
                </h5>
                <h5><span style="color: #0890e3;">Blue</span> pieces are finished: ${game.gameboard.blueFinished}
                </h5>
                <h5><span style="color: #e32908;">Red</span> pieces are finished: ${game.gameboard.redFinished}</h5>
                <h5><span style="color: #26ca0c;">Green</span> pieces are finished: ${game.gameboard.greenFinished}
                </h5>
            </div>

            <c:if test="${game.started}">
                <div class="row">
                    <table class="table table-hover table-striped table-condensed rounded-3"
                        style="background-color: #FFFFFF;">
                        <tr class="fw-bold">
                            <th>Last Plays</th>
                        </tr>
                        <tbody>
                            <c:forEach items="${game.historyBoard}" var="history">
                                <tr class="fw-bolder">
                                    <td>
                                        <c:out value="${history}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>


                <c:if test="${currentuser.myTurn}">
                    <h3>It's your turn</h3>

                    <c:if test="${game.GameMovement == GameMovement.START}">
                        <spring:url value="{gameId}/dice" var="diceUrl">
                            <spring:param name="gameId" value="${game.Id}" />
                        </spring:url>
                        <a href="${fn:escapeXml(diceUrl)}" class="btn btn-secondary active" role="button"
                            aria-pressed="true">Roll Dice</a>
                    </c:if>


                    <c:if test="${game.GameMovement == GameMovement.CHOOSEPLAYER || game.GameMovement == GameMovement.DIRECTPASSTURN}">
                        <div class="row">
                            <h6> You rolled: ${game.dice}</h6>

                          <!-- <parchisoca:dice number="${game.dice}" />  -->

                            <c:choose>
                                <c:when test="${game.gameboard.options.size()} == 1">
                                    <h6>${game.options.get(0)}</h6>
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
                                                <tr>
                                                    <td>
                                                        <c:out value="${option.text}" />
                                                    </td>
                                                    <td>
                                                        <spring:url value="{gameid}/choice/{choiceid}" var="choiceUrl">
                                                            <spring:param name="choiceid" value="${option.number}" />
                                                            <spring:param name="gameid" value="${game.Id}" />
                                                        </spring:url>
                                                        <a href="${fn:escapeXml(choiceUrl)}"
                                                            class="btn btn-secondary active" role="button"
                                                            aria-pressed="true">Choose</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:if>

                    <c:if test="${game.GameMovement == GameMovement.CHOOSEEXTRATURN}">
                        <div class="row">
                            <h6>Extra movement</h6>
                            <c:choose>
                                <c:when test="${game.gameboard.options.size()} == 1">
                                    <h6>${game.options.get(0)}</h6>
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
                                                <tr>
                                                    <td>
                                                        <c:out value="${option.text}" />
                                                    </td>
                                                    <td>
                                                        <spring:url value="{gameid}/choice/{choiceid}" var="choiceUrl">
                                                            <spring:param name="choiceid" value="${option.number}" />
                                                            <spring:param name="gameid" value="${game.Id}" />
                                                        </spring:url>
                                                        <a href="${fn:escapeXml(choiceUrl)}"
                                                            class="btn btn-secondary active" role="button"
                                                            aria-pressed="true">Choose and option</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:if>
                </c:if>
            </c:if>
        </div>
    </div>
<<!--</parchisoca:gameLayout> -->

<script>
    $(document).ready(function () {
        $("#fpb").click(function () {
            $("#fpd").fadeToggle();
        });
    });

</script>
