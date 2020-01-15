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

/**
 *
 * @author Michiel Claes
 */
public class EntityDeserialiser implements JsonDeserializer<Entity> {

    public Entity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
            JsonObject jObject = json.getAsJsonObject();
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
            
            
            if (jLevens != null){
                Player p = new Player(jX.getAsInt(), jY.getAsInt());
                p.setLevens(jLevens.getAsInt());
                return p;
            }
            else if (jIsVanPlayer != null){
                Bullet b = new Bullet(jX.getAsInt(), jY.getAsInt(), jIsVanPlayer.getAsBoolean());
                return b;
            }
            else if (jIsUpgrade != null){
                Upgrade u = new Upgrade(jX.getAsInt(), jY.getAsInt(), jBreedte.getAsInt(), jHoogte.getAsInt());
                return u;
            }
            else if (jIsEnemy != null){
                Enemy e = new Enemy(jX.getAsInt(), jY.getAsInt(), jBreedte.getAsInt(), jHoogte.getAsInt());
                return e;
            }
            else {
                return null;
            }
            
        

    }

}
