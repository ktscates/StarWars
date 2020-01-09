package com.example.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

//import static com.example.starwars.Characters.EXTRA_AFFILIATION;
//import static com.example.starwars.Characters.EXTRA_APPRENTICE;
//import static com.example.starwars.Characters.EXTRA_BIRTH_PLACE;
//import static com.example.starwars.Characters.EXTRA_BIRTH_YEAR;
//import static com.example.starwars.Characters.EXTRA_DIED_AGE;
//import static com.example.starwars.Characters.EXTRA_DIED_PLACE;
import static com.example.starwars.Characters.EXTRA_EYE;
import static com.example.starwars.Characters.EXTRA_GENDER;
//import static com.example.starwars.Characters.EXTRA_HAIR;
//import static com.example.starwars.Characters.EXTRA_HOMEWORLD;
import static com.example.starwars.Characters.EXTRA_IMAGE;
//import static com.example.starwars.Characters.EXTRA_MASTER;
import static com.example.starwars.Characters.EXTRA_NAME;
//import static com.example.starwars.Characters.EXTRA_SKIN;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String characterImage = intent.getStringExtra(EXTRA_IMAGE);
        String characterName = intent.getStringExtra(EXTRA_NAME);
        String gender = intent.getStringExtra(EXTRA_GENDER);
//        String homeworld = intent.getStringExtra(EXTRA_HOMEWORLD);
        String eye = intent.getStringExtra(EXTRA_EYE);
//        String hair = intent.getStringExtra(EXTRA_HAIR);
//        String skin = intent.getStringExtra(EXTRA_SKIN);
//        String birthYear = intent.getStringExtra(EXTRA_BIRTH_YEAR);
//        String birthPlace = intent.getStringExtra(EXTRA_BIRTH_PLACE);
//        String diedAge = intent.getStringExtra(EXTRA_DIED_AGE);
//        String diedPlace = intent.getStringExtra(EXTRA_DIED_PLACE);
//        String affiliation = intent.getStringExtra(EXTRA_AFFILIATION);
//        String master = intent.getStringExtra(EXTRA_MASTER);
//        String apprentice = intent.getStringExtra(EXTRA_APPRENTICE);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCharacter = findViewById(R.id.text_view_character_detail);
        TextView textViewGender = findViewById(R.id.gender);
//        TextView textViewHomeworld = findViewById(R.id.homeworld);
        TextView textViewEye = findViewById(R.id.eye);
//        TextView textViewHair = findViewById(R.id.hair);
//        TextView textViewSkin = findViewById(R.id.skin);
//        TextView textViewBirthYear = findViewById(R.id.birth_year);
//        TextView textViewBirthPlace = findViewById(R.id.birth_place);
//        TextView textViewDiedAge = findViewById(R.id.died_age);
//        TextView textViewDiedPlace = findViewById(R.id.died_place);
//        TextView textViewAffiliation = findViewById(R.id.affiliation);
//        TextView textViewMaster = findViewById(R.id.master);
//        TextView textViewApprentice = findViewById(R.id.apprentice);

        Picasso.get().load(characterImage).fit().centerCrop().into(imageView);
        textViewCharacter.setText(characterName);
        textViewGender.setText(gender);
//        textViewHomeworld.setText(homeworld);
        textViewEye.setText(eye);
//        textViewHair.setText(hair);
//        textViewSkin.setText(skin);
//        textViewBirthYear.setText(birthYear);
//        textViewBirthPlace.setText(birthPlace);
//        textViewDiedAge.setText(diedAge);
//        textViewDiedPlace.setText(diedPlace);
//        textViewAffiliation.setText(affiliation);
//        textViewMaster.setText(master);
//        textViewApprentice.setText(apprentice);
    }
}
