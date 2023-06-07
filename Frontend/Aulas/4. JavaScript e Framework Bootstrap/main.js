// Exemplo 3
function substituirParagrafo() {
    document.getElementById('substitui-p-texto').innerText = 'Parágrafo substituído.'
}


// Exemplo 4
var exemplo4 = document.getElementById('exemplo-4')
var botao = document.querySelector('.btn-danger')

function ocultarExemplo() {
    console.log('dentro da function')
    exemplo4.style.display = 'none'
}

botao.onclick = ocultarExemplo