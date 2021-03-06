package game.collectibles;

import game.control.SoundManager;
import game.res.anim.CoinFlipAnim;
import javafx.animation.Animation;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

public class Coin extends Pane implements Collectible {

    private ImageView coin;
    private Animation coinFlip;
    private MediaPlayer coinCollect;

    public Coin(int x, int y) {
        this.setY(y);
        this.setX(x);
        coin = new ImageView(new Image("game/res/img/coin.png"));
        this.getChildren().add(coin);

        //Plays coin collect sound
        coinCollect = SoundManager.getSoundManager().getCoinCollect();

        //Plays coin flip animation
        coinFlip= new CoinFlipAnim(this);
        coinFlip.play();
    }

    //Setters
    public void setImage(Image image) {
        coin.setImage(image);
    }

    @Override
    public void setX (double x) {
        this.setTranslateX(x);
    }

    @Override
    public void setY (double y) {
        this.setTranslateY(y);
    }

    //Getters
    @Override
    public double getY() {
        return this.getTranslateY();
    }

    @Override
    public double getX() {
        return this.getTranslateX();
    }

    @Override
    public Bounds getBounds() {
        return this.getBoundsInParent();
    }

    @Override
    public void playSound() {
        coinCollect.setCycleCount(1);
        coinCollect.stop();
        coinCollect.play();
    }

}