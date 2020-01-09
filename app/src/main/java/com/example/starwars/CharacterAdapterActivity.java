package com.example.starwars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapterActivity extends RecyclerView.Adapter<CharacterAdapterActivity.CharacterViewHolder> {
    private Context mContext;
    private ArrayList<Datum> mCharacterList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public CharacterAdapterActivity(Context context, ArrayList<Datum> characterList){
        mContext = context;
        mCharacterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_card_view_item, parent, false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Datum currentItem = mCharacterList.get(position);

        String name = currentItem.getName();
//        int height = currentItem.getHeight();
//        Integer mass = currentItem.getMass();
//        String gender = currentItem.getGender();
//        String homeworld = currentItem.getHomeworld();
//        String wiki = currentItem.getWiki();
        String image = currentItem.getImage();
//        Integer born = currentItem.getBorn();
//        String bornLocation = currentItem.getBornLocation();
//        Integer died = currentItem.getDied();
//        String diedLocation = currentItem.getDiedLocation();
//        String species = currentItem.getSpecies();
//        String hairColor = currentItem.getHairColor();
//        String eyeColor = currentItem.getEyeColor();
//        String skinColor = currentItem.getSkinColor();
//        String cybernetics = currentItem.getCybernetics();
//        List<String> affiliations = currentItem.getAffiliations();
//        List<String> masters = currentItem.getMasters();
//        List<String> apprentices = currentItem.getApprentices();
//        List<String> formerAffiliations = currentItem.getFormerAffiliations();
//        Integer dateCreated = currentItem.getDateCreated();
//        Integer dateDestroyed = currentItem.getDateDestroyed();
//        String destroyedLocation = currentItem.getDestroyedLocation();
//        String creator = currentItem.getCreator();
//        String manufacturer = currentItem.getManufacturer();
//        String model = currentItem.getModel();
//        String _class = currentItem.getClass_();
//        String sensorColor = currentItem.getSensorColor();
//        String platingColor = currentItem.getPlatingColor();
//        List<String> equipment = currentItem.getEquipment();
//        String productLine = currentItem.getProductLine();
//        String kajidic = currentItem.getKajidic();
//        List<String> era = currentItem.getEra();
//        String degree = currentItem.getDegree();
//        String armament = currentItem.getArmament();



        holder.mTextViewCharacterName.setText(name);
//        holder.textViewHeight.setText(height);
        Picasso.get().load(image).fit().centerCrop().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCharacterName;
//        public TextView textViewHeight;

        public CharacterViewHolder(View itemView){
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCharacterName = itemView.findViewById(R.id.text_view_character_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){}
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
