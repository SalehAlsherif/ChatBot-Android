package com.example.yomna.symptomate;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private TextView startText;
    private TextView textView;
    Context mContext=this;
    String text="saleh";
    String  Authorization="";
    String Recieved="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface helv = Typeface.createFromAsset(getAssets(),"fonts/Helvetica.ttf");
        startText = (TextView) findViewById(R.id.startText);
        Log.d("d","aifaojdsjodafm");
        textView = findViewById(R.id.textView);
        textView.setText("a7he");
        Button SendChat = (Button) findViewById(R.id.button);
        SendChat.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                JSONObject jsn=new JSONObject();
                try {
                    jsn.put("message",text);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new Chat(mContext).execute(Authorization,jsn.toString());
            }
        });
        Button Begin = (Button) findViewById(R.id.button2);
        Begin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new Welcome(mContext).execute();
            }
        });

    }
    //Recives the server First response along with the UUID for authization
    public void ServerWelcome(JSONObject res){
        try {
            Recieved=(res.getString("message"));
            Authorization=res.getString("uuid");
            textView.setText(Recieved);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  //  this method recieves the server response
    public void ServerChat(JSONObject res){
        try {
            Recieved=res.getString("message");
            textView.setText(Recieved);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
