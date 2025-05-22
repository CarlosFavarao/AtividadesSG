var numeroAnterior = "";
var operador = "";
var numeroAtual = "";
function atualizarVisor() {
    document.getElementById("visor").value = numeroAtual;
}
document.querySelectorAll("button").forEach(function (botao) {
    botao.addEventListener("click", function () {
        var valor = botao.textContent;
        if (!valor)
            return;
        if (valor === "C") {
            numeroAnterior = "";
            operador = "";
            numeroAtual = "";
        }
        else if (["+", "-", "*", "/"].includes(valor)) {
            if (numeroAtual) {
                numeroAnterior = numeroAtual;
                operador = valor;
                numeroAtual = "";
            }
        }
        else if (valor === "=") {
            if (numeroAnterior && operador && numeroAtual) {
                var n1 = parseFloat(numeroAnterior);
                var n2 = parseFloat(numeroAtual);
                switch (operador) {
                    case "+":
                        numeroAtual = (n1 + n2).toString();
                        break;
                    case "-":
                        numeroAtual = (n1 - n2).toString();
                        break;
                    case "*":
                        numeroAtual = (n1 * n2).toString();
                        break;
                    case "/":
                        numeroAtual = (n1 / n2).toString();
                        break;
                }
                operador = "";
                numeroAnterior = "";
            }
        }
        else {
            numeroAtual += valor;
        }
        atualizarVisor();
    });
});
