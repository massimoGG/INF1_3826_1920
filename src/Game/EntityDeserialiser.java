/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Objects.Entity;
import com.google.gson.*;
import java.lang.reflect.Type;
import Game.Objects.*;
import java.util.ArrayList;

/**
 *
 * @author Michiel Claes
 */
public class EntityDeserialiser implements JsonDeserializer<ArrayList> {

    public ArrayList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        ArrayList<Entity> lijst = new ArrayList<Entity>();

        JsonArray jArray = json.getAsJsonArray();
        for (JsonElement jOb : jArray) {

            JsonObject jObject = jOb.getAsJsonObject();

            JsonElement jLevens = jObject.get("levens");
            JsonElement jIsVanPlayer = jObject.get("isVanPlayer");
            JsonElement jX = jObject.get("x");
            JsonElement jY = jObject.get("y");
            JsonElement jDx = jObject.get("dx");
            JsonElement jDy = jObject.get("dy");
            JsonElement jBreedte = jObject.get("breedte");
            JsonElement jHoogte = jObject.get("hoogte");
            JsonElement jIsUpgrade = jObject.get("isUpgrade");
            JsonElement jIsEnemy = jObject.get("isEnemy");

            if (jLevens != null) {
                Player p = new Player(jX.getAsInt(), jY.getAsInt());
                p.setLevens(jLevens.getAsInt());
                lijst.add(p);
            } else if (jIsVanPlayer != null) {
                Bullet b = new Bullet(jX.getAsInt(), jY.getAsInt(), jIsVanPlayer.getAsBoolean());
                lijst.add(b);
            } else if (jIsUpgrade != null) {
                Upgrade u = new Upgrade(jX.getAsInt(), jY.getAsInt(), jBreedte.getAsInt(), jHoogte.getAsInt());
                lijst.add(u);
            } else if (jIsEnemy != null) {
                Enemy e = new Enemy(jX.getAsInt(), jY.getAsInt(), jBreedte.getAsInt(), jHoogte.getAsInt());
                e.setdy(2);
                lijst.add(e);
            } else {
                return null;
            }
        }

        return lijst;
    }

}
