package game;

import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
	Board testedBoard;
	String[][] resutExpectedBoard;
	@BeforeEach
	public void initialize(){
		this.testedBoard = new Board();
		this.resutExpectedBoard = new String[3][3];
		resutExpectedBoard[0][0] = " ";
		resutExpectedBoard[0][1] = "x";
		resutExpectedBoard[0][2] = " ";

		resutExpectedBoard[1][0] = " ";
		resutExpectedBoard[1][1] = " ";
		resutExpectedBoard[1][2] = " ";

		resutExpectedBoard[2][0] = " ";
		resutExpectedBoard[2][1] = " ";
		resutExpectedBoard[2][2] = " ";

	}
	@Test
	public void exceptionPlayerDoesntExistShouldBeThrown() {
		assertThrows(GameRuleException.class, () -> {
			testedBoard.playTurn(1,0,0);
			testedBoard.playTurn(2,0,0);
		});
		/*GameRuleException ex = A-a.Throws<GameRuleException>(() => playTurn());
		Assert.That(ex.Message, Is.EqualTo("Actualexception message"));*/
	}
	@Test
	public void expetionTheCaseIsFullShouldBeThrown(){

		Board testedBoard = new Board();
		testedBoard.setBoard(resutExpectedBoard);
		/*assertThrows(GameRuleException.class, () -> {
			testedBoard.playTurn(2,0,1);
		});*/
		try{

			testedBoard.playTurn(2,0,1);
			fail();
		}catch (GameRuleException e){
			assertEquals("Cette case est déjà occupée.",e.getMessage());

		}
	}
	@Test
	public void playerShouldBeXOnZeroOne(){

		Board testedBoard = new Board();
		try{
			testedBoard.playTurn(1,0,1);
			assertArrayEquals(resutExpectedBoard, testedBoard.getBoard());
		}catch (GameRuleException e){
			System.out.println("the test went wrong");
		}


	}
	@Test
	public void playerShoudBeOOnZeroZero(){
		resutExpectedBoard[0][0] = "o";
		resutExpectedBoard[0][1] = " ";

		Board testedBoard = new Board();
		try{
			testedBoard.playTurn(2,0,0);
			assertArrayEquals(resutExpectedBoard, testedBoard.getBoard());
		}catch (GameRuleException e){
			System.out.println("the test went wrong");
		}
	}
}
