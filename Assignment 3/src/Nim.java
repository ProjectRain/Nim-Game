import java.util.Random;
import java.util.Scanner;

public class Nim {

	private Pile pileA;
	private Pile pileB;
	private Pile pileC;
	private Random rnd = new Random();

	private Scanner input = new Scanner(System.in);

	public Nim() {

		System.out.print("Welcome to the NIM game");
		System.out.print("\nWe play by the misère rules\n");
		pileA = new Pile(rnd.nextInt(11) + 10);
		pileB = new Pile(rnd.nextInt(11) + 10);
		pileC = new Pile(rnd.nextInt(11) + 10);

		while (!done()) {
			PlayerMove();
			computerMove();

		}

	}

	public boolean PlayerMove() {
		int num = 0;
		boolean check = true;

		if (done()) {
			return false;
		}
		while (check) {
			printPiles();
			System.out.print("\n\nSelect a pile: ");
			String pile = input.next();

			if (pile.equals("a") || pile.equals("b") || pile.equals("c") || pile.equals("A") || pile.equals("B")
					|| pile.equals("C")) {
				// checking to see correct pile
				if (pile.equals("A") || pile.equals("a")) {
					if (pileA.getSize() <= 0) {
						System.out.print("\nPile A is empty, pick another");
					} else {
						System.out.print("How many do you want to remove? ");
						num = input.nextInt();
						if (num > 0 && num < pileA.getSize() + 1) { // checking to see if num between 1-10
							pileA.remove(num);
							printPiles();
							check = false; // everything is true breaks from while loop
						} else {
							System.out.print("Pick a number between 1 and " + pileA.getSize() + "\n");
						}

					}
				}

				if (pile.equals("B") || pile.equals("b")) {
					if (pileB.getSize() <= 0) {
						System.out.print("\nPile B is empty, pick another");
					} else {
						System.out.print("How many do you want to remove? ");
						num = input.nextInt();
						if (num > 0 && num < pileB.getSize() + 1) { // checking to see if num between 1-10
							pileB.remove(num);
							printPiles();
							check = false; // everything is true breaks from while loop
						} else {
							System.out.print("Pick a number between 1 and " + pileB.getSize() + "\n");
						}

					}
				}

				if (pile.equals("C") || pile.equals("c")) {
					if (pileC.getSize() <= 0) {
						System.out.print("\nPile C is empty, pick another");
					} else {
						System.out.print("How many do you want to remove? ");
						num = input.nextInt();
						if (num > 0 && num < pileC.getSize() + 1) { // checking to see if num between 1-10
							pileC.remove(num);
							printPiles();
							check = false; // everything is true breaks from while loop
						} else {
							System.out.print("Pick a number between 1 and " + pileC.getSize() + "\n");
						}

					}
				}

			} else {
				System.out.print("Invalid pile letter, select a, b or c \n");

			}
		}
		if (pileA.getSize() + pileB.getSize() + pileC.getSize() == 0) {
			System.out.print("\nSorry: you lose");
		}
		return true;
	}

	public void computerMove() {

		int n = 0;
		int p = rnd.nextInt(3) + 1;
		boolean check = false;

		if (done()) { // checking if game is done
			return;
		}

		while (!check) { // checks if selected pile is empty, if empty pick another pile
			if (p == 1) {
				if (pileA.getSize() == 0) {
					p = rnd.nextInt(3) + 1;
				} else {
					n = rnd.nextInt(pileA.getSize()) + 1; // n is between 1 and pileA size max. (rndom)
					// if the size is smaller than the rndom number,
					if (pileA.getSize() < n) {
						pileA.remove(pileA.getSize());
						System.out.print("\nComputer takes " + pileA.getSize() + " from pile A");

					} else {
						pileA.remove(n);
						System.out.print("\nComputer takes " + n + " from pile A\n");
					}
					check = true;
				}
			}
			if (p == 2) {
				if (pileB.getSize() == 0) {
					p = rnd.nextInt(3) + 1;
				} else {
					n = rnd.nextInt(pileB.getSize()) + 1;
					// if the size is smaller than the rndom number,
					if (pileB.getSize() < n) {
						pileB.remove(pileB.getSize());
						System.out.print("\nComputer takes " + pileB.getSize() + " from pile B");

					} else {
						pileB.remove(n);
						System.out.print("\nComputer takes " + n + " from pile B\n");
					}
					check = true;
				}
			}
			if (p == 3) {
				if (pileC.getSize() == 0) {
					p = rnd.nextInt(3) + 1;
				} else {
					n = rnd.nextInt(pileC.getSize()) + 1;
					// if the size is smaller than the rndom number,
					if (pileC.getSize() < n) {
						pileC.remove(pileC.getSize());
						System.out.print("\nComputer takes " + pileC.getSize() + " from pile C");

					} else {
						pileC.remove(n);
						System.out.print("\nComputer takes " + n + " from pile C\n");
					}
					check = true;
				}
			}

		}
		if (pileA.getSize() + pileB.getSize() + pileC.getSize() == 0) {
			System.out.print("Congrats: you win");
		}
		return;
	}

	public boolean done() {

		if ((pileA.getSize() == 0 && pileB.getSize() == 0 && pileC.getSize() == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public void printPiles() {

		System.out.print("	A	B	C");
		System.out.print("\n	" + pileA.getSize() + "	" + pileB.getSize() + "	" + pileC.getSize());
	}

}
