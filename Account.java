public class Account {

    protected String accountId;
    protected String name;
    protected String phone;

    public Account() {
        this("ACC000", "Unknown", "0000000000");
    }

    public Account(String accountId, String name, String phone) {
        this.accountId = accountId;
        this.name = name;
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void register() {
        System.out.println("Account registered: " + accountId);
    }

    public void updateProfile(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String displayInfo() {
        return "Account ID: " + accountId +
                "\nName: " + name +
                "\nPhone: " + phone;
    }

    @Override
    public String toString() {
        return displayInfo();
    }
}
