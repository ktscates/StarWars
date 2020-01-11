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
import java.util.Objects;


public class DetailsActivity extends AppCompatActivity {
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

    SharedPreferences sharedPreferences;
    Button save;

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
        textViewAffiliations = findViewById(R.id.affiliations);
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
        textViewCyber.setText(cybernetics);

        StringBuilder affiliate = new StringBuilder();
        if (affiliations != null) {
            for (int i = 0; i < affiliations.size(); i++) {
                affiliate.append(affiliations.get(i)).append("\n");
            }
        }
        textViewAffiliations.setText("Affiliations: " + affiliate);
        System.out.println(affiliate);


//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_details);
//            image=(ImageView)findViewById(R.id.image1);
//            name=findViewById(R.id.name);
//            aff=findViewById(R.id.affiliations);
//            final Intent intent=getIntent();
//            name.setText(intent.getStringExtra("name"));
//            List<String> mList=intent.getStringArrayListExtra("aff");
//            String affi="";
//            for(int i=0;i<mList.size();i++){
//
//                affi=affi+mList.get(i)+"\n";
//            }
//            aff.setText(affi);
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

        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("com.example.starwars", Context.MODE_PRIVATE);
                String characterName = textViewCharacter.getText().toString();
                String characterGender = textViewGender.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("characterName", characterName);
                editor.putString("characterGender", characterGender);
                editor.commit();
                Toast.makeText(DetailsActivity.this, characterName + "Has been Saved", Toast.LENGTH_LONG).show();
                System.out.println(characterName);
                System.out.println(characterGender);
            }
        });
    }

}
