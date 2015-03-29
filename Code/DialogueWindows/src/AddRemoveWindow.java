import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


public class AddRemoveWindow extends Shell {
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			AddRemoveWindow shell = new AddRemoveWindow(display);
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
	public AddRemoveWindow(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setBounds(215, 37, 75, 25);
		btnCancel.setText("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 10, 280, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 37, 75, 25);
		btnNewButton.setText("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//<InsertMethodHere>				
			}
		});
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(114, 37, 75, 25);
		btnNewButton_1.setText("Remove");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		setSize(315, 110);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
