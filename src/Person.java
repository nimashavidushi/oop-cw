public class Person {
    private String name;
    private String surName;
    private String birth;
    private int contactNum;

    public Person(String name, String surName, String birth, int contactNum){
        this.name=name;
        this.surName=surName;
        this.birth=birth;
        this.contactNum=contactNum;
    }
    public String toString(){
        return this.name+"\n"+this.surName+"\n"+this.birth+"\n"+this.contactNum+"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }
}
