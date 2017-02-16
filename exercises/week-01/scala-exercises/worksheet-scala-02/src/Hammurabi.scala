import scala.io.StdIn.readLine

object Hammurabi extends App {

  // For Testing in IDE
  hammurabi()

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _ : Throwable =>
        println("That’s not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def printIntroductoryMessage(): Unit = {

  println()
  println(
    """Congratulations, you are the newest ruler of ancient Samaria, elected
    |for a ten year term of office. Your duties are to dispense food, direct
    |farming, and buy and sell land as needed to support your people. Watch
    |out for rat infestations and the plague! Grain is the general currency,
    |measured in bushels. The following will help you in your decisions:
    |
    |  * Each person needs at least 20 bushels of grain per year to survive.
    |  * Each person can farm at most 10 acres of land.
    |  * It takes 2 bushels of grain to farm an acre of land.
    |  * The market price for land fluctuates yearly.
    |
    |Rule wisely and you will be showered with appreciation at the end of
    |your term. Rule poorly and you will be kicked out of office!""".stripMargin)
    println()
   }

  def hammurabi(): Unit = {

    var starved = 0               // how many people starved
    var immigrants = 5            // how many people came to the city
    var population = 100
    var harvest = 3000            // total bushels harvested
    var bushelsPerAcre = 3        // amount harvested for each acre planted
    var rats_ate = 200            // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19         // each acre costs this many bushels
    var plagueDeaths = 0

    var foodPerPerson = 20        // annual food (20 bushels per year for 1 person)
    var costToPlantInBushels = 2  // how much it costs to plant per acres of land
    var landFarmedPerPerson = 10  // each person can farm 10 acres

    printIntroductoryMessage()

    for (year <- 1 to 10) {


      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned = acresOwned + acresToBuy
      bushelsInStorage = bushelsInStorage - (acresToBuy * pricePerAcre)

      val notBuying: Boolean = acresToBuy == 0

      if (notBuying) {
        var acresToSell = askHowMuchLandToSell(acresOwned, pricePerAcre)
        acresOwned = acresOwned - acresToSell
        bushelsInStorage = bushelsInStorage + (acresToBuy * pricePerAcre)
      }

      var grainsToFeed = askHowMuchToFeedPeople(population, bushelsInStorage)
      bushelsInStorage = bushelsInStorage - grainsToFeed

      var acresToFarm = askHowManyAcresToPlant(acresOwned, bushelsInStorage, population, costToPlantInBushels, landFarmedPerPerson)
      bushelsInStorage = bushelsInStorage - (acresToFarm * costToPlantInBushels)

      println()
      println()
      println(s"""O great Hammurabi!
        |You are in year $year of your ten year rule.
        |In the previous year $starved people starved to death.
        |In the previous year $immigrants people entered the kingdom.
        |The population is now $population.
        |We harvested $harvest bushels at 3 bushels per acre.
        |Rats destroyed $rats_ate bushels, leaving 2800 bushels in storage.
        |The city owns $acresOwned acres of land.
        |Land is currently worth $pricePerAcre bushels per acre.
        |There were $plagueDeaths deaths from the plague.""".stripMargin)
      println()

    }


  }

  def askHowMuchLandToBuy(bushels: Int, price: Int) = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }


  def askHowMuchLandToSell(acres: Int, price: Int) = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell < 0 || acresToSell > acres) {
      println("O Great Hammurabi, we have but " + acres + " acres to sell!")
      acresToSell = readInt("How many acres will you sell? ")
    }
    acresToSell
  }

  def askHowMuchToFeedPeople(pop: Int, bushels: Int) = {
    var grainsToFeed = readInt("How many bushels to feed the people?")
    while (grainsToFeed < 0 || grainsToFeed > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      grainsToFeed = readInt("How many bushels to feed the people?")
    }
    grainsToFeed
  }

  def askHowManyAcresToPlant(acres: Int, bushels: Int, pop: Int, cost: Int, farmedPp: Int) = {

    var acresToPlant = readInt("How many acres do you wish to plant? ")

    //  (acres >= acresToPlant)           i.e. Are enough acres owned to plant what's requested?
    //  (bushels >= acresToPlant * cost)  i.e. Are there enough bushels to pay for the planting requested?
    //  (pop * farmedPp >= acresToPlant)  i.e. Are there enough people to plant the acres requested?

    while(!(acres >= acresToPlant) || !(bushels >= acresToPlant * cost) || !(pop * farmedPp >= acresToPlant)) {

      if(!(acres >= acresToPlant)) {
       print(s"not enough land, you have $acres acres of land. You would need ${acresToPlant-acres} more acres of land\n")
      }
      if(!(bushels >= acresToPlant * cost)) {
        print(s"not enough bushels. You have $bushels bushels. You will need ${(acresToPlant * cost) - bushels}\n")
      }
      if(!(bushels >= acresToPlant * cost)) {
        print(s"not enough people. You have $pop people in your population. You will need at least ${acresToPlant/farmedPp} people\n")
      }
      acresToPlant = readInt("How many acres do you wish to plant? ")

    }
    acresToPlant
  }
}