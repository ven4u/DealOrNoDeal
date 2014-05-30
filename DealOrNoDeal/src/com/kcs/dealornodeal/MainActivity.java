package com.kcs.dealornodeal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final Context context = this;
	GridView gridView;
	GridView dollargridView;
	// To have count of clicks made on image
	int counter= 0;
	Hashtable clickedImageValuesHashTable = new Hashtable();
	public static int briefcaseLeft = 0; 
	//BankerOffer class 
	BankerOffer bo = new BankerOffer();
	
	//Randam number generation variables
	Integer shuffeled;
	Integer selected;
	Hashtable ht = new  Hashtable();
	Enumeration key;
	ArrayList<Integer> number = new ArrayList<Integer>();
	//ArrayList<Integer> shuffledcards = new ArrayList<Integer>();
	ArrayList<Integer> cancledShufflenumbers = new ArrayList<Integer>();
	ToastImage toastImage = new ToastImage();
 	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ImageView view = new ImageView(this);	
		Log.i("ImageView", "ImageView Initialised " );
		final TableRow tableRow = (TableRow) findViewById(R.id.tableRow2);
		//TableRow.LayoutParams tableRowPrams = new TableRow.LayoutParams(
	    //TableRow.LayoutParams.WRAP_CONTENT,
	    //TableRow.LayoutParams.WRAP_CONTENT);
		Log.i("TableRow", "TableRow Initialised" );
		//Add Breifcase with question mark 
		
		
		/* TableLayout TableLayout2 = (TableLayout) findViewById(R.id.TableLayout2);
		
		TableLayout.LayoutParams lprams = new TableLayout.LayoutParams(
	    TableLayout.LayoutParams.WRAP_CONTENT,
	    TableLayout.LayoutParams.WRAP_CONTENT);
		/* toast */
		LayoutInflater inflater = getLayoutInflater();
		final View toastLayout = inflater.inflate(R.layout.toast_layout,
		                           (ViewGroup) findViewById(R.id.toast_layout_root));
		
		
			/*for(int i=0;i<5;i++) {
		    Button btn = new Button(this);
		    btn.setId(i+1);
		    btn.setText("Button"+(i+1));
		    btn.setLayoutParams(lprams);
		    final int index = i;
		    btn.setOnClickListener(new OnClickListener() {
		        public void onClick(View v) {
		            Log.i("TAG", "The index is" + index);
		        }
		    });
		   
		    
		    TableLayout2.addView(btn);*/
		
		//Randam number generation in hashtable ht
		
		for(int i=0;i<17;i++)
		{
		    number.add(i);
		}
		Collections.shuffle(number);
		for(int i=0; i<17;i++){
			ht.put(i,number.get(i));
		}
		key = ht.keys();
		while(key.hasMoreElements()) {
	         //str = (String) names.nextElement();
			Integer i = (Integer) key.nextElement();
	         System.out.println(i + ";" + ht.get(i));
	      }
		
		    
		gridView = (GridView) findViewById(R.id.gridView1);
    
		// GridView gridview = (GridView) findViewById(R.id.gridview);
		final ImageAdapter IA = new ImageAdapter(this);
		gridView.setAdapter(IA);
		// Initialise  Doller Image Grid 
		dollargridView = (GridView) findViewById(R.id.gridView2);
    
	   // GridView gridview = (GridView) findViewById(R.id.gridview);
		final DollarImageAdapter DIA = new DollarImageAdapter(this);
	    dollargridView.setAdapter(DIA);
	    // Welcome image toast
	    //toastImage.toastImageStart(IA,toastLayout,context);
	    
	    //add question marked breifcase
	    android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    	Log.i("layoutParams ", "layoutParams initiated" );
    	int width = 70;
    	int height = 70;
    	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
    	view.setLayoutParams(parms);
    	Log.i("View ", "layoutParams" );
    	view.setImageResource(IA.questionMarkBreifcase);
    	Log.i("View ", "image added" );
    	//view.getLayoutParams().height = 100;
    	//view.getLayoutParams().width = 100;
    	Log.i("ImageView ", "Image is set to view" );
    	tableRow.addView(view);
    

    gridView.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        	
        	if (!clickedImageValuesHashTable.contains(position)){
        	if(counter == 0){
	        	tableRow.removeView(view);
	        	Log.i("TableRow ", "TableRow View is removed" );
	        	android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
	        	Log.i("layoutParams ", "layoutParams initiated" );
	        	//view.getLayoutParams().height = 100;
	        	//view.getLayoutParams().width = 100;
	        	int width = 70;
	        	int height = 70;
	        	TableRow.LayoutParams parms = new TableRow.LayoutParams(width,height);
	        	Log.i("layoutParams ", "layoutParams width and height" );
	        	view.setLayoutParams(parms);
	        	Log.i("View ", "layoutParams" );
	        	shuffeled = (Integer)ht.get(position);
	        	selected = shuffeled;
	        	//cancledShufflenumbers.add(shuffeled);
	        	view.setImageResource(IA.mThumbIds[position]);
	        	Log.i("View ", "image added" );
	        	//view.getLayoutParams().height = 120;
	        	//view.getLayoutParams().width = 120;
	        	Log.i("ImageView ", "Image is set to view" );
	        	tableRow.addView(view);
	        	Log.i("TableRow", "view is added to table row" );
	        	//tableLayout.addView(tableRow);
	        	//Log.i("TableLayout", "TableRow  is added to TableLayout" );
	        	if(counter == 0)
	        		briefcaseLeft=5;
	        	String message = "Select " + briefcaseLeft + " more briefcase";
	        	toastImage.toastBriefcaseLeft(context, message, toastLayout );
	        	
        	}
        	else if (counter >0 && counter < 6)
        	{
        		String Offer = "";        		
        		shuffeled = (Integer)ht.get(position);
        		cancledShufflenumbers.add(shuffeled);
        		IA.mThumbIds[position] = IA.empty;
            	DIA.mDollerIds[shuffeled] = DIA.mCanclledDollerIds[shuffeled];
            	if(counter == 5){
            		Offer = bo.getOffer(cancledShufflenumbers);
            		//DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		//dailogbox.showDailog(tableRow, view, selected,IA);
            		//Log.i("Result", Boolean.toString(dailogbox.result));
            		
            	}
            	//SelectedDailogBox sdb = new SelectedDailogBox(context);
            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
        		//DealOrNoDealDailogBox sdb = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);        		
            	dailogbox.selectedDailog(shuffeled,tableRow, view, selected,IA,counter);
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if (briefcaseLeft != 1){
            	--briefcaseLeft;
            	String message = "Select " + briefcaseLeft + " more briefcase";
	        	toastImage.toastBriefcaseLeft(context, message, toastLayout ); 
    			}else{
    				briefcaseLeft = 4;
    			}
        	}
        	else if(counter >5 && counter < 10){
        		String Offer = "";    
        		shuffeled = (Integer)ht.get(position);
        		cancledShufflenumbers.add(shuffeled);
        		IA.mThumbIds[position] = IA.empty;
            	DIA.mDollerIds[shuffeled] = DIA.mCanclledDollerIds[shuffeled];
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if(counter == 9){
            		Offer = bo.getOffer(cancledShufflenumbers);
            		//DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		//dailogbox.showDailog(tableRow, view, selected,IA);
            		//Log.i("Result", Boolean.toString(dailogbox.result));            		
            	}
            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            	dailogbox.selectedDailog(shuffeled,tableRow, view, selected,IA,counter);  
            	if (briefcaseLeft != 1){
                	--briefcaseLeft;
                	String message = "Select " + briefcaseLeft + " more briefcase";
    	        	toastImage.toastBriefcaseLeft(context, message, toastLayout ); 
        			}else{
        				briefcaseLeft = 3;
        			}
        		
        	}else if(counter >9 && counter < 13){
        		String Offer = "";    
        		shuffeled = (Integer)ht.get(position);
        		cancledShufflenumbers.add(shuffeled);
        		IA.mThumbIds[position] = IA.empty;
            	DIA.mDollerIds[shuffeled] = DIA.mCanclledDollerIds[shuffeled];
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if(counter == 12){
            		Offer = bo.getOffer(cancledShufflenumbers);
            		//DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		//dailogbox.showDailog(tableRow, view, selected,IA);
            		//Log.i("Result", Boolean.toString(dailogbox.result));            		
            	}
            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            	dailogbox.selectedDailog(shuffeled,tableRow, view, selected,IA,counter);
            	if (briefcaseLeft != 1){
                	--briefcaseLeft;
                	String message = "Select " + briefcaseLeft + " more briefcase";
    	        	toastImage.toastBriefcaseLeft(context, message, toastLayout ); 
        			}else{
        				briefcaseLeft = 2;
        			}
        		
        		
        	}else if(counter >12 && counter < 15){
        		String Offer = "";  
        		shuffeled = (Integer)ht.get(position);
        		cancledShufflenumbers.add(shuffeled);
        		IA.mThumbIds[position] = IA.empty;
            	DIA.mDollerIds[shuffeled] = DIA.mCanclledDollerIds[shuffeled];
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if(counter == 14){
            		Offer = bo.getOffer(cancledShufflenumbers);
            		//DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		//dailogbox.showDailog(tableRow, view, selected,IA);
            		//Log.i("Result", Boolean.toString(dailogbox.result));            		
            	}
            	//SelectedDailogBox sdb = new SelectedDailogBox(context);
            	//SelectedDailogBox sdb = new SelectedDailogBox(context);
            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            	//DealOrNoDealDailogBox sdb = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);        		
            	dailogbox.selectedDailog(shuffeled,tableRow, view, selected,IA,counter);
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if (briefcaseLeft != 1){
                	--briefcaseLeft;
                	String message = "Select " + briefcaseLeft + " more briefcase";
    	        	toastImage.toastBriefcaseLeft(context, message, toastLayout ); 
        			}else{
        				briefcaseLeft = 1;
        			}

        		
        	}else if(counter >14 && counter < 16){
        		String Offer = "";  
        		shuffeled = (Integer)ht.get(position);
        		cancledShufflenumbers.add(shuffeled);
        		IA.mThumbIds[position] = IA.empty;
            	DIA.mDollerIds[shuffeled] = DIA.mCanclledDollerIds[shuffeled];
            	//toastImage.toastImage(IA,toastLayout,shuffeled,context);
            	if(counter == 15){
            		Offer = bo.getOffer(cancledShufflenumbers);
            		//DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		//dailogbox.showDailog(tableRow, view, selected,IA);
            		//Log.i("Result", Boolean.toString(dailogbox.result));
            		
            	}
            	//SelectedDailogBox sdb = new SelectedDailogBox(context);
            	DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            	//DealOrNoDealDailogBox sdb = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);        		
            	dailogbox.selectedDailog(shuffeled, tableRow, view, selected, counter, IA, DIA, clickedImageValuesHashTable, cancledShufflenumbers,ht,toastLayout);
            	
            	/*if(counter == 15){
            		//Log.i("START VEN", "START"); 
            		String Offer = bo.getOffer(cancledShufflenumbers);
            		DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", Offer);
            		//dailogbox.showDailog();
            		dailogbox.showDailog(shuffeled,tableRow, view, selected, counter, IA, DIA, clickedImageValuesHashTable, cancledShufflenumbers,ht,toastLayout);
            		Log.i("Result", Boolean.toString(dailogbox.result));
            		//Log.i("END VEN", "ENDVEN");          		
            		
            	}*/
        		
        	}
        	 // Check if its a deal or no deal
            //DealOrNoDealDailogBox dailogbox = new DealOrNoDealDailogBox(context, "Bankers Offer", "XXXXXXXX");
            //Log.i("Result", Boolean.toString(dailogbox.result));            
        	// Check if its a deal or no deal
        	//IA.mThumbIds[position] = IA.mDollerIds[position];
        	//DIA.mDollerIds[position] = DIA.mCanclledDollerIds[position];
        	//Log.i("IA", "Image is replaced with Dollers image" );
            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            Log.i("position", "position is displayed for the image" );
            IA.notifyDataSetChanged();
            DIA.notifyDataSetChanged();
            Log.i("IA Notified", "Change is refreshed" );
            clickedImageValuesHashTable.put(counter, position );
            counter++;              
            Log.i("counter", Integer.toString(counter));
            Log.i("counter", Integer.toString(position));
            Log.i("shuffeled", Integer.toString(shuffeled));
            Log.i("end1", "end1");
           }
           	            
        }
    });
		    
		    
}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
