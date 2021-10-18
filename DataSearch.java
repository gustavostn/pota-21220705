import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSearch {

    public ArrayList<String> usersData = new ArrayList<String>();
    public int index = 0;
    private int comparisonNumber = 0;
    String[] infsTypes = {"Nome", "Sexo", "Endereço", "Cidade", "Email", "Número de telefone", "Idade"};

    public String name;
    public String sex;
    public String address;
    public String city;
    public String email;
    public String number;
    public String age;
    public int indexNumber;

    public DataSearch(File userData) {
        if(userData == null){
            System.out.println("Por favor informe o arquivo com os dados.");
            System.exit(0);
        } else {
            try {
                Scanner scanner = new Scanner(userData);

                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    usersData.add(data);
                    index++;
                }
                scanner.close();

            } catch (IOException error) {
                System.err.println(error.getMessage());
                System.exit(0);
            }
        }
    }

    public void callFunction(String action){
        Scanner scanner = new Scanner(System.in);
        String name = "";

        if(action.equals("2") || action.equals("3") || action.equals("4")){
            System.out.println("Informe o nome que deseja buscar: ");
            name = scanner.nextLine().toLowerCase();
            name = name.substring(0,1).toUpperCase().concat(name.substring(1));
        }

        switch (action) {
            case "1":
                showAllData();
                break;
            case "2":
                sequentialSearchByNameFirst(name);
                break;
            case "3":
                sequentialSearchByNameAll(name);
                break;
            case "4":
                System.out.println(sequentialSearchRecursive(name, usersData.size()));
                break;
            case "exit":
                System.out.println("Programa finalizado com sucesso.");
                break;
            default:
                System.err.println("Valor inválido, por favor tente novamente.");
                break;
        }
    }

    public void setUserData(String userData, int indexUser){
        String[] userInfs = userData.split(",");

        this.name = userInfs[0];
        this.sex = userInfs[1];
        this.address = userInfs[2];
        this.city = userInfs[3];
        this.email = userInfs[4];
        this.number = userInfs[5];
        this.age = userInfs[6];
        this.indexNumber = indexUser;
    }

    public void getUserInfs(){
        System.out.println("----------------------------");
        System.out.println("Nome: " + this.name);
        System.out.println("Sexo: " + this.sex);
        System.out.println("Endereço: " + this.address);
        System.out.println("Cidade: " + this.city);
        System.out.println("Email: " + this.email);
        System.out.println("Número de telefone: " + this.number);
        System.out.println("Idade: " + this.age);
        System.out.println("Index usuário: " + this.indexNumber);
        getTotalOfComparisonNumber();
    }

    public void getTotalOfComparisonNumber(){
        System.out.println("Valor total de comparações: " + this.comparisonNumber);
    }

    public void showAllData() {
        comparisonNumber = 0;
        for (int i = 0; i < usersData.size(); i++) {
            comparisonNumber++;
            for (int j = 0; j < infsTypes.length; j++) {
                System.out.println(infsTypes[j] + ":" + usersData.get(i).split(",")[j]);
            }
            System.out.println("Index usuário: " + i);
            getTotalOfComparisonNumber();
            System.out.println("------------------------------");
        }
    }

    public void sequentialSearchByNameFirst(String name) {
        comparisonNumber = 0;
        boolean userFound = false;
        for (int i = 0; i < usersData.size(); i++) {
            comparisonNumber++;
            if (usersData.get(i).contains(name)) {
                setUserData(usersData.get(i), i);
                getUserInfs();
                userFound = true;
            }
        }
        if(!userFound) {
            System.out.println("----------------------------");
            System.out.println("Não foi encontrado um usuário com este nome.");
            System.out.println("Index usuário: -1");
            getTotalOfComparisonNumber();
        }
    }
    
    public void sequentialSearchByNameAll(String name) {
        boolean userFound = false;
        comparisonNumber = 0;
        for (int i = 0; i < usersData.size(); i++) {
            comparisonNumber++;
            if (usersData.get(i).contains(name)) {
                setUserData(usersData.get(i), i);
                getUserInfs();
                userFound = true;
                break; 
            }
        }
        if(!userFound) {
            System.out.println("----------------------------");
            System.out.println("Não foi encontrado um usuário com este nome.");
            System.out.println("Index usuário: -1" );
            getTotalOfComparisonNumber();
        }
    }

    private int sequentialSearchRecursive(String data, int length) {
        if (length == 0 || length == -1){ 
            System.out.println("Usuário não localizado. -1");
            System.exit(0);
        }

        if (usersData.get(length).contains(data)) { // caso base (achou)
            System.out.println(usersData.get(length));
        }

        return sequentialSearchRecursive(data, length - 1);
    }


}
