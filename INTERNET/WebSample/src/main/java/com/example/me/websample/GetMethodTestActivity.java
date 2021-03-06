package com.example.me.websample;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetMethodTestActivity extends Activity {
	private EditText edtName,edtPassword;	
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getmethodtest);
		edtName=(EditText)findViewById(R.id.editText1);	
		edtPassword=(EditText)findViewById(R.id.editText2);			
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  ConnectivityManager connMgr = (ConnectivityManager) 
				            getSystemService(Context.CONNECTIVITY_SERVICE);
				        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				        if (networkInfo != null && networkInfo.isConnected()) {
				        	String path="aa";
				            new DownloadWebTask().execute(path,edtName.getText().toString(),edtPassword.getText().toString());
				        } else {
				        	Toast.makeText(getApplicationContext(), "No network connection available", Toast.LENGTH_SHORT).show();
				        }
			}			
		});
	}

	private Boolean login(String path,String name,String password){
		try{
			
			return InternetTools.getMethosTest(path, name, password);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return  Boolean.valueOf(false);
	}
	
	
	 private class DownloadWebTask extends AsyncTask<String, Void, Boolean> {
	        @Override
	        protected Boolean doInBackground(String... urls) {
	              
	            // params comes from the execute() call: params[0] is the url.
	         
	            	return login(urls[0],urls[1],urls[2]);
	           
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(Boolean result) {
	           if(result){
	        	 Toast.makeText(getApplicationContext(), "get succeed", Toast.LENGTH_SHORT).show();
	            }else{
	            	Toast.makeText(getApplicationContext(), "get fail", Toast.LENGTH_SHORT).show();
	            }
	        	
	       }
	    }



}
