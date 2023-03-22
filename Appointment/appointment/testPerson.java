/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class testPerson {

    private static ArrayList<Meeting> allMeetings = new ArrayList<>();
    static ArrayList<String> lİstOfUsers = new ArrayList<>();
    private static String currentPerson = null;
    private static Scanner input;

    public static void allMeetings(Meeting mett) {
        allMeetings.add(mett);
    }

    public static void main(String[] args) {

        input = new Scanner(System.in);
        int number;
        addListOfUser();

        Person p3 = new Person(currentPerson);

        while (true) {

            System.out.println("Choose a number");
            System.out.println(" 0) Login ");
            System.out.println(" 1) Create and host a new meeting ");
            System.out.println(" 2) Cancel a meeting ");
            System.out.println(" 3) Attend an existing meeting ");
            System.out.println(" 4) Leave a meeting ");
            System.out.println(" 5) Display my meetings ");
            System.out.println(" 6) Display meetings organized by me ");
            System.out.println(" 7) Logout ");
            System.out.println(" 8) Exit ");
            number = input.nextInt();

            if (number == 0) {
                login();
            }

            if (number == 1) {
                System.out.println(" Enter the name of meeting: ");
                String nameOfMeeting = input.next();
                System.out.println(" Enter the day of meeting: ");
                int day = input.nextInt();
                System.out.println(" Enter the month of meeting: ");
                int month = input.nextInt();
                System.out.println(" Enter the year of meeting: ");
                int year = input.nextInt();
                Date date1 = new Date(day, month, year);
                MDate date = new MDate(date1);
                Meeting meet = new Meeting(nameOfMeeting, date);
                System.out.println(nameOfMeeting + " " + date1);
                p3.organizeMeeting(meet);
                allMeetings.add(meet);

            }

            if (number == 2) {
                cancelMeeting();

            }

            if (number == 3) {
                attendMeeting();

            }

            if (number == 4) {
                leaveMeeting();

            }
            if (number == 5) {

                if (p3.getMyMeetings().size() == 0) {
                    System.out.println("Your agenda is empty");
                } else {
                    p3.displayMyMeetings();
                }

            }
            if (number == 6) {

                if (p3.getiOrganize().size() == 0) {
                    System.out.println(" Meetings organized by you is zero. ");
                } else {
                    p3.displayMyOrganizations();
                }

            }
            if (number == 7) {
                if (currentPerson != null) {
                    currentPerson = null;
                    System.out.println(" You logged out. ");
                } else {
                    System.out.println("There is no person");
                }
            }
            if (number == 8) {
                System.out.println("You quitted");
                return;
            }
            if (number > 8) {
                System.out.println("Your number is out of range");

            }
        }

    }

    public static void addListOfUser() {
        int num = 0;
        while (num != -1) {
            System.out.print("Enter user name:");
            String name = input.next();
            lİstOfUsers.add(name);
            System.out.println("Enter a random integer number. If you write -1, you can see menu");
            num = input.nextInt();
        }
    }

    public static void login() {
        if (currentPerson == null) {
            boolean isPerson = false;
            System.out.print("Enter username to login: ");
            String nameToLogin = input.next();
            for (int i = 0; i < lİstOfUsers.size(); i++) {
                String p = lİstOfUsers.get(i);
                if (p != null && p.equals(nameToLogin)) {
                    currentPerson = p;
                    isPerson = true;
                    break;
                }
            }

            if (!isPerson) {
                System.out.println("There is no person with this name");
            }

        } else {
            System.out.println("First log out please! ");
        }
    }

    public static void cancelMeeting() {
        Person p2 = new Person(currentPerson);
        if (p2.getMyMeetings().size() != 0) {
            p2.displayMyOrganizations();
            System.out.println("Write the name of meeting to cancel");
            String cancelMe = input.next();
            allMeetings.remove(cancelMe);
            if (allMeetings.remove(cancelMe)) {
                System.out.println(" All attendees of" + cancelMe + "have been removed." + cancelMe + "is cancelled. ");
            }
        } else {
            System.out.println("There is no organization to cancel.");
        }
    }

    public static void attendMeeting() {
        Person p3 = new Person(currentPerson);
        if (p3.getMyMeetings().size() != 0) {
            System.out.println("Do you want to attend any meeting, true or false??");
            boolean isWant = input.nextBoolean();
            if (isWant == true) {
                p3.displayMyMeetings();
                System.out.println("Write the name of meeting to attend");
                String nameOfMeeting = input.next();
                Person p4 = new Person(nameOfMeeting);
                Meeting met1 = new Meeting();
                met1.addAttendee(p4);
            } else {
                System.out.println("You can choose other options from menu.");
            }

        } else {
            System.out.println("There is no meeting to attend");
        }

    }

    public static void leaveMeeting() {
        Person p3 = new Person(currentPerson);
        p3.displayMyMeetings();
        System.out.println("Write the name of meeting to leave");
        String leftMeeting = input.next();
        Meeting m4 = new Meeting(leftMeeting);
        p3.removeMeeting(m4);
    }

}
