package game.blob.food;

public class Sushi extends Food{

	private final static int SATIABILITY = 13;
	private final static int TASTINESS = 7;
	private final static int FAT = 1;
	private final static int COST = 9;
	
	
	public Sushi(){
		super(SATIABILITY, TASTINESS, FAT, COST);
	}

}
