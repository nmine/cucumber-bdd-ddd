package hellocucumber;

import be.nmine.restaurant.orderpicking.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.lang.Integer.*;
import static org.junit.Assert.assertEquals;

public class StepTakeOrder {
    SaleRepository saleRepository = new SaleRepositoryInMemory();

    @Given("{string} person takes an order {string} item of value {string}")
    public void person_take_and_order(String personNumber, String numberItem, String valueItem) {
        Order order = new Order();
        for (int i = 0; i < parseInt(numberItem); i++) {
            order.addItem(new Item(parseInt(valueItem)));
        }
        Sale sale = new Sale();
        for(int i = 0; i < parseInt(personNumber); i++) {
            sale.addOrder(order);
        }
        saleRepository.save(sale);
    }

    @When("the waitress introduces the order in the system")
    public void the_waitress_introduces_the_order_in_the_system() {
    }

    @Then("the system knows the order {string} items with value {string}")
    public void the_system_knwo_the_order(String expectedAnswer, String valueSalesExpected) {
        assertEquals(parseInt(expectedAnswer), saleRepository.getSale(1).getOrdersSize());
        assertEquals(parseInt(valueSalesExpected), saleRepository.getSale(1).getValue());
    }
}