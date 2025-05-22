let numeroAnterior = "";
let operador = "";
let numeroAtual = "";

function atualizarVisor() {
    (document.getElementById("visor") as HTMLInputElement).value = numeroAtual;
}

document.querySelectorAll("button").forEach((botao) => {
    botao.addEventListener("click", () => {
        const valor = botao.textContent;
        if (!valor) return;

        if (valor === "C") {
            numeroAnterior = "";
            operador = "";
            numeroAtual = "";
        } else if (["+", "-", "*", "/"].includes(valor)) {
            if (numeroAtual) {
                numeroAnterior = numeroAtual;
                operador = valor;
                numeroAtual = "";
            }
        } else if (valor === "=") {
            if (numeroAnterior && operador && numeroAtual) {
                const n1 = parseFloat(numeroAnterior);
                const n2 = parseFloat(numeroAtual);
                switch (operador) {
                    case "+": numeroAtual = (n1 + n2).toString(); break;
                    case "-": numeroAtual = (n1 - n2).toString(); break;
                    case "*": numeroAtual = (n1 * n2).toString(); break;
                    case "/": numeroAtual = (n1 / n2).toString(); break;
                }
                operador = "";
                numeroAnterior = "";
            }
        } else {
            numeroAtual += valor;
        }

        atualizarVisor();
    });
});