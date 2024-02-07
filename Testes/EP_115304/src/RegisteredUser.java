public class RegisteredUser extends User{
    private static int idCount = 0;
    private UserType type;

    public RegisteredUser(String nome) {
        super(idCount++, nome);
        this.type = UserType.REGISTERED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredUser that)) return false;
        if (!super.equals(o)) return false;

        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public UserType getType() {
        return type;
    }
}
