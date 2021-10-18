import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("arquivoDados.csv");
        DataSearch data = new DataSearch(file);
        String actionGlobal = "";

        while(!actionGlobal.equals("exit")){
            System.out.println("----------------------------");
            System.out.println("Qual ação deseja realizar? ");
            System.out.println("1 - Mostrar todos os usuários cadastrados ");
            System.out.println("2 - Pesquisar todos os usuários");
            System.out.println("3 - Pesquisar único o usuário");
            System.out.println("4 - Realizar busca recursiva");
            System.out.println("exit - Sair do menu.");
            System.out.println("----------------------------");

            String action = scanner.nextLine().toLowerCase();
            data.callFunction(action);
            actionGlobal = action;
        }
    }

    /*
        Grupo:
        ADOLFO ABRAHAO - 21365067
        ANTHONY OLIVEIRA - 20931993
        GUSTAVO SANTANA CARVALHO - 21220705
        LUCAS BEPPU TEIXEIRA - 21273686
    */
   
}
