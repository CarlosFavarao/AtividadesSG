import java.math.BigDecimal;

public class Saque {
    private BigDecimal value;
    private CaixaEletronico caixaEletronico;

    public Saque(BigDecimal value, CaixaEletronico caixaEletronico) {
        this.value = value;
        this.caixaEletronico = caixaEletronico;
    }

    public void doWithdraw(User user) {

        if (!user.canWithdraw(value)) {
            System.out.println("O usuário não possui saldo suficiente para essa operação.");
            return;
        }


        if (!caixaEletronico.hasBalance(value)) {
            System.out.println("O Caixa eletrônico não possui dinheiro suficiente para essa operação.");
            return;
        }

        user.withdraw(value);
        System.out.println("Saque de R$ " + value + " realizado com sucesso para o usuário " + user.getName());


        caixaEletronico.refresh(value);
    }
}
