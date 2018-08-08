package com.telagene.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telagene.chess.model.Game;
import com.telagene.chess.model.Player;
import com.telagene.chess.model.Round;
import com.telagene.chess.model.Tournament;

@RestController
public class ChessController {


    @RequestMapping("/testlist")
    public List<String> testlist() {
        List<String> test = new ArrayList<>();
        test.add("Salut");
        test.add("Bonjour");
        return test;
    }

    @RequestMapping("/chess")
    public Player[] getChessResults() {

        Player player1 = new Player("Jimmy", "Forest", 1783);
        Player player2 = new Player("Sylvain", "Mireault", 1711);
        Player player3 = new Player("Roger", "Gendron", 1607);
        Player player4 = new Player("Guillaume", "Levebvre", 1551);
        List<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        Tournament tournoi = new Tournament(players);

        // round 1
        Game game1 = new Game(player1, player3, 1);
        Game game2 = new Game(player2, player4, 0);

        Round round1 = new Round();
        round1.addGame(game1);
        round1.addGame(game2);
        tournoi.addRound(round1);

        // round 2
        Game game3 = new Game(player1, player4, 1);
        Game game4 = new Game(player2, player3, 1);
        Round round2 = new Round();


        round2.addGame(game3);
        round2.addGame(game4);
        tournoi.addRound(round2);

        //round 3
        Game game5 = new Game(player1, player2, 1);
        Game game6 = new Game(player3, player4, 0);

        Round round3 = new Round();

        round3.addGame(game5);
        round3.addGame(game6);

        tournoi.addRound(round3);

        tournoi.computeNewRatings();
        return tournoi.getPlayersStanding();
    }

}
