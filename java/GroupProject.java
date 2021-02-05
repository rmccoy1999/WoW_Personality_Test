import java.io.*; 
import java.util.*; 
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Image; 
import java.net.URL; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants; 

  

public class GroupProject { 

public static void main(String[] args) { 

     //declaring the frame
	JFrame frame = new JFrame("Your Character Is:"); 
	frame.setSize(900, 900); 

    //Closes the program when the panel is closed. 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
	Scanner console = new Scanner(System.in);
    Character player = new Character(); 

    //map for questions and answers 

    ArrayList<String> Qs = new ArrayList<String>();// 

    Qs.add("Which is your preferred go-to, on-the-fly drink?\n\n1)Dr. Pepper\n" + 
    		"2)Dark Cherry Powerade.\n" + 
    		"3)Ice water."); 
    Qs.add("If you were up to bat in a baseball game and a ball was thrown directly at you, what would you do?\n\n1)Get hit by the pitch and jog happily to first.\n" + 
    		"2)Jump out of the batter's box and take a wild swing at it.\n" + 
    		"3)I wouldn't be batting; I would be chasing butterflies in the outfield."); 
    Qs.add("If you were stuck with only three TV shows to choose from, which would you select?\n\n1)Ring of Honor Wrestling\n" + 
    		"2)NCIS\n" + 
    		"3)Nat Geo's Into the Wild"); 
    Qs.add("What would be your reaction to your grandmother giving you a pair of ugly socks for Christmas?\n\n1)To wear them for a day because it's your grandmother.\n" + 
    		"2)To burn them in the backyard and then mail her an envelope with the ashes.\n" + 
    		"3)To turn in the receipt and use the money to buy something different."); 
    Qs.add("On a sunny day would you prefer to:\n\n1)Go outside and sunbathe for an hour, despite a chance of horrific sunburn.\n" + 
    		"2)Stay inside and play Clash of Clans on your phone.\n" + 
    		"3)Go outside and create a homemade sun dial for the fun of it."); 
    Qs.add("Which of the following vacations sounds more appealing?\n\n1)A trip to Yosemite National Park.\n" + 
    		"2)Rock climbing in the Appalachian Mountains\n" + 
    		"3)Sky diving in the Grand Canyon"); 
    Qs.add("If you had to get one of the three following pets, which would you choose?\n\n1)A Bengal tiger to keep your mom at bay for when she comes into your room to yell at you for forgetting to do your dishes.\n" + 
    		"2)A termite colony to unleash underneath the annoying next-door neighbor's wooden deck.\n" + 
    		"3)A kitten to help soothe the nerves you get from studying for a computer science final."); 
    Qs.add("What would you do if you realized that you left your favorite pen in the school library after it closed up for the night?\n\n1)Get hold of the head librarian's phone number and text them non-stop at 3am.\n" + 
    		"2)Break open a window and search the entire library until you found it.\n" + 
    		"3)Forget about it; it's a pen and it's not worth losing 8 hours of sleep over."); 

    player=BuildChar(console, Qs); 

    showImage(player, frame); 
    printStats(player);

	} 

public static Character BuildChar(Scanner console, ArrayList<String> Qs) {//Start program 

	//counters to keep track of which character to assign based on answers 
	int H = 0; 
	int W = 0; 
	int T = 0; 

	System.out.println("Welcome to our Character Builder!"); 
	System.out.println("Let's go!\n"); 

	//loop for questions to print and keep track of answers 
	System.out.println("Choose 1, 2, or 3\n"); 

	for(int i=1; i<9;i++) { 
		System.out.println("Question "+i+":\n"); 
		System.out.println(Qs.get(i-1)); 
		boolean number = false; 
		int ans = 0; 
		while(number==false) { 
			String A = console.nextLine(); 
			Scanner Answer = new Scanner(A); 
			number = Answer.hasNextInt(); 
			if(number) { 
				ans=Answer.nextInt(); 
				if(ans>3||ans<1) { 
					number=false; 
					System.out.println("Invalid entry. Please choose 1, 2, or 3"); 
				} 
			}else { 
				System.out.println("That's not an integer number. Please choose 1, 2, or 3"); 
			} 
		} 
		if(ans==1) { 
			T++; 
		}else if(ans==2) { 
			W++; 
		}else if(ans==3) { 
			H++; 
		} 
	} 
	int c = assignChar(H, W, T); 
	System.out.println("You've been assigned to the "+Charac(c)+" Class!");
	System.out.println();
	System.out.println("Congratulations! Your're a "+ Charac(c) +"! What name do you want to be called? ");
	String name = console.nextLine();
	System.out.println("Welcome " + name + "! ");
	return Type(c, name);
	
} 


public static Character Type(int x, String name) {
	 
	if(x<0||x>2) {
		throw new IllegalArgumentException(); 
	}
	Character Ch;
	if(x==0) {
		Ch = new Healer();
		Ch.setName(name);
	}else if(x==1) {
		Ch = new Warrior();
		Ch.setName(name);
	}else {
		Ch = new Tank();
		Ch.setName(name);
	}
	return Ch;
 
}

public static String Charac(int x) { 
	if(x<0||x>2) { 
		throw new IllegalArgumentException(); 
	} 
	if(x==0) { 
		return "Healer"; 
	}else if(x==1) { 
		return "Warrior"; 
	}else { 
		return "Tank"; 
	} 
} 


public static int assignChar(int H, int W, int T) { 
	if(((H>2)&&(T==H||H==W))||((W>2)&&(W==T||W==H))) {//break the tie 
		return tiebreak(H,W,T); 
	}else if(Math.max(H, W)==H && Math.max(H,T)==H) {//healer biggest score 
		return 0; 
	}else if(Math.max(H, W)==W && Math.max(W,T)==W) {//warrior biggest score 
		return 1; 
	}else{//Tank biggest score 
		return 2; 
	} 
} 

public static int tiebreak(int H, int W, int T) {
	System.out.println("Tie-break question:\nChoose 1 or 2");
	if(H==W) {//question for tie between Healer and Warrior
		System.out.println("Do you prefer a taco salad or a regular taco?\n\n" +
			"1)Authentic Mexican Taco Bell tacos\n" + //healer
			"2)What even are these green things on the taco? "); //warrior
	}else if(H==T) {//question for tie between Healer and Tank
		System.out.println("Would you rather walk in the park or take a hike in the mountains?\n\n" +
			"1)I'm like Carl Wheezer from Jimmy Neutron. Allergies are too much to handle.\n" + //healer
			"2)Bring the view on! "); //tank
	}else if(T==W){//question for tie between Tank and Warrior
		System.out.println("Do you like high-pressure situations?\n\n" +
			"1)Please no...\n" + //tank
			"2)Uh, ya"); //warrior
	}
	
	Scanner console = new Scanner(System.in);
	boolean number = false;
	int ans = 0;
	while(number==false) {
		String A = console.nextLine();
		Scanner Answer = new Scanner(A);
		number = Answer.hasNextInt();
		if(number) {
			ans=Answer.nextInt();
			if((ans>2||ans<1)) {
				number=false;
				System.out.println("Invalid entry. Please choose 1 or 2. ");}
			}else {
				System.out.println("Invalid input. Please choose 1 or 2. ");
			}
	}
	if((H==W||H==T) && ans == 1) {//Answered 1 for Healer
		return 0;
	}else if((T==W || H==W) && ans==2) {//Answered 2 for Warrior
		return 1;
	}else {//Answered Tank
		return 2;
	}
}
 
public static void printStats(Character ch) {
	System.out.println("Here are your stats!");
	System.out.println("Health ="+ch.getHealth());
	System.out.println("Speed ="+ch.getSpeed());
	System.out.println("Strength ="+ch.getStrength());
	System.out.println("Shield ="+ch.getShield());
	System.out.println("Vertical ="+ch.getVertical());
	System.out.println(ch.getQuote());
	
}

public static void showImage(Character ch,JFrame f) {  
	Image image = null; 
	URL url = null; 
	try { 
		if(ch instanceof Healer) { 
			url = new URL("https://vignette.wikia.nocookie.net/wowwiki/images/f/f8/Taurenhealer.jpg/revision/latest?cb=20061210040032 "); 
		}
		if(ch instanceof Warrior) {
			url = new URL("https://blznav.akamaized.net/img/games/cards/card-world-of-warcraft-54576e6364584e35.jpg"); 
		}
		if(ch instanceof Tank) {
			url = new URL("https://www.blogcdn.com/wow.joystiq.com/media/2008/06/tanktalktoday.jpg ");
		}
		image = ImageIO.read(url); 
	} catch (IOException e) { 
		e.printStackTrace(); 
	} 
	//IMAGE OF CHARACTER 
	JLabel labelImg = new JLabel(new ImageIcon(image), JLabel.CENTER); 
	labelImg.setBackground(Color.BLACK); 
	labelImg.setOpaque(true); 
	f.add(labelImg); 
	f.setVisible(true); 

	}  

}//end of class 