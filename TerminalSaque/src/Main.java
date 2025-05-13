
public class Main {
    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        SaqueView saqueView = new SaqueView();
        double value;

        value = saqueView.showSaqueView();
        caixaEletronico.sacar(value);
    }
}