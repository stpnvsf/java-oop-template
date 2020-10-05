package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository{
    private Author[] authors = new Author[1000];
    private int quantity = 0;
    private int ind = 0;
    @Override
    public boolean save(Author author) {
        if(this.findByFullName(author.getName(),author.getLastName()) != null) {
            return false;
        }
        else{
            quantity++;
            authors[ind] = author;
            ind = quantity;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for(int i = 0; i < quantity; i++){
            if(authors[i].getName().equals(name) && authors[i].getLastName().equals(lastname)){
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        int length = quantity;
        for(int i = 0; i < length; i++){
            if(authors[i].equals(author)){
                ind = i;
                authors[i] = null;
                quantity--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return quantity;
    }
}
