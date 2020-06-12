var titulo = document.querySelector(".titulo1");			
titulo.textContent = "Fernando Nutricionista";

var paciente = document.querySelectorAll(".paciente");

for (var i = 0; i < paciente.length; i++) {

    var pacientes = paciente[i];

    var tdPeso = pacientes.querySelector(".info-peso");
    var peso = tdPeso.textContent;

    var tdAltura = pacientes.querySelector(".info-altura");
    var altura = tdAltura.textContent;

    var imc =  pacientes.querySelector(".info-imc");

    if(!validaPesoFunction(peso)){                
        imc.textContent = "Peso inválido!";
        pacientes.classList.add("paciente-invalido");
    }

    if(!validaAlturaFunction(altura)){                
        imc.textContent = "Altura inválida!";
        pacientes.classList.add("paciente-invalido");
    }

    if(validaPesoFunction(peso) && validaAlturaFunction(altura)){
        var novoImc = calculaImc(peso, altura);
        imc.textContent = novoImc;
    }
    
}

function calculaImc(peso,altura) {

    var imcNovo = 0;
    imcNovo = peso / (altura * altura);    
    return imcNovo.toFixed(2);
}

function validaPesoFunction(peso) {

    if (peso >= 0 && peso <= 1000) {
        return true;
    } else {
        return false;
    }
}

function validaAlturaFunction(altura) {
    
    if (altura >= 0 && altura <= 3.00) {
        return true;
    } else {
        return false;
    }
}