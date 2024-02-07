package aula07.Av1;

public class LibraryItem {
    private int itemId;
    private String title;
    private boolean available = true;
    private String nameReq = "";

    LibraryItem(String title){
        this.title = title;
        this.itemId = this.hashCode();
    }

    public void checkoutItem(String nameEmp){
        setAvailable(false);
        setNameReq(nameEmp);
        this.itemId = this.hashCode();
    }

    public void returnItem(){
        setAvailable(true);
        setNameReq("");
        this.itemId = this.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem that)) return false;

        if (getItemId() != that.getItemId()) return false;
        if (isAvailable() != that.isAvailable()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getNameReq() != null ? getNameReq().equals(that.getNameReq()) : that.getNameReq() == null;
    }

    @Override
    public int hashCode() {
        int result = getItemId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (isAvailable() ? 1 : 0);
        result = 31 * result + (getNameReq() != null ? getNameReq().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", nameReq='" + nameReq + '\'';
    }


    // Getters


    public String getNameReq() {
        return nameReq;
    }

    public String getTitle() {
        return this.title;
    }

    public int getItemId(){
        return this.itemId;
    }

    public boolean isAvailable() {
        return this.available;
    }

    // Setters


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setNameReq(String nameReq) {
        this.nameReq = nameReq;
    }


}
