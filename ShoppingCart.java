/**
 * ShoppingCart.java - implementation of a bag that simulates real world obj of
 * a shopping
 * 
 */
public class ShoppingCart<T> {
    // PROPERTIES
    private ArrayBag<T> bag; // bag property used to implement all featutres of bag
    private final static int DEFAULT_CAP = 20;
    private final static int MAX_CAP = 10000; // maximum space in the bag we implement
    private boolean integrityOK; // flag value

    // CONSTRUCTOR METHODS
    // default constructor - creates empty bag inside of out shoppingcart with
    // DEFUALT_CAP
    public ShoppingCart() {
        this(DEFAULT_CAP);
    }

    // parameterized constructor - creates empty bag inside the shopping cart with
    // given capacity
    public ShoppingCart(int cap) {
        integrityOK = false; // false at start if block doesn't run successfully val remain same

        // if input is too small =>> bag has default capicty
        if (cap <= 0) {
            bag = new ArrayBag<T>(DEFAULT_CAP);
        } else if (cap <= MAX_CAP) { // if input is lessthan or equal to max allowed then make it
            bag = new ArrayBag<T>(cap);
        } else { // throw error if passed capcity
            throw new IllegalStateException("Cart capcity exceeds max value allowed");
        }
        integrityOK = true; // block ran successfully so we are good
    }

    // HELPER METHODS

    // checkIntegrity() - helper method to esure that data is being moved without
    // error between methods
    private void checkIntegrity() {
        // if the integrity check is false then throw error
        if (!integrityOK) {
            throw new SecurityException("DATA OF SHOPPING CART IS CORRUPT");
        }
    }

    // toArray() - calls bag's to array method to return an array version of the
    // contents of the bag
    // @return array of contents of the bag
    public T[] toArray() {
        return bag.toArray();
    }

    // SHOPPING CART METHODS

    // Adds new entry inside of the bag of the cart calls the bags method for
    // addition
    // @param newEntry - the object to be added
    // @return TRUE if successful addition, FALSE if not
    public boolean add(T newEntry) {
        checkIntegrity();
        integrityOK = false;
        bag.add(newEntry);

        integrityOK = true;
        return true;
    }

    // Removes entry from the last index of the bag calls the bags method to remove
    public void remove() {
        checkIntegrity();
        integrityOK = false;
        bag.remove();
        integrityOK = true;
    }

    // Removes a specified entry from the bag - calls method from bag class
    public void remove(T anEntry) {
        checkIntegrity();
        integrityOK = false;
        bag.remove(anEntry);
        integrityOK = true;
    }

    // SHOPPING CART SPECIFIC METHODS

    // Adds duplicates of an etry for amount times
    // @param amount - the amount of items to add
    // @param newEntry - the entry to add
    // @return - TRUE if successful addition false if not
    public boolean add(int amount, T newEntry) {
        checkIntegrity();
        integrityOK = false;
        // if there is nothing to add or a negative number the return false
        if (amount <= 0) {
            return false;
        }
        // repeat the add method for the amount that the user specifies
        int i = 0;
        while (i != amount) {
            bag.add(newEntry);
            i++;
        }
        integrityOK = true;
        return true;
    }

    // cartPrice() - helper method to get the price of the items in the bag
    // @return - a double of the price formated 00.00
    private double cartPrice() {
        int price = 0;
        T[] cartBag = bag.toArray(); //create a copy of the to avoid it interfering with other methods
        for (int i = 0; i < cartBag.length; i++) {
            Item item = (Item) cartBag[i]; //cast item to obj of the cartbag
            price += item.getPrice(); //get the price of the item
        }
        double f_price = Float.parseFloat(price / 100 + "." + price % 100); //format price 00.00
        return f_price;
    }

    // remove item from bag in cart and sums up the total price of items
    public void checkOut() {
        checkIntegrity();
        integrityOK = false;
        System.out.println("Total price of cart: $" + (float) cartPrice());
        bag.clear(); //empty out the bag after checkout
        integrityOK = true;
    }

    // checks if budget is enough to afford total price of cart
    // @param budget - the total price the cart price should be undet
    // @return - true if the budget is enough and false if not
    public boolean checkBudget(Double budget) {
        checkIntegrity();
        integrityOK = false;
        while (!bag.isEmpty()) {
            if (cartPrice() > budget) {
                System.out.println("Cannot afford budeget");
                System.out.println("Removed:" + bag.remove());
            } else {
                System.out.println("Budget affordable");
                integrityOK = true;
                return true;
            }
        }
        return false;
    }

}
