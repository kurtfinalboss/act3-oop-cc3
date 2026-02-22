package cc3.main;


package student.cc3_task3;

public class Student {
    private final int studentID;
    private final int age, yearLevel;
    private final String contact ;
    private final String studentName, address,sex,email;
    private final String course, nstpComp;
    
    public Student(StudentBuilder builder){
        this.studentID = builder.studentID;
        this.studentName = builder.studentName;
        this.age = builder.age;
        this.sex = builder.sex;
        this.course = builder.course;
        this.yearLevel = builder.yearLevel;
        this.nstpComp = builder.nstpComp;
        this.email = builder.email;
        this.contact = builder.contact;
        this.address = builder.address;
    }
    
    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
    
     public String toString() {
        return "Student ID: " + studentID +
           "\nName: " + studentName +
           "\nAge: " + age +
           "\nSex: " + sex +
           "\nCourse: " + course +
           "\nYear Level: " + yearLevel +
           "\nNSTP Component: " + nstpComp +
           "\nEmail: " + email +
           "\nContact: " + contact +
           "\nAddress: " + address;
}
           public int getStudentID() {
               return studentID;
           }

           public String getStudentName() {
               return studentName;
           }

           public int getAge() {
               return age;
           }

           public String getSex() {
               return sex;
           }

           public String getCourse() {
               return course;
           }

           public int getYearLevel() {
               return yearLevel;
           }

           public String getNstpComp() {
               return nstpComp;
           }

           public String getEmail() {
               return email;
           }

           public String getContact() {
               return contact;
           }

           public String getAddress() {
               return address;
           }

    public static class StudentBuilder{
        private  int studentID;
        private  int age, yearLevel;
        private  String contact;
        private  String studentName, address,sex, email;
        private  String course, nstpComp;
       
       public StudentBuilder setStudentID(int studentID){//1
           this.studentID = studentID;
           return this;
       }
       public StudentBuilder setStudentName(String studentName){//2
           this.studentName = studentName;
           return this;
       }
       public StudentBuilder setAge(int age){//3
           this.age = age;
           return this;
       }
       public StudentBuilder setSex(String sex){//4
           this.sex = sex;
           return this;
       }
       public StudentBuilder setCourse(String course){//5
           this.course = course;
           return this;
       }
       public StudentBuilder setYearLevel(int yearLevel){//6
           this.yearLevel = yearLevel;
           return this;
       }
       public StudentBuilder setNstpComp(String nstpComp){//7
           this.nstpComp = nstpComp;
           return this;
       }
       public StudentBuilder setEmail(String email){//8
           this.email = email;
           return this;
       }
       public StudentBuilder setContact(String contact){//9
           this.contact = contact;
           return this;
       }
       public StudentBuilder setAddress(String address){//10
           this.address = address;
           return this;
       }
       
       public Student build(){
           return new Student(this);
       }
    
    }
    
}