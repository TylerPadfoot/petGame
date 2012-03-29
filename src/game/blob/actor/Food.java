package game.blob.actor;

public abstract class Food {
	int satiability;
	int tastiness;
	int fat;
	
	public Food(int s, int t, int f){
		satiability = s;
		tastiness = t;
		fat = f;
	}
}
