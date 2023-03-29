package my;

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
    }
}