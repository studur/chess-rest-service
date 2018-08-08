package com.telagene.chess;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.telagene.chess.model.Game;
import com.telagene.chess.model.Player;
import com.telagene.chess.model.Tournament;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class TournamentTest {

   private static Tournament tournament;
   private static Player player1;
   private static Player player2;
   private static Game game1;

   @Before
   public void setUp() {
      player1 = new Player("John", "Doe", 1500);
      player2 = new Player("Jane", "Doe", 1800);

      List<Player> players = new ArrayList<>();
      players.add(player1);
      players.add(player2);
      tournament = new Tournament(players);

      game1 = new Game(player1, player2, 0);
      tournament.addResult(game1);
   }

   @Test
   public void getResultMatrix() {
      double[][] result = tournament.getResultMatrix();
      double[][] expected = new double[][]{{0, -4.800000000000001}, {4.800000000000001, 0}};
      assertArrayEquals(expected, result);
   }

   @Test
   public void addResult() throws Exception {
      assertTrue(player1.getWins() == 0);
      assertTrue(player1.getLosses() == 1);
      assertTrue(player2.getWins() == 1);
      assertTrue(player2.getLosses() == 0);
      assertTrue(player1.getScore() == 0);
      assertTrue(player2.getScore() == 1);
   }

   @Test
   public void computeNewRatings() throws Exception {
      tournament.computeNewRatings();
      assertTrue(player1.getOldRating() == 1500);
      assertTrue(player2.getOldRating() == 1800);
      assertTrue(player1.getRating() == 1495.2);
      assertTrue(player2.getRating() == 1804.8);
   }

   @Test
   public void computePlayerStanding() throws Exception {

      Player[] expectedBefore = new Player[]{null, null};
      Player[] expectedAfter = new Player[]{player2, player1};

      assertArrayEquals(expectedBefore, tournament.getPlayersStanding());

      tournament.computeNewRatings();
      assertArrayEquals(expectedAfter, tournament.getPlayersStanding());
   }

}