package com.example.fadfadly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fadfadly.Base.BaseActivity;
import com.example.fadfadly.Database.daos.UsersDao;
import com.example.fadfadly.Model.DataUtil;
import com.example.fadfadly.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends BaseActivity implements View.OnClickListener, OnFailureListener, OnCompleteListener<AuthResult> {

    protected TextView title;
    protected TextView username;
    protected EditText usernameText;
    protected TextView age;
    protected EditText ageText;
    protected TextView email;
    protected EditText emailText;
    protected TextView password;
    protected EditText passwordText;
    protected Button submit;
    protected RadioGroup group;
    protected RadioButton genderButton;
    private String gender ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_signup);
        initView();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                genderButton = group.findViewById(i);
                switch (i){
                    case R.id.male :
                        gender = genderButton.getText().toString();
                        break;
                    case R.id.female :
                        gender = genderButton.getText().toString();
                        break;
                }
            }
        });
    }
    User user;
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {
            String EmailText=emailText.getText().toString();
            String PasswordText=passwordText.getText().toString();
            String usernameText=username.getText().toString();
            String ageText=age.getText().toString();

            //male, female
            if(usernameText.trim().isEmpty()){
                username.setError("requried");
                return;
            }
            if(ageText.trim().isEmpty()){
                age.setError("requried");
                return;
            }
            if(EmailText.trim().isEmpty()){
                email.setError("requried");
                return;
            }
            if(PasswordText.trim().isEmpty()){
                password.setError("requried");
                return;
            }
            //authontification
            user=new User();
            user.setName(usernameText);
            user.setEmail(EmailText);
            user.setAge(ageText);
            user.setGender(gender);

            // user.setId(DataUtil.user.getUid());
            FirebaseAuth auth=FirebaseAuth.getInstance();
            showProgressDialog(R.string.Loading);
            auth.createUserWithEmailAndPassword(EmailText,PasswordText)
                    .addOnCompleteListener(this)
                    .addOnFailureListener(this);


            //authuntication
        }
    }
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        hideProgressDialog();
        if(task.isSuccessful()){
            DataUtil.user =
                    FirebaseAuth.getInstance().getCurrentUser();
            user.setId(DataUtil.user.getUid());
            UsersDao.addUser(user, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            DataUtil.dbUser=user;
                            hideProgressDialog();
                          //  startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                            finish();

                        }
                    },
                    new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            hideProgressDialog();
                            showMessage(e.getLocalizedMessage(),"ok");

                        }
                    });

        }
    }


    @Override
    public void onFailure(@NonNull Exception e) {
        hideProgressDialog();
        showMessage(e.getLocalizedMessage(),"ok");

    }
    private void initView() {
        title = (TextView) findViewById(R.id.title);
        username = (TextView) findViewById(R.id.username);
        usernameText = (EditText) findViewById(R.id.username_text);
        age = (TextView) findViewById(R.id.age);
        ageText = (EditText) findViewById(R.id.age_text);
        email = (TextView) findViewById(R.id.email);
        emailText = (EditText) findViewById(R.id.email_text);
        password = (TextView) findViewById(R.id.password);
        passwordText = (EditText) findViewById(R.id.password_text);
        group = (RadioGroup) findViewById(R.id.radio_group);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(SignupActivity.this);


    }
    public void onsubmit(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
