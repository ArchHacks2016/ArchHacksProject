package com.example.grace.archhacks;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Grace on 11/5/2016.
 */

@ParseClassName("Picture")
public class Picture extends ParseObject{

    public Picture() {
        super();
    }

    public String getId() {
        return getObjectId();
    }

    public ParseFile getPhotoFile() { return getParseFile("file"); }

    public ParseUser getOwner(){
        return getParseUser("owner");
    }

    public int getHappinessLikelihood() { return getInt("happiness");}

    public int getSurprisedLikelihood() { return getInt("surprised");}

    public int getAngerLikelihood() { return getInt("anger");}

    public int getSadnessLikelihood() { return getInt("sadness");}

    public String getEmotionLevel() { return getString("emotionLevel"); }

    public void setId(String id) {
        setObjectId(id);
    }

    public void setPhotoFile(ParseFile file) { put("file", file); }

    public void setOwnerId(String id){
        put("parentId", id);
    }

    public void setHappinessLikelihood(int likelihood) { put("happiness",likelihood);}

    public void setSurprisedLikelihood(int likelihood) { put("surprised",likelihood);}

    public void setAngerLikelihood(int likelihood) { put("anger",likelihood);}

    public void setSadnessLikelihood(int likelihood) { put("sadness",likelihood);}

    public void setEmotionLevel(String emotionLevel) {put("emotionLevel",emotionLevel); }

}
