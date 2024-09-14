package Chapter5.Tutorials;

public class PreschoolStudent {
    int idNum;
    int age;

    public PreschoolStudent(int num, int studentAge) {
        setIdNum(num);
        setAge(studentAge);
    }

    public void setIdNum(int num) {
        if (num <= HIGH_ID) {
            this.idNum = num;
        } else {
            this.idNum = 0;
        }
    }

    public void setAge(int studentAge) {
        if (studentAge <= HIGH_AGE) {
            this.age = studentAge;
        } else {
            this.age = 0;
        }
    }


    public int getIdNum() {
        return this.idNum;
    }

    public int getAge() {
        return this.age;
    }

    public final int HIGH_ID = 9999;
    public final int HIGH_AGE = 6;
}
