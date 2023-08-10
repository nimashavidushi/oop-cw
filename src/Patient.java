public class Patient extends Person{
    private int idNum;
    //patient details
    Patient(String name, String surName, String birth, int contactNum, int idNum) {
        super(name, surName, birth, contactNum);
        this.idNum=idNum;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String toString(){
        return super.toString()+this.idNum;
    }
}
