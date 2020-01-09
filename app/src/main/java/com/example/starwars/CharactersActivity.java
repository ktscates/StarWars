package com.example.starwars;

public class CharactersActivity {
    private String mCharacterImage;
    private String mCharacterName;
    private String mGender;
//    private String mHomeWorld;
    private String mEye;
//    private String mHair;
//    private String mSkin;
//    private int mBirthYear;
//    private String mBirthPlace;
//    private int mDiedAge;
//    private String mDiedPlace;
//    private String mAffiliation;
//    private String mMaster;
//    private String mApprentice;

    public CharactersActivity(String characterImage, String characterName, String gender, String eye){
        mCharacterImage = characterImage;
        mCharacterName = characterName;
        mGender = gender;
//        mHomeWorld = homeworld;
        mEye = eye;
//        mHair = hair;
//        mSkin = skin;
//        mBirthYear = birthYear;
//        mBirthPlace = birthPlace;
//        mDiedAge = diedAge;
//        mDiedPlace = diedPlace;
//        mAffiliation = affiliation;
//        mMaster = master;
//        mApprentice = apprentice;
    }
//    , String eye, int birthYear, String birthPlace, int diedAge, String diedPlace, String affiliation, String master, String apprentice String hair,String skin
    public String getCharacterImage(){
        return mCharacterImage;
    }

    public String getCharacterName(){
        return mCharacterName;
    }

    public String getGender() {
        return mGender;
    }

//    public String getHomeWorld() {
//        return mHomeWorld;
//    }
//
    public String getEye() {
        return mEye;
    }
//
//    public String getHair() {
//        return mHair;
//    }

//    public String getSkin() {
//        return mSkin;
//    }
//
//    public int getBirthYear() {
//        return mBirthYear;
//    }
//
//    public String getBirthPlace() {
//        return mBirthPlace;
//    }
//
//    public int getDiedAge() {
//        return mDiedAge;
//    }
//
//    public String getDiedPlace() {
//        return mDiedPlace;
//    }
//
//    public String getAffiliation() {
//        return mAffiliation;
//    }
//
//    public String getMaster() {
//        return mMaster;
//    }
//
//    public String getApprentice() {
//        return mApprentice;
//    }
}
