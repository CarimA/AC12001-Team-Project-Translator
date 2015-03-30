import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


public class WindowDictionary extends Shell {
	private Text txtLeft;
	private Text txtRight;

	public WindowDictionary(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setLayout(null);
		
		txtLeft = new Text(this, SWT.BORDER);
		txtLeft.setBounds(10, 41, 224, 140);
		
		txtRight = new Text(this, SWT.BORDER);
		txtRight.setBounds(390, 41, 224, 140);
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(10, 12, 224, 23);
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(390, 12, 224, 23);
		combo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Translates left text to right text");
		btnNewButton.setBounds(240, 156, 144, 25);
		btnNewButton.setText("Translate Right to Left");
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WordDictionary t = new WordDictionary(false);
		        Trie trie = t.createTrie("english");
		        
		        txtRight.setText(trie.translate(txtLeft.getText(), "english", "french"));
			}
		});
		button.setToolTipText("Translates left text to right text");
		button.setText("Translate Left to Right");
		button.setBounds(240, 125, 144, 25);
		
		Button btnClearLeft = new Button(this, SWT.NONE);
		btnClearLeft.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtLeft.setText("");
			}
		});
		btnClearLeft.setToolTipText("Translates left text to right text");
		btnClearLeft.setText("Clear Left");
		btnClearLeft.setBounds(10, 187, 144, 25);
		
		Button btnClearRight = new Button(this, SWT.NONE);
		btnClearRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtRight.setText("");
			}
		});
		btnClearRight.setToolTipText("Translates left text to right text");
		btnClearRight.setText("Clear Right");
		btnClearRight.setBounds(470, 187, 144, 25);
		
		Button btnAddWord = new Button(this, SWT.NONE);
		btnAddWord.setToolTipText("Translates left text to right text");
		btnAddWord.setText("Add Word");
		btnAddWord.setBounds(10, 218, 66, 25);
		
		Button btnRemoveWord = new Button(this, SWT.NONE);
		btnRemoveWord.setToolTipText("Translates left text to right text");
		btnRemoveWord.setText("Remove Word");
		btnRemoveWord.setBounds(82, 218, 87, 25);
		
		Button btnDisplayDictionary = new Button(this, SWT.NONE);
		btnDisplayDictionary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnDisplayDictionary.setToolTipText("Translates left text to right text");
		btnDisplayDictionary.setText("Display Dictionary");
		btnDisplayDictionary.setBounds(507, 218, 107, 25);
		
		Button btnTranslateFromFile = new Button(this, SWT.NONE);
		btnTranslateFromFile.setToolTipText("Translates left text to right text");
		btnTranslateFromFile.setText("Translate From File");
		btnTranslateFromFile.setBounds(240, 10, 144, 25);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		createContents();
		
		try {
			this.open();
			this.layout();
			while (!this.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void createContents() {
		setText("CEC Translator");
		setSize(640, 280);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
}