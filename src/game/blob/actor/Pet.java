package game.blob.actor;

import java.util.*;
import java.lang.*;

import android.text.format.Time;
import android.util.*;
import android.graphics.Color;
import android.os.*;

/**
 * replaces the BlobActions interface,
 * generic class for a pet,
 * specifies a series of actions that Pets are capable of doing
 * @author lancelot, padfoot
 *
 */
public abstract class Pet {
	String name;
	
	Time age;
	long birthTime;
	
	int hungerMeter; /** at 100, all bars empty. max 200 = death; */
	int happinessMeter;
	int sleepinessMeter; //max 1080
	int disciplineMeter;
	int sicknessMeter;
	int dirtyMeter;
	
	Color color;
	
	boolean asleep;
	
	int size; // max 100 changed from "fat" more generic
	
	public Pet(String n,Color c){
		color = c;
		name = n;
		hungerMeter = 0; //at 100, all bars empty. max 200 = death;
		happinessMeter = 50;
		sleepinessMeter = 0; //max 1080
		disciplineMeter = 50;
		sicknessMeter = 50;
		dirtyMeter = 0;
		birthTime = System.currentTimeMillis();
		//FIXME size start at 0?
		size = 0; // max 100
		asleep = false;
	}
	/**
	 * specifies pet action when no action is happening
	 * subclasses should override this method, unless you want to
	 * actually do NOTHING
	 */
	void onDoNothing(){
		
	}
	public long getAgeInMilli(){
		return System.currentTimeMillis()-birthTime;
	}
	
	/**
	 * get the age of the pet
	 * @return current time in a {@link android.text.format.Time}
	 * 
	 */
	public Time getAge(){
		age = new Time(Time.getCurrentTimezone());
		age.set(getAgeInMilli());
		return age;
	}
	/**
	 * sends push notification for attention
	 */
	public abstract void onWantAttention();
	/** 
	 * specifies pet action when sleeping 
	 */	
	public abstract void onSleep();
	/** specifies pet action when pooping */
	public abstract void onPoop();
	/** specifies pet action when dead */
	public abstract void onDeath();
	/** specifies pet action when happy */
	public abstract void onHappy();
	/** specifies pet action when sad */
	public abstract void onSad();
}
