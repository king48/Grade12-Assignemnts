/*
    JuanDiego Castano
    Ms. Krasteva
    02/13/19
    This program is the bluepring for a Student, it will store the students name
	two of their marks and their average.
*/
import java.awt.*;
import hsa.Console;

public class Student
{
    public String name; // This variable will store the students name
    public int mark1; // This variable will store the first mark
    public int mark2; // This variable will store the second mark
    public double average; // this  variable will store the students overall average
    // This method will initalize the students variables
    public Student (String n)
    {
	name = n;
	mark1 = 0;
	mark2 = 0;
	average = 0.0;
    }


    //This method will set the marks for this student
    public void setMarks (int x, int y)
    {
	mark1 = x;
	mark2 = y;
    }


    //This method will calculate the overall average for the student
    public void calcAverage ()
    {

	average = (mark1 / mark2) / 2;
    }


    //This method will return a message that inclues the name of the student and their average
    public String message ()
    {

	return name + " you got an" + average;
    }
}
