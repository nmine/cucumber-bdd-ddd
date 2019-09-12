package be.nmine.restaurant.orderpicking;

public class SaleRepositoryInMemory implements SaleRepository {
    private Sale sale;

    @Override
    public void save(Sale sale) {
        this.sale = sale;
    }

    @Override
    public Sale getSale(int id) {
        return sale;
    }


}
