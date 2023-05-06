package com.example.userapp;

import static android.Manifest.permission.RECORD_AUDIO;

import static com.example.userapp.Functions.wishMe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.media.MicrophoneInfo;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;

import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


public class ChassisActivity extends AppCompatActivity {

    private ImageButton close;
    private SpeechRecognizer recognizer;
    TextToSpeech tts;
    TextView tv,bot,user;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chasis);

        bot = findViewById(R.id.botText);
        user = findViewById(R.id.userText);
        findViewById();
        initializeResult();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChassisActivity.this, HomePage.class);
                startActivity(i);
                finish();
            }
        });

        initializeTextToSpeech();
    }

    private void initializeTextToSpeech() {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (tts.getEngines().size() == 0) {
                    Toast.makeText(ChassisActivity.this, "Engine not available", Toast.LENGTH_SHORT).show();
                } else {
                    speak(wishMe() + "Hey, I am Chatbot assistant ... How may I help you?");
                }
            }
        });
    }

    private void speak(String msg) {
        tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    private void initializeResult() {
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            recognizer = SpeechRecognizer.createSpeechRecognizer(this);
            recognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle bundle) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float v) {

                }

                @Override
                public void onBufferReceived(byte[] bytes) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int i) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    ArrayList<String> res = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    Toast.makeText(ChassisActivity.this, "" + res.get(0), Toast.LENGTH_SHORT).show();
                    tv.setText(res.get(0));
                    response(res.get(0));
                }

                @Override
                public void onPartialResults(Bundle bundle) {

                }

                @Override
                public void onEvent(int i, Bundle bundle) {

                }
            });
        }
    }

    private void response(String msg) {



        String msgs = msg.toLowerCase();
        if (msgs.indexOf("hi") != -1 || msgs.indexOf("hello") != -1) {
            speak("Hello, I am Chatbot assistant! How may I help you today?");
            user.setText(msgs); bot.setText("Hello, I am Chatbot assistant! How may I help you today?");
        } else if (msgs.indexOf("how are you") != -1) {
            speak("I am all good what about you?");
            user.setText(msgs); bot.setText("I am all good what about you?");
        } else if (msgs.indexOf("") != -1) {
            user.setText(msgs); bot.setText("");
            speak("");
        } else if (msgs.indexOf("") != -1) {
            speak("");
        } else if (msgs.indexOf("") != -1) {
            speak("");
        }

        else if (msgs.indexOf("Where is the registrar office") != -1) {
            speak("Go through the gate no.1 and take the 1 left towards the Electronics department There u can get all the offices. Can I help you further");
            user.setText(msgs); bot.setText("Go through the gate no.1 and take the 1 left towards the Electronics department There u can get all the offices. Can I help you further");
        } else if (msgs.indexOf("how are you") != -1) {
            user.setText(msgs); bot.setText("");
            speak("");
        } else if (msgs.indexOf("") != -1) {
            speak("");
        } else if (msgs.indexOf("") != -1) {
            speak("");
        }
else{
            speak("Sorry I don't know about that?");
        }
        if (msg.indexOf("Registrar") != -1) {
            if (msg.indexOf("office") != -1) {
                speak("Go through the gate no.1 and take the 1 left towards the Electronics department There u can get all the offices. Can I help you further");
                user.setText(msgs); bot.setText("Go through the gate no.1 and take the 1 left towards the Electronics department There u can get all the offices. Can I help you further");
            }
        }
        if (msg.indexOf("time") != -1) {
            if (msg.indexOf("now") != -1) {
                Date date = new Date();
                String time = DateUtils.formatDateTime(this, date.getTime(), DateUtils.FORMAT_SHOW_TIME);
                speak("Its " + time);
            }
        }

        if (msg.indexOf("date") != -1) {
            if (msg.indexOf("today") != -1) {
            Date date = new Date();
            String time = DateUtils.formatDateTime(this, date.getDate(), DateUtils.FORMAT_SHOW_DATE);
            speak("Its " + time);
        }
    }

    }


    //
    private void findViewById() {
        tv = (TextView) findViewById(R.id.tvResult);
        close = findViewById(R.id.closeBtn);
    }

    public void startRecording(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        recognizer.startListening(intent);
    }
}