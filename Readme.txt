Game arkavquarium ini dibuat untuk memenuhi tugas mata kuliah Object Oriented Programming IF2210.
Program ini dibuat dalam bahasa Java dengan menggunakan IDE Intellij. Selain itu menggunakan checkstyle Google checks.

Memulai permainan:
- Compile game Arkavquarium dengan "javac Main.java"
- Run program dengan "java Main"

Pada awal permainan, akan diberikan satu siput yang akan mengejar coin dan dua guppy level 1. Untuk membeli object pada game dengan menggunakan key:
F -- untuk membeli food
G -- untuk membeli guppy
P -- untuk membeli piranha
S -- untuk membeli snail/snail
E -- untuk membeli egg

Cara bermain:
Kumpulkan tiga egg sehingga menang. Apabila uang tidak cukup untuk membeli ikan, maka game akan berakhir.

classes:

	1. Object
		class abstract yang merupakan parent class dari semua class lain, memiliki method draw, move untuk mengakomodasi GUI tugas kedepannya. (semua object akan digambar, tapi tidak semua bergerak)

	2. Aquarium 
		extends object
		class aquarium berupa container / controller dari kelas kelas lain. (memiliki list of fish dan object object lainnya)
		class aquarium juga mengatur penciptaan dan pemusnahan object lain dalam aquarium

	3.  LinkedList
		class yang berupa class generic, berupa array / vector untuk menampung berbagai object dengan jenis yang sama
		digunakan dalam aquarium, sebagai container object
	
	4.	Coin 
		extends object implements moveable
		salah satu object dalam game, merepresentasikan coin yang di drop oleh ikan

	5.	Food
		extends object
		Salah satu object dalam game, merepresentasikan makanan yang di munculkan dalam aquarium

	6. 	Fish
		extends object
		class yang merupakan parent class dari semua class ikan ikan lainnya. 

	7.	Guppy 
		extends Fish implements AbleToSearch
		memiliki atribut growth level yang berbeda dengan ikan lainnya
		merepresentasikan ikan kuning / standar dalam game

	8.	Piranha
		extends Fish implements AbleToSearch
		merepresentasikan ikan piranha dalam game

	9.	Pet 
		extends object 
		merupakan parent class dari semua pet (karakter non ikan yang berfungsi membantu player dalam game)
		class dibuat untuk mengakomodasi apabila perlu dikembangkan pet yang lain

	10.	Siput
		extends Pet implements AbleToSearch
		merepresentasikan salah satu jenis pet yaitu snail (siput)

interfaces:
	1. Moveable
		Berisi method move untuk bergerak
		
	2. AbleToSearch
		Berisi method move untuk bergerak dan mencari objek dari parameter LinkedList

Made by:
Nella Zabrina Pramata - 13516025
Jessin Donnyson - 13516112
Nicholas Wijaya - 13516121
Maharani Devira Pramita - 13516142