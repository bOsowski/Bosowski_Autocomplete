# Bosowski_Autocomplete

The Autocomplete program reads a text from the url file, sorts, deletes duplicates and prints the weighted terms.

The WordList class creates a wordlist arraylist, storing line objects filled with the weight and word from for each line in the URL.
It inculdes a sorting algorithm and one for removing duplicates.

The line class is basically a wrapper class.

The BruteAutocomplete class calls the sorting and removing duplicates methods from its constructor only once at the start of the program, after the wordlist has been filled out with terms from the URL.
It's responsible for returning the required words.

The Driver talks to the user and handles exceptions associated with wrong iput.



All the tests work.

The LineTest tests all the methods in the class. Tests with negative weights, nulls etc.

The WordListTest tests all the methods in the class, making sure all duplicates are removed by testing with large enough amount of duplicates and the sorting works properly.

The BruteAutocomplete checks the words after parsing them, against the words as they are on the URL page. All the methods are tested.
