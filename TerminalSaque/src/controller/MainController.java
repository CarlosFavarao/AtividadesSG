package controller;

import model.CaixaEletronico;
import model.User;
import validation.Validation;
import view.MainMenuView;
import view.SaqueView;
import view.UserView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainController {
    private Map<String, User> users;
    private CaixaEletronico caixaEletronico;
    private static Validation validation = new Validation();

    public MainController() {
        caixaEletronico = new CaixaEletronico();
        users = new HashMap<>();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MainMenuView.showMenu();
            int op = validation.readValidInt(scanner);

            switch (op){
                case 1:
                    User newUser = UserView.userRegister();
                    users.put(newUser.getName(), newUser);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2: {
                    User user = UserView.selectUser(users);
                    if (user == null) {
                        System.out.println("Usuário não encontrado");
                    } else {
                        UserView.showUserInfo(user);
                    }
                    break;
                }

                case 3: {
                    User user = UserView.selectUser(users);
                    if (user == null) {
                        System.out.println("Usuário não encontrado");
                    } else {
                        SaqueView.doWithDraw(user, caixaEletronico);
                    }
                    break;
                }

                case 4:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
