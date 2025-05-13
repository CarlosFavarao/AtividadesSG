public class CaixaEletronico {
    private double value;


    public void sacar(double value){
        int[] notes = {200, 100, 50, 20, 10, 5, 2};
        double[] coins = {1, 0.50, 0.25, 0.10, 0.05, 0.01};

        System.out.println("Sacando o valor: " + value);

        for (int note : notes){
            int quant = (int) (value / note);
            if (quant > 0){
                if (quant > 1) {
                    System.out.println(quant + " notas de " + note);
                }else{
                    System.out.println(quant + " nota de " + note); //bonito e pesado, bem desnecessário
                }
                value = value % note;
            }
        }

        for (double coin : coins){
            int quant = (int) (value / coin);
            if (quant > 0){
                System.out.println(quant + " moedas de " + coin);
                value = value % coin;
            }
        }
    }

    public double getValue() {
        return value;
    }
}
