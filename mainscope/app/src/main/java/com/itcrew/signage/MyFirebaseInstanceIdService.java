package com.itcrew.signage;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by maxse on 23/06/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    public static final String TAG ="FirebaseIDService";
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "Token: " + token);
        actualizarToken(token);

    }


    private void actualizarToken(String token){
        //aqui se llama al ws para actualizar el push token
    }

}
