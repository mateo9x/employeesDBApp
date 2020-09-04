package com.mateo9x;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x;
        List<User> userList = new ArrayList<>();
        do {
            System.out.printf("%n%nWybierz operację:%n" +
                    "1- Dodawanie pracownika%n" +
                    "2- Podgląd danych pracownika%n" +
                    "3- Usuwanie pracownika%n" +
                    "4- Zamknięcie programu bez zapisuu%n" +
                    "5- Zamknięcie programu i zapis danych do pliku%n");

            x = scan.nextInt();


            switch(x){
                case 1:{

                    User newUser = new User();

                    System.out.printf("Podaj imię: ");
                    newUser.setName(scan.next());
                    while (!newUser.name.matches("[a-zA-Z]+$")) {
                        System.out.printf("Błędne imię!%n");
                        System.out.printf("Podaj imię: ");
                        newUser.setName(scan.next());
                    }


                        System.out.printf("Podaj nazwisko: ");
                        newUser.setSurname(scan.next());
                    while (!newUser.surname.matches("[a-zA-Z]+$")) {
                        System.out.printf("Błędne nazwisko!%n");
                        System.out.printf("Podaj nazwisko: ");
                        newUser.setSurname(scan.next());
                    }

                        while(true){
                            System.out.printf("Podaj wiek: ");
                            newUser.setAge(scan.nextInt());
                        if(newUser.age>=16 && newUser.age<=75) {
                            break;
                        }
                        else if (newUser.age < 16) {
                                System.out.printf("Pracownik musi mieć skończone 16 lat%n");
                            } else System.out.printf("Nie poprawny wiek pracownika!%n");
                        }

                        while(true) {
                            System.out.printf("Podaj zarobki brutto(zł): ");
                            newUser.setSalary(scan.nextDouble());
                            if(newUser.salary>2000 && newUser.salary<15000){
                                break;
                            }
                            else if(newUser.salary>15000) {
                                System.out.printf("Kłamiesz! Nawet nasz CEO tyle nie zarabia!%n");
                            }   else System.out.printf("Zarobek nie może być niższy niż najniższa krajowa!%n");
                        }
                        userList.add(newUser);

                }break;

                case 2: {
                    System.out.printf("Podgląd aktualnych pracowników:%n%n");

                    for (User newUser : userList){
                        System.out.printf("ID: " + newUser.getUniqueID() + ' ' + newUser.getName() + " Nazwisko: " + newUser.getSurname() + " Wiek: " +
                                newUser.getAge() + " lat Pensja: " + newUser.getSalary() + " zł%n");
                    }


                }break;

                case 3: {

                    User users = new User();
                    System.out.printf("Podaj Unikalne ID pracownika którego chesz usunąć: ");
                    String deleteByUniqueId = scan.next();
                        userList.removeIf(newUser -> newUser.getUniqueID().equals(deleteByUniqueId));

                }break;

                case 4:{
                    System.out.printf("Pomyślnie zakończono działanie programu.");
                } break;

                case 5:{

                    try {
                    FileWriter writer = new FileWriter("output.txt");
                        for (User newUser : userList) {
                            writer.write("ID: " + newUser.getUniqueID() + " Imię: " + newUser.getName() + " Nazwisko: " + newUser.getSurname() + " Wiek: "
                                    + newUser.getAge() + " lat Zarobki(brutto): " + newUser.getSalary() + " zł" + System.lineSeparator());
                        }
                        System.out.printf("Zapisano plik!");
                        writer.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }

                }break;

                default: System.out.printf("Błędny nr zadania!");
            }
        }while(x!=5 && x!=4);
    }
}