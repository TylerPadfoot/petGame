package com.games.blobpet;

import java.util.*;
import java.lang.*;
import android.util.*;
import android.os.*;

public class Blob implements BlobActions {
	String name;
	Food Meal;
	Food Snack;
	int hungerMeter; //at 100, all bars empty. max 200 = death;
	int hours;//no max
	int days;
	int months;
	int years;
	int happinessMeter;
	int sleepinessMeter; //max 1080
	int disciplineMeter;
	int sicknessMeter;
	int dirtyMeter;
	int fat; // max 100
	int color;
	boolean asleep;
	String message;
	boolean notify;
	
	Blob (String n, int c){
		name = n;
		Meal = new Food(40, 10, 1);
		Snack = new Food(20, 40, 5);
		hungerMeter = 0; //at 100, all bars empty. max 200 = death;
		hours = 0;//no max
		days = 0;
		months = 0;
		years = 0;
		happinessMeter = 50;
		sleepinessMeter = 0; //max 1080
		disciplineMeter = 50;
		sicknessMeter = 50;
		dirtyMeter = 0;
		fat = 0; // max 100
		asleep = false;
		color = c;
		message ="";
		notify = false;
	}
	public void updateBlob(){
		//updates age
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
		//end of age update
		
		//start of hunger mechanisms
		if (!this.asleep){ //shouldn't die or poke for attention when asleep.
			if (this.hungerMeter >= 200){
				this.die();
			}
			else if(this.hungerMeter >= 100){
				this.happinessMeter -= 5;
				this.message="I'm hungry. Feed me! =(";
			}
		}
		//end of hunger mechanisms
		
		//start of happiness
		if (!this.asleep){ //should not cry or bounce around while asleep
			if (this.happinessMeter <= 30){
				this.stayStill();
				this.cry();
				this.message="T_T";
			}
			else this.bounceAround();//necessary?	
		}
		//end of happiness
		
		//start of sleepiness
		if (this.asleep){ // if asleep, wake up when sleepiness = 0
			if (this.sleepinessMeter <= 0){
				this.asleep = false; //wakes up
			}
		}
		else{ //if not asleep, fall asleep when sleepiness = 1080
			if (this.sleepinessMeter >= 1080){
				this.sleep();
			}
		}
		//end of sleepiness
		
		if(!this.asleep){//should not make trouble when asleep. when awake, likelihood to cause trouble increases.
			int threshold = 100 - this.disciplineMeter;
			Random generator = new Random(android.os.SystemClock.elapsedRealtime());//generator with randseed
			int randChance = generator.nextInt(100); // creates a random digit from 0 to 100
			if(randChance <= threshold){
				this.message="Your blob is causing a nuisance.";
			}
		}
		
		if(sicknessMeter >= 70){
			//display sick face;
			this.happinessMeter -= 10;
			if (!this.asleep){
				this.stayStill();
				this.cry();
				this.message="ACHOOO!";
			}
			if (sicknessMeter >= 150){
				this.die();
			}
		}
		if(dirtyMeter >= 60){
			this.happinessMeter -= 5;
		}
	}
	public void giveMedication(){
		this.sicknessMeter -= 50;
		this.happinessMeter -= 40;
		this.fat -= 30;
	}
	public void feedMeal(){
		this.eat(Meal);
	}
	
	public void feedSnack(){
		this.eat(Snack);
	}
	
	public void eat(Food foodType){
		//eat Meal or Snack; modifies happinessMeter and hungerMeter
		this.happinessMeter += foodType.tastiness;
		this.hungerMeter -= foodType.satiability;
		this.fat += foodType.fat;
	}
	
	public void sleep(){
		//activates when sleepiness reaches 1080, deactivates when sleepiness = 0
		//ticks sleeping per minute
		
		if (true/*gamestate == lightsOff*/){
			this.snore(1);
			this.sleepinessMeter -= 3; // for sleeping for 6 hours 
		}
		else 
		{
			this.snore(0);
			this.sleepinessMeter -= 1; //for sleeping for 18 hours  with lights on.
			this.happinessMeter -= 1;
		}
		this.asleep = true;
	}

	public void scold(){
		//scold to +40 to discipline
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
	
	public void stayStill() {
		// TODO Auto-generated method stub
		// stands still
	}

	public String pokeForAttention(String message) {
		// send push notification with 'message'
		return message;
	}

	public void snore(int state) {
		// display zzz
		if (state == 1){
			//display zzz black on white
		}
		else if (state == 0){
			//display zzz white on black
		}
		else return;
	}

	public void poop() {
		//poop chances increased when hunger level > 80
		this.dirtyMeter += 40;
	}

	public void cry() {
		// display sad face
		
	}

	public void die() {
		// display dead blob, disables all actions
		
	}
	
	public void sadFace(){
		//animates a sadface;
	}
	
}
