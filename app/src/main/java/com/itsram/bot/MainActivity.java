package com.itsram.bot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.provider.Telephony;
import android.speech.RecognizerIntent;
import android.view.View;

import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   private ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=findViewById(R.id.goSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              viceAutomation();


            }
        });



    }

    private void viceAutomation()
    {

        Intent voice=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        voice.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());

        voice.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Now...");
        startActivityForResult(voice,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {

            ArrayList<String>arrayList=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            String str=arrayList.get(0).toString();
            switch (str)
            {
                case "open Gmail":
                    Intent intentGmail=getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                    if (intentGmail!=null) {
                        startActivity(intentGmail);
                    }
                    break;

                case "open Facebook":
                    Intent intentFacebook=getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                    if (intentFacebook!=null) {
                        startActivity(intentFacebook);
                    }
                    break;


                case "open WhatsApp":
                        Intent intentWhatsApp=getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                        if (intentWhatsApp!=null) {
                            startActivity(intentWhatsApp);
                        }
                        break;

                case "open SMS":
                            Intent intentSms=getPackageManager().getLaunchIntentForPackage(Telephony.Sms.getDefaultSmsPackage(this));
                            if (intentSms!=null) {
                                startActivity(intentSms);
                            }

                            break;

                case "open YouTube":
                    Intent intentYouTube=getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                    if (intentYouTube!=null) {
                        startActivity(intentYouTube);
                    }

                    break;

                case "open Chrome":
                    Intent intentChrome=getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                    if (intentChrome!=null) {
                        startActivity(intentChrome);
                    }
                    break;

                case "open drive":
                    Intent intentDrive=getPackageManager().getLaunchIntentForPackage("com.google.android.apps.docs");
                    if (intentDrive!=null) {
                        startActivity(intentDrive);
                    }
                    break;
                case "open Google Map":
                    Intent intentMap=getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                    if (intentMap!=null) {
                        startActivity(intentMap);
                    }
                    break;

                case "open LinkedIn":
                    Intent intentLinkedIn=getPackageManager().getLaunchIntentForPackage("com.linkedin.android");
                    if (intentLinkedIn!=null) {
                        startActivity(intentLinkedIn);
                    }
                    break;

                default :
                    Toast.makeText(this, "Something went Wrong...", Toast.LENGTH_LONG).show();


            }
        }

    }


}
