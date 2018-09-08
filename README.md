# Auswendig
!This project is a work-in-process, I would like feedback! 

 Information
Auswendig is memorisation software built using Netbeans and written in Java. It is inspired from Quizlet and Anki. 
I am currently writing Auswendig by myself, it is a year-long project that will hopefully produce a flexible memorisation software with     multipe activities - Learn (regular flashcards), Starred (starred flashcards only), *Leitner* (flashcards sorted and displayed by a    user's   familiarity with them), Listen (a user must write what they hear), Write (a user writes the definition/term of a flashcard) and True/False (a user is asked whether the definition of a term is the correct one for that card).

 Context
One set contains multiple cards (a maximum of 200 so far).
Multiple sets can be placed in a "folder".
Cards can be rated on familarity - making cards appear a set amount of days after review.
Cards can be starred.

 Folders
Creating a set places that set within a "Sets" folder.
Creating a folder (technically a set containing multiple sets) places that folder within a "Folder" folder.
Starring a card creates a starred set of the original in the "Starred" folder.
Rating cards with the Leitner system creates a Leitner set of the original in the "Leitner" folder.
The "res" (resources) folder contains icons used in drop-down menus.

 Notes
Currently directories for saving and reading files are hard-coded only for my directory, this will be changed.
Optimisation for reading files will be done, the way I have done it makes reading many cards slow.

*Leitner System: https://en.wikipedia.org/wiki/Leitner_syste
