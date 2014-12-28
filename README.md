# Caesar Cipher

A Caesar cipher is a method of encryption used all the way back to Caesar's day. It is one of the
simplest forms of encryption, so simple you could independently come up with it yourself at the 
age of 10. It involves taking a message and *shifting* each letter by a certain 'shift' distance.

For example if the shift is 3 and your entire message is "a b c" the encoded message would be "D E F".

## Why?
This little project does look very simple at face value and it is. The actual coding of the cipher
took no time at all. The purpose of writing this was

1. Getting some coding practice so I don't get rusty
2. To use it in another project that's slightly more interesting

The project was never intended to be difficult. In fact I did almost the same program as a first year
coding assignment nearly two years ago. To make it a little more interesting I also threw in a nice little
GUI to make it user friendly (I did intend to use it after all.)

##Usage
To fire it up simply clone the repo

`git clone https://github.com/jbatch/caesercipher.git`

`cd caesarcipher`

compile the code

`javac *.java` (I should add a quick makefile to this at some point)

and run it!

`java CaesarCipher`

<img src="http://puu.sh/dMdMD/e125ecf3cb.png">

The GUI will appear on your screen. From here usage is fairly self explanatory.
The message you want to encode goes in the message box. The shift value you
want to use to encode goes in the shift box and you hit *Encrypt*. That's all
there is to it.