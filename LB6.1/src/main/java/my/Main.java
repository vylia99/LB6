package my;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    Patient[] patients;
    String file;

    public Main() {
    }

    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }

    private void run() {
        Logic logic = new Logic();
        InputOutput printAll = new InputOutput();

        while (true){
            while (true){
                System.out.println("1: Додати запис до файлу");
                System.out.println("2: Вивести зміст файлу на екран");
                System.out.println("3: Вивести список пацієнтів, які мають указаний діагноз в порядку зростання номерів медичної картки");
                System.out.println("4: Вивести список пацієнтів, номер медичної карти у яких знаходиться в заданому інтервалі");
                System.out.println("5: Вивести кількість та список пацієнтів, номер телефона яких починається з вказаної цифри");
                System.out.println("6: Вивести список діагнозів пацієнтів (без повторів) із вказанням кількості пацієнтів, " +
                                         "що мають цей діагноз у порядку спадання цієї кількості.");
                System.out.println("0: Вийти з програми");
                Scanner sc = new Scanner(System.in);
                int k = sc.nextInt();
                boolean r = false;
                int q;
                String file ;
                switch (k){
                    case 0:
                        System.out.println("Роботу завершенно");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Введіть кількість паціентів");
                        q = sc.nextInt();
                        Patient[] temp = new Patient[q];

                        for (int i = 0; i < temp.length; i++){
                            temp[i] = logic.scannerPatient();}
                        System.out.println("Введіть назву файлу");
                        this.file = sc.next();
                        Path path = Paths.get(this.file);
                        if (!Files.exists(path, new LinkOption[0])){
                            logic.writeToFile(path, temp);
                        }   else {
                            logic.addToFile(path, temp);}
                        break;
                    case 2:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        System.out.println("Зміст файлу");
                        this.patients = logic.readFromFile(file);
                        printAll.printPatient(this.patients);
                        break;
                    case 3:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        this.patients = logic.readFromFile(file);
                        printAll.printPatient(patients);
                        printAll.printFilterDiagnosis(this.patients);
                        break;
                    case 4:
                        System.out.println("Введіть початок інтервалу");
                        int numberLow = sc.nextInt();
                        System.out.println("Введіть кінець інтервалу");
                        int numberUp = sc.nextInt();
                        this.patients = logic.readFromFile("patients.txt");
                        logic.filterNumberMedCart(this.patients, numberLow, numberUp);
                        printAll.printFilterNumberMedCart(this.patients);
                    case  5:

            }   }
        }
    }


}

