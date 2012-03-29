package game.blob.actor;

public interface BlobActions {
	void bounceAround(); //bounces randomly
	void wobble(); // wobbles
	void stayStill(); //stays still
	String pokeForAttention(String message); //sends push notification to user containing message
	void snore(int state); //displays zzz near the blob; eyes closed. disables bounceAround();
	void poop(); // creates a face and poop should appear near the blob.
	void cry(); //crying animation, used when happiness < 30
	void die(); //kills blob. T_T
	void sadFace();//makes a sad face
}
