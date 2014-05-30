package com.kcs.dealornodeal;

import java.util.ArrayList;
import java.util.Hashtable;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;


public class DealOrNoDealDailogBox {
	
	private Context context;
	private String title;
	private String message;
	public static boolean result = false;
	BankerOffer bo = new BankerOffer();
	ToastImage toastImage = new ToastImage();
	Hashtable<Integer, Integer> numberAmounts = new Hashtable<Integer,Integer>(){{
	    put(0, 100);
	    put(1, 250);
	    put(2, 500);
	    put(3, 750);
	    put(4, 1000);
	    put(5, 2500);
	    put(6, 5000);
	    put(7, 7500);
	    put(8, 10000);
	    put(9, 25000);
	    put(10, 50000);
	    put(11, 75000);
	    put(12, 100000);
	    put(13, 250000);
	    put(14, 500000);
	    put(15, 750000);
	    put(16, 1000000);
	    
	}};
	
	DealOrNoDealDailogBox(Context context, String title, String message){
		
		this.context = context;
		this.title = title;
		this.message = message;
	}
	DealOrNoDealDailogBox(Context context){
		
		this.context = context;
		this.title = "";
		this.message = "";
	}
	
	public void showDailog(){
	
	
	
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			context);

		// set title
		alertDialogBuilder.setTitle(title);

		// set dialog message
		alertDialogBuilder
			.setMessage(message)
			.setCancelable(false)
			.setPositiveButton("Deal",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					//MainActivity.this.finish();
					
					result = true;
					Log.i("positive" , "we are in positive" );
					dialog.cancel();
					
					
				}
			  })
			.setNegativeButton("NoDeal",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					result = false;
					Log.i("negative" , "we are in negative" );
					dialog.cancel();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();			
			
}
	public void selectedDailog(Integer shuffeled, final TableRow tableRow, final ImageView view, final Integer selected,
			final ImageAdapter IA, final Integer counter){
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		// Get the layout inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		View dailogView = inflater.inflate(R.layout.dailogbox_layout, null);
		//tableRow.removeView(view);
		ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
   		image.setImageResource(IA.mDollerIds[shuffeled]);  
   		
   		alertDialogBuilder.setTitle("The Box Contains");
		// Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    alertDialogBuilder.setView(dailogView)
			// set title
			

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
						if(counter == 5 || counter == 9 || counter == 12 || counter == 14){
		            		//Offer = bo.getOffer(cancledShufflenumbers);
		            		showDailog(tableRow, view, selected,IA);
		            		//Log.i("Result", Boolean.toString(dailogbox.result));
		            		
		            	}
						dialog.cancel();
					}
				});
	    		
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				
				
	}
	
	
	public void selectedDailog(Integer shuffeled, final TableRow tableRow, final ImageView view, final Integer selected, final Integer counter, 
			final ImageAdapter IA, final DollarImageAdapter DIA, final Hashtable clickedImageValuesHashTable, final ArrayList<Integer> cancledShufflenumbers, final Hashtable ht,final View toastLayout) {

		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		// Get the layout inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		View dailogView = inflater.inflate(R.layout.dailogbox_layout, null);
		//tableRow.removeView(view);
		ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
   		image.setImageResource(IA.mDollerIds[shuffeled]);  
   		
   		alertDialogBuilder.setTitle("The Box Contains");
		// Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    alertDialogBuilder.setView(dailogView)
			// set title
			

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
						if(counter == 15){
		            		//Offer = bo.getOffer(cancledShufflenumbers);
							showDailog(tableRow, view, selected, counter, IA, DIA, clickedImageValuesHashTable, cancledShufflenumbers,ht,toastLayout);
		            		//showDailog(tableRow, view, selected,IA);
		            		//Log.i("Result", Boolean.toString(dailogbox.result));
		            		
		            	}
						dialog.cancel();
					}
				});
	    		
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				
				
	}

	public void showDailog(final TableRow tableRow, final ImageView view, final Integer selected,
			final ImageAdapter IA) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		View dailogView = inflater.inflate(R.layout.dailogbox_text_layout, null);
		//tableRow.removeView(view);
		//ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
		TextView textview = (TextView) dailogView.findViewById(R.id.textView1);
		textview.setText("$  "+ message);
		//textview.setTextSize(50.0f);
		  textview.setTextColor(Color.parseColor("#590808"));		
   		//image.setImageResource(IA.mDollerIds[shuffeled]);   	
		// Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	   // alertDialogBuilder
			// set title
			alertDialogBuilder.setTitle(title);
			//alertDialogBuilder.setIcon(R.drawable.bg2);
			
			// set dialog message
			alertDialogBuilder	
				.setView(dailogView)
				//.setMessage(message)				
				.setCancelable(false)
				.setPositiveButton("Deal",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						//MainActivity.this.finish();
						
						result = true;
						Log.i("positive" , "we are in positive" );
						tableRow.removeView(view);
			        	Log.i("TableRow ", "TableRow View is removed" );
			        	android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
			        	Log.i("layoutParams ", "layoutParams initiated" );
			        	//view.getLayoutParams().height = 100;
			        	//view.getLayoutParams().width = 100;
			        	int width = 90;
			        	int height = 90;
			        	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
			        	Log.i("layoutParams ", "layoutParams width and height" );
			        	view.setLayoutParams(parms);
			        	Log.i("View ", "layoutParams" );
			        	//cancledShufflenumbers.add(shuffeled);
			        	view.setImageResource(IA.mDollerIds[selected]);
			        	Log.i("View ", "image added" );
			        	//view.getLayoutParams().height = 120;
			        	//view.getLayoutParams().width = 120;
			        	Log.i("ImageView ", "Image is set to view" );
			        	tableRow.addView(view);
			        	Log.i("before end2", "before end2");
						dialog.cancel();
						Log.i("end2", "end2");
						Integer myBriefcaseAmount = numberAmounts.get(selected);
		                message = message + " and Briefcase have $ " + myBriefcaseAmount.toString();
		                showDailogReloadExit();
					}
				  })
				.setNegativeButton("NoDeal",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						result = false;
						Log.i("negative" , "we are in negative" );
						dialog.cancel();
					}
				});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
		
	}
	public void showDailog(final TableRow tableRow, final ImageView view, final Integer selected, final Integer counter, 
			final ImageAdapter IA, final DollarImageAdapter DIA, final Hashtable clickedImageValuesHashTable, final ArrayList<Integer> cancledShufflenumbers, final Hashtable ht,final View toastLayout) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
			LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			View dailogView = inflater.inflate(R.layout.dailogbox_text_layout, null);
			//tableRow.removeView(view);
			//ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
			TextView textview = (TextView) dailogView.findViewById(R.id.textView1);
			textview.setText("$  "+ message);
			//textview.setTextSize(50.0f);
			textview.setTextColor(Color.parseColor("#590808"));		
   		//image.setImageResource(IA.mDollerIds[shuffeled]);   	
	
			// set title
			alertDialogBuilder.setTitle(title);
			
			// set dialog message
			alertDialogBuilder	
				.setView(dailogView)
				//.setMessage(message)				
				.setCancelable(false)
				.setPositiveButton("Deal",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						//MainActivity.this.finish();
						
						result = true;
						Log.i("positive" , "we are in positive" );
						tableRow.removeView(view);
			        	Log.i("TableRow ", "TableRow View is removed" );
			        	android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
			        	Log.i("layoutParams ", "layoutParams initiated" );
			        	//view.getLayoutParams().height = 100;
			        	//view.getLayoutParams().width = 100;
			        	int width = 90;
			        	int height = 90;
			        	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
			        	Log.i("layoutParams ", "layoutParams width and height" );
			        	view.setLayoutParams(parms);
			        	Log.i("View ", "layoutParams" );
			        	//cancledShufflenumbers.add(shuffeled);
			        	view.setImageResource(IA.mDollerIds[selected]);
			        	Log.i("View ", "image added" );
			        	//view.getLayoutParams().height = 120;
			        	//view.getLayoutParams().width = 120;
			        	Log.i("ImageView ", "Image is set to view" );
			        	tableRow.addView(view);
			        	Log.i("before end2", "before end2");
						dialog.cancel();
						Log.i("end2", "end2");
						Integer myBriefcaseAmount = numberAmounts.get(selected);
		                message = message + " and Briefcase have $ " + myBriefcaseAmount.toString();
		              	showDailogReloadExit();
					}
				  })
				.setNegativeButton("NoDeal",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						result = false;
						Log.i("negative" , "we are in negative" );
						if (counter == 15){
							Integer firstBox =  (Integer) clickedImageValuesHashTable.get(0);
			        		//int  = Integer.parseInt(first);
			        		firstBox = firstBox + 1;
			        		int leftOutBox = 0;
			        		
			        		for(int i=0; i <= 16; i++){
			        			if((clickedImageValuesHashTable.containsValue(i)) ){
			        			Integer temp = (Integer) clickedImageValuesHashTable.get(i);
			        			//System.out.println("lastOutBox " + temp);
			        			}
			        			if((!clickedImageValuesHashTable.containsValue(i)) ){
			        			leftOutBox = i;	
			        			leftOutBox = leftOutBox + 1;
			        			}
			        		}
			            	Log.i("Counter 16", "Counter 16"); 
			            	String Offer = bo.getOffer(cancledShufflenumbers);
			            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
			            	dailogbox.finalBoxChangeDailog(tableRow, view, firstBox, leftOutBox, IA, DIA, ht, toastLayout);
			            
						}
						dialog.cancel();
					}
				});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
		
	}

	public void showDailogReloadExit(){
		
		
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		
		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			View dailogView = inflater.inflate(R.layout.dailogbox_text_layout, null);
			//tableRow.removeView(view);
			//ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
			TextView textview = (TextView) dailogView.findViewById(R.id.textView1);
			textview.setText("You Win $ " + message);
			textview.setTextSize(30.0f);
			textview.setTextColor(Color.parseColor("#590808"));	
		
			// set title
			alertDialogBuilder.setTitle("Game Over" );

			// set dialog message
			alertDialogBuilder
				.setView(dailogView)
				//.setMessage("You Win $" + message)
				.setCancelable(false)
				.setPositiveButton("New Game",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						Intent i = context.getApplicationContext().getPackageManager()
						 .getLaunchIntentForPackage(context.getApplicationContext().getPackageName() );
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
						context.startActivity(i);		
					}
				  })
				.setNegativeButton("Exit Game",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
						//finish();
			            System.exit(0);
						
					}
				});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				
	}
	public void finalBoxChangeDailog(final TableRow tableRow, final ImageView view,  final int firstBox, final int leftOutBox, final ImageAdapter IA, final DollarImageAdapter DIA, final Hashtable ht, final View toastLayout){
				
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			View dailogView = inflater.inflate(R.layout.dailogbox_text_layout, null);
			//tableRow.removeView(view);
			//ImageView image = (ImageView) dailogView.findViewById(R.id.image_selectedbox);
			TextView textview = (TextView) dailogView.findViewById(R.id.textView1);
			textview.setText("Exchange your briefcase " + firstBox+ " with " + leftOutBox);
			textview.setTextSize(30.0f);
			textview.setTextColor(Color.parseColor("#590808"));	
			// set title
			alertDialogBuilder.setTitle("Exchange Briefcase" );
			
			// set dialog message
			alertDialogBuilder
				.setView(dailogView)
				//.setMessage("Change your BOX " + firstBox+ " with " + leftOutBox)
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity	
						tableRow.removeView(view);
			        	Log.i("TableRow ", "TableRow View is removed" );
			        	android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
			        	Log.i("layoutParams ", "layoutParams initiated" );
			        	//view.getLayoutParams().height = 100;
			        	//view.getLayoutParams().width = 100;
			        	int width = 90;
			        	int height = 90;
			        	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
			        	Log.i("layoutParams ", "layoutParams width and height" );
			        	view.setLayoutParams(parms);
			        	Log.i("View ", "layoutParams" );
			        	//cancledShufflenumbers.add(shuffeled);
			        	final int fb = firstBox - 1;
			        	view.setImageResource(IA.mDollerIds[(Integer)ht.get(firstBox-1)]);
			        	Log.i("View ", "image added" );
			        	//view.getLayoutParams().height = 120;
			        	//view.getLayoutParams().width = 120;
			        	Log.i("ImageView ", "Image is set to view" );
			        	tableRow.addView(view);
			        	Log.i("before end2", "before end2");
			        	IA.mThumbIds[firstBox-1] = IA.mDollerIds[(Integer)ht.get(firstBox-1)];
			        	DIA.mDollerIds[(Integer)ht.get(firstBox-1)] = DIA.mCanclledDollerIds[(Integer)ht.get(firstBox-1)];
			        	IA.mThumbIds[leftOutBox-1] = IA.mDollerIds[(Integer)ht.get(leftOutBox-1)];
			        	DIA.mDollerIds[(Integer)ht.get(leftOutBox-1)] = DIA.mCanclledDollerIds[(Integer)ht.get(leftOutBox-1)];
			        	//toastImage.toastImageWin(IA, toastLayout, (Integer)ht.get(leftOutBox-1), context);
			        	IA.notifyDataSetChanged();
			            DIA.notifyDataSetChanged();
		                Integer LeftOutBoxAmount = numberAmounts.get((Integer)ht.get(leftOutBox-1));
		                Integer firstBoxAmount = numberAmounts.get((Integer)ht.get(firstBox-1));
		                message = LeftOutBoxAmount.toString() + " and Briefcase have $ " + firstBoxAmount.toString();
		                dialog.cancel();
						showDailogReloadExit();
					
							
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						tableRow.removeView(view);
			        	Log.i("TableRow ", "TableRow View is removed" );
			        	android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
			        	Log.i("layoutParams ", "layoutParams initiated" );
			        	//view.getLayoutParams().height = 100;
			        	//view.getLayoutParams().width = 100;
			        	int width = 90;
			        	int height = 90;
			        	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
			        	Log.i("layoutParams ", "layoutParams width and height" );
			        	view.setLayoutParams(parms);
			        	Log.i("View ", "layoutParams" );
			        	//cancledShufflenumbers.add(shuffeled);
			        	final int fb = firstBox - 1;
			        	view.setImageResource(IA.mDollerIds[(Integer)ht.get(firstBox-1)]);
			        	Log.i("View ", "image added" );
			        	//view.getLayoutParams().height = 120;
			        	//view.getLayoutParams().width = 120;
			        	Log.i("ImageView ", "Image is set to view" );
			        	tableRow.addView(view);
			        	Log.i("before end2", "before end2");
			        	IA.mThumbIds[firstBox-1] = IA.mDollerIds[(Integer)ht.get(firstBox-1)];
			        	DIA.mDollerIds[(Integer)ht.get(firstBox-1)] = DIA.mCanclledDollerIds[(Integer)ht.get(firstBox-1)];
			        	IA.mThumbIds[leftOutBox-1] = IA.mDollerIds[(Integer)ht.get(leftOutBox-1)];
			        	DIA.mDollerIds[(Integer)ht.get(leftOutBox-1)] = DIA.mCanclledDollerIds[(Integer)ht.get(leftOutBox-1)];
			        	//selectedDailog((Integer)ht.get(firstBox-1),tableRow, view, IA);
			        	//toastImage.toastImageWin(IA, toastLayout, (Integer)ht.get(firstBox-1), context);
			        	IA.notifyDataSetChanged();
			            DIA.notifyDataSetChanged();
						Integer firstBoxAmount = numberAmounts.get((Integer)ht.get(firstBox-1));
						Integer LeftOutBoxAmount = numberAmounts.get((Integer)ht.get(leftOutBox-1));		                
		                message = firstBoxAmount.toString()+ " and Briefcase have $ " + LeftOutBoxAmount.toString();
		                dialog.cancel();
						showDailogReloadExit();
					}
				});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				
	}
	
}
