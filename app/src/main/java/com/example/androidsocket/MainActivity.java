package com.example.androidsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends ActionBarActivity {
	
	@InjectView(R.id.et_conn)
	EditText et_conn;
	@InjectView(R.id.et_message)
	EditText et_message;
	@InjectView(R.id.tv_content)
	TextView tv_content;
	
	Socket socket = null;
	BufferedWriter bw = null;
	BufferedReader br = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
	}
	
	public void conn(View v){
		
			AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>(){

				@Override
				protected Void doInBackground(Void... params) {
					try {
						socket = new Socket("127.0.0.1", 12345);
						bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					} catch (UnknownHostException e1) {
						Toast.makeText(MainActivity.this, "无法建立连接", Toast.LENGTH_LONG).show();
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String line = null;
					try {
						while((line = br.readLine()) != null){
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
				
				@Override
				protected void onProgressUpdate(String... values) {
					Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_LONG).show();
					tv_content.append(values[0]);
					super.onProgressUpdate(values);
				}
				
			};
			read.execute();
		
	}
	
	public void send(View v){
		try {
			bw.write(et_message.getText().toString());
			et_message.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
