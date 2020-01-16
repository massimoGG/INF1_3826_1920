package Game;

import Game.Objects.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
// Core van het spel
// @author Massimo

public class GameModel {

    private GameController controller;
    private GameView view;
    private Stage stage;
    private ArrayList<Entity> entities, removeLijst;
    private Iterator<Entity> lijst;
    private Collision col;
    private Entity e;

    // Onze speler
    public int score = 0;
    private static Player player;

    // Afmetingen van het scherm
    public double minX = 0;
    public double maxX;

    //de upgrade status
    public boolean upgradeOn;

    private long upgradeTijd;

    private boolean saving = false;

    // Constructor
    public GameModel() {
        // Maak een nieuwe speler aan
        player = new Player(50, 50);
        // Al uw objecten
        entities = new ArrayList<Entity>();
        col = new Collision(this);
        entities.add(player);
    }

    /**
     * Deze functie update de benodigde zaken.
     */
    public void update() {

        ArrayList<Entity> removeLijst = new ArrayList<Entity>();

        if (player.getX() + player.getdx() > minX && player.getX() + player.getdx() < maxX) {
            player.setX(player.getX() + player.getdx());
        }

        // Doorloop alles om het te updaten
        for (Entity e : entities) {
            if (e != null) {
                // Hou de vijanden binnen het scherm?
                if (e.getY() > stage.getHeight() - e.getHoogte() - 50 || e.getY() < 0) {
                    if (e instanceof Enemy) {
                        score = score - 1;
                    }
                    remove(e);

                } else {
                    // UPdate positie van entitie
                    e.setY(e.getY() + e.getdy());
                }
            }
        }
        col.isOverlappend();//entities);

        if (player.getLevens() <= 0) {
            reset();
        }

    }

    public void reset() {
/*        player.setLevens(5);
        setScore(0);
        entities.clear();*/
        player = new Player(50, 50);
        // Al uw objecten
        entities = new ArrayList<Entity>();
        col = new Collision(this);
        entities.add(player);
        player.setY(stage.getHeight()-150);
    }

    public Iterator<Entity> getEntities() {
        return entities.iterator();
    }

    public ArrayList<Entity> getEntitiesArray() {
        return entities;
    }

    /**
     * Deze functie geeft de mogelijkheid om de speler terug te geven.
     *
     * @return De speler.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Deze functie maakt nieuwe bullets aan op de plaatsten waar nodig. Deze
     * bepaalt ook als het nodig is om een bullet te maken bij de tegenstanders.
     *
     * @param totalTime Dit is de totale tijd die de thread aan het lopen is.
     */
    public void addBullets(long totalTime) {
        ArrayList<Entity> bullets = new ArrayList<Entity>();
        Bullet p = new Bullet(player.getX() + player.getBreedte() / 2, player.getY() - 5, true);
        entities.add(p);
        if (upgradeOn) {
            Bullet ul = new Bullet(player.getX() - 10 + player.getBreedte() / 2, player.getY() - 5, true);
            entities.add(ul);
            Bullet ur = new Bullet(player.getX() + 10 + player.getBreedte() / 2, player.getY() - 5, true);
            entities.add(ur);
            upgradeTijd++;
            if (upgradeTijd > 15) {
                setUpgradeOn();
            }
        }

        for (Entity en : entities) {
            if (en instanceof Enemy && totalTime % 1500 == 0) {
                Bullet be = new Bullet(en.getX() + en.getBreedte() / 2, en.getY() + 50, false);

                bullets.add(be);

            }
        }
        entities.addAll(bullets);
    }

    /**
     * Deze functie maakt een nieuwe Enemy aan.
     *
     * @param x De X positie van de Enemy.
     * @param breedte De breedte die de Enemy moet aan nemen.
     */
    public void addEnemy(double x, double breedte) {
        Enemy e = new Enemy(x, 20, breedte, 20);
        e.setdy(2);
        entities.add(e);
    }

    /**
     * Deze functie maakt een nieuwe Upgrade aan.
     *
     * @param x De X positie van de Upgrade.
     * @param breedte De breedte die de Upgrade moet aan nemen.
     */
    public void addUpgrade(double x, double breedte) {
        Upgrade u = new Upgrade(x, 20, breedte, 20);
        u.setdy(3);
        entities.add(u);
    }

    /**
     * Deze functie laat de Player bewegen.
     *
     * @param e Het KeyEvent wat gemaakt is.
     */
    public void KeyEvent(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                case Q: // Azerty
                    player.setdx(-5);
                    break;
                case RIGHT:
                case D:
                    player.setdx(5);
                    break;
                case ESCAPE:
                    // Escape -> Close game
                    controller.showMenu(true);
                    break;
                case S:
                    toJson();
                    break;
                /*case L:
                    load();
                    break;*/
            }
        } catch (Exception a) {
        }
    }

    /**
     * Deze functie laat de Player stoppen met bewegen.
     *
     * @param e Het KeyEvent wat gemaakt is.
     */
    public void deKeyEvent(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                case Q:
                case RIGHT:
                case D:
                    player.setdx(0);
                    break;
               
            }
        } catch (Exception a) {
        }
    }
    
    public void stopSpel() {
        stage.close();
    }

    /**
     * Deze functie geeft de score.
     *
     * @return De score
     */
    public int getScore() {
        return score;
    }

    /**
     * Met deze functie kan er een nieuwe score gemaakt worden.
     *
     * @param newScore De nieuwe score.
     */
    public void setScore(int newScore) {
        if (newScore <= 0) {
            this.score = 0;
        } else {
            this.score = newScore;
        }
    }

    /*
    *setter upgrade status
     */
    public boolean setUpgradeOn() {
        
            
        if (upgradeOn == false) {
            upgradeOn = true;
        } else {
            upgradeOn = false;
        }
        return upgradeOn;
    }
    public void upgrade(){
        double upgradeNr = Math.random()*2;
        upgradeTijd = 0;
        if (upgradeNr <= 1){
            setLevens(10);
        }
        else if (upgradeNr <= 2){
            setUpgradeOn();
        }
    }

    public void setController(GameController controller) {
        this.controller = controller;
        
    }
    
     public void setStage(Stage stage) {
        this.stage = stage;
        player.setY(stage.getHeight()-150);
        
    }
    /**
     * Deze haalt de mee gegeven Entity uit de lijst.
     *
     * @param eRemove De te verwijderde Entity.
     */
    public void remove(Entity eRemove) {
        entities.remove(eRemove);
    }

    /**
     * Deze functie geeft de levens die de speler nog overheeft.
     *
     * @return Het aantal levens.
     */
    public int getLevens() {
        return player.getLevens();
    }

    /**
     * Deze functie laat toe de levens te veranderen naar een andere waarde.
     *
     * @param levens De nieuwe hoeveelheid levens.
     */
    public void setLevens(int levens) {
        player.setLevens(levens);
    }

    public void toJson() {
        saving = true;
        try {
            Entity[] lijst = new Entity[entities.size()];
            int i = 0;
            for (Entity e : entities){
                lijst[i] = e;
                i++;
            }
            Gson gsonobject = new Gson();
            String json = gsonobject.toJson(lijst);
            System.out.println(json);
            JsonWriter schrijver = gsonobject.newJsonWriter(new FileWriter("dc.json.txt"));
            schrijver.jsonValue(json);
            schrijver.close();

        } catch (IOException ex) {
            System.out.println("Error");
        }
        saving = false;

    }

    public boolean isSaving() {
        return saving;
    }

    public void load() {

        try {
            /*
            JsonReader fileReader = new JsonReader(new FileReader("dc.json.txt"));
            Gson gson = new Gson();
            Player newPlayer = gson.fromJson(fileReader, Player.class);
            entities.remove(player);
            player = newPlayer;
            entities.add(player);
            */
            
            
            
            GsonBuilder gsonBouwer = new GsonBuilder();
            
            gsonBouwer.registerTypeAdapter(Entity.class, new EntityDeserialiser());
            
            Gson gson = gsonBouwer.create();
            
            FileReader file = new FileReader("dc.json.txt");
            
            ArrayList nieuw = gson.fromJson(file, ArrayList.class);
            
            
            System.out.println(entities);
            
            entities = (ArrayList<Entity>) nieuw;
            
            System.out.println(nieuw);
            
            for (Entity e : entities){
                if (e instanceof Player){
                    player = (Player) e;
            }
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("error");
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
