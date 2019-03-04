import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    //Class fields
    private int width;
    private int height;

    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;

    //Class constructor
    public Arena(int width, int height) {
        hero = new Hero(10, 10);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
    }

    //Class methods
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        if(!(position.getX() >= 0 && position.getX() < this.width && position.getY() >= 0 && position.getY() < this.height)){
            return false;
        }
        return true;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#374A54"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        hero.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        if(key.getKeyType() != KeyType.Character){
            switch (key.getKeyType()){
                case ArrowDown: moveHero(hero.moveDown()); break;
                case ArrowUp: moveHero(hero.moveUp()); break;
                case ArrowRight: moveHero(hero.moveRight()); break;
                case ArrowLeft: moveHero(hero.moveLeft()); break;
            }
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < this.width; x++){
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height-1));
        }

        for (int y = 0; y < this.width; y++){
            walls.add(new Wall(0, y));
            walls.add(new Wall(width-1, y));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(new Coin(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
        while (coins.size() < 5) {
            Position pos = new Position(random.nextInt(width-2)+1, random.nextInt(height-2)+1);
            if(!(hero.getPosition().equals(pos))) {
                if (!(coins.get(coins.size()-1).getPosition().equals(pos))) {
                    /*for (Wall wall : walls) {
                        if (!(wall.getPosition().equals(pos))) {*/
                            coins.add(new Coin(pos.getX(), pos.getY()));
                   /*     }
                    }*/
                }

            }
        }
        return coins;
    }
}