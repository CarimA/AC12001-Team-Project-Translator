import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class BrowseWindow extends Composite {
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BrowseWindow(Composite parent, int style) {
		super(parent, style);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 10, 237, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 37, 75, 25);
		btnNewButton.setText("Browse...");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(172, 37, 75, 25);
		btnNewButton_1.setText("Cancel");
		
		Button btnTranslate = new Button(this, SWT.NONE);
		btnTranslate.setBounds(91, 37, 75, 25);
		btnTranslate.setText("Translate");

	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
