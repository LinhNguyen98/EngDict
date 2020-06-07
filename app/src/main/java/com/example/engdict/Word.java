package com.example.engdict;

public class Word {
    private String mVietTranslation;
    private String mDefautlTranslation;



    public Word(String defautlTranslation,String vietTranslation) {
        this.mDefautlTranslation = defautlTranslation;
        this.mVietTranslation = vietTranslation;
    }

    /*get default translation of the word*/
    public String getDefautlTranslation() {
        return mDefautlTranslation;
    }

    public String getVietTranslation() {
        return mVietTranslation;
    }



    @Override
    public String toString() {
        return "Word{" +
                "mVietTranslation='" + mVietTranslation + '\'' +
                ", mDefautlTranslation='" + mDefautlTranslation + '\'' +

                '}';
    }

}
