fun main() {
	wildHorses.printInfo()
    wildHorses.isPopular()
}

class Song(
    var title: String,
    var artist: String,
    var year: Int,
    var playCount: Int) {
	
    val isPopular: Boolean = if (playCount > 1000) true else false
    
    fun isPopular() {
        println("It would be a $isPopular statement to say that this was a popular song.")
    }
    
    fun printInfo() {
        println("\"$title\", performed by $artist, was released in $year.\n")
    }
}

// wildHorses IS-A Song
val wildHorses: Song = Song("Wild Horses", "The Flying Burrito Brothers", 1970, 1001)