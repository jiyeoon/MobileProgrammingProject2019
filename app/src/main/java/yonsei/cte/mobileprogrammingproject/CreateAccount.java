package yonsei.cte.mobileprogrammingproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CreateAccount extends AppCompatActivity {
    private static final String TAG = "EmailPassword";

    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private EditText mEmailField;
    private EditText mPasswordField;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Check if user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    private void createAccount(String email, String password){
        Log.d(TAG, "createAccount : " + email);
        if(!validatedForm()){
            return;
        }

        //showProgressDialog();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "New User Registration : " + task.isSuccessful());

                        if(!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Authentication is failed.", Toast.LENGTH_SHORT).show();
                        } else{
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                    }
                });

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


    public void onCreateButtonClicked(View view) {
        mEmailField = (EditText)findViewById(R.id.create_email);
        mPasswordField = (EditText)findViewById(R.id.create_password);

        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        createAccount(email, password);
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
