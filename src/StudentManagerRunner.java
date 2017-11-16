public class StudentManagerRunner
{

   public static void main(String[] args)
   {
      StudentManager students = new StudentManager();
      students.add("Anisa", "A");
      students.add("Carlos", "B+");
      students.add("James", "A-");
      
      System.out.println(students.getPrintableRoster());
   }
   
  

}