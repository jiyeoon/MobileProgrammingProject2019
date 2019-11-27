package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends Activity {

    protected FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private String name, email, photoUrl, uid, emailVerified;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        FirebaseUser user = (FirebaseUser) intent.getSerializableExtra("user");
        currentUser = user;
    }


    @Override
    protected void onStart() {
        super.onStart();

        currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            name = currentUser.getDisplayName();
            email = currentUser.getEmail();
//            photoUrl = currentUser.getPhotoUrl().toString();
            uid = currentUser.getUid();

            //Select Image Views to display image
            CircleImageView image = (CircleImageView) findViewById(R.id.profile_image);
            if(photoUrl != null){
                //Display jpg image from the project resource
 //               Picasso.get().load(photoUrl).into(image);
            }else{
                //유저 없으면 그냥 기본 이미지로 출력하긔
   //             Picasso.get().load(R.drawable.profile);
            }

            TextView nameView = (TextView) findViewById(R.id.profile_name);
            nameView.setText(name);

            TextView emailView = (TextView) findViewById(R.id.profile_email);
            emailView.setText(email);

        } else{
            //유저 없으면..

        }

    }



}
