package game.blob.actor;

import java.util.Timer;
import java.util.TimerTask;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BlobPetService extends Service {	
	private Timer timer = new Timer();
	private Blob pet=new Blob("",0);
	
	@Override
    public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Service Created...", Toast.LENGTH_LONG).show();
		_startService();
    }
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void _startService(){
		timer.scheduleAtFixedRate(
				new TimerTask(){
				@Override
				public void run() {
			        SharedPreferences settings = getSharedPreferences("blob", 0);
			        //supposed to load petstate
//			       	pet.name = settings.getString("name", "Blob");
//			       	pet.asleep = settings.getBoolean("asleep", false);
//			       	pet.color = settings.getInt("color", 0);
//			       	pet.days = settings.getInt("days", 0);
//			       	pet.dirtyMeter = settings.getInt("dirtyMeter", 0);
//			       	pet.disciplineMeter = settings.getInt("disciplineMeter", 50);
//			       	pet.fat = settings.getInt("fat", 0);
//			       	pet.happinessMeter = settings.getInt("happinessMeter", 50);
//			       	pet.sleepinessMeter = settings.getInt("sleepinessMeter", 0);
//			       	pet.sicknessMeter = settings.getInt("sicknessMeter", 0);
//			       	pet.hours = settings.getInt("hours",0);
//			       	pet.months = settings.getInt("months", 0);
//			       	pet.years = settings.getInt("years",0);
//			       	pet.notify = settings.getBoolean("notify", false);
//			       	pet.message = settings.getString("message", "");
					updateBlobState();
					saveState();
					}
				}
				, 
				0, 10);
	}
	public void updateBlobState(){
		pet.hungerMeter += 1;
		pet.happinessMeter -= 1;
		pet.hours += 1;//to change
		pet.disciplineMeter -=1;
		pet.sleepinessMeter += 1;
		 pet.updateBlob();
	}
	public void saveState(){
        SharedPreferences settings = getSharedPreferences("blob", 0);
        SharedPreferences.Editor editor = settings.edit();
       	editor.putString("name", pet.name);
       	editor.putBoolean("asleep", pet.asleep);
        editor.putInt("color", pet.color);
       	editor.putInt("days", pet.days);
       	editor.putInt("dirtyMeter", pet.dirtyMeter);
       	editor.putInt("disciplineMeter", pet.disciplineMeter);
       	editor.putInt("fat", pet.fat);
        editor.putInt("happinessMeter", pet.happinessMeter);
       	editor.putInt("sleepinessMeter", pet.sleepinessMeter);
       	editor.putInt("sicknessMeter", pet.sicknessMeter);
       	editor.putInt("hours",pet.hours);
       	editor.putInt("months", pet.months);
       	editor.putInt("years",pet.years);
        editor.putBoolean("notify", pet.notify);
       	editor.putString("message", pet.message);
       	editor.commit();
	}
}
