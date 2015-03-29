import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


public class DictionaryShell extends Shell {
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			DictionaryShell shell = new DictionaryShell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DictionaryShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(null);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 70, 200, 140);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(240, 70, 200, 140);
		
		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(0, 0, 450, 35);
		
		ToolItem tltmFile = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmFile.setText("File");
		tltmFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//InsertMethodHere
			}
		});
		
		ToolItem tltmHelp = new ToolItem(toolBar, SWT.NONE);
		tltmHelp.setText("Help");
		tltmHelp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//InsertMethodHere
			}
		});
		
		ToolItem tltmExit = new ToolItem(toolBar, SWT.NONE);
		tltmExit.setText("Exit");
		tltmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//InsertMethodHere
			}
		});
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(10, 41, 200, 23);
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(240, 41, 200, 23);
		combo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setToolTipText("Translates left text to right text");
		btnNewButton.setBounds(188, 217, 75, 25);
		btnNewButton.setText("Translate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		createContents();

	}
	
	protected void createContents() {
		setText("CEC Translator");
		setSize(465, 285);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
}
