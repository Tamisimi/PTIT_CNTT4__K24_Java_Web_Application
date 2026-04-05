package SESSION01.BAI03;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}
