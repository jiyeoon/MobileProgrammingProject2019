package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

}
