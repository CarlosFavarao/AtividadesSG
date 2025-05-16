package view;

import model.User;
import validation.Validation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    private static Validation validation = new Validation();

    public static User userRegister(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do usuário: ");
        String name = scanner.nextLine();

        System.out.println("Digite o valor seu saldo: ");
        BigDecimal balance = validation.readValidBigDecimal(scanner);

        return new User(name, balance);
    }

    public static void showUserInfo(User user){
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + user.getName());
        System.out.println("Saldo: " + user.getBalance());
    }

    public static User selectUser(Map<String, User> users){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do usuário: ");
        String name = scanner.nextLine();

        User user = users.get(name);
        if (user == null){
            System.out.println("Usuário não encontrado.");
        }
        return user;
    }
}
