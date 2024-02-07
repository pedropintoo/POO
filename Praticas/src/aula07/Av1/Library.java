package aula07.Av1;


import java.util.ArrayList;
import java.util.Scanner;

public class Library implements ILibrary{
    public static Scanner scanner = new Scanner(System.in);
    public ArrayList<LibraryItem> allItems = new ArrayList<>();

    @Override
    public void addItem(LibraryItem item) {
        allItems.add(item);
    }

    @Override
    public void removeItem(LibraryItem item) {
        if(allItems.contains(item))
            allItems.remove(item);
    }

    @Override
    public LibraryItem searchForItem(String title) {
        for(LibraryItem item : allItems){
            if(item.getTitle().equals(title)) return item;
        }
        return null;
    }

    @Override
    public boolean borrowItem(int itemId) {
        String nameReq;
        for(LibraryItem item : allItems){
            if(item.getItemId() == itemId && item.isAvailable()) {
                System.out.print("Name to requisition: ");
                nameReq = scanner.nextLine();

                item.checkoutItem(nameReq);
                System.out.println("Book has borrow!");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean returnItem(int itemId) {
        for(LibraryItem item : allItems){
            if(item.getItemId() == itemId && !item.isAvailable()) {

                item.returnItem();
                System.out.println("Book has return!");
                return true;
            }
        }

        return false;
    }

    @Override
    public void printInventory() {
        for(LibraryItem item : allItems){
            System.out.println(item);
        }
    }

}
