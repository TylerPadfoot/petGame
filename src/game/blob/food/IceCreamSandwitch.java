package game.blob.food;

public class IceCreamSandwitch extends Food{
	private final static int SATIABILITY = 10;
	private final static int TASTINESS = 5;
	private final static int FAT = 5;
	private final static int COST = 2;
	
	
	public IceCreamSandwitch(){
		super(SATIABILITY, TASTINESS, FAT, COST);
	}

}
