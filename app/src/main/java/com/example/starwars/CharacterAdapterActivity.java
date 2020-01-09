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

public class CharacterAdapterActivity extends RecyclerView.Adapter<CharacterAdapterActivity.CharacterViewHolder> {
    private Context mContext;
    private ArrayList<CharactersActivity> mCharacterList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public CharacterAdapterActivity(Context context, ArrayList<CharactersActivity> characterList){
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
        CharactersActivity currentItem = mCharacterList.get(position);

        String characterImage = currentItem.getCharacterImage();
        String characterName = currentItem.getCharacterName();
//        String gender = currentItem.getGender();
//        String homeworld = currentItem.getHomeWorld();
//        String eye = currentItem.getEye();
//        String hair = currentItem.getHair();
//        String skin = currentItem.getSkin();
//        int birthYear = currentItem.getBirthYear();
//        String birthPlace = currentItem.getBirthPlace();
//        int diedAge = currentItem.getDiedAge();
//        String diedPlace = currentItem.getDiedPlace();
//        String affiliation = currentItem.getAffiliation();
//        String master = currentItem.getMaster();
//        String apprentice = currentItem.getApprentice();


        holder.mTextViewCharacterName.setText(characterName);
        Picasso.get().load(characterImage).fit().centerCrop().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCharacterName;

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
