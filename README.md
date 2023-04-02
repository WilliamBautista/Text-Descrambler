# Encrypting File Writer

This project was created as a way to add a extra layer of secuirty when accessing doucments such as .txt by encyrpting the file and all of its contents inside of it.

## Functions
* App has all the standard functions of a file editor except at the moment there is no GUI so all of it is done through command line/IDE at the moment
* Jasypt has been added to add a second layer of securiy by encrypting any and all text by using a password
* When attempting to view a text without the password, the text in the file will be repalced only be the encyrpted text and can only be accessed using the app
* Jasypt uses the included Java Cryptography Extension to create a message digest of the text
* The library uses the salt method and a iteration count of 1000 to encrypt the text
