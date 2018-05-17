### Setup
* Fork, Clone locally
* Import in selected IDEA, use gradle build

### Runs locally on
* http://localhost:8080

### controller 
* Located in main/java/com/slalom/pockerchallenge/controller
* PokerController
    * Requests mapped to /cards
    * POST request accepts a JSON object - will respond with String of hand
    * GET request returns a list of cards from the last hand posted

### service
* Located in main/java/com/slalom/pokerchallenge/service
* Card service
    * Directly manages requests from controller
    * Initializes instances of PokerHand and Card objects
* Poker service
    * Contains business logic to process hand from POST request
    * Returns String of hand which is then added to PokerHand object

### objects
* Card
    * Located in main/java/com/slalom/pokerchallenge/objects
    * Contains two attribute: Integer Rank, String Suit
    * Rank is acquired from a Map object that selects corresponding integer value from string key
    * Cards are sorted on Rank attribute
* PokerHand
    * Contains two attributes: List of Cards, String for hand
    * Hand is acquired through business logic from PokerService

### Tests
* Controller tests in test/java/com/slalom/pokerchallenge/controller
    * Tests each variation of the hand results retrieved in PokerService
    * Uses MockMvc to perform requests to PokerController
    * Posts a JSON object
    * Expects a specified String result



