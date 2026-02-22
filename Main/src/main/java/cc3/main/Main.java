package cc3.main;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository repo = new Repository.RepositoryBuilder().setDatabasePath().build();
       
        System.out.println("[1] STORE\n[2] RETRIEVE");
        System.out.print("Enter action: ");
        int choice = sc.nextInt();
        
        switch(choice){
            case 1: 
                System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Sex: ");
                    String sex = sc.next();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Year Level: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter NSTP Comp: ");
                    String nstp = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Contact: ");
                    String contact = sc.next();
                    sc.nextLine();

                    Student student = Student.builder()
                            .setStudentID(id)//1
                            .setStudentName(name)//2
                            .setAge(age)//3
                            .setSex(sex)//4
                            .setCourse(course)//5
                            .setYearLevel(year)//6
                            .setNstpComp(nstp)//7
                            .setEmail(email)//8
                            .setContact(contact)//9
                            .setAddress(address).build();//10

                    System.out.println("------ STUDENT INFORMATION -------");
                    System.out.println(student);

                    repo.save(student);
                break;
                
            case 2:
               List<Student> allStudents = repo.retrieveAll();
               
               System.out.printf("%-10s | %-30s | %-10s | %-15s | %-15s | %-15s | %-15s | %-30s | %-15s | %-15s%n", "ID", "NAME", "AGE", "SEX","COURSE","YEAR LEVEL","NSTP COMPONENT","EMAIL","CONTACT","ADDRESS");
               System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    for (Student s : allStudents) {
                        System.out.printf("%-10s | %-30s | %-10s | %-15s | %-15s | %-15s | %-15s | %-30s | %-15s | %-15s%n",
                            s.getStudentID(), 
                            s.getStudentName(), 
                            s.getAge(), 
                            s.getSex(),
                            s.getCourse(),
                            s.getYearLevel(),       
                            s.getNstpComp(),       
                            s.getEmail(),        
                            s.getContact(),       
                            s.getAddress()        
                        );
                    }
                break;
                
            default: System.out.println("Invalid Action!");
        }
        sc.close();
    } 
}