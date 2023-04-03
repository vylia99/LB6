package my;

import java.util.Arrays;
import java.util.Scanner;

public class InputOutput {
       Patient[] patients;
     Logic logic;

    public InputOutput() {
        logic = new Logic();

}
    public void printPatient(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            System.out.println(patients[i]);
        }
    }

    public void printFilterDiagnosis(Patient[] patients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діагноз");
       String st = scanner.nextLine();
        System.out.println(st);
     printPatient(logic.filterDiagnosis(patients, st));
    }

    public void printFilterNumberMedCart(Patient[] patients) {
        Scanner c = new Scanner(System.in);
        System.out.println("Введіть початок інтервалу");
        int numLow = c.nextInt();
        System.out.println("Введіть кінець інтервалу");
        int numUp = c.nextInt();
        printPatient(logic.filterNumberMedCart(patients,numLow, numUp));
    }
    public void printFilterPhone(Patient[] patients){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть початкову цифру номеру телефону");
        int f = s.nextInt();
        printPatient(logic.filterPhone(patients, f));
    }

    public void printDiagnosis(Patient[] patients) {
        System.out.println(Arrays.toString(logic.filterDiagnosis(patients)));
        System.out.println(Arrays.toString(logic.number(patients)));
    }
}