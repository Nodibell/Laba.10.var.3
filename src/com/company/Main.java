package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void removeMinusIfLowerZero(double number) {
        if (number < 0) {
            System.out.println("Price can't be lower than 0.\nRemoving minus...");
            number *= -1;
            System.out.println("Now, it is " + number + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner;
        Museums museums = new Museums();

        // adding some examples to museums
        Museum museum1 = new Museum("Musa'sRooms", "Musical", "Frankin 12", "12:00-19:00", 20);
        Museum museum2 = new Museum("MovieHome", "Cinematic", "Koralki 81A", "10:00-18:00", 30);
        Museum museum3 = new Museum("Wallpaperia", "Art", "Ivashka 37B", "11:00-21:00", 25);
        museums.addMuseum(museum1);
        museums.addMuseum(museum2);
        museums.addMuseum(museum3);

        Museums museumsL2 = new Museums();

        // adding some examples to museumsL2
        Museum museumL21 = new Museum("CarbonaraMuseum", "Food", "TastyHills 3", "09:00-22:00", 10);
        Museum museumL22 = new Museum("CartoonsFromMoons", "Cinematic", "Colorless 1A", "10:00-21:00", 20);
        Museum museumL23 = new Museum("HugeDiamonds", "Jewelery", "Brightening 92", "10:00-20:00", 40);
        museumsL2.addMuseum(museumL21);
        museumsL2.addMuseum(museumL22);
        museumsL2.addMuseum(museumL23);

        String name;
        String purpose;
        String address;
        String workTime;
        double price;

        String action;

        // making almost endless working process
        while (true) {
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n" +
                    "Actions:\n" +
                    "~~~ Type \"add\" to add new museum ~~~\n" +
                    "~~~ Type \"remove\" to remove thr museum from the list ~~~\n" +
                    "~~~ Type \"show\" to find element in the list ~~~\n" +
                    "~~~ Type \"show.all\" to see all the museums in the list ~~~\n" +
                    "~~~ Type \"sort\" to sort all the museums in the list ~~~\n" +
                    "~~~ Type \"combine.lists\" to combine lists ~~~\n" +
                    "~~~ Type \"stop\" to stop executing the code ~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n");
            System.out.print("Action: ");
            scanner = new Scanner(System.in);
            action = scanner.next();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0");
            switch (action) {
                case ("add"):// add the new museum
                    System.out.print("Adding a new museum...\nName: ");
                    scanner = new Scanner(System.in);
                    name = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    System.out.print("Purpose: ");
                    purpose = scanner.next();
                    scanner = new Scanner(System.in);
                    System.out.print("Address: ");
                    address = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    System.out.print("Working Time: ");
                    workTime = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    System.out.print("Price: ");
                    try {
                        price = scanner.nextInt();
                        removeMinusIfLowerZero(price);
                    } catch (InputMismatchException e) {
                        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n" +
                                "Incorrect price!\nThis museum hasn't been added!!!\n");
                        break;
                    }
                    Museum museum = new Museum(name, purpose, address, workTime, price);
                    museums.addMuseum(museum);

                    // sorting after adding new museum
                    museums.sortByPurpose();
                    System.out.println("This museum is successfully added.");
                    break;

                case ("show"):// show the element is needed
                    int i;
                    System.out.print("Type the index of museum: ");
                    i = scanner.nextInt();
                    try {
                        museums.printerOfMuseum(i);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no such the museum you are searching for.");
                    }
                    break;

                case ("show.all"):// show all the elements of Museums
                    museums.printerOfMuseums();
                    break;

                case ("sort"):
                    museums.sortByPurpose();
                    System.out.println("");
                    break;

                case ("remove"):// remove the museum from Museums
                    int j;
                    try {
                        System.out.print("Type the index of museum you want to remove: ");
                        j = scanner.nextInt();
                        museums.removeMuseum(j);
                        System.out.println("This museum is successfully removed.");
                        // sorting after removing a museum
                        museums.sortByPurpose();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no such the museum in this list.");
                    } catch (InputMismatchException e) {
                        System.out.println("Index can not be a symbol.");
                    }
                    break;

                // combine museums and museumsL2
                case ("combine.lists"):
                    museums.combineMuseumLists(museums);
                    System.out.println("Lists is successfully combined.");
                    // sorting after combining lists
                    museums.sortByPurpose();
                    break;

                case ("stop")://stop executing the code
                    return;

                default:
                    System.out.println("Incorrect action!!!");
            }
        }
    }
}
