package Model.players;

public enum PlayerType{
     

    AI ("AI", "AI: Impossible") {
        @Override
        public Player create(String playerName, String playersMark){
            return new AI(playersMark);
}
    },

    Human("Human", "Human Player") {
        @Override
        public Player create(String playerName, String playersMark){
            return new HumanPlayer(playerName, playersMark );
}
    },

    Computer("Computer", "Computer: Easy") {
        @Override
        public Player create(String playerName, String playersMark ){
            return new Computer(playersMark);
        }
    };

    private final String displayName;
    private final String discripiton;

    PlayerType(String displayName, String description) {
        this.displayName = displayName;
        this.discripiton = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return discripiton;
    }

    @Override
    public String toString() {
        return displayName; 
    }

    public abstract Player create(String playerName, String playersMark);
}