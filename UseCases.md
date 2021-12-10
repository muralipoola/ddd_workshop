#com.ddd.workshop.domain

- have a domain package
- application/driver package

###Problem#1 : Add a “IPad Pro” to a Cart
Note: Please do not model/use User class

###Problem#2: Add a “Hero ink Pen” to a Cart

###Problem#3: Add 2 qty of  “GM Cricket bat” to Cart.
- Agree on domain language

###Problem#4: Remove already added Item “IPad Pro”( with all quantities)  from cart.

###Problem#5: As a business User I would like to know which Products ( product name) were deleted from Cart.

###Problem#6: As a business User, I would like to differentiate between two Carts.
*  Two carts where items are same, equality on Carts should return false

>Cart cart1 = new Cart();
>Cart cart2 = new Cart();

>Item item1 = new Item(new Product("Ipad"), 1);
>Item item2 = new Item(new Product("Ipad"), 1);

>cart1.addItem(item1);
>cart2.addItem(item2);

>cart1.equals(cart2)  should be false*

###Problem#7: Add Price to product

Notes: Java.Util.Currency ==> Currency.getInstance("USD")
> new Product("Ipad Pro", new Price(...));

###Problem #8 -  As a Business User I would like price my product 10% below competitor price 
(competitor price is available for product) .
Assume that HashMap of Competitor Product Name and price is available.                                                                                                           
Competitor name matches 1  to 1 with our Product Name

>new Product( "name", Price(discountedPrice, "USD"))

>new Product( "name", Price(10, "USD"))


###Problem #9  Create Order( with Products) when Cart is checked out. Also Mark cart as checked out .  
While Creating Order please do not use Item class but use Product class. Flatten out products in Item.
= new Order( List<Product> products)

###Problem #10 - Customer and Bank Account
When Customer’s Address is updated, update her all Bank Accounts address as well. 
(example of invariant or business rules or consistency rules)

Customer is Entity
Account Is Entity
Customer has List of bank accounts
Customer has Address
Account has Address
Address has one attribute called City
Address is Value Object
----  customer.updateAddress(address)

###Problem #11 - Calculate Total cost for the Order.  Put shipping cost as per weight
Total cost = cost of all products in order + (weightIngrams of each product *.01)