package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//class for making blackjack hands (user, cpu)
class hand<T> extends deck<T> {

	//Arraylist used to easily add/remove elements ("cards) from list ("hand")
	ArrayList<String> hand;
	int sum = 0;
	//track keeps "track" of which index we are at within the hand, so everytime we call find sum, we aren't traversing the arraylist
	//everytime we call it.
	int track = 0;

	//default constructor, makes hand, blackjack starts with 2 cards.
	public hand() 
	{
		 hand = new ArrayList<>(2);
	}
	//retrieve elems from deck arraylist obj, adds them to hand
	public void getHand(deck <String> deck)
	{
		for(int i = 0; i < 2; i++)
		{
			hand.add( i, deck.draw() );
		}
	}
	//addds single elem to hand, used for "hit"/draw" to your hand
	public void addCard(deck <String> deck)
	{
		hand.add(deck.draw());
	}
	//removes all elems from list, used for starting over/"next hand"
	//also sets track equal to zero.
	public void fold()
	{
		int bound = getSize();
		for(int i = 0; i < bound; i++)
		{
			hand.remove(0);
		}
		this.track = 0;
	}
	public void resetSum()
	{
		this.sum = 0;
	}
	public int getSize()
	{
		return hand.size();
	}
	public String getCard(int i)
	{
		return hand.get(i);
	}
	//sets sum to zero, used when starting new hand
	//returns value of sum for the current hand obj
	public int fetchSum()
	{
		return sum;
	}
	//used to add values to the sum (crucial for dealing with Aces)
	public void addSum(int sum)
	{
		this.sum += sum;
	}
	//chooses value to add to sum based on first character of each string elem in array list.
	//increments 1 to track
	public void findSum()
	{
		int size = hand.size();
		for(int i = track; i < size; i++)
		{
			if(hand.get(i).charAt(0) == 'A')
			{
				track++;
			}
			if(hand.get(i).charAt(0) == '2')
			{
				addSum(2);
				track++;
			}
			if(hand.get(i).charAt(0) == '3')
			{
				addSum(3);
				track++;
			}
			if(hand.get(i).charAt(0) == '4')
			{
				addSum(4);
				track++;
			}
			if(hand.get(i).charAt(0) == '5')
			{
				addSum(5);
				track++;
			}
			if(hand.get(i).charAt(0) == '6')
			{
				addSum(6);
				track++;
			}
			if(hand.get(i).charAt(0) == '7')
			{
				addSum(7);
				track++;
			}
			if(hand.get(i).charAt(0) == '8')
			{
				addSum(8);
				track++;
			}
			if(hand.get(i).charAt(0) == '9')
			{
				addSum(9);
				track++;
			}
			if(hand.get(i).charAt(0) == '1'||  hand.get(i).charAt(0) == 'J' || hand.get(i).charAt(0) == 'Q' || hand.get(i).charAt(0) == 'K')
			{
				addSum(10);
				track++;
			}
		
		}
	}
	//prints elems in hand arraylist
	public void showHand()
	{
		for(int i = 0; i < hand.size(); i++)
			System.out.print(hand.get(i) + " ");
	}

}

//class that makes the deck for the game
class deck <T> {
	
	//arraylist deck holds all 52 elems/cards inside of it
	//use copy to refill deck once deck is empty
	ArrayList <String> deck = new ArrayList<>(56);
	ArrayList <String> copy;
	int deckSize = 0;
	
	//4 suits, all get added into arraylist deck
	String [] hrts = new String[14];
	String [] sp = new String[14];
	String [] dia = new String[14];
	String [] club = new String[14];


	//adds values to the 4 suit arrays
	public deck() {

		String s = " ";
		for(int i = 0; i < hrts.length; i++)
		{
			if(i <= 10)
			{
				if(i == 0)
				{
					s = "AH";
					hrts[i] = s;
					s = "ASp";
					sp[i] = s;
					s = "AD";
					dia[i] = s;
					s = "AC";
					club[i] = s;
				}
				else
				{
					s = i+1 + "H";
					hrts[i] = s;
					
					s = i+1 + "Sp";
					sp[i] = s;
					
					s = i+1 + "D";
					dia[i] = s;
					
					s = i+1 + "C";
					club[i] = s;
				}
			}
			if(i == 11)
			{
				s = "JH";
				hrts[i] = s;
				
				s = "JSp";
				sp[i] = s;
				
				s = "JD";
				dia[i] = s;
				
				s = "JC";
				club[i] = s;
			}
			if(i == 12)
			{
				s = "QH";
				hrts[i] = s;
				
				s = "QSp";
				sp[i] = s;
				
				s = "QD";
				dia[i] = s;
				
				s = "QC";
				club[i] = s;
			}
			if(i == 13)
			{
				s = "KH";
				hrts[i] = s;
				
				s = "KSp";
				sp[i] = s;
				
				s = "KD";
				dia[i] = s;
				
				s = "KC";
				club[i] = s;
			}
		
		}
		makeDeck();
	}
	//adds the values from the 4 suit arrays to the arraylist deck, removes 11 since there is no value for 11 in standard poker/bj deck
	public void makeDeck()
	{
		int size = 0;
		for(int i = 0; i < hrts.length; i++)
		{
			deck.add(size, hrts[i]);
			size++;
		}
		for(int i = 0; i < sp.length; i++)
		{
			deck.add(size, sp[i]);
			size++;
		}
		for(int i = 0; i < dia.length; i++)
		{
			deck.add(size, dia[i]);
			size++;
		}
		for(int i = 0; i < club.length; i++)
		{
			deck.add(size, club[i]);
			size++;
		}
		
		for(int i = 0; i < deck.size(); i++)
		{
			if(deck.get(i).charAt(0) == '1' && deck.get(i).charAt(1) == '1')
			{
				deck.remove(i);
			}
		}
		
		deckSize = size;
		//copy the deck into copy arraylist
		copy = new ArrayList<String>(deck);
		
	
	}
	//refills deck using copy arraylist, calls upon shuffle function to shuffle elems once its refilled
	public void refillDeck()
	{
		for(int i = 0; i < copy.size(); i++)
		{
			deck.add(copy.get(i) );
		}
		Shuffle();
	}
	public int getSize() 
	{
		return deckSize;
	}
	//native shuffle function from collections
	//if deck is empty, refill deck, otherwise shuffle it
	public void Shuffle()
	{
		if(deck.isEmpty())
		{
			refillDeck();
		}
		else
		{
		Collections.shuffle(deck);
		}
	}
	//once cpu or user calls for another card, draw function is used, takes first elem from deck and returns it.
	//if the function is called and deck is empty, calls for the refill deck function first.
	public String draw()
	{
		if(deck.isEmpty())
		{
			refillDeck();
			return deck.remove(0);
		}
		else
		{
			return deck.remove(0);
		}
	}
}
//class that handles the game of blackjack
class BJgame<T>{
	
	public static Scanner reader = new Scanner(System.in);
	int coin;
	int bet;

	//default constructor, user starts with 10 coins
	public BJgame()
	{
		coin = 10;
	}
	//takes bet value user inputs and saves the value in bet
	public void setBet(int bet)
	{
		this.bet = bet;
	}
	//returns the value in bet
	public int getBet()
	{
		return bet;
	}
	//returns value of coins
	public int getCoins()
	{
		return coin;
	}
	//lets user decide how to handle an Ace in their hand. whether it wouldbe 11 or 1, ace doesn't have value in findsum
	//as the value for ace could be different depending on the sum user currently have
	public void aceChoice(hand <String> user)
	{
		String answer = " ";
		System.out.println("You have an Ace in your hand. Do you want it to count as an 11 or a 1? (11 or 1)");
		answer = reader.next();
			if(answer.equalsIgnoreCase("11"))
			{
				 user.addSum(11);
			}
			if(answer.equalsIgnoreCase("1"))
			{
				user.addSum(1);
			}
	}
	//how CPU decides how to handle an Ace in their hand. whether it would be 11 or 1, ace doesn't have value in findsum
	//as the value for ace could be different depending on the sum user currently have
	//array ace saves indecies of ace from the hand, so when this function is called again for the same hand, cpu doesn't "find" the same ace it already
	//calculated value for
	public void cpuAce(hand <String> cpu)
	{
		int size = cpu.getSize();
		int [] ace = new int[4];
		int x = 0;
		for(int i = 0; i < size; i++)
		{
			if(cpu.getCard(i).charAt(0) == 'A')
			{
				ace[x] = i;
				x++;
			}
		}
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < ace.length; j++)
			{
				if(i == ace[j])
				{
					if(cpu.getCard(i).charAt(0) == 'A' && cpu.fetchSum() <= 10 )
					{
						cpu.addSum(11);
					}
					else if(cpu.getCard(i).charAt(0) == 'A' && cpu.fetchSum() > 10)
					{
						cpu.addSum(1);
					}
					else
					{
						continue;
					}
				}
			}
		}
	}
	//the game of blackjack, 10 coins, asks user if they want to play. must say yes to continue
	//as long as user has more than 0 coins left, the game will continue to play.
	public void playGame(hand<String> user, hand<String> cpu, deck <String> deck)
	{
		coin = 10;
		String play = "y";
		String answer = " ";
		deck.Shuffle();
		
		System.out.println("Interested in playing a game of blackjack? you're given 10 coins to play with. (Y/N)");
		answer = reader.next();
		
		while(!answer.equalsIgnoreCase(play) )
		{
			System.out.println("Interested in playing a game of blackjack? you're given 10 coins to play with. (Y/N)");
			answer = reader.next();
		}
		
		while(coin > 0)
		{
			user.getHand(deck);
			user.findSum();
			
			cpu.getHand(deck);
			cpu.findSum();
			
			cpuAce(cpu);
			System.out.println("\n\n" + "You have " + coin + " Left, how much do you want to be on this hand?");
			bet = reader.nextInt();
			
			while(bet > coin)
			{
				System.out.println("You cannot bet " + bet + " coins, you only have " + coin + "please place a new bet...");
				bet = reader.nextInt();
			}
			
			System.out.println();
			user.showHand();
			//checks within user's hand if there is an ace, if it is, call aceChoice function to give Ace a value
			//ace variable keeps track of index of the ace elem within the hand.
			int ace = 0;
			for(int i = 0; i < user.getSize(); i++)
			{
				if(user.getCard(i).charAt(0) == 'A')
				{
					aceChoice(user);
					ace = i;
				}
			}
			
			
			System.out.println("\n" + "You're at " + user.fetchSum() + " , Do you want to draw another card or stay where you're at? (hit/stay)");
			answer = reader.next();
			
			if(answer.equalsIgnoreCase("hit"))
			{
				while(!answer.equalsIgnoreCase("stay"))
				{
					user.addCard(deck);
					user.findSum();
					//checks within user's hand if there is an ace, if it is, call aceChoice function to give Ace a value
					//as long as i does not equal int ace, meaning it is a new ace in the hand
					int size = user.getSize();
					for(int i = 0; i < size; i++)
					{
						if(user.getCard(i).charAt(0) == 'A' && ace != i)
						{
							aceChoice(user);
							ace = i;
						}
					}
					user.findSum();
					System.out.println();
					user.showHand();
					System.out.println("\n" + "You're at " + user.fetchSum() + ", Do you want to draw another card or stay where you're at? (hit/stay)");
					answer = reader.next();
				}
			}
			while(cpu.fetchSum() < 17)
			{
				if(cpu.fetchSum() < 17)
				{
					cpu.addCard(deck);
					cpu.findSum();
					cpuAce(cpu);
				}
			
			}
			
			//checks for absolute wins or loses like black jack and/or both bust 
			if(cpu.fetchSum() == 21 || user.fetchSum() == 21)
			{
				if(user.fetchSum() == 21 && cpu.fetchSum() != 21)
				{
					System.out.println("\n" + "You have blackjack! You win!!");
					System.out.print("\n" + "User hand: " + "\n");
					user.showHand();
					System.out.print("\n\n" + "cpu hand: " + "\n");
					cpu.showHand();
					System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n");
					coin = coin + bet;
				
				}
				else
				{
					System.out.println("\n" + "CPU has blackjack! You lose!");
					System.out.print("\n" + "User hand: " + "\n");
					user.showHand();
					System.out.print("\n\n" + "cpu hand: "+ "\n");
					cpu.showHand();
					System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n");
					coin = coin - bet;
					
				}
			}
			else if(cpu.fetchSum() > 21 || user.fetchSum() > 21)
			{
				if(user.fetchSum() > 21 && cpu.fetchSum() < 21)
				{
					System.out.println("\n" + "You're over 21, busted hand!");
					System.out.print("\n" + "User hand:" + "\n");
					user.showHand();
					System.out.print("\n\n" + "cpu hand:" + "\n");
					cpu.showHand();
					System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n");
					coin = coin - bet;
				
				}
				else if(user.fetchSum() < 21 && cpu.fetchSum() > 21)
				{
					System.out.println("\n" + "CPU has busted! You win!");
					System.out.print("\n" + "User hand:" + "\n");
					user.showHand();
					System.out.print("\n\n" + "cpu hand:" + "\n");
					cpu.showHand();
					System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n");
					coin = coin + bet;
					
				}
				else
				{
					System.out.println("\n" + "Both User and CPU busted!");
					System.out.print("\n" + "User hand:" + "\n");
					user.showHand();
					System.out.print("\n\n" + "cpu hand:" + "\n");
					cpu.showHand();
					System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n");
					
				}
			}
			else
			{
				checkSums(user, cpu, deck);
				
			}
			
			user.fold();
			cpu.fold();
			cpu.resetSum();
			user.resetSum();
		}
		
		if(coin <= 0)
		{
			System.out.println("\n"+ "Better luck next time, would you like to play again? (Y/N)");
			answer = reader.next();
				
				if(answer.equalsIgnoreCase("y"))
				{
					playGame(user,cpu, deck);
				}
				else
				{
					System.out.println("Thanks for playing!");
				}
		}
									
	}
	//checks the sum of user and cpu hands
	public void checkSums(hand<String> user, hand<String> cpu, deck <String> deck)
	{
		
		if (user.fetchSum() > cpu.fetchSum() )
		{
			System.out.print("\n" + "User hand:" + "\n");
			user.showHand();
			System.out.print("\n\n" + "cpu hand:" + "\n");
			cpu.showHand();
			System.out.print("\n" +"cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n" +  "USER WINS" + "\n");
			coin = coin + bet;
			
		}
		else if(user.fetchSum() < cpu.fetchSum() )
		{
			System.out.print("\n" + "User hand:" + "\n");
			user.showHand();
			System.out.print("\n\n" + "cpu hand:" + "\n");
			cpu.showHand();
			System.out.print("\n" + "cpu sum " + cpu.fetchSum() + " user sum: " + user.fetchSum() + "\n" + "CPU WINS" + "\n");
			coin = coin - bet;
		}
		
	}
}
public class blackjack {

	public static void main(String[] args) {
		
		//initialize 4 objs, game, deck and user/cpu hands
		BJgame<String> game = new BJgame<>();
		deck <String> newDeck = new deck<>();

		hand <String> user = new hand<>(); 
		hand <String> cpu = new hand<>();
		
		//starts blackjack game
		game.playGame(user, cpu, newDeck);
		
	}

}




