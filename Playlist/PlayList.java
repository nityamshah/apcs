import java.util.Arrays;

public class PlayList
{
	/** Song[] array list instance variable*/
   private Song[] list;
	
	/** default constructor used to set the instance variables to default values*/
   public PlayList()
   {
   	// make a list of length 1
      list = new Song[1];
   	
   	// Then make sure you add 1 song (using default constructor) to the list at index 0
      list[0] = new Song();
   }
	
	/** initialization constructor used to set the instance variables
		* @param x the length of the playlist */
   public PlayList(int x)
   {
   	// instantiate a playlist of the provided length
      list = new Song[x];
   }
	
	/** modifier method to set the instance variable list
		* @param x the length of the playlist*/
   public void setList(int x)
   {
   	// this should set the length of the playlist
      Song[] newList = new Song[x];
      list = newList; 
   }
	
	/** accessor method to get the entire playlist
		* @return return the entire playslist as a Song[] array*/
   public Song[] getList()
   {
      return list;
   }
	
	/** method to add a song to the playlist
		* @param x the position in the playlist to add the song
		* @param s the song to add to the playlist*/
   public void addSong(int x, Song s)
   {
       /*  method to add a song to the playlist at the position indicated 
             + the first song in the playlist is at x = 0
             + if there is a null reference at x, add the song at location x
             + if there is a song at x, shift the songs at position x and beyond by 1 position and insert song at location x.
             + if x is larger then the last array position, insert the song at the end of the playlist (i.e. make the array one position larger) */
   	/* you need to check to make sure the array is big enough to add the song
   	   if it is not big enough you will need to create a large enough array
   		   and then transfer the songs to the new array before assigning the new
   		   array back to the list array*/
      if ((x < list.length) && list[x] == null){
         list[x] = s;
      }
      else if (x > list.length - 1){
         Song[] newList = new Song[list.length + 1];
         for (int i = 0; i < list.length; i++){
            newList[i] = list[i];
         }
         newList[newList.length - 1] = s;
         list = newList;
      }	  
      else if (list[x] != null){
         Song[] newList = new Song[list.length + 1];
         for (int i = 0; i < x; i++){
            newList[i] = list[i];
         }
         for (int i = x; i < list.length; i++){
            newList[i+1] = list[i];
         }
         newList[x] = s;
         list = newList;
      } 
   }
	
	/** method to get a song from the playlist
		* @param x the position in the playlist to get the song from
		* @return return the song in the position specified*/
   public Song getSong(int x)
   {
      return list[x];
   }
	
	/** method to get the number of songs in the playlist
		* @return return the number of songs in the playlist*/
   public int numSongs()
   {
      return list.length;
   }
	
	/** method to get the total length of the playlist specified in seconds
		* @return return the length of the playlist in seconds*/
   public int totalLength()
   {
   	/* before accessing the length of an individual song you should ensure that the 
   			song reference is not null*/
      int length = 0;
      for (int i = 0; i < list.length; i++){
         if(list[i] != null){
            length += list[i].getSongLength();
         }
      }
      return length;
   }
	
	/** method to remove any songs from the specified artist
		* @param ar the artist of the songs to remove from the playlist*/
   public void removeArtist(String ar)
   {
   	/* to remove the songs with the specified artist you will first need to count the
   			occurances of that artist. 
   			Then you will need to create a new smaller array
   			Then you can copy the songs to the new array excluding the ones from the artist*/
      int numArtist = 0;
      for (int i = 0; i < list.length; i++){
         if(list[i] != null && list[i].getArtist().equals(ar)){
            numArtist++;
         }
      }
      Song[] newList = new Song[list.length - numArtist];
      int positionInNewList = 0;
      for (int i = 0; i < list.length; i++){
         if(list[i] != null && !(list[i].getArtist().equals(ar))){
            newList[positionInNewList] = list[i];
            positionInNewList++;
         }    
      }
      list = newList;
   }
	
	/** method to remove any songs longer than the length specified
		* @param length length of songs to removed given in seconds*/
   public void removeLength(int length)
   {
   	// same as method above with creating a smaller array
      int numTooLong = 0;
      for (int i = 0; i < list.length; i++){
         if(list[i] != null && list[i].getSongLength() > length){
            numTooLong++;
         }
      }
      Song[] newList = new Song[list.length - numTooLong];
      int positionInNewList = 0;
      for (int i = 0; i < list.length; i++){
         if(list[i] != null && list[i].getSongLength() <= length){
            newList[positionInNewList] = list[i];
            positionInNewList++;
         }    
      }
      list = newList;
   }
	
	/** method to shuffle the order of the playlist - use the card shuffling example from the arrays presentation to help*/
   public void shuffle()
   {
   	// use the card shuffling example from the arrays presentation to help you with this
      int n = list.length;
      for(int i = 0; i < n; i++){
         int exchange = i+(int)(Math.random()*(n-i));
         Song temp = list[i];
         list[i] = list[exchange];
         list[exchange] = temp;
      }	
   }
	
	/** equals method to determine if two playlists are equal
	 * The base class for all classes instantiated into objects in Java is "Object"
		* @param obj the object to be compared
		* @return return true or false if the playlists are equal*/
   public boolean equals(Object obj)
   {
      PlayList pl = (PlayList)obj;
      if(!Arrays.equals(list, pl.getList()))
         return false;
      return true;
   }
	
	/** toString() method to get the instance variables
		* @return return a String containing the instance variablees*/
   public String toString()
   {
      return Arrays.toString(list);
   }
}
