package game.blob.actor;

import com.games.blobpet.*;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class BlobPetActivity extends Activity {
	Blob pet = new Blob("",new Color());
	
	private EditText mHunger;
	private EditText mSleepy;
	private EditText mDiscipline;
	private EditText mSickness;
	private EditText mDirty;
	
	String savefile = "blob";	
	
	private Timer timer = new Timer();
	
	OnClickListener mFeedMealListener;
	OnClickListener mFeedSnackListener;
	OnClickListener mScoldListener;
	OnClickListener mCleanListener;
	OnClickListener mPlayListener;
	OnClickListener mToggleLightsListener;
	
	Intent blobService;
	public BlobPetActivity(){
		super();
		initListeners();
		blobService = new Intent("game.blob.actor.BlobPetService");
	}
	/**
	 * initialize listener fields
	 */
	private void initListeners(){
		mFeedMealListener = new OnClickListener() {
	        public void onClick(View v) {
	            pet.feedMeal();
	            tempService();
	        }
	    };
	    mFeedSnackListener = new OnClickListener() {
	        public void onClick(View v) {
	            pet.feedSnack();
	            tempService();
	        }
	    };
	    mScoldListener = new OnClickListener() {
	        public void onClick(View v) {
	            pet.scold();
	            tempService();
	        }
	    };
	    mCleanListener = new OnClickListener() {
	        public void onClick(View v) {
	            pet.clean();
	            tempService();
	        }
	    };
	    mPlayListener = new OnClickListener() {
	        public void onClick(View v) {
	            pet.play();
	            tempService();
	        }
	    };
	    mToggleLightsListener = new OnClickListener() {
	        public void onClick(View v) {
	        }
	    };
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        BlobPetActivity.this.startService(blobService);
        // Hook up button presses to the appropriate event handler.
        ((Button) findViewById(R.id.feedMeal)).setOnClickListener(mFeedMealListener);
        ((Button) findViewById(R.id.feedSnack)).setOnClickListener(mFeedSnackListener);
        ((Button) findViewById(R.id.clean)).setOnClickListener(mCleanListener);
        ((Button) findViewById(R.id.play)).setOnClickListener(mPlayListener);
        ((Button) findViewById(R.id.scold)).setOnClickListener(mScoldListener);
        ((Button) findViewById(R.id.toggleLights)).setOnClickListener(mToggleLightsListener);
        mHunger = (EditText) findViewById(R.id.hunger);
        mSleepy = (EditText) findViewById(R.id.sleepy);
        mDiscipline = (EditText) findViewById(R.id.discipline);
        mSickness = (EditText) findViewById(R.id.sickness);
        mDirty = (EditText) findViewById(R.id.dirty);
        updateGameState();
    }
	private void updateGameState(){
		timer.scheduleAtFixedRate(
				new TimerTask(){
					@Override
					public void run() {
				        SharedPreferences settings = getSharedPreferences("blob", 0);
				       	pet.name = settings.getString("name", "Blob");
				       	pet.asleep = settings.getBoolean("asleep", false);
				       	pet.color = new Color(); //FIXME need to somehow convert a string into color
				       	pet.days = settings.getInt("days", 0);
				       	pet.dirtyMeter = settings.getInt("dirtyMeter", 0);
				       	pet.disciplineMeter = settings.getInt("disciplineMeter", 50);
				       	pet.size = settings.getInt("fat", 0);
				       	pet.happinessMeter = settings.getInt("happinessMeter", 50);
				       	pet.sleepinessMeter = settings.getInt("sleepinessMeter", 0);
				       	pet.sicknessMeter = settings.getInt("sicknessMeter", 0);
				       	pet.hours = settings.getInt("hours",0);
				       	pet.months = settings.getInt("months", 0);
				       	pet.years = settings.getInt("years",0);
				       	pet.notify = settings.getBoolean("notify", false);
				       	pet.message = settings.getString("message", "");
				      // 	tempService();
						}
				}
				, 
				0, 1000);
	}
    
    public void tempService(){
    	//updates textfields in main.xml to show current stats
        	mHunger.setText(Integer.toString(pet.hungerMeter));
        	mSleepy.setText(Integer.toString(pet.sleepinessMeter));
        	mDiscipline.setText(Integer.toString(pet.disciplineMeter));
        	mSickness.setText(Integer.toString(pet.sicknessMeter));
        	mDirty.setText(Integer.toString(pet.dirtyMeter));
    	}
    /**
     * testing stopping service
     * should really never be stopped need to be changed later
     */
    @Override
    protected void onStop(){
    	super.onStop();
    	BlobPetActivity.this.stopService(blobService);
    }
    }
