package com.example.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import java.util.List;

public class DetailsActivity<KEY_CHARACTERS> extends AppCompatActivity {
    TextView textViewCharacter;
    TextView textViewHeight;
    TextView textViewMass;
    TextView textViewGender;
    TextView textViewHomeworld;
    TextView textViewWiki;
    ImageView imageView;
    TextView textViewBorn;
    TextView textViewBornLocation;
    TextView textViewDied;
    TextView textViewDiedLocation;
    TextView textViewSpecies;
    TextView textViewHaircolor;
    TextView textViewEyeColor;
    TextView textViewSkinColor;
    TextView textViewCyber;
    TextView textViewAffiliations;
    TextView textViewMasters;
    TextView textViewApprentices;
    TextView textViewFormer;
    TextView textViewDateCreated;
    TextView textViewDateDestroyed;
    TextView textViewDestroyed;
    TextView textViewCreator;
    TextView textViewManufacturer;
    TextView textViewModel;
    TextView textViewClass;
    TextView textViewSensor;
    TextView textViewPlating;
    TextView textViewEquipment;
    TextView textViewProduct;
    TextView textViewKajidic;
    TextView textViewEra;
    TextView textViewDegree;
    TextView textViewArmament;

    SharedPreferences sharedPreferences;
    private final String MY_CHARACTERS_KEY = "myCharacters";
    static final String KEY_NAME = "nameKey";
    static final String KEY_GENDER = "genderKey";
    Button save;
    Button load;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer height = intent.getIntExtra("height", 0);
        Integer mass = intent.getIntExtra("mass",0);
        String gender = intent.getStringExtra("gender");
        String homeworld = intent.getStringExtra("homeworld");
        String wiki = intent.getStringExtra("wiki");
        String image = intent.getStringExtra("image");
        Integer born = intent.getIntExtra("born",0);
        String bornLocation = intent.getStringExtra("bornLocation");
        Integer died = intent.getIntExtra("died",0);
        String diedLocation = intent.getStringExtra("diedLocation");
        String species = intent.getStringExtra("species");
        String hairColor = intent.getStringExtra("hairColor");
        String eyeColor = intent.getStringExtra("eyeColor");
        String skinColor = intent.getStringExtra("skinColor");
        String cybernetics = intent.getStringExtra("cybernetics");
        List<String> affiliations = intent.getStringArrayListExtra("affialiations");
        String masters = intent.getStringExtra("masters");
        String apprentices = intent.getStringExtra("apprentices");
        String formerAffliations = intent.getStringExtra("formerAffiliations");
        Integer dateCreated = intent.getIntExtra("dateCreated",0);
        Integer dateDestroyed = intent.getIntExtra("dateDestroyed",0);
        String destroyedLocation = intent.getStringExtra("destroyedLocation");
        String creator = intent.getStringExtra("creator");
        String manufacturer = intent.getStringExtra("manufacturer");
        String model = intent.getStringExtra("model");
        String _class = intent.getStringExtra("_class");
        String sensorColor = intent.getStringExtra("sensorColor");
        String platingColor = intent.getStringExtra("platingColor");
        String equipment = intent.getStringExtra("equipment");
        String productLine = intent.getStringExtra("productLine");
        String kajidic = intent.getStringExtra("kajidic");
        String era = intent.getStringExtra("era");
        String degree = intent.getStringExtra("degree");
        String armament = intent.getStringExtra("armament");

        textViewCharacter = findViewById(R.id.text_view_character_detail);
        textViewHeight = findViewById(R.id.height);
        textViewMass = findViewById(R.id.mass);
        textViewGender = findViewById(R.id.gender);
        textViewHomeworld = findViewById(R.id.homeworld);
        textViewWiki = findViewById(R.id.wiki);
        imageView = findViewById(R.id.image_view_detail);
        textViewBorn = findViewById(R.id.born);
        textViewBornLocation = findViewById(R.id.born_location);
        textViewDied = findViewById(R.id.died);
        textViewDiedLocation = findViewById(R.id.died_location);
        textViewSpecies = findViewById(R.id.species);
        textViewHaircolor = findViewById(R.id.hair);
        textViewEyeColor = findViewById(R.id.eye);
        textViewSkinColor = findViewById(R.id.skin);
        textViewCyber = findViewById(R.id.cyber);
        textViewAffiliations = findViewById(R.id.affiliations);
        textViewMasters = findViewById(R.id.masters);
        textViewApprentices = findViewById(R.id.apprentices);
        textViewFormer = findViewById(R.id.former);
        textViewDateCreated = findViewById(R.id.date_created);
        textViewDateDestroyed = findViewById(R.id.date_destroyed);
        textViewDestroyed = findViewById(R.id.destroyed);
        textViewCreator = findViewById(R.id.creator);
        textViewManufacturer = findViewById(R.id.manufacturer);
        textViewModel = findViewById(R.id.model);
        textViewClass = findViewById(R.id.class_);
        textViewSensor = findViewById(R.id.sensor);
        textViewPlating = findViewById(R.id.plating);
        textViewEquipment = findViewById(R.id.equipments);
        textViewProduct = findViewById(R.id.product);
        textViewKajidic = findViewById(R.id.kajidic);
        textViewEra = findViewById(R.id.era);
        textViewDegree = findViewById(R.id.degree);
        textViewArmament = findViewById(R.id.armament);

        textViewCharacter.setText(name);
        textViewHeight.setText("Height: " + height);
        textViewMass.setText("Mass: " + mass);
        textViewGender.setText("Gender: " + gender);
        textViewHomeworld.setText("Homeworld: " + homeworld);
        textViewWiki.setText("Wiki: " + wiki);
        Picasso.get().load(image).fit().centerCrop().into(imageView);
        textViewBorn.setText("Born: " + born);
        textViewBornLocation.setText("Born location: " + bornLocation);
        textViewDied.setText("Died: " + died);
        textViewDiedLocation.setText("Died Location: " + diedLocation);
        textViewSpecies.setText("Species: " + species);
        textViewHaircolor.setText("Hair Color: " + hairColor);
        textViewEyeColor.setText("Eye color: " + eyeColor);
        textViewSkinColor.setText("Skin color: " + skinColor);
        textViewCyber.setText("Cybernetics: " + cybernetics);

        StringBuilder affiliate = new StringBuilder();
        if (affiliations != null) {
            for (int j = 0; j < affiliations.size(); j++) {
                affiliate.append(affiliations.get(j)).append("\n");
            }
        }
        textViewAffiliations.setText("Affiliations: " + affiliate);
        System.out.println(affiliate);

//        StringBuilder master = new StringBuilder();
//        if(masters != null) {
//            for (int j = 0; j < masters.size(); j++) {
//                master.append(masters.get(j)).append("\n");
//            }
//        }
        textViewMasters.setText("Masters: " + masters);
//        System.out.println(master);
        textViewApprentices.setText("Apprentices: " + apprentices);
        textViewFormer.setText("Former Affiliations: " + formerAffliations);
        textViewDateCreated.setText("Date created: " + dateCreated);
        textViewDateDestroyed.setText("Date destroyed: " + dateDestroyed);
        textViewDestroyed.setText("Destroyed location: " + destroyedLocation);
        textViewCreator.setText("Creator: " + creator);
        textViewManufacturer.setText("Manufacturer: " + manufacturer);
        textViewModel.setText("Model: " + model);
        textViewClass.setText("Class: " + _class);
        textViewSensor.setText("Sensor color: " + sensorColor);
        textViewPlating.setText("Plating color: " + platingColor);
        textViewEquipment.setText("Equipment: " + equipment);
        textViewProduct.setText("Product line: " + productLine);
        textViewKajidic.setText("Kajidic: " + kajidic);
        textViewEra.setText("Era: " + era);
        textViewDegree.setText("Degree: " + degree);
        textViewArmament.setText("Armament: " + armament);

        save = findViewById(R.id.save);
        load = findViewById(R.id.load);
        delete = findViewById(R.id.delete);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                   writeFileOnInternalStorage();
                sharedPreferences = getSharedPreferences(MY_CHARACTERS_KEY, Context.MODE_PRIVATE);
                String characterName = textViewCharacter.getText().toString();
                String characterGender = textViewGender.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, characterName);
                editor.putString(KEY_GENDER, characterGender);
                editor.commit();
                Toast.makeText(DetailsActivity.this, characterName + "Has been Saved", Toast.LENGTH_LONG).show();
                System.out.println(characterName);
                System.out.println(characterGender);
            }

        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(MY_CHARACTERS_KEY, Context.MODE_PRIVATE);

                if(sharedPreferences.contains(KEY_NAME)){
                    textViewCharacter.setText(sharedPreferences.getString(KEY_NAME, ""));
                }
                if(sharedPreferences.contains(KEY_GENDER)){
                    textViewGender.setText(sharedPreferences.getString(KEY_GENDER, ""));
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewCharacter.setText("");
                textViewGender.setText("");
            }
        });
    }

}
