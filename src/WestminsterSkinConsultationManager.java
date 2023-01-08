import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static ArrayList<String> MonMor = new ArrayList<>();
    static ArrayList<String> MonEve = new ArrayList<>();
    static ArrayList<String> TueMor = new ArrayList<>();
    static ArrayList<String> TueEve = new ArrayList<>();
    static ArrayList<String> WedMor = new ArrayList<>();
    static ArrayList<String> WedEve = new ArrayList<>();
    static ArrayList<String> ThuMor = new ArrayList<>();
    static ArrayList<String> ThuEve = new ArrayList<>();
    static ArrayList<String> FriMor = new ArrayList<>();
    static ArrayList<String> FriEve = new ArrayList<>();
    static ArrayList<String> SatMor = new ArrayList<>();
    static ArrayList<String> SatEve = new ArrayList<>();
    static ArrayList<String> SunMor = new ArrayList<>();
    static ArrayList<String> SunEve = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<String> surNames = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);
    static WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();
    static int doctorNum=0;


    public static void main(String[] args){

        String option;
        do {
            try {
                System.out.println("Console Menu");
                System.out.println("A.  add a doctor");
                System.out.println("D.  delete a doctor");
                System.out.println("P.  print the doctors");
                System.out.println("S.  save to a file");
                System.out.println("E.  exit");
                System.out.println("Choose an option");
                option = input.nextLine().toUpperCase();
                switch (option){
                    case "A":
                        obj.addDoctor();
                        doctorNum++;
                        break;
                    case "D":
                        obj.deleteDoctor();
                        break;
                    case "P":
                        obj.printDoctors();
                        break;
                    case "S":
                        obj.saveFile();
                        break;
                    case "E":
                        System.exit(0);
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid input");
                input.nextLine();
            }
            ConsultGui gui = new ConsultGui();
        }while (true);

    }

    @Override
    public void addDoctor() {
        while (true) {
            if (doctorNum < 2) {
                System.out.println("Enter the first name of the doctor:");
                String name = input.nextLine();
                System.out.println("enter sur name of the doctor:");
                String surName = input.nextLine();
                System.out.println("Enter the dob :");
                String birth = input.nextLine();
                System.out.println("enter contact number:");
                int contactNum = input.nextInt();
                System.out.println("enter license number:");
                int licenseNum = input.nextInt();
                input.nextLine();
                System.out.println("enter specialisation:");
                String specialisation = input.nextLine();
                String workDays;
                while (true) {
                    System.out.println("enter day and time");
                    workDays = input.nextLine();
                    System.out.println("enter time");
                    String workHours = input.nextLine();
                    if (workDays.equals("q")) {
                        break;
                    }
                    if (workDays.equals("monday") && workHours.equals("morning")) {
                        MonMor.add(name);
                    }
                    if (workDays.equals("monday") && workHours.equals("evening")) {
                        MonEve.add(name);
                    }
                    if (workDays.equals("tuesday") && workHours.equals("morning")) {
                        TueMor.add(name);
                    }
                    if (workDays.equals("tuesday") && workHours.equals("evening")) {
                        TueEve.add(name);
                    }
                    if (workDays.equals("wednesday") && workHours.equals("morning")) {
                        WedMor.add(name);
                    }
                    if (workDays.equals("wednesday") && workHours.equals("evening")) {
                        WedEve.add(name);
                    }
                    if (workDays.equals("thursday") && workHours.equals("morning")) {
                        ThuMor.add(name);
                    }
                    if (workDays.equals("thursday") && workHours.equals("evening")) {
                        ThuEve.add(name);
                    }
                    if (workDays.equals("friday") && workHours.equals("morning")) {
                        FriMor.add(name);
                    }
                    if (workDays.equals("friday") && workHours.equals("evening")) {
                        FriEve.add(name);
                    }
                    if (workDays.equals("saturday") && workHours.equals("morning")) {
                        SatMor.add(name);
                    }
                    if (workDays.equals("saturday") && workHours.equals("evening")) {
                        SatEve.add(name);
                    }
                    if (workDays.equals("sunday") && workHours.equals("morning")) {
                        SunMor.add(name);
                    }
                    if (workDays.equals("sunday") && workHours.equals("evening")) {
                        SunEve.add(name);
                    }
                }
                System.out.println(MonMor);
                System.out.println(MonMor.size());

                Doctor doctorsObj = new Doctor(name, surName, birth, contactNum, licenseNum, specialisation);
                doctors.add(doctorsObj);
                for (Doctor obj : doctors) {
                    System.out.println(obj.getName() + "\n" + obj.getSurName() + "\n" + obj.getBirth() + "\n" + obj.getContactNum() + "\n" + obj.getLicenseNum() + "\n" + obj.getSpecialisation());
                    surNames.add(obj.getSurName());
                }
                break;
            }
            else {
                System.out.println("can't add more than 10 doctors");
                break;
            }
        }

    }

    @Override
    public void deleteDoctor() {
        while (true){
            if (doctorNum>0){
                doctorNum--;
                System.out.println("enter license number to delete a doctor:");
                int deleteDoctor = input.nextInt();
                for (Doctor obj : doctors){
                    if (deleteDoctor==obj.getLicenseNum()){
                        doctors.remove(obj);
                        System.out.println("deleted");
                        break;
                    }
                }
                for (Doctor obj : doctors){
                    System.out.println(obj.getName()+"\n"+obj.getSurName()+"\n"+obj.getBirth()+"\n"+obj.getContactNum()+"\n"+obj.getLicenseNum()+"\n"+obj.getSpecialisation());
                }
                break;
            }
            else {
                System.out.println("You haven't add any doctors to delete.");
                break;
            }
        }

    }

    @Override
    public void printDoctors() {
        Collections.sort(doctors, Doctor.surNameComparator);
        for (Doctor obj : doctors){
            System.out.println("First name: "+obj.getName()+"\n"+"Last name:"+obj.getSurName()+"\n"+" Date of Birth: "+obj.getBirth()+"\n"+" Contact Number: "+obj.getContactNum()+"\n"+" License number: "+obj.getLicenseNum()+"\n"+" Specialisation: "+obj.getSpecialisation());
        }
    }

    @Override
    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter("myDoctor.txt");
            for (Doctor obj : doctors){
                fileWriter.write("First name:" +obj.getName()+"\n"+"Last name:"+obj.getSurName()+"\n"+" Date of Birth:"+obj.getBirth()+"\n"+" Contact Number:"+obj.getContactNum()+"\n"+" License number:"+obj.getLicenseNum()+"\n"+" Specialisation:"+obj.getSpecialisation());
            }
            fileWriter.flush();
        }catch (IOException e){
            System.err.println("file not found");
        }
    }

}
