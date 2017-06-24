package com.itcrew.signage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Window;
import android.net.Uri;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Campaign extends AppCompatActivity {
    ProgressDialog pDialog;
    VideoView videoView;
    private String jsonResponse, jsonmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_campaign);

        // Create a progressbar
        pDialog = new ProgressDialog(Campaign.this);
        // Set progressbar message
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        videoView = (VideoView) findViewById(R.id.videoView);

        String url ="http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";
        Uri vidUri = Uri.parse(url);

        videoView.setVideoURI(vidUri);

        videoView.start();

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    Campaign.this);
            mediacontroller.setAnchorView(videoView);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(url);
            videoView.setMediaController(mediacontroller);
            videoView.setVideoURI(video);


        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoView.start();
            }
        });

        /*JSONObject content = new JSONObject();

        //Build Parameter
        try {
            content.put("request_type", "");
            content.put("campana_id", "");
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        final String requestBody = content.toString();

        //Start request to Server
        final JsonObjectRequest jsonrequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Get response
                try
                {
                    Log.i("JSON STATUS", jsonResponse = response.getString("status"));
                    Log.i("JSON ERROR", jsonmessage = response.getString("mensaje"));

                    if(jsonResponse.compareTo("ok") == 0) {
                        Toast.makeText(getApplicationContext(), jsonmessage, Toast.LENGTH_LONG).show();
                        Intent mainIntent = new Intent().setClass(LoginActivity.this, com.itcrew.signage.Campaign.class);
                        startActivity(mainIntent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), jsonmessage, Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        }){
            @Override
            public byte[] getBody() {
                return requestBody.getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("token-app", "0367F1D1-5463-44DD-8CD2-9E1368E207E8_20170426104639");
                params.put("api-key", "bcaf75d0a47bad12faa1272e_3ad024c8ab85f8c1fe91b61c");
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonrequest);*/

    }
}
