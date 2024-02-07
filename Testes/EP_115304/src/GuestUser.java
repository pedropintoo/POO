public class GuestUser extends User{

    private static int idCount = -1;
    private UserType type;

    public GuestUser(String nome) {
        super(idCount--, nome);
        this.type = UserType.GUEST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuestUser guestUser)) return false;
        if (!super.equals(o)) return false;

        return getType() == guestUser.getType();
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
