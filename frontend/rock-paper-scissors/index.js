const playerSelection = [];
const container = document.querySelector('#result-container');
let reset = document.getElementById("reset");
let your_score  = document.getElementById('your-score');
let computer_score  = document.getElementById('computer-score');
let computerSelection = 0;
let yourScore = 0;

let computerScore = 0;

// Player Choice
const buttons = document.querySelectorAll('button');
buttons.forEach((button) => {
  button.addEventListener('click', () => {
    playerSelection.push(button.id);
    console.log("You Chose "+playerSelection[0]);
    playRound(playerSelection,computerSelection);
  });
});
//  For Computer Choice
function getComputerChoice() {
    let computerChoice;
    const choices = ["Rock", "Paper", "Scissors"];
    let c = Math.floor(Math.random() * 3);
    computerChoice = choices[c];  
    return computerChoice;
}
// Round Begins
function playRound(playerSelection, computerSelection) {
    let result;
    computerSelection = getComputerChoice();
    console.log("Computer chose "+computerSelection);
    if (computerSelection == playerSelection) {
        result = "Match is Tie";
    }
    else if (computerSelection === "Rock" && playerSelection === "Scissors") {
        result = "You lost, Scissors loses to Rock";
    } else if (computerSelection == "Scissors" && playerSelection == "Rock") {
        result = "You Won,Rock beats Scissors"
    } else if (computerSelection == "Rock" && playerSelection == "Paper") {
        result = "You Won, Paper beats Rock";
    } else if (computerSelection == "Scissors" && playerSelection == "Paper") {
        result = "You Lost, Paper loses to Scissors";
    } else if (computerSelection == "Paper" && playerSelection == "Rock") {
        result = "You Lost, Rock loses to Paper";
    } else if (computerSelection == "Paper" && playerSelection == "Scissors") {
        result = "You Won, Scissors beats Paper";
    } else {
        result = "Kya choose kar rha bhai";
    }
    playerSelection.pop();
    console.log(result)
    scoreBoard(result);
   
    return result;
}
// For Keeping Score
function scoreBoard(result){
    if (result.includes("You Won")){
        yourScore++;
    }else if(result.includes("You Lost")){
        computerScore++;
    }else{
        "Tie"
    }
    your_score.innerHTML = ""+yourScore;
    computer_score.innerHTML = ""+computerScore;
    matchWinner(yourScore, computerScore);
}
// For Deciding who won
function matchWinner(yourScore, computerScore){
    let matchWinner;
    if(yourScore === 5 && computerScore<yourScore){
        matchWinner = 
        alert("Congratulation You Won")
        reset.style.visibility= "visible"
    }else if(computerScore === 5 && yourScore<computerScore){
        alert("Oups, You lost to Compuer")
        reset.style.visibility= "visible"
        
    }else{
        console.log("keep Playing")
    }
    return matchWinner;
}
function resetfunction(){
    yourScore = 0;
    computerScore = 0;
}

