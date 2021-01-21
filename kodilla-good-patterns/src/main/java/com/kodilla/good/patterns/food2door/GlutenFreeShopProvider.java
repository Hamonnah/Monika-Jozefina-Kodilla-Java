package food2door;

public class GlutenFreeShopProvider implements Provider {

    private final String name;
    private final String email;

    public GlutenFreeShopProvider(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean process(Order order) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlutenFreeShopProvider that = (GlutenFreeShopProvider) o;

        if (!name.equals(that.name)) return false;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GlutenFreeShopProvider{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
