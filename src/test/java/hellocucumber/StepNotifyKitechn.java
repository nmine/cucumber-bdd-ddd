package hellocucumber;

import be.nmine.restaurant.orderpicking.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;

public class StepNotifyKitechn {

    SaleRepository saleRepository = new SaleRepositoryInMemory();
    private Order order;
    private NotificationService notificationService = new NotificationServiceInMemory();

    @Given("waitress take an order {string} item of value {string}")
    public void waitress_take_and_order(String itemNumber,String itemValue) {
        Sale sale = new Sale();
        for(int i = 0; i < parseInt(itemNumber); i++) {
            int itemValueInt = parseInt(itemValue);
            Item item = new Item(itemValueInt);
            order = Order.from(item);
            sale.addOrder(order);
        }
        saleRepository.save(sale);
    }

    @When("the waitress introduces the order introduced in the system")
    public void the_waitress_introduces_the_order_in_the_system() {
        Notification notification = new Notification(saleRepository.getSale(id()).getOrders().get(first()));
        notificationService.notify(notification);
    }

    private int first() {
        return 0;
    }

    private int id() {
        return 1;
    }

    @Then("the Cooker is notified of the order {string} item")
    public void kitchen_is_notified(String itemNumber) {
        assertEquals(notificationService.getNotification().order.items.size(), parseInt(itemNumber));
    }
}