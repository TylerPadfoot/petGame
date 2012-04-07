package game.blob.actor;
/**
 * replaces the BlobActions interface,
 * generic class for a pet,
 * specifies a series of actions that Pets are capable of doing
 * @author lancelot, padfoot
 *
 */
public abstract class Pet {
	String name;
	
	long birthTime;
	
	int hungerMeter; /** at 100, all bars empty. max 200 = death; */
	int happinessMeter;
	int sleepinessMeter; //max 1080
	int disciplineMeter;
	int sicknessMeter;
	int dirtyMeter;
	int color;
	
	boolean asleep;
	
	int size; // max 100 changed from "fat" more generic
	/**
	 * specifies pet action when no action is happening
	 */
	void onDoNothing(){
		
	}
	/**
	 * sends push notification for attention
	 */
	abstract void onWantAttention();
	/** 
	 * specifies pet action when sleeping 
	 */
	abstract void onSleep();
	/** specifies pet action when pooping */
	abstract void onPoop();
	/** specifies pet action when dead */
	abstract void onDeath();
	/** specifies pet action when happy */
	abstract void onHappy();
	/** specifies pet action when sad */
	abstract void onSad();
}
