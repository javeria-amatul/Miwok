package com.example.android.miwok;

/**
 * Created by Javeria on 6/4/2017.
 */

public class Word {

    private String mDefaultTransalation;
    private String mMiwokTransalation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    //to check if phrases has images
    private static final int NO_IMAGE_PROVIDED=-1;

    private int mAudioResourceId;

    public  Word(String defaultTransalation,String miwokTransalation, int audioResourceId){
        mDefaultTransalation=   defaultTransalation;
        mMiwokTransalation  = miwokTransalation;
        mAudioResourceId=audioResourceId;
    }

    public Word(String defaultTransalation, String miwokTranslation, int ImageResourceId, int audioResourceId){

        mDefaultTransalation=defaultTransalation;
        mMiwokTransalation=miwokTranslation;
        mImageResourceId= ImageResourceId;
        mAudioResourceId=audioResourceId;
    }

    public String getdefaultTransalation(){
        return mDefaultTransalation;
    }


    public String getMiwokTransalation(){
        return mMiwokTransalation;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public  boolean hasImage(){
        return mImageResourceId !=NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){return  mAudioResourceId;}
}
