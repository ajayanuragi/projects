const container = document.querySelector(".container");
const colors = ["red","blue","black", "green","yellow","brown","silver"];
let erase = 0;

function randomColor(){
 let color =   Math.floor(Math.random() * colors.length);
 return colors[color];
}


for(let i=1;i<=56;i++){

   const content  = document.createElement("div");
   content.classList.add("content");
   container.appendChild(content);
}


container.addEventListener('mouseover', function(e){
   if(e.target.matches(".content")){
      if(!erase){
      e.target.classList.add(randomColor());
      e.target.classList.remove("none")
      }
      if (erase){
         e.target.classList.add("none")
         e.target.classList.remove(randomColor())
         console.log("erase")
      }
   }
});

function eraseFunction(){
   erase = true;
}
function colorFunction(){
   erase = false;
}

 
  