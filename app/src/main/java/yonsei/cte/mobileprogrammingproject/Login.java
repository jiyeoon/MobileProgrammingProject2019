package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private EditText mEmailField;
    private EditText mPasswordField;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //start Initialize_auth
        //Initialize firebase auth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Check if user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void createAccount(String email, String password){
        //Log.d(TAG, "createAccount : " + email);
        if(!validatedForm()){
            return;
        }

        //showProgressDialog();

        //[start create user with eamil]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Sign in success!!!!!
                            Log.d(TAG, "createUserwithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //UpdateUI(user);
                        } else{
                            //sign in failed.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                            //UpdateUI(null);
                        }
                    }
                });

    }

    private void signIn(String email, String password){
        Log.d(TAG, "signIn:" + email);
        if(!validatedForm())
            return;

        //start sign_in_with email
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //sign in success
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            System.out.println("Sign In : Success");
                        } else{
                            // sign in failed.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        //start exclude
                        if(!task.isSuccessful()){
                            //mStatusTextView.setText(R.string.auth_failed);
                        }
                    }
                });
    }

    private void signOut(){
        mAuth.signOut();
        //updateUI(null);
    }

    private boolean validatedForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if(TextUtils.isEmpty(email)){
            mEmailField.setError("Required!");
            valid = false;
        }else{
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if(TextUtils.isEmpty(password)){
            mPasswordField.setError("Required!");
            valid = false;
        } else{
            mPasswordField.setError(null);
        }

        return valid;
    }

    public void onSignInClicked(View view) {
        mEmailField = (EditText)findViewById(R.id.edit_email);
        mPasswordField = (EditText)findViewById(R.id.edit_password);

        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        signIn(email, password);
    }

    public void onCreateAccountClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
        startActivity(intent);

    }

    private void updateUI(FirebaseUser user){
        if(user != null){
            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt, user.getEmail(), user.isEmailVerified()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            findViewById(R.id.email_sign_in_button).setVisibility(View.VISIBLE);
        }
        else{
            mStatusTextView.setText(R.string.sign_out);
            mDetailTextView.setText(null);

            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.email_sign_in_button).setVisibility(View.GONE);
        }
    }

}
