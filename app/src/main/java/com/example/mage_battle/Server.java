package com.example.mage_battle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mage_battle.inventory.Rune;
import com.example.mage_battle.inventory.Spell;
import com.example.mage_battle.player.Mage;
import com.example.mage_battle.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Server {

    public String runeToInt(Rune a) {
        if (a.runeType == Rune.RuneType.Air) {
            return "0";
        } else if (a.runeType == Rune.RuneType.Fire) {
            return "1";
        } else if (a.runeType == Rune.RuneType.Earth) {
            return "2";
        } else {
            return "3";
        }
    }

    public Spell makeSimpleSpell(String name) {
        Spell sp = new Spell();
        sp.spellName = name;
        return sp;
    }

    public Spell getSpellFromRunes(Rune r1, Rune r2, Rune r3) {
        Map<String, String> params = new HashMap();
        params.put("r1", this.runeToInt(r1));
        params.put("r2", this.runeToInt(r2));
        params.put("r3", this.runeToInt(r3));

        JSONObject parameters = new JSONObject(params);
        final Spell[] result = {new Spell()};
        final Boolean[] finished = {false};


        RequestQueue queue = Volley.newRequestQueue(MainActivity.context);

        String url = "https://raw.githubusercontent.com/karpp/demodata/master/cast.json";
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, url, parameters,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        TextView results = findViewById(R.id.maintext);
//                        results.setText("I got response");
                        try {
//                            String data = "";
//                            JSONObject obj = response.getJSONObject("colorObject");
//                            String color = obj.getString("colorName");
//                            String desc = obj.getString("description");
//
//                            data += "Color Name: " + color +
//                                    "nDescription : " + desc;
//
//                            results.setText(data);
                            JSONObject obj = response.getJSONObject("spell");
                            String spellName = obj.getString("spellName");
                            result[0] = makeSimpleSpell(spellName);
                            finished[0] = true;
                        }
                        catch (JSONException e) {
                            finished[0] = true;
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        queue.add(obreq);

//        while (!finished[0]) {
//            return this.makeSimpleSpell("I am stuck");
//        }
//        new TimeLimitedCodeBlock(5, TimeUnit.SECONDS) {
//            @Override
//            public void codeBlock() {
//
//            }
//        }.run();
        return result[0];


    }

}
