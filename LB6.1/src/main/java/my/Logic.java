package my;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Logic {
    public Logic() {
    }

    public Patient[] readFromFile(String file) {
        Patient[] patients = new Patient[100];
        int i = 0;
        String str = "";
        Path path = Paths.get(file);

        try {
            Scanner scanner = new Scanner(path);
            try {
                while (scanner.hasNext()) {
                    str = scanner.nextLine();
                    String[] strs = str.trim().split("\\|");
                    patients[i] = new Patient(Integer.parseInt(strs[0]), strs[1], strs[2], strs[3],
                            strs[4], strs[5], Integer.parseInt(strs[6]), strs[7]);
                    i++;
                }
            } catch (Throwable var10) {
                try {
                    scanner.close();
                } catch (Throwable var9) {
                    var10.addSuppressed(var9);
                }
                throw var10;
            }
            scanner.close();
        } catch (IOException var11) {
        }

        patients = (Patient[]) Arrays.copyOf(patients, i);
        return patients;
    }
    public void writeToFile(Path file, Patient[] patients) {
        try {
            BufferedWriter bfr = Files.newBufferedWriter(file);

            try {
                Patient[] var4 = patients;
                int var5 = patients.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Patient h = var4[var6];
                    bfr.write(h.createString());
                }
            } catch (Throwable var9) {
                if (bfr != null) {
                    try {
                        bfr.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (bfr != null) {
                bfr.close();
            }
        } catch (IOException var10) {
        }

    }
    public void addToFile(Path file, Patient[] patients) {
        try {
            BufferedWriter bfr = Files.newBufferedWriter(file, StandardOpenOption.APPEND);

            try {
                Patient[] var4 = patients;
                int var5 = patients.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Patient h = var4[var6];
                    bfr.write(h.createString());
                }
            } catch (Throwable var9) {
                if (bfr != null) {
                    try {
                        bfr.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (bfr != null) {
                bfr.close();
            }
        } catch (IOException var10) {
        }

    }

    public Patient[] filterDiagnosis(Patient[] patients, String diagnosis) { //указаний діагноз в порядку зростання номерів медичної картки
        Patient[] temp = new Patient[patients.length];
        int p = 0;
        Patient[] var5 = patients;
        int var6 = patients.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Patient patient = var5[var7];
            if (Objects.equals(patient.getDiagnoz(), diagnosis)) {
                temp[p++] = patient;
            }
        }
        temp = Arrays.copyOf(temp, p);


        return (Patient[])Arrays.sort(temp, new Comparator<Patient>(){
            @Override
            public int compare(Patient p1, Patient p2){
                int compare = Integer.compare(p1.getNumberMedCart(), p2.getNumberMedCart());
                return compare;
            }
        });
    }



    public Patient[] filterNumberMedCart(Patient[] patients, int numberLow, int numberUp) { //номер медичної карти у яких знаходиться в заданому інтервалі
        Patient[] temp = new Patient[patients.length];
        int p = 0;
        Patient[] var6 = patients;
        int var7 = patients.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Patient patient = var6[var8];
            if (numberLow <= patient.getNumberMedCart() && numberUp >= patient.getNumberMedCart()) {
                temp[p++] = patient;
            }
        }

        return (Patient[])Arrays.copyOf(temp, p);
    }

    public Patient[] filterPhone(Patient[] patients, int phone) { //фільтер номер телефона яких починається з вказаної цифри
        Patient[] temp = new Patient[patients.length];
        int p = 0;
        Patient[] var5 = patients;
        int var6 = patients.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Patient patient = var5[var7];
            String var10000 = patient.getPhone();
            if (Integer.parseInt("" + var10000.charAt(0)) == phone) {
                temp[p++] = patient;
            }
        }

        return (Patient[])Arrays.copyOf(temp, p);
    }
    public Patient scannerPatient(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть id");
        int id = s.nextInt();
        System.out.println("Введіть прізвище");
        String surname = s.next();
        System.out.println("Введіть ім'я");
        String name = s.next();
        System.out.println("Введіть ім'я по-батькові");
        String fatherName = s.next();
        System.out.println("Введіть адресу");
        String address = s.next();
        System.out.println("Введіть номер телефону");
        String phone = s.next();
        System.out.println("Введіть номер медичної картки");
        int numberMedCart = s.nextInt();
        System.out.println("Введіть діагноз");
        String diagnosis = s.next();
        return new Patient(id, surname, name, fatherName, address, phone, numberMedCart, diagnosis);
    }
}
