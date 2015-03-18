import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Combo;


public class dictionarycomposite extends Composite {
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public dictionarycomposite(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 70, 200, 140);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(240, 70, 200, 140);
		
		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(0, 0, 450, 35);
		
		ToolItem tltmTranslateFile = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmTranslateFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tltmTranslateFile.setText("File");
		
		ToolItem tltmHelp = new ToolItem(toolBar, SWT.NONE);
		tltmHelp.setText("Help");
		
		ToolItem tltmExit = new ToolItem(toolBar, SWT.NONE);
		tltmExit.setText("Exit");
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(10, 41, 200, 23);
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(240, 41, 200, 23);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setToolTipText("Translates left text to right text");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(188, 217, 75, 25);
		btnNewButton.setText("Translate");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
