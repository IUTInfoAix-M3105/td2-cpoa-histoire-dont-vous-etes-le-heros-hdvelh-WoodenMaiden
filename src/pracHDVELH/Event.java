/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";

	static private int lastid;
	private int id;
	private String intitule;
	private String[] possibleAnswers;
	private String playerAnswer;
	private int chosenPath;
	private GUIManager gui;
	private Scanner reader;

	@Override
	public String toString(){
		return "Event: #"+getId()+" ("+getClass()+"): "+ getData();
	}

	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return possibleAnswers[chosenPath];
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		//for (String str );
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		this.chosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return intitule;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		this.intitule = data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		setDaughter(daughter, i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return this.gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	public boolean isFinal(){
		if (!hasDaughters()) return true;
		return false;
	}

	public boolean isInRange(int index){
		NodeMultiple[] mesdaugters = getDaughters();
		if (mesdaugters[index] != null) return true;
		return false;
	}

	public Event run(){
		this.gui.outputln(this.toString());
		this.gui.output(PROMPT_ANSWER);
		this.playerAnswer = reader.next();
		this.chosenPath = interpretAnswer();
		return getDaughter(chosenPath);
	}


	/* Methods */

	public Event (GUIManager gui, String data)
	{
		super(data);
		this.gui = gui;
		this.id = ++this.lastid;
		this.reader = gui.getInputReader();
	}

	public Event ()
	{
		this(new GUIManager(), "");
	}

}

// eof