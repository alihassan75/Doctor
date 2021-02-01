package com.example.doctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

//callbackManager = CallbackManager.Factory.create();

public class MainActivity<callbackManager> extends AppCompatActivity {
    TextView registernow, tv_forgetpassowrd;
    Button btn_login;
    CheckBox chkRememberMe;
    //    AlertDialog.Builder buildAlertDialog;
    String stEmailAddress, stPassword;
    private GoogleSignInClient mGoogleSignInClient;
    EditText etemailAdress, etpassword;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private LoginButton loginButton;
    private FirebaseAuth.AuthStateListener authStateListener;
    //    boolean clickTwiceToExit = false;
    private SignInButton mSignInButton;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        chkRememberMe = findViewById(R.id.chkRememberMe);
        etemailAdress = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        registernow = findViewById(R.id.tv_Registernow);
        loginButton = (LoginButton) findViewById(R.id.login_button);
//        callbackManager = CallbackManager.Factory.create();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        // Callback registration
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email");
        LoginManager.getInstance().registerCallback((CallbackManager) callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Intent intent = new Intent(getApplicationContext(), List_of_Medical_Specialties.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
        btn_login = findViewById(R.id.btn_login);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    Intent intent = new Intent(getApplicationContext(), List_of_Medical_Specialties.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        mSignInButton = (SignInButton) findViewById(R.id.sign_in);

        // Set click listeners
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
//        FacebookCallback<LoginResult> mFacebookCallback = new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                AccessToken accessToken = loginResult.getAccessToken();
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//
//            }
//        };


        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        tv_forgetpassowrd = findViewById(R.id.tv_forgepassword);
        registernow.setPaintFlags(registernow.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv_forgetpassowrd.setPaintFlags(tv_forgetpassowrd.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    Intent intent = new Intent(MainActivity.this, List_of_Medical_Specialties.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stEmailAddress = etemailAdress.getText().toString().trim();
                stPassword = etpassword.getText().toString().trim();
                if (stEmailAddress.isEmpty() && stPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "من فضلك ادخل الاميل والباسورد", Toast.LENGTH_SHORT).show();
                }
                if (stEmailAddress.isEmpty() && !stPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "من فضلك ادخل الاميل ", Toast.LENGTH_SHORT).show();
                }
                if (!stEmailAddress.isEmpty() && stPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "من فضلك ادخل الباسورد ", Toast.LENGTH_SHORT).show();
                }
                if (!stEmailAddress.isEmpty() && !stPassword.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(stEmailAddress, stPassword).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()) {
//                                  currentUser = task.getResult().getUser();
                                Intent intent = new Intent(MainActivity.this, List_of_Medical_Specialties.class);
                                startActivity(intent);
                            }
                        }
                    });
                }

            }
        });

//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


//        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegister = new Intent(getApplicationContext(), Register.class);
                startActivity(gotoRegister);
            }
        });
        tv_forgetpassowrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(intent);
            }
        });
        SharedPreferences rememberMeFile = getSharedPreferences("rememberMeFile", 0);
        if (rememberMeFile.getBoolean("bool", true)) {
            String Email = rememberMeFile.getString("Username", "");
            etemailAdress.setText(Email);
            String Password = rememberMeFile.getString("Password", "");
            etpassword.setText(Password);
            chkRememberMe.setChecked(true);
        }

    }

    @Override
    protected void onStart() {
        mAuth.addAuthStateListener(authStateListener);
        super.onStart();
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 9001);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent in signIn()
        if (requestCode == RC_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this, List_of_Medical_Specialties.class));
                            finish();
                        }
                    }
                });
    }

    public void rememberMe(View view) {
        // Creating the Xml SharedPreferences File
        SharedPreferences rememberMeFile = getSharedPreferences("rememberMeFile", 0);
        // Creating the pen to edit inside the rememberMe file
        SharedPreferences.Editor pen = rememberMeFile.edit();
        // Adding String Value to the rememberMe
        pen.putString("Username", etemailAdress.getText().toString().trim());
        pen.putString("Password", etpassword.getText().toString().trim());
        pen.putBoolean("bool", true);
        pen.apply();
//        chkRememberMe.setChecked(true);
        if (chkRememberMe.isChecked()) {
            Toast.makeText(this, "Data Saved ", Toast.LENGTH_SHORT).show();
        }
    }
//    public void Sign_in(View view) {
//        signIn();
//    }

    @Override
    public void onBackPressed() {
        finish();
        FirebaseAuth auth;
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        super.onBackPressed();
    }
}


