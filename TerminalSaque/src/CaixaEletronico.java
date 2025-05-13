public class CaixaEletronico {
    private double value;


    public void sacar(double value){
        int[] notes = {200, 100, 50, 20, 10, 5, 2};
        int[] qtdNotes = {1, 0, 2, 0, 0, 2, 0};
        double[] coins = {1, 0.50, 0.25, 0.10, 0.05, 0.01};
        int[]qtdCoins = {3, 0, 2, 0, 0, 0};

        System.out.println("Sacando o valor: " + value);

        int i = 0;
        for (int note : notes){
            if (qtdNotes[i] > 0) {
                int quant = (int) (value / note);
                if (quant > 0) {
                    if (quant > 1) {
                        System.out.println(quant + " notas de " + note);
                    } else {
                        System.out.println(quant + " nota de " + note);
                    }
                    value = value % note;
                }
            }
            i++;
        }

        i = 0;
        for (double coin : coins){
            if (qtdCoins[i] > 0) {
                int quant = (int) (value / coin);
                if (quant > 0) {
                    System.out.println(quant + " moedas de " + coin);
                    value = value % coin;
                }
            }
            i++;
        }
    }

    public double getValue() {
        return value;
    }
}
