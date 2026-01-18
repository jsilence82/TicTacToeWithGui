package Model;

import Contoller.GameControls;
import Model.players.Factory;
import Model.players.Player;
import Model.players.PlayerType;

public class GameStateFactory {

    public static GameControls createGameState(String player1Name, String player2Name, String player1Type, String player2Type) {
        PlayerType type1 = getPlayerTypeFromString(player1Type);
        PlayerType type2 = getPlayerTypeFromString(player2Type);
        Player player1 = Factory.playerFactory(type1, player1Name, "X");
        Player player2 = Factory.playerFactory(type2, player2Name, "O");
        return new GameState(player1, player2);
    }

    public static PlayerType getPlayerTypeFromString(String playerTypeString) {
        for (PlayerType type : PlayerType.values()) {
            if (type.getDisplayName().equals(playerTypeString)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No PlayerType with display name: " + playerTypeString);
    }

}
