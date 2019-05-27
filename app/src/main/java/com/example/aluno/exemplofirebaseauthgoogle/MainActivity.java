package com.example.aluno.exemplofirebaseauthgoogle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private TextView tvPerfil;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        String dados = firebaseUser.getEmail() + "\n" + firebaseUser.getDisplayName() + "\n" + firebaseUser.getProviderData() + "\n" + firebaseUser.getUid() + "\n" + firebaseUser.getPhotoUrl();
        tvPerfil = (TextView) findViewById(R.id.tvPerfil);
        tvPerfil.setText(dados);
    }

    public void signOut(View view) {
        firebaseAuth.signOut();
        finish();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
