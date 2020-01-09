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

public class Characters extends AppCompatActivity implements CharacterAdapterActivity.OnItemClickListener {
    public static final String EXTRA_IMAGE = "characterImage";
    public static final String EXTRA_NAME = "characterName";
    public static final String EXTRA_GENDER = "gender";
//    public static final String EXTRA_HOMEWORLD = "homeWorld";
    public static final String EXTRA_EYE = "eye";
    public static final String EXTRA_HAIR = "hair";
    public static final String EXTRA_SKIN = "skin";
//    public static final String EXTRA_BIRTH_YEAR = "birthYear";
//    public static final String EXTRA_BIRTH_PLACE = "birthPlace";
//    public static final String EXTRA_DIED_AGE = "diedAge";
//    public static final String EXTRA_DIED_PLACE = "diedPlace";
//    public static final String EXTRA_AFFILIATION = "affiliation";
//    public static final String EXTRA_MASTER = "master";
//    public static final String EXTRA_APPRENTICE = "apprentice";

    private RecyclerView mRecycleView;
    private CharacterAdapterActivity mCharacterAdapter;
    private ArrayList<CharactersActivity> mCharacterList;
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

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);

                                String characterName = object.getString("name");
                                String characterImage = object.getString("image");
                                String gender = object.getString("gender");
//                                String homeworld = object.getString("homeworld");
                                String eye = object.getString("eyeColor");
//                                String hair = object.getString("hairColor");
//                                String skin = object.getString("skinColor");
//                                int birthYear = object.getInt("born");
//                                String birthPlace = object.getString("bornLocation");
//                                int diedAge = object.getInt("died");
//                                String diedPlace = object.getString("diedLocation");
//                                String affiliation = object.getString("affiliations");
//                                String master = object.getString("masters");
//                                String apprentice = object.getString("apprentices");

                                mCharacterList.add(new CharactersActivity(characterImage, characterName, gender, eye));
                            }
//                           , homeworld, birthYear, birthPlace, diedAge, diedPlace, affiliation, master, apprentice, hair, skin
                            mCharacterAdapter = new CharacterAdapterActivity(Characters.this, mCharacterList);
                            mRecycleView.setAdapter(mCharacterAdapter);

                            mCharacterAdapter.setOnItemClickListener(Characters.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        error.printStackTrace();
                    }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        CharactersActivity itemClicked = mCharacterList.get(position);

        intent.putExtra(EXTRA_IMAGE, itemClicked.getCharacterImage());
        intent.putExtra(EXTRA_NAME, itemClicked.getCharacterName());
        intent.putExtra(EXTRA_GENDER, itemClicked.getGender());
//        intent.putExtra(EXTRA_HOMEWORLD, itemClicked.getHomeWorld());
        intent.putExtra(EXTRA_EYE, itemClicked.getEye());
//        intent.putExtra(EXTRA_HAIR, itemClicked.getHair());
//        intent.putExtra(EXTRA_SKIN, itemClicked.getSkin());
//        intent.putExtra(EXTRA_BIRTH_YEAR, itemClicked.getBirthYear());
//        intent.putExtra(EXTRA_BIRTH_PLACE, itemClicked.getBirthPlace());
//        intent.putExtra(EXTRA_DIED_AGE, itemClicked.getDiedAge());
//        intent.putExtra(EXTRA_DIED_PLACE, itemClicked.getDiedPlace());
//        intent.putExtra(EXTRA_AFFILIATION, itemClicked.getAffiliation());
//        intent.putExtra(EXTRA_MASTER, itemClicked.getMaster());
//        intent.putExtra(EXTRA_APPRENTICE, itemClicked.getApprentice());

        startActivity(intent);
    }
}
