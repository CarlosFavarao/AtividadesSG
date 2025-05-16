package model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CaixaEletronico {

    Map<BigDecimal, Integer> cashQuantity = new LinkedHashMap<>();
    {
        cashQuantity.put(BigDecimal.valueOf(200), 5);
        cashQuantity.put(BigDecimal.valueOf(100), 5);
        cashQuantity.put(BigDecimal.valueOf(50), 5);
        cashQuantity.put(BigDecimal.valueOf(20), 5);
        cashQuantity.put(BigDecimal.valueOf(10), 5);
        cashQuantity.put(BigDecimal.valueOf(5), 5);
        cashQuantity.put(BigDecimal.valueOf(2), 5);
        cashQuantity.put(BigDecimal.valueOf(1), 5);
        cashQuantity.put(BigDecimal.valueOf(0.50),5);
        cashQuantity.put(BigDecimal.valueOf(0.25),5);
        cashQuantity.put(BigDecimal.valueOf(0.10),5);
        cashQuantity.put(BigDecimal.valueOf(0.05),5);
        cashQuantity.put(BigDecimal.valueOf(0.01),5);
    }

    public boolean hasBalance(BigDecimal value){
        BigDecimal totalCashBalance = BigDecimal.ZERO;

        for (Map.Entry<BigDecimal, Integer> entry : cashQuantity.entrySet()){
            BigDecimal noteValue = entry.getKey();
            int quantity = entry.getValue();
            totalCashBalance = totalCashBalance.add(noteValue.multiply(BigDecimal.valueOf(quantity)));
        }
        return totalCashBalance.compareTo(value) >= 0;
    }

    public void refresh(BigDecimal value) {
        for (Map.Entry<BigDecimal, Integer> entry : cashQuantity.entrySet()) {
            BigDecimal noteValue = entry.getKey();
            int availableNotes = entry.getValue();
            int notesToWithdraw = value.divideToIntegralValue(noteValue).intValue();

            if (notesToWithdraw > 0 && availableNotes > 0) {
                int qtdForRetire = Math.min(notesToWithdraw, availableNotes);
                cashQuantity.put(noteValue, availableNotes - qtdForRetire);
                value = value.subtract(noteValue.multiply(BigDecimal.valueOf(qtdForRetire)));
                if (noteValue.compareTo(BigDecimal.ONE) > 0){
                    if (qtdForRetire > 1){
                        System.out.println("Retiradas " + qtdForRetire + " cédulas de R$ " + noteValue);
                    }else {
                        System.out.println("Retirada " + qtdForRetire + " cédula de R$ " + noteValue);
                    }
                }else{
                    if (qtdForRetire > 1) {
                        System.out.println("Retiradas " + qtdForRetire + " moedas de R$ " + noteValue);
                    }else {
                        System.out.println("Retirada " + qtdForRetire + " moeda de R$ " + noteValue);
                    }
                }
            }
        }

        if (value.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Não foi possível sacar o valor exato devido à falta de cédulas/moedas adequadas.");
        } else {
            System.out.println("Caixa atualizado com sucesso!");
        }
    }


    public Map<BigDecimal, Integer> getCashQuantity() {
        return cashQuantity;
    }

}
