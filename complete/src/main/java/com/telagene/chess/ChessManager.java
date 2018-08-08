package com.telagene.chess;

import java.util.ArrayList;
import java.util.List;

import com.telagene.chess.model.Cevtables;
import com.telagene.chess.model.Game;
import com.telagene.chess.model.Player;
import com.telagene.chess.model.Round;
import com.telagene.chess.model.Tournament;

public class ChessManager {

   public static void main(String[] args) {



      Player player1 = new Player("Jimmy", "Forest", 1783);
      Player player2 = new Player("Sylvain", "Mireault", 1711);
      Player player3 = new Player("Roger", "Gendron", 1607);
      Player player4 = new Player("Guillaume", "Levebvre", 1551);

//      Player player5 = new Player("Robert", "Blanchard", 1231);
//      Player player6 = new Player("Yves", "Gosselin", 1190);
//      Player player7 = new Player("Pierre", "Boucher", 1136);
//      Player player8 = new Player("Guillaume", "Lefebvre", 1372);
//      Player player9 = new Player("Jean", "Morissette", 1861);

      List<Player> players = new ArrayList<>();

      players.add(player1);
      players.add(player2);
      players.add(player3);
      players.add(player4);
//      players.add(player5);
//      players.add(player6);
//      players.add(player7);
//      players.add(player8);
//      players.add(player9);

      Tournament tournoi = new Tournament(players);


      // round 1
      Game game1 = new Game(player1, player3, 1);
      Game game2 = new Game(player2, player4, 0);
//      Game game3 = new Game(player3, player7, 0.5);
//      Game game4 = new Game(player4, player8, 0);

      Round round1 = new Round();
      round1.addGame(game1);
      round1.addGame(game2);
//      round1.addGame(game3);
//      round1.addGame(game4);

      tournoi.addRound(round1);

      // round 2

      Game game3 = new Game(player1, player4, 1);
      Game game4 = new Game(player2, player3, 1);
//      Game game7 = new Game(player4, player7, 0.5);
//      Game game8 = new Game(player8, player9, 0);


      Round round2 = new Round();


      round2.addGame(game3);
      round2.addGame(game4);
//      round2.addGame(game7);
//      round2.addGame(game8);

      tournoi.addRound(round2);

      //round 3

      Game game5 = new Game(player1, player2, 1);
      Game game6 = new Game(player3, player4, 0);
//      Game game11 = new Game(player3, player4, 0);
//      Game game12 = new Game(player6, player7, 1);

      Round round3 = new Round();

      round3.addGame(game5);
      round3.addGame(game6);
//      round3.addGame(game11);
//      round3.addGame(game12);


      tournoi.addRound(round3);

      tournoi.computeNewRatings();
      tournoi.printTournamentReport();

      try {
         String filename = "result-3";
         tournoi.printTournamentReportToCsvFile(filename);
         Cevtables.convertCsvToXml(filename);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
