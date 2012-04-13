package game.blob.food;

/**
 * generic class for type food which the pet will eat
 * should contain cerntain parameter defining the food
 * @author lancelot
 *
 */
public abstract class Food {
	private int satiability;
	private int tastiness;
	private int fat;
	private int cost;
	
	/**
	 * new Food
	 * @param s satiability
	 * @param t tastiness
	 * @param f fat
	 * @param c cost
	 */
	public Food(int s, int t, int f, int c){
		satiability = s;
		tastiness = t;
		fat = f;
		cost = c;
	}
	public int getFat(){
		return fat;
	}
	public int getCost(){
		return cost;
	}
	public int getTastiness(){
		return tastiness;
	}
	public int getSatiability(){
		return satiability;
	}
}
