/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BoundaryForTestingPurpose.TestPirateGameBoundary;
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

/**
 *
 * @author Robin
 */
public class TestControlBox {
	 private int NB_CASES = 30;
     private Board board ;
     LinkedList<Pirate> listPirate ;
     private TestPirateGameBoundary functionnalKernelAdapter;
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
        functionnalKernelAdapter = new TestPirateGameBoundary();
        activateBoxControl = new ActivateBoxControl(functionnalKernelAdapter);
        moveControl = new MoveControl(functionnalKernelAdapter, board);
        verifyEndGameControl = new VerifyEndGameControl(functionnalKernelAdapter);
        pirateGameControl = new PirateGameControl(board, functionnalKernelAdapter,moveControl, verifyEndGameControl, activateBoxControl);
       
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
    	this.listPirate.get(0).setPosition(2);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(1);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(0));
        assertTrue(this.listPirate.get(0).getHp()==5 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==5 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }
    @Test
    void testActivateBoxAvecCaseNormaleQuandLesPiratesSontsDeuxSurLaCases(){
    	this.listPirate.get(0).setPosition(2);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(2);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(0));
        assertTrue(this.listPirate.get(0).getHp()==4 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==4 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }
    @Test
    void testActivateBoxAvecCaseLuckyLuckQuandLePirateEstSeulSurSaCAse(){
    	int numCase = 27;
    	this.listPirate.get(0).setPosition(numCase);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(1);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(numCase));
        assertTrue(this.listPirate.get(0).getHp()==3 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==5 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }
    @Test
    void testActivateBoxAvecCaseLuckyLuckQuandLesPirateSontsDeuxSurLaCase(){
    	int numCase = 27;
    	this.listPirate.get(0).setPosition(numCase);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(numCase);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(numCase));
    	assertTrue(this.listPirate.get(0).getHp()==2 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==4 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }
    @Test
    void testActivateBoxAvecCaseGargamelQuandLePirateEstSeulSurSaCAse(){
    	int numCase = 15;
    	this.listPirate.get(0).setPosition(numCase);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(1);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(numCase));
        assertTrue(this.listPirate.get(0).getHp()==4 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==5 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }
    @Test
    void testActivateBoxAvecCaseGargamelQuandLesPirateSontsDeuxSurLaCase(){
    	int numCase = 15;
    	this.listPirate.get(0).setPosition(numCase);
    	int positionInitial = this.listPirate.get(0).getPosition();
    	this.listPirate.get(1).setPosition(numCase);
    	int positionInitial2 = this.listPirate.get(1).getPosition();
    	activateBoxControl.activateBox( this.board.getListPirate(), this.board.getListPirate().get(0), board.getCases().get(numCase));
    	assertTrue(this.listPirate.get(0).getHp()==3 
        		&& 
        		this.listPirate.get(0).getPosition()==positionInitial 
        		&& 
        		this.listPirate.get(1).getHp()==4 
        		&& 
        		this.listPirate.get(1).getPosition()==positionInitial2);
    }


}
