package com.text2sql.llm.labor.langchain;

import com.text2sql.llm.labor.business.concretes.OrderManager;
import com.text2sql.llm.labor.entities.*;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class Lang4jTools {

    private final OrderManager service;

    public Lang4jTools(OrderManager service) {
        this.service = service;
    }

    @Tool("Return the orders from the table Orders")
    public List<Order> getOrders() throws ParseException {
        //return service.getAll();
        List<Order> orders = new ArrayList<>();
        Order order1 = createObject();
        orders.add(order1);
        return orders;

    }


    public Order createObject() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Employee employee = new Employee();
        employee.setEmployeeId(30);

        Customer customer = new Customer();
        customer.setCustomerId(25); // Assuming there is an id field and a setter for it

        Shipper shipper = new Shipper();
        shipper.setId(1); // Assuming there is an id field and a setter for it

        OrdersTaxStatus taxStatus = new OrdersTaxStatus();
        // Assuming OrdersTaxStatus has a suitable constructor or setters
        taxStatus.setId((byte) 3); // Assuming there is an id field and a setter for it

        OrdersStatus status = new OrdersStatus();
        // Assuming OrdersStatus has a suitable constructor or setters
        status.setId((byte) 3); // Assuming there is an id field and a setter for it

        // Create the Order object
        Order order = new Order();
        order.setOrderId(76);

        order.setEmployee(employee);
        order.setCustomer(customer);
        order.setOrderDate(dateFormat.parse("2006-06-05 00:00:00"));
        order.setShippedDate(dateFormat.parse("2006-06-05 00:00:00"));
        order.setShipper(shipper);
        order.setShipName("John Rodman");
        order.setShipAddress("789 25th Street");
        order.setShipCity("Chicago");
        order.setShipStateProvince("IL");
        order.setShipZipPostalCode("99999");
        order.setShipCountryRegion("USA");
        order.setShippingFee(new BigDecimal("5.0000"));
        order.setTaxes(new BigDecimal("0.0000"));
        order.setPaymentType("Cash");
        order.setPaidDate(dateFormat.parse("2006-06-05 00:00:00"));
        order.setNotes("");
        order.setTaxRate(0.0);
        order.setTaxStatus(taxStatus);
        order.setStatus(status);

        // Print the created Order object
        //System.out.println(order);
        return order;
    }

}
