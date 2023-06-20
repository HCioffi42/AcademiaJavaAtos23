//PREENCHIMENTO DO CAMPO DE LOGIN

var nomeInput = document.getElementById('nome');
var sobrenomeInput = document.getElementById('sobrenome');
const loginInput = document.getElementById('login');

nomeInput.addEventListener('input', atualizarLogin);
sobrenomeInput.addEventListener('input', atualizarLogin);

function atualizarLogin() {
  var nome = nomeInput.value.toLowerCase();
  nome = nome.replace(/[^\w\s]/gi, '');
  var sobrenome = sobrenomeInput.value.toLowerCase();
  sobrenome = sobrenome.replace(/[^\w\s]/gi, '');
  nome = nome.trim().replace(/\s+/g, '');
  sobrenome = sobrenome.trim().replace(/\s+/g, '');
  const login = `${nome}.${sobrenome}`;
  loginInput.value = login;
  
}


//PREENCHIMENTO DO ENDEREÇO COM O CEP

const cepInput = document.getElementById('cep');
cepInput.addEventListener('blur', fetchAddressData);

function fetchAddressData() {
  const cep = cepInput.value;
  const url = `https://viacep.com.br/ws/${cep}/json/`;

  const xhr = new XMLHttpRequest();
  xhr.open('GET', url, true);
  xhr.onload = function () {
    if (xhr.status === 200) {
      const data = JSON.parse(xhr.responseText);

      document.getElementById('endereco').value = data.logradouro;
      document.getElementById('bairro').value = data.bairro;
      document.getElementById('cidade').value = data.localidade;
      document.getElementById('estado').value = data.uf;
    }
  };
  xhr.send();

  
}


//EVENTO DE HABILITAR CHECKBOX

function habilitarCheckbox() {
  const textarea = document.getElementById('termos');
  const checkbox = document.getElementById('checkbox-termos');

  if (textarea.scrollTop + textarea.clientHeight === textarea.scrollHeight) {
    checkbox.disabled = false;
  } else {
    checkbox.disabled = true;
  }
}

const textarea = document.getElementById('termos');
textarea.addEventListener('scroll', habilitarCheckbox);

// EVENTO DE PREENCHIMENTO DA TABELA

window.addEventListener('DOMContentLoaded', function() {
  var form = document.getElementById('formulario');
  form.addEventListener('submit', function(event) {
    event.preventDefault(); 

    // PEGA OS DADOS DO FORMULÁRIO
    var nome = document.getElementById('nome').value;
    var sobrenome = document.getElementById('sobrenome').value;
    var email = document.getElementById('email').value;
    var login = document.getElementById('login').value;
    var senha = document.getElementById('senha').value;
    var cep = document.getElementById('cep').value;
    var endereco = document.getElementById('endereco').value;
    var complemento = document.getElementById('complemento').value;
    var bairro = document.getElementById('bairro').value;
    var cidade = document.getElementById('cidade').value;
    var estado = document.getElementById('estado').value;
    var github = document.getElementById('github').value;
    var academia = document.getElementById('academia').value;
    var professor = document.getElementById('professor').value;

    // MOSTRA OS DADOS DA TABELA
    document.getElementById('t-nome').textContent = nome;
    document.getElementById('t-sobrenome').textContent = sobrenome;
    document.getElementById('t-email').textContent = email;
    document.getElementById('t-login').textContent = login;
    document.getElementById('t-senha').textContent = senha;
    document.getElementById('t-cep').textContent = cep;
    document.getElementById('t-endereco').textContent = endereco;
    document.getElementById('t-complemento').textContent = complemento;
    document.getElementById('t-bairro').textContent = bairro;
    document.getElementById('t-cidade').textContent = cidade;
    document.getElementById('t-estado').textContent = estado;
    document.getElementById('t-github').textContent = github;
    document.getElementById('t-academia').textContent = academia;
    document.getElementById('t-professor').textContent = professor;

    // MOSTRA A TABELA
    document.getElementById('tabela-dados').classList.remove('d-none');
  });
});
