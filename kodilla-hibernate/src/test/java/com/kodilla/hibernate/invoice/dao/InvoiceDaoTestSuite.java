package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Table");
        Product product2 = new Product("Bed");
        Product product3 = new Product("Lamp");

        Item item1 = new Item(product1, new BigDecimal(1430),1, new BigDecimal(1430));
        Item item2 = new Item(product2, new BigDecimal(4350),1, new BigDecimal(4350));
        Item item3 = new Item(product3, new BigDecimal(200),10, new BigDecimal(2000));

        Invoice invoice1 = new Invoice("PN102102020");
        Invoice invoice2 = new Invoice("PN202102020");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item3);
        invoice2.getItems().add(item2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int invoice1Id = invoice1.getId();
        int invoice2Id = invoice2.getId();
        Optional<Invoice> readInvoice = invoiceDao.findById(invoice1Id);

        //Then
        Assert.assertTrue(readInvoice.isPresent());
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);

        //CleanUp
        invoiceDao.deleteById(invoice1Id);
        invoiceDao.deleteById(invoice2Id);


    }

}
