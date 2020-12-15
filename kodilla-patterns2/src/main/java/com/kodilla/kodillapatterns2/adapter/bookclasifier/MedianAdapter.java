package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book> bookMap = new HashMap<BookSignature, com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book>();
        for (Book setBook : bookSet) {
            bookMap.put(new BookSignature(setBook.getSignature()), new com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book(setBook.getAuthor(), setBook.getTitle(), setBook.getPublicationYear()));
        }
        return medianPublicationYear(bookMap);
    }

}