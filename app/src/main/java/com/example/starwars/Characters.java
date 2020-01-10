package com.example.starwars;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Characters extends AppCompatActivity implements CharacterAdapterActivity.OnItemClickListener {
//    public static final String EXTRA_NAME = "name";
//    public static final String EXTRA_HEIGHT = "height";
//    public static final String EXTRA_MASS = "mass";
//    public static final String EXTRA_GENDER = "gender";
//    public static final String EXTRA_HOMEWORLD = "homeworld";
//    public static final String EXTRA_WIKI = "wiki";
//    public static final String EXTRA_IMAGE = "image";
//    public static final String EXTRA_BORN = "born";
//    public static final String EXTRA_BORN_LOCATION = "bornLocation";
//    public static final String EXTRA_DIED = "died";
//    public static final String EXTRA_DIED_LOCATION = "diedLocation";
//    public static final String EXTRA_SPECIES = "species";
//    public static final String EXTRA_HAIRCOLOR = "hairColor";
//    public static final String EXTRA_EYECOLOR = "eyeColor";
//    public static final String EXTRA_SKINCOLOR = "skinColor";
//    public static final String EXTRA_CYBERNETICS = "cybernetics";
//    public static final String EXTRA_AFFILIATIONS = "affiliations";
//    public static final String EXTRA_MASTERS = "masters";
//    public static final String EXTRA_APPRENTICES = "apprentices";
//    public static final String EXTRA_FORMER_AFFILIATIONS = "formerAffiliations";
//    public static final String EXTRA_DATE_CREATED = "dateCreated";
//    public static final String EXTRA_DATE_DESTROYED = "dateDestroyed";
//    public static final String EXTRA_DESTROYED_LOCATION = "destroyedLocation";
//    public static final String EXTRA_CREATOR = "creator";
//    public static final String EXTRA_MANUFACTURER = "manufacturer";
//    public static final String EXTRA_MODEL= "model";
//    public static final String EXTRA_CLASS = "_class";
//    public static final String EXTRA_SENSORCOLOR= "sensorColor";
//    public static final String EXTRA_PLATINGCOLOR= "platingColor";
////    public static final String EXTRA_EQUIPMENT = "equipment";
//    public static final String EXTRA_PRODUCTLINE = "productLine";
//    public static final String EXTRA_KAJIDIC = "kajidic";
////    public static final String EXTRA_ERA= "era";
//    public static final String EXTRA_DEGREE= "degree";
//    public static final String EXTRA_ARMAMENT = "armament";

    private RecyclerView mRecycleView;
    private CharacterAdapterActivity mCharacterAdapter;
    private ArrayList<Datum> mCharacterList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        mRecycleView = findViewById(R.id.recycle_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, 2));

        mCharacterList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson(){
        String url = "https://awesome-star-wars-api.herokuapp.com/characters";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
//                                List<String> affiliations = null;
//
//                                JSONArray jsonArrayAff = object.getJSONArray("affiliations");
//
//                                affiliations = new ArrayList<String>();
//                                for(int j = 0; j < jsonArrayAff.length(); j++){
//                                    affiliations.add(jsonArrayAff.getString(j));
//                                }

                                Integer id = object.getInt("id");
                                String name = object.getString("name");
                                Integer height = object.optInt("height");
                                Integer mass = object.optInt("mass");
                                String gender = object.optString("gender");
                                String homeworld = object.optString("homeworld");
                                String wiki = object.optString("wiki");
                                String image = object.getString("image");
                                Integer born = object.optInt("born");
                                String bornLocation = object.optString("bornLocation");
                                Integer died = object.optInt("died");
                                String diedLocation = object.optString("diedLocation");
                                String species = object.optString("species");
                                String hairColor = object.optString("hairColor");
                                String eyeColor = object.optString("eyeColor");
                                String skinColor = object.optString("skinColor");
                                String cybernetics = object.optString("cybernetics");
//                                List<String> affiliations = object.getJSONArray("affiliations");
//                                List<String> masters = object.getString("masters");
//                                List<String> apprentices = object.getString("apprentices");
//                                List<String> formerAffiliations = object.getString("formerAffiliations");
                                Integer dateCreated = object.optInt("dateCreated");
                                Integer dateDestroyed = object.optInt("dateDestroyed");
                                String destroyedLocation = object.optString("destroyedLocation");
                                String creator = object.optString("creator");
                                String manufacturer = object.optString("manufacturer");
                                String model = object.optString("model");
                                String _class = object.optString("_class");
                                String sensorColor = object.optString("sensorColor");
                                String platingColor = object.optString("platingColor");
//                                List<String> equipment = object.getString("equipment");
                                String productLine = object.optString("productLine");
                                String kajidic = object.optString("kajidic");
//                                List<String> era = object.getString("era");
                                String degree = object.optString("degree");
                                String armament = object.optString("armament");


                                mCharacterList.add(new Datum(id, name, height, mass, gender, homeworld, wiki, image, born, bornLocation, died, diedLocation, species, hairColor, eyeColor, skinColor, cybernetics, dateCreated, dateDestroyed, destroyedLocation, creator, manufacturer, model, _class, sensorColor, platingColor, productLine, kajidic, degree, armament));
                            }
//                            affiliations, masters, apprentices, formerAffiliations,,  era, equipment
                            mCharacterAdapter = new CharacterAdapterActivity(Characters.this, mCharacterList);
                            mRecycleView.setAdapter(mCharacterAdapter);

                            mCharacterAdapter.setOnItemClickListener(Characters.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        Datum itemClicked = mCharacterList.get(position);

        intent.putExtra("name", itemClicked.getName());
        intent.putExtra("height", itemClicked.getHeight());
        intent.putExtra ("mass", itemClicked.getMass());
        intent.putExtra("gender", itemClicked.getGender());
        intent.putExtra("homeworld", itemClicked.getHomeworld());
        intent.putExtra ("wiki", itemClicked.getWiki());
        intent.putExtra("image", itemClicked.getImage());
        intent.putExtra("born", itemClicked.getBorn());
        intent.putExtra("bornLocation", itemClicked.getBornLocation() );
        intent.putExtra ("died", itemClicked.getMass());
        intent.putExtra("diedLocation", itemClicked.getDiedLocation());
        intent.putExtra("species", itemClicked.getSpecies());
        intent.putExtra("hariColor", itemClicked.getHairColor());
        intent.putExtra("eyeColor", itemClicked.getEyeColor());
        intent.putExtra("skinColor", itemClicked.getSkinColor());
        intent.putExtra("cybernetics", itemClicked.getCybernetics());
//        intent.putStringArrayListExtra(EXTRA_AFFILIATIONS, (ArrayList<String>) itemClicked.getAffiliations());
//        intent.putExtra(EXTRA_MASTERS, itemClicked.getMasters());
//        intent.putExtra(EXTRA_APPRENTICES, itemClicked.getApprentices());
//        intent.putExtra (EXTRA_FORMER_AFFILIATIONS, itemClicked.getFormerAffiliations());
        intent.putExtra("dateCreated", itemClicked.getDateCreated());
        intent.putExtra("dateDestroyed", itemClicked.getDateDestroyed());
        intent.putExtra("destroyedLocation", itemClicked.getDestroyedLocation());
        intent.putExtra ("creator", itemClicked.getCreator());
        intent.putExtra("manufacturer", itemClicked.getManufacturer());
        intent.putExtra("model", itemClicked.getModel());
        intent.putExtra ("_class", itemClicked.getClass_());
        intent.putExtra("sensorColor", itemClicked.getSensorColor());
        intent.putExtra("platingColor", itemClicked.getPlatingColor());
//        intent.putExtra(EXTRA_EQUIPMENT, itemClicked.getEquipment() );
        intent.putExtra ("productLine", itemClicked.getProductLine());
        intent.putExtra("kajidic", itemClicked.getKajidic());
//        intent.putExtra(EXTRA_ERA, itemClicked.getEra());
        intent.putExtra ("degree", itemClicked.getDegree());
        intent.putExtra("armament", itemClicked.getArmament());

        startActivity(intent);
    }
}
