
**Layout**


Every tile has an instance of an object. These hold the data. 
the actual nodes on the bord only get the data they need to display correct information, and a backreference (id) to their corresponding object.
This is done separate concerns. It is not a good idea to put all bussines logic and data in the 
view itself.