package com.example.starwars;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

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

    private RecyclerView mRecycleView;
    private CharacterAdapterActivity mCharacterAdapter;
//    private Context mContext;
    private List<Datum> mCharacterList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        mRecycleView = findViewById(R.id.recycle_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new GridLayoutManager(this,2));
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
                                List<String> affiliations;
                                List<String> masters;
                                List<String> apprentices;
                                List<String> formerAffiliations;
                                List<String> equipment;
                                List<String> era;

                                JSONArray jsonArrayAff = object.getJSONArray("affiliations");

                                affiliations = new ArrayList<>();
                                for(int j = 0; j < jsonArrayAff.length(); j++){
                                    affiliations.add(jsonArrayAff.getString(j));
                                }
//
//                                JSONArray jsonArrayMast = object.getJSONArray("masters");
//
//                                masters = new ArrayList<>();
//                                for(int k = 0; k < jsonArrayMast.length(); k++){
//                                    masters.add(jsonArrayMast.getString(k));
//                                }
//
//                                JSONArray jsonArrayApp = object.getJSONArray("apprentices");
//
//                                apprentices = new ArrayList<>();
//                                for(int l = 0; l < jsonArrayApp.length(); l++){
//                                    apprentices.add(jsonArrayApp.getString(l));
//                                }
//
//                                JSONArray jsonArrayformer = object.getJSONArray("formerAffiliations");
//
//                                formerAffiliations = new ArrayList<>();
//                                for(int m = 0; m < jsonArrayformer.length(); m++){
//                                    formerAffiliations.add(jsonArrayformer.getString(m));
//                                }
//
//                                JSONArray jsonArrayEquip = object.getJSONArray("equipment");
//
//                                equipment = new ArrayList<>();
//                                for(int n = 0; n < jsonArrayEquip.length(); n++){
//                                    equipment.add(jsonArrayEquip.getString(n));
//                                }
//
//                                JSONArray jsonArrayEra = object.getJSONArray("era");
//
//                                era = new ArrayList<>();
//                                for(int o = 0; o < jsonArrayEra.length(); o++){
//                                    era.add(jsonArrayEra.getString(o));
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
                                Integer dateCreated = object.optInt("dateCreated");
                                Integer dateDestroyed = object.optInt("dateDestroyed");
                                String destroyedLocation = object.optString("destroyedLocation");
                                String creator = object.optString("creator");
                                String manufacturer = object.optString("manufacturer");
                                String model = object.optString("model");
                                String _class = object.optString("_class");
                                String sensorColor = object.optString("sensorColor");
                                String platingColor = object.optString("platingColor");
                                String productLine = object.optString("productLine");
                                String kajidic = object.optString("kajidic");
                                String degree = object.optString("degree");
                                String armament = object.optString("armament");


                                mCharacterList.add(new Datum(id, name, height, mass, gender, homeworld, wiki, image, born, bornLocation, died, diedLocation, species, hairColor, eyeColor, skinColor, cybernetics, affiliations, dateCreated, dateDestroyed, destroyedLocation, creator, manufacturer, model, _class, sensorColor, platingColor, productLine, kajidic, degree, armament));
                            }
//                            affiliations, masters, apprentices, formerAffiliations,,  era, equipment
                            mCharacterAdapter = new CharacterAdapterActivity(mCharacterList);
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
        intent.putStringArrayListExtra("affiliations", (ArrayList<String>) itemClicked.getAffiliations());
        intent.putStringArrayListExtra("masters", (ArrayList<String>) itemClicked.getMasters());
        intent.putStringArrayListExtra("apprentices", (ArrayList<String>) itemClicked.getApprentices());
        intent.putStringArrayListExtra("formerAffiliations", (ArrayList<String>) itemClicked.getFormerAffiliations());
        intent.putExtra("dateCreated", itemClicked.getDateCreated());
        intent.putExtra("dateDestroyed", itemClicked.getDateDestroyed());
        intent.putExtra("destroyedLocation", itemClicked.getDestroyedLocation());
        intent.putExtra ("creator", itemClicked.getCreator());
        intent.putExtra("manufacturer", itemClicked.getManufacturer());
        intent.putExtra("model", itemClicked.getModel());
        intent.putExtra ("_class", itemClicked.getClass_());
        intent.putExtra("sensorColor", itemClicked.getSensorColor());
        intent.putExtra("platingColor", itemClicked.getPlatingColor());
        intent.putStringArrayListExtra("equipment", (ArrayList<String>) itemClicked.getEquipment());
        intent.putExtra ("productLine", itemClicked.getProductLine());
        intent.putExtra("kajidic", itemClicked.getKajidic());
        intent.putStringArrayListExtra("era", (ArrayList<String>) itemClicked.getEra());
        intent.putExtra ("degree", itemClicked.getDegree());
        intent.putExtra("armament", itemClicked.getArmament());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mCharacterAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
