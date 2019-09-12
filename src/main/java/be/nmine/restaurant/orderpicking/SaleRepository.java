package be.nmine.restaurant.orderpicking;

public interface SaleRepository {

    void save(Sale sale);
    Sale getSale(int id);

}
