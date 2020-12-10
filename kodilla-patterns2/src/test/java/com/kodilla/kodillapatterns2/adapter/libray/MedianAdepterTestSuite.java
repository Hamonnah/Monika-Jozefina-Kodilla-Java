package com.kodilla.kodillapatterns2.adapter.libray;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdepterTestSuite {

    @Test
    public void testMedian() {

        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Book book1 = new Book("James McBride", "Deacon King Kong", "1234", 2019 );
        Book book2 = new Book("Marcel Proust", "Swanns Way", "9123", 1913);
        Book book3 = new Book("James Joyce", "Ulysses", "4321",1904);
        Book book4 = new Book("Maggie O’Farrell", "Hamnet", "5678", 2020);
        Book book5 = new Book("Harper Lee", "To Kill Mockingbird", "5678", 1960);

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        //When
        int median = medianAdapter.publicationYearMedian(books);

        //Then
        Assert.assertEquals(1960, median);
    }

}
