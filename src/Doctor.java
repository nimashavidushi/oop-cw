import java.util.Comparator;
import java.util.Locale;

public class Doctor extends Person{
    private int licenseNum;
    private String specialisation;


    public Doctor(String name, String surName, String birth, int contactNum, int licenseNum, String specialisation) {
        super(name, surName, birth, contactNum);
        this.licenseNum=licenseNum;
        this.specialisation=specialisation;

    }



    public String toString(){
        return super.toString()+this.licenseNum+"\n"+this.specialisation;
    }

    public int getLicenseNum() {
        return licenseNum;
    }

    public String getSpecialisation() {
        return specialisation;
    }



    public void setLicenseNum(int licenseNum) {
        this.licenseNum = licenseNum;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public static Comparator<Doctor> surNameComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            String surName1 = o1.getSurName().toUpperCase();
            String surName2 = o2.getSurName().toUpperCase();
            return surName1.compareTo(surName2);
        }
    };

}
