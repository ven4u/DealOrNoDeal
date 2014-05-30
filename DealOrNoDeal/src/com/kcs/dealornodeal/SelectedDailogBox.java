package com.kcs.dealornodeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

public class SelectedDailogBox{
	
	private Context context;
	//private String title;
	//private String message;
	
	
	SelectedDailogBox(Context context){
		
		this.context = context;
		//this.title = title;
		//this.message = message;
	}
	public void showDailog(ImageAdapter IA, Integer shuffeled){
	
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		// Get the layout inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		View view = inflater.inflate(R.layout.dailogbox_layout, null);
		ImageView image = (ImageView) view.findViewById(R.id.image_selectedbox);
   		image.setImageResource(IA.mDollerIds[shuffeled]);   	
		// Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    alertDialogBuilder.setView(view)
			// set title
			//alertDialogBuilder.setTitle(title);

			// set dialog message
			//alertDialogBuilder
				//.setMessage(message)
			    //.setCancelable(false)
				//.setPositiveButton("Deal",new DialogInterface.OnClickListener() {
				.setNegativeButton("OK",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						Log.i("negative" , "we are in negative" );
						dialog.cancel();
					}
				});
	    		
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				
				
	}

}
