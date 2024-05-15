/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import boundary.graphics.Dialog;
import boundary.graphics.FunctionnalKernelAdapter;
import control.ActivateBoxControl;
import control.MoveControl;
import control.PirateGameControl;
import control.VerifyEndGameControl;
import model.entities.Board;
import model.entities.Case;
import model.entities.FinishLine;
import model.entities.GargamelleCase;
import model.entities.LuckyLukeShadowCase;
import model.entities.MrKrabsCase;
import model.entities.NurseCase;
import model.entities.Pirate;
import model.entities.PortalCase;
import model.entities.StartCase;
import model.entities.SwapCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static scenario.ConsoleScenario.NB_CASES;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Robin
 */
public class TestControlBox {
     private Board board ;
     LinkedList<Pirate> listPirate ;
     private FunctionnalKernelAdapter functionnalKernelAdapter;
     private Dialog dialog;
     private ActivateBoxControl activateBoxControl ;
     private MoveControl moveControl;
     private VerifyEndGameControl verifyEndGameControl ;
     private PirateGameControl pirateGameControl;
    public TestControlBox() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board(NB_CASES);
         for(int i = 0; i < NB_CASES; i++) {
            switch(i){
                case 0:
                    board.addCase(new StartCase(i));
                    break;
                case 6:
                    board.addCase(new PortalCase(i));
                    break;
                case 15:
                    board.addCase(new GargamelleCase(i));
                    break;
                case 23:
                    board.addCase(new MrKrabsCase(i));
                    break;
                case 7:
                    board.addCase(new NurseCase(i));
                    break;
                case 27:
                    board.addCase(new LuckyLukeShadowCase(i));
                    break;
                case 28:
                    board.addCase(new SwapCase(i));
                    break;
                case 29:
                   board.addCase(new FinishLine(i));
                   break;
                default:
                   board.addCase(new Case(i));
            }
         }
        functionnalKernelAdapter = new FunctionnalKernelAdapter();
        dialog = new Dialog(functionnalKernelAdapter);
        activateBoxControl = new ActivateBoxControl(functionnalKernelAdapter);
        moveControl = new MoveControl(functionnalKernelAdapter, board);
        verifyEndGameControl = new VerifyEndGameControl(functionnalKernelAdapter);
        pirateGameControl = new PirateGameControl(board, functionnalKernelAdapter,moveControl, verifyEndGameControl, activateBoxControl);
        
        functionnalKernelAdapter.setThrowDice(moveControl);
        functionnalKernelAdapter.setDialog(dialog);
        functionnalKernelAdapter.setMovePirate(moveControl);
        functionnalKernelAdapter.setPirateGameControl(pirateGameControl);
        functionnalKernelAdapter.setMovePirateEffect(activateBoxControl);
        moveControl.setPirateGameControl(pirateGameControl);
        activateBoxControl.setPirateGameControl(pirateGameControl);
        listPirate = new LinkedList<>();
        listPirate.add(new Pirate(0, "Toto", 5));
        listPirate.add(new Pirate(1, "Tata", 5));
        for(Pirate p : listPirate) {
        	board.addPlayer(p);
        }
        
    }
    
    @AfterEach
    public void tearDown() {
    }
    @Test
    void testActivateBoxAvecCaseNormaleQuandLePirateEstSeulSurSaCAse(){
    	int positionInitial = this.listPirate.get(0).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(0));
        assertTrue(this.listPirate.get(0).getHp()==5 && this.listPirate.get(0).getPosition()==positionInitial);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
