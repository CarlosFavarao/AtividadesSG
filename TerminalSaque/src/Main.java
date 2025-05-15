import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        User user = new User("Carlos", BigDecimal.valueOf(300));

        System.out.println("Usuário: " + user.getName());
        System.out.println("Saldo inicial: R$ " + user.getBalance());

        BigDecimal valorSaque = BigDecimal.valueOf(210);

        Saque saque = new Saque(valorSaque, caixaEletronico);

        System.out.println("\nTentando sacar R$ " + valorSaque + "...");
        saque.doWithdraw(user);

        System.out.println("\nSaldo final: R$ " + user.getBalance());

        System.out.println("\nNotas restantes no caixa:");
        caixaEletronico.getCashQuantity().forEach((nota, qtd) ->
                System.out.println("R$ " + nota + " -> " + qtd + " unidade(s)")
        );
    }
}
