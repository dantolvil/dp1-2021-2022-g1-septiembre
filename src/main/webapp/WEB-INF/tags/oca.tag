<%@ attribute name="oca" required="false" rtexprvalue="true" type="org.springframework.samples.parchis_oca.model.Oca"
 description="Oca to be rendered" %>
<canvas id="oca" width="${oca.width}" height="${oca.height}"></canvas>
<img id="background" src="${oca.background}" style="display:none">

<script>
var canvas = document.getElementById("oca");
var ctx = canvas.getContext("2d");
var image = document.getElementById('background');

ctx.drawImage(image, 0, 0, ${oca.width}, ${oca.height});
</script>
