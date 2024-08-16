function newColor() {
        let one = Math.floor(Math.random() * 256);
        let two = Math.floor(Math.random() * 256);
        let three = Math.floor(Math.random() * 256);
        let four = Math.floor(Math.random() * 11)/10;
        randomColor = document.getElementById("one").style.backgroundColor = "rgba" + "(" + one + "," + two + "," + three + "," + four + ")";
        document.getElementById("color1").innerText = "" + randomColor ;
        hexColor = RGBAToHexA(one,two,three);
        document.getElementById("hex1").innerHTML = "HEX " + hexColor +"<br> Opacity :" + four;
        secondColor();
}
function secondColor(){
    let one = Math.floor(Math.random() * 256);
    let two = Math.floor(Math.random() * 256);
    let three = Math.floor(Math.random() * 256);
    let four = Math.floor(Math.random() * 11)/10;Math.random();
    randomColor = document.getElementById("two").style.backgroundColor = "rgba" + "(" + one + "," + two + "," + three + "," + four + ")";
    document.getElementById("color2").innerText = "" + randomColor ;
    hexColor = RGBAToHexA(one,two,three);
    document.getElementById("hex2").innerHTML = "HEX " + hexColor +"<br> Opacity :" + four;
    thirdColor();
}
function thirdColor(){
    let one = Math.floor(Math.random() * 256);
    let two = Math.floor(Math.random() * 256);
    let three = Math.floor(Math.random() * 256);
    let four = Math.floor(Math.random() * 11)/10;
    randomColor = document.getElementById("three").style.backgroundColor = "rgba" + "(" + one + "," + two + "," + three + "," + four + ")";
    document.getElementById("color3").innerText = "" + randomColor ;
    hexColor = RGBAToHexA(one,two,three);
    document.getElementById("hex3").innerHTML = "HEX " + hexColor +"<br> Opacity :" + four;
    fourthColor();
}
function fourthColor(){
    let one = Math.floor(Math.random() * 256);
    let two = Math.floor(Math.random() * 256);
    let three = Math.floor(Math.random() * 256);
    let four = Math.floor(Math.random() * 11)/10;
    randomColor = document.getElementById("four").style.backgroundColor = "rgba" + "(" + one + "," + two + "," + three + "," + four + ")";
    document.getElementById("color4").innerText = "" + randomColor ;
    hexColor = RGBAToHexA(one,two,three);
    document.getElementById("hex4").innerHTML = "HEX " + hexColor +"<br> Opacity :" + four;
    fivththColor();
}
function fivththColor(){
    let one = Math.floor(Math.random() * 256);
    let two = Math.floor(Math.random() * 256);
    let three = Math.floor(Math.random() * 256);
    let four = Math.floor(Math.random() * 11)/10;
    randomColor = document.getElementById("five").style.backgroundColor = "rgba" + "(" + one + "," + two + "," + three + "," + four + ")";
    hexColor = RGBAToHexA(one,two,three);
    document.getElementById("color5").innerText = "" + randomColor ;
    document.getElementById("hex5").innerHTML = "HEX " + hexColor +"<br> Opacity :" + four;
}

function RGBAToHexA(r,g,b) {
  r = r.toString(16);
  g = g.toString(16);
  b = b.toString(16);
  if (r.length == 1)
    r = "0" + r;
  if (g.length == 1)
    g = "0" + g;
  if (b.length == 1)
    b = "0" + b;
  return "#" + r + g + b;
}
