# Share-Book
This the restful web application made by java and springboot frameword where you can find second hand books for less 
price. Those who have books that doesn't need can sell them to our repositorykeeper and 
the book will be placed online for sell.
All you need to do to use this site is creating an account and you can start using the service.

## How To Run
For running application head to the target folder and run `ap-0.0.1-SNAPSHOT.jar` that should run the program for you.

## Features
### Adding book to repository
For adding book to repository `addBook` method is mapped to `http://127.0.0.1/book/add` that receives a post request 
and saves the received book in database.
### Searching for book in repository
For finding a book in repository `findBook` method is mapped to the end point `http://127.0.0.1/book/add` witch receives
a get request with parameters ("name" and "type") of type String this method calls `findBookByNameContaining` or 
`findBookByNameContaining` method of the interface BookRepository and fetch the data needed from the database and sends
it in a json array.
### Charge account
For charging account of a user `chargeAccount` method is mapped to the end point `http://127.0.0.1/user/charge/{user_id}`
which receives post request with the path variable parameter `user_id` and a parameter `amount` then this method calls 
get the user by its id from database and calls chargeAccount method of it and sends the `amount` value as argument then
it saves the changes to the database by calling userRepository.save() method.
### Getting information of one book by id
For doing this `find` method in `BookController.java` is called which is mapped to the end point 
`http://127.0.0.1/book/{book_id}/get-information` and receives get request this method calls the bookRepository.findById()
method and returns the result if this book exists in the repository.
### Adding Book To basket
For adding book to basket `userController.addToBasket` method which is mapped to the end point `http://127.0.0.1/user/add-book`
and receives post requests this method receives two parameters (book_id and user_id) and adds the book to the user's 
shopping basket and sets the book's `inBasket` field to false and saves changes to database.
### Get basket Books
The user can see what's in his shopping basket. The method `viewHistory` of userController which is mapped to the end point
`http://127.0.0.1/user/history/{user_id}` and receives `user_id` as path variable then finds the user from database and returns
its purchases as an Iterable<Purchase> in json array.
### Purchase
After that you have selected the books you want to buy you can purchase them. The method purchase of UserController class 
is mapped to the end point `http://127.0.0.1/user/purchase/{user_id}` and it calls the method purchase of the user that 
is specified with the id which subtracts the basketPrice from account balance and sets basketPrice to zero. And saves 
changes to the database.
