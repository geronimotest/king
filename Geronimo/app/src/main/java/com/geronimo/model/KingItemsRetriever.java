package com.geronimo.model;

import java.util.List;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

public interface KingItemsRetriever {

    /**
     *
     * @return The available kings
     */
    public List<King> listKings();

    /**
     *
     * @return a new king
     */
    public King newKing();
}
