package view;

import model.CaixaEletronico;
import model.Saque;
import model.User;
import validation.Validation;

import java.math.BigDecimal;
import java.util.Scanner;

public class SaqueView {
    private static Validation validation = new Validation();

    public static void doWithDraw(User user, CaixaEletronico caixaEletronico){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor em que deseja sacar: ");
        BigDecimal value = validation.readValidBigDecimal(scanner);

        Saque saque = new Saque(value, caixaEletronico);

        if(!user.canWithdraw(value)) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        if(!caixaEletronico.hasBalance(value)){
            System.out.println("Caixa eletrônico não possui notas o suficiente para a operação...");
            return;
        }

        saque.doWithdraw(user);
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Saldo atual: R$ " + user.getBalance());
    }
}
