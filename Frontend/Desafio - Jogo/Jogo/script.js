// Variáveis globais
let level = 1;
let score = 0;
let timeLimit = 6000; // 6 segundos
let timer;
const colors = ["red", "blue", "yellow", "green", "orange", "pink", "purple", "black", "gray"];

// Elementos do DOM
const levelElement = document.getElementById("level");
const timerElement = document.getElementById("timer");
const startButton = document.getElementById("start");
const targetWordElement = document.getElementById("target-word");
const buttonContainer = document.getElementById("button-container");
const scoreElement = document.getElementById("score");

// Função para embaralhar um array usando o algoritmo Fisher-Yates
function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

// Função para iniciar o jogo
function startGame() {
    startButton.disabled = true;
    score = 0;
    level = 1;
    timeLimit = 6000; // 6 segundos
    updateLevel();
    updateScore();
    playRound();
    timer = setInterval(updateTimer, 10);
}

// Evento de clique no botão de iniciar
startButton.addEventListener("click", startGame);

// Função para jogar uma rodada
function playRound() {
    // Limpa os botões anteriores
    buttonContainer.innerHTML = "";

    // Escolhe uma cor aleatória para o alvo
    const randomColorIndex = Math.floor(Math.random() * colors.length);
    const randomColor = colors[randomColorIndex];
    targetWord = randomColor;

    // Obtém uma cor aleatória para o texto, excluindo a cor correspondente à palavra
    const filteredColors = colors.filter(color => color !== randomColor);
    const randomTextColor = filteredColors[Math.floor(Math.random() * filteredColors.length)];

    // Altera o nome da cor para caixa alta e colorida
    targetWordElement.textContent = randomColor.toUpperCase();
    targetWordElement.style.color = randomTextColor;

    // Embaralha os botões a partir do nível 3
    const shuffledColors = (level >= 3) ? shuffle(colors) : colors;

    // Cria os botões para as cores
    shuffledColors.forEach(color => {
        const button = document.createElement("button");
        button.style.backgroundColor = color;
        button.className = "color-button";
        button.addEventListener("click", () => checkAnswer(color));
        buttonContainer.appendChild(button);
    });
}

// Função para verificar a resposta do jogador
function checkAnswer(clickedColor) {
    if (clickedColor === targetWordElement.style.color) {
        score++;
        scoreElement.textContent = score;
        playRound();
    } else {
        endGame();
    }
}


// Função para atualizar a pontuação
function updateScore() {
    scoreElement.textContent = `Pontuação: ${score}`;
}

// Função para atualizar o nível
function updateLevel() {
    levelElement.textContent = `Nível: ${level}`;
}

// Função para atualizar o tempo regressivo
function updateTimer() {
    timeLimit -= 10;
    const seconds = Math.floor(timeLimit / 1000);
    timerElement.textContent = `Tempo: ${seconds}`;

    if (timeLimit <= 0) {
        endGame();
    }
}

// Função para encerrar o jogo e permitir jogar novamente
function endGame() {
    clearInterval(timer);
    startButton.disabled = false;
    startButton.textContent = "Jogar Novamente";
    
    setTimeout(() => {
        alert(`Fim de jogo! Sua pontuação final é ${score}.`);
    }, 10);
    
    timeLimit = 6000; // Reinicia o limite de tempo para 3 segundos
}



// Evento de clique no botão "Jogar Novamente"
startButton.addEventListener("click", () => {
    if (startButton.textContent === "Jogar Novamente") {
        startGame();
    }
});
