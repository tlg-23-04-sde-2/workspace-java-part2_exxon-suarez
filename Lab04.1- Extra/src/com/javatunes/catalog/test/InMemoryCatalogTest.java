/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
//         testFindById();
        // testFindByKeyword();
//         testFindByCategory();
         testSize();
//         testGetAll();
        // selfTitleAlbums()
    }

    public static void selfTitleAlbums() {

    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();        //create an instance of your InMemoryCatalog // This is the new collection that you are creating to hold the things you find
        MusicItem itemFound = catalog.findById(6L);             // declare a new itemFound variable that is the record found at 6L id  in the MusicItem collection
        System.out.println(itemFound);
        MusicItem itemNotFound = catalog.findById(19L);
        System.out.println(itemNotFound);
    }

    private static void testFindByKeyword() {
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();        // reate new instance of InMemoryCatalog named catalog
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);        // declare Collections item that holds every catalog item that has a catagory of POP
        System.out.println(items);


    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("The size of this array is: " + catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog);
    }


}