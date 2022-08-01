<%@ attribute name="parchis" required="false" rtexprvalue="true" type="org.springframework.samples.parchis_oca.model.Parchis"
 description="Parchis to be rendered" %>
<canvas id="parchis" width="${parchis.width}" height="${parchis.height}"></canvas>

<img id="pieceBlue" src="resources/images/piece_BLUE.png" style="display:none">
<img id="pieceYellow" src="resources/images/piece_YELLOW.png" style="display:none">
<img id="pieceGreen" src="resources/images/piece_GREEN.png" style="display:none">
<img id="pieceRed" src="resources/images/piece_RED.png" style="display:none">

<script>
var canvas = document.getElementById("parchis");
var ctx = canvas.getContext("2d");

ctx.beginPath();
ctx.rect(0, 0, 800, 800);
ctx.fillStyle = "#FFFFFF70"; <!-- White Color %-->

ctx.fill();

ctx.beginPath();
ctx.lineWidth = "5";
ctx.rect( 0, 0, ${parchis.width}, ${parchis.height});
ctx.stroke();

ctx.beginPath();
ctx.arc(${parchis.width}/20 * 3.5, ${parchis.height}/20 * 3.5 , 100, 0, 2 * Math.PI);
ctx.fillStyle = '#e32908'; <!-- Fill Red Color -->
ctx.fill();
ctx.strokeStyle = '#e32908'; <!-- Stroke Red Color -->
ctx.stroke();

ctx.beginPath();
ctx.arc(${parchis.width}/20 * 16.5, ${parchis.height}/20 * 3.5 , 100, 0, 2 * Math.PI);
ctx.fillStyle = '#0890e3'; <!-- Fill Blue Color -->
ctx.fill();
ctx.strokeStyle = '#0890e3'; <!-- Stroke Blue Color -->
ctx.stroke();

ctx.beginPath();
ctx.arc(${parchis.width}/20 * 16.5, ${parchis.height}/20 * 16.5 , 100, 0, 2 * Math.PI);
ctx.fillStyle = '#dbe117'; <!-- Fill Yellow Color -->
ctx.fill();
ctx.strokeStyle = '#dbe117'; <!-- Stroke Yellow Color -->
ctx.stroke();

ctx.beginPath();
ctx.arc(${parchis.width}/20 * 3.5, ${parchis.height}/20 * 16.5 , 100, 0, 2 * Math.PI);
ctx.fillStyle = '#26ca0c';  <!-- Fill Green Color -->
ctx.fill();
ctx.strokeStyle = '#26ca0c';  <!-- Stroke Green Color -->
ctx.stroke();
</script>



