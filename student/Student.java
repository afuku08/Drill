public class Student {
    private String name;
    private String id;
    private String code;
    private int yy, mm, dd;
    private int english, math, japanese;
    String teacherscode;

    private class StudentEditStudent extends InitialEditStudent{
        public int getMark(int course) {
            switch (course) {
                case EditStudent.ENGLISH: return english;
                case EditStudent.MATH: return math;
                case EditStudent.JAPANESE: return japanese;
                default: return 0;
            }
        }

        public void setMark(int course, int mark){}

        public void show(){
            printStudent();
            System.out.println("ENGLISH : " + english + " MATH : " + math + " JAPANESE : " + japanese);
        }
    }

    private class TeachersEditStudent extends StudentEditStudent{
        public void setMark(int course, int mark){
            switch(course){
                case EditStudent.ENGLISH : english = mark; break;
                case EditStudent.MATH : math = mark; break;
                case EditStudent.JAPANESE : japanese = mark; break;
            }
        }
    }

    Student(String name, String id, String code, int[] date, int[] marks, String tcode){
        this.name = name;
        this.id = id;
        this.code = code;
        yy = date[0];
        mm = date[1];
        dd = date[2];
        english = marks[0];
        math = marks[1];
        japanese = marks[2];
        teacherscode = tcode;
    }

    public void printStudent(){
        System.out.println("Name : " + name);
        System.out.println("Student's ID : " + id);
        System.out.println("Entrance Date : " + yy + "/" + mm + "/" + dd);
    }

    public EditStudent createEditStudent(String passwd) {
        if(passwd.equals(teacherscode)) return new TeachersEditStudent();
        if(passwd.equals(code)) return new StudentEditStudent();
        return new InitialEditStudent();
    }
}
