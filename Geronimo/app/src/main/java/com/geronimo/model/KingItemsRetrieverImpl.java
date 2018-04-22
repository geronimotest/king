package com.geronimo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

public class KingItemsRetrieverImpl implements KingItemsRetriever{
    private List<King> kings = new ArrayList();

    @Inject
    public KingItemsRetrieverImpl(){

    }

    @Override
    public List<King> listKings() {
        King viking = new King();
        viking.setDescription("Vikings");
        viking.setTitle("The king of Ragnar");
        viking.setPictureUrl("http://mythologian.net/wp-content/uploads/2013/05/ragnar-lothbrok-vikings-wallpaper-1024x576.png");

        King sangoku = new King();
        sangoku.setDescription("Daragon ball");
        sangoku.setTitle("The unbelievable king");
        sangoku.setPictureUrl("http://media.comicbook.com/2018/03/dragon-ball-super-1092519-1280x0.jpeg");

        King vainGlory = new King();
        vainGlory.setDescription("Vain Glory");
        vainGlory.setTitle("Yet another king");
        vainGlory.setPictureUrl("https://pre00.deviantart.net/e65f/th/pre/f/2016/177/5/3/ten_shin_han_by_wandertof-d9xtntb.jpg");




        kings.add(viking);
        kings.add(sangoku);
        kings.add(vainGlory);
        return kings;
    }

    @Override
    public King newKing() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
        return kings.get(randomNum%3);
    }
}
