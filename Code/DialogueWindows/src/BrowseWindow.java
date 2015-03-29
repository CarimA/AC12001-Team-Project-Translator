import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


public class BrowseWindow extends Shell {
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			BrowseWindow shell = new BrowseWindow(display);
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

	/**
	 * Create the shell.
	 * @param display
	 */
	public BrowseWindow(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 10, 237, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 37, 75, 25);
		btnNewButton.setText("Browse...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(172, 37, 75, 25);
		btnNewButton_1.setText("Cancel");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Button btnTranslate = new Button(this, SWT.NONE);
		btnTranslate.setBounds(91, 37, 75, 25);
		btnTranslate.setText("Translate");
		btnTranslate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(275, 110);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
