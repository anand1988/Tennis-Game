package com.anand;

import java.util.Arrays;
import java.util.List;

public class TennisGame {
	public static final List<String> pointsDescription = Arrays.asList("Love",
			"Fifteen", "Thirty", "Forty");
	private String player1Name;
	private String player2Name;
	private int player1Score = 0;
	private int player2Score = 0;

	public TennisGame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1Name))
			player1Score += 1;
		else if (playerName.equals(player2Name))
			player2Score += 1;
	}

	public String getScore() {
		if (player1Score >= 3 && player2Score >= 3) {
			if (Math.abs(player2Score - player1Score) >= 2) {
				return "Win for " + getLeadPlayer();
			} else if (player1Score == player2Score) {
				return "Deuce";
			} else {
				return "Advantage " + getLeadPlayer();
			}
		} else if ((player1Score >= 4 && player2Score < 4)
				|| (player2Score >= 4 && player1Score < 4)) {
			return "Win for " + getLeadPlayer();
		} else {
			return pointsDescription.get(player1Score) + "-"
					+ pointsDescription.get(player2Score);
		}
	}

	public String getLeadPlayer() {
		return (player1Score > player2Score) ? player1Name : player2Name;
	}
}
