package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        System.out.println(json);
        JSONObject jsonBase;
        try {
            jsonBase = new JSONObject(json);

            String mainName = "";
            List<String> alsoKnownAs = new ArrayList<>();
            String placeOfOrigin = "";
            String description = "";
            String image = "";
            List<String> ingredients = new ArrayList<>();

            JSONObject name = jsonBase.getJSONObject("name");
            JSONArray alsoKnownAsJSONArray, ingredientsJSONArray;

            if (name.has("mainName"))
                mainName = name.optString("mainName");

            if (name.has("alsoKnownAs")) {
                alsoKnownAsJSONArray = name.getJSONArray("alsoKnownAs");
                for (int i = 0; i < alsoKnownAsJSONArray.length(); i++)
                    alsoKnownAs.add(alsoKnownAsJSONArray.getString(i));
            }

            if (jsonBase.has("placeOfOrigin"))
                placeOfOrigin = jsonBase.optString("placeOfOrigin");

            if (jsonBase.has("description"))
                description = jsonBase.optString("description");

            if (jsonBase.has("image"))
                image = jsonBase.optString("image");

            if (jsonBase.has("image")) {
                ingredientsJSONArray = jsonBase.getJSONArray("ingredients");
                for (int i = 0; i < ingredientsJSONArray.length(); i++)
                    ingredients.add(ingredientsJSONArray.getString(i));
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
