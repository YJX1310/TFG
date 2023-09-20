/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2023
 * Authors:
 * 		- Fernando S�enz P�rez (Team Director).
 *      - Version from 0.1 to 0.6:
 *      	- Diego Cardiel Freire.
 *			- Juan Jos� Ortiz S�nchez.
 *          - Delf�n Rup�rez Ca�as.
 *      - Version 0.7:
 *          - Miguel Mart�n L�zaro.
 *      - Version 0.8:
 *      	- Javier Salcedo G�mez.
 *      - Version from 0.9 to 0.11:
 *      	- Pablo Guti�rrez Garc�a-Pardo.
 *      	- Elena Tejeiro P�rez de �greda.
 *      	- Andr�s Vicente del Cura.
 *      - Version from 0.12 to 0.16
 *      	- Sem�ramis Guti�rrez Quintana
 *      	- Juan Jes�s Marqu�s Ortiz
 *      	- Fernando Ord�s Lorente
 *      - Version 0.17
 *      	- Sergio Dom�nguez Fuentes
 * 		- Version 0.18
 * 			- Sergio Garc�a Rodr�guez
 * 		- Version 0.19
 * 			- Carlos Gonz�lez Torres
 * 			- Cristina Lara L�pez
 * 			- Yuejie Xu
 * 			- Yihang Zhuo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package acide.gui.debugPanel.traceSQLPanel;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import acide.gui.debugPanel.debugCanvas.AcideDebugCanvas;
import acide.gui.debugPanel.traceSQLPanel.listeners.*;
import acide.gui.debugPanel.utils.AcideDebugHelper;
import acide.gui.debugPanel.utils.AcideDebugPanelHighLighter;
import acide.gui.graphUtils.DirectedWeightedGraph;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;
import acide.process.console.DesDatabaseManager;

/**
 * 
 * ACIDE - A Configurable IDE trace SQL panel.
 * 
 * @version 0.15
 * @see JPanel
 */
public class AcideTraceSQLPanel extends JPanel {

	/**
	 * ACIDE - A Configurable IDE trace SQL panel class serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel debug canvas.
	 */
	public static AcideDebugCanvas _canvas;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel button panel.
	 */
	private JPanel _mainButtonPanel;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel zoom spinner.
	 */
	private static JSpinner _zoomSpinner;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel show label check box.
	 */
	private JCheckBox _showLabelsMenuItem;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel show rules check box.
	 */
	private JCheckBox _showSQLMenuItem;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel view box.
	 */
	private JComboBox _viewBox;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel query.
	 */
	private String _query;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel high lighter.
	 */
	private AcideDebugPanelHighLighter _highLighter;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel show label view label.
	 */
	private JLabel _viewLabel;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel zoom in button.
	 */
	private JButton _zoomin;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel zoom out button.
	 */
	private JButton _zoomout;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel first node button.
	 */
	private JButton _firstNodeButton;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel prev node button.
	 */
	private JButton _prevNodeButton;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel next node button.
	 */
	private JButton _nextNodeButton;

	/**
	 * ACIDE - A Configurable IDE trace SQL panel last node button.
	 */
	private JButton _lastNodeButton;
	/**
	 * ACIDE - A Configurable IDE trace SQL panel to the first button icon
	 */
	private final static ImageIcon TO_THE_FIRST_IMAGE = new ImageIcon(
			"./resources/icons/menu/configuration/menu/double_left_arrow.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel to the last button icon
	 */
	private final static ImageIcon TO_THE_LAST_IMAGE = new ImageIcon(
			"./resources/icons/menu/configuration/menu/double_right_arrow.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel to the right button icon
	 */
	private final static ImageIcon TO_THE_RIGHT_IMAGE = new ImageIcon(
			"./resources/icons/menu/configuration/menu/right_arrow.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel to the left button icon
	 */
	private final static ImageIcon TO_THE_LEFT_IMAGE = new ImageIcon(
			"./resources/icons/menu/configuration/menu/left_arrow.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel add button icon
	 */
	private final static ImageIcon ADD_IMAGE = new ImageIcon("./resources/icons/graph/add.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel minus button icon
	 */
	private final static ImageIcon MINUS_IMAGE = new ImageIcon("./resources/icons/graph/minus.png");
	/**
	 * ACIDE - A Configurable IDE trace SQL panel refresh button icon
	 */
	private final static ImageIcon REFRESH_IMAGE = new ImageIcon("./resources/icons/panels/refresh.png");
	/**
	 * ACIDE - A Configurable IDE debug SQL panel show view button icon
	 */
	private final static ImageIcon SHOW_VIEW = new ImageIcon(
			"./resources/icons/dataBase/table.png");
	/**
	 * ACIDE - A Configurable IDE debug SQL panel refresh button
	 */
	public static JButton refreshSQL = new JButton();
	/**
	 * ACIDE - A Configurable IDE debug SQL panel show view button
	 */
	public static JButton showView = new JButton();

	public AcideTraceSQLPanel() {
		// Sets the layout of the panel
		setLayout(new BorderLayout());
		// Builds the canvas
		buildCanvas();
		// Builds the button panel
		buildButtons();
		// Adds the canvas to sp and sp to panel
		ScrollPane sp = new ScrollPane();
		sp.add(_canvas);
		add(sp, BorderLayout.CENTER);
		// Adds the button panel
		add(_mainButtonPanel, BorderLayout.SOUTH);

		setHighLighter(new AcideDebugPanelHighLighter());
		
		//AcideTraceSQLPanel.acideWindow = AcideMainWindow.getInstance();

	}

	/**
	 * Builds the buttons for the ACIDE - A Configurable IDE trace SQL panel.
	 */
	private void buildButtons() {
		// builds the button panel
		_mainButtonPanel = new JPanel();
		// adds the layout to the button panel
		_mainButtonPanel.setLayout(new BorderLayout());
		// creates the sub button panel 1
		JPanel subButtonPanel1 = new JPanel();
		// adds the layout to the sub button panel
		subButtonPanel1.setLayout(new FlowLayout());
		subButtonPanel1.setOpaque(false);
		// adds the sub button panel to the main button panel
		_mainButtonPanel.add(subButtonPanel1, BorderLayout.NORTH);
		refreshSQL.setIcon(REFRESH_IMAGE);
		refreshSQL.setPreferredSize(new Dimension((int) (1.5 * refreshSQL.getIcon()
				.getIconWidth()), (int) refreshSQL.getPreferredSize().getHeight()));
		// adds the action listener to the refresh button
		refreshSQL.addActionListener(new AcideTraceSQLPanelRefreshListener());
		//sets tooltip button 
		refreshSQL.setToolTipText(AcideLanguageManager.getInstance().getLabels().getString("s2044"));
		//unable the button
		refreshSQL.setEnabled(false);
		// adds the refresh button
		subButtonPanel1.add(refreshSQL);

		showView.setIcon(SHOW_VIEW);
		showView.setPreferredSize(new Dimension((int) (1.5 * showView
				.getIcon().getIconWidth()), (int) showView.getPreferredSize()
				.getHeight()));
		// adds the action listener to the refresh button
		showView.addActionListener(new AcideTraceSQLPanelShowViewListener());
		// sets tooltip button
		showView.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2323"));
		// unable the button
		showView.setEnabled(false);
		// adds the refresh button
		subButtonPanel1.add(showView);
		// creates the spinner model for the zoom spinner
		SpinnerModel model = new SpinnerNumberModel(
				(int) _canvas.getZoom() * 100, 0, Integer.MAX_VALUE, 1);
		// creates the zoom spinner with the model
		_zoomSpinner = new JSpinner(model);
		((JSpinner.DefaultEditor) _zoomSpinner.getEditor()).getTextField()
				.setColumns(4);
		// adds the action listener to the zoom spinner
		_zoomSpinner
				.addChangeListener(new AcideTraceSQLPanelZoomSpinnerListener());
		subButtonPanel1.add(_zoomSpinner);
		// creates the zoom in button
		_zoomin = new JButton(ADD_IMAGE);
		_zoomin.setPreferredSize(new Dimension((int) (1.5 * _zoomin.getIcon()
				.getIconWidth()), (int) _zoomin.getPreferredSize().getHeight()));
		// adds the zoom in action listener
		_zoomin.addActionListener(new AcideTraceSQLPanelZoomInListener());
		// adds the zoom in button to the button panel
		subButtonPanel1.add(_zoomin);
		// creates the zoom out button
		_zoomout = new JButton(MINUS_IMAGE);
		_zoomout.setPreferredSize(new Dimension((int) (1.5 * _zoomout.getIcon()
				.getIconWidth()), (int) _zoomout.getPreferredSize().getHeight()));
		// adds the zoom out action listener
		_zoomout.addActionListener(new AcideTraceSQLPanelZoomOutListener());
		// adds the zoom out button to the button panel
		subButtonPanel1.add(_zoomout);
		// builds the show labels check box
		_showLabelsMenuItem = new JCheckBox();
		// sets the default selected option
		_showLabelsMenuItem.setSelected(true);
		// sets the text of the show labels check box
		_showLabelsMenuItem.setText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2263"));
		_showLabelsMenuItem
				.setFont(_showLabelsMenuItem.getFont().deriveFont(10f));
		// adds the action listener to the show labels check box
		_showLabelsMenuItem
				.addActionListener(new AcideTraceSQLPanelShowLabelsListener());
		// adds the show labels check box to the button panel
		subButtonPanel1.add(_showLabelsMenuItem);
		// creates the sub button panel 2
		JPanel subButtonPanel2 = new JPanel();
		// adds the layout to the sub button panel
		subButtonPanel2.setLayout(new FlowLayout());
		subButtonPanel2.setOpaque(false);
		// adds the sub button panel to the main button panel
		_mainButtonPanel.add(subButtonPanel2, BorderLayout.SOUTH);
		// Builds the view label
		_viewLabel = new JLabel(AcideLanguageManager.getInstance().getLabels().getString("s2287"));
		// Set view selector function
		_viewLabel.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2410"));
		_viewLabel.setFont(_viewLabel.getFont().deriveFont(10f));
		subButtonPanel2.add(_viewLabel);
		// Builds the views combo box
		_viewBox = new JComboBox();
		_viewBox.addItem("          ");
		// Adds the listeners to the views combo box
		_viewBox.addActionListener(new AcideTraceSQLPanelViewBoxListener());
		_viewBox.addFocusListener(new FocusAdapter() {
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.FocusAdapter#focusGained(java.awt.event.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				
				// Puts the wait cursor
				//AcideTraceSQLPanel.acideWindow.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				
				// Gets the views from the database
				LinkedList<String> l = DesDatabaseManager.getInstance()
						.executeCommand("/tapi /list_views");
				ArrayList<String> views = new ArrayList<String>();
				views.add("          ");
				// Parses the output from the database
				for (String s : l) {
					// Checks if the output is an error output
					if (s.equals("$error")) {
						//Resets the list of views
						views = new ArrayList<String>();
						views.add(AcideLanguageManager.getInstance()
								.getLabels().getString("s2287"));
						break;
					}
					//Checks if the output has ended
					if (s.equals("$eot"))
						break;
					// Adds the actual's view name to the list
					views.add(s);
				}
				// Gets the trace datalog panel list of views
				JComboBox viewBox = AcideMainWindow.getInstance()
						.getDebugPanel().getTraceSQLPanel().getViewBox();
				// Removes the previous views
				viewBox.removeAllItems();
				// Adds the new views
				for (String item : views)
					viewBox.addItem(item);
				viewBox.setPopupVisible(false);
				viewBox.setPopupVisible(true);

				// Check if there are no views to select
				if(viewBox.getItemCount()==1){
					// Disable refresh button
					refreshSQL.setEnabled(false);
					// Disable show view button
					showView.setEnabled(false);
					// Clean canvas
					_canvas.set_graph(new DirectedWeightedGraph());
					_canvas.repaint();
				}

				// Puts the default cursor
				//AcideTraceSQLPanel.acideWindow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		subButtonPanel2.add(_viewBox);
		// Creates the first node button
		_firstNodeButton = new JButton(TO_THE_FIRST_IMAGE);
		_firstNodeButton.setPreferredSize(new Dimension(
				(int) (1.5 * _firstNodeButton.getIcon().getIconWidth()),
				(int) _firstNodeButton.getPreferredSize().getHeight()));
		// adds the action listener to the first node button
		_firstNodeButton
				.addActionListener(new AcideTraceSQLPanelNodeListener());
		// adds the firs node button to the button panel
		subButtonPanel2.add(_firstNodeButton);
		// creates the previous node button
		_prevNodeButton = new JButton(TO_THE_LEFT_IMAGE);
		_prevNodeButton.setPreferredSize(new Dimension((int) (1.5 * _prevNodeButton.getIcon()
				.getIconWidth()), (int) _prevNodeButton.getPreferredSize().getHeight()));
		// adds the action listener to the previous node button
		_prevNodeButton
				.addActionListener(new AcideTraceSQLPanelPreviousNodeListener());
		// adds the previous node button to the button panel
		subButtonPanel2.add(_prevNodeButton);
		// creates the next node button
		_nextNodeButton = new JButton(TO_THE_RIGHT_IMAGE);
		_nextNodeButton.setPreferredSize(new Dimension((int) (1.5 * _nextNodeButton.getIcon()
				.getIconWidth()), (int) _nextNodeButton.getPreferredSize().getHeight()));
		// adds the action listener to the next node button
		_nextNodeButton
				.addActionListener(new AcideTraceSQLPanelNexNodeListener());
		// adds the next node button to the button panel
		subButtonPanel2.add(_nextNodeButton);
		// Creates the last node button
		_lastNodeButton = new JButton(TO_THE_LAST_IMAGE);
		_lastNodeButton.setPreferredSize(new Dimension(
				(int) (1.5 * _lastNodeButton.getIcon().getIconWidth()),
				(int) _lastNodeButton.getPreferredSize().getHeight()));
		// adds the action listener to the last node button
		_lastNodeButton
				.addActionListener(new AcideTraceSQLPanelLastNodeListener());
		// adds the last node button to the button panel
		subButtonPanel2.add(_lastNodeButton);
		// Builds the show rules check box
		_showSQLMenuItem = new JCheckBox();
		// sets the default selected option
		_showSQLMenuItem.setSelected(false);
		// sets the text of the show rules check box
		_showSQLMenuItem.setText(AcideLanguageManager.getInstance().getLabels()
				.getString("s2141"));
		_showSQLMenuItem.addActionListener(new AcideTraceSQLPanelShowSQLListener());
		_showSQLMenuItem.setFont(_showSQLMenuItem.getFont().deriveFont(10f));
		// showRulesMenuItem.addActionListener(arg0)
		subButtonPanel2.add(_showSQLMenuItem);
	}

	/**
	 * Builds the canvas of the the ACIDE - A Configurable IDE trace SQL panel.
	 */
	private void buildCanvas() {
		this._canvas = new AcideDebugCanvas();
		_canvas.setBounds(this.getBounds());
		_canvas.setVisible(true);
		_canvas.repaint();
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel
	 * canvas.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel
	 *         canvas.
	 */
	public AcideDebugCanvas getCanvas() {
		return _canvas;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel
	 * canvas.
	 * 
	 * @param canvas
	 *            new value to set.
	 */
	public void setCanvas(AcideDebugCanvas canvas) {
		this._canvas = canvas;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel view
	 * box.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel view
	 *         box.
	 */
	public JComboBox getViewBox() {
		return _viewBox;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel view
	 * box.
	 * 
	 * @param viewBox
	 *            new value to set.
	 */
	public void setViewBox(JComboBox viewBox) {
		this._viewBox = viewBox;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel zoom
	 * spinner.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel zoom
	 *         spinner.
	 */
	public static JSpinner getZoomSpinner() {
		return _zoomSpinner;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel zoom
	 * spinner.
	 * 
	 * @param zoomSpinner
	 *            new value to set.
	 */
	public void setZoomSpinner(JSpinner zoomSpinner) {
		this._zoomSpinner = zoomSpinner;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel show
	 * labels item.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel show
	 *         labels item.
	 */
	public JCheckBox getShowLabelsMenuItem() {
		return _showLabelsMenuItem;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel show
	 * labels item.
	 * 
	 * @param showLabelsMenuItem
	 *            new value to set.
	 */
	public void setShowLabelsMenuItem(JCheckBox showLabelsMenuItem) {
		this._showLabelsMenuItem = showLabelsMenuItem;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel show
	 * SQL item.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel show
	 *         SQL item.
	 */
	public JCheckBox getShowSQLMenuItem() {
		return _showSQLMenuItem;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel show
	 * SQL item.
	 * 
	 * @param showSQLsMenuItem
	 *            new value to set.
	 */
	public void setShowSQLMenuItem(JCheckBox showSQLsMenuItem) {
		this._showSQLMenuItem = showSQLsMenuItem;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE debug panel trace SQL panel query.
	 * 
	 * @return the ACIDE - A Configurable IDE debug panel trace SQL panel query.
	 */
	public String getQuery() {
		return _query;
	}

	/**
	 * Sets a new value to the ACIDE - A Configurable IDE trace SQL panel query.
	 * 
	 * @param query
	 *            new value to set.
	 */
	public void setQuery(String query) {
		this._query = query;
	}

	/**
	 * Returns the the ACIDE - A Configurable IDE trace SQL panel highligther.
	 * 
	 * @return the the ACIDE - A Configurable IDE trace datalog highligther.
	 */
	public AcideDebugPanelHighLighter getHighLighter() {
		return _highLighter;
	}

	/**
	 * Sets a new value to the the the ACIDE - A Configurable IDE trace sql
	 * panel highligther.
	 * 
	 * @param highLighter
	 *            the new value to set.
	 */
	public void setHighLighter(AcideDebugPanelHighLighter highLighter) {
		this._highLighter = highLighter;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE trace SQL canvas.
	 * 
	 * @return the ACIDE - A Configurable IDE trace SQL canvas.
	 */
	public AcideDebugCanvas getDebugSQLCanvas() {
		return _canvas;
	}
	
	public void setBackgroundColor(Color backgroundColor, Color foregroundColor, Color darker) {
		this.setBackground(backgroundColor);
		this._mainButtonPanel.setBackground(darker);
		this._mainButtonPanel.setForeground(foregroundColor);
		Component[] c = this._mainButtonPanel.getComponents();
		for(Component c1:((JPanel)c[1]).getComponents()) {
			if(c1 instanceof JLabel)
				((JLabel)c1).setForeground(foregroundColor);
		}
		SwingUtilities.invokeLater(() -> AcideDebugHelper.updateCanvasTrace(_canvas));
	}

	/**
	 * Sets the text of the components assigned to the ACIDE - A Configurable
	 * IDE trace SQL panel.
	 */
	public void setComponentsText() {
		// sets the text of the show labels check box
		_showLabelsMenuItem.setText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2263"));
		// sets the text of the show rules check box
		_showSQLMenuItem.setText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2141"));
		// Set the text of view label
		_viewLabel.setText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2287"));
		// Set view selector function
		_viewLabel.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2410"));
		//sets tooltip button
		refreshSQL.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2044"));
		// sets tooltip button
		showView.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2323"));
		// sets tooltip button
		_zoomin.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2389"));
		// sets tooltip button
		_zoomout.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2390"));
		// sets tooltip button
		_firstNodeButton.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2391"));
		// sets tooltip button
		_prevNodeButton.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2392"));
		// sets tooltip button
		_nextNodeButton.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2393"));
		// sets tooltip button
		_lastNodeButton.setToolTipText(AcideLanguageManager.getInstance()
				.getLabels().getString("s2394"));
	}

	/**
	 * Disable components assigned to the ACIDE - A Configurable IDE trace SQL panel.
	 */
	public void disableComponents(){
		_canvas.setEnabled(false);
		for(Component p:_mainButtonPanel.getComponents()){
			for(Component c:((JPanel)p).getComponents()){
				c.setEnabled(false);
			}
		}
	}

	/**
	 * Enable components assigned to the ACIDE - A Configurable IDE trace SQL panel.
	 */
	public void enableComponents(){
		_canvas.setEnabled(true);
		for(Component p:_mainButtonPanel.getComponents()){
			for(Component c:((JPanel)p).getComponents()){
				if(!c.equals(refreshSQL) && !c.equals(showView))
					c.setEnabled(true);
				else
					if(_viewBox.getSelectedIndex()!=0)
						c.setEnabled(true);
			}
		}
	}

}
