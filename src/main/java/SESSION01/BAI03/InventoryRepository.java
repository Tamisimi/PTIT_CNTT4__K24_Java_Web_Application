package SESSION01.BAI03;

public interface InventoryRepository {
    int getStock(String foodName);
    void reduceStock(String foodName, int quantity);
}
