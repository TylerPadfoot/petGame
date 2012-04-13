package game.blob.actor;

import game.blob.food.*; 

import java.util.*;
import java.lang.*;
import android.util.*;
import android.graphics.Color;
import android.os.*;

public class Blob extends Pet  {
	Food Meal;
	Food Snack;
	int hours;//no max
	int days;
	int months;
	int years;
	String message;
	boolean notify;
	
	Blob (String n, Color c){
		super(n,c);
		Meal = new FoodOne();
		Snack = new FoodTwo();
		hours = 0;//no max
		days = 0;
		months = 0;
		years = 0;
		message ="";
		notify = false;
	}
	public void updateBlob(){
		updateAge();
		updateHunger();
		updateHappiness();
		updateSleepiness();
		updateSickliness();
		updateCleansiness();
	}
	private void updateCleansiness(){
		if(dirtyMeter >= 60){
			this.happinessMeter -= 5;
		}
	}
	private void updateSickliness(){
		if(sicknessMeter >= 70){
			//display sick face;
			this.happinessMeter -= 10;
			if (!this.asleep){
				this.onDoNothing();
				this.cry();
				this.message="ACHOOO!";
			}
			if (sicknessMeter >= 150){
				this.onDeath();
			}
		}
	}
	private void updateSleepiness(){
		if (this.asleep){ // if asleep, wake up when sleepiness = 0
			if (this.sleepinessMeter <= 0){
				this.asleep = false; //wakes up
			}
		}
		else{ //if not asleep, fall asleep when sleepiness = 1080
			if (this.sleepinessMeter >= 1080){
				this.onSleep();
			}
		}
		
		if(!this.asleep){//should not make trouble when asleep. when awake, likelihood to cause trouble increases.
			int threshold = 100 - this.disciplineMeter;
			Random generator = new Random(android.os.SystemClock.elapsedRealtime());//generator with randseed
			int randChance = generator.nextInt(100); // creates a random digit from 0 to 100
			if(randChance <= threshold){
				this.message="Your blob is causing a nuisance.";
			}
		}
	}
	private void updateHappiness() {
		if (!this.asleep){ //should not cry or bounce around while asleep
			if (this.happinessMeter <= 30){
				this.onDoNothing();
				this.cry();
				this.message="T_T";
			}
			else this.bounceAround();//necessary?	
		}
		
	}
	private void updateAge(){
		if (this.hours >= 24){
			this.hours = 0;
			this.days += 1;
		}
		if (this.days >= 30){
			this.days = 0;
			this.months += 1;
			//this.message = "Your blob has grown older!";
			//notify = true;
		}
		if (this.months >= 12){
			this.months = 0;
			this.years += 1;
		}
	}
	
	private void updateHunger(){
		if (!this.asleep){ //shouldn't die or poke for attention when asleep.
			if (this.hungerMeter >= 200){
				this.onDeath();
			}
			else if(this.hungerMeter >= 100){
				this.happinessMeter -= 5;
				this.message="I'm hungry. Feed me! =(";
			}
		}
	}
	/**
	 * medicate the blob, modifiese sickness and happiness
	 */
	public void giveMedication(){
		this.sicknessMeter -= 50;
		this.happinessMeter -= 40;
		this.size -= 30;
	}
	
	public void feedMeal(){
		this.eat(Meal);
	}
	
	public void feedSnack(){
		this.eat(Snack);
	}
	/**
	 * eat food
	 * decrease hunger meter
	 * and increase in satiability
	 * @param food
	 */
	public void eat(Food food){
		//eat Meal or Snack; modifies happinessMeter and hungerMeter
		this.happinessMeter += food.getTastiness();
		this.hungerMeter -= food.getSatiability();
		this.size += food.getFat();
		if(this.hungerMeter <= 0){
			this.hungerMeter=0;
		}
	}
	/**
	 * Scold
	 */
	public void scold(){
		//scold to +40 to discipline maybe also subtract from happiness
		this.disciplineMeter += 40;
	}
	
	public void clean(){
		//takes a shower to set dirty meter to 0
		this.dirtyMeter = 0;
	}
	
	public void play(){
		//modifies happinessMeter greatly, slightly adds to dirtyMeter, slightly adds to hungerMeter
		//TODO - add minigames to alter meter levels.
		this.happinessMeter += 50;
		this.dirtyMeter += 20;
		this.hungerMeter += 20;
	}

	public void bounceAround() {
		// bounce bounce bounce!
	}
	
	
	public void wobble(){
		//to display wobble animation when poked
	}
	
	public void onDoNothing() {
		// TODO Auto-generated method stub
		// stands still
	}

	public void onWantAttention() {
		// send push notification with 'message'
		//return message;
		// FIXME ShawnLim, do we want our blob to decide what message we send?
		// i vote for just randomly picking from a list of messages
	}

	public void onSleep(){
		//activates when sleepiness reaches 1080, deactivates when sleepiness = 0
		//ticks sleeping per minute
		
		//TODO perhaps eventually, make the system more intelligient, such as a baby blob sleep more than old ones
		if (true/*gamestate == lightsOff*/){
			this.snore(1);
			this.sleepinessMeter -= 3; // for sleeping for 6 hours 
		}
		else 
		{	//FIXME dead else
			this.snore(0);
			this.sleepinessMeter -= 1; //for sleeping for 18 hours  with lights on.
			this.happinessMeter -= 1;
		}
		this.asleep = true;
	}
	
	public void snore(int state) {
		// display zzz
		if (state == 1){
			//display zzz black on white
		}
		else if (state == 0){
			//display zzz white on black
		}
		
	}

	public void onPoop() {
		//poop chances increased when hunger level > 80
		this.dirtyMeter += 40;
	}

	public void cry() {
		// display sad face
		
	}

	public void onDeath() {
		// display dead blob, disables all actions
		
	}
	
	public void onSad(){
		//animates a sadface =(;
	}
	public void onHappy(){
		// happy face =D
	}
	
}
