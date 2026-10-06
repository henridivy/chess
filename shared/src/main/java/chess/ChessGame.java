package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * A class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    ChessBoard board = new ChessBoard();
    TeamColor teamTurn;

    public ChessGame() {
        board.resetBoard();
        teamTurn = TeamColor.WHITE;
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return teamTurn;
    }

    /**
     * Sets which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) { teamTurn = team; }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets all valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) { return null; }

        Collection<ChessMove> validMoves = new ArrayList<>();

        Collection<ChessMove> pieceMoves = piece.pieceMoves(board, startPosition);

        ChessBoard backupBoard = board.clone();

        // test each move on the board and check if the king is in check after
        for (var move : pieceMoves) {
            makeMoveHelper(move.getStartPosition(), move.getEndPosition(), piece, board);

            if (!isInCheck(piece.getTeamColor())) {
                validMoves.add(move);
            }

            // return the board to its original state
            board = backupBoard.clone();
        }

        return validMoves;
    }

    /**
     * Makes a move in the chess game
     *
     * @param move chess move to perform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {

        ChessPosition start = move.getStartPosition();
        ChessPosition end = move.getEndPosition();
        
        // get the piece at the move's starting position
        ChessPiece piece = board.getPiece(start);

        // check if move is in valid (empty position, wrong team color, or leaves king in check)
        if (piece == null) { throw new InvalidMoveException("No piece at start position."); }
        if (piece.getTeamColor() != teamTurn) { throw new InvalidMoveException("Wrong team's turn."); }
        if (!validMoves(start).contains(move)) { throw new InvalidMoveException("Invalid move."); }

        // make the move
        makeMoveHelper(start, end, piece, board);

        // set the next team's turn
        changeTeamTurn();
    }

    private void makeMoveHelper(ChessPosition start, ChessPosition end, ChessPiece piece, ChessBoard board) {
        /*
        this is the function that actually performs whatever move on whatever board its given
        and doesn't check for any kind of validity
         */

        // add the piece to the board at the ending position
        board.addPiece(end, piece);

        // set the starting position to null
        board.addPiece(start, null);
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {

        // find the team's king and save its position
        ChessPosition kingPosition = getKingPosition(teamColor);

        // loop through pieces on the board
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                ChessPosition position = new ChessPosition(r, c);
                ChessPiece piece = board.getPiece(position);
                if (piece != null) {
                    if (piece.getTeamColor() != teamColor) { // for enemy pieces
                        // check if the kings position is in any of the valid moves ending position
                        for (var move : piece.pieceMoves(board, position)) {
                            ChessPosition end = move.getEndPosition();
                            if (end.equals(kingPosition)) { return true; }      // can't use ==, must use equals()
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves while not in check.
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets this game's chessboard to a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) { this.board = board; }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }

    private void changeTeamTurn() {
        if (teamTurn == TeamColor.WHITE) { setTeamTurn(TeamColor.BLACK); }
        else { setTeamTurn(TeamColor.WHITE); }
    }

    private ChessPosition getKingPosition(TeamColor teamColor) {
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                ChessPosition position = new ChessPosition(r, c);
                ChessPiece piece = board.getPiece(position);
                if (piece != null) {
                    if (piece.getTeamColor() == teamColor) {
                        if (piece.getPieceType() == ChessPiece.PieceType.KING) {
                            return position;
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Implementation Error: No king on board.");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessGame chessGame = (ChessGame) o;
        return Objects.equals(board, chessGame.board) && teamTurn == chessGame.teamTurn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, teamTurn);
    }

    @Override
    public String toString() {
        return "ChessGame: \n" +
                "\nteamTurn = " + teamTurn +
                "\nboard =\n" + board.toString();
    }
}
