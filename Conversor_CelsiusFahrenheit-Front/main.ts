function celsiusToFahrenheit(c: number): number {
    return (c * 9) / 5 + 32;
}

function fahrenheitToCelsius(f : number): number {
    return ((f - 32) * 5) / 9;
}

const btn = document.getElementById("converter") as HTMLButtonElement;
const input = document.getElementById("temp") as HTMLInputElement;
const tipo = document.getElementById("tipo") as HTMLSelectElement;
const resultado = document.getElementById("resultado") as HTMLParagraphElement;

btn.addEventListener("click", () => {
    const valor: number = parseFloat(input.value);
    let res: number;

    if(tipo.value == "c2f"){
        res = celsiusToFahrenheit(valor);
        resultado.textContent = `${res.toFixed(2)} °F`;
    }else{
        res = fahrenheitToCelsius(valor);
        resultado.textContent = `${res.toFixed(2)} °C`; 
    }


});