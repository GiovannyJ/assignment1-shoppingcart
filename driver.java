/**
 * Testing class for all of the classes designed
 */

public class driver {
    public static void main(String[] args){
        //create a shopping cart
        // ShoppingCart groceries = new ShoppingCart<Item>();
        ShoppingCart groceries = new ShoppingCart<Item>();

        //create items
        Item apple = new Item("apple", 60);
        Item orange = new Item("orange", 50);
        Item milk = new Item("milk", 300);
        Item sugar = new Item("sugar", 200);
        Item toothpaste = new Item("toothpaste", 350);
        Item juice = new Item("juice", 400);

        //adding items
        System.out.println("\n-----ADDING ITEMS-----");
        groceries.add(apple);
        groceries.add(orange);
        groceries.add(milk);
        
        displayCart(groceries);
        

        //adding more items
        System.out.println("\n-----ADDING MORE ITEMS-----");
        groceries.add(sugar);
        groceries.add(toothpaste);
        
        displayCart(groceries);


        //adding item with specified amount
        System.out.println("\n-----ADDING 4 JUICE-----");
        groceries.add(4, juice);

        displayCart(groceries);
        
        // remove an item
        System.out.println("\n-----REMOVING LAST ITEM------");
        groceries.remove();
        
        displayCart(groceries);

        //remove specified item
        System.out.println("\n-----REMOVING SUGAR-----");
        groceries.remove(sugar);

        displayCart(groceries);

        //check buget
        System.out.println("\n-----CHECKING BUDGET OF 20-----");
        groceries.checkBudget(10.00);
        displayCart(groceries);
        
        //checkout items
        System.out.println("\n-----CHECKING OUT------");
        groceries.checkOut();
        displayCart(groceries);
        
        
    }

    public static void displayCart(ShoppingCart theCart)
    {
        System.out.println("Displaying contents of the cart");
        
        //use toArray() to get the contents
        Object[] data = theCart.toArray();
        if(data.length == 0){
            System.out.println("Cart is empty");
        }
        //use for loop to print each entry
        for (int i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }
    }
}
