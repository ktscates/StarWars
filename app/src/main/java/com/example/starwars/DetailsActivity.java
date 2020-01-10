package com.example.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//
////import static com.example.starwars.Characters.EXTRA_AFFILIATIONS;
////import static com.example.starwars.Characters.EXTRA_APPRENTICES;
//import static com.example.starwars.Characters.EXTRA_ARMAMENT;
//import static com.example.starwars.Characters.EXTRA_BORN;
//import static com.example.starwars.Characters.EXTRA_BORN_LOCATION;
//import static com.example.starwars.Characters.EXTRA_CLASS;
//import static com.example.starwars.Characters.EXTRA_CREATOR;
//import static com.example.starwars.Characters.EXTRA_CYBERNETICS;
//import static com.example.starwars.Characters.EXTRA_DATE_CREATED;
//import static com.example.starwars.Characters.EXTRA_DATE_DESTROYED;
//import static com.example.starwars.Characters.EXTRA_DEGREE;
//import static com.example.starwars.Characters.EXTRA_DESTROYED_LOCATION;
//import static com.example.starwars.Characters.EXTRA_DIED;
//import static com.example.starwars.Characters.EXTRA_DIED_LOCATION;
////import static com.example.starwars.Characters.EXTRA_EQUIPMENT;
////import static com.example.starwars.Characters.EXTRA_ERA;
//import static com.example.starwars.Characters.EXTRA_EYECOLOR;
////import static com.example.starwars.Characters.EXTRA_FORMER_AFFILIATIONS;
//import static com.example.starwars.Characters.EXTRA_GENDER;
//import static com.example.starwars.Characters.EXTRA_HAIRCOLOR;
//import static com.example.starwars.Characters.EXTRA_HEIGHT;
//import static com.example.starwars.Characters.EXTRA_HOMEWORLD;
//import static com.example.starwars.Characters.EXTRA_KAJIDIC;
//import static com.example.starwars.Characters.EXTRA_MANUFACTURER;
//import static com.example.starwars.Characters.EXTRA_IMAGE;
//import static com.example.starwars.Characters.EXTRA_MASS;
////import static com.example.starwars.Characters.EXTRA_MASTERS;
//import static com.example.starwars.Characters.EXTRA_MODEL;
//import static com.example.starwars.Characters.EXTRA_NAME;
//import static com.example.starwars.Characters.EXTRA_PLATINGCOLOR;
//import static com.example.starwars.Characters.EXTRA_PRODUCTLINE;
//import static com.example.starwars.Characters.EXTRA_SENSORCOLOR;
//import static com.example.starwars.Characters.EXTRA_SKINCOLOR;
//import static com.example.starwars.Characters.EXTRA_SPECIES;
//import static com.example.starwars.Characters.EXTRA_WIKI;
//

public class DetailsActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
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
    TextView textViewDateCreated;
    TextView textViewDateDestroyed;
    TextView textViewDestroyed;
    TextView textViewCreator;
    TextView textViewManufacturer;
    TextView textViewModel;
    TextView textViewClass;
    TextView textViewSensor;
    TextView textViewPlating;
    TextView textViewProduct;
    TextView textViewKajidic;
    TextView textViewDegree;
    TextView textViewArmament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
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
        String cybenretics = intent.getStringExtra("cybernetics");
//        List<String> affiliations = intent.getStringArrayListExtra(EXTRA_AFFILIATIONS);
//        String masters = intent.getStringExtra(EXTRA_MASTERS);
//        String apprentices = intent.getStringExtra(EXTRA_APPRENTICES);
//        String formerAffliations = intent.getStringExtra(EXTRA_FORMER_AFFILIATIONS);
        Integer dateCreated = intent.getIntExtra("dateCreated",0);
        Integer dateDestroyed = intent.getIntExtra("dateDestroyed",0);
        String destroyedLocation = intent.getStringExtra("destroyedLocation");
        String creator = intent.getStringExtra("creator");
        String manufacturer = intent.getStringExtra("manufacturer");
        String model = intent.getStringExtra("model");
        String _class = intent.getStringExtra("_class");
        String sensorColor = intent.getStringExtra("sensorColor");
        String platingColor = intent.getStringExtra("platingColor");
//        String equipments = intent.getStringExtra(EXTRA_EQUIPMENT);
        String productLine = intent.getStringExtra("productLine");
        String kajidic = intent.getStringExtra("kajidic");
//        String era = intent.getStringExtra(EXTRA_ERA);
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
//        TextView textViewAffiliations = findViewById(R.id.affiliations);
//        TextView textViewMasters = findViewById(R.id.masters);
//        TextView textViewApprentices = findViewById(R.id.apprentices);
//        TextView textViewFormer = findViewById(R.id.former);
        textViewDateCreated = findViewById(R.id.date_created);
        textViewDateDestroyed = findViewById(R.id.date_destroyed);
        textViewDestroyed = findViewById(R.id.destroyed);
        textViewCreator = findViewById(R.id.creator);
        textViewManufacturer = findViewById(R.id.manufacturer);
        textViewModel = findViewById(R.id.model);
        textViewClass = findViewById(R.id.class_);
        textViewSensor = findViewById(R.id.sensor);
        textViewPlating = findViewById(R.id.plating);
//        TextView textViewEquipments = findViewById(R.id.equipments);
        textViewProduct = findViewById(R.id.product);
        textViewKajidic = findViewById(R.id.kajidic);
//        TextView textViewEra = findViewById(R.id.era);
        textViewDegree = findViewById(R.id.degree);
        textViewArmament = findViewById(R.id.armament);

        textViewCharacter.setText(name);
        textViewHeight.setText("Height: " + height);
        textViewMass.setText("Mass: " + mass);
        textViewGender.setText(gender);
        textViewHomeworld.setText(homeworld);
        textViewWiki.setText(wiki);
        Picasso.get().load(image).fit().centerCrop().into(imageView);
        textViewBorn.setText("Born: " + born);
        textViewBornLocation.setText(bornLocation);
        textViewDied.setText("Died: " + died);
        textViewDiedLocation.setText(diedLocation);
        textViewSpecies.setText(species);
        textViewHaircolor.setText(hairColor);
        textViewEyeColor.setText(eyeColor);
        textViewSkinColor.setText(skinColor);
        textViewCyber.setText(cybenretics);
//        String affiliate = "";
//        for(int i = 0; i < affiliations.size(); i++){
//            affiliate = affiliations.get(i) + "\n";
//        }
//        textViewAffiliations.setText(affiliate);
//        textViewMasters.setText(masters);
//        textViewApprentices.setText(apprentices);
//        textViewFormer.setText(formerAffliations);
        textViewDateCreated.setText("Date created: " + dateCreated);
        textViewDateDestroyed.setText("Date destroyed: " + dateDestroyed);
        textViewDestroyed.setText(destroyedLocation);
        textViewCreator.setText(creator);
        textViewManufacturer.setText(manufacturer);
        textViewModel.setText(model);
        textViewClass.setText(_class);
        textViewSensor.setText(sensorColor);
        textViewPlating.setText(platingColor);
//        textViewEquipments.setText(equipments);
        textViewProduct.setText(productLine);
        textViewKajidic.setText(kajidic);
//        textViewEra.setText(era);
        textViewDegree.setText(degree);
        textViewArmament.setText(armament);
    }

}
