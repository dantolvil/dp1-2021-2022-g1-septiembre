<%@ attribute name="gameBoard" required="false" rtexprvalue="true" type="org.springframework.samples.parchis_oca.model.GameBoard"
 description="GameBoard to be rendered" %>
<canvas id="gameBoard" width="${gameBoard.width}" height="${gameBoard.height}"></canvas>
<img id="background" src="${gameBoard.background}">

<script>
var canvas = document.getElementById("gameBoard");
var ctx = canvas.getContext("2d");
var image = document.getElementById('background');

ctx.drawImage(image, 0, 0, ${gameBoard.width}, ${gameBoard.height});
</script>
