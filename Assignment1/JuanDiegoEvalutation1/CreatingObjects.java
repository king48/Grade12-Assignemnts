/*
    JuanDiego Castano
    Ms. Krasteva
    02/13/19
    This method will create 5 objects for all of the following classes : Student class, Car Class, House Class,
	Animal Class. 

*/
import java.awt.*;
import hsa.Console;

public class CreatingObjects
{
    public static void main (String[] args)
    {
	// Student Class
	Student sOne = new Student ("Ted Mosby");
	sOne.setMarks (80, 97);
	sOne.calcAverage ();
	sOne.message ();
	Student sTwo = new Student ("Carl Chung");
	sTwo.setMarks (60, 67);
	sTwo.calcAverage ();
	sTwo.message ();
	Student sThree = new Student ("Richard Hammond");
	sThree.setMarks (78, 82);
	sThree.calcAverage ();
	sThree.message ();
	Student sFour = new Student ("Hernando Smith");
	sFour.setMarks (85, 88);
	sFour.calcAverage ();
	sFour.message ();
	Student sFive = new Student ("John Johnson");
	sFive.setMarks (55, 49);
	sFive.calcAverage ();
	sFive.message ();
	// Car Class
	Car cOne = new Car ("Audi", "R8", 40, 60);
	cOne.drive (60);
	cOne.gasUp ();
	Car cTwo = new Car ("Nissan", "370Z", 10, 70);
	cTwo.drive (7);
	cTwo.gasUp ();
	Car cThree = new Car ("Alfa Romeo", "4C Spider", 100, 100);
	cThree.drive (180);
	cThree.gasUp ();
	Car cFour = new Car ("Tesla", "Model X", 0, 0);
	cFour.drive (231);
	cFour.gasUp ();
	Car cFive = new Car ("Hyundai ", "I40", 40, 60);
	cFive.drive (78);
	cFive.gasUp ();
	// House Class
	House hOne = new House (15, "Carlton", "Aurora", "Ontario", "A3H 5H1", 5790, false, 2);
	hOne.displayAddress ();
	House hTwo = new House (22, "Fisher St", "King City", "Ontario", "ON L7B", 210, false, 1);
	hTwo.displayAddress ();
	House hThree = new House (281, "Erie St", "Stratford", "Ontario", "ON N5A", 891, false, 3);
	hThree.displayAddress ();
	House hFour = new House (2035, "Osler St", "Regina", "Saskatchewan", "SK S4P", 339, false, 3);
	hFour.displayAddress ();
	House hFive = new House (9919, "MacDonald Ave", "AB T9H ", "Alberta", "SK S4P", 339, false, 3);
	hFive.displayAddress ();
	//Animal Class
	Animal aOne = new Animal ("Lola", 30);
	aOne.feed ("vegetables");
	aOne.sleep ();
	Animal aTwo = new Animal ("Leo", 53);
	aTwo.feed ("watermelon");
	Animal aThree = new Animal ("Winston", 67);
	aTwo.feed ("meat");
	Animal aFour = new Animal ("Mia", 41);
	aTwo.feed ("vegatables");
	Animal aFive = new Animal ("Piper", 98);
	aTwo.feed ("pineapple");

	/*
		//Question 2 a Student Array
		String[] stdnt = new String [5];
		stdnt [0] = "TedMosby";  // fills the array with 5 names 
		stdnt [1] = "CarlChung";
		stdnt [2] = "RichardHammond ";
		stdnt [3] = "Hernando Smith";
		stdnt [4] = "John Johnson";
		//2B
		String[] stdnt2 = new String [10]; // resizes the array
		for (int a = 0 ; a < 5 ; a++)
		{
		    stdnt2 [a] = stdnt [a]; // fills  the array with the names from stdnt []
		}
		//2C
		stdnt2 [7] = "Jimmy Jole";
		stdnt2 [7] = new Student (stdnt2 [7]);
		stdnt2 [7].setMarks (98, 67);
		stdnt2 [7].calcAverage ();
		stdnt2 [7].message ();
		//2D
		for (int a = 0 ; a < 10 ; a++)
		{
		    stdnt2 [a].setMarks ((int) (Math.random () * 80) + 20, (int) (Math.random () * 80) + 20);
		    stdnt2 [a].calcAverage ();
		    stdnt2 [a].message ();
		    System.out.print (stdnt2 [a].message ());
		}
	*/
    }
}
