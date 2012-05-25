package game.blob.main;

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
// FOR EASE OF MAKING NEW METHODS 
	// field definations will be at the end of class
	public Pet(String n,Color c){
		color = c;
		name = n;
		hunger = 0; //at 100, all bars empty. max 200 = death;
		happiness = 50;
		sleepiness = 0; //max 1080
		discipline = 50;
		sickness = 50;
		dirty = 0;
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
	public String getName(){
		return name; 
	}
	public int getHunger(){
		return hunger; 
	}
	public int getHappiness(){
		return happiness;
	}
	public int getSleepiness(){
		return sleepiness;
	}
	public int getDiscipline(){
		return discipline;
	}
	public int getSickliness(){
		return sickness;
	}
	public int getDirtiness(){
		return dirty;
	}
	public int getAnger(){
		return anger;
	}
	public boolean isAsleep(){
		return asleep;
	}
	String name;
	
	Time age;
	long birthTime;
	private int anger;
	int hunger; /** at 100, all bars empty. max 200 = death; */
	int happiness;
	int sleepiness; //max 1080
	int discipline;
	int sickness;
	int dirty;
	
	Color color;
	
	boolean asleep;
	
	int size; // max 100 changed from "fat" more generic
	
}
