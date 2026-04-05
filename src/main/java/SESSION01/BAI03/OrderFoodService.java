package SESSION01.BAI03;

import org.springframework.stereotype.Service;

@Service
public class OrderFoodService {

    private final InventoryRepository inventoryRepository;
    private final UserAccountRepository userAccountRepository;

    // Constructor Injection
    public OrderFoodService(InventoryRepository inventoryRepository,
                            UserAccountRepository userAccountRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public String orderFood(String username, String foodName, int quantity) {

        int stock = inventoryRepository.getStock(foodName);
        if (stock < quantity) {
            return "Hết hàng";
        }

        double price = 20000;
        double total = price * quantity;

        double balance = userAccountRepository.getBalance(username);
        if (balance < total) {
            return "Không đủ tiền";
        }

        userAccountRepository.deductBalance(username, total);
        inventoryRepository.reduceStock(foodName, quantity);

        return "Đặt món thành công";
    }
}
