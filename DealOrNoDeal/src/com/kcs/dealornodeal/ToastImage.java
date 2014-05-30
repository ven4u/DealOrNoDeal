package com.kcs.dealornodeal;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class ToastImage {
	
	
	/*public void toastImage(ImageAdapter IA, View toastLayout, Integer shuffeled, final Context context){
		ImageView image = (ImageView) toastLayout.findViewById(R.id.image);
   		image.setImageResource(IA.mDollerIds[shuffeled]);   		
	    Toast toast = new Toast(context.getApplicationContext());
	    	//toast.cancel();
		    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		    toast.setDuration(Toast.LENGTH_LONG);
		    toast.setView(toastLayout);
		    toast.show();
		   
	}
	public void toastImageWin(ImageAdapter IA, View toastLayout, Integer win, final Context context){
		ImageView image = (ImageView) toastLayout.findViewById(R.id.image);
   		//image.setImageResource(DIA.mDollerIds[lose]);   
   		image.setImageResource(IA.mDollerIds[win]);
	    Toast toast = new Toast(context.getApplicationContext());
		    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		    toast.setDuration(Toast.LENGTH_LONG);
		    toast.setView(toastLayout);
		    toast.show();		
	}
	
	public void toastImageStart(ImageAdapter IA, View toastLayout, final Context context){
		ImageView image = (ImageView) toastLayout.findViewById(R.id.image);
   		//image.setImageResource(DIA.mDollerIds[lose]);   
   		image.setImageResource(IA.start);
	    Toast toast = new Toast(context.getApplicationContext());
		    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		    toast.setDuration(Toast.LENGTH_LONG);
		    toast.setView(toastLayout);
		    toast.show();		
	}*/
	
	public void toastBriefcaseLeft(Context context, String message, View toastLayout){
		TextView text = (TextView) toastLayout.findViewById(R.id.text);
		text.setText(message);
		Toast toast = new Toast(context.getApplicationContext());
	    toast.setGravity(Gravity.BOTTOM, 0, 0);	
	    //CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		toast.setView(toastLayout);
		//toast = Toast.makeText(context, text, duration);
		toast.show();	
	}
	
	
}
