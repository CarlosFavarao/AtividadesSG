function celsiusToFahrenheit(c) {
    return (c * 9) / 5 + 32;
}
function fahrenheitToCelsius(f) {
    return ((f - 32) * 5) / 9;
}
var btn = document.getElementById("converter");
var input = document.getElementById("temp");
var tipo = document.getElementById("tipo");
var resultado = document.getElementById("resultado");
btn.addEventListener("click", function () {
    var valor = parseFloat(input.value);
    var res;
    if (tipo.value == "c2f") {
        res = celsiusToFahrenheit(valor);
        resultado.textContent = "".concat(res.toFixed(2), " \u00B0F");
    }
    else {
        res = fahrenheitToCelsius(valor);
        resultado.textContent = "".concat(res.toFixed(2), " \u00B0C");
    }
});
