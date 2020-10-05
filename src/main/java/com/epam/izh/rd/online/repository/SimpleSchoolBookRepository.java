package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[1000];
    private int quantity = 0;
    private int ind = 0;

    @Override
    public boolean save(SchoolBook book) {
        try{
            quantity++;
            schoolBooks[ind] = book;
            ind = quantity;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public SchoolBook[] findByName(String name) {
        int q = 0;
        for (int i = 0; i < quantity; i++) {
            if(schoolBooks[i].getName().equals(name)) {
                q++;
            }
        }
        if(q > 0){
            SchoolBook[] sb = new SchoolBook[q];
            for (int i = 0; i < quantity; i++) {
                if(schoolBooks[i].getName().equals(name)) {
                    sb[i] = schoolBooks[i];
                }
            }
            return sb;
        }
        else {
            return new SchoolBook[0];
        }
    }
    @Override
    public boolean removeByName(String name) {
        int k = 0;
        int length = quantity;
        for(int i = 0; i < length; i++)
        {
            if(schoolBooks[i].getName().equals(name))
            {
                ind = i;
                schoolBooks[i] = null;
                quantity--;
                k++;
            }
        }
        return k != 0;
    }

    @Override
    public int count() {
        return quantity;
    }
}
