package com.kodilla.stream.sand;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SandStorageTestSuite {

    @Test
    public void testGetSandBeansQuantity() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        //When
        BigDecimal totalSand = BigDecimal.ZERO;
        for(SandStorage continent : continents){
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }
        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assert.assertEquals(expectedSand, totalSand);
    }

    @Test
    public void testGetSandBeansQuantityWithReduce() {
        //Given uruchamiamy strumień na kolekcji continents
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        //When wynik przypiszemy do zmiennej totalSand typu BigDecimal
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)  //zmienia obiekty w strumieniu z klas reprezentujących kontynenty na liczby typu BigDecimal odpowiadające ilościom ziaren piasku na poszczególnych kontynentach
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current)); //wywołujemy kolektor skalarny reduce
        //wartość początkową otrzymuje BigDecimal.ZERO, a następnie dla każdej liczby w kolekcji wykonuje wyrażenie
        // lambda (sum, current) -> sum = sum.add(current), gdzie sum jest wynikiem pośrednim uzyskanym dla poprzedniego
        // obiektu w kolekcji (na początku przy pierwszym elemencie jest to BigDecimal.ZERO, czyli wartość początkowa identity).
        // Lambda przypisuje do zmiennej sum nową wartość będącą sumą dotychczasowych obliczeń i wartości current,
        // reprezentującej bieżący obiekt w strumieniu. Po dokonaniu obliczenia - wartość ta będzie przekazana do "następnego przebiegu" kolektora
        // jako nowa wartość pośrednia. Na końcu - po zakończeniu działania kolektora - obliczona suma jest zwracana do zmiennej totalSand.

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assert.assertEquals(expectedSand, totalSand);
    }

}
