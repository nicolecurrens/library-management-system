package libraryManagementSystem;

import java.util.Scanner;
import java.util.Hashtable;

public class LibraryManagerDisplay {
	// This class handles the console output
	Scanner input = new Scanner(System.in); // TODO Ideally we'd close this scanner at the end of main to prevent memory leaks
	Hashtable<Integer, User> userSelection = new Hashtable<>();
	Hashtable<Integer, String> mainMenu = new Hashtable<>();


//	private JTextField firstNumber  = new JTextField(10);
//	private JLabel additionLabel = new JLabel("+");
//	private JLabel subtractionLabel = new JLabel("-");
//	private JLabel multiplicationLabel = new JLabel("*");
//	private JLabel divisionLabel = new JLabel("/");
//	private JTextField secondNumber = new JTextField(10);
//	private JButton addButton = new JButton("Add");
//	private JButton subtractButton = new JButton("Subtract");
//	private JButton divideButton = new JButton("Divide");
//	private JButton multiplyButton = new JButton("Multiply");
//	private JTextField calcSolution = new JTextField(10);
	
	LibraryManagerDisplay(User[] users){
		
		this.userSelection = setUpUserSelection(users);
		this.mainMenu = setUpMainMenu();

	}
	
	private Hashtable<Integer, String> setUpMainMenu() {
		
		Hashtable<Integer, String> ht = new Hashtable<>();
		
		ht.put(0, "See current loans");
		ht.put(1, "Check out materials");
		ht.put(2, "Check in materials");
		ht.put(3, "Pay fines");
		
		return ht;
		
	}
	
	private Hashtable<Integer, User> setUpUserSelection(User[] users) {
		Hashtable<Integer, User> ht = new Hashtable<>();
		for(int i = 0; i < users.length; i++) {
			User u = users[i];
			ht.put(i, u);
		}
		
		return ht;
	}

	public int getUserInput(){
		
		int selection;
		selection = input.nextInt();
        System.out.println("");
        return selection;
        
        // TODO add a way to exit
		
	}
	
	public User displayUserSelection() {
		
		System.out.println("Pick your user: ");
		for(int i = 0; i < userSelection.size(); i++) {
			User u = userSelection.get(i);
			System.out.println(i + ": " + u.name);
		}
		int user_number = getUserInput();
		System.out.println("");
		User u = userSelection.get(user_number);
		System.out.println("You have chosen " + u.name);
		return u;
		
	}
	
	public int displayMainMenu() {
		System.out.println("How can we help you today? ");
		for(int i = 0; i < mainMenu.size(); i++) {
			String option = mainMenu.get(i);
			System.out.println(i + ": " + option);
		}
		int choice = getUserInput();
		System.out.println("");
		
		return choice;
		
	}
	
	
}
