
public class Pile {

	private int size;

	public Pile() {

		size = 10;
			
	}
	
	public Pile(int s) {
		
		size = s;
	}

	public int getSize() {

		return this.size;
	}

	public void remove(int a) {

		this.size = this.size - a;
	}

}
